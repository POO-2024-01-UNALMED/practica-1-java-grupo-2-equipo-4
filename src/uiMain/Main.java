package uiMain;
import static uiMain.Main.print;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import baseDatos.Deserializador;
import baseDatos.Serializador;
import gestorAplicación.servicios.*;
import gestorAplicación.servicios.Enums.Categoria;
import gestorAplicación.servicios.Enums.Tamaño;
import gestorAplicación.sujetos.Cliente;
import gestorAplicación.sujetos.*;

public class Main {
	public static void print(String p) {
		System.out.println(p);
	}
	
	public static void lineas() {
		for (int i=0;i<160;i++) {
			System.out.print("-");
		}
		print("");
	}
	public static Scanner sc = new Scanner(System.in);
	public static int escaner() {
		int p;
		try{
			p=sc.nextInt();
		}
		catch(Exception e) {
			print("Este no es un numero valido");
			System.out.print(" Introduzca otro numero: ");
			sc.nextLine();
			p=escaner();
		}
		return p;
	}
	
	public static int escaner(int rango) {
		int p;
		try{
			p=sc.nextInt();
		}
		catch(Exception e) {
			print("Este no es un numero valido");
			System.out.print(" Introduzca otro numero: ");
			sc.nextLine();
			p=escaner(rango);
		}
		if (p<1 || p>rango) {
			print("Este numero esta fuera del rango");
			System.out.print(" Introduzca otro numero: ");
			sc.nextLine();
			p=escaner(rango);
		}
		return p;
	}
	
	public static ArrayList<Producto> ser;
	static int [] numeros = {1,2,3,4,5,6};
	static int decision;
//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args){
		Tienda tienda= new Tienda("apilipona");
		Cliente cliente = new Cliente(); 
		Producto producto = new Producto("Cebolla","Cebollando",0,Categoria.ALIMENTO,tienda,"13/08/2024",1);
		producto.setTamaño(Tamaño.GRANDE);
		Producto producto12 = new Producto("Cebolla","marquita1",0,Categoria.ALIMENTO,tienda,"13/08/2024",0);
		Producto producto13 = new Producto("Cebolla","marquita2",0,Categoria.ALIMENTO,tienda,"13/08/2024",-1);
		Producto producto14 = new Producto("Cebolla","marquita3",0,Categoria.ALIMENTO,tienda,"13/08/2024",-2);
		//Crear Empleados
				Empleado juan =new Domiciliario();
				Empleado pepe =new Domiciliario();
				Empleado maria =new Domiciliario();
				Empleado pedro =new Domiciliario();
				ArrayList<Empleado> duo1= new ArrayList<Empleado>();
				ArrayList<Empleado> duo2= new ArrayList<Empleado>();
				duo1.add(juan);
				duo1.add(pepe);
				duo2.add(maria);
				duo2.add(pedro);
				//Crear Pasillos
				Pasillo p1 = new Pasillo("A7",Categoria.ALIMENTO);
				Pasillo p2 = new Pasillo("A8",Categoria.BEBIDA);
				Pasillo p3 = new Pasillo("A9",Categoria.LIMPIEZA);
				Pasillo p4 = new Pasillo("A2",Categoria.PERSONAL);
				Pasillo p5 = new Pasillo("A7",Categoria.HOGAR);
				Pasillo p6 = new Pasillo("A7",Categoria.ELECTRONICO);
				
				// Crear Productos para cada categoria
				Producto producto1 = new Producto("Pan",null,0, Categoria.ALIMENTO,2);
				Producto producto2 = new Producto("Leche", Categoria.BEBIDA);
				Producto producto3 = new Producto("Detergente", Categoria.LIMPIEZA);
				Producto producto4 = new Producto("Shampoo", Categoria.PERSONAL);
				Producto producto5 = new Producto("Mesa", Categoria.HOGAR);
				Producto producto6 = new Producto("Televisor", Categoria.ELECTRONICO);
				Producto producto7 = new Producto("Café", Categoria.BEBIDA);
				Producto producto8 = new Producto("Manzana",null,0, Categoria.ALIMENTO,3);
				Producto producto9 = new Producto("Jabón", Categoria.PERSONAL);
				Producto producto10 = new Producto("Escoba", Categoria.LIMPIEZA);
				// Crear listas para cada categoría
				ArrayList<Producto> alimentos = new ArrayList<Producto>();
				ArrayList<Producto> bebidas = new ArrayList<Producto>();
				ArrayList<Producto> limpieza = new ArrayList<Producto>();
				ArrayList<Producto> personal = new ArrayList<Producto>();
				ArrayList<Producto> hogar = new ArrayList<Producto>();
				ArrayList<Producto> electronico = new ArrayList<Producto>();

				// Agregar productos a las listas correspondientes
				alimentos.add(producto1);
				alimentos.add(producto8);

