/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import by.lab5.bean.Movie;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Игорь
 */
@Local
public interface MovieFacadeLocal {

    void create(Movie movie);

    void edit(Movie movie);

    void remove(Movie movie);

    Movie find(Object id);

    List<Movie> findAll();

    List<Movie> findRange(int[] range);

    int count();
    
}
