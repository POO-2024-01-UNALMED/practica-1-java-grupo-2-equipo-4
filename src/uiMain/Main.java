package uiMain;
import gestorAplicación.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static void print(String p) {
		
		System.out.println(p);
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
				print("Estas tiendas tienen tu categoria, en cual deseas visitar?:");
				enumerado=1;
				for(Tienda alimento:Tienda.buscarTienda(Categoria.ALIMENTO)) {
					print(enumerado+"."+alimento.getNombre());
					enumerado++;
					
				} 	
				break;	
			}
			
			else { 
					print("No hay tiendas disponibles de la categoria ALIMENTO.");
					print("1.Buscar otra categoria");
					print("2.Volver");
					int decision = sc.nextInt();
					if (decision == 1) {
					mostrarProductos();
					break;
					}
					else { 
						break;
						}
			}
				
			
		case 2:
			if (Tienda.buscarTienda(Categoria.BEBIDA).size() > 0) {
				print("Estas tiendas tienen tu categoria deseada en cual deseas visitar:");
				enumerado=1;
				for(Tienda bebida:Tienda.buscarTienda(Categoria.BEBIDA)) {
					print(enumerado+"."+bebida.getNombre());
					enumerado++;
				} 
				break;
			}

			else { 
					print("No hay tiendas disponibles de la categoria ALIMENTO.");
					print("1.Buscar otra categoria");
					print("2.Volver");
					int decision = sc.nextInt();
					if (decision == 1) {
					mostrarProductos();
					break;
					}
					else { 
						break;
						}
			}
				
			
		case 3:
			if (Tienda.buscarTienda(Categoria.LIMPIEZA).size() > 0) {
				print("Estas tiendas tienen tu categoria deseada en cual deseas visitar:");
				enumerado=1;
				for(Tienda limpieza:Tienda.buscarTienda(Categoria.LIMPIEZA)) {
					print(enumerado+"."+limpieza.getNombre());
					enumerado++;
				} 
				break;
			}

			else { 
					print("No hay tiendas disponibles de la categoria ALIMENTO.");
					print("1.Buscar otra categoria");
					print("2.Volver");
					int decision = sc.nextInt();
					if (decision == 1) {
					mostrarProductos();
					break;
					}
					else { 
						break;
						}
			}
				
			
		case 4:
			if (Tienda.buscarTienda(Categoria.PERSONAL).size() > 0) {
				print("Estas tiendas tienen tu categoria deseada en cual deseas visitar:");
				enumerado=1;
				for(Tienda personal:Tienda.buscarTienda(Categoria.PERSONAL)) {
					print(enumerado+"."+personal.getNombre());
					enumerado++;
				} 
				
				break;
			}

			else { 
					print("No hay tiendas disponibles de la categoria ALIMENTO.");
					print("1.Buscar otra categoria");
					print("2.Volver");
					int decision = sc.nextInt();
					if (decision == 1) {
					mostrarProductos();
					break;
					}
					else { 
						break;
						}
			}
				
			
		case 5:
			if (Tienda.buscarTienda(Categoria.HOGAR).size() > 0) {
				print("Estas tiendas tienen tu categoria deseada en cual deseas visitar:");
				enumerado=1;
				for(Tienda hogar:Tienda.buscarTienda(Categoria.HOGAR)) {
					print(enumerado+"."+hogar.getNombre());
					enumerado++;
				} 
				break;
				}

			else { 
					print("No hay tiendas disponibles de la categoria ALIMENTO.");
					print("1.Buscar otra categoria");
					print("2.Volver");
					int decision = sc.nextInt();
					if (decision == 1) {
					mostrarProductos();
					break;
					}
					else { 
						break;
						}
			}
				
			
		case 6:
			if (Tienda.buscarTienda(Categoria.ELECTRONICO).size() > 0) {
				print("Estas tiendas tienen tu categoria deseada en cual deseas visitar:");
				enumerado=1;
				for(Tienda electronico:Tienda.buscarTienda(Categoria.ELECTRONICO)) {
					print(enumerado+"."+electronico.getNombre());
					enumerado++;
				} 
			}

			else { 
					print("No hay tiendas disponibles de la categoria ALIMENTO.");
					print("1.Buscar otra categoria");
					print("2.Volver");
					int decision = sc.nextInt();
					if (decision == 1) {
					mostrarProductos();
					break;
					}
					else { 
						break;
						}
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
		//	ArrayList <Tienda> tiendaDisp = new ArrayList<>();
		//	tiendaDisp= Tienda.buscarTienda(Categoria.ALIMENTO);
			//print();
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
	
	static int [] numeros = {1,2,3,4,5,6};
	static int decision;
	
	public static void main(String[] args){
		Pasillo p1 = new Pasillo("A7",Categoria.ALIMENTO);
		Pasillo p2 = new Pasillo("A8",Categoria.BEBIDA);
		Pasillo p3 = new Pasillo("A9",Categoria.LIMPIEZA);
		Pasillo p4 = new Pasillo("A2",Categoria.PERSONAL);
		Pasillo p5 = new Pasillo("A7",Categoria.HOGAR);
		Pasillo p6 = new Pasillo("A7",Categoria.ELECTRONICO);

		Tienda t1 = new Tienda();
		Tienda t2= new Tienda();
		Tienda t3 = new Tienda();
		Tienda t4 = new Tienda();

		t1.setNombre("Donde Chucho");
		t2.setNombre("Los Paisitas");
		t3.setNombre("La esquina de Luis");
		t4.setNombre(" D1 ");

		t1.getPasillos().add(p1);
		t1.getPasillos().add(p2);
		t2.getPasillos().add(p2);
		t2.getPasillos().add(p3);
		t3.getPasillos().add(p3);
		t3.getPasillos().add(p4);
		t4.getPasillos().add(p4);
		t4.getPasillos().add(p5);
		t1.getPasillos().add(p5);
		t2.getPasillos().add(p6);
		t3.getPasillos().add(p1);
		t4.getPasillos().add(p2);
//-----------------------------------------------------------------------------------------------------------
	do{
		boolean boleano=false;
		print("Bienvenido a My_Tiendita, que desea hacer?");
		print("1.Consultar productos\n"
				+ "2.Realizar compra\n"
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
			ArrayList<Tienda> alimento=Tienda.buscarTienda(Categoria.ALIMENTO);
			print(Tienda.getTiendas()+"");
			print(alimento.size()+"");
			
		case 5:
		
		}
	 } while (decision!=6);

	}
}
