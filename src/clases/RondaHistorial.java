package clases;

public class RondaHistorial {
	private int idRonda;
	private int idPartida;
	
	public RondaHistorial (int idRonda, int idPartida) {
		this.idRonda=idRonda;
		this.idPartida=idPartida;
	}
	public RondaHistorial() {
		
	}
	//metodo get
	public int getIdRonda() {
		return idRonda;
	}
	public int getIdPartida() {
		return idPartida;
	}
	//metodo set
	public void setIdRonda(int idRonda) {
		this.idRonda=idRonda;
	}
	public void setIdPartida(int idPartida) {
		this.idPartida=idPartida;
	}

}
