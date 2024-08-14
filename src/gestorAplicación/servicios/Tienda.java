package gestorAplicación.servicios;
import java.io.Serializable;
import java.util.*;

import gestorAplicación.servicios.Enums.Categoria;
import gestorAplicación.servicios.Enums.EstadoProducto;
import gestorAplicación.sujetos.Cliente;
import gestorAplicación.sujetos.Empleado;
import gestorAplicación.sujetos.Persona;

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
	private  ArrayList <Pasillo> bodegas=new ArrayList<Pasillo>();
	
	private ArrayList <Producto> ProductosVencidos = new ArrayList <>();
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


	public ArrayList<Producto> getProductosVencidos() {
		return ProductosVencidos;
	}

	public void setProductosVencidos(ArrayList<Producto> productosVencidos) {
		ProductosVencidos = productosVencidos;
	}

	

	
//------------------------------------------------------------------------------------------------------------
	
//Contructores------------------------------------------------------------------------------------------------

	public Tienda(){
		tiendas.add(this);
	}

	public Tienda(String nombre) {
		this.nombre=nombre;
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
	
	public static ArrayList<Producto> buscarProductos(Cliente cliente, Categoria categoria,ArrayList<Producto> productos) {
		ArrayList<Integer> ids=new ArrayList<>();
		for (Pasillo i:cliente.getTienda().getPasillos()) {
			for (Producto j:i.getProductos()){
				if (j.getCategoria()==categoria){
					boolean confirmacion=true;
					for(int p:ids) {
						if(j.getId()==p) {
							confirmacion=false;
						}
					}
					ids.add(j.getId());
					if(confirmacion) {
					productos.add(j);
					}
				}
			}
		}
		return productos;
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
		for (Pasillo p:this.bodegas) {
			if (p.getProductos().size()!=0) {
				bodega=true;
				break;
			}
		}
		boolean resultado=pasillo || bodega;
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
	
	public void crearPasillos(int x2,String nom) {
		Categoria cat=Categoria.values()[x2-1];
		Pasillo pasillo=new Pasillo(nom,cat);
		pasillos.add(pasillo);
		//Así irá en el main:
		
	/*Tienda tien = Deserializador.deserealizar()[0];
      	int i=1;
	while(true){
		print("que categorias tendra el pasillo "+i+"?");
		int n=1;
		for(Categoria j:Categoria.values()) {
			print(n+"."+j);
			n++;
		}
		int x2=escaner();
		print("nombre del pasillo "+i+":");
		String nom=sc.nextline();
		tien.crearPasillos(x2,nom);
		print("pasillo creado");
		i++;
	}
	if (this.disponibilidadProductos()==false) {
		print(dueño +"de la tienda"+nombre+ " sus pasillos estan vacios ");
		print("desea llamar a un proveedor?\n1.Si\n2.No");
		int x3=escaner();
			
		if(x3==1) {
			this.llamarProveedor();
		}
	*/		
	}
	

	//Hacer prints: "seleccione un proveedor" y "llamando a un proveedor" en el main
	public String llamarProveedor() {
		int n=1;
		String s= ""; 
		for(Proveedor i:getProveedores()) {
			s+=n+"."+i+"\n";
			n++;
		}
		return s;
	}
	
	public String mostrarPasillos() {
		if (pasillos.size()==0) {
			return "la tienda "+this.getNombre()+" no tiene pasillos";
		}
		else {
			String s="";
			for(Pasillo i:pasillos) {
				s+=i.getNombre()+"\n";
			}
			return s;
		}
		
	}
	
	public void crearCaja(String tipo) {
		char letra=65;
		letra+=(int) cajas.size()/3;
		int num=1;
		num+=cajas.size()%3;
		String nletra=Character.toString(letra);
		String nom=nletra+num;
		Enums.TipoCaja tipocaja = Enums.TipoCaja.resolverTipoCaja(tipo);
		cajas.add(new Caja(nom,tipocaja,this));
	}
	//ANTES EN BASEDATOS:
	
	//Este método se encarga de buscar si existe al menos una tienda 
	public static boolean buscarTienda() {
		ArrayList<Tienda> tiendasRevisa = tiendas;
		if(tiendas.size() > 0 ) {
			
			 ArrayList<Tienda> tiendasRevisadas = revisionTienda(tiendasRevisa);
			 return tiendasRevisadas.size()>0;
		}
		else {
			return false;
		}
	    
	}
	
	
	//Busca las tiendas que tienen pasillos con la categoria escogida por el cliente
		public static boolean buscarTienda(Categoria categoria){
			ArrayList<Tienda> tiendasRevisa = revisionTienda(tiendas);
			ArrayList<Tienda>tiendaDisp = new ArrayList<>();
			for (Tienda i:tiendasRevisa) {			
				for(Pasillo j:i.getPasillos()) {
					if(j.getCategoria()==categoria) {
						tiendaDisp.add(i);
					}
				}
			}
			return tiendaDisp.size()>0;
		}
		
		//Busca las tiendas que tienen pasillos con la categoria escogida por el cliente
				public static ArrayList<Tienda> categoriaTienda(Categoria categoria){
					ArrayList<Tienda> tiendasRevisa = revisionTienda(tiendas);
					ArrayList<Tienda>tiendaDisp = new ArrayList<>();
					for (Tienda i:tiendasRevisa) {			
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
		public static ArrayList<Tienda> revisionTienda(ArrayList<Tienda> tiendaDisp) {
		    Iterator<Tienda> iterator = tiendaDisp.iterator(); 
		    while (iterator.hasNext()) {
		        Tienda tienda = iterator.next();
		        if (tienda.getEmpleados().size() == 0 || !tienda.disponibilidadProductos()) {
		            iterator.remove(); 
		        }
		    }
		    return tiendaDisp;
		}

		
		//Devuelve los productos disponibles en los pasillos de la tienda, pero parece que
		//Jordan queria hacerlo segun la categoria, falta arreglar eso
		public String buscarProducto(Tienda tienda,int n) {
			String s = "";
			for (Pasillo i:tienda.getPasillos()) {
				for (Producto j:i.getProductos()) {
					s+=n+"."+j+"\n";
				}
			}
			return s;
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
		
		public ArrayList<Producto> obtenerTodosLosProductos() {
	        ArrayList<Producto> todosLosProductos = new ArrayList<>();
	        for (Pasillo pasillo : pasillos) {
	            todosLosProductos.addAll(pasillo.getProductos());
	        }
	        return todosLosProductos;
		}
	
		public static StringBuilder imprimirProducto(int mayorN,int mayorM,int mayorP,Producto producto) {
			StringBuilder texto=new StringBuilder();
			texto.append("  ");
			texto.append(producto.getNombre());
			if(producto.getNombre()!=null) {
			mayorN=(mayorN-texto.length())+4;
			}
			else {
			mayorN=mayorN-2;
			}
			for(int i=0;i<mayorN;i++) {
				texto.append(" ");
			}
			texto.append("|");
			texto.append("  ");
			texto.append(producto.getMarca());
			if(producto.getMarca()!=null) {
			mayorM=mayorM+2-producto.getMarca().length();
			}
			else {
			mayorM=mayorM-2;
			}
			for(int i=0;i<mayorM;i++) {
				texto.append(" ");
			}
			texto.append("|");
			texto.append("  ");
			texto.append(producto.getPrecio());
			mayorP=mayorP+2-(""+producto.getPrecio()).length();
			for(int i=0;i<mayorP;i++) {
				texto.append(" ");
			}
			texto.append("|");
			return texto;
		}
		
		public void agregarProducto(Producto p,String pasillo) {
			for (Pasillo i:pasillos) {
				if (i.getNombre()==pasillo) {
					i.getProductos().add(p);
				}
			}
		}
		
		public void  vencerProducto() {
			//si esta caducado//
			for (Producto producto: obtenerTodosLosProductos()) {
				if (producto.getFechaPerecer()==producto.getFechaActual()){
				 producto.setEstado(EstadoProducto.VENCIDO); 
				 getProductosVencidos().add(producto);
			    }			
			}
		}
		public final String toString() {
			return this.getNombre(); 
		}
//------------------------------------------------------------------------------------------------------------

		
}
