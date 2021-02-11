package tutorial;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.Objects;
import tutorial.daos.EquipoDao;
import tutorial.daos.JugadorDao;
import tutorial.domain.Equipo;
import tutorial.domain.Jugador;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Esta clase crea 6 jugadores y dos equipos con 3 jugadores cada uno.
 */
public class App07CreaEquiposYJugadores {
    public static void main(String[] args){
        // Abrimos la conexión
        ODB odb = ODBFactory.open("neodatis.test");

        // Creamos jugadores
        Jugador jugador1 = new Jugador("Marcos", "petanca", "Zaragoza", 28);
        Jugador jugador2 = new Jugador("Carlos", "petanca", "Teruel", 33);
        Jugador jugador3 = new Jugador("Mario", "petanca", "Guadalajara", 15);
        Jugador jugador4 = new Jugador("Alicia", "petanca", "Madrid", 16);
        Jugador jugador5 = new Jugador("Maria", "petanca", "Madrid", 13);
        Jugador jugador6 = new Jugador("Miguel", "petanca", "Zaragoza", 14);

        // Guardamos jugadores en la base de datos
        odb.store(jugador1);
        odb.store(jugador2);
        odb.store(jugador3);
        odb.store(jugador4);
        odb.store(jugador5);
        odb.store(jugador6);

        // Creamos equipos
        ArrayList<Jugador> jugadoresGiants = new ArrayList<>(Arrays.asList(jugador1, jugador2, jugador3));
        Equipo equipo1 = new Equipo("Giants", "petanca", jugadoresGiants);
        ArrayList<Jugador> jugadoresFnatic = new ArrayList<>(Arrays.asList(jugador4, jugador5, jugador6));
        Equipo equipo2 = new Equipo("Fnatic", "petanca", jugadoresFnatic);

        // Guardamos equipos en la base de datos
        odb.store(equipo1);
        odb.store(equipo2);

        // Listamos equipos
        EquipoDao equipoDao = new EquipoDao(odb);
        equipoDao.listarEquipos();

        // Listamos jugadores
        JugadorDao jugadorDao = new JugadorDao(odb);
        jugadorDao.listarJugadores();

        // Cerramos la conexión
        odb.close();
    }


}
