/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import beans.AuthorFacadeLocal;
import beans.NewsFacadeLocal;
import constants.Lookup;
import static constants.Pages.ERROR;
import static constants.Pages.LIST_NEWS;
import static constants.Pages.PAGE_ERROR;
import static constants.Pages.PAGE_READ_NEWS;
import entities.Author;
import entities.News;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sparksonet
 */
public class AddNewsCommand implements ICommand {

    NewsFacadeLocal newsFacade;
    AuthorFacadeLocal authorFacade;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            News news = new News();
            Author author = new Author();
            author.setAuthorName(request.getParameter("authorName"));
            authorFacade = Lookup.lookupAuthorFacadeLocal();
            if (!authorFacade.isAuthorExist(author)) {
                authorFacade.create(author);
            }
            news.setAuthorName(author);
            news.setName(request.getParameter("name"));
            Date date = new Date();
            //correct dat shit if your locale data format differs. dd.MM.yyyy
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            date = format.parse(request.getParameter("publishDate"));
            news.setPublishdate(date);
            news.setCirculation(Integer.parseInt(request.getParameter("circulation")));
            news.setRegion(request.getParameter("region"));
            newsFacade = Lookup.lookupNewsFacadeLocal();
            newsFacade.create(news);
            request.setAttribute(LIST_NEWS, newsFacade.findAll());
            return PAGE_READ_NEWS;
        } catch (NamingException ex) {
            Logger.getLogger(AddNewsCommand.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute(ERROR, ex.getMessage());
            return PAGE_ERROR;
        } catch (ParseException ex) {
            Logger.getLogger(AddNewsCommand.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute(ERROR, ex.getMessage());
            return PAGE_ERROR;
        }
    }

}
