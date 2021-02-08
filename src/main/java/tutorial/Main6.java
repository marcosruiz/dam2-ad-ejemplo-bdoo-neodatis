package tutorial;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Main6 {
    public static void main(String[] args){
        // Abrimos la conexión
        ODB odb = ODBFactory.open("neodatis.test");

        // Creamos la consulta
//        ICriterion iCriterion2 = Where.ge("edad", 13);
//        ICriterion iCriterion2 = Where.lt("edad", 13);
//        ICriterion iCriterion2 = Where.le("edad", 13);
//        ICriterion iCriterion3 = Where.contain("nombrearray", valor);
        ICriterion iCriterion4 = Where.isNull("nombre");
        ICriterion iCriterion5 = Where.isNotNull("nombre");

        ICriterion iCriterion1 = Where.like("nombre", "M%");
        ICriterion iCriterion2 = Where.gt(Jugador.EDAD, 13);
        ICriterion iCriterion = new And().add(iCriterion1).add(iCriterion2);
//        ICriterion iCriterion = new Or().add(iCriterion1).add(iCriterion2);

        IQuery iQuery = new CriteriaQuery(Jugador.class, iCriterion);

        // Obtenemos el iterador
        Objects<Jugador> objects = odb.getObjects(iQuery);

        // Iteramos hasta que no haya siguiente elemento
        while(objects.hasNext()){
            Jugador j = objects.next();
            System.out.println(j);
        }

        // Cerramos la conexión
        odb.close();
    }
}