				bebidas.add(producto2);
				bebidas.add(producto7);

				limpieza.add(producto3);
				limpieza.add(producto10);

				personal.add(producto4);
				personal.add(producto9);

				hogar.add(producto5);

				electronico.add(producto6);
				
				// Asignar las listas de productos a los pasillos correspondientes
				p1.setProductos(alimentos);      // Pasillo A7 - Alimentos
				p2.setProductos(bebidas);        // Pasillo A8 - Bebidas
				p3.setProductos(limpieza);       // Pasillo A9 - Limpieza
				p4.setProductos(personal);       // Pasillo A2 - Productos de cuidado personal
				p5.setProductos(hogar);          // Pasillo A7 - Hogar
				p6.setProductos(electronico);    // Pasillo A7 - Electrónicos

				//Crear Tiendas
				Tienda t1 = new Tienda();
				Tienda t2= new Tienda();
				Tienda t3 = new Tienda();
				Tienda t4 = new Tienda();
				
				//Nombrar Tiendas y agregar pasillos y Empleados
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
				
				t1.setEmpleados(duo1);
				t2.setEmpleados(duo2);
				t3.setEmpleados(duo1);
		cliente.setTienda(tienda);
		tienda.getPasillos().add(p1);
		tienda.agregarProducto(producto, "A7");
		tienda.agregarProducto(producto12, "A7");
		tienda.agregarProducto(producto13, "A7");
		tienda.agregarProducto(producto14, "A7");
		ArrayList<Tienda> tiendas=new ArrayList<>();
		tiendas.add(t1);
		tiendas.add(t2);
		tiendas.add(t3);
		tiendas.add(t4);
//		Serializador.serializar(tiendas);
		escogerFuncionalidad(cliente);
		Proveedor pro=new Proveedor("Colanta", electronico, Categoria.ALIMENTO, t3, null);
		Proveedor pro2=new Proveedor("Alqueria", bebidas, Categoria.BEBIDA, t3, null);
		ArrayList<Tienda> tiendas1=new ArrayList<>();
		tiendas1.add(t1);
		tiendas1.add(t2);
		tiendas1.add(t3);
//		Serializador.serializar(tiendas1);
	}
	
	public static void escogerFuncionalidad(Cliente cliente) {
		do{
			boolean boleano=false;
			lineas();
			print("""
				    ________________________
				   /                        \\
				  /                          \\
				 /____________________________\\
				 |  ______   ______   ______  |
				 | |      | |      | |      | |
				 | |  []  | |  []  | |  []  | |   My_Tiendita
				 | |______| |______| |______| |
				 |                            |
				 |            ____            |
				 |           |    |           |
				 |___________|____|___________|
				    """);
			lineas();
			print("Bienvenido a My_Tiendita, ¿que desea hacer?");
			print("");
			print(" 1. Ecosistema de Consultas Personalizadas\n"
					+ " 2. Escoger productos\n"
					+ " 3. Pagar recibos pendientes\n"
					+ " 4. \n"
					+ " 5. Personalizar y modificar tiendas\n"
					+ " 6. Terminar");
			print("");
			System.out.print("Escoja un numero: ");
			while (!boleano){
				try{
					decision=sc.nextInt();
				}
				catch(Exception e) {
					print(" Este no es un numero valido");
					System.out.print(" Introduzca otro numero: ");
					sc.nextLine();
					continue;
				}
				for (int i:numeros){
					 if (decision==i){
					        boleano=true;
					 }
				}
				if (boleano==false){
					 print(" El numero esta fuera del rango");
					 System.out.print(" Introduzca otro numero: ");
					 continue;
				}
			}
			switch(decision){
			case 1:
				Funcionalidad1.consultasEco(cliente);
				break;
			case 2:
				Funcionalidad2.elegirTipoBusqueda(cliente);
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				Funcionalidad5.personalizarTienda(cliente);
				break;
			case 6:
//				Serializador.serializar();
				print("Ha salido del programa");
				break;
			}
		 } while (decision!=6);

		}
	

	
	
	
