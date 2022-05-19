package clases;

public class Ronda {
	private int idRonda;
	private int nivel;
	private int idDificultad;
	
	public Ronda (int idRonda, int nivel, int idDificultad) {
		this.idRonda=idRonda;
		this.nivel=nivel;
	}
	public Ronda() {
		
	}
	//metodo get
	public int getIdRonda() {
		return idRonda;
	}
	public int getNivel() {
		return nivel;
	}
	public int getIdDificultad() {
		return idDificultad;
	}
	//metodo set
	public void setIdRonda (int idRonda) {
		this.idRonda=idRonda;
	}
	public void setNivel (int nivel) {
		this.nivel=nivel;
	}
	public void setIdDificultad(int idDificultad) {
		this.idDificultad=idDificultad;
	}

}
