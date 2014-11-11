package org.lasalle.javaweb.av2.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.lasalle.javaweb.av2.model.Fabricante;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-11T11:51:43")
@StaticMetamodel(Console.class)
public class Console_ { 

    public static volatile SingularAttribute<Console, Float> preco;
    public static volatile SingularAttribute<Console, Date> dta;
    public static volatile SingularAttribute<Console, String> nome;
    public static volatile SingularAttribute<Console, Long> id;
    public static volatile SingularAttribute<Console, Fabricante> fabricante;
    public static volatile SingularAttribute<Console, Integer> quantidade;
    public static volatile SingularAttribute<Console, String> descricao;

}