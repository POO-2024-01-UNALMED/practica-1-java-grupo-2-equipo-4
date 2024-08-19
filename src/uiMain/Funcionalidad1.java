package uiMain;

import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicación.sujetos.Cliente;
import gestorAplicación.sujetos.Persona;
import gestorAplicación.servicios.Producto;
import gestorAplicación.servicios.Tienda;
import gestorAplicación.servicios.Enums.Categoria;
import gestorAplicación.servicios.Enums.Edades;
import static uiMain.Main.lineas;

public class Funcionalidad1 extends Identidad{
	
	//Simplemente para imprimir más fácil （￣︶￣）↗　
    public static void print(String p) {
        System.out.println(p);
    }
    
    //Implementación de scanner para hacer el proceso más fácil y verificar las entradas

    static Scanner sc = new Scanner(System.in);

    public static int escaner() {
        int p;
        try {
            p = sc.nextInt();
        } catch (Exception e) {
            print("Este no es un número válido");
            sc.nextLine();
            p = escaner();
        }
        return p;
    }

    public static int escaner(int rango) {
        int p;
        try {
            p = sc.nextInt();
        } catch (Exception e) {
            print("Este no es un número válido");
            sc.nextLine();
            p = escaner(rango);
        }
        if (p < 1 || p > rango) {
            print("Este número está fuera del rango");
            sc.nextLine();
            p = escaner(rango);
        }
        return p;
    }
 // ---------------------------------------------------------------------------------------------------------------------------------------------------

    //Este método se encarga de direccionar al cliente hacia la consulta que desea realizar 
    public static void consultasEco() {
    	Cliente cliente= (Cliente)Identidad.identificarPersona();
    	lineas();
        print("Ha seleccionado Ecosistema de Consultas Personalizadas. Elija una opción:");
        print("1. Consulta general de productos\n" +
              "2. Consulta de productos por categoría\n" +
              "3. Consulta de membresías\n" +
              "4. Volver");
        print("");
        print("Escoja un número: ");

        int consulta = escaner(4); // Usando escaner con rango para asegurar la entrada correcta.

        print("Opción seleccionada: " + consulta);

        switch (consulta) {
            case 1:
                consultaGeneralProductos(cliente);
                break;
            case 2:
                consultaPorCategoria(cliente);
                break;
            case 3:
                consultaMembresias(cliente);
                break;
            case 4:
                Main.escogerFuncionalidad();
                break;
            default:
                print("Opción no válida");
        }
    }
    
