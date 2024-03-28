package gestorAplicación;

import java.util.ArrayList;

public class Inventario {
	private String nombre;
	private ArrayList <ArrayList<Producto>> productos=new ArrayList<ArrayList<Producto>>();
	private Tienda tienda;
	
	public String solicitarInventario() {
		return "Nada por ahora";
	}
}
