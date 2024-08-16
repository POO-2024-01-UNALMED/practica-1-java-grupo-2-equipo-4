package uiMain;
import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicación.servicios.Producto;
import gestorAplicación.servicios.Tienda;
import gestorAplicación.servicios.Enums.Categoria;
import gestorAplicación.sujetos.Cliente;

import static uiMain.Main.print;
import static uiMain.Main.escaner;
import static uiMain.Main.lineas;

public class Funcionalidad2 {
	static Scanner sc = new Scanner(System.in);
	
	public static void cuadriculaProductos(Cliente cliente,ArrayList<Producto> productos, int inferior, int superior) {
		//Imprimira el nombre, la marca, precio, cantidad y fecha(al pendiente), los numeros que se encuentran
		//Son para hacer una separacion y centrados de cada uno
		lineas();
		int mayorN=0;
		int mayorM=0;
		int mayorP=0;
		for (Producto p:productos.subList(inferior, superior)) {
			if(p.getNombre()!=null) {
				if (mayorN<p.getNombre().length()) {
					mayorN=p.getNombre().length();
					}
			}
			if (p.getMarca()!=null) {
				if(p.getTamaño()!=null) {
					if (mayorM<p.getMarca().length()+p.getTamaño().getTamaño().length()+1) {
						mayorM=p.getMarca().length()+p.getTamaño().getTamaño().length()+1;
				}
				}
				if (mayorM<p.getMarca().length()) {
					mayorM=p.getMarca().length();
				}
			}
			if (mayorP<(""+p.getPrecio()).length()) {
				mayorP=(""+p.getPrecio()).length();
			}
		}
		if (mayorN<6) {
			mayorN=6;
		}
		if (mayorM<12) {
			mayorM=12;
		}
		if (mayorP<6) {
			mayorP=6;
		}
		
		int mayorC=8;
		print("");
		for(int i=0;i<mayorM+mayorN+mayorP+30;i++) {
			System.out.print("-");
		}
		print("");
		System.out.print("    ");
		System.out.print("Nombre");
		for(int i=0;i<mayorN-4;i++) {
		System.out.print(" ");
		}
		System.out.print("|  ");
		System.out.print("Marca/Tamaño");
		for(int i=0;i<mayorM-10;i++) {
			System.out.print(" ");
		}
		System.out.print("|  ");
		System.out.print("Precio");
		for(int i=0;i<mayorP-4;i++) {
			System.out.print(" ");
		}
		System.out.print("|  ");
		System.out.print("Cantidad  ");
		
		print("|");
		for (Producto p:productos.subList(inferior, superior)) {
			int cantidad=cliente.getTienda().cantidadProducto(p);
			System.out.println(Tienda.imprimirProducto(mayorN,mayorM,mayorP,mayorC,cantidad,p));
		}
		
		for(int i=0;i<mayorM+mayorN+mayorP+30;i++) {
			System.out.print("-");
		}
		print("");
		
		Funcionalidad2.impresionSeleccion(cliente,productos);
	}
	
	public static void impresionSeleccion(Cliente cliente,ArrayList<Producto> productos) {
		int contador=1;
		int tamañoLista=productos.size();
		
		for (Producto p:productos) {
			int cantidad=cliente.getTienda().cantidadProducto(p);
			System.out.print(""+contador+".");
			contador++;
			if (contador%5==0) {
				for(int i=0;i<mayorM+mayorN+mayorP+30;i++) {
					System.out.print("-");
				}
				print("");
				print(" 1/2/3/4/Texto. ¿Desea alguno de estos productos?, si es asi escojalo");
				System.out.println(" 5. Si desea volver escriba 5");
				System.out.println(" Y. Si desea imprimir los 4 proximos productos, escriba Y");
				print("");
				System.out.print("¿Que desea realizar?: ");
				String seleccion=sc.nextLine();
				boolean texto=false;
				int numero=0;
				Producto seleccionado;
				try{
					numero = Integer.parseInt(seleccion);
				}
				catch(Exception e) {
					texto=true;
				}
				
				if(texto) {
					if (seleccion.toLowerCase()=="y") {
						contador=1;	
						continue;
					}
					for(Producto k:productos) {
						if (k.getNombre().toLowerCase()==seleccion.toLowerCase()) {
							seleccionado=k;
						}
					}
				}
				else switch(numero) {
				case 1:
					seleccionado=productos.get(numero);
				case 2:
					seleccionado=productos.get(numero);
				case 3:
					seleccionado=productos.get(numero);
				case 4:
					seleccionado=productos.get(numero);
				case 5:
					elegirTipoBusqueda(cliente);
				}
				
			}
		}
	}
	public static void elegirTipoBusqueda(Cliente cliente) {
		lineas();
		print("La busqueda de nuestra tienda es lo mas accesible para nuestros clientes, desea buscar por"
				+ "\n"+ "una categoria o por nombre del producto: ");
		print("");
		print(" 1. Por categoria de un producto");
		print(" 2. Por nombre del producto");
		print(" 3. Volver");
		print("");
		
		System.out.print("Escoja un numero: ");
		
		int decision=escaner(3);
		Categoria categoria = null;
		lineas();
		switch (decision) {
		case 1:
			
			//Impresion de categorias para luego ser escogidas por el cliente con escaner
			//Esta hace que se cree una lista con los productos de la tienda con esa categoria
			print("Estas son las categorias de los productos de nuestras tiendas: ");
			print("");
			int enumerado = 1;
			for(Categoria tipo:Categoria.values()) {
					print(" "+enumerado +". "+tipo.getTexto());
					enumerado++;			
			}
			print(" "+enumerado+". Volver");
			print("");
			System.out.print("Escoja un numero: ");
			int decisionCategoria = escaner(enumerado);
			if(decisionCategoria==enumerado) {
				elegirTipoBusqueda(cliente);
			}
			categoria=Categoria.resolverEnum(decisionCategoria);
			ArrayList<Producto> productos=new ArrayList<Producto>();
			productos= Tienda.buscarProductos(cliente,categoria,productos);
			impresionSeleccion(cliente,productos);
			
		case 2:
			print("");
			print("Introduzca el nombre del producto que desea buscar: ");
			sc.nextLine();
			String nombre=sc.nextLine();
			Tienda.buscarProductos(nombre);
		case 3:
			Main.escogerFuncionalidad(cliente);
		}
	}
}
