/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pro.paulomotta.lojavirtual.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author aluno.unilasalle
 */
@FacesValidator("validator.EmailValidator")
public class EmailValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String str = (String)value;
        if(!str.contains("@")){
            FacesMessage msg = new FacesMessage("Email inválido","formato errado");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
}
