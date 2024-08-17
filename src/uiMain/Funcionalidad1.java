package uiMain;

import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicación.sujetos.Cliente;
import gestorAplicación.sujetos.Persona;
import gestorAplicación.servicios.Producto;
import gestorAplicación.servicios.Tienda;
import gestorAplicación.servicios.Enums.Categoria;

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

    public static void consultasEco(Cliente cliente) {
    	Persona identidad=identificarPersona();
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
                consultaPorCategoria();
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

    public static void consultaGeneralProductos() {
        if (Tienda.buscarTienda()) {
            ArrayList<Tienda> tiendas = Tienda.revisionTienda(Tienda.getTiendas());
            printTablaTiendas(tiendas);
        } else {
            print("Lo sentimos, no hay tiendas disponibles en este momento.");
        }
    }

    public static void consultaPorCategoria() {
        if (Tienda.buscarTienda()) {
            print("Selecciona una de las categorías disponibles en nuestras tiendas:");
            int contador = 1;

            for (Categoria tipo : Categoria.values()) {
                print(contador + "." + tipo);
                contador++;
            }

            int categoriaSeleccionada = escaner(Categoria.values().length);

            ArrayList<Tienda> tiendas = busquedaCategoria(categoriaSeleccionada);
            if (tiendas != null && !tiendas.isEmpty()) {
                printTablaTiendas(tiendas);
                
                print("Selecciona una tienda:");
                int tiendaSeleccionada = escaner(tiendas.size());
                Tienda tienda = tiendas.get(tiendaSeleccionada - 1);
                print("Has seleccionado la tienda: " + tienda.getNombre());
                listaProductos(tienda);
            } else {
                print("No hay tiendas disponibles para la categoría seleccionada.");
            }
        } else {
            print("Lo sentimos, no hay tiendas disponibles en este momento.");
        }
    }

    public static void consultaMembresias() {
        if (Tienda.buscarTienda()) {
            print("Consulta de membresías:");
            // Aquí puedes agregar la lógica para manejar la consulta de membresías.
        } else {
            print("Lo sentimos, no hay tiendas disponibles en este momento.");
        }
    }

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

    public static void listaProductos(Tienda tienda) {
        ArrayList<Producto> productos = tienda.obtenerTodosLosProductos();
        if (productos.size() > 0) {
            printTablaProductos(productos);
        } else {
            print("No hay productos disponibles en esta tienda.");
        }
    }

    // Método para imprimir las tiendas en formato tabla ASCII
    public static void printTablaTiendas(ArrayList<Tienda> tiendas) {
        print("+------------------------------------+");
        print("| No. |          Nombre de Tienda    |");
        print("+------------------------------------+");
        for (int i = 0; i < tiendas.size(); i++) {
            String numero = String.format("| %-3d", i + 1);
            String nombre = String.format("| %-28s |", tiendas.get(i).getNombre());
            print(numero + nombre);
        }
        print("+------------------------------------+");
    }

    // Método para imprimir los productos en formato tabla ASCII
    public static void printTablaProductos(ArrayList<Producto> productos) {
        print("+------------------------------------+");
        print("| No. |         Nombre de Producto   |");
        print("+------------------------------------+");
        for (int i = 0; i < productos.size(); i++) {
            String numero = String.format("| %-3d", i + 1);
            String nombre = String.format("| %-28s |", productos.get(i).getNombre());
            print(numero + nombre);
        }
        print("+------------------------------------+");
    }
    
    // Método para imprimir las categorias en formato tabla ASCII
    public static void printTablaCategorias() {
        print("+--------------------------+");
        print("| No. |    Categoría        |");
        print("+--------------------------+");
        int contador = 1;
        for (Categoria categoria : Categoria.values()) {
            print(String.format("| %-3d | %-20s |", contador, categoria.toString()));
            contador++;
        }
        print("+--------------------------+");
    }
}
