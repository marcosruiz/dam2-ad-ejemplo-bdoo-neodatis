package tutorial;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import tutorial.domain.Jugador;


/**
 * Esta clase consulta los jugadores cuyo nombre empieza por M y tienen 14 años de edad.
 */
public class App06ConsultaConAnd {
    public static void main(String[] args){
        // Abrimos la conexión
        ODB odb = ODBFactory.open("neodatis.test");

        // Otras consultas que quizás te ayuden
        // ICriterion iCriterion = Where.ge("edad", 13);
        // ICriterion iCriterion = Where.lt("edad", 13);
        // ICriterion iCriterion = Where.le("edad", 13);
        // ICriterion iCriterion = Where.isNull("nombre");
        // ICriterion iCriterion = Where.isNotNull("nombre");
        // ICriterion iCriterion = new Or().add(iCriterion1).add(iCriterion2);

        // Creamos la consulta
        ICriterion iCriterion1 = Where.like(Jugador.NOMBRE, "M%");
        ICriterion iCriterion2 = Where.gt(Jugador.EDAD, 13);
        ICriterion iCriterion = new And().add(iCriterion1).add(iCriterion2);

        IQuery iQuery = new CriteriaQuery(Jugador.class, iCriterion);

        // Obtenemos el iterador
        Objects<Jugador> iterador = odb.getObjects(iQuery);

        // Iteramos hasta que no haya siguiente elemento
        while(iterador.hasNext()){
            Jugador j = iterador.next();
            System.out.println(j);
        }

        // Cerramos la conexión
        odb.close();
    }
}
