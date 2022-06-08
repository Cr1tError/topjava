package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.DAO;
import ru.javawebinar.topjava.dao.MealDAO;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

import java.util.List;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    DAO dao = new MealDAO();

    private static final Logger log = getLogger(UserServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("redirect to meals");
        String paramName = "action";
        String paramValue = req.getParameter(paramName);

        if(paramValue == null){
            Map<Integer, MealTo> meals = MealsUtil.filteredByCycles(dao.getMeals(), dao.getCalories());
            req.setAttribute("attr1", meals);

            req.getRequestDispatcher("meals.jsp").forward(req, resp);
        } else {
            String param2name = "id";
            String value2 = req.getParameter(param2name);

            dao.deleteMeal(Integer.parseInt(value2));
            Map<Integer, MealTo> meals = MealsUtil.filteredByCycles(dao.getMeals(), dao.getCalories());
            req.setAttribute("attr1", meals);

            req.getRequestDispatcher("meals.jsp").forward(req, resp);
        }





    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String description = req.getParameter("description");
        LocalDateTime localDateTime = LocalDateTime.parse(req.getParameter("date"));
        int calories = Integer.parseInt(req.getParameter("calories"));
        Meal meal = new Meal(localDateTime, description, calories);
        dao.addMeal(meal);
        doGet(req, resp);
    }
}
