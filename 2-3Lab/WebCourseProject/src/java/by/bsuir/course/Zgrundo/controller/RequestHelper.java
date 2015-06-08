/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.Zgrundo.controller;

import by.bsuir.course.Zgrundo.command.AddFavouriteCommand;
import by.bsuir.course.Zgrundo.command.AddUserCommand;
import by.bsuir.course.Zgrundo.command.Command;
import by.bsuir.course.Zgrundo.command.DeleteFavouruteCommand;
import by.bsuir.course.Zgrundo.command.EditUserCommand;
import by.bsuir.course.Zgrundo.command.EnterUserCommand;
import by.bsuir.course.Zgrundo.command.ExitCommand;
import by.bsuir.course.Zgrundo.command.ShowDishesCommand;
import by.bsuir.course.Zgrundo.command.ShowFavouriteCommand;
import by.bsuir.course.Zgrundo.command.ShowOneDishCommand;
import by.bsuir.course.Zgrundo.command.ToCabinetCommand;
import by.bsuir.course.Zgrundo.command.ToInfoCommand;
import by.bsuir.course.Zgrundo.command.ToMainCommand;
import by.bsuir.course.Zgrundo.command.ToRegistrationCommand;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

/**
 * This class is used to help organize activities of servlet
 * @author ko
 */
public class RequestHelper {
    private static RequestHelper instance = null;
    HashMap<String, Command> commands = new HashMap<String, Command>();

    
    
    private RequestHelper() {
        commands.put("ToMain", new ToMainCommand());
        commands.put("ToRegistration", new ToRegistrationCommand());
        commands.put("ToCabinet", new ToCabinetCommand());
        commands.put("ToInfo", new ToInfoCommand());
        commands.put("EnterUser", new EnterUserCommand());
        commands.put("ExitUser", new ExitCommand());
        commands.put("AddUser", new AddUserCommand());
        commands.put("EditUser", new EditUserCommand());
        commands.put("AddFavourite", new AddFavouriteCommand());
        commands.put("ShowOneDish", new ShowOneDishCommand());
        commands.put("ShowDishes", new ShowDishesCommand());
        commands.put("ShowFavourite", new ShowFavouriteCommand());
        commands.put("DeleteFavourute", new DeleteFavouruteCommand());
    }
    
    /**
     * This method is used to get command
     * @param request - request
     * @return Command
     */
    public Command getCommand(HttpServletRequest request){
        Command  c = null;
        String action = request.getParameter("command");
        System.out.println(action);
        c = commands.get(action);
        return c;
    }
    
    /**
     * This method is used to create object of class RequestHelper
     * @return object of class RequestHelper
     */
    public static RequestHelper getInstance(){
        if(instance == null){
            instance = new RequestHelper();
        }
        return instance;
    }
    
}
