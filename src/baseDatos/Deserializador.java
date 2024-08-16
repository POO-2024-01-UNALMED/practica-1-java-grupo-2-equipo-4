package baseDatos;

import java.io.File; 
import java.io.FileInputStream; 
import java.io.ObjectInputStream; 
import java.util.ArrayList;

import gestorAplicación.servicios.Enums;
import gestorAplicación.servicios.Producto;
import gestorAplicación.servicios.Tienda;
import uiMain.Main;

import java.io.IOException; 
import java.io.FileNotFoundException;

public class Deserializador {
	private static File rutaTemp = new File("");
	
	@SuppressWarnings("unchecked")
	public static void deserializar() {
		try {
			FileInputStream f= new FileInputStream(new File(rutaTemp.getAbsolutePath()+  "\\src\\baseDatos\\temp\\tiendas.txt"));
			ObjectInputStream o = new ObjectInputStream(f);
			//System.out.println(new Producto("",Categoria.ALIMENTO) );
			//System.out.println(o.readObject());
			ArrayList<Tienda> l=(ArrayList<Tienda>) o.readObject();
			Tienda.setTiendas(l);
			//System.out.println(A);
			//Producto.pro=A;
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
			//e.printStackTrace();
		}
	}
}
