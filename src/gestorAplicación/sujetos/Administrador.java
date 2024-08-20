package gestorAplicación.sujetos;

import java.util.ArrayList;
import java.util.Map;

import gestorAplicación.servicios.Tienda;

import java.io.Serializable;

public class Administrador extends Persona implements Serializable {
	private static final long serialVersionUID = -9139003303968753008L;
	private ArrayList<Tienda> tiendas=new ArrayList<Tienda>();


	@Override
	public StringBuilder obtenerContadorProductos(Persona cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Integer> obtenerContadorProductos(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Tienda> getTiendas() {
		return tiendas;
	}

	public void setTiendas(ArrayList<Tienda> tiendas) {
		this.tiendas = tiendas;
	}
	
	

}
