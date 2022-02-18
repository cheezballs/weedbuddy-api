create table wb_user (
    id              int not null auto_increment primary key,
    idp_identifier  varchar(250),
    first_name      varchar(100) not null,
    last_name       varchar(100) not null,
    username        varchar(25) not null,
    email           varchar(250),
    avatar_url      varchar(1000),
    date_created    datetime not null
);

create table dispensary (
    id              int not null auto_increment pimary key,
    name            varchar(100) not null,
    address         varchar(250),
    city            varchar(250),
    state           char(2),
    gps_coordinates point
);

create table brand (
    id              int not null auto_increment primary key,
    name            varchar(100) not null
);

create table media_image (
    id              int not null auto_increment primary key,
    size            int not null,
    filename        varchar(250) not null,
    parent          int not null,
    parent_type     char(2) not null,
    user_created    int not null,
    date_created    datetime not null,
    foreign key (user_created) references (wb_user.id)
);

create table strain (
    id              int not null auto_increment primary key,
    name            varchar(250) not null,
    description     text,
    flower_type     char(2) not null,
    user_created    int not null,
    date_created    datetime not null,
    foreign key (user_created) references (wb_user.id)
);

create table terpene (
    id              int not null auto_increment primary key,
    name            varchar(50) not null,
    description     text
);

create table terpene_effect (
    terpene         int not null,
    effect          char(2) not null,
    foreign key (terpene) references (terpene.id)
);

create table strain_terpene (
    strain          int not null,
    terpene         int not null,
    order_index     int not null,
    foreign key (strain) references (strain.id),
    foreign key (terpene) references (terpene.id)
);

create table purchase (
    id              int not null auto_increment primary key,
    dispensary      int not null,
    purchase_date   date,
    user_created    int not null,
    date_created    datetime not null,
    foreign key (dispensary) references (dispensary.id),
    foreign key (user_created) references (wb_user.id)
)

create table purchase_item (
    id              int not null auto_increment primary key,
    item_type       char(2) not null,
    price           int,
    thc_value       int,
    cbd_value       int,
    size            char(2) not null,
    brand           int not null,
    foreign key (brand) references (brand.id),
)

