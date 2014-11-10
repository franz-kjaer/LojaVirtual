/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lasalle.javaweb.av2.managedbean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import org.lasalle.javaweb.av2.model.Tema;
import org.lasalle.javaweb.av2.model.Miniatura;
import org.lasalle.javaweb.av2.session.TemaFacade;
import org.lasalle.javaweb.av2.session.MiniaturaFacade;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Francis
 */
@ManagedBean
@SessionScoped
public class MiniaturaBean extends AbstractBean<Miniatura>{

    @EJB
    TemaFacade temaFacade;
    @EJB
    MiniaturaFacade miniaturaFacade;
    
    /** Creates a new instance of MiniaturaBean */
    public MiniaturaBean() {
        super(Miniatura.class);
    }
    
    @Override
    public String salvar(){
        System.out.println("chegou aqui");
       if (getEdt() != null) {
           System.out.println("editou");
            miniaturaFacade.edit(getEdt());
        } else {
           System.out.println("salvou");
            miniaturaFacade.create(getObj());
        }
        cleanUp();
        return null;
    }
    public List<SelectItem> getTemas(){
        List<Tema> temas = temaFacade.findAll();
        List<SelectItem> itens = new ArrayList<SelectItem>();
        for(Tema c: temas){
            itens.add(new SelectItem(c, c.getNome()));
        }
        return itens;
    }

    public List<Miniatura> getMiniaturas(){
        
        return miniaturaFacade.findAll();
    }

    @Override
    public String excluir() {
        miniaturaFacade.remove(getSelecionado());
        return null;
    }
    
}
