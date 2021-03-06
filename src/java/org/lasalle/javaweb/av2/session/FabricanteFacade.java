/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lasalle.javaweb.av2.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.lasalle.javaweb.av2.model.Fabricante;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author francis
 */
@Stateless
public class FabricanteFacade extends AbstractFacade<Fabricante> {
    @PersistenceContext(unitName = "LojaVirtualPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public FabricanteFacade() {
        super(Fabricante.class);
    }
    
    public Fabricante findFabricante(String str){
        String query = "SELECT c "
                + "FROM Fabricante c "
                + "WHERE c.nome LIKE '%" + str + "%'";
        return em.createQuery(query, Fabricante.class).getSingleResult();
    }
}
