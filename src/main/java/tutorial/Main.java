package tutorial;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class Main {
  public static void main(String[] args) {
    // Creamos los jugadores
    Jugador jugador1 = new Jugador("Maria", "voleibol", "Madrid", 13);
    Jugador jugador2 = new Jugador("Miguel", "tenis", "Zaragoza", 14);
    Jugador jugador3 = new Jugador("Mario", "baloncesto", "Guadalajara", 15);
    Jugador jugador4 = new Jugador("Alicia", "tenis", "Madrid", 16);

    // Abrimos la conexión
    ODB odb = ODBFactory.open("neodatis.test");

    // Guaradamos los jugadores
    odb.store(jugador1);
    odb.store(jugador2);
    odb.store(jugador3);
    odb.store(jugador4);

    // Obtenemos el iterador
    Objects<Jugador> iterador = odb.getObjects(Jugador.class);
    System.out.printf("%d Jugadores: %n", iterador.size());

    // Iteramos hasta que no haya siguiente elemento
    while(iterador.hasNext()){
      Jugador jugador = iterador.next();
      System.out.println(jugador);
    }

    // Cerramos la conexión
    odb.close();

  }
}