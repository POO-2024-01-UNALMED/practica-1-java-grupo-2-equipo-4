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
	private double saldo;
	private String estado;
	private Carrito carrito;
	private ArrayList <Carrito> facturas=new ArrayList<Carrito>();	
	private ArrayList<Proveedor> proveedores=new ArrayList<Proveedor>();
	
	private ArrayList <Caja> cajas= new ArrayList<Caja>();
	private ArrayList <Empleado> empleados=new ArrayList<Empleado>();
	private static ArrayList<Empleado> desempleados=new ArrayList<Empleado>();
	
	private static ArrayList<Tienda> tiendas = new ArrayList<Tienda>();
	
	private ArrayList <Pasillo> pasillos=new ArrayList<Pasillo>();
	
		
	private ArrayList <Producto> productosVencidos = new ArrayList <Producto>();
	private ArrayList <Producto> productosDevueltos = new ArrayList <Producto>();
//------------------------------------------------------------------------------------------------------------
	
//Getters and Setters-----------------------------------------------------------------------------------------
	
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
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
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
	

	public static ArrayList<Empleado> getDesempleados() {
		return desempleados;
	}

	public static void setDesempleados(ArrayList<Empleado> des) {
		desempleados = des;
	}
	public ArrayList<Producto> getProductosVencidos() {
		return productosVencidos;
	}

	public void setProductosVencidos(ArrayList<Producto> productosVencidos) {
		productosVencidos = productosVencidos;
	}
	
	public ArrayList <Carrito> getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList <Carrito> facturas) {
		this.facturas = facturas;
	}

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	public ArrayList<Producto> getProductosDevueltos() {
		return productosDevueltos;
	}

	public void setProductosDevueltos(ArrayList<Producto> productosDevueltos) {
		this.productosDevueltos = productosDevueltos;
	}
	
	
	
//------------------------------------------------------------------------------------------------------------
	
//Contructores------------------------------------------------------------------------------------------------

//	public Tienda(){
//		tiendas.add(this);
//	}

//	public Tienda(String nombre) {
//		this.nombre=nombre;
//		tiendas.add(this);
//	}
	
	public Tienda(String nit, Persona dueño, String nombre, double saldo, String estado,ArrayList<Caja> caja, Carrito carrito, ArrayList<Carrito> facturas, ArrayList<Proveedor> proveedores, ArrayList<Caja> cajas, ArrayList<Empleado> empleados, ArrayList<Pasillo> pasillos, ArrayList<Producto> productosVencidos, ArrayList<Producto> productosDevueltos) {	
		this.nit = nit;
		this.dueño = dueño;
		this.nombre = nombre;
		this.saldo = saldo;
		this.estado = estado;
		this.carrito=carrito;
		this.facturas=facturas;
		this.proveedores=proveedores;
		this.cajas=cajas;
		this.empleados=empleados;
		this.pasillos=pasillos;
		this.productosVencidos = productosVencidos;
		this.productosDevueltos = productosDevueltos;
		Tienda.getTiendas().add(this);
	}

//------------------------------------------------------------------------------------------------------------
	
//Metodos-----------------------------------------------------------------------------------------------------
	

	
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
			
//------------------------------------------------------------------------------------------------------------
			
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
//------------------------------------------------------------------------------------------------------------
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
			
//------------------------------------------------------------------------------------------------------------
		    public static ArrayList<Tienda> tiendasConCliente(Cliente cliente) {
		        Set<Tienda> tiendasConCliente = new HashSet<>();
		        for (Tienda tienda : tiendas) {
		            for (Carrito carrito : tienda.getFacturas()) {
		                if (carrito.getCliente().equals(cliente)) {
		                    tiendasConCliente.add(tienda);
		                    break;
		                }
		            }
		        }
		        return new ArrayList<>(tiendasConCliente);
		    }
//------------------------------------------------------------------------------------------------------------
			
//------------------------------------------------------------------------------------------------------------			
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

//------------------------------------------------------------------------------------------------------------	
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
//------------------------------------------------------------------------------------------------------------
	public ArrayList<Producto> buscarProductos(Cliente cliente, String nombre) {
	    ArrayList<Producto> productos = new ArrayList<Producto>();
	    for (Pasillo i : cliente.getTienda().getPasillos()) {
	        for (Producto j : i.getProductos()) {
	            boolean exists = false;
	            for (Producto prod : productos) {
	                if (prod.getId() == j.getId()) {
	                    exists = true;
	                    break;
	                }
	            }
	            if (!exists && new StringBuilder(j.getNombre().toLowerCase()).indexOf(nombre.toLowerCase()) != -1) {
	                productos.add(j);
	            }
	        }
	    }
	    return productos;
	}
	
