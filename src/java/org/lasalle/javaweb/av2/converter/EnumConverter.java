package org.lasalle.javaweb.av2.converter;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class EnumConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent comp,
            String value) throws ConverterException {

        Class enumType = comp.getValueExpression("value").getType(context.getELContext());
        return Enum.valueOf(enumType, value);

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object object) throws ConverterException {
        if (object == null) {
            return null;
        }
        Enum type = (Enum) object;
        return type.name();
    }
}
