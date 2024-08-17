package uiMain;
import java.util.ArrayList;
import java.util.Scanner;

import baseDatos.Deserializador;
import gestorAplicación.servicios.Tienda;
import gestorAplicación.sujetos.Cliente;
import gestorAplicación.servicios.Enums.Categoria;

import static uiMain.Main.print;
import static uiMain.Main.escaner;

public class Funcionalidad5 {
	static Scanner sc = new Scanner(System.in);
	
	public static void personalizarTienda(Cliente clien) {
		print("Ha seleccionado Personalizar y modificar tiendas.");
		Deserializador.deserializar(0);
		if (Tienda.buscarTienda()) {
            print("Selecciona una de las tiendas disponibles para ti:");
            int contador = 1;
            for (Tienda generales : Tienda.revisionTienda(Tienda.getTiendas())) {
                System.out.println(contador + ". " + generales.getNombre());
                contador++;
            }
		}
		int h =escaner();
		Tienda tien =Tienda.getTiendas().get(h-1);
		float diferencia=(float) (clien.getDinero()-tien.getSaldo());
		if(diferencia>=0) {
			tien.setDueño(clien);
			clien.setDinero(diferencia);
		}
      	int i=1;
      	while(true){
      		print("que categorias tendra el pasillo "+i+"?");
      		int n=1;
      		for(Categoria j:Categoria.values()) {
      			print(n+"."+j);
      			n++;
      		}
      		int x2=escaner();
      		print("nombre del pasillo "+i+":");
      		String nom=sc.nextLine();
      		tien.añadirPasillo(x2,nom);
      		print("pasillo creado");
      		i++;
	  		print("1.Continuar\n2.Terminar");
	  		int x3=escaner();
	  		if(x3!=1) {
	  			break;
	  		}
      	}
      	
      	if ((tien.disponibilidadProductos()==false)) {
      		print(tien.getDueño().getNombre() +"de la tienda"+tien.getNombre()+ ", sus pasillos estan vacios ");
      		print("desea llamar a un proveedor?\n1.Si\n2.No");
      	}
  		int x3=escaner();
  		if(x3==1) {
  			System.out.println(tien.getProveedores());
  			print(tien.llamarProveedor());
  		}
  		print("desea contratar empleados?\n1.Si\n2.No");
  		int x4=escaner();
  		if(x4==1) {
  			int j=1;
  	      	while(true){
  	      		print("qué tipo de empleado necesita que sea el 1empleado"+j+"?");
  	      		String[] ems={"Domiciliario","Concerje","Cajero"};
  	      		int n=1;
  	      		for(String e:ems) {
  	      			print(n+"."+e);
  	      			n++;
  	      		}
  	      		int x5=escaner();
  	      		tien.contratarEmpleados(x5);
  	      		System.out.print(tien.getEmpleados());
  	      		i++;
  	      		print("1.Continuar\n2.Terminar");
  	      		int x6=escaner();
  	      		if(x6!=1) {
  	      			break;
  	      		}
  		}
  		
  		
  	}
}
}
