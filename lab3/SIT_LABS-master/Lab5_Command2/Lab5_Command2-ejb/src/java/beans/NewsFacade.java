/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.News;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sparksonet
 */
@Stateless
public class NewsFacade extends AbstractFacade<News> implements NewsFacadeLocal {

    @PersistenceContext(unitName = "Lab5_Command2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NewsFacade() {
        super(News.class);
    }

    public List<News> getTop10() {

        return em.createNativeQuery("SELECT * FROM News where (News.publishdate > date_add(curdate(), interval -1 month))"
                + " order by circulation desc limit 10", News.class).getResultList();

    }

    public List<News> getTopAuth() {
        return em.createNativeQuery("SELECT * FROM mydb.News where publishdate > date_add(curdate(), interval -4 month)"
                + "group by authorName order by circulation desc limit 5", News.class).getResultList();
    }

    @Override
    public List<News> getSellStatsByRegion() {
        return em.createNativeQuery("SELECT News.idNews, News.region, sum(News.circulation) as circulation FROM mydb.News \n"
                + "where (News.publishdate > date_add(curdate(), interval -1 year))\n"
                + "GROUP by region", News.class).getResultList();
    }

}
