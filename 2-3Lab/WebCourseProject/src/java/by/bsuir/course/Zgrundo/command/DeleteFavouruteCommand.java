/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.Zgrundo.command;

import by.bsuir.course.Zgrundo.bean.Favourite;
import by.bsuir.course.Zgrundo.bean.User;
import by.bsuir.course.Zgrundo.dao.FavouriteDAO;
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
public class DeleteFavouruteCommand implements Command {

    private User user;
    private FavouriteDAO dao;
    static final Logger logger = Logger.getLogger("FavouriteDAO");

    public DeleteFavouruteCommand() {
        user = null;
        dao = new FavouriteDAO();
    }

    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;

        int id = Integer.valueOf(request.getParameter("id"));
        int i = dao.deleteByID(id);

        user = (User) request.getSession().getAttribute("user");
        ArrayList<Favourite> list = dao.readByUser(user.getIdUser());
        request.setAttribute("favList", list);
        int n_slides = list.size() / 4;
        if (n_slides * 4 < list.size()) {
            n_slides++;
        }
        request.setAttribute("n_slides", n_slides);
        page = "/favourite.jsp";

        return page;
    }

}
