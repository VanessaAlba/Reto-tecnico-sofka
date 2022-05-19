package clases;

public class Jugador {
	private int idJugador;
	private String nombre;
	
	public Jugador (int idJugador,String nombre) {
		this.idJugador=idJugador;
		this.nombre=nombre;
	}
	public Jugador() {
		
	}
	//meteodo get
	public int getIdJugador() {
		return idJugador;
	}
	public String getNombre() {
		return nombre;
	}
	//metodo set
	public void setIdJugador(int idJugador) {
		this.idJugador=idJugador;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}

}
