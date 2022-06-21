DELETE FROM meals;
ALTER SEQUENCE meal_global_seq RESTART WITH 100000;

INSERT INTO meals (description, calories, datetime, user_id)
VALUES ('Завтрак', '500', '2020-01-30 10:00', '100000'),
       ('Обед', '1000', '2020-01-30 13:00', '100000'),
       ('Ужин', '500', '2020-01-30 20:00', '100000'),
       ('Еда на граничное значение', '100', '2020-01-31 00:00', '100000'),
       ('Завтрак', '1000', '2020-01-31 10:00', '100000'),
       ('Обед', '500', '2020-01-31 13:00', '100000'),
       ('Ужин', '410', '2020-01-31 20:00', '100000');

