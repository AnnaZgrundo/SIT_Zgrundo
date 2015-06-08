/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import by.lab5.bean.Producer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Игорь
 */
@Stateless
public class ProducerFacade extends AbstractFacade<Producer> implements ProducerFacadeLocal {
    @PersistenceContext(unitName = "Kloster-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProducerFacade() {
        super(Producer.class);
    }
    
}
