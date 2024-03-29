package gestorAplicación;

import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		
		Tienda tienda1= new Tienda();
		Cliente cliente1 = new Cliente();
		Proveedor proveedor1 = new Proveedor();
		
		Producto chito1 = new Producto("chitos",Categoria.ALIMENTO);
		Producto chito2 = new Producto("chitos",Categoria.ALIMENTO);
		Producto palo1 = new Producto("palos",Categoria.ALIMENTO);
		
		ArrayList<Producto> productos1 = new ArrayList<>();
		productos1.add(chito1);
		productos1.add(chito2);
		
		ArrayList<Producto> productos2 = new ArrayList<>();
		productos2.add(palo1);
		
		Pasillo p1 = new Pasillo("pasillo1", productos1,tienda1,cliente1, Categoria.ALIMENTO);
		Pasillo p2 = new Pasillo("pasillo2", productos2,tienda1,cliente1,Categoria.LIMPIEZA);
		
		ArrayList<Pasillo> bodegas = new ArrayList<>();
		bodegas .add(p1);
		bodegas .add(p2);
		
		Inventario inv1= new Inventario(bodegas,tienda1,proveedor1);
		
		ArrayList<Producto> x = inv1.solicitarInventario();
		for (Producto a:x){
			   System.out.println(a.getNombre());
			}
	}

}
