DROP TABLE IF EXISTS todos;
DROP SEQUENCE IF EXISTS global_seq;


CREATE SEQUENCE GLOBAL_SEQ
  AS INTEGER
    START WITH 100000;

CREATE TABLE todos
(
  id          INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
  description VARCHAR(38) NOT NULL,
  start_date  TIMESTAMP DEFAULT now(),
  end_date    TIMESTAMP DEFAULT now()
);

INSERT INTO todos (description, start_date, end_date) VALUES
  ('first toDo', '2017-05-10 9:00:00', '2017-05-26 18:00:00'),
  ('second toDo', '2017-05-20 14:00:00', '2017-05-26 18:00:00'),
  ('third toDo', '2017-05-23 10:00:00', '2017-05-26 18:00:00'),
  ('test quest', '2017-05-22 10:00:00', '2017-05-26 18:00:00');

INSERT INTO todos (description) VALUES
  ('start toDo');