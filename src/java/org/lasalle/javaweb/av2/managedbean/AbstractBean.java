/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lasalle.javaweb.av2.managedbean;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.html.HtmlDataTable;

/**
 *
 * @author Francis
 */
public abstract class AbstractBean<T> {

    private Class<T> c;
    private T edt;
    private T obj;
    private T selected;
    private HtmlDataTable lista;
    
    public AbstractBean(Class<T> classe) {
        c = classe;
        try {
            obj = c.newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String cancelar() {
        setEdt(null);
        return null;
    }

    public T getSelecionado(){
        return (T) getSelected();
    }
    
    protected void cleanUp(){
        edt = null;
        try {
            obj = c.newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public abstract String excluir();

    /**
     * @return the lista
     */
    public HtmlDataTable getLista() {
        return lista;
    }

    public abstract String salvar();

    /**
     * @param lista the lista to set
     */
    public void setLista(HtmlDataTable lista) {
        this.lista = lista;
    }

    /**
     * @return the edt
     */
    public T getEdt() {
        return edt;
    }

    /**
     * @param edt the edt to set
     */
    public void setEdt(T edt) {
        this.edt = edt;
    }

    /**
     * @return the obj
     */
    public T getObj() {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(T obj) {
        this.obj = obj;
    }

    /**
     * @return the selected
     */
    public T getSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(T selected) {
        this.selected = selected;
    }
    
}
