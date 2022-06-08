package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;
import java.util.Map;

public interface DAO {


  Map<Integer, Meal> getMeals();

    void addMeal(Meal meal);

  int getCalories();
  void deleteMeal(int id);
}
