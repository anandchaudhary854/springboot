create table if not exists transactions
(
    ID uuid default random_uuid() primary key,
    REFERENCE varchar(255),
    USER_ID varchar(255),
    TIME_STAMP varchar(255),
    AMOUNT int
);