CREATE TABLE IF NOT EXISTS users
(
  id bigint NOT NULL,
  username character(30),
  firstname character(30),
  lastname character(30),
  email character(45),
  CONSTRAINT users_pkey PRIMARY KEY (id),
  CONSTRAINT users_email_key UNIQUE (email)
);