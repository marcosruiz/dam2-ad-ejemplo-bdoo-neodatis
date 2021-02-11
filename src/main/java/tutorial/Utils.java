package tutorial;

import org.neodatis.odb.OID;
import org.neodatis.odb.Objects;
import tutorial.domain.Equipo;
import tutorial.domain.Jugador;

import java.util.List;

/**
 * Clase con funcionalidades comunes
 */
public class Utils {

  public static void listarJugadores(List<Jugador> jugadores) {
    for(Jugador jugador : jugadores){
      System.out.println(jugador);
    }
  }

  public static void listarEquipos(List<Equipo> equipos) {
    for(Equipo equipo : equipos){
      System.out.println(equipo);
    }
  }

}
