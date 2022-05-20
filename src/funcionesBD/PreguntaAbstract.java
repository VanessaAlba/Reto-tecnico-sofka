package funcionesBD;

import java.util.ArrayList;

import clases.Pregunta;

public abstract class PreguntaAbstract {
	public abstract void InsertarPregunta(Pregunta InsPregunta); 
	public abstract void ModificarPregunta(Pregunta modPregunta );
	public abstract void EliminarPregunta (Pregunta EliPregunta);
	public abstract ArrayList<Pregunta> ListarPreguntas();
		
}
