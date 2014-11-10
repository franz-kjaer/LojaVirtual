/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lasalle.javaweb.av2.converter;

import org.lasalle.javaweb.av2.model.Fabricante;
import org.lasalle.javaweb.av2.session.FabricanteFacade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Francis
 */
@FacesConverter(forClass=Fabricante.class)
public class FabricanteConverter extends BaseConverter implements Converter {

    FabricanteFacade facade;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (facade == null) {
            facade = (FabricanteFacade) lookup("LojaVirtual/FabricanteFacade");
        }
        Fabricante obj = facade.find(Long.parseLong(value));
        return obj;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return String.valueOf(((Fabricante)value).getId());
    }
    
}
