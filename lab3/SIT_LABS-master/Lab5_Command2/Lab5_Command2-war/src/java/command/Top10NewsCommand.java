/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import beans.NewsFacadeLocal;
import constants.Lookup;
import static constants.Pages.ERROR;
import static constants.Pages.LIST_NEWS;
import static constants.Pages.PAGE_ERROR;
import static constants.Pages.PAGE_READ_NEWS;
import static constants.Pages.PAGE_TOP_NEWS;
import static constants.Pages.TOPAUTH;
import static constants.Pages.TOPNEWS;
import entities.News;
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
public class Top10NewsCommand implements ICommand {

    NewsFacadeLocal newsFacade;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            newsFacade = Lookup.lookupNewsFacadeLocal();
            List<News> list = this.newsFacade.getTop10();
            List<News> list2 = this.newsFacade.getTopAuth();

            request.setAttribute(TOPNEWS, list);
            request.setAttribute(TOPAUTH, list2);

            return PAGE_TOP_NEWS;
        } catch (NamingException e) {
            Logger.getLogger(ReadNewsCommand.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute(ERROR, e.getMessage());
            return PAGE_ERROR;

        }
    }
}
