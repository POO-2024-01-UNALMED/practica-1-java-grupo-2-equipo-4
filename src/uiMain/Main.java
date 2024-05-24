package uiMain;
import java.util.Scanner;

import gestorAplicación.*;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void print(String p) {
		System.out.println(p);
	}
	
	static int [] numeros = {1,2,3,4,5,6};
	static int decision;
	
	public static void main(String[] args){
//-----------------------------------------------------------------------------------------------------------
	do{
		boolean boleano=false;
		print("Bienvenido a My_Tiendita, que desea hacer?");
		print("1.Mostrar productos disponibles segun categoria y tienda\n"
				+ "2.Realizar listas de compras\n"
				+ "3.Pagar recibos pendientes\n"
				+ "4. \n"
				+ "5.Personalizar y modificar tiendas\n"
				+ "6.Terminar");
		while (!boleano){
			try{
				decision=sc.nextInt();
			}
			catch(Exception e) {
				print("Este no es un numero valido");
				sc.nextLine();
			}
			for (int i:numeros){
				 if (decision==i){
				        boleano=true;
				 }
			}
			if (boleano==false){
				 print("El numero esta fuera del rango");
				 continue;
			}
		}
		switch(decision){
		case 1:
			mostrarProductos();
			break;
		case 2:
			realizarListaCompra();
		case 3:
		
		case 4:
			
		case 5:
		
		}
	 } while (decision!=6);

	}	
	// -------- FUNCIONALIDAD 1 ----------------------------------------------------------------
	public static void mostrarProductos(){
		print("Elige la categoria que desea buscar: ");
		int enumerado = 1;
		for(Categoria tipo:Categoria.values()) {
				print(enumerado +"."+tipo );
				enumerado++;
			
		}
		int desicionCategoria = sc.nextInt();
		switch(desicionCategoria){
		case 1:			
			if (Tienda.buscarTienda(Categoria.ALIMENTO).size() > 0) {
				print("Estas tiendas tienen tu categoria, en cual deseas comprar?:");
				enumerado=1;
				for(Tienda alimento:Tienda.buscarTienda(Categoria.ALIMENTO)) {
					print(enumerado+"."+alimento.getNombre());
					enumerado++;
				} 
			}
			else
				{ print("No hay tiendas disponibles de la categoria ALIMENTO.");
				print("1.Buscar otra categoria");
				print("2.Volver");
				int decision = sc.nextInt();
				if (decision == 1) {
				mostrarProductos();
				break;
				}else break;
			}
			
		
		case 2:
			if (Tienda.buscarTienda(Categoria.BEBIDA).size() > 0) {
				print("Estas tiendas tienen tu categoria deseada en cual deseas comprar:");
				enumerado=1;
				for(Tienda bebida:Tienda.buscarTienda(Categoria.BEBIDA)) {
					print(enumerado+"."+bebida.getNombre());
					enumerado++;
				} 
			}
			else
				{ print("No hay tiendas disponibles de la categoria ALIMENTO.");
				print("1.Buscar otra categoria");
				print("2.Volver");
				int decision = sc.nextInt();
				if (decision == 1) {
				mostrarProductos();
				break;
				}else break;
			}
			
		case 3:
			if (Tienda.buscarTienda(Categoria.LIMPIEZA).size() > 0) {
				print("Estas tiendas tienen tu categoria deseada en cual deseas comprar:");
				enumerado=1;
				for(Tienda limpieza:Tienda.buscarTienda(Categoria.LIMPIEZA)) {
					print(enumerado+"."+limpieza.getNombre());
					enumerado++;
				} 
			}
			else
				{ print("No hay tiendas disponibles de la categoria ALIMENTO.");
				print("1.Buscar otra categoria");
				print("2.Volver");
				int decision = sc.nextInt();
				if (decision == 1) {
				mostrarProductos();
				break;
				}else break;
			}
			
		case 4:
			if (Tienda.buscarTienda(Categoria.PERSONAL).size() > 0) {
				print("Estas tiendas tienen tu categoria deseada en cual deseas comprar:");
				enumerado=1;
				for(Tienda personal:Tienda.buscarTienda(Categoria.PERSONAL)) {
					print(enumerado+"."+personal.getNombre());
					enumerado++;
				} 
			}
			else
				{ print("No hay tiendas disponibles de la categoria ALIMENTO.");
				print("1.Buscar otra categoria");
				print("2.Volver");
				int decision = sc.nextInt();
				if (decision == 1) {
				mostrarProductos();
				break;
				}else break;
			}
			
		case 5:
			if (Tienda.buscarTienda(Categoria.HOGAR).size() > 0) {
				print("Estas tiendas tienen tu categoria deseada en cual deseas comprar:");
				enumerado=1;
				for(Tienda hogar:Tienda.buscarTienda(Categoria.HOGAR)) {
					print(enumerado+"."+hogar.getNombre());
					enumerado++;
				} 
				}else
				{ print("No hay tiendas disponibles de la categoria ALIMENTO.");
				print("1.Buscar otra categoria");
				print("2.Volver");
				int decision = sc.nextInt();
				if (decision == 1) {
				mostrarProductos();
				break;
				}else break;
			}
			
		case 6:
			if (Tienda.buscarTienda(Categoria.ELECTRONICO).size() > 0) {
				print("Estas tiendas tienen tu categoria deseada en cual deseas comprar:");
				enumerado=1;
				for(Tienda electronico:Tienda.buscarTienda(Categoria.ELECTRONICO)) {
					print(enumerado+"."+electronico.getNombre());
					enumerado++;
				} 
			}
			else
				{ print("No hay tiendas disponibles de la categoria ALIMENTO.");
				print("1.Buscar otra categoria");
				print("2.Volver");
				int decision = sc.nextInt();
				if (decision == 1) {
				mostrarProductos();
				break;
				}else break;
			}
			
		}
	}
	// ----- FUNCIONALIDAD 2 ----------------------------------------------------------------
	public static void realizarListaCompra(){
		print("Elegir categoria");
		int index=1;
		for(Categoria i:Categoria.values()) {
			print(index+"."+i);
			index+=1;
		}
		int decision =sc.nextInt();
		switch(decision){
		case 1:
			Tienda.buscarTienda(Categoria.ALIMENTO);
		case 2:
			Tienda.buscarTienda(Categoria.BEBIDA);
		case 3:
			Tienda.buscarTienda(Categoria.LIMPIEZA);
		case 4:
			Tienda.buscarTienda(Categoria.PERSONAL);
		case 5:
			Tienda.buscarTienda(Categoria.HOGAR);
		case 6:
			Tienda.buscarTienda(Categoria.ELECTRONICO);
		}
		
		
	}
	
	// ------ FUNCINALIDAD 3 ---------------------------------------
	public static void pagarRecibo(){
		//funcionalidad 3
	}
	
	// ----- FUNCIONALIDAD 4 ---------------------------------------------------
	public static void func4(){
		//funcionalidad 4
	}
	
	//----- FUNCIONALIDAD 5 ----------------------------------------------------
	public static void PersonalizarTienda(){
		//funcionalidad 5
	}
	
	
}
