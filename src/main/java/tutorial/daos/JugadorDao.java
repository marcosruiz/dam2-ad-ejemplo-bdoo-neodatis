package tutorial.daos;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import tutorial.dominio.Jugador;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase se encarga de realizar las consultas a la base de datos sobre los objetos Jugador.
 */
public class JugadorDao {

  private ODB odb;

  public JugadorDao(ODB odb){
    this.odb = odb;
  }

  public List<Jugador> getAllJugadores() {
    List<Jugador> jugadores = new ArrayList<>();

    // Obtenemos el iterador
    Objects<Jugador> objects = this.odb.getObjects(Jugador.class);
    System.out.printf("%d Jugadores: %n", objects.size());

    // Iteramos hasta que no haya siguiente elemento
    while(objects.hasNext()){
      Jugador jugador = objects.next();
      jugadores.add(jugador);
    }

    return jugadores;
  }
}
