/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lasalle.javaweb.av2.managedbean;

import org.lasalle.javaweb.av2.model.Tema;
import org.lasalle.javaweb.av2.session.TemaFacade;
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
public class TemaBean extends AbstractBean<Tema> {

    @EJB
    TemaFacade temaFacade;
    

    /** Creates a new instance of TemaBean */
    public TemaBean() {
        super(Tema.class);
    }

    @Override
    public String salvar() {
        if (getEdt() != null) {
            temaFacade.edit(getEdt());
        } else {
            temaFacade.create(getObj());
        }
        cleanUp();
        return null;
    }

    public String buscar() {
        Tema c = temaFacade.findTema(getObj().getNome());
        System.out.println("c="+c.getId()+" "+c.getNome());
        return null;
    }
    
    @Override
    public String excluir() {
        temaFacade.remove(getSelecionado());
        return null;
    }

    @Override
    protected void cleanUp() {
        //nao precisaria chamar esse metodo, apenas para exemplificar
        super.cleanUp();
    }


    public List<Tema> getTemas() {
        return temaFacade.findAll();
    }
}
