package clases;

public class Premio {
	private int idPremio;
	private int puntaje;
	private int idRonda;
	
	public Premio (int idPremio,int puntaje,int idRonda) {
		this.idPremio=idPremio;
		this.puntaje=puntaje;
		this.idRonda=idRonda;
	}
	public Premio () {
		
	}
	//metodo get
	public int getIdPremio() {
		return idPremio;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public int getIdRonda() {
		return idRonda;
	}
	//metodo set
	public void setIdPremio(int idPremio) {
		this.idPremio=idPremio;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje=puntaje;
	}
	public void setIdRonda (int idRonda) {
		this.idRonda=idRonda;
	}
	

}
