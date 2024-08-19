package gestorAplicación.servicios;
import java.io.Serializable;
import java.util.*;

import gestorAplicación.servicios.Enums.Categoria;
import gestorAplicación.servicios.Enums.EstadoProducto;
import gestorAplicación.sujetos.Cajero;
import gestorAplicación.sujetos.Cliente;
import gestorAplicación.sujetos.Conserje;
import gestorAplicación.sujetos.Domiciliario;
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
	private ArrayList <Persona> cliente;
	private ArrayList<Proveedor> proveedores=new ArrayList<Proveedor>();
	private ArrayList <Pasillo> pasillos=new ArrayList<Pasillo>();
	private ArrayList <Persona> candidatos=new ArrayList<Persona>();
	private ArrayList <Caja> cajas= new ArrayList<Caja>();
	private ArrayList <Carrito> carritos=new ArrayList<Carrito>();
	private ArrayList <Empleado> empleados=new ArrayList<Empleado>();
	private static ArrayList<Tienda>tiendas = new ArrayList<Tienda>();
	private  ArrayList <Pasillo> bodegas=new ArrayList<Pasillo>();
	private static ArrayList<Empleado> desempleados=new ArrayList<Empleado>();
	
	private ArrayList <Producto> ProductosVencidos = new ArrayList <Producto>();
	
	private ArrayList <Carrito> productosComprados = new ArrayList <Carrito>();
	private ArrayList <Producto> productosVendidos = new ArrayList <Producto>();
//------------------------------------------------------------------------------------------------------------
	
//Getters and Setters-----------------------------------------------------------------------------------------
	
	public ArrayList <Persona> getCliente() {
		return cliente;
	}

	public ArrayList<Carrito> getProductosComprados() {
		return productosComprados;
	}

	public void setProductosComprados(ArrayList<Carrito> productosComprados) {
		this.productosComprados = productosComprados;
	}

	public ArrayList<Producto> getProductosVendidos() {
		return productosVendidos;
	}

	public void setProductosVendidos(ArrayList<Producto> productosVendidos) {
		this.productosVendidos = productosVendidos;
	}

	public void setCliente(ArrayList <Persona> cliente) {
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

	public void setProveedores(ArrayList<Proveedor> proveedor) {
		this.proveedores = proveedor;
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

	public static ArrayList<Empleado> getDesempleados() {
		return desempleados;
	}

	public static void setDesempleados(ArrayList<Empleado> des) {
		desempleados = des;
	}
	public ArrayList<Producto> getProductosVencidos() {
		return ProductosVencidos;
	}

	public void setProductosVencidos(ArrayList<Producto> productosVencidos) {
		ProductosVencidos = productosVencidos;
	}
	
	public ArrayList <Carrito> getCarritos() {
		return carritos;
	}

	public void setCarritos(ArrayList <Carrito> carritos) {
		this.carritos = carritos;
	}

	

	
//------------------------------------------------------------------------------------------------------------
	
//Contructores------------------------------------------------------------------------------------------------

	public Tienda(){
		tiendas.add(this);
	}

	public Tienda(String nombre) {
		this.nombre=nombre;
		tiendas.add(this);
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
	
	public ArrayList<Producto> buscarProductos(Cliente cliente, Categoria categoria,ArrayList<Producto> productos) {
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
	
	public ArrayList<Producto> buscarProductos(Cliente cliente,String nombre) {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		for (Pasillo i:cliente.getTienda().getPasillos()) {
			for (Producto j:i.getProductos()){
				if (new StringBuilder(j.getNombre().toLowerCase()).indexOf(nombre.toLowerCase())!=-1){
					productos.add(j);
				}
			}
		}
		return productos;
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
	
	 public void agregarProducto(Producto producto) {
	        for (Pasillo pasillo : pasillos) {
	            if (pasillo.getCategoria() == producto.getCategoria()) {
	                pasillo.agregarProducto(producto);
	                return;
	            }
	        }
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
	
	public void agregarPasillo(Pasillo pasillo) {
		for(Producto p:pasillo.getProductos()) {
			p.setTienda(this);
		}
		pasillo.setTienda(this);
		this.pasillos.add(pasillo);
	}
	
	public void añadirPasillo(int x2,String nom) {
		new Pasillo(nom,Categoria.values()[x2-1],this);
	}
	
	public String listarProveedores() {
		int n=1;
		String s= "  Proveedor  |  Categoria \n";
		for(Proveedor i:seisProveedores) {
			s+=n+"."+i.getNombre();
			s+="     ";
			s+=i.getTipo();
		}
		return s;
	}
	
	public String mostrarPasillos() {
		if (pasillos.size()==0) {
			return "la tienda "+this.getNombre()+" no tiene pasillos";
		}
		else {
			String s="  Pasillo     Categoria \n";
			for(Pasillo i:pasillos) {
				s+="    ";
				s+=i.getNombre();
				s+="        ";
				s+=i.getCategoria()+"\n";
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
		public ArrayList<Producto> llamarProveedor(int x) {
			Proveedor prov=Tienda.getSeisProveedores().get(x-1);
			ArrayList<Producto> entrega =prov.getEntrega();
			for(Producto p:entrega) {
				agregarProducto(p);
			}
			return entrega;
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
	
		public static StringBuilder imprimirProducto(int mayorN,int mayorM,int mayorP, int mayorC, int cantidad,Producto producto) {
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
			if (producto.getTamaño()!=null) {
				texto.append("/");
				texto.append(producto.getTamaño().getTamaño());
			}
			boolean hacersintamaño=false;
			if(producto.getMarca()!=null || producto.getTamaño()!=null) {
				if(producto.getTamaño()!=null) {
					mayorM=mayorM+2-((""+producto.getMarca()).length())-producto.getTamaño().getTamaño().length()-1;
					hacersintamaño=true;
				}
				if(!hacersintamaño) {
				mayorM=mayorM+2-(producto.getMarca().length());
				}
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
			texto.append("  ");
			texto.append(""+cantidad);
			mayorC=mayorC+2-(""+cantidad).length();
			for(int i=0;i<mayorC;i++) {
				texto.append(" ");
			}
			texto.append("|");
			return texto;
		}
		
		public void agregarProducto(Producto p,String pasillo) {
			for (Pasillo i:pasillos) {
				if (i.getNombre()==pasillo) {
					i.getProductos().add(p);
					p.setTienda(this);
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
		
		public void contratarEmpleados(int x5) {
			switch(x5) {
				case 1:
					for(Empleado e:getDesempleados()) {
						if(e.validarCriterios()!=false && e instanceof Domiciliario) {
							this.getEmpleados().add(e);
						}
					}
					break;
				case 2:
					for(Empleado e:getDesempleados()) {
						if(e.validarCriterios()!=false && e instanceof Cajero) {
							this.getEmpleados().add(e);
						}
					}
					break;
				case 3:
					for(Empleado e:getDesempleados()) {
						if(e.validarCriterios()!=false && e instanceof Conserje) {
							this.getEmpleados().add(e);
						}
					}
				}
		}


		public int cantidadProducto(Producto p) {
			int cantidad=0;
			for (Pasillo i:this.pasillos) {
				for (Producto j:i.getProductos()) {
					if(p.getId()==j.getId()) {
						cantidad++;
					}
				}
			}
			return cantidad;
		}
		
	
		public final String toString() {
			return this.getNombre(); 
		}
//------------------------------------------------------------------------------------------------------------


		
}
