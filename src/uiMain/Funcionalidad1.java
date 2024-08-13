package uiMain;

import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicación.sujetos.Cliente;
import gestorAplicación.servicios.Producto;
import gestorAplicación.servicios.Tienda;
import gestorAplicación.servicios.Enums.Categoria;

public class Funcionalidad1 {
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
		                Main.escogerFuncionalidad(cliente);
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
						int decision = 0;
						decision = sc.nextInt();
						if (decision == 1) {
						
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
		
}
