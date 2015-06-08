/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.News;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sparksonet
 */
@Local
public interface NewsFacadeLocal {

    void create(News news);

    void edit(News news);

    void remove(News news);

    News find(Object id);

    List<News> findAll();

    List<News> getTop10();

    List<News> getTopAuth();

    List<News> findRange(int[] range);

    int count();

    public List<News> getSellStatsByRegion();

}
