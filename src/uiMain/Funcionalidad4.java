package uiMain;

import uiMain.Main;
import java.util.ArrayList;
import java.util.Scanner;
import gestorAplicación.servicios.Producto;
import gestorAplicación.servicios.Tienda;
import gestorAplicación.servicios.Enums.Categoria;
import gestorAplicación.sujetos.Cliente;
import static uiMain.Main.print;
import static uiMain.Main.escaner;

public class Funcionalidad4 {	
	    public static void main() {
	    	System.out.println("------------------ REVISION DE TIENDA -----------------");
	    	System.out.println("seleccione una opcion");
	    	System.out.println("1.Total de productos en el inventario\n"
					+ "2. Productos para vencer\n"
					+ "3. Marcar producto como defectuoso\n"
					+ "4. Reabastecimiento\n");
	    	
	        int opcion = Main.sc.nextInt();
	        switch (opcion) {
	            case 1:
	                System.out.println("Opción 1 seleccionada");
	                break;
	            default:
	                System.out.println("Opción no válida");
	                break;
	        }
	    }
	}

