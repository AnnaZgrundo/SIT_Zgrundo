/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constants;

import beans.AuthorFacadeLocal;
import beans.NewViewFacadeLocal;
import beans.NewsFacadeLocal;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Ivan Bachilo
 */
public class Lookup {

    public static AuthorFacadeLocal lookupAuthorFacadeLocal() throws NamingException {

        Context context = new InitialContext();
        return (AuthorFacadeLocal) context.lookup("java:global/Lab5_Command2/Lab5_Command2-ejb/AuthorFacade!beans.AuthorFacadeLocal");

    }

    public static NewsFacadeLocal lookupNewsFacadeLocal() throws NamingException {

        Context c = new InitialContext();
        return (NewsFacadeLocal) c.lookup("java:global/Lab5_Command2/Lab5_Command2-ejb/NewsFacade!beans.NewsFacadeLocal");

    }
    
    public static NewViewFacadeLocal lookupNewViewFacadeLocal() throws NamingException {

        Context c = new InitialContext();
        return (NewViewFacadeLocal) c.lookup("java:global/Lab5_Command2/Lab5_Command2-ejb/NewViewFacade!beans.NewViewFacadeLocal");

    }

}
