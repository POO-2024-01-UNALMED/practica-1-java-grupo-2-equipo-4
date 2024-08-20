package baseDatos;

import java.io.File;  
import java.io.FileOutputStream;  
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import gestorAplicación.servicios.*;
import gestorAplicación.servicios.Enums.Categoria;
import gestorAplicación.servicios.Enums.Edades;
import gestorAplicación.servicios.Enums.Genero;
import gestorAplicación.servicios.Enums.Tamaño;
import gestorAplicación.sujetos.Cajero;
import gestorAplicación.sujetos.Conserje;
import gestorAplicación.sujetos.Domiciliario;
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
//		Producto producto1 = new Producto(
//		            "Leche Entera", "La Vaquita", 1.50, Tamaño.GRANDE, Edades.MENORES, Categoria.ALIMENTO,
//		            "Leche entera de vaca, fortificada con vitaminas A y D.", "15/10/2024", 101
//		        );
//		Producto producto12 = new Producto(
//		            "Leche Entera", "La Vaquita", 1.50, Tamaño.GRANDE, Edades.MENORES, Categoria.ALIMENTO,
//		            "Leche entera de vaca, fortificada con vitaminas A y D.", "15/10/2024", 101
//		        );
//	        Producto producto13 = new Producto(
//		            "Leche Entera", "La Vaquita", 1.50, Tamaño.GRANDE, Edades.MENORES, Categoria.ALIMENTO,
//		            "Leche entera de vaca, fortificada con vitaminas A y D.", "15/10/2024", 101
//		        );
//
//	        Producto producto2 = new Producto(
//	            "Pan Integral", "PanRico", 2.00, Tamaño.MEDIANO, Edades.MENORES, Categoria.ALIMENTO,
//	            "Pan integral alto en fibra, ideal para una dieta saludable.", "22/08/2024", 102
//	        );
//
//	        Producto producto3 = new Producto(
//	            "Yogur Natural", "BioLácteos", 3.25, Tamaño.MEDIANO, Edades.ADULTOS, Categoria.ALIMENTO,
//	            "Yogur natural sin azúcar añadido, fuente de probióticos.", "10/09/2024", 103
//	        );
//
//	        Producto producto4 = new Producto(
//	            "Queso Cheddar", "La Gran Quesería", 4.50, Tamaño.MEDIANO, Edades.ADULTOS, Categoria.ALIMENTO,
//	            "Queso cheddar madurado, ideal para sandwiches y gratinados.", "30/09/2024", 104
//	        );
//
//	        Producto producto5 = new Producto(
//	            "Galletas de Avena", "Cerealia", 2.75, Tamaño.PEQUEÑO, Edades.MENORES, Categoria.ALIMENTO,
//	            "Galletas de avena y miel, perfectas para un snack saludable.", "05/11/2024", 105
//	        );
//	        ArrayList<Tienda> t=new ArrayList<>();
//	        ArrayList<Producto> entrega=new ArrayList<>();
//	     new Domiciliario("Pablo",10101,20,Genero.H,100000,null,true,true,true,"moto");
//	     new Cajero("Carlos", 3030, 30, Genero.M, 25000, null, true, true);
//	     new Conserje("Sara",1313,21,Genero.M,100000,null,true,false);
		// Cajero
//		new Cajero("Javier", 4040, 25, Genero.H, 30000, null, true, false, 5,null);
//		new Cajero("Elena", 5050, 26, Genero.M, 28000, null, false, true, 6,null);
//		new Cajero("Fernando", 6060, 24, Genero.H, 29000, null, true, true, 4,null);
//		new Cajero("Sofía", 7070, 27, Genero.M, 31000, null, true, false, 7 ,null);
//		new Cajero("Miguel", 8080, 29, Genero.H, 27000, null, false, true, 8,null);
//		
//		new Conserje("Ana", 1616, 26, Genero.M, 90000, null, false, true, 7);  // Cumple
//		new Conserje("Luis", 2020, 27, Genero.H, 95000, null, true, false, 8);  // Cumple
//		new Conserje("Carmen", 5050, 30, Genero.M, 94000, null, true, false, 9); // Cumple
//		new Conserje("Rosa", 6060, 28, Genero.H, 96000, null, true, true, 3);  
//		new Conserje("Julia", 3030, 24, Genero.M, 92000, null, true, true, 10); 
		Tienda t=new Tienda("NIT123456", null, "Exito", 1000000, "abierto");
		Tienda.getTiendas().add(t);
		serializar(Tienda.getDesempleados(),"empleados");
	}
	
	} 

