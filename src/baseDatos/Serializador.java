package baseDatos;

import java.io.File;  
import java.io.FileOutputStream;  
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import gestorAplicación.servicios.*;
import gestorAplicación.servicios.Enums.Categoria;
import gestorAplicación.servicios.Enums.Edades;
import gestorAplicación.servicios.Enums.Tamaño;
import gestorAplicación.sujetos.Persona;

import java.io.IOException; 
import java.io.FileNotFoundException;

public class Serializador {
	private static File archivo = new File("");
	
	public static void serializar(ArrayList<? extends Object> lista, String nombre) {
		 try { 
			 FileOutputStream f = new FileOutputStream(new File(archivo.getAbsolutePath()+  "\\src\\baseDatos\\temp\\"+nombre+".txt"));
			 ObjectOutputStream o = new ObjectOutputStream(f);
			 o.writeObject(lista);
			 o.close(); f.close();
		 } catch (FileNotFoundException e) { 
			 e.printStackTrace();
			 
		 } catch (IOException e) { 
			 e.printStackTrace();
			 
		 	} 
		}
	public static void serializarTodo() {
		serializar(Tienda.getTiendas(),"tiendas");
		serializar(Tienda.getDesempleados(),"empleados");
		serializar(Proveedor.getSeisProveedores(),"proveedores");
		serializar(Persona.getPersonas(),"clientes");
		}
	public static void main(String[] args){
		Producto producto1 = new Producto(
		            "Leche Entera", "La Vaquita", 1.50, Tamaño.GRANDE, Edades.MENORES, Categoria.ALIMENTO,
		            "Leche entera de vaca, fortificada con vitaminas A y D.", "15/10/2024", 101
		        );
		Producto producto12 = new Producto(
		            "Leche Entera", "La Vaquita", 1.50, Tamaño.GRANDE, Edades.MENORES, Categoria.ALIMENTO,
		            "Leche entera de vaca, fortificada con vitaminas A y D.", "15/10/2024", 101
		        );
	        Producto producto13 = new Producto(
		            "Leche Entera", "La Vaquita", 1.50, Tamaño.GRANDE, Edades.MENORES, Categoria.ALIMENTO,
		            "Leche entera de vaca, fortificada con vitaminas A y D.", "15/10/2024", 101
		        );

	        Producto producto2 = new Producto(
	            "Pan Integral", "PanRico", 2.00, Tamaño.MEDIANO, Edades.MENORES, Categoria.ALIMENTO,
	            "Pan integral alto en fibra, ideal para una dieta saludable.", "22/08/2024", 102
	        );

	        Producto producto3 = new Producto(
	            "Yogur Natural", "BioLácteos", 3.25, Tamaño.MEDIANO, Edades.ADULTOS, Categoria.ALIMENTO,
	            "Yogur natural sin azúcar añadido, fuente de probióticos.", "10/09/2024", 103
	        );

	        Producto producto4 = new Producto(
	            "Queso Cheddar", "La Gran Quesería", 4.50, Tamaño.MEDIANO, Edades.ADULTOS, Categoria.ALIMENTO,
	            "Queso cheddar madurado, ideal para sandwiches y gratinados.", "30/09/2024", 104
	        );

	        Producto producto5 = new Producto(
	            "Galletas de Avena", "Cerealia", 2.75, Tamaño.PEQUEÑO, Edades.MENORES, Categoria.ALIMENTO,
	            "Galletas de avena y miel, perfectas para un snack saludable.", "05/11/2024", 105
	        );
	        ArrayList<Tienda> t=new ArrayList<>();
	        ArrayList<Producto> entrega=new ArrayList<>();
	        entrega.add()
	        new Proveedor("ProveeMax" entrega,Categoria.ALIMENTO,t);
//		System.out.println(Proveedor.getSeisProveedores());
//		serializar(Proveedor.getSeisProveedores(),"proveedores");
	}
	
	} 

