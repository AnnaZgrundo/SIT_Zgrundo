/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.Zgrundo.command;

import by.bsuir.course.Zgrundo.bean.Dish;
import by.bsuir.course.Zgrundo.bean.DishIngredient;
import by.bsuir.course.Zgrundo.bean.Ingredient;
import by.bsuir.course.Zgrundo.dao.DishDAO;
import by.bsuir.course.Zgrundo.dao.DishIngredientDAO;
import by.bsuir.course.Zgrundo.dao.IngredientDAO;
import by.bsuir.course.Zgrundo.resource.ResourcesBundle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ko
 */
public class ShowOneDishCommand implements Command {

    private Dish dish;
    private DishDAO daoDish;
    private IngredientDAO daoIngr;
    private DishIngredientDAO daoDishIngr;
    private ArrayList<Ingredient> listIngr;
    private ArrayList<DishIngredient> listDishIngr;
    static final Logger logger = Logger.getLogger("DishDAO");
    
    
    public ShowOneDishCommand() {
        dish = null;
        listIngr = null;
        listDishIngr = null;
        daoDish = new DishDAO();
        daoIngr = new IngredientDAO();
        daoDishIngr = new DishIngredientDAO();
    }
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        int idDish = Integer.valueOf(request.getParameter("dishID"));
        dish = daoDish.readByID(idDish);
        request.setAttribute("dish", dish);
        logger.info(dish.toString());
        listDishIngr = daoDishIngr.readByDish(idDish);
        listIngr = new ArrayList<>();
        ArrayList<Integer> listW = new ArrayList<>();
        for (int i=0, idIngr=0, w=0; i<listDishIngr.size(); i++) {
            idIngr = listDishIngr.get(i).getIdIngredient();
            w = listDishIngr.get(i).getWeight();
            listIngr.add(daoIngr.readByID(idIngr));
            listW.add(w);
        }
        request.setAttribute("listIngr", listIngr);
        request.setAttribute("listW", listW);
        page = String.valueOf(new ResourcesBundle(ResourcesBundle.pageProperties).getValue(ResourcesBundle.ONE_DISH_PAGE_PATH));
        
        return page;

    }

}
