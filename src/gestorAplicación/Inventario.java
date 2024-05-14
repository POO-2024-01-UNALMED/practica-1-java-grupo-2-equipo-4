package gestorAplicación;

import java.util.ArrayList;

public class Inventario {
//Atributos----------------------------------------------------------------------------------------------------
	
	private ArrayList <Pasillo> bodegas=new ArrayList<Pasillo>();
	private Tienda tienda;
	private Proveedor proveedor;

//-------------------------------------------------------------------------------------------------------------

//Getters and Setters------------------------------------------------------------------------------------------
	
	public ArrayList<Pasillo> getBodegas() {
		return bodegas;
	}

	public void setBodegas(ArrayList<Pasillo> bodegas) {
		this.bodegas = bodegas;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	public Tienda getTienda() {
		return tienda;
	}
	
	public void setTienda(Tienda tienda) {
		this.tienda=tienda;
	}
	
//-------------------------------------------------------------------------------------------------------------

//Contructores-------------------------------------------------------------------------------------------------
	
	public Inventario() {

	}
	
	public Inventario(Tienda tienda) {
		this.tienda = tienda;
	}

	public Inventario(ArrayList<Pasillo> bodegas, Tienda tienda, Proveedor proveedor) {
		this.bodegas = bodegas;
		this.tienda = tienda;
		this.proveedor = proveedor;
	}
	
//-------------------------------------------------------------------------------------------------------------

//Metodos(QUE SON ESOS METODOS DE ABAJO)-----------------------------------------------------------------------
	
	public ArrayList <Producto> solicitarInventario() {
		ArrayList <Producto> Inventario=new ArrayList<Producto>();
		for (Pasillo i:bodegas) {
			for (Producto p:i.getProductos()) {
				Inventario.add(p);
			}
		}
		return Inventario;
	}

	public void contactarProvedor() {
		
	}
	
	public int contarProductosEnIventario() {
		return 1;
	}

//-------------------------------------------------------------------------------------------------------------
}
