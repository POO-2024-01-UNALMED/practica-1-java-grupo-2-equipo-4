package uiMain;
import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicación.Cliente;
import gestorAplicación.Producto;
import gestorAplicación.Tienda;
import gestorAplicación.Enums.Categoria;
import static uiMain.Main.print;
import static uiMain.Main.escaner;

public class Funcionalidad2 {
	static Scanner sc = new Scanner(System.in);
	public static void elegirTipoBusqueda(Cliente cliente) {
		print("La busqueda de nuestra tienda es lo mas accesible para nuestros clientes, desea buscar por"
				+ "\n"+ "una categoria o por nombre del producto: ");
		print("1. Por categoria de un producto");
		print("2. Por nombre del producto");
		print("3. Volver");
		int decision=escaner(3);
		Categoria categoria = null;
		switch (decision) {
		case 1:
			print("Estas son las categorias de los productos de nuestras tiendas: ");
			int enumerado = 1;
			for(Categoria tipo:Categoria.values()) {
					print(enumerado +". "+tipo);
					enumerado++;			
			}
			print(enumerado+". Volver");
			int decisionCategoria = escaner();;
			categoria=Categoria.resolverEnum(decisionCategoria);
			ArrayList<Producto> productos=new ArrayList<Producto>();
			productos= Tienda.buscarProductos(cliente,categoria,productos);
			for (Producto p:productos) {
				System.out.println(p);
			}		
		case 2:
			print("Introduzca el nombre del producto que desea buscar: ");
			sc.nextLine();
			String nombre=sc.nextLine();
			Tienda.buscarProductos(nombre);
		case 3:
			Main.escogerFuncionalidad(cliente);
		}
	}
}
