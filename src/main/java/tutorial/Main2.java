package tutorial;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class Main2 {
  public static void main(String[] args){
    ODB odb = ODBFactory.open("neodatis.test");

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
