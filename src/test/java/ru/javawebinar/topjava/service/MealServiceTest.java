package ru.javawebinar.topjava.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.MealTestData;

import ru.javawebinar.topjava.model.Meal;


import java.util.List;


import static ru.javawebinar.topjava.MealTestData.*;


@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populate_meals.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceTest {


    static {
        // Only for postgres driver logging
        // It uses java.util.logging and logged via jul-to-slf4j bridge
        SLF4JBridgeHandler.install();
    }

    @Autowired
    private MealService mealService;

    @Test
    public void create() {
        Meal created = mealService.create(getNew(), 100001);
        Integer newId = created.getId();
        Meal newMeal = getNew();
        newMeal.setId(newId);
        assertMatch(created, newMeal);
        MealTestData.assertMatch(mealService.get(newId, 1000001), newMeal);
    }

    @Test
    public void getAll() {
        Meal meal = mealService.getAll(1000001).stream().findAny().orElse(null);
        MealTestData.assertMatch(meal,  mealTest);
    }
}