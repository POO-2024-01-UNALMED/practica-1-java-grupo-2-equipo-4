package uiMain;
import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicación.servicios.Tienda;
import gestorAplicación.sujetos.Cliente;
import gestorAplicación.servicios.Enums.Categoria;

import static uiMain.Main.print;
import static uiMain.Main.escaner;
import static uiMain.Main.lineas;

public class Funcionalidad5 {
	static Scanner sc = new Scanner(System.in);
	
	public static void personalizarTienda(Cliente clien) {
		lineas();
		print("Ha seleccionado Personalizar y modificar tiendas.");
		print("Selecciona una de las tiendas disponibles para ti:");
		Funcionalidad1.printTablaTiendas(Tienda.getTiendas());
		int h =escaner();
		
		Tienda tien=Tienda.getTiendas().get(h-1);
		float diferencia=(float) (clien.getDinero()-tien.getSaldo());
		if(diferencia>=0) {
			tien.setDueño(clien);
			lineas();
			print("Has seleccionado la tienda: " + tien.getNombre());
			print("Se te resto $"+tien.getSaldo()+" de tu saldo");
			print("Ahora eres el dueño de la tienda: \""+tien.getNombre()+"\"");
			clien.setDinero(diferencia);
			print("Tu saldo ahora es de: $"+diferencia);
		}
		boolean iterar=true;
		while(iterar) {
			lineas();
			print("1.Desea reorganizar pasillos?");
			print("2.Desea llamar al proveedor?");
			print("3.Desea contratar empleados?");
			print("4.Salir de personalizar tienda");
			int decision = escaner();
			switch(decision) {
		        case 1:
		        	reorganizarPasillos(tien);
		        	break;
		        case 2:
		        	llamarProveedor(tien);
		        	break;
		        case 3:
		        	contratar(tien);
		        	break;
		        case 4:
		        	iterar=false;
		        	print("Ha salido de personalizar tienda");
		        	break;
		        default:
		        	print("Ese numero esta fuera del rango");
					print("Introduzca otro numero: ");
					break;
		        } 
			}
		}
		public static void reorganizarPasillos(Tienda tien) {
			lineas();
			int i=1;
			while(true){
				lineas();
				print("¿qué categorias tendra el pasillo "+i+"?");
				int n=1;
				for(Categoria j:Categoria.values()) {
					print(n+"."+j);
					n++;
				}
				int x2=escaner();
				lineas();
				print("nombre del pasillo numero "+i+":");
				String nom=sc.nextLine();
				
				tien.añadirPasillo(x2,nom);
				print("Pasillo añadido");
				
				lineas();
				print(tien.mostrarPasillos());
				i++;
				lineas();
				print("1.Continuar\n2.Terminar");
				int x3=escaner();
				if(x3!=1) {
					break;
				}
			}	
		}
      	
      	
  		
  		

	private static void llamarProveedor(Tienda tien) {
		// TODO Auto-generated method stub
		if ((tien.disponibilidadProductos()==true)) {
      		lineas();
      		print(tien.getDueño().getNombre() +" de la tienda: \""+tien.getNombre()+ "\", sus pasillos estan vacios ");
      		print("¿Desea llamar a un proveedor?\n1.Si\n2.No");
      		int x3=escaner();
      		if(x3==1) {
      			print(tien.listarProveedores());
      			int k=escaner();
      			print("Se han llenado los pasillos");
      			Funcionalidad4.printTablaProductos(tien.llamarProveedor(k));
      			
      		}
      	}
	}

	private static void contratar(Tienda tien) {
		// TODO Auto-generated method stub
		lineas();
  		print("¿Desea contratar empleados?\n1.Si\n2.No");
  		int x4=escaner();
  		if(x4==1) {
  			int j=1;
  	      	while(true){
  	      		lineas();
  	      		print("¿Qué tipo de empleado necesita que sea el empleado numero: "+j+"?");
  	      		String[] ems={"Domiciliario","Concerje","Cajero"};
  	      		int n=1;
  	      		for(String e:ems) {
  	      			print(n+"."+e);
  	      			n++;
  	      		}
  	      		int x5=escaner();
  	      		tien.contratarEmpleados(x5);
  	      		
  	      		System.out.println(tien.mostrarEmpleados());
  	      		System.out.println(tien.mostrarEmpleados());
  	      		j++;
  	      		print("1.Continuar\n2.Terminar");
  	      		int x6 = escaner();
  	      		if(x6!=1) {
  	      			break;
  	      		}
  		}
  		
  		
  	}
}
	}

