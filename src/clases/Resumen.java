package clases;

public class Resumen {
	private String NombreJugador;
	private int AcumuladoJugador;
	private int Ronda;
	
	public Resumen (String NombreJugador,int AcumuladoJugador, int Ronda) {
		this.NombreJugador=NombreJugador;
		this.AcumuladoJugador=AcumuladoJugador;
		this.Ronda=Ronda;
	}
	public String getNombreJugador(){
		return NombreJugador;
	}
	public int getAcumuladoJugador() {
		return AcumuladoJugador;
	}
	public int getRonda() {
		return Ronda;
	}

}
