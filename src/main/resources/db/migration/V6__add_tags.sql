create table tags (
    id bigint auto_increment primary key,
    name varchar(255) not null
);

-- Join tables
create table user_tags (
    tag_id bigint not null,
    user_id bigint not null,
    primary key(user_id, tag_id),
    constraint user_tags_users_id_fk foreign key (user_id) references users (id) on delete cascade,
    constraint user_tags_tags_id_fk foreign key (tag_id) references tags (id) on delete cascade
);