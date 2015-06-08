/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import by.lab5.bean.Award;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Игорь
 */
@Stateless
public class AwardFacade extends AbstractFacade<Award> implements AwardFacadeLocal {
    @PersistenceContext(unitName = "Kloster-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AwardFacade() {
        super(Award.class);
    }
    
}
