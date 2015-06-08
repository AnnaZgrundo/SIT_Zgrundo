/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import by.lab5.bean.Award;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Игорь
 */
@Local
public interface AwardFacadeLocal {

    void create(Award award);

    void edit(Award award);

    void remove(Award award);

    Award find(Object id);

    List<Award> findAll();

    List<Award> findRange(int[] range);

    int count();
    
}
