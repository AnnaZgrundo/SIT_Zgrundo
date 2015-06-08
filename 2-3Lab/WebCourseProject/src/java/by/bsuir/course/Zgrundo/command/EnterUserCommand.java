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
public class EnterUserCommand implements Command {

    private User user;
    private UserDAO dao;
    static final Logger logger = Logger.getLogger("UserDAO");

    public EnterUserCommand() {
        user = new User();
        dao = new UserDAO();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        String message = null;
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        
        User daoUser = null;
        daoUser = dao.readByLogin(user.getLogin());
        if (daoUser == null) {
            message = new Warnings().getValue(Warnings.WRONG_LOGIN);
            request.setAttribute("userError", message);
            page = "/index.jsp";
        } else {
            if (daoUser.getPassword().equals(user.getPassword())) {
                request.getSession().setAttribute("user", daoUser);
                if (daoUser.getAdmin() == 1) {
                    page = "/index.jsp";
                }
                if (daoUser.getAdmin() == 0) {
                    page = "/index.jsp";
                }
            } else {
                message = new Warnings().getValue(Warnings.WRONG_PASSWORD);
                request.setAttribute("userError", message);
                page = "/index.jsp";
            }
        }
        return page;

    }
}