//Lo de abajo es codigo funcionalidad 2----------------------------------------------------------------------
	public static void mostrarProductos(){
		// buscar por nombre o categoria 
		// arrays
		//En esta parte del metodo se hace la impresion de las categorias
		//Luego el usuario escogera una de las categorias para luego 
		//buscar si existen productos con esa categoria
		int enumerado = 1;
		for(Categoria tipo:Categoria.values()) {
				print(enumerado +"."+tipo );
				enumerado++;			
		}
		sc.nextInt();
		int desicionCategoria = sc.nextInt();
		switch(desicionCategoria){
		case 1:			
			if (Tienda.categoriaTienda(Categoria.ALIMENTO).size() > 0) {
				print("Estas tiendas tienen tu categoria");
				ArrayList<Tienda> tiendas= new ArrayList<Tienda>();
				//Serializador.serializar(tiendas);
				Deserializador.deserializar();
				System.out.print(Tienda.getTiendas());
				print("en cual Tienda desea consultar?");
				enumerado=1;
				for(Tienda alimento:Tienda.categoriaTienda(Categoria.ALIMENTO)) {
					print(enumerado+"."+alimento.getNombre());
					enumerado++;					
				} 
				
				int desicionTienda = sc.nextInt();				
				for (int i=1; i<= Tienda.categoriaTienda(Categoria.ALIMENTO).size();i++) {
					if (desicionTienda==i) {
						Tienda tiendaDisp =Tienda.categoriaTienda(Categoria.ALIMENTO).get(desicionTienda-1);
						print("Productos disponibles categoria: ALIMENTO");
						int cont = 1;
						ArrayList<Producto> productos= new ArrayList<>();
						for(Pasillo j:tiendaDisp.getPasillos()) {
							if(j.getCategoria()==Categoria.ALIMENTO) {								
								for(Producto producto:j.getProductos()) {
									print(cont+ ". " + producto.getNombre());
									productos.add(producto);
									cont++;
									}								
								}
							print("Consultar:");
							int desicionProducto = sc.nextInt();
							for (int p=1; i<= productos.size();p++) {
								if (desicionProducto==p) {
									print("Nombre del producto:"+productos.get(p-1).getNombre());
									break;
									}
								}// fusionar 
							} break;
						}
					}
				
				
				break;	
			}
			
			else { 
					print("No hay tiendas disponibles de la categoria ALIMENTO.");
					print("1.Buscar otra categoria");
					print("2.Volver");
					decision = sc.nextInt();
					if (decision == 1) {
					mostrarProductos();
					break;
					}
					else { 
						break;
						}
			}
				
			
		case 2:
			if (Tienda.categoriaTienda(Categoria.BEBIDA).size() > 0) {
				print("Estas tiendas tienen tu categoria deseada en cual deseas visitar:");
				enumerado=1;
				for(Tienda bebida:Tienda.categoriaTienda(Categoria.BEBIDA)) {
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
			if (Tienda.categoriaTienda(Categoria.LIMPIEZA).size() > 0) {
				print("Estas tiendas tienen tu categoria deseada en cual deseas visitar:");
				enumerado=1;
				for(Tienda limpieza:Tienda.categoriaTienda(Categoria.LIMPIEZA)) {
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
			if (Tienda.categoriaTienda(Categoria.PERSONAL).size() > 0) {
				print("Estas tiendas tienen tu categoria deseada en cual deseas visitar:");
				enumerado=1;
				for(Tienda personal:Tienda.categoriaTienda(Categoria.PERSONAL)) {
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
			if (Tienda.categoriaTienda(Categoria.HOGAR).size() > 0) {
				print("Estas tiendas tienen tu categoria deseada en cual deseas visitar:");
				enumerado=1;
				for(Tienda hogar:Tienda.categoriaTienda(Categoria.HOGAR)) {
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
			if (Tienda.categoriaTienda(Categoria.ELECTRONICO).size() > 0) {
				print("Estas tiendas tienen tu categoria deseada en cual deseas visitar:");
				enumerado=1;
				for(Tienda electronico:Tienda.categoriaTienda(Categoria.ELECTRONICO)) {
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
// ----- FUNCIONALIDAD 2 ---------------------------------------------------------------------------------
	
	
	
//------------Metodo a revisar donde meterlo-----------------------------------------------------------------------------
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
			Tienda.buscarTienda(Categoria.ALIMENTO);
		case 5:
			Tienda.buscarTienda(Categoria.HOGAR);
		case 6:
			Tienda.buscarTienda(Categoria.ELECTRONICO);
		}
		
		
	}
	
	// ------ FUNCINALIDAD 3 ---------------------------------------
	public static void pagarRecibo(){
		String nombre= sc.nextLine();
		nombre = nombre.toLowerCase();
		int existencia= Cliente.existeCliente(nombre);
		if (existencia==-1) {
			System.out.println("Esta persona nunca ha comprado aca");
			System.out.println("Desea buscar por otro nombre? [Y/N]");
			String buscar= sc.nextLine();
			buscar= buscar.toLowerCase();
			switch(buscar) {
			case "y":
				pagarRecibo();
			case "n":
				break;
			}
		}
		for (Carrito i:Cliente.getClientes().get(existencia).getFacturas()) {
			
		}
}
	
	// ----- FUNCIONALIDAD 4 ---------------------------------------------------
	public static void func4(){
		// prueba
	}
	
	//----- FUNCIONALIDAD 5 ----------------------------------------------------
	public static void PersonalizarTienda(){
		//funcionalidad 5
	}

}
