package uiMain;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import baseDatos.Deserializador;
import baseDatos.Serializador;
import gestorAplicación.servicios.*;
import gestorAplicación.servicios.Enums.Categoria;
import gestorAplicación.sujetos.Cliente;

public class Main {
	public static void print(String p) {
		System.out.println(p);
	}
	
	
	static Scanner sc = new Scanner(System.in);
	public static int escaner() {
		int p;
		try{
			p=sc.nextInt();
		}
		catch(Exception e) {
			print("Este no es un numero valido");
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
			sc.nextLine();
			p=escaner(rango);
		}
		if (p<1 || p>rango) {
			print("Este numero esta fuera del rango");
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
		Producto producto = new Producto("cebolla",Categoria.ALIMENTO,tienda,"13/08/2024");
		cliente.setTienda(tienda);
		escogerFuncionalidad(cliente);
	}
	
	public static void escogerFuncionalidad(Cliente cliente) {
		do{
			boolean boleano=false;
			print("Bienvenido a My_Tiendita, que desea hacer?");
			print("1. Ecosistema de Consultas Personalizadas\n"
					+ "2. Escoger productos\n"
					+ "3. Pagar recibos pendientes\n"
					+ "4. \n"
					+ "5. Personalizar y modificar tiendas\n"
					+ "6. Terminar");
			while (!boleano){
				try{
					decision=sc.nextInt();
				}
				catch(Exception e) {
					print("Este no es un numero valido");
					sc.nextLine();
					continue;
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
				consultasEco(cliente);
				break;
			case 2:
				Funcionalidad2.elegirTipoBusqueda(cliente);
			case 3:
			
			case 4:
				
			case 5:
			
			}
		 } while (decision!=6);

		}
	
// -------- FUNCIONALIDAD 1 ---------------------------------------------------------------------------------
	//Este método se encarga de presentar las opciones de consulta al usuario
	public static void consultasEco(Cliente cliente) {
	    int consulta = 0;

	    print("Ha seleccionado Ecosistema de Consultas Personalizadas. Elija una opción:");
	    print("1. Consulta general de productos\n" +
	                   "2. Consulta de productos por categoria\n" +
	                   "3. Consulta de membresias\n" +
	                   "4. Volver");

	    while (consulta < 1 || consulta > 4) {
	        try {
	            consulta = sc.nextInt();
	            
	            if (consulta < 1 || consulta > 4) {
	                print("Opción no válida. Por favor, ingrese un número entre 1 y 4.");
	                consulta = 0; 
	            }
	            sc.nextLine();
	        } catch (Exception e) {
	            print("Entrada no válida, por favor ingrese un número.");
	            sc.nextLine(); 
	        }
	    }

	    try {
	        print("Opción seleccionada: " + consulta);

	        switch (consulta) {
	            case 1:
	                if (Tienda.buscarTienda()) {
	                    print("Selecciona una de las tiendas disponibles para ti:");
	                    int contador = 1;
	                    for (Tienda generales : Tienda.revisionTienda(Tienda.getTiendas())) {
	                        System.out.println(contador + ". " + generales.getNombre());
	                        contador++;
	                    }
	                } else {
	                    print("Lo sentimos, no hay tiendas disponibles en este momento.");
	                }
	                break;

	            case 2:
	               
	            	  if (Tienda.buscarTienda()) {
		                    print("Selecciona una de las categorias disponibles en nuestras tiendas:");
		                    int contador = 1;
		            		for(Categoria tipo:Categoria.values()) {
		            				print(contador +"."+tipo );
		            				contador++;
		            		}
		            		busquedaCategoria(sc.nextInt());
		            		int opcion = sc.nextInt();
		                    Tienda tiendaSeleccionada = busquedaCategoria(sc.nextInt()).get(opcion - 1);
		                    print("Has seleccionado la tienda: " + tiendaSeleccionada.getNombre());
		                    listaProductos(tiendaSeleccionada);
		            		 sc.nextLine(); 
		                } 
	            	  	else {
		                    print("Lo sentimos, no hay tiendas disponibles en este momento.");
		                }
		                break;
	             

	            case 3:
	                if (Tienda.buscarTienda()) {
	                    print("Consulta de membresías:");
	                   
	                } else {
	                    print("Lo sentimos, no hay tiendas disponibles en este momento.");
	                }
	                break;

	            case 4:
	                escogerFuncionalidad(cliente);
	                break;

	            default:
	                print("Opción no válida");
	        }
	    } catch (Exception e) {
	        print("Entrada no válida, por favor ingrese otro número.");
	        sc.nextLine();
	    }
	}

	
	public static ArrayList <Tienda> busquedaCategoria(int categoria) {
		int desicionCategoria = categoria;
		switch(desicionCategoria){
		case 1:			
			if (Tienda.categoriaTienda(Categoria.ALIMENTO).size() > 0) {
				print("Estas tiendas tienen tu categoria");
				ArrayList<Tienda> tiendas= Tienda.categoriaTienda(Categoria.ALIMENTO);
				//Serializador.serializar(tiendas);
				//Deserializador.deserealizar();
				print("en cual Tienda desea consultar?");
				int enumerado=1;
				for(Tienda alimento:Tienda.categoriaTienda(Categoria.ALIMENTO)) {
					print(enumerado+"."+alimento.getNombre());
					enumerado++;
				return tiendas;
				}
				
				 
	               
	                
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
		}
		return null;	
		
	}
	
	public static void listaProductos(Tienda tienda) {
	    ArrayList<Producto> productos = tienda.obtenerTodosLosProductos();
	    print("Hola");
        if (productos.size() > 0) {
            print("Estos son los productos disponibles en la tienda:");
            int numProducto = 1;
            for (Producto producto : productos) {
                print(numProducto + ". " + producto.getNombre());
                numProducto++;
            }
        }
		
		
		
		
	}
	
	
	
	
//Lo de abajo es codigo funcionalidad 2----------------------------------------------------------------------
	public static void mostrarProductos(){
		// buscar por nombre o categoria 
		// arrays
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
				Deserializador.deserealizar();
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
		
	}
	
	//----- FUNCIONALIDAD 5 ----------------------------------------------------
	public static void PersonalizarTienda(){
		//funcionalidad 5
	}

}
