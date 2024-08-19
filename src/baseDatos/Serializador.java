package baseDatos;

import java.io.File;  
import java.io.FileOutputStream;  
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import gestorAplicación.servicios.*;
import gestorAplicación.servicios.Enums.Categoria;
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
		serializar(Tienda.getSeisProveedores(),"proovedores");
		serializar(Persona.getPersonas(),"clientes");
		}
	public static void main(String[] args){
		serializarTodo();
	}
	
	} 

