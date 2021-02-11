package tutorial.daos;

import org.neodatis.odb.ODB;
import org.neodatis.odb.OID;
import org.neodatis.odb.Objects;
import tutorial.domain.Equipo;

public class EquipoDao {

  private ODB odb;

  public EquipoDao(ODB odb){
    this.odb = odb;
  }

  public void listarEquipos(){
    // Obtenemos el iterador
    Objects<Equipo> objects = odb.getObjects(Equipo.class);
    System.out.printf("%d Equipos: %n", objects.size());

    // Iteramos hasta que no haya siguiente elemento
    while(objects.hasNext()){
      Equipo e = objects.next();
      OID oid = odb.getObjectId(e);
      System.out.print("OID: " + oid.getObjectId() + " => ");
      System.out.println(e);
    }
  }
}
