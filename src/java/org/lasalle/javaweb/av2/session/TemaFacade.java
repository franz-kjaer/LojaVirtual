/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lasalle.javaweb.av2.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.lasalle.javaweb.av2.model.Tema;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author francis
 */
@Stateless
public class TemaFacade extends AbstractFacade<Tema> {
    @PersistenceContext(unitName = "LojaVirtualPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TemaFacade() {
        super(Tema.class);
    }
    
    public Tema findTema(String str){
        String query = "SELECT c "
                + "FROM Tema c "
                + "WHERE c.nome LIKE '%" + str + "%'";
        return em.createQuery(query, Tema.class).getSingleResult();
    }
}
