/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import static constants.Pages.DEFAULT_METHOD;
import static constants.Pages.METHOD;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Sparksonet
 */
public class CommandFactory {

    public static ICommand buildCommand(HttpServletRequest request) {
        String strMethod = request.getParameter(METHOD);
        ECommand method = null;
        if (strMethod != null) {
            method = ECommand.valueOf(strMethod.toUpperCase());
        } else {
            method = ECommand.valueOf(DEFAULT_METHOD.toUpperCase());
        }
        ICommand command = null;
        switch (method) {

            case READ_NEWS:
                command = new ReadNewsCommand();
                break;
            case READ_AJAX:
                command = new ReadAjaxCommand();
                break;
            case READ_PERSON: //fix bug git
                command = new ReadAjaxCommand();
                break;
            case ADD_NEWS:
                command = new AddNewsCommand();
                break;
                
                case ADD_AJAX:
                command = new AddNewsCommand();
                break;
            case DELETE_NEWS:
                command = new DeleteNewsCommand();
                break;
                
                case DELETE_AJAX:
                command = new DeleteNewsCommand();
                break;
            case READ_TOP_NEWS:
                command = new Top10NewsCommand();
                break;
            case READ_STATS:
                command = new ReadStatsCommand();
                break;
        }
        return command;
    }
}
