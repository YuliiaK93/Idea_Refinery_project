create table task(
    id int auto_increment,
    title varchar(255) NOT NULL,
    description varchar(255) NOT NULL,
    completed boolean DEFAULT FALSE,
    created_date date,
    completed_date date
);