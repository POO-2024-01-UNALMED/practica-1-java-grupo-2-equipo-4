package gestorAplicación;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	static long readLong(){
		return sc.nextLong();
	}
	public void desplegarTiendas(){
		//funcionalidad 1
	}
	public void mostrarProductos(){
		//funcionalidad 2
	}
	public void realizarPago(){
		//funcionalidad 3
	}
	public void asignarDueño(){
		//funcionalidad 4
	}
	public void revisarTienda(){
		//funcionalidad 5
	}
	
	public static void print(String p) {
		System.out.println(p);
	}
	static int [] numeros = {1,2,3,4,5,6};
	static int decision;
	
	public static void crearPasillos(Tienda tienda) {
		ArrayList <Categoria> categorias=new ArrayList<>();
		System.out.println("cuantos pasillos desea crear?");
		int x1=sc.nextInt();
		
		for(int i=1;i<=x1;i++) {
			System.out.println("que categorias tendra el pasillo "+i+"?");
			int n=1;
			for(Categoria j:Categoria.values()) {
				System.out.println(n+"."+j);
				n++;
			}
			int x2=sc.nextInt();
			sc.nextLine();
			categorias.add(Categoria.values()[x2-1]);
		}
		
		int n=1;
		for(Categoria k:categorias) {
			
			Categoria cat=k;
			System.out.println("nombre del pasillo "+n+" :");
			String x2=sc.nextLine();
			Pasillo pasillo=new Pasillo(x2,cat);
			tienda.getPasillos().add(pasillo);
			System.out.println("pasillo creado");
			n++;
		}	
		
		if (tienda.disponibilidadProductos()==false) {
			System.out.println(tienda.getDueño() +"de la tienda"+tienda.getNombre()+ " sus pasillos estan vacios ");
			System.out.println("desea llamar a un proveedor?\n1.Si\n2.No");
			int x3=sc.nextInt();
			
			if(x3==1) {
				tienda.llamarProveedor();
			}
			
		}
		
		
	}
	
	public static void main(String[] args){		
//-----------------------------------------------------------------------------------------------------------
	do{
		boolean boleano=false;
		print("Bienvenido a My_Tiendita, que desea hacer?");
		print("1.Mostrar productos disponibles segun categoria y tienda\n"
				+ "2.Realizar listas de compras\n"
				+ "3.Pagar recibos pendientes\n"
				+ "4. \n"
				+ "5.Personalizar y modificar tiendas\n"
				+ "6.Terminar");
		while (!boleano){
			try{
				decision=sc.nextInt();
			}
			catch(Exception e) {
				print("Este no es un numero valido");
				sc.nextLine();
			}
			for (int i:numeros){
				 if (decision==i){
				        boleano=true;
				 }
			}
			if (boleano==false){
				 print("El numero esta fuera del rango");
				 continue;
			}
		}
		switch(decision){
		case 1:
			print("Elige la categoria que estas buscando ");
			int enumerado = 1;
			for(Categoria tipo:Categoria.values()) {
					print(enumerado +"."+tipo );
					enumerado++;
				
			}
			int desicionCategoria = sc.nextInt();
			switch(desicionCategoria){
			case 1:
				print("Estas tiendas tienen tu categoria deseada en cual deseas comprar:");
				enumerado=1;
				for(Tienda alimento:BaseDatos.buscarTienda(Categoria.ALIMENTO)) {
					print(enumerado+"."+alimento.getNombre());
					enumerado++;
				} 
				
				break;
			
			case 2:
				print("Estas tiendas tienen tu categoria deseada en cual deseas comprar:");
				enumerado=1;
				for(Tienda alimento:BaseDatos.buscarTienda(Categoria.BEBIDA)) {
					print(enumerado+"."+alimento.getNombre());
					enumerado++;
				} 
				
				break;
				
			case 3:
				print("Estas tiendas tienen tu categoria deseada en cual deseas comprar:");
				enumerado=1;
				for(Tienda alimento:BaseDatos.buscarTienda(Categoria.LIMPIEZA)) {
					print(enumerado+"."+alimento.getNombre());
					enumerado++;
				} 
			
				break;
				
			case 4:
				print("Estas tiendas tienen tu categoria deseada en cual deseas comprar:");
				enumerado=1;
				for(Tienda alimento:BaseDatos.buscarTienda(Categoria.PERSONAL)) {
					print(enumerado+"."+alimento.getNombre());
					enumerado++;
				} 
			
				break;
				
			case 5:
				print("Estas tiendas tienen tu categoria deseada en cual deseas comprar:");
				enumerado=1;
				for(Tienda alimento:BaseDatos.buscarTienda(Categoria.HOGAR)) {
					print(enumerado+"."+alimento.getNombre());
					enumerado++;
				} 
				
				break;
			case 6:
				print("Estas tiendas tienen tu categoria deseada en cual deseas comprar:");
				enumerado=1;
				for(Tienda alimento:BaseDatos.buscarTienda(Categoria.ELECTRONICO)) {
					print(enumerado+"."+alimento.getNombre());
					enumerado++;
				} 
				
				break;
				
			}
			
			break;
			
		case 2:
			
		case 3:
		
		case 4:
			
		case 5:
		
		}
	 } while (decision!=6);

	}
}
