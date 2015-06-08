/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.Zgrundo.command;

import by.bsuir.course.Zgrundo.bean.User;
import by.bsuir.course.Zgrundo.dao.UserDAO;
import by.bsuir.course.Zgrundo.resource.Warnings;
import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ko
 */
public class EditUserCommand implements Command {

    private User user;
    private UserDAO dao;
    static final Logger logger = Logger.getLogger("UserDAO");

    public EditUserCommand() {
        user = new User();
        dao = new UserDAO();
    }

    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        String message = null;
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        user.setName(request.getParameter("name"));
        user.setAdmin(0);
        if (request.getParameter("password").equals(request.getParameter("password2"))) {
            int i = dao.update(user);
            if (i != 0) {
                user = dao.readByLogin(user.getLogin());
                request.getSession().setAttribute("user", user);
                page = "/index.jsp";
            } else {
                message = new Warnings().getValue(Warnings.TRY_AGAIN);
                request.setAttribute("error", message);
                request.setAttribute("typeCabinet", 1);
                page = "/cabinet.jsp";
            }
            return page;
        } else {
            message = new Warnings().getValue(Warnings.ERROR_PASS);
            request.setAttribute("error", message);
            request.setAttribute("user", user);
            request.setAttribute("typeCabinet", 1);
            return page = "/cabinet.jsp";
        }
    }
}
