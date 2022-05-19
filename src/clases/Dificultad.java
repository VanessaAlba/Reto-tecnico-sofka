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
	public int IdDicultad(){
		return idDificultad;
	}
	public String NomDificultad() {
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
