package tutorial.daos;

import org.neodatis.odb.ODB;
import org.neodatis.odb.OID;
import org.neodatis.odb.Objects;
import tutorial.domain.Equipo;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase se encarga de realizar las consultas a la base de datos sobre los objetos Equipo.
 */
public class EquipoDao {

  private ODB odb;

  public EquipoDao(ODB odb){
    this.odb = odb;
  }

  public List<Equipo> getAllEquipos(){
    List<Equipo> equipos = new ArrayList<>();

    // Obtenemos el iterador
    Objects<Equipo> iterador = odb.getObjects(Equipo.class);
    System.out.printf("%d Equipos: %n", iterador.size());

    // Iteramos hasta que no haya siguiente elemento
    while(iterador.hasNext()){
      Equipo equipo = iterador.next();
      equipos.add(equipo);
    }
    return equipos;
  }
}
