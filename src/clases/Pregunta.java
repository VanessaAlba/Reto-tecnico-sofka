package clases;

public class Pregunta {
	//atributos
	private int idPregunta;
	private String enunciado;
	private int idCategoria;
	private int idDificultad;
	
	public Pregunta(int idPregunta, String enunciado,int idCategoria, int idDificultad) { //metodo constructor
		this.idPregunta=idPregunta;
		this.enunciado=enunciado;
		this.idCategoria=idCategoria;
		this.idDificultad=idDificultad;
	} 
	public Pregunta() {
		
	}
	//metodos getter
	public int getIdPregunta() {
		return idPregunta;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public int getIdDicultad(){
		return idDificultad;
	}
	//metodos setter
	public void setIdPregunta(int idPregunta) {
		this.idPregunta= idPregunta;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado=enunciado;
	}
	public void setIdCategoria(int idPregunta) {
		this.idCategoria=idPregunta;
	}
	public void setIdDificultad (int idDificultad) {
		this.idDificultad=idDificultad;
	}

}


