  CREATE TABLE User (
    id bigserial not null,
    name varchar (50);
    password TEXT,
    primary key (id)
  )

  CREATE TABLE Movie (
    id bigserial not null,
    name varchar (50),
    genre varchar (50),
    primary key (id)
  )

  CREATE TABLE Actor (
    id bigserial not null,
    name varchar (50),
    primary key (id),
  )

  CREATE TABLE Location (
    id bigserial not null,
    name varchar (50),
    primary key (id)
  )

  CREATE TABLE Timeslot (
    id bigserial not null,
    name DATE,
    maxpax int,
    primary key (id)
  )

  CREATE TABLE Walkingtour (
    id bigserial not null,
    price int,
    discription varchar (200)
  )