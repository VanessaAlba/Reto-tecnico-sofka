package principal;

import java.util.ArrayList;
import java.util.Scanner;

import ConexionBD.conectarBDaJava;
import aplicacionFunciones.CategoriaBD;
import aplicacionFunciones.DificultadBD;
import aplicacionFunciones.PreguntaBD;
import aplicacionFunciones.PremioBD;
import aplicacionFunciones.RespuestaBD;
import clases.Categoria;
import clases.Dificultad;
import clases.Pregunta;
import clases.Premio;
import clases.Respuesta;

public class Principal {
	
	public static void main(String[] args) {
		Scanner entrada =new Scanner(System.in);
		int seleccionar;
		
		do {
		System.out.println("Elige una opcion: \n1:Jugar \n2:Resumen \n3:Preguntas "
				+ "\n4:Respuestas \n5:Listar Categoria \n6:Listar Dificultades \n7:Listar Premios \n8:Salir");
		 seleccionar=entrada.nextInt();
		switch (seleccionar) {
		//jugar
		case 1: 
			boolean Correcta;
			int mirespuesta,puntajeAcumulado, acumulador=0;
			int ronda=1;
			int responder;
			System.out.println(); 
			
			do {
				int categoriaAle = (int)(Math. random()*5+1);
				Pregunta mipregunta;
				mipregunta=PreAleatoria(categoriaAle, ronda);
				ListarResEspecifica(mipregunta.getIdPregunta());
				responder = entrada.nextInt();
	
				Correcta= ResPregEspecifica(mipregunta.getIdPregunta(),responder);
				if (Correcta==true){
					puntajeAcumulado= ObtenerPuntaje(ronda);
					System.out.println("Respuesta Correcta");
					//acumulador=puntajeAcumulado;
					acumulador += puntajeAcumulado;
					System.out.println("Tu puntaje acumulado es: "+acumulador);
					ronda++;
					if (ronda==6) {
						Correcta=false;
					}
					
				}else {
					System.out.println("�Ups! Respuesta Incorrecta");
					System.out.println("Tu puntaje acumulado es: "+(puntajeAcumulado=0));
				}
				
			}while(Correcta != false);
				
			break;
		//Resumen
		case 2:
			break;
		//Preguntas
		
		case 3:
			int submenu1;
			do {
			System.out.println
			("Elige una opcion: \n1:Insertar Pregunta \n2:Modificar Pregunta \n3:Eliminar Pregunta \n4:Listar preguntas \n5:Atras");
			submenu1=entrada.nextInt();
			switch (submenu1) {
			case 1:
				InsertarPreguntas();
				break;
			case 2:
				ModificarPregunta();
				break;
			case 3:
				EliminarPregunta();
				break;
			case 4: 
				ListarPreguntas();
				break;
			default:
				break;
			}
			}while(submenu1!=5);
			break;
	
		//Respuestas
		case 4:
			int submenu2;
			do {
			System.out.println
			("Elige una opcion: \n1:Insertar Respuesta \n2:Modificar Respuesta  \n3:Listar Respestas \n4: Atras");
			submenu2=entrada.nextInt();
			switch (submenu2) {
			case 1:
				InsertarRespuestas();
				break;
			case 2:
				ModificarRespuestas();
				break;
			case 3: 
				ListarRespuetas();
				break;
			default:
			break;
			}
			}while(submenu2!=4);
			break;
		//listar categorias
		case 5:
			ListarCategorias();
			break;
		//listar dificultad
		case 6:
			ListarDificultad();
			break;
		//listar premios
		case 7:
			ListarPremio();
			break;
		default:
	       break;
		
		}		
	
		}while(seleccionar!=8);
	}
public static void InsertarPreguntas() {
	Scanner entrada = new Scanner(System.in);
	Pregunta dato = new Pregunta();
	System.out.println("Digite el enunciado de la pregunta:");
	dato.setEnunciado(entrada.nextLine());
	System.out.println("Digite el Id de la categoria:");
	dato.setIdCategoria(entrada.nextInt());
	entrada.nextLine();
	System.out.println("Digite el nivel de dificultad:");
	dato.setIdDificultad(entrada.nextInt());
	entrada.nextLine();
	PreguntaBD insertar = new PreguntaBD();
	insertar.InsertarPregunta(dato);
}
public static void ModificarPregunta () {
	Scanner entrada = new Scanner (System.in);
	Pregunta dato =new Pregunta();
	System.out.println("Digite el Id de la pregunta que desea modificar:");
	dato.setIdPregunta(entrada.nextInt());
	entrada.nextLine();
	System.out.println("Digite el nuevo enunciado de la pregunta:");
	dato.setEnunciado(entrada.nextLine());
	System.out.println("Digite el Id de la categoria:");
	dato.setIdCategoria(entrada.nextInt());
	entrada.nextLine();
	System.out.println("Digite el nivel de dificultad:");
	dato.setIdDificultad(entrada.nextInt());
	entrada.nextLine();
	PreguntaBD modificar = new PreguntaBD();
	modificar.ModificarPregunta(dato);
}
public static void EliminarPregunta() {
	Scanner entrada = new Scanner (System.in);
	Pregunta dato = new Pregunta();
	System.out.println("Digite el Id de la pregunta que desea eliminar:");
	dato.setIdPregunta(entrada.nextInt());
	entrada.nextLine();
	PreguntaBD eliminar = new PreguntaBD();
	eliminar.EliminarPregunta(dato);
}
public static void ListarPreguntas() {
	ArrayList<Pregunta> PREGUNTA;
	PreguntaBD pregunta = new PreguntaBD();
	PREGUNTA=pregunta.ListarPreguntas();
	Pregunta interrogante = new Pregunta();
	for (int i = 0;i<PREGUNTA.size();i++) {
		System.out.print(PREGUNTA.get(i).getIdPregunta()+" \t");
		System.out.print(PREGUNTA.get(i).getEnunciado()+ "\t");
		//System.out.print(PREGUNTA.get(i).getIdCategoria()+"\t"); 
		//System.out.print(PREGUNTA.get(i).getIdDicultad()+"\t");
		System.out.println();
	}
}
public static void InsertarRespuestas() {
	Scanner entrada = new Scanner(System.in);
	int pregunta;
	Respuesta dato = new Respuesta();
	System.out.println("Digite el Id de la pregunta que desea ingresar la respuesta: ");
	pregunta=entrada.nextInt();
	entrada.nextLine();
	ListarPregEspecifica(pregunta);
	System.out.println("Insertando respuestas");
	for (int i=0;i<4;i++) {
		System.out.println("Digite la respuesta n� "+(i+1));
		dato.setopciones(entrada.nextLine());
		System.out.println("Digite 'si' en caso que la respuesta sea correcta de lo contrario digite 'no'");
		dato.setopcValida(entrada.nextLine());
		dato.setIdPregunta(pregunta);
		RespuestaBD insertar = new  RespuestaBD();
		insertar.InsertarRespuesta(dato, pregunta);;
	}	
}
public static void ListarPregEspecifica(int numPregunta) {
	PreguntaBD listarPreg = new PreguntaBD();
	Pregunta LisPre;
	LisPre = listarPreg.PregEspecifica(numPregunta);
	System.out.println(LisPre.getEnunciado());
}
public static void ModificarRespuestas() {
	Scanner entrada = new Scanner(System.in);
	Respuesta dato = new Respuesta();
	ListarRespuetas();
	System.out.println("Digite el Id de la respuesta que desea cambiar:");
	dato.setIdRespuesta(entrada.nextInt());
	entrada.nextLine();
	System.out.println("Digite el nuevo enunciado de la respuesta:");
	dato.setopciones(entrada.nextLine());
	System.out.println("Digite 'si' en caso que la respuesta sea correcta de lo contrario digite 'no'");
	dato.setopcValida(entrada.nextLine());
	RespuestaBD modificar = new RespuestaBD();
	modificar.ModificarRespuesta(dato);;
}
public static void ListarRespuetas() {
	Scanner entrada = new Scanner(System.in);
	int pregunta;
	Pregunta opcion=new Pregunta();
	System.out.println("Digite el numero de la pregunta: ");
	pregunta=entrada.nextInt();
	ListarPregEspecifica(pregunta);
	opcion.setIdPregunta(pregunta);
	RespuestaBD mirespuesta =new RespuestaBD();
	Respuesta arreglo[];
	arreglo=mirespuesta.ListarRespuesta(opcion);
	for (int i=0;i<arreglo.length;i++) {
		System.out.print(arreglo[i].getIdRespuesta()+" \t");
		System.out.print(arreglo[i].getopcValida()+" \t");
		System.out.print(arreglo[i].getopciones()+" \t");
		//System.out.print(arreglo[i].getIdPregunta()+" \t");
		System.out.println();
	}
}
public static void ListarResEspecifica(int NumPregunta) {
	Pregunta opcion=new Pregunta();
	ListarPregEspecifica(NumPregunta);
	opcion.setIdPregunta(NumPregunta);
	RespuestaBD mirespuesta =new RespuestaBD();
	Respuesta arreglo[];
	arreglo=mirespuesta.ListarRespuesta(opcion);
	for (int i=0;i<arreglo.length;i++) {
		System.out.print(i +" " +arreglo[i].getIdRespuesta()+" \t");
		System.out.print(i +" " +arreglo[i].getopcValida()+" \t");
		System.out.print(i +" " +arreglo[i].getopciones()+" \t");
		//System.out.print(arreglo[i].getIdPregunta()+" \t");
		System.out.println();
	}
}
public static boolean  ResPregEspecifica(int IdPregunta,int NumRespuesta) {
	boolean correcto;
	Pregunta opcion=new Pregunta();
	opcion.setIdPregunta(IdPregunta);
	RespuestaBD mirespuesta =new RespuestaBD();
	Respuesta arreglo[];
	arreglo=mirespuesta.ListarRespuesta(opcion);
	if (arreglo[NumRespuesta].getopcValida().equalsIgnoreCase("si")) {
		//System.out.println("respuesta correcta");
		correcto=true;
	}else {
		//System.out.println("respuesta incorrecta");
		correcto=false;
	}
	return correcto;
}
public static int ObtenerPuntaje(int NumRonda) {
	int mipuntaje;
	PremioBD obtener =new PremioBD();
	mipuntaje=obtener.ObtenerPremio(NumRonda);
		return mipuntaje;
	
}
public static Pregunta PreAleatoria(int IdCategoria,int IdDificultad) {
	Pregunta preguntaAle;
	PreguntaBD PreAleatoria = new PreguntaBD();
	preguntaAle=PreAleatoria.PregCategoriaDif(IdCategoria, IdDificultad);
	return preguntaAle;
}
public static void ListarCategorias() {
	
	Categoria datos[];
	CategoriaBD listar=new CategoriaBD();
	datos=listar.ListarCategorias();
	for(int i=0;i<datos.length;i++) {
		System.out.print(datos[i].getIdCategoria()+" \t");
		System.out.println(datos[i].getNomCategoria()+" \t");
		
	}
}
public static void ListarDificultad() {
	Dificultad dato[];
	DificultadBD listar=new DificultadBD();
	dato=listar.ListarDificultad();
	for(int i=0;i<dato.length;i++) {
		System.out.print(dato[i].getIdDicultad()+" \t");
		System.out.println(dato[i].getNomDificultad()+" \t");
	}
}
public static void ListarPremio() {
	Premio dato[];
	PremioBD listar=new PremioBD();
	dato= listar.listarPremio();
	for(int i=0;i<dato.length;i++) {
		System.out.print(dato[i].getIdPremio()+" \t");
		System.out.print(dato[i].getPuntaje()+" \t");
		System.out.println(dato[i].getIdRonda()+" \t");
		//System.out.println();
	}
}

}
