package clases;

public class Dificultad {
	private int idDificultad;
	private String nomDificultad;
	
	public Dificultad (int idDificultad,String nomDificultad) {
		this.idDificultad=idDificultad;
		this.nomDificultad=nomDificultad;
	}
	public Dificultad(){
		
	}
	//metodo get
	public int getIdDicultad(){
		return idDificultad;
	}
	public String getNomDificultad() {
		return nomDificultad;
	}
	//metodo set
	public void setIdDificultad (int idDificultad) {
		this.idDificultad=idDificultad;
	}
	public void setNomDificultad (String nomDificultad) {
		this.nomDificultad=nomDificultad;
	}

}
