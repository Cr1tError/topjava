package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collections;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {
    public static final int USER_ID = START_SEQ;
    private static int counter = 0;

    public static final Meal meal1 = new Meal((START_SEQ +(++counter)),LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500);
    public static final Meal mealTest = new Meal(100007, LocalDateTime.of(2022, Month.JUNE, 22, 12, 10), "newMeal", 500 );
    public static Meal getNew() {
        return new Meal(null, LocalDateTime.now(),  "newMeal", 500);

    }
    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).usingRecursiveComparison().ignoringFields("dateTime").isEqualTo(expected);
    }

//    INSERT INTO meals (description, calories, datetime, user_id)
//    VALUES ('Завтрак', '500', '2020-01-30 10:00', '100000'),
//       ('Обед', '1000', '2020-01-30 13:00', '100000'),
//               ('Ужин', '500', '2020-01-30 20:00', '100000'),
//               ('Еда на граничное значение', '100', '2020-01-31 00:00', '100000'),
//               ('Завтрак', '1000', '2020-01-31 10:00', '100000'),
//               ('Обед', '500', '2020-01-31 13:00', '100000'),
//               ('Ужин', '410', '2020-01-31 20:00', '100000');
//          new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
//            new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
//            new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
//            new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
//            new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
//            new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
//            new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410)
}
