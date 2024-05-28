package baseDatos;

import java.io.File;  
import java.io.FileOutputStream;  
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.IOException; 
import java.io.FileNotFoundException;

import gestorAplicación.Producto;
import gestorAplicación.Tienda;

public class Serializador {
	private static File archivo = new File(""/*src\\baseDatos\\temp*/);
	
	public static void serializar(ArrayList<Tienda> tiendas) {
		 try { 
		FileOutputStream f = new FileOutputStream(new File(archivo.getAbsolutePath()+  "\\src\\baseDatos\\temp\\tiendas.txt"));
		ObjectOutputStream o = new ObjectOutputStream(f);
		//System.out.println(tiendas);
		o.writeObject(tiendas); 
		o.close(); f.close();
		 }

		catch (FileNotFoundException e) { 
			 System.out.println("No se encuentra archivo");
		} catch (IOException e) { 
			// TODO Auto-generated catch block
						e.printStackTrace();
		} 
		}
	} 