//------------------------------------------------------------------------------------------------------------
	
	public boolean disponibilidadProductos() {
		boolean pasillo = false;
		
		for (Pasillo i:pasillos) {
			if (i.getProductos().size()!=0){
				pasillo=true;
				break;
			}
		}
		
		
		boolean resultado=pasillo ;
		return resultado;
   }
	
//------------------------------------------------------------------------------------------------------------
	
	 public void agregarProducto(Producto producto) {
	        for (Pasillo pasillo : pasillos) {
	            if (pasillo.getCategoria() == producto.getCategoria()) {
	                pasillo.agregarProducto(producto);
	                return;
	            }
	        }
	    }
	public void agregarProducto(Producto p,String pasillo) {
			for (Pasillo i:pasillos) {
				if (i.getNombre()==pasillo) {
					i.getProductos().add(p);
					p.setTienda(this);
				}
			}
		}
//------------------------------------------------------------------------------------------------------------	
	public ArrayList<Producto> obtenerTodosLosProductos() {
        ArrayList<Producto> todosLosProductos = new ArrayList<>();
        for (Pasillo pasillo : pasillos) {
            todosLosProductos.addAll(pasillo.getProductos());
        }
        return todosLosProductos;
	}
//------------------------------------------------------------------------------------------------------------
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
	
//------------------------------------------------------------------------------------------------------------	
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
	
//------------------------------------------------------------------------------------------------------------	
	public ArrayList<Producto> productosNoActuales(Categoria categoria){
		ArrayList<Producto>	productos=new ArrayList<Producto>();
		Proveedor proveedor=null;
		for (Proveedor p:Proveedor.getSeisProveedores()) {
			if (p.getTipo()==categoria) {
				proveedor=p;
				break;
			}
		}
		System.out.println(proveedor.getEntrega());
		System.out.println(this.obtenerTodosLosProductos());
		for(Producto i:proveedor.getEntrega()) {
			boolean confirmacion=false;
			for(Producto k:this.obtenerTodosLosProductos()) {
				if(i.equals(k)) {
					confirmacion=true;
				}
			}
			if(!confirmacion) {
				productos.add(i);
			}
		}
		return productos;
	}
	
//------------------------------------------------------------------------------------------------------------	
	
	public void  vencerProducto() {
		//si esta caducado//
		for (Producto producto: obtenerTodosLosProductos()) {
			if (producto.getFechaPerecer()==producto.getFechaActual()){
			 producto.setEstado(EstadoProducto.VENCIDO); 
			 getProductosVencidos().add(producto);
		    }			
		}
	}
	
	
	//------------------------------------------------------------------------------------------------------------		

    // Método para recomendar productos
  public ArrayList<Producto> recomendarProductos(Producto productoOriginal, Cliente cliente) {
        ArrayList<Producto> productosRecomendados = new ArrayList<>();
        
        // Obtener el precio del producto original
        double precioOriginal = productoOriginal.getPrecio();
        double montoActual=0;
		for(Producto z:cliente.getCarrito().getProductos()) {
			montoActual+=z.getPrecio();
		} 
        // Buscar productos similares por nombre y por categoría
        for (Pasillo pasillo : pasillos) {
            for (Producto producto : pasillo.getProductos()) {
                // Verificar si el producto es más barato que el original y se ajusta al presupuesto del cliente
                if (producto.getPrecio() < precioOriginal && producto.getPrecio() <= cliente.getDinero()-montoActual) {
                    // Buscar coincidencia de nombres parciales
                    if (producto.getNombre().toLowerCase().contains(productoOriginal.getNombre().toLowerCase())) {
                        productosRecomendados.add(producto);
                    }
                    // Buscar coincidencia de categoría
                    if (producto.getCategoria().equals(productoOriginal.getCategoria())) {
                        productosRecomendados.add(producto);
                    }
                }
            }
        }
        
        // Eliminar duplicados si el producto fue agregado tanto por nombre como por categoría
        List<Producto> productosSinDuplicados = new ArrayList<>();
        for (Producto producto : productosRecomendados) {
            if (!productosSinDuplicados.contains(producto)) {
                productosSinDuplicados.add(producto);
            }
        }
        
        return new ArrayList<Producto>(productosSinDuplicados);
    }
	
			
