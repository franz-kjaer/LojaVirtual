/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lasalle.javaweb.av2.converter;

import org.lasalle.javaweb.av2.model.Desenvolvedor;
import org.lasalle.javaweb.av2.session.DesenvolvedorFacade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Francis
 */
@FacesConverter(forClass=Desenvolvedor.class)
public class DesenvolvedorConverter extends BaseConverter implements Converter {

    DesenvolvedorFacade facade;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (facade == null) {
            facade = (DesenvolvedorFacade) lookup("LojaVirtual/DesenvolvedorFacade");
        }
        Desenvolvedor obj = facade.find(Long.parseLong(value));
        return obj;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return String.valueOf(((Desenvolvedor)value).getId());
    }
    
}
