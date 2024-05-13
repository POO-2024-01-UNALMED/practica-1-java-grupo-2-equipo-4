package gestorAplicación;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void print(String p) {
		System.out.println(p);
	}
	static int [] numeros = {1,2,3,4,5,6};
	static int decision;
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int n=1; // este contador lo pueden usar a gusto,reiniciar a pls
		BaseDatos baseDatos1=new BaseDatos();
		
//Separacion de funcionalidades--------------------------------------------------------------------------------

		do{
			boolean boleano=false;
			print("Bienvenido a My_Tiendita, que desea hacer?");
			print("1.Mostrar productos disponibles segun cateogria y tienda\n"
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
				
			case 2:
				
			case 3:
			
			case 4:
				
			case 5:
			
			}
		 } while (decision!=6);





//--------------------------------------------------------------------------------------------------------------	
		//crear pasillos de tiendas
		Persona persona1=new Persona("pacho",1035,34,"masculino");
		Tienda tienda1= new Tienda("b101",persona1,"pacho's","cra20",10.000000,"abierto");
		tienda1.crearPasillos();
		Tienda tienda2= new Tienda("a201",persona1,"pachos2","cra20",10.000000,"abierto");
		tienda1.disponibilidadProductos();
		tienda2.disponibilidadProductos();
		tienda1.mostrarPasillos();
		tienda2.mostrarPasillos();
		
		System.out.println(tienda1.getPasillos());
		System.out.println(tienda1.getPasillos().get(0).getCategoria() );
		System.out.println(tienda1.getPasillos().get(1).getCategoria() );
		
		//busca tiendas devuelve tiendas disponibles 
		System.out.println("Buscando tiendas...Categorias disponibles:");
		for(Categoria cat:Categoria.values()) {
			System.out.println(n +"."+cat );
			n++;
		}
		n=1;
		
		System.out.println("Seleccione una Categoria:" );
		int x1=sc.nextInt();
		
		System.out.println("Tiendas segun su categoria:" );
		System.out.println(baseDatos1.buscarTienda(Categoria.values()[x1]));
		
		System.out.println("Seleccione una tienda" );
		int x2 = sc.nextInt();
		ArrayList<Tienda>lista = baseDatos1.buscarTienda(Categoria.values()[x1]);
		Tienda tiendaSelec=lista.get(x2);
		
		System.out.println("productos categoria:"+Categoria.values()[x1]);		
		baseDatos1.buscarProducto(tiendaSelec, n);
		//-----------------------------------------------------------------------------------------------------
		
		//Creando constructor de persona (WIP)
		System.out.println("Introduzca su nombre: ");
		String nombre = sc.nextLine();
		System.out.println("Introduzca su ## de identificacion: ");
		int id =sc.nextInt();
		System.out.println("Introduzca su edad: ");
		int edad = sc.nextInt();
		
		
		//Creando arraylist de las cajas buenas y agregandolas (WIP)
		ArrayList<Caja> cajas=new ArrayList<Caja>();
		tienda1.cajasDisponibles(cajas);
		if (cajas.size()==0) {
			int contador=0;
			int decision=1;
			while(cajas.size()==0 & decision==1) {
			System.out.println("Parece que no hay cajas disponibles, ¿que desea hacer?");
			System.out.println("1. Esperar que haya una caja disponible");
			System.out.println("2. Dejar los productos e irse de la tienda");
			decision = sc.nextInt();
			if (decision==1) {
				contador++;
				//Poner aca que hacer si el cliente espera y con el contador dependiendo de cuanto espera
			}
			if (decision==2) {
				//Necesito metodo para devolver productos
				break;
			}
			}
		}
		
		for (Caja i:cajas) {
			System.out.println(i.getNombre()+" Tipo "+i.getTipo());
		}
		System.out.println("Recuerde que las cajas rapidas son para 5 productos o menos");
		boolean comprobacionNom=false;
		boolean comprobacionPro=false;
		String eleccion=null;
		while (!comprobacionNom & !comprobacionPro) {
		System.out.println("¿Cual caja desea escoger?:");
		eleccion=sc.nextLine();
		for (Caja i:cajas) {
			if (i.getNombre()==eleccion) {
				comprobacionNom=true;
				if (i.getTipo()==TipoCaja.RAPIDA & i.getTienda().getCliente().getCarrito().getProductos().size()<=5) {
						comprobacionPro=true;
				}
				if (i.getTipo()==TipoCaja.LENTA) {
					comprobacionPro=true;
				}
			}	
		}
		if (comprobacionNom=false) {
			System.out.println("Esa caja no existe");
		}
		
		if (comprobacionPro=false) {
			System.out.println("Esta escogiendo una caja rapida con mas de 5 productos");
		}
		}
		
		for (Caja p:cajas) {
			if (p.getNombre()==eleccion) {
				p.setCliente(p.getTienda().getCliente());
			}
		}
	}
}
