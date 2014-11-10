/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lasalle.javaweb.av2.converter;

import org.lasalle.javaweb.av2.model.Tema;
import org.lasalle.javaweb.av2.session.TemaFacade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Francis
 */
@FacesConverter(forClass=Tema.class)
public class TemaConverter extends BaseConverter implements Converter {

    TemaFacade facade;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (facade == null) {
            facade = (TemaFacade) lookup("LojaVirtual/TemaFacade");
        }
        Tema obj = facade.find(Long.parseLong(value));
        return obj;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return String.valueOf(((Tema)value).getId());
    }
    
}
