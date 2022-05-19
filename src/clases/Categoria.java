package clases;

public class Categoria {
	//atrubtos
	private int idCategoria;
	private String nomCategoria;
	
	public Categoria (int idCategoria,String nomCategoria) { //metodo constructor 
		this.idCategoria=idCategoria;
		this.nomCategoria=nomCategoria;
	}
	public Categoria () {
		
	}
	// metodo getter
	public int getIdCategoria() {
		return idCategoria;
	}
	public String getNomCategoria() {
		return nomCategoria;
	}
	//metodo setter
	public void setIdCategoria(int idPregunta) {
		this.idCategoria=idPregunta;
	}
	public void setNomCategoria(String nomCategoria) {
		this.nomCategoria=nomCategoria;
	}
	
}
