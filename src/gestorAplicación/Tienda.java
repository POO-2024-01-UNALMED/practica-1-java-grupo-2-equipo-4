package gestorAplicación;
import java.io.Serializable;
import java.util.*;

public class Tienda implements Serializable{
//Atributos---------------------------------------------------------------------------------------------------
	private static final long serialVersionUID = 1L; //<---parte de serializar
	private String nit;
	private Persona dueño;
	private String nombre;
	private String direccion;
	private double saldo;
	private String estado;
	private Cliente cliente;
	private ArrayList <Proveedor> proveedores=new ArrayList<Proveedor>();
	private ArrayList <Pasillo> pasillos=new ArrayList<Pasillo>();
	private ArrayList <Persona> candidatos=new ArrayList<Persona>();
	private ArrayList <Caja> cajas= new ArrayList<Caja>();
	private ArrayList <Empleado> empleados=new ArrayList<Empleado>();
	//Antes en BaseDatos e inventario:
	private static ArrayList<Tienda>tiendas = new ArrayList<Tienda>();
	private static ArrayList <Pasillo> bodegas=new ArrayList<Pasillo>();

//------------------------------------------------------------------------------------------------------------
	
//Getters and Setters-----------------------------------------------------------------------------------------
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public ArrayList<Caja> getCajas() {
		return cajas;
	}

	public void setCajas(ArrayList<Caja> cajas) {
		this.cajas = cajas;
	}
	
	public String getNit() {
		return nit;
	}
	
	public void setNit(String nit) {
		this.nit=nit;
	}
	
	public Persona getDueño() {
		return dueño;
	}
	
	public void setDueño(Persona dueño) {
		this.dueño=dueño;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion=direccion;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(float saldo) {
		this.saldo=saldo;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado=estado;
	}
	
	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}
	
	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados=empleados;
	}
	
	public ArrayList<Pasillo> getPasillos() {
		return pasillos;
	}
	
	public void setPasillos(ArrayList<Pasillo> pasillos) {
		this.pasillos=pasillos;
	}
	
	public ArrayList<Persona> getCandidatos() {
		return candidatos;
	}
	
	public void setCandidatos(ArrayList<Persona> candidatos) {
		this.candidatos=candidatos;
	}
	
	public ArrayList<Proveedor> getProveedores() {
		return proveedores;
	}
	
	public void setProveedores(ArrayList<Proveedor> proveedores) {
		this.proveedores=proveedores;
	}
	public static void setTiendas(ArrayList<Tienda> arrayList) {
			Tienda.tiendas=arrayList;
	}	
	public static ArrayList<Tienda> getTiendas() {
		return tiendas;
	}
	public ArrayList<Pasillo> getBodegas() {
		return bodegas;
	}

	public void setBodegas(ArrayList<Pasillo> bodegas) {
		this.bodegas = bodegas;
	}

//------------------------------------------------------------------------------------------------------------
	
//Contructores------------------------------------------------------------------------------------------------

	public Tienda(){
		Tienda.getTiendas().add(this);
	}

	
	public Tienda(String nit, Persona dueño, String nombre, String direccion, double saldo, String estado) {	
		this.nit = nit;
		this.dueño = dueño;
		this.nombre = nombre;
		this.direccion = direccion;
		this.saldo = saldo;
		this.estado = estado;
		Tienda.getTiendas().add(this);
	}

//------------------------------------------------------------------------------------------------------------
	
