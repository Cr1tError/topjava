DROP TABLE IF EXISTS meals;
DROP SEQUENCE IF EXISTS meal_global_seq;

CREATE SEQUENCE meal_global_seq START WITH 100000;

CREATE TABLE meals
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    description VARCHAR                                  NOT NULL,
    calories    INTEGER                                  NOT NULL,
    dateTime    TIMESTAMP                         UNIQUE NOT NULL,
    user_id     INTEGER REFERENCES users(id)
)
