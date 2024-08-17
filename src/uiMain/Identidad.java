package uiMain;
import gestorAplicación.servicios.Enums;
import gestorAplicación.sujetos.*;
import gestorAplicación.sujetos.Persona;
import static uiMain.Main.escaner;
import static gestorAplicación.servicios.Enums.Genero;
import java.util.Scanner;
public abstract class Identidad {
  static Scanner  sc = new Scanner(System.in);
	public static Persona identificarPersona() {
		
		System.out.println("digite su documento");
		int p=escaner();
		for (Persona i : Persona.getPersonas()) {
			if ( p== i.getId() ) {
				return i;
			}					
		}
		System.out.println("No se ha encontrado el usuario "+p);
		System.out.println("Que desea hacer ");
		System.out.println("1. Digite otra vez su documento ");
		System.out.println("2. Registrar usuario ");
		
		int seleccion = escaner(2);
		if (seleccion== 1) {
			Persona persona1 = identificarPersona();
			return persona1 ;
		}
		
		System.out.println("Digite su nombre ");
		String nombre = sc.nextLine();
		
		System.out.println("Digite su genero ");
		System.out.println("1. Masculino ");
		System.out.println("2. Femenino");
		
		int genero = escaner(2);
		Genero genero1=null;
		if (genero == 1) {
			 genero1  = Genero.M; 
		}
		else{
			 genero1  = Genero.M; 
		}
			

		System.out.println("digite su edad ");
		int edad = escaner();
		
		
		Persona persona = new Persona(nombre,p,edad,genero1);
		System.out.println("Usuario creado con exito ");
		System.out.println("Bienvenido "+nombre);
		return persona ;
	}

}
