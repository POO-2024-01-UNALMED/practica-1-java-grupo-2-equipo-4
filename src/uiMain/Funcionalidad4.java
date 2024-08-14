package uiMain;
import uiMain.Main;
public class Funcionalidad4 {	
	    public static void main(String[] args) {
	    	System.out.println("------------------ REVISION DE TIENDA -----------------");
	    	System.out.println("seleccione una opcion");
	    	System.out.println("1.Total de productos en el inventario"
					+ "2. Escoger productos\n"
					+ "3. Pagar recibos pendientes\n"
					+ "4. \n"
					+ "5. Personalizar y modificar tiendas\n"
					+ "6. Terminar");
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

