package gestorAplicación;
import java.util.ArrayList;



public class BaseDatos {
	ArrayList<Tienda>tiendas = new ArrayList<>();
	
	public ArrayList<Tienda> buscar(Categoria categoria){
		ArrayList<Tienda>tiendaDisp = new ArrayList<>();
		for (Tienda i:tiendas) {			
			for(Pasillo j:i.getPasillos()) {
				if(j.getCategoria()==categoria) {
					tiendaDisp.add(i);
				}
			}
		}return tiendaDisp;
	}
}
