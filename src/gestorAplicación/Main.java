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
	
	public void crearPasillos(Tienda tienda) {
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
//-----------------------------------------------------------------------------------------------------------
		
		System.out.println("Cual es tu rol?:" + "\n" + "1. ADMINISTRADOR" + "\n" + "2. CLIENTE");
		int x1=sc.nextInt();
		sc.nextLine();
		
		String x2=null;
		if(x1 == 1) {
			System.out.println("ingrese su nombre");
			x2 = sc.nextLine();	
		}
		System.out.println(x2);
		
		int n=1; // este contador lo pueden usar a gusto,reiniciar a pls
		BaseDatos baseDatos1=new BaseDatos();
		
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
		 x1=sc.nextInt();
		
		System.out.println("Tiendas segun su categoria:" );
		System.out.println(baseDatos1.buscarTienda(Categoria.values()[x1]));
		
		System.out.println("Seleccione una tienda" );
		int x3 = sc.nextInt();
		ArrayList<Tienda>lista = baseDatos1.buscarTienda(Categoria.values()[x1]);
		Tienda tiendaSelec=lista.get(x3);
		
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
