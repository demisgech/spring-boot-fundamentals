create table products (
    id bigint auto_increment,
    name varchar(255) not null,
    price decimal(10, 2) default 0,
    category_id tinyint not null,
    constraint products_pk primary key (id),
    constraint products_categories_fk foreign key (category_id) references categories(id) on delete restrict
);