//Metodos-----------------------------------------------------------------------------------------------------
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void buscarProductos(Categoria categoria) {
		for (Tienda i:tiendas) {
			
		}
	}
	
	public static void buscarProductos(String nombre) {
		
	}
	
	public boolean disponibilidadProductos() {
		boolean pasillo = false;
		boolean bodega = false;
		
		for (Pasillo i:pasillos) {
			if (i.getProductos().size()!=0){
				pasillo=true;
				break;
			}
		}
		for (Pasillo p:Tienda.bodegas) {
			if (p.getProductos().size()!=0) {
				bodega=true;
				break;
			}
		}
		boolean resultado=pasillo | bodega;
		return resultado;
   }
	
	public boolean confirmarDisponibilidad(){
		return false; //provisional este false, por el error que tiene
	}
	
	
	
	public void cajasDisponibles(ArrayList<Caja> cajas) {
		for(Caja i:this.cajas) {
			if(i.getEstado()==2 & i.getEmpleado()!=null) {
				cajas.add(i);
			}
		}
	}
	
	public void crearPasillos() {
		ArrayList <Categoria> categorias=new ArrayList<>();
		System.out.println("cuantos pasillos desea crear?");
		int x1=scanner.nextInt();
		
		for(int i=1;i<=x1;i++) {
			System.out.println("que categorias tendra el pasillo "+i+"?");
			int n=1;
			for(Categoria j:Categoria.values()) {
				System.out.println(n+"."+j);
				n++;
			}
			int x2=scanner.nextInt();
			scanner.nextLine();
			categorias.add(Categoria.values()[x2-1]);
		}
		
		int n=1;
		for(Categoria k:categorias) {
			
			Categoria cat=k;
			System.out.println("nombre del pasillo "+n+" :");
			String x2=scanner.nextLine();
			Pasillo pasillo=new Pasillo(x2,cat);
			pasillos.add(pasillo);
			System.out.println("pasillo creado");
			n++;
		}	
		
		if (this.disponibilidadProductos()==false) {
			System.out.println(dueño +"de la tienda"+nombre+ " sus pasillos estan vacios ");
			System.out.println("desea llamar a un proveedor?\n1.Si\n2.No");
			int x3=scanner.nextInt();
			
			if(x3==1) {
				this.llamarProveedor();
			}
			
		}
		
		
	}
	
	public void llamarProveedor() {
		System.out.println("llamando a un proveedor");
		System.out.println("seleccione un proveedor");
		
		int n=1;
		for(Proveedor i:getProveedores()) {
			System.out.println(n+"."+i);
			n++;
		}
		n=1;	
	}
	
	public void mostrarPasillos() {
		if (pasillos.size()==0) {
			System.out.println("la tienda "+this.getNombre()+" no tiene pasillos");
		}
		else {
			for(Pasillo i:pasillos) {
				System.out.println(i.getNombre());
			}
		}
		
	}
	
	public void crearCaja(String tipo) {
		char letra=65;
		letra+=(int) cajas.size()/3;
		int num=1;
		num+=cajas.size()%3;
		String nletra=Character.toString(letra);
		String nom=nletra+num;
		TipoCaja tipocaja = resolvertipocaja(tipo);
		cajas.add(new Caja(nom,tipocaja,this));
	}
	
	public TipoCaja resolvertipocaja(String tipo) {
	    boolean prueba = false;
	    TipoCaja p = null;
	    while (!prueba) {
	        if (tipo.equals("lenta")) {
	            p = TipoCaja.LENTA;
	            prueba = true;
	        } else if (tipo.equals("rapida")) {
	            p = TipoCaja.RAPIDA;
	            prueba = true;
	        } else {
	            System.out.println("Ese no es un tipo válido de caja, introduzca uno válido");
	            tipo = scanner.nextLine();
	        }
	    }
	    return p;
	}
	//ANTES EN BASEDATOS:
	//Busca las tiendas que tienen pasillos con la categoria escogida por el cliente
		public static ArrayList<Tienda> buscarTienda(Categoria categoria){
			ArrayList<Tienda>tiendaDisp = new ArrayList<>();
			for (Tienda i:tiendas) {			
				for(Pasillo j:i.getPasillos()) {
					if(j.getCategoria()==categoria) {
						tiendaDisp.add(i);
						break; //potencial error
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
	//ANTES EN INVENTARIO
		public void contactarProvedor() {
			
		}
		public ArrayList <Producto> solicitarInventario() {
			ArrayList <Producto> Inventario=new ArrayList<Producto>();
			for (Pasillo i:bodegas) {
				for (Producto p:i.getProductos()) {
					Inventario.add(p);
				}
			}
			return Inventario;
		}
//------------------------------------------------------------------------------------------------------------

		
}
