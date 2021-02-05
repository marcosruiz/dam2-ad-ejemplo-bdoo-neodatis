package tutorial;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class Main {
  public static void main(String[] args) {
    // Creamos los jugadores
    Jugador j1 = new Jugador("Maria", "voleibol", "Madrid", 13);
    Jugador j2 = new Jugador("Miguel", "tenis", "Madrid", 14);
    Jugador j3 = new Jugador("Mario", "baloncesto", "Guadalajara", 15);
    Jugador j4 = new Jugador("Alicia", "tenis", "Madrid", 16);

    // Abrimos la conexión
    ODB odb = ODBFactory.open("neodatis.test");

    // Guaradamos los jugadores
    odb.store(j1);
    odb.store(j2);
    odb.store(j3);
    odb.store(j4);

    // Obtenemos el iterador
    Objects<Jugador> objects = odb.getObjects(Jugador.class);
    System.out.printf("%d Jugadores: %n", objects.size());

    // Iteramos hasta que no haya siguiente elemento
    while(objects.hasNext()){
      Jugador j = objects.next();
      System.out.println(j);
    }

    // Cerramos la conexión
    odb.close();

  }
}