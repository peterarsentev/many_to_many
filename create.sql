create table users (
  id serial primary key,
  name text
);

create table roles (
  id serial primary key,
  name text
);

create table user_role (
  id serial primary key,
  user_id int not null references users(id),
  role_id int not null references roles(id)
);