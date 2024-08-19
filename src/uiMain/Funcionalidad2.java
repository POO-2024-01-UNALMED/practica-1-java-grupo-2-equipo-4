package uiMain;
import java.util.ArrayList;

import java.util.Scanner;

import gestorAplicación.servicios.Producto;
import gestorAplicación.servicios.Tienda;
import gestorAplicación.servicios.Enums.Categoria;
import gestorAplicación.servicios.Pasillo;
import gestorAplicación.sujetos.Cliente;
import static uiMain.Main.print;
import static uiMain.Main.escaner;
import static uiMain.Main.lineas;

public class Funcionalidad2 extends Identidad {
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
		for(int i=0;i<mayorM+mayorN+mayorP+30;i++) {
			System.out.print("-");
		}
		print("");
		int contador=1;
		for (Producto p:productos.subList(inferior, superior)) {
			int cantidad=cliente.getTienda().cantidadProducto(p);
			System.out.print(""+contador+".");
			System.out.println(Tienda.imprimirProducto(mayorN,mayorM,mayorP,mayorC,cantidad,p));
			contador++;
		}
		
		for(int i=0;i<mayorM+mayorN+mayorP+30;i++) {
			System.out.print("-");
		}
		print("");
		print("");
		print(" 1/2/3/4/Texto. ¿Desea alguno de estos productos?, si es asi escojalo");
		System.out.println(" 5. Si desea volver escriba 5");
		if (superior>4) {
			print(" [A] pag. Si desea imprimir los 4 productos anteriores, escriba A");
		}
		if (productos.size()-superior>0) {
			System.out.println(" [S] pag. Si desea imprimir los 4 proximos productos, escriba S");
		}
		print("");
		System.out.print("¿Que desea realizar?: ");
	}
	
	public static Producto impresionSeleccionCategoria(Cliente cliente,ArrayList<Producto> productos,Categoria categoria, boolean malSeleccionado) {
		int inferior=0;
		int superior=4;
		Producto seleccionado = null;
		while(true) {
			if ((productos.size()-superior)<0) {
				superior=superior-(superior-productos.size());
			}
			if (!malSeleccionado) {
			cuadriculaProductos(cliente,productos,inferior,superior);
			}
			String seleccion=sc.nextLine();
			malSeleccionado=false;
			boolean texto=false;
			int numero=0;
			try{
				numero = Integer.parseInt(seleccion);
			}
			catch(Exception e) {
				texto=true;
			}
			if(texto) {
				for(Producto k:productos) {
					if (k.getNombre().toLowerCase().equals(seleccion.toLowerCase())) {
						seleccionado=k;
					}
				}
				if (seleccion.toLowerCase().equals("s")) {	
					inferior=superior;
					superior+=4;
					continue;
				}
				if (seleccion.toLowerCase().equals("a")) {	
					superior=inferior;
					inferior=superior-4;
					continue;
				}
				if (seleccionado==null) {
					print("");
					System.out.println("Este producto no se encuentra: ");
					print(" 1. Desea copiar otra opcion");
					print(" 2. Desea mirar si puede pedir reabastecer el producto");
					System.out.print("Escoja una opcion: ");
					malSeleccionado=true;
					continue;
				}
			}
			else switch(numero) {
			case 1:
				seleccionado=productos.get(numero+inferior-1);
				break;
			case 2:
				seleccionado=productos.get(numero+inferior-1);
				break;
			case 3:
				seleccionado=productos.get(numero+inferior-1);
				break;
			case 4:
				seleccionado=productos.get(numero+inferior-1);
				break;
			case 5:
				busquedaCategoria(cliente, categoria, productos, seleccionado);
				break;
			default:
				print("Ese numero esta fuera del rango");
				System.out.print("Introduzca otro numero: ");
				malSeleccionado=true;
				impresionSeleccionCategoria(cliente,productos,categoria,malSeleccionado);
				break;
			}	
			return seleccionado;
		}
	}
	
	public static Producto impresionSeleccionNombre(Cliente cliente,ArrayList<Producto> productos,Producto seleccionado) {
		int inferior=0;
		int superior=4;
		boolean malSeleccionado=false;
		while(true) {
			if ((productos.size()-superior)<0) {
				superior=superior-(superior-productos.size());
			}
			if (!malSeleccionado) {
			cuadriculaProductos(cliente,productos,inferior,superior);
			}
			malSeleccionado=false;
			String seleccion=sc.nextLine();
			boolean texto=false;
			int numero=0;
			try{
				numero = Integer.parseInt(seleccion);
			}
			catch(Exception e) {
				texto=true;
			}
			if(texto) {
				for(Producto k:productos) {
					if (k.getNombre().toLowerCase().equals(seleccion.toLowerCase())) {
						seleccionado=k;
					}
				}
				if (seleccion.toLowerCase().equals("s")) {	
					inferior=superior;
					superior+=4;
					continue;
				}
				if (seleccion.toLowerCase().equals("a")) {	
					superior=inferior;
					inferior=superior-4;
					continue;
				}
				if (seleccionado==null) {
					print("");
					System.out.print("Este producto no se encuentra, escriba otro o selecione otra opcion: ");
					malSeleccionado=true;
					continue;
				}
			}
			else switch(numero) {
			case 1:
				seleccionado=productos.get(numero+inferior-1);
				break;
			case 2:
				seleccionado=productos.get(numero+inferior-1);
				break;
			case 3:
				seleccionado=productos.get(numero+inferior-1);
				break;
			case 4:
				seleccionado=productos.get(numero+inferior-1);
				break;
			case 5:
				busquedaNombre(cliente, productos, seleccionado);
				break;
			}	
			return seleccionado;
		}
	}
	
	
	
	
	public static void busquedaCategoria(Cliente cliente, Categoria categoria, ArrayList<Producto> productos, Producto seleccionado) {
		//Impresion de categorias para luego ser escogidas por el cliente con escaner
		//Esta hace que se cree una lista con los productos de la tienda con esa categoria
		lineas();
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
			elegirTipoBusqueda();
		}
		categoria=Categoria.resolverEnum(decisionCategoria);
		productos=new ArrayList<Producto>();
		productos= cliente.getTienda().buscarProductos(cliente,categoria,productos);
		while (productos.size()==0) {
			print("No hay productos disponibles de esa categoria, escoja otro por favor");
			System.out.print("Escoja un numero nuevamente: ");
			decisionCategoria=escaner(enumerado);
			if(decisionCategoria==enumerado) {
				elegirTipoBusqueda();
			}
			categoria=Categoria.resolverEnum(decisionCategoria);
			productos=new ArrayList<Producto>();
			productos= cliente.getTienda().buscarProductos(cliente,categoria,productos);
		}
		boolean malSeleccionado=false;
		seleccionado = impresionSeleccionCategoria(cliente,productos,categoria,malSeleccionado);
		lineas();
		dondeSeAgreganProductos(cliente, seleccionado);
	}
	

	public static void busquedaNombre(Cliente cliente, ArrayList<Producto> productos, Producto seleccionado) {
		lineas();
		System.out.print("Introduzca el nombre del producto que desea buscar\n"
				+ "O escoja [3]. [Volver] para regresar: ");
		String nombre=sc.nextLine();
		int number;
		boolean string=true;
		try{
			number = Integer.parseInt(nombre);
		}
		catch(Exception e) {
			string=false;
		}
		if (string) {
			if (Integer.parseInt(nombre)==3) {
				elegirTipoBusqueda();
			}
		}
		if (nombre.toLowerCase().equals("volver")) {
			elegirTipoBusqueda();
		}
		productos=new ArrayList<Producto>();
		productos=cliente.getTienda().buscarProductos(cliente,nombre);
		while (productos.size()==0) {
			print("No hay productos disponibles con ese nombre, escoja otro por favor");
			System.out.print("Introduzca otro nombre: ");
			nombre=sc.nextLine();
			number=0;
			string=true;
			try{
				number = Integer.parseInt(nombre);
			}
			catch(Exception e) {
				string=false;
			}
			if (string) {
				if (Integer.parseInt(nombre)==3) {
					elegirTipoBusqueda();
				}
			}
			if (nombre.toLowerCase().equals("volver")) {
				elegirTipoBusqueda();
			}
			productos=new ArrayList<Producto>();
			productos=cliente.getTienda().buscarProductos(cliente,nombre);
		}
		seleccionado = impresionSeleccionNombre(cliente,productos, seleccionado);
		dondeSeAgreganProductos(cliente, seleccionado);
	}
	
	public static void dondeSeAgreganProductos(Cliente cliente, Producto seleccionado) {
		print("¿Cuantos productos de este quiere usted?");
		print("");
		System.out.print("Introduzca una cantidad de productos: ");
		int cantidad=escaner();
		StringBuilder resultado= cliente.getCarrito().agregarAlCarrito(seleccionado, cantidad);
		print("");
		System.out.println(resultado);
		boolean contieneProductosNoAgregados = resultado.indexOf("Productos no agregados") != -1;
        boolean contieneProductosSuficientes = resultado.indexOf("productos suficientes") != -1;
        if (contieneProductosNoAgregados && contieneProductosSuficientes) {
            print("Desea recibir la cantidad de productos que tenemos o desea mejor escoger otro");
            print("1. Recibir la cantidad que tienen");
            print("2. Escojer otro producto nuevamente");
            int decision=escaner(2);
            switch(decision) {
            case 1:
            	cliente.getCarrito().agregarAlCarrito(seleccionado,seleccionado.cantidadProducto());
            	break;
            case 2:
            	elegirTipoBusqueda();
            	break;
            }
        }
	}
	
	// Método auxiliar para ajustar el texto al ancho de la celda, cortando si es necesario
				private static String ajustarTexto(String texto, int anchoCelda) {
				    if (texto.length() > anchoCelda) {
				        return texto.substring(0, anchoCelda - 1) + ".";
				    } else {
				        return texto;
				    }
				}
	
	public static void elegirTipoBusqueda() {
		Cliente cliente=(Cliente)identificarPersona();
		Tienda tienda=cliente.getTienda();
		if(tienda==null) {
			lineas();
			print("Deberia seleccionar una tienda primero, dirijase a la funcionalidad 1");
			print("1. Ir a la funcionalidad 1");
			print("2. Ver el menu para escoger otra funcionalidad");
			System.out.print("Escoja una opcion: ");
			int decision=escaner(2);
			switch(decision) {
			case 1:
				Funcionalidad1.consultasEco();
				break;
			case 2:
				Main.escogerFuncionalidad();
				break;
			}

		}
		lineas();
		print("La busqueda de nuestra tienda es lo mas accesible para nuestros clientes, desea buscar por"
				+ "\n"+ "una categoria o por nombre del producto: ");
		print("");
		print(" 1. Por categoria de un producto");
		print(" 2. Por nombre del producto");
		print(" 3. Pedir productos no actuales");
		if (cliente.getCarrito().getProductos().size()>0) {
			print(" 4. Eliminar un producto de mi carrito");
		}
		print(" 5. Volver");
		print("");
		
		System.out.print("Escoja un numero: ");
		
		int decision=escaner(5);
		Categoria categoria = null;
		ArrayList<Producto> productos=new ArrayList<Producto>();
		Producto seleccionado = null;
		switch (decision) {
		case 1:
			busquedaCategoria(cliente, categoria, productos, seleccionado);
			break;
		case 2:
			busquedaNombre(cliente, productos,seleccionado);
			break;
		case 3:
			print("Estas son las categorias de los productos de nuestras tiendas: ");
			print("");
			int enumerado = 1;
			for(Categoria tipo:Categoria.values()) {
					print(" "+enumerado +". "+tipo.getTexto());
					enumerado++;			
			}
			print(" "+enumerado+". Volver");
			print("");
			System.out.print("Escoja cual desea para pedir productos: ");
			int decisionCategoria = escaner(enumerado);
			if(decisionCategoria==enumerado) {
				elegirTipoBusqueda();
			}
			categoria=Categoria.resolverEnum(decisionCategoria);
			ArrayList<Producto> posiblepeticion=cliente.getTienda().productosNoActuales(categoria);
			System.out.println(posiblepeticion);
			print("+--------------------------------------------+");
			print("| No. |      Nombre de Producto/Tamaño       |");
			print("+--------------------------------------------+");
			int anchoCelda = 34; 
			for (int i = 0; i < posiblepeticion.size(); i++) {
				String nombreProducto = posiblepeticion.get(i).getNombre();
			        String tamañoProducto = posiblepeticion.get(i).getTamaño().getTamaño();
			        String nombreYtamaño = nombreProducto + "/" + tamañoProducto;
			        
			        int espacios = (anchoCelda - nombreYtamaño.length()) / 2;

			        // Relleno a izquierda y derecha para centrar el nombre y tamaño del producto
			        String paddingIzquierdo = " ".repeat(Math.max(0, espacios));
			        String paddingDerecho = " ".repeat(Math.max(0, espacios + (anchoCelda - nombreYtamaño.length()) % 2));

			        print(String.format("| %-3d |%s%s%s|", i + 1, paddingIzquierdo, nombreYtamaño, paddingDerecho));
			}
			print("+--------------------------------------------+");

		case 4:
			if(cliente.getCarrito().getProductos().size()==0) {
				print("Usted no puede seleccionar esta opcion");
				elegirTipoBusqueda();
				break;
			}
			print("Estos son los productos de su carrito");
			productos=cliente.getCarrito().getProductos();
			
			    // Ancho total de la tabla ajustado para las nuevas columnas
			    int anchoCeldaNombre = 20;
			    int anchoCeldaMarca = 15;
			    int anchoCeldaTamaño = 10;
			    int anchoCeldaPrecio = 10;
			    int anchoCeldaCantidad = 10;
			    
			    // Encabezado de la tabla
			    print("+----+--------------------+---------------+----------+----------+----------+");
			    print("| No | Nombre              | Marca         | Tamaño   | Precio   | Cantidad |");
			    print("+----+--------------------+---------------+----------+----------+----------+");
			    
			    for (int i = 0; i < productos.size(); i++) {
			        Producto producto = productos.get(i);
			        String nombreProducto = producto.getNombre();
			        String marcaProducto = producto.getMarca();
			        String tamañoProducto = producto.getTamaño().getTamaño();
			        String precioProducto = String.format("%.2f", producto.getPrecio()); // Precio formateado a dos decimales
			        String cantidadProducto = String.valueOf(cliente.getCarrito().contarRepeticiones(producto));

			        // Imprimir cada producto en la tabla
			        print(String.format("| %-2d | %-18s | %-13s | %-8s | %-8s | %-8s |", 
			            i + 1, 
			            ajustarTexto(nombreProducto, anchoCeldaNombre), 
			            ajustarTexto(marcaProducto, anchoCeldaMarca), 
			            ajustarTexto(tamañoProducto, anchoCeldaTamaño), 
			            ajustarTexto(precioProducto, anchoCeldaPrecio), 
			            ajustarTexto(cantidadProducto, anchoCeldaCantidad)
			        ));
			    }

			    // Pie de la tabla
			    print("+----+--------------------+---------------+----------+----------+----------+");
			  
			
		case 5:
			Main.escogerFuncionalidad();
			break;
		}
	}
}
