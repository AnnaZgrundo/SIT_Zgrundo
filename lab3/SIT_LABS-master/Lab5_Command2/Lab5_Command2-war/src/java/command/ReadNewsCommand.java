/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import beans.NewsFacadeLocal;
import constants.Lookup;
import static constants.Pages.ERROR;
import static constants.Pages.ID;
import static constants.Pages.ID_THEME;
import static constants.Pages.LIST_NEWS;
import static constants.Pages.PAGE_ERROR;
import static constants.Pages.PAGE_READ_NEWS;
import entities.News;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sparksonet
 */
public class ReadNewsCommand implements ICommand {

    NewsFacadeLocal newsFacade;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            newsFacade = Lookup.lookupNewsFacadeLocal();
            List<News> list = this.newsFacade.findAll();

            request.setAttribute(LIST_NEWS, list);

            return PAGE_READ_NEWS;
        } catch (NamingException e) {
            Logger.getLogger(ReadNewsCommand.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute(ERROR, e.getMessage());
            return PAGE_ERROR;

        }
    }

}
