/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import beans.AuthorFacadeLocal;
import beans.NewsFacadeLocal;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import constants.Lookup;
import static constants.Pages.ERROR;
import static constants.Pages.LIST_NEWS;
import static constants.Pages.NOT_USED;
import static constants.Pages.PAGE_ERROR;
import static constants.Pages.PAGE_READ_AJAX;
import static constants.Pages.PAGE_READ_NEWS;
import entities.Author;
import entities.News;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class ReadAjaxCommand implements ICommand{
    
    NewsFacadeLocal newsFacade;
   
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
             newsFacade = Lookup.lookupNewsFacadeLocal();
                 
            List<News> news;
            news = this.newsFacade.findAll();
            
                 
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
          
            JsonElement element = gson.toJsonTree(news, new TypeToken<List<News>>() {
            }.getType());
            
            JsonArray jsonArray = element.getAsJsonArray();
         
            response.setContentType("application/json");
            response.getWriter().print(jsonArray);
            
            return NOT_USED;
        } catch (NamingException ex) {
            Logger.getLogger(AddNewsCommand.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute(ERROR, ex.getMessage());
            return NOT_USED;
        } catch (IOException ex) {
            Logger.getLogger(ReadAjaxCommand.class.getName()).log(Level.SEVERE, null, ex);
            return NOT_USED;
        }
    }
    
}
