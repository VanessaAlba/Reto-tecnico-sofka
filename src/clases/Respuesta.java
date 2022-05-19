package clases;

public class Respuesta {
	private int idRespuesta;
	private String OpcValida;
	private String Opciones;
	private int idPregunta;
	//constructor
	public Respuesta (int idRespuesta,String OpcValida,String Opciones,int idPregunta) {
		this.idRespuesta=idRespuesta;
		this.OpcValida=OpcValida;
		this.Opciones=Opciones;
		this.idPregunta=idPregunta;
	}
	public Respuesta(){
		
	}
	//metodo get
	public int getIdRespuesta() {
		return idRespuesta;
	}
	public String getopcValida() {
		return OpcValida;
	}
	public String getopciones () {
		return Opciones;
	}
	public int getIdPregunta() {
		return idPregunta;
	}
	//metodo set
	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta=idRespuesta;
	}
	public void setopcValida(String OpcValida) {
		this.OpcValida=OpcValida;
	}
	public void setopciones(String Opciones) {
		this.Opciones=Opciones;
	}
	public void setIdPregunta(int idPregunta) {
		this.idPregunta=idPregunta;
	}
	
}