//------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------
	public ArrayList<Caja> cajasDisponibles() {
		ArrayList<Caja> cajas= new ArrayList<Caja>();
		for(Caja i:this.cajas) {
			if(i.getEstado()==2 & i.getCliente()!=null) {
				cajas.add(i);
			}
		}
		return cajas;
	}
	
	//------------------------------------------------------------------------------------------------------------
	
	public void agregarPasillo(Pasillo pasillo) {
		for(Producto p:pasillo.getProductos()) {
			p.setTienda(this);
		}
		pasillo.setTienda(this);
		this.pasillos.add(pasillo);
	}
	//------------------------------------------------------------------------------------------------------------
	
	public void añadirPasillo(int x2,String nom) {
		new Pasillo(nom,Categoria.values()[x2-1],this);
	}
	
	//------------------------------------------------------------------------------------------------------------
	
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
	//------------------------------------------------------------------------------------------------------------
	
	
	public String listarProveedores() {
		int n=1;
		String s= "  Proveedor  |  Categoria \n";
		for(Proveedor i:Proveedor.getSeisProveedores()) {
			s+="\n"+n+"."+i.getNombre();
			s+="     ";
			s+=i.getTipo();
			n++;
		}
		return s;
	}
	
	
	//------------------------------------------------------------------------------------------------------------
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
	
	
	//------------------------------------------------------------------------------------------------------------
	
		public void contratarEmpleados(int x5) {
			ArrayList<Empleado> quitados=new ArrayList<>();
			switch(x5) {
				case 1:
					for(Empleado e:getDesempleados()) {
						if(e.validarCriterios()!=false && e instanceof Domiciliario) {
							quitados.add(e); //Se va de Desempleados
							this.getEmpleados().add(e); //llega a esta
						}
					}
					break;
				case 2:
					for(Empleado e:getDesempleados()) {
						if(e.validarCriterios()!=false && e instanceof Cajero) {
							quitados.add(e); //Se va de Desempleados
							this.getEmpleados().add(e);//llega a esta
							this.asignarCajero((Cajero)e);
						}
					}
					break;
				case 3:
					for(Empleado e:getDesempleados()) {
						if(e.validarCriterios()!=false && e instanceof Conserje) {
							quitados.add(e); //Se va de Desempleados
							this.getEmpleados().add(e);//llega a esta
						}
					}
					break;
				}
			for(Empleado e:quitados) {
					getDesempleados().remove(e); //Se va de Desempleados
			}
		}
		
		public void asignarCajero(Cajero cajero){
			for(Caja c:this.cajas) {
				if(c.getCajero()==null) {
					c.setCajero(cajero);
				}
			}
		}

//------------------------------------------------------------------------------------------------------------

		
		
		public String mostrarEmpleados() {
			if (this.getEmpleados().size()==0) {
				return "la tienda "+this.getNombre()+" no tiene empleados";
			}
			else {
				String s="  Empleado  |   Tipo \n";
				for(Empleado i:empleados) {
					s+="    ";
					s+=i.getNombre();
					s+="       ";
					s+=i.getTipo()+"\n";
				}
				return s;
			}
		}
		
//------------------------------------------------------------------------------------------------------------
		// este metodo transfiere productos de un Array a su correspondiente pasillo
		public void transferirProductos(ArrayList<Producto> productosTransferir) {
	        ArrayList<Producto> productosParaEliminar = new ArrayList<>();
	        for (Producto producto : productosTransferir) {
	            if (producto.getEstado() == Enums.EstadoProducto.ACTIVO) {
	                for (Pasillo pasillo : pasillos) {
	                    if (pasillo.getCategoria() == producto.getCategoria()) {
	                        pasillo.agregarProducto(producto);
	                        productosParaEliminar.add(producto);
	                        break;
	                    }
	                }
	            }
	        }
	        productosTransferir.removeAll(productosParaEliminar);
	    }

// ------------------------------------------------------------------------------------------------------------
		public static String mostrarDesempleados() {
			int m=1;
			String s= "  Empleado   |   tipo \n";
			for(Empleado i:Tienda.getDesempleados()) {
				s+="\n"+m+"."+i.getNombre();
				s+="     ";
				s+=i.getTipo();
				m++;
			}
			return s;
		}

//------------------------------------------------------------------------------------------------------------
		@Override
		public final String toString() {
			return this.getNombre(); 
		}
//------------------------------------------------------------------------------------------------------------
		public static Cajero encontrarCajero(List<Empleado> empleados) {
	        for (Empleado empleado : empleados) {
	            if (empleado instanceof Cajero) {
	                return (Cajero) empleado;
	            }
	        }
	        return null; // Retorna null si no se encuentra ningún Cajero
	    }

		
}
