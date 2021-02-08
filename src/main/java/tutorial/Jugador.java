package tutorial;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Jugador {

  public static final String NOMBRE = "nombre";
  public static final String DEPORTE = "deporte";
  public static final String CIUDAD = "ciudad";
  public static final String EDAD = "edad";

  private String nombre;
  private String deporte;
  private String ciudad;
  private int edad;

  public Jugador() {
  }

  public Jugador(String nombre, String deporte, String ciudad, int edad) {
    this.nombre = nombre;
    this.deporte = deporte;
    this.ciudad = ciudad;
    this.edad = edad;
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
