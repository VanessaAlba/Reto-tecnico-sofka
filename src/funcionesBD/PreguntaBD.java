package funcionesBD;

import clases.Pregunta;

public abstract class PreguntaBD {
	public abstract void InsertarPregunta(Pregunta InsPregunta); 
	public abstract void ModificarPregunta(Pregunta modPregunta );
	public abstract void EliminarPregunta (Pregunta EliPregunta);
	public abstract void ListarPreguntas ();
		
}
