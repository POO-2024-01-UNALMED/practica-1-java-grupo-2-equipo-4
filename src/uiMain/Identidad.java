package uiMain;
import gestorAplicación.servicios.Enums.Genero;
import gestorAplicación.sujetos.*;

import static uiMain.Main.escaner;
import static gestorAplicación.servicios.Enums.Genero;
import java.util.Scanner;
import static uiMain.Main.lineas;
import static uiMain.Main.print;
public abstract class Identidad {
  static Scanner  sc = new Scanner(System.in);
  public static Persona identificarPersona() {
		lineas();
		System.out.print("Digite su documento: ");
		int p=escaner();
		for (Persona i : Persona.getPersonas()) {
			if (p==i.getId()) {
				System.out.println("Bienvenido "+i.getNombre());
				return i;
			}					
		}
		print("");
		System.out.println("No se ha encontrado el usuario "+p);
		System.out.println("¿Que desea hacer?");
		System.out.println("1. Digitar otra vez mi documento ");
		System.out.println("2. Registrar usuario ");
		print("");
		System.out.print("Seleccione una opcion: ");
		
		int seleccion = escaner(2);
		if (seleccion== 1) {
			Persona persona1 = identificarPersona();
			return persona1;
		}
		lineas();
		
		System.out.print("Digite su nombre: ");
		String nombre = sc.nextLine();
		
		print("");
		System.out.println("Escoja su genero ");
		System.out.println("1. Masculino ");
		System.out.println("2. Femenino ");
		System.out.print("Cual de los dos: ");
		
		int genero = escaner(2);
		Genero genero1=null;
		if (genero == 1) {
			 genero1  = Genero.M; 
		}
		else{
			 genero1  = Genero.M; 
		}
			
		print("");
		System.out.print("Digite su edad: ");
		int edad = escaner();
		
		print("");
		print("Desea comprar productos o administrar tiendas: ");
		print(" 1.Comprar productos");
		print(" 2.Administrar tiendas");
		print("");
		System.out.print("Seleccione una: ");
		int decision=escaner(2);
		Persona persona;
		if (decision==1) {
			persona = new Cliente(nombre,p,edad,genero1);
		}
		else {
			persona = new Administrador(nombre,p,edad,genero1);
		}
		lineas();
		print("");
		System.out.println("Usuario creado con exito ");
		System.out.println(" Bienvenido "+nombre);
		print("");
		return persona;
	}

}
