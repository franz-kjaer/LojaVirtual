/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lasalle.javaweb.av2.managedbean;

import org.lasalle.javaweb.av2.model.Desenvolvedor;
import org.lasalle.javaweb.av2.session.DesenvolvedorFacade;
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
public class DesenvolvedorBean extends AbstractBean<Desenvolvedor> {

    @EJB
    DesenvolvedorFacade desenvolvedorFacade;
    

    /** Creates a new instance of DesenvolvedorBean */
    public DesenvolvedorBean() {
        super(Desenvolvedor.class);
    }

    @Override
    public String salvar() {
        if (getEdt() != null) {
            desenvolvedorFacade.edit(getEdt());
        } else {
            desenvolvedorFacade.create(getObj());
        }
        cleanUp();
        return null;
    }

    public String buscar() {
        Desenvolvedor c = desenvolvedorFacade.findDesenvolvedor(getObj().getNome());
        System.out.println("c="+c.getId()+" "+c.getNome());
        return null;
    }
    
    @Override
    public String excluir() {
        desenvolvedorFacade.remove(getSelecionado());
        return null;
    }

    @Override
    protected void cleanUp() {
        //nao precisaria chamar esse metodo, apenas para exemplificar
        super.cleanUp();
    }


    public List<Desenvolvedor> getDesenvolvedors() {
        return desenvolvedorFacade.findAll();
    }
}
