/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.NewView;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sparksonet
 */
@Local
public interface NewViewFacadeLocal {

    void create(NewView newView);

    void edit(NewView newView);

    void remove(NewView newView);

    NewView find(Object id);

    List<NewView> findAll();

    List<NewView> findRange(int[] range);

    int count();
    
}
