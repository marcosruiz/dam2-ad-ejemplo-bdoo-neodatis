package tutorial;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Main7 {
    public static void main(String[] args){
        // Abrimos la conexión
        ODB odb = ODBFactory.open("neodatis.test");

        // Creamos la consulta
        ICriterion iCriterion = Where.contain("","");
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
