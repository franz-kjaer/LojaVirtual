package org.lasalle.javaweb.av2.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.lasalle.javaweb.av2.model.Desenvolvedor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-11T11:51:43")
@StaticMetamodel(Jogo.class)
public class Jogo_ { 

    public static volatile SingularAttribute<Jogo, Float> preco;
    public static volatile SingularAttribute<Jogo, Date> dta;
    public static volatile SingularAttribute<Jogo, String> nome;
    public static volatile SingularAttribute<Jogo, Desenvolvedor> desenvolvedor;
    public static volatile SingularAttribute<Jogo, Long> id;
    public static volatile SingularAttribute<Jogo, Integer> quantidade;
    public static volatile SingularAttribute<Jogo, String> descricao;

}