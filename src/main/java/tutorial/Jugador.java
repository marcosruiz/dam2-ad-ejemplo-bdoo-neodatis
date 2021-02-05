package tutorial;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Jugador {
  String nombre;
  String deporte;
  String ciudad;
  int edad;

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
