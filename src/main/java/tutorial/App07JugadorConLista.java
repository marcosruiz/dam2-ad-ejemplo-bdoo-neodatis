package tutorial;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase crea 2 jugadores con lista de puntos y consulta los jugadores que tienen en su lista un dato igual a 5
 * TODO NO FUNCIONA
 */
public class App07JugadorConLista {
    public static void main(String[] args){
        // Abrimos la conexión
        ODB odb = ODBFactory.open("neodatis.test");

        // Añadimos jugador1
        List<Integer> lista1 = new ArrayList<>();
        lista1.add(10);
        lista1.add(10);
        lista1.add(5);
        lista1.add(10);
        Jugador jugador1 = new Jugador("Marcos", "futbol", "Zaragoza", 28, lista1);

        // Añadimos jugador2
        List<Integer> lista2 = new ArrayList<>();
        lista1.add(0);
        lista1.add(0);
        lista1.add(2);
        lista1.add(0);
        Jugador jugador2 = new Jugador("Carlos", "natación", "Teruel", 33, lista2);

        // Creamos la consulta
        ICriterion iCriterion = Where.contain(Jugador.PUNTOS,0);
        IQuery iQuery = new CriteriaQuery(Jugador.class, iCriterion);

        // Obtenemos el iterador
        Objects<Jugador> iterador = odb.getObjects(iQuery);

        // Iteramos hasta que no haya siguiente elemento
        System.out.println("Lista de jugadores: ");
        while(iterador.hasNext()){
            Jugador jugador = iterador.next();
            System.out.println(jugador);
        }

        // Cerramos la conexión
        odb.close();
    }
}
