package tutorial;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class Main {
  public static void main(String[] args) {
    Jugador j1 = new Jugador("Maria", "voleibol", "Madrid", 14);
    Jugador j2 = new Jugador("Miguel", "tenis", "Madrid", 14);
    Jugador j3 = new Jugador("Mario", "baloncesto", "Guadalajara", 14);
    Jugador j4 = new Jugador("Alicia", "tenis", "Madrid", 14);

    ODB odb = ODBFactory.open("neodatis.test");

    odb.store(j1);
    odb.store(j2);
    odb.store(j3);
    odb.store(j4);

    Objects<Jugador> objects = odb.getObjects(Jugador.class);
    System.out.printf("%d Jugadores: %n", objects.size());

    int i = 1;
    while(objects.hasNext()){
      Jugador j = objects.next();
      System.out.println(j);
    }

    odb.close();

  }
}