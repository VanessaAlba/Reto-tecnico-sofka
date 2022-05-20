package funcionesBD;

import clases.Respuesta;

public abstract class RespuestaAbstracta {
	public abstract void InsertarRespuesta(Respuesta InsRespuesta,int idPregunta);
	public abstract void ModificarRespuesta(Respuesta ModRespuesta,int idPregunta);
	public abstract void EliminarRespuesta(Respuesta ElimRespuesta,int idPregunta);
	public abstract Respuesta[] ListarRespuesta();

}
