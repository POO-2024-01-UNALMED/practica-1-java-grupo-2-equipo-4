package gestorAplicación.sujetos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import gestorAplicación.servicios.Carrito;
import gestorAplicación.servicios.Enums.Genero;
import gestorAplicación.servicios.Tienda;

import java.io.Serializable;

public class Administrador extends Persona implements Serializable {
	private static final long serialVersionUID = -9139003303968753008L;
	private double dinero;
	private ArrayList<Tienda> tiendas=new ArrayList<Tienda>();
	
	public Administrador(String nombre, int id, int edad, Genero genero) {
		super(nombre,id,edad,genero);
//		this.dinero=dinero;
	}
	
	

	public ArrayList<Tienda> getTiendas() {
		return tiendas;
	}

	 public ArrayList<Carrito> getFacturas(Tienda tienda) {
	        // Método que debe estar implementado para devolver las facturas de la tienda
	        return tienda.getFacturas();
	    }
	
	 @Override
	    public ArrayList<Tienda> getTiendasConFacturas() {
	        Map<Tienda, Integer> tiendaConFacturas = new HashMap<>();

	        for (Tienda tienda : tiendas) {
	            if (tienda != null) {
	                ArrayList<Carrito> facturas = tienda.getFacturas(); // Obtener facturas de la tienda
	                if (facturas != null && !facturas.isEmpty()) {
	                    tiendaConFacturas.put(tienda, facturas.size()); // Contar las facturas
	                }
	            }
	        }

	        // Devolver la lista de tiendas únicas con al menos una factura
	        return new ArrayList<>(tiendaConFacturas.keySet());
	    }


	public void setTiendas(ArrayList<Tienda> tiendas) {
		this.tiendas = tiendas;
	}



	/**
	 * @return the dinero
	 */
	public double getDinero() {
		return dinero;
	}



	/**
	 * @param dinero the dinero to set
	 */
	public void setDinero(double dinero) {
		this.dinero = dinero;
	}
	
}
