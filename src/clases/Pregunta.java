package clases;

public class Pregunta {
	//atributos
	private int idPregunta;
	private String enunciado;
	
	public Pregunta(int idPregunta, String enunciado) { //metodo constructor
		this.idPregunta=idPregunta;
		this.enunciado=enunciado;
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
	//metodos setter
	public void setIdPregunta(int idPregunta) {
		this.idPregunta= idPregunta;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado=enunciado;
	}

}


