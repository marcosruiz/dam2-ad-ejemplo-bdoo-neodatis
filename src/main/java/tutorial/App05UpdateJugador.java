package tutorial;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import tutorial.domain.Jugador;

/**
 * Esta clase actualiza un jugador que se llame Maria.
 */
public class App05UpdateJugador {
    public static void main(String[] args){
        // Abrimos la conexión
        ODB odb = ODBFactory.open("neodatis.test");

        // Creamos la consulta
        IQuery iQuery = new CriteriaQuery(Jugador.class, Where.equal(Jugador.NOMBRE, "Maria"));

        // Obtenemos el primer resultado
        Jugador jugador = (Jugador) odb.getObjects(iQuery).getFirst();

        // Iteramos para obtener todos los jugadores
        jugador.setDeporte("voley-playa");

        // Actualizamos jugador
        odb.store(jugador);

        // Cerramos la conexión
        odb.close();
    }
}
