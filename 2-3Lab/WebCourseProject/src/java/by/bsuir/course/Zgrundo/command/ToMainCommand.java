/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.Zgrundo.command;

import by.bsuir.course.Zgrundo.resource.ResourcesBundle;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ko
 */
public class ToMainCommand implements Command {

    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        page = String.valueOf(new ResourcesBundle(ResourcesBundle.pageProperties).getValue(ResourcesBundle.INDEX_PAGE_PATH));
        return page;

    }

}
