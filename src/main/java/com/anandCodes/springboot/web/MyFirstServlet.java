package com.anandCodes.springboot.web;//package com.example.web;
//
////import com.example.context.Application;
//import com.example.context.MyTransactionsApplicationConfiguration;
//import com.example.model.Transactions;
//import com.example.service.TransactionService;
//import com.example.service.UserService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import java.io.IOException;
//import java.util.List;
//
//public class MyFirstServlet extends HttpServlet {
//
//    private UserService userService;
//    private TransactionService transactionService;
//    private ObjectMapper objectMapper;
//
//
//    @Override
//    public void init() throws ServletException{
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyTransactionsApplicationConfiguration.class);
//        this.userService = ctx.getBean(UserService.class);
//        this.transactionService = ctx.getBean(TransactionService.class);
//        this.objectMapper = ctx.getBean(ObjectMapper.class);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        if(request.getRequestURI().equalsIgnoreCase("/transactions")){
//            response.setContentType("application/json; charset=UTF-8");
//            List<Transactions> transactions = transactionService.findAll();
//            response.getWriter().print(objectMapper.writeValueAsString(transactions));
//        }else{
//            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
//        if(request.getRequestURI().equalsIgnoreCase("/transactions")){
//                Integer amount = Integer.valueOf(request.getParameter("amount"));
//                String userId = request.getParameter("userId");
//                Transactions transactions = transactionService.create(amount, userId);
//                response.setContentType("application/json; charset=UTF-8");
//                response.getWriter().print(objectMapper.writeValueAsString(transactions));
//        }else{
//            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//        }
//    }
//
//
//}
