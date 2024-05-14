package baseDatos;

import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.io.IOException; 
import java.io.FileNotFoundException;

public class Serializador {
	private static File rutaTemp = new File("src\\baseDatos\\temp");
	
	public static void deserealizar(/*Producto p*/) {
		 try { 
		FileOutputStream f = new FileOutputStream(new File(archivo.getAbsolutePath()+  "\\src\\archivos\\Productos.txt"));
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(p); 
		o.close(); f.close();
		 }

		catch (FileNotFoundException e) { 
			 System.out.println("No se encuentra archivo");
		} catch (IOException e) { 
			 System.out.println("Error flujo de inicialización");
		} catch (ClassNotFoundException e) { // TODO Auto-generated catch block 
			 e.printStackTrace(); }  
	} 
}
