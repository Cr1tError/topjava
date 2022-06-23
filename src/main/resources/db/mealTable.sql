DROP TABLE IF EXISTS meals;
DROP SEQUENCE IF EXISTS meal_global_seq;

CREATE SEQUENCE meal_global_seq START WITH 100000;

CREATE TABLE meals
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('meal_global_seq'),
    description VARCHAR                                  NOT NULL,
    calories    INTEGER                                  NOT NULL,
    date_time   TIMESTAMP                         UNIQUE NOT NULL,
    user_id     INTEGER                                  NOT NULL,
    FOREIGN KEY (user_id) REFERENCES  users (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX meals_unique_user_datetime_idx ON meals (user_id, date_time)
