package baseDatos;

import java.io.File;  
import java.io.FileOutputStream;  
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.IOException; 
import java.io.FileNotFoundException;

import gestorAplicación.Producto;

public class Serializador {
	private static File archivo = new File(""/*src\\baseDatos\\temp*/);
	
	public static void serializar(ArrayList<Producto> p) {
		for(Producto i:p){
			
		 try { 
		FileOutputStream f = new FileOutputStream(new File(archivo.getAbsolutePath()+  "\\src\\baseDatos\\temp\\Productos.txt"));
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(i); 
		o.close(); f.close();
		 }

		catch (FileNotFoundException e) { 
			 System.out.println("No se encuentra archivo");
		} catch (IOException e) { 
			 System.out.println("Error flujo de inicialización");
		} 
		}
	} 
}
