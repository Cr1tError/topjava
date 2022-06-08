package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MealDAO implements DAO {

    private AtomicInteger count = new AtomicInteger(0);
    private final static int CALORIES_PER_DAY = 2000;

    private static Map<Integer, Meal> meals = new ConcurrentHashMap<>();

    public MealDAO() {
        meals.put((count.incrementAndGet()),(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500)));
        meals.put((count.incrementAndGet()),(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000)));
        meals.put((count.incrementAndGet()),(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500)));
        meals.put((count.incrementAndGet()),(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Перекус", 100)));
        meals.put((count.incrementAndGet()),(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000)));
        meals.put((count.incrementAndGet()),(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500)));
        meals.put((count.incrementAndGet()),(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410)));

    }



    @Override
    public void addMeal(Meal meal) {
        meals.put(count.incrementAndGet(), meal);
    }

    @Override
    public Map<Integer, Meal> getMeals() {
        return meals;
    }
    @Override
    public  int getCalories() {
        return CALORIES_PER_DAY;
    }

    @Override
    public void deleteMeal(int id) {
        meals.remove(id);
    }
}
