package tutorial;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.Objects;
import tutorial.dominio.Jugador;

/**
 * Esta clase lista los jugadores de la base de datos.
 */
public class App01ConsultaJugadores {
  public static void main(String[] args){
    // Abrimos la conexión
    ODB odb = ODBFactory.open("neodatis.test");

    // Obtenemos el iterador
    Objects<Jugador> objects = odb.getObjects(Jugador.class);
    System.out.printf("%d Jugadores: %n", objects.size());

    // Iteramos hasta que no haya siguiente elemento
    while(objects.hasNext()){
      Jugador j = objects.next();
      OID oid = odb.getObjectId(j);
      System.out.print("OID: " + oid.getObjectId() + " => ");
      System.out.println(j);
    }

    // Cerramos la conexión
    odb.close();
  }
}
