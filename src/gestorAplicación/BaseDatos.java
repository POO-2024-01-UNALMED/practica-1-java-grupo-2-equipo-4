package gestorAplicación;
import java.util.ArrayList;



public  class BaseDatos {
	static private ArrayList<Tienda>tiendas = new ArrayList<>();
	
	
	public static ArrayList<Tienda> getTiendas() {
		return tiendas;
	}

	public ArrayList<Tienda> buscarTienda(Categoria categoria){
		ArrayList<Tienda>tiendaDisp = new ArrayList<>();
		for (Tienda i:tiendas) {			
			for(Pasillo j:i.getPasillos()) {
				if(j.getCategoria()==categoria) {
					tiendaDisp.add(i);
				}
			}
		}return tiendaDisp;
	}
	
	public void buscarProducto(Tienda tienda,int n) {
		
		for (Pasillo i:tienda.getPasillos()) {
			for ( Producto j:i.getProductos()) {
				
				System.out.println(n+"."+j);
			}
		}
	}
}
