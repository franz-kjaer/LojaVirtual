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
import org.lasalle.javaweb.av2.model.Fabricante;
import org.lasalle.javaweb.av2.model.Console;
import org.lasalle.javaweb.av2.session.FabricanteFacade;
import org.lasalle.javaweb.av2.session.ConsoleFacade;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Francis
 */
@ManagedBean
@SessionScoped
public class ConsoleBean extends AbstractBean<Console>{

    @EJB
    FabricanteFacade fabricanteFacade;
    @EJB
    ConsoleFacade consoleFacade;
    
    /** Creates a new instance of ConsoleBean */
    public ConsoleBean() {
        super(Console.class);
    }
    
    @Override
    public String salvar(){
        System.out.println("chegou aqui");
       if (getEdt() != null) {
           System.out.println("editou");
            consoleFacade.edit(getEdt());
        } else {
           System.out.println("salvou");
            consoleFacade.create(getObj());
        }
        cleanUp();
        return null;
    }
    public List<SelectItem> getFabricantes(){
        List<Fabricante> fabricantes = fabricanteFacade.findAll();
        List<SelectItem> itens = new ArrayList<SelectItem>();
        for(Fabricante c: fabricantes){
            itens.add(new SelectItem(c, c.getNome()));
        }
        return itens;
    }

    public List<Console> getConsoles(){
        
        return consoleFacade.findAll();
    }

    @Override
    public String excluir() {
        consoleFacade.remove(getSelecionado());
        return null;
    }
    
}
