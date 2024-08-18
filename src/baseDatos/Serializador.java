package baseDatos;

import java.io.File;  
import java.io.FileOutputStream;  
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import gestorAplicación.servicios.*;
import gestorAplicación.servicios.Enums.Categoria;

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
		serializar(Tienda.getProveedores(),"proovedores");
		}
	public static void main(String[] args){
//		new Proveedor(null,null,Categoria.ALIMENTO);
//		Tienda.getDesempleados().add(new Domiciliario());
//		Tienda.getDesempleados().add(new Cajero());
		serializarTodo();
	}
	
	} 

