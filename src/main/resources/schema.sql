create table if not exists transactions
(
    id      uuid  default random_uuid() primary key,
    refrence varchar(255),
    user_id varchar(255),
    time_stamp varchar(255),
    amount  int
);