 // ---------------------------------------------------------------------------------------------------------------------------------------------------
    //Este método permite al cliente realizar una consulta general de productos en las tiendas disponibles,
    //seleccionando una tienda para explorar los productos o regresar al menú principal.
    public static void consultaGeneralProductos(Cliente cliente) {
        if (Tienda.buscarTienda()) {
        	print("Selecciona una de las tiendas que tenemos disponibles para ti" );
            ArrayList<Tienda> tiendas = Tienda.revisionTienda(Tienda.getTiendas());
            printTablaTiendas(tiendas);
            print("Selecciona una tienda:");
            int tiendaSeleccionada = escaner(tiendas.size() + 1); 

            if (tiendaSeleccionada == tiendas.size() + 1) { // Verificar si la opción seleccionada es "Volver"
                consultasEco();
            } else {
                Tienda tienda = tiendas.get(tiendaSeleccionada - 1);
                Cliente.asignaciones(cliente,tienda);
                print("Has seleccionado la tienda: " + tienda.getNombre());
                print("Esta servira para escoger productos en la funcionalidad 2");
                print("1. Desea chismosear la descripcion de productos en la tienda");
                print("2. Desea ir al menu principal para empezar a hacer sus compras");
                print("3. Volver a escoger tienda");
                int decision=escaner(3);
                switch(decision) {
                case 1:
                	seleccionarProducto(listaProductos(tienda,cliente,null),cliente);
                	break;
                case 2:
                	Main.escogerFuncionalidad();
                	break;
                case 3:
                	consultasEco();
                	break;
                }
            }
            
        } else {
            print("Lo sentimos, no hay tiendas disponibles en este momento.");
        }
    }
    
    
 // ---------------------------------------------------------------------------------------------------------------------------------------------------
    //Este método permite al cliente consultar las categorías de productos disponibles en las tiendas, seleccionar una tienda 
    //y realizar acciones adicionales, como explorar los productos de esa tienda o regresar al menú principal.
    public static void consultaPorCategoria(Cliente cliente) {
        if (Tienda.buscarTienda()) {
            print("Selecciona una de las categorías disponibles en nuestras tiendas:");
            printTablaCategorias();

            int categoriaSeleccionada = escaner(Categoria.values().length);

            ArrayList<Tienda> tiendas = busquedaCategoria(categoriaSeleccionada);
            if (tiendas != null && !tiendas.isEmpty()) {
                printTablaTiendas(tiendas);
                
                print("Selecciona una tienda:");
                int tiendaSeleccionada = escaner(tiendas.size() + 1); 

                if (tiendaSeleccionada == tiendas.size() + 1) { // Verificar si la opción seleccionada es "Volver"
                    consultasEco();
                } else {
                    Tienda tienda = tiendas.get(tiendaSeleccionada - 1);
                    Cliente.asignaciones(cliente,tienda);
                    print("Has seleccionado la tienda: " + tienda.getNombre());
                    print("Esta servira para escoger productos en la funcionalidad 2");
                    print("1. Desea chismosear la descripcion de productos en la tienda");
                    print("2. Desea ir al menu principal para empezar a hacer sus compras");
                    print("3. Volver a escoger tienda");
                    int decision=escaner(3);
                    switch(decision) {
                    case 1:
                    	seleccionarProducto(listaProductos(tienda,cliente,Categoria.values()[categoriaSeleccionada - 1]),cliente);
                    	break;
                    case 2:
                    	Main.escogerFuncionalidad();
                    	break;
                    case 3:
                    	consultasEco();
                    	break;
                  
                    }
                }
            } else {
                print("No hay tiendas disponibles para la categoría seleccionada.");
            }
        } else {
        	print("Lo sentimos, no hay tiendas disponibles en este momento.");
        }
              
    }

 // ---------------------------------------------------------------------------------------------------------------------------------------------------
    //Comentario 
    public static void consultaMembresias(Cliente cliente) {
        if (Tienda.buscarTienda()) {
            print("Consulta de membresías:");
            
        } else {
            print("Lo sentimos, no hay tiendas disponibles en este momento.");
        }
    }

 // ---------------------------------------------------------------------------------------------------------------------------------------------------
    //Este método se encarga de revisar si hay tiendas para la categoría seleccionada para esto llama a un método en tienda 
    //que te entrega la lista de las tiendas que pertenecen a la categoría a buscar.
    public static ArrayList<Tienda> busquedaCategoria(int categoria) {
        Categoria cat = Categoria.values()[categoria - 1];
        ArrayList<Tienda> tiendas = Tienda.categoriaTienda(cat);

        if (tiendas.size() > 0) {
            print("Estas tiendas tienen tu categoría");
        } else {
            print("No hay tiendas disponibles de la categoría " + cat + ".");
        }
        return tiendas;
    }

