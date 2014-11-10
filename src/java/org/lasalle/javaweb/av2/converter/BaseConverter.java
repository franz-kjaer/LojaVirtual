/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lasalle.javaweb.av2.converter;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Francis
 */
class BaseConverter {
    
    protected Object lookup(String str){
        InitialContext ic;
        Object result = null;
        try{
            ic = new InitialContext();
            result = ic.lookup("java:global/"+str);
        } catch(NamingException e){
            System.out.println("erro "+e);
        }
        return result;
    }
    
}
