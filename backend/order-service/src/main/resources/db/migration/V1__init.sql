create table orders (
                        order_no varchar(255) not null,
                        description varchar(255),
                        name varchar(255),
                        status varchar(255),
                        total_price float(53) not null,
                        primary key (order_no)
);