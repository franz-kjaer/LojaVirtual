package org.lasalle.javaweb.av2.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.lasalle.javaweb.av2.model.Tema;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-11T11:51:43")
@StaticMetamodel(Miniatura.class)
public class Miniatura_ { 

    public static volatile SingularAttribute<Miniatura, Float> preco;
    public static volatile SingularAttribute<Miniatura, Date> dta;
    public static volatile SingularAttribute<Miniatura, Tema> tema;
    public static volatile SingularAttribute<Miniatura, String> nome;
    public static volatile SingularAttribute<Miniatura, Long> id;
    public static volatile SingularAttribute<Miniatura, Integer> quantidade;
    public static volatile SingularAttribute<Miniatura, String> descricao;

}