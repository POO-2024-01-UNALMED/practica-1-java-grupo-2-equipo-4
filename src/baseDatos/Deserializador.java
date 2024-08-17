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
	public static void deserializar(int x) {
		try {
			if(x==1) {
			FileInputStream f= new FileInputStream(new File(rutaTemp.getAbsolutePath()+  "\\src\\baseDatos\\temp\\tiendas.txt"));
			ObjectInputStream o = new ObjectInputStream(f);
				ArrayList<Tienda> l=(ArrayList<Tienda>) o.readObject();
				Tienda.setTiendas(l);
				o.close();
				f.close();
			} else {
				FileInputStream f= new FileInputStream(new File(rutaTemp.getAbsolutePath()+  "\\src\\baseDatos\\temp\\empleados.txt"));
				ObjectInputStream o = new ObjectInputStream(f);
				ArrayList<Empleado> l=(ArrayList<Empleado>) o.readObject();
				Tienda.setDesempleados(null);
				Tienda.setDesempleados(l);
				
				o.close();
				f.close();
				System.out.println(Tienda.getDesempleados());
			}
			

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
}
