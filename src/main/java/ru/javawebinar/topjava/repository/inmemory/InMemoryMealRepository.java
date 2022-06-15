package ru.javawebinar.topjava.repository.inmemory;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InMemoryMealRepository implements MealRepository {
    private final Map<Integer, Map<Integer, Meal>> repository = new ConcurrentHashMap<>();
    private final Map<Integer, Meal> allMeal = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    {
        for (Meal meal : MealsUtil.meals) {
            save(meal, 1);
        }
    }

    @Override
    public Meal save(Meal meal, int userId) {
        if (meal.isNew()) {
            meal.setUserId(userId);
            meal.setId(counter.incrementAndGet());
            Map<Integer, Meal> currentMeal = new ConcurrentHashMap<>();
            allMeal.put(meal.getId(), meal);
            currentMeal.put(meal.getId(), meal);
            repository.put(userId, currentMeal);
            return meal;
        }

        if (meal.getUserId() == userId) {
            if (repository.get(userId).containsKey(meal.getId())) {
                repository.get(userId).replace(meal.getId(), meal);
                allMeal.replace(meal.getId(), meal);
                return meal;
            }
        }
        return null;
    }

    @Override
    public boolean delete(int id, int userId) {
        if (allMeal.get(id).getUserId() == userId) {
            repository.get(userId).remove(id);
            return true;
        }
        return false;
    }


    @Override
    public Meal get(int id, int userId) {
        if (allMeal.get(id).getUserId() == userId) {
            return repository.get(userId).get(id);
        }
        return null;
    }

    @Override
    public List<Meal> getAll() {


        return allMeal.values().stream().sorted(new Comparator<Meal>() {
            @Override
            public int compare(Meal o1, Meal o2) {
                return o2.getDate().compareTo(o1.getDate());
            }
        }).collect(Collectors.toList());
    }

}