 // ---------------------------------------------------------------------------------------------------------------------------------------------------
    /*Este método obtiene y filtra los productos disponibles en una tienda específica,
      basándose en la edad del cliente y en una categoría opcional. Si la categoría es 
      nula, se filtrarán los productos solo por la edad del cliente. Si se proporciona
      una categoría, se filtrarán los productos por edad y categoría.*/
    public static  ArrayList<Producto> listaProductos(Tienda tienda, Cliente cliente, Categoria categoria) {
        ArrayList<Producto> productos = tienda.obtenerTodosLosProductos();
        ArrayList<Producto> productosAdecuados;
        
        

        if (categoria == null) {
            // Si no se proporciona una categoría, filtrar solo por edad
            productosAdecuados = Producto.filtrarPorEdad(productos, cliente);
            
        } else {
            // Si se proporciona una categoría, filtrar por edad y categoría
            productosAdecuados = Producto.filtrarPorEdadYCategoria(productos, cliente, categoria);
        }
        
        
        
        if (productosAdecuados.size() > 0) {
        	 printTablaProductos(productosAdecuados);
            return productosAdecuados;
        } else {
            print("No hay productos disponibles para su grupo de edad" +
                  (categoria != null ? " en esta categoría." : "."));
            
        }

        print("");
        print("Desea elegir otra tienda?");
        print("1. Sí");
        print("2. No");
        int opcion = escaner(2);

        if (opcion == 1) {
            consultaPorCategoria(cliente);
            return null;
        } else {
            consultasEco();
            return null;
        }
    }

 // --------------------------------------------------------------------------------------------------------------------------------------------------- 
   /* Este método permite al cliente seleccionar un producto de una lista proporcionada para ver sus detalles.
      Después de mostrar los detalles del producto, se le da la opción de elegir otro producto o regresar al menú principal.*/ 
    public static void seleccionarProducto(ArrayList<Producto> productos,Cliente cliente) {
        print("Seleccione un producto para ver sus detalles:");
        
        int seleccionProducto = escaner(8);
        if(seleccionProducto== productos.size()+1 ) {
        	printTablaProductos(productos);
        	seleccionarProducto(productos,cliente);
        }
        else {
        // Obtener el producto seleccionado
        Producto productoSeleccionado = productos.get(seleccionProducto - 1);

        // Mostrar detalles del producto en tabla ASCII
        printDetallesProducto(productoSeleccionado);
        
        // Volver al menú de consultas después de mostrar los detalles
        print("¿Desea elegir otro producto?");
        print("1. Sí");
        print("2. No");

        int opcion = escaner(2);

        if (opcion == 1) {
            seleccionarProducto(productos,cliente); // Volver a elegir otro producto
        } else {
        	Main.escogerFuncionalidad(); // Regresar al menú principal
        }
        }
    }

 // ---------------------------------------------------------------------------------------------------------------------------------------------------
    // Método para imprimir las tiendas en formato tabla ASCII
    public static void printTablaTiendas(ArrayList<Tienda> tiendas) {
        print("+------------------------------------+");
        print("| No. |       Nombre de Tienda       |");
        print("+------------------------------------+");

        int anchoCelda = 28; // Ancho de la celda para el nombre de la tienda

        for (int i = 0; i < tiendas.size(); i++) {
            String nombreTienda = tiendas.get(i).getNombre();
            int espacios = (anchoCelda - nombreTienda.length()) / 2;

            // Relleno a izquierda y derecha para centrar el nombre de la tienda
            String paddingIzquierdo = " ".repeat(Math.max(0, espacios));
            String paddingDerecho = " ".repeat(Math.max(0, espacios + (anchoCelda - nombreTienda.length()) % 2));

            print(String.format("| %-3d |%s%s%s|", i + 1, paddingIzquierdo, nombreTienda, paddingDerecho));
        }
        int numeroVolver = tiendas.size() + 1;
        String opcionVolver = "Volver";
        int espaciosVolver = (anchoCelda - opcionVolver.length()) / 2;
        String paddingIzquierdoVolver = " ".repeat(Math.max(0, espaciosVolver));
        String paddingDerechoVolver = " ".repeat(Math.max(0, espaciosVolver + (anchoCelda - opcionVolver.length()) % 2));

        print(String.format("| %-3d |%s%s%s|", numeroVolver, paddingIzquierdoVolver, opcionVolver, paddingDerechoVolver));
        print("+------------------------------------+");
    }

