package gestorAplicación;
import java.util.Scanner;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		BaseDatos baseDatos1=new BaseDatos();
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
		int n = 1;
		for (Producto a:x){
			
			   System.out.println(n+ a.getNombre());
			   n++;
			}
		n=1;
		
		//busca tiendas devuelve tiendas disponibles 
		System.out.println("Buscando tiendas...Categorias disponibles:");
		for(Categoria cat:Categoria.values()) {
			System.out.println(n +"."+cat );
			n++;
		}
		n=1;
		
		System.out.println("Seleccione una Categoria:" );
		int x1=scanner.nextInt();
		
		System.out.println("tiendas segun su categoria:" );
		System.out.println(baseDatos1.buscarTienda(Categoria.values()[x1]));
		
		System.out.println("Seleccione una tienda" );
		int x2 = scanner.nextInt();
		ArrayList<Tienda>lista = baseDatos1.buscarTienda(Categoria.values()[x1]);
		Tienda tiendaSelec=lista.get(x2);
		
		System.out.println("productos categoria:"+Categoria.values()[x1]);		
		baseDatos1.buscarProducto(tiendaSelec, n);
	}
}
