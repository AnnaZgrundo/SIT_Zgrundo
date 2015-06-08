/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.Zgrundo.command;

import by.bsuir.course.Zgrundo.bean.Favourite;
import by.bsuir.course.Zgrundo.bean.User;
import by.bsuir.course.Zgrundo.dao.FavouriteDAO;
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
public class ShowFavouriteCommand implements Command {

    private User user;
    private FavouriteDAO dao;
    private ArrayList<Favourite> list;
    static final Logger logger = Logger.getLogger("FavouriteDAO");

    /**
     * Constructor without parameters
     */
    public ShowFavouriteCommand() {
        user = null;
        dao = new FavouriteDAO();
        list = null;
    }

    /**
     * This method is used to show information about bill
     *
     * @param request - request
     * @param response - response
     * @return page which would be made the transition
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            list = dao.readByUser(user.getIdUser());
            for (int i = 0; i < list.size(); i++) {
                logger.info(i + ". " + list.get(i).getDish().getName());
            }
            request.setAttribute("favList", list);
            int n_slides = list.size() / 4;
            if (n_slides*4 < list.size()) {
                n_slides++;
            }
            request.setAttribute("n_slides", n_slides);
        }
        page = String.valueOf(new ResourcesBundle(ResourcesBundle.pageProperties).getValue(ResourcesBundle.FAVOURITE_PAGE_PATH));

        return page;

    }

}
