package tutorial;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Main3 {
    public static void main(String[] args){
        // Abrimos la conexión
        ODB odb = ODBFactory.open("neodatis.test");

        // Creamos la consulta
        IQuery iQuery = new CriteriaQuery(Jugador.class, Where.equal("deporte", "tenis"));
        iQuery.orderByAsc("nombre"); // Ordena

        // Obtenemos el iterador
        Objects<Jugador> objects = odb.getObjects(iQuery);

        // Iteramos para obtener todos los jugadores
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
