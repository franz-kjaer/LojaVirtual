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
import org.lasalle.javaweb.av2.model.Desenvolvedor;
import org.lasalle.javaweb.av2.model.Jogo;
import org.lasalle.javaweb.av2.session.DesenvolvedorFacade;
import org.lasalle.javaweb.av2.session.JogoFacade;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Francis
 */
@ManagedBean
@SessionScoped
public class JogoBean extends AbstractBean<Jogo>{

    @EJB
    DesenvolvedorFacade desenvolvedorFacade;
    @EJB
    JogoFacade jogoFacade;
    
    /** Creates a new instance of JogoBean */
    public JogoBean() {
        super(Jogo.class);
    }
    
    @Override
    public String salvar(){
        System.out.println("chegou aqui");
       if (getEdt() != null) {
           System.out.println("editou");
            jogoFacade.edit(getEdt());
        } else {
           System.out.println("salvou");
            jogoFacade.create(getObj());
        }
        cleanUp();
        return null;
    }
    public List<SelectItem> getDesenvolvedors(){
        List<Desenvolvedor> desenvolvedors = desenvolvedorFacade.findAll();
        List<SelectItem> itens = new ArrayList<SelectItem>();
        for(Desenvolvedor c: desenvolvedors){
            itens.add(new SelectItem(c, c.getNome()));
        }
        return itens;
    }

    public List<Jogo> getJogos(){
        
        return jogoFacade.findAll();
    }

    @Override
    public String excluir() {
        jogoFacade.remove(getSelecionado());
        return null;
    }
    
}
