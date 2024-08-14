package uiMain;
import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicación.servicios.Producto;
import gestorAplicación.servicios.Tienda;
import gestorAplicación.servicios.Enums.Categoria;
import gestorAplicación.sujetos.Cliente;

import static uiMain.Main.print;
import static uiMain.Main.escaner;

public class Funcionalidad2 {
	static Scanner sc = new Scanner(System.in);
	public static void elegirTipoBusqueda(Cliente cliente) {
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
		print("");
		switch (decision) {
		case 1:
			
			//Impresion de categorias para luego ser escogidas por el cliente con escaner
			//Esta hace que se cree una lista con los productos de la tienda con esa categoria
			print("Estas son las categorias de los productos de nuestras tiendas: ");
			int enumerado = 1;
			for(Categoria tipo:Categoria.values()) {
					print(" "+enumerado +". "+tipo.getTexto());
					enumerado++;			
			}
			print(" "+enumerado+". Volver");
			print("");
			System.out.print("Escoja un numero: ");
			int decisionCategoria = escaner(enumerado);
			categoria=Categoria.resolverEnum(decisionCategoria);
			ArrayList<Producto> productos=new ArrayList<Producto>();
			productos= Tienda.buscarProductos(cliente,categoria,productos);
			
			//Imprimira el nombre, la marca, precio, cantidad y fecha(al pendiente), los numeros que se encuentran
			//Son para hacer una separacion y centrados de cada uno
			int mayorN=0;
			int mayorM=0;
			int mayorP=0;
			for (Producto p:productos) {
				if(p.getNombre()!=null) {
					if (mayorN<p.getNombre().length()) {
						mayorN=p.getNombre().length();
						}
				}
				if (p.getMarca()!=null) {
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
			if (mayorM<5) {
				mayorM=5;
			}
			if (mayorP<6) {
				mayorP=6;
			}
			
			int mayorC=8;
			
			System.out.print("  ");
			System.out.print("Nombre");
			for(int i=0;i<mayorN-4;i++) {
			System.out.print(" ");
			}
			System.out.print("|  ");
			System.out.print("Marca");
			for(int i=0;i<mayorM-3;i++) {
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
			
			for(int i=0;i<mayorM+mayorN+mayorP+28;i++) {
				System.out.print("-");
			}
			print("");
			
			int contador=0;
			for (Producto p:productos) {
				System.out.println(Tienda.imprimirProducto(mayorN,mayorM,mayorP,p));
				contador++;
				if (contador%4==0) {
					
				}
			}
			for(int i=0;i<mayorM+mayorN+mayorP+28;i++) {
				System.out.print("-");
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
