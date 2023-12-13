package com.anandCodes.springboot.service;

import com.anandCodes.springboot.model.Transactions;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class TransactionService {

    UserService userService;
    JdbcTemplate jdbcTemplate;
    public TransactionService(UserService userService, JdbcTemplate jdbcTemplate){
        this.userService = userService;
        this.jdbcTemplate = jdbcTemplate;
    }


    List<Transactions> transactions = new CopyOnWriteArrayList<>();

    public List<Transactions> findAll(){

        return jdbcTemplate.query("select id, user_id, refrence, amount, time_stamp from transactions", (resultSet, rowNum)->{
            Transactions transactions1 = new Transactions();
            transactions1.setId(resultSet.getObject("id").toString());
            transactions1.setReference(resultSet.getString("refrence"));
            transactions1.setAmount(resultSet.getInt("amount"));
            transactions1.setUserId(resultSet.getString("user_id"));
            transactions1.setTimeStamp(resultSet.getString("time_stamp"));
            return transactions1;
        });
    }

    @Transactional
    public Transactions create(Integer amount, String userId){
        System.out.println("Is a database transaction open? = " + TransactionSynchronizationManager.isActualTransactionActive());
        String refrence = "eating at mcDonalds";
        String timeStamp = LocalDateTime.now().toString();
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement("insert into transactions (user_id, refrence, amount, time_stamp) values (?, ?, ?, ?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, userId);  //
            ps.setString(2, refrence);
            ps.setInt(3, amount);
            ps.setString(4, timeStamp);
            return ps;
        }, keyHolder);

        String uuid = !keyHolder.getKeys().isEmpty() ? keyHolder.getKeys().values().iterator().next().toString()
                : null;

        Transactions transactions1 = new Transactions();
        transactions1.setUserId(userId);
        transactions1.setReference(refrence);
        transactions1.setId(uuid);
        transactions1.setAmount(amount);
        transactions1.setTimeStamp(timeStamp);
        return transactions1;
    }
}
