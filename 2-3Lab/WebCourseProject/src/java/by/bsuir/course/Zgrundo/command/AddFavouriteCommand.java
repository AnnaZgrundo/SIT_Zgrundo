/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.Zgrundo.command;

import by.bsuir.course.Zgrundo.bean.Dish;
import by.bsuir.course.Zgrundo.bean.DishIngredient;
import by.bsuir.course.Zgrundo.bean.Favourite;
import by.bsuir.course.Zgrundo.bean.Ingredient;
import by.bsuir.course.Zgrundo.bean.User;
import by.bsuir.course.Zgrundo.dao.DishDAO;
import by.bsuir.course.Zgrundo.dao.DishIngredientDAO;
import by.bsuir.course.Zgrundo.dao.FavouriteDAO;
import by.bsuir.course.Zgrundo.dao.IngredientDAO;
import by.bsuir.course.Zgrundo.resource.Warnings;
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
public class AddFavouriteCommand implements Command {

    private Favourite fav;
    private FavouriteDAO dao;
    static final Logger logger = Logger.getLogger("FavouriteDAO");

    public AddFavouriteCommand() {
        fav = new Favourite();
        fav.setDish(new Dish());
        dao = new FavouriteDAO();
    }

    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        String message = null;
        int idDish = Integer.valueOf(request.getParameter("dishID"));
        fav.getDish().setIdDish(idDish);
        fav.setIdUser(Integer.valueOf(request.getParameter("userID")));

        int i = dao.create(fav);
        if (i == -1) {
            message = new Warnings().getValue(Warnings.FAV_EXIST);
            request.setAttribute("error", message);
            request.setAttribute("dish", new DishDAO().readByID(idDish));
            DishIngredientDAO daoDishIngr = new DishIngredientDAO();
            ArrayList<DishIngredient> listDishIngr = daoDishIngr.readByDish(idDish);
            ArrayList<Ingredient> listIngr = new ArrayList<>();
            ArrayList<Integer> listW = new ArrayList<>();
            for (int j = 0, idIngr = 0, w = 0; j < listDishIngr.size(); j++) {
                idIngr = listDishIngr.get(j).getIdIngredient();
                w = listDishIngr.get(j).getWeight();
                listIngr.add(new IngredientDAO().readByID(idIngr));
                listW.add(w);
            }
            request.setAttribute("listIngr", listIngr);
            request.setAttribute("listW", listW);
            page = "/one_dish.jsp";
        } else if (i != 0) {
            User user = (User) request.getSession().getAttribute("user");
            ArrayList<Favourite> list = dao.readByUser(user.getIdUser());
            request.setAttribute("favList", list);
            int n_slides = list.size() / 4;
            if (n_slides*4 < list.size()) {
                n_slides++;
            }
            request.setAttribute("n_slides", n_slides);
            page = "/favourite.jsp";
        } else {
            page = "/one_dish.jsp";
        }
        return page;
    }

}
