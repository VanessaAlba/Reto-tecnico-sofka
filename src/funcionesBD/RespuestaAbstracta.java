package funcionesBD;

import clases.Pregunta;
import clases.Respuesta;

public abstract class RespuestaAbstracta {
	public abstract void InsertarRespuesta(Respuesta InsRespuesta,int idPregunta);
	public abstract void ModificarRespuesta(Respuesta ModRespuesta);
	public abstract Respuesta[] ListarRespuesta(Pregunta NumPregunta);

}
