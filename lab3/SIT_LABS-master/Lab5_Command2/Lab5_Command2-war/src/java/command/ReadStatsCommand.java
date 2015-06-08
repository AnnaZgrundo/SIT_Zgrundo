/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import beans.NewViewFacade;
import beans.NewViewFacadeLocal;
import beans.NewsFacadeLocal;
import constants.Lookup;
import static constants.Pages.ERROR;
import static constants.Pages.LIST_STATS;
import static constants.Pages.PAGE_ERROR;
import static constants.Pages.PAGE_STATS;
import static constants.Pages.PAGE_TOP_NEWS;
import static constants.Pages.TOPAUTH;
import static constants.Pages.TOPNEWS;
import entities.NewView;
import entities.News;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ivan Bachilo
 */
public class ReadStatsCommand implements ICommand {

    NewViewFacadeLocal newsFacade;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            newsFacade = Lookup.lookupNewViewFacadeLocal();

            List<NewView> list = this.newsFacade.findAll();

            request.setAttribute(LIST_STATS, list);

            return PAGE_STATS;
        } catch (NamingException e) {
            Logger.getLogger(ReadNewsCommand.class.getName()).log(Level.SEVERE, null, e);
             request.setAttribute(ERROR, e.getMessage());
            return PAGE_ERROR;

        }

    }

}
