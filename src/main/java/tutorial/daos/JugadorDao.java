package tutorial.daos;

import org.neodatis.odb.ODB;
import org.neodatis.odb.OID;
import org.neodatis.odb.Objects;
import tutorial.domain.Jugador;

public class JugadorDao {

  private ODB odb;

  public JugadorDao(ODB odb){
    this.odb = odb;
  }

  public void listarJugadores() {
    // Obtenemos el iterador
    Objects<Jugador> objects = this.odb.getObjects(Jugador.class);
    System.out.printf("%d Jugadores: %n", objects.size());

    // Iteramos hasta que no haya siguiente elemento
    while(objects.hasNext()){
      Jugador j = objects.next();
      OID oid = this.odb.getObjectId(j);
      System.out.print("OID: " + oid.getObjectId() + " => ");
      System.out.println(j);
    }
  }
}
