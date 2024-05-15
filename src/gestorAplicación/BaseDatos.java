package gestorAplicación;
import java.util.ArrayList;



public  class BaseDatos {
//Atributos----------------------------------------------------------------------------------------------------
	
	private static ArrayList<Tienda>tiendas = new ArrayList<>();
	
//-------------------------------------------------------------------------------------------------------------

//Getters and Setters------------------------------------------------------------------------------------------
	
	public static ArrayList<Tienda> getTiendas() {
		return tiendas;
	}
	


//-------------------------------------------------------------------------------------------------------------
	
//Metodos------------------------------------------------------------------------------------------------------

	//Busca las tiendas que tienen pasillos con la categoria escogida por el cliente
	public static ArrayList<Tienda> buscarTienda(Categoria categoria){
		ArrayList<Tienda>tiendaDisp = new ArrayList<>();
		for (Tienda i:tiendas) {			
			for(Pasillo j:i.getPasillos()) {
				if(j.getCategoria()==categoria) {
					tiendaDisp.add(i);
				}
			}
		}
		return tiendaDisp;
	}
	
	//Revisa si las tiendas que hay en la lista pasada tienen al menos un empleado o al menos un producto
	//Su aplicacion se da cuando el cliente escoge su categoria y se da una lista con las tiendas
	//este metodo asegura que si sean posibles para que el cliente vaya
	public ArrayList<Tienda> revisionTienda(ArrayList<Tienda> tiendaDisp){
		for (Tienda i:tiendaDisp) {
			if (i.getEmpleados().size()==0 | i.disponibilidadProductos()==false) {
				tiendaDisp.remove(i);
			}
		}
		return tiendaDisp;
	}
	
	//Devuelve los productos disponibles en los pasillos de la tienda, pero parece que
	//Jordan queria hacerlo segun la categoria, falta arreglar eso y que esto es mejor
	//que se encuentre en la clase Tienda
	public void buscarProducto(Tienda tienda,int n) {
		
		for (Pasillo i:tienda.getPasillos()) {
			for (Producto j:i.getProductos()) {
				
				System.out.println(n+"."+j);
			}
		}
	}
//-------------------------------------------------------------------------------------------------------------
}
