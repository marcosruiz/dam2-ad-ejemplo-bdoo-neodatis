package tutorial;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import tutorial.dominio.Equipo;
import tutorial.dominio.Jugador;

/**
 * Esta clase consulta los equipos que contengan un jugador en específico.
 * Es necesario ejecutar App07CreaEquiposYJugadores para obtener un resultado.
 */
public class App08ConsultaEquipos {
    public static void main(String[] args) {
        // Abrimos la conexión
        ODB odb = ODBFactory.open("neodatis.test");

        IQuery iQuery = new CriteriaQuery(Jugador.class, Where.equal(Jugador.NOMBRE, "Marcos"));
        Objects<Jugador> iterador = odb.getObjects(iQuery);
        Jugador jugador = (Jugador) iterador.getFirst();
        System.out.println(jugador);

        // Creamos la consulta
        IQuery iQuery2 = odb.criteriaQuery(Equipo.class, Where.contain(Equipo.JUGADORES, jugador));

        // Obtenemos el iterador
        Objects<Equipo> iterador2 = odb.getObjects(iQuery2);

        // Iteramos hasta que no haya siguiente elemento
        System.out.println("Lista de " + iterador2.size() + " equipos: ");
        while (iterador2.hasNext()) {
            Equipo equipo = iterador2.next();
            System.out.println(equipo);
        }

        // Cerramos la conexión
        odb.close();
    }
}
