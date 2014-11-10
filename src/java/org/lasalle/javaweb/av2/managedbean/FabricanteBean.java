/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lasalle.javaweb.av2.managedbean;

import org.lasalle.javaweb.av2.model.Fabricante;
import org.lasalle.javaweb.av2.session.FabricanteFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Francis
 */
@ManagedBean
@SessionScoped
public class FabricanteBean extends AbstractBean<Fabricante> {

    @EJB
    FabricanteFacade fabricanteFacade;
    

    /** Creates a new instance of FabricanteBean */
    public FabricanteBean() {
        super(Fabricante.class);
    }

    @Override
    public String salvar() {
        if (getEdt() != null) {
            fabricanteFacade.edit(getEdt());
        } else {
            fabricanteFacade.create(getObj());
        }
        cleanUp();
        return null;
    }

    public String buscar() {
        Fabricante c = fabricanteFacade.findFabricante(getObj().getNome());
        System.out.println("c="+c.getId()+" "+c.getNome());
        return null;
    }
    
    @Override
    public String excluir() {
        fabricanteFacade.remove(getSelecionado());
        return null;
    }

    @Override
    protected void cleanUp() {
        //nao precisaria chamar esse metodo, apenas para exemplificar
        super.cleanUp();
    }


    public List<Fabricante> getFabricantes() {
        return fabricanteFacade.findAll();
    }
}
