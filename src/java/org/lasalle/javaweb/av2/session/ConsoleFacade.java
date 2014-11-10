/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lasalle.javaweb.av2.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.lasalle.javaweb.av2.model.Console;

/**
 *
 * @author Francis
 */
@Stateless
public class ConsoleFacade extends AbstractFacade<Console> {
    @PersistenceContext(unitName = "LojaVirtualPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ConsoleFacade() {
        super(Console.class);
    }
    
}