 // ---------------------------------------------------------------------------------------------------------------------------------------------------

    // Método para imprimir los productos en formato tabla ASCII
    public static void printTablaProductos(ArrayList<Producto> productos) {
        print("+------------------------------------+");
        print("| No. |      Nombre de Producto      |");
        print("+------------------------------------+");

        int anchoCelda = 28; // Ancho de la celda para el nombre del producto
        for (int i = 0; i < productos.size(); i++) {
            String nombreProducto = productos.get(i).getNombre();
            int espacios = (anchoCelda - nombreProducto.length()) / 2;

            // Relleno a izquierda y derecha para centrar el nombre del producto
            String paddingIzquierdo = " ".repeat(Math.max(0, espacios));
            String paddingDerecho = " ".repeat(Math.max(0, espacios + (anchoCelda - nombreProducto.length()) % 2));

            print(String.format("| %-3d |%s%s%s|", i + 1, paddingIzquierdo, nombreProducto, paddingDerecho));
        
        }
        int numeroVolver = productos.size() + 1;
        String opcionVolver = "Volver";
        int espaciosVolver = (anchoCelda - opcionVolver.length()) / 2;
        String paddingIzquierdoVolver = " ".repeat(Math.max(0, espaciosVolver));
        String paddingDerechoVolver = " ".repeat(Math.max(0, espaciosVolver + (anchoCelda - opcionVolver.length()) % 2));

        print(String.format("| %-3d |%s%s%s|", numeroVolver, paddingIzquierdoVolver, opcionVolver, paddingDerechoVolver));
        print("+------------------------------------+");
    }

 // ---------------------------------------------------------------------------------------------------------------------------------------------------
   
    // Método para imprimir las categorias en formato tabla ASCII
    public static void printTablaCategorias() {
        print("+--------------------------+");
        print("| No. |      Categoría     |");
        print("+--------------------------+");
        int anchoCelda = 20; // Ancho de la celda para la categoría
        int contador = 1;
        for (Categoria categoria : Categoria.values()) {
            String categoriaTexto = categoria.toString();
            int espacios = (anchoCelda - categoriaTexto.length()) / 2;
            
            // Si la longitud es impar, añade un espacio adicional al final
            String paddingIzquierdo = " ".repeat(Math.max(0, espacios));
            String paddingDerecho = " ".repeat(Math.max(0, espacios + (anchoCelda - categoriaTexto.length()) % 2));
            
            print(String.format("| %-3d |%s%s%s|", contador, paddingIzquierdo, categoriaTexto, paddingDerecho));
            contador++;
        }
        print("+--------------------------+");
        
    }
 // ---------------------------------------------------------------------------------------------------------------------------------------------------
    
	 // Método para imprimir los detalles del producto en formato tabla ASCII
	    public static void printDetallesProducto(Producto producto) {
	    	int anchoTabla = 44; 

	        // Crea la tabla con formato
	        print("+--------------------------------------------+");
	        print("|            Detalles del Producto           |");
	        print("+--------------------------------------------+");
	        print("  Nombre:        " + ajustarTexto(producto.getNombre(), anchoTabla ));
	        print("  Marca:         " + ajustarTexto(producto.getMarca(), anchoTabla ));
	        print("  Precio:        $" + String.format("%.2f", producto.getPrecio())); 
	        print("  Descripción:   " + ajustarTexto(producto.getDescripcion(), anchoTabla) );
	        print("  Tamaño:        " + ajustarTexto(producto.getTamaño().toString(),anchoTabla));
	        print("+--------------------------------------------+");
	    }
	    
	    public static String ajustarTexto(String texto, int ancho) {
	        if (texto.length() > ancho) {
	            return texto.substring(0, ancho - 3) + "..."; // Acorta el texto si es demasiado largo
	        } else {
	            return texto + " ".repeat(ancho - texto.length()); // Añade espacios para ajustar el texto
	        }
	    }
    
}
