/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.Zgrundo.command;

import by.bsuir.course.Zgrundo.bean.Dish;
import by.bsuir.course.Zgrundo.dao.DishDAO;
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
public class ShowDishesCommand implements Command {

    private DishDAO dao;
    private ArrayList<Dish> list;
    static final Logger logger = Logger.getLogger("DishDAO");

    public ShowDishesCommand() {
        dao = new DishDAO();
        list = null;
    }
    
    

    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        int idType = 0;
        if (request.getParameter("type")!=null) {
            idType = Integer.valueOf(request.getParameter("type"));
        }
        if (idType == 0) {
            list = dao.readAll();
            logger.info(list.toString());
            request.setAttribute("dishList", list);
        } else {
            list = dao.readByType(idType);
            logger.info(list.toString());
            request.setAttribute("dishList", list);
        }
        page = String.valueOf(new ResourcesBundle(ResourcesBundle.pageProperties).getValue(ResourcesBundle.DISH_PAGE_PATH));
        return page;

    }
}
