package uiMain;

import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicación.sujetos.Cliente;
import gestorAplicación.sujetos.Persona;
import gestorAplicación.servicios.Producto;
import gestorAplicación.servicios.Tienda;
import gestorAplicación.servicios.Enums.Categoria;
import gestorAplicación.servicios.Enums.Edades;

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
                consultaGeneralProductos();
                break;
            case 2:
                consultaPorCategoria(cliente);
                break;
            case 3:
                consultaMembresias();
                break;
            case 4:
                Main.escogerFuncionalidad(cliente);
                break;
            default:
                print("Opción no válida");
        }
    }
    
 // ---------------------------------------------------------------------------------------------------------------------------------------------------

    public static void consultaGeneralProductos() {
        if (Tienda.buscarTienda()) {
            ArrayList<Tienda> tiendas = Tienda.revisionTienda(Tienda.getTiendas());
            printTablaTiendas(tiendas);
        } else {
            print("Lo sentimos, no hay tiendas disponibles en este momento.");
        }
    }
    
    
 // ---------------------------------------------------------------------------------------------------------------------------------------------------

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
                    print("Has seleccionado la tienda: " + tienda.getNombre());
                    mostrarProductosPorEdad(tienda,cliente);
                }
            } else {
                print("No hay tiendas disponibles para la categoría seleccionada.");
            }
        } else {
        	print("Lo sentimos, no hay tiendas disponibles en este momento.");
        }
              
    }

 // ---------------------------------------------------------------------------------------------------------------------------------------------------

    public static void consultaMembresias() {
        if (Tienda.buscarTienda()) {
            print("Consulta de membresías:");
            // Aquí puedes agregar la lógica para manejar la consulta de membresías.
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

    public static void listaProductos(Tienda tienda) {
        ArrayList<Producto> productos = tienda.obtenerTodosLosProductos();
        if (productos.size() > 0) {
            printTablaProductos(productos);
        } else {
            print("No hay productos disponibles en esta tienda.");
        }
    }
 // ---------------------------------------------------------------------------------------------------------------------------------------------------
    public static void mostrarProductosPorEdad(Tienda tienda, Cliente cliente) {
    	
        ArrayList<Producto> productos = tienda.obtenerTodosLosProductos();
        ArrayList<Producto> productosAdecuados = Producto.filtrarPorEdad(productos, cliente);
        
        // Verificar si hay productos disponibles para la edad del cliente
        if (productosAdecuados.size()==0) {
            print("No hay productos disponibles para " + (cliente.mayorEdad() ? "adultos" : "menores de edad") + " en esta tienda.");
            print("¿Desea volver a elegir otra tienda?");
            print("1. Sí");
            print("2. No");
            print("");
            
            int seleccion = escaner(2);
            if (seleccion == 1) {
                consultaPorCategoria(cliente); // Volver a seleccionar otra tienda
            } else {
                consultasEco(); // Regresar al menú de opciones
            }
        } else {
            printTablaProductos(productosAdecuados);
            print("¿Desea volver a elegir otra tienda?");
            print("1. Sí");
            print("2. No");
            print("");
            
            int seleccion = escaner(2);
            if (seleccion == 1) {
                consultaPorCategoria(cliente); // Volver a seleccionar otra tienda
            } else {
                consultasEco(); // Regresar al menú de opciones
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
    
}
