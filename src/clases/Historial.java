package clases;

public class Historial {
	private int idPartida;
	private int acumulado;
	private int idJugador;
	
	public Historial (int idPartida,int acumulado,int idJugador) {
		this.idPartida=idPartida;
		this.acumulado=acumulado;
		this.idJugador=idJugador;
	}
	public Historial() {
		
	}
	//metood get
	public int getIdPartida() {
		return idPartida;
	}
	public int getAcumulado() {
		return acumulado;
	}
	public int getIdJugador() {
		return idJugador;
	}
	//metodo set
	public void setIdPartida(int idPartida) {
		this.idPartida=idPartida;
	}
	public void setAcumulado(int acumulado) {
		this.acumulado=acumulado;
	}
	public void setIdJugador(int idJugador) {
		this.idJugador=idJugador;
	}

}
