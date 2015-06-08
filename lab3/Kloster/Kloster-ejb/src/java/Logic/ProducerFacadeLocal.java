/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import by.lab5.bean.Producer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Игорь
 */
@Local
public interface ProducerFacadeLocal {

    void create(Producer producer);

    void edit(Producer producer);

    void remove(Producer producer);

    Producer find(Object id);

    List<Producer> findAll();

    List<Producer> findRange(int[] range);

    int count();
    
}
