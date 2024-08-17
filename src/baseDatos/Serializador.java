package baseDatos;

import java.io.File;  
import java.io.FileOutputStream;  
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import gestorAplicación.servicios.Pasillo;
import gestorAplicación.servicios.Producto;
import gestorAplicación.servicios.Tienda;
import gestorAplicación.sujetos.Domiciliario;
import gestorAplicación.sujetos.Empleado;

import java.io.IOException; 
import java.io.FileNotFoundException;

public class Serializador {
	private static File archivo = new File(""/*src\\baseDatos\\temp*/);
	
	public static void serializar(ArrayList<Tienda> tiendas) {
		 try { 
			 FileOutputStream f = new FileOutputStream(new File(archivo.getAbsolutePath()+  "\\src\\baseDatos\\temp\\tiendas.txt"));
			 ObjectOutputStream o = new ObjectOutputStream(f);
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
	public static void serializarEmpleados(ArrayList<Empleado> empleados) {
		 try { 
			 FileOutputStream f = new FileOutputStream(new File(archivo.getAbsolutePath()+  "\\src\\baseDatos\\temp\\empleados.txt"));
			 ObjectOutputStream o = new ObjectOutputStream(f);
			 o.writeObject(empleados); 
			 o.close(); f.close();
		 }

		catch (FileNotFoundException e) { 
			 System.out.println("No se encuentra archivo");
			} catch (IOException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	public static void main(String[] args){
		//Tienda.setDesempleados((Tienda.getDesempleados().add(new Domiciliario())));
		//serializarEmpleados(Tienda.getDesempleados());
		Deserializador.deserializar(2);
		
//		ArrayList<Producto> pas1 = new ArrayList<>();
//		pas1.add(new Producto("papa", null));
//		pas1.add(new Producto("salsa", null));
//		
//		Pasillo pas = new Pasillo(null, pas1, null);
//		
//		ArrayList<Pasillo> pasillos = new ArrayList<>();
//		pasillos.add(pas);
//		
//		ArrayList<Tienda> tiendas = new ArrayList<>();
//		serializar(tiendas);
	}
	
	} 

