package tutorial.dominio;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
/**
 * Esta clase representa un jugador.
 */

@Getter
@Setter
public class Jugador {

  public static final String NOMBRE = "nombre";
  public static final String DEPORTE = "deporte";
  public static final String CIUDAD = "ciudad";
  public static final String EDAD = "edad";
  public static final String PUNTOS = "puntos";

  private String nombre;
  private String deporte;
  private String ciudad;
  private int edad;
  private List<Integer> puntos; // Lista de puntos que hace en cada partido

  public Jugador() {
  }

  public Jugador(String nombre, String deporte, String ciudad, int edad) {
    this.nombre = nombre;
    this.deporte = deporte;
    this.ciudad = ciudad;
    this.edad = edad;
    this.puntos = new ArrayList<>();
  }

  public Jugador(String nombre, String deporte, String ciudad, int edad, List<Integer> puntos) {
    this( nombre,  deporte,  ciudad,  edad);
    this.puntos = puntos;
  }

  @Override
  public String toString() {
    return "Jugador{" +
        "nombre='" + nombre + '\'' +
        ", deporte='" + deporte + '\'' +
        ", ciudad='" + ciudad + '\'' +
        ", edad=" + edad +
        '}';
  }
}
