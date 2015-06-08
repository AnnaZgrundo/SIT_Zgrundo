/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.NewView;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sparksonet
 */
@Stateless
public class NewViewFacade extends AbstractFacade<NewView> implements NewViewFacadeLocal {
    @PersistenceContext(unitName = "Lab5_Command2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NewViewFacade() {
        super(NewView.class);
    }
    
}
