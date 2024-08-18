package baseDatos;

import java.io.File; 
import java.io.FileInputStream; 
import java.io.ObjectInputStream; 
import java.util.ArrayList;

import gestorAplicación.servicios.Enums;
import gestorAplicación.servicios.Producto;
import gestorAplicación.servicios.Tienda;
import gestorAplicación.sujetos.Empleado;
import uiMain.Main;

import java.io.IOException; 
import java.io.FileNotFoundException;

public class Deserializador {
	private static File rutaTemp = new File("");
	
	@SuppressWarnings("unchecked")
	public static <T> void deserializar(ArrayList<T> list, String nombre) {
		try {
			FileInputStream f= new FileInputStream(new File(rutaTemp.getAbsolutePath()+  "\\src\\baseDatos\\temp\\"+nombre+".txt"));
			ObjectInputStream o = new ObjectInputStream(f);
			list.addAll((ArrayList<T>) o.readObject());
			o.close();
			f.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(ClassCastException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void deserializarListas() {
		deserializar(Tienda.getTiendas(),"tiendas");
		deserializar(Tienda.getDesempleados(),"empleados");
		deserializar(Tienda.getSieteProveedores(),"proovedores");
		}
}
