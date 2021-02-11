package tutorial.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Equipo {

  public static String NOMBRE = "nombre";
  public static String DEPORTE = "deporte";
  public static String JUGADORES = "jugadores";

  private String nombre;
  private String deporte;
  private List<Jugador> jugadores;

  public Equipo(){

  }

  public Equipo(String nombre, String deporte, List<Jugador> jugadores){
    this.nombre = nombre;
    this.deporte = deporte;
    this.jugadores = jugadores;
  }

  @Override
  public String toString() {
    return "Equipo{" +
        "nombre='" + nombre + '\'' +
        ", deporte='" + deporte + '\'' +
        ", jugadores=" + jugadores +
        '}';
  }
}
