package gestorAplicación.sujetos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import gestorAplicación.servicios.Carrito;
import gestorAplicación.servicios.Enums;
import gestorAplicación.servicios.Enums.Edades;
import gestorAplicación.servicios.Enums.Genero;
import gestorAplicación.servicios.Enums.Membresia;
import gestorAplicación.servicios.Producto;
import gestorAplicación.servicios.Tienda;

public class Cliente extends Persona implements Serializable {
	private static final long serialVersionUID = -6750540194444988134L;
//Atributos----------------------------------------------------------------------------------------------------
	

	private Membresia membresia;
	private Tienda tienda;
	private double dinero;
	private Carrito carrito;
	private ArrayList <Carrito> facturas= new ArrayList<Carrito>();

	
//-------------------------------------------------------------------------------------------------------------
	
//Getters and Setters------------------------------------------------------------------------------------------
	
	public Carrito getCarrito() {
		return carrito;
	}	

	public Tienda getTienda() {
		return this.tienda;
	}


	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}


	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}
	
	public double getDinero() {
		return dinero;
	}
	
	public void setDinero(double dinero) {
		this.dinero=dinero;
	}
	
	public ArrayList<Carrito> getFacturas(){
		return facturas;
	}
	
	public ArrayList<Carrito> getFacturas(Tienda tiendaSeleccionada) {
		ArrayList<Carrito> misFacturas = new ArrayList<Carrito>();
    	for(Carrito c:tiendaSeleccionada.getFacturas()) {
    		if (c.getCliente().equals(persona)) {
    			misFacturas.add(c);
    		}
    	}
    	return misFacturas;
	}

	public void setFacturas(ArrayList<Carrito> facturas) {
		this.facturas = facturas;
	}
	
	public Membresia getMembresia() {
		return membresia;
	}

	public void setMembresia(Membresia membresia) {
		this.membresia = membresia;
	}

//-------------------------------------------------------------------------------------------------------------
	
//Constructores------------------------------------------------------------------------------------------------
	
	

	public Cliente() {
		
	}
	
	public Cliente(String nombre, int id, int edad, Genero genero, double dinero, Carrito carrito) {
		super(nombre, id, edad,genero);
		this.dinero = dinero;
		this.carrito = carrito;
		super.getPersonas().add(this);
	}
	
	public Cliente(String nombre, int id, int edad, Genero genero1) {
		super(nombre, id, edad, genero1);
		super.getPersonas().add(this);
	}
	
	


//-------------------------------------------------------------------------------------------------------------

//Metodos------------------------------------------------------------------------------------------------------
	
	public static int existeCliente(String nombre) {
		int contador=0;
		for (Persona i:getPersonas()) {
			if (i.getNombre()==nombre) {
				return contador;
			}
			contador++;
		}
		return -1;
	}
	
//	public StringBuilder imprimirFacturas(Persona cliente) {
//		StringBuilder texto=new StringBuilder();
//		int contador=1;
//		if(cliente.getTiendas().size()==0) {
//			texto.append("Usted no tiene ninguna tienda a la que revisarle facturas");
//			return texto;
//		}
//		for(Tienda i: cliente.getTiendas()) {
//			texto.append("Estos son los productos que ha vendido su tienda\n");
//			if(i.getProductosVendidos().size()==0) {
//				texto.append("Su tienda no ha vendido ningun producto");
//			}
//			else {
//			for(Producto p:i.getProductosVendidos()) {
//				texto.append(p.toString()+"\n");
//			}
//			}
//			texto.append("Estas son las facturas que ha pagado usted a los proveedores\n");
//			if(i.getProductosComprados().size()==0) {
//				texto.append("Su tienda no ha pedido ningun producto del proveedor");
//			}
//			else {
//			for(Carrito c:i.getProductosComprados()) {
//				if(c.isPagado()) {
//				texto.append("Factura del proveedor "+c.getProveedor().getNombre()+" con "+c.getProductos().size()+" productos PAGADA\n");
//				}
//			}
//			for(Carrito c:i.getProductosComprados()) {
//				if(!c.isPagado()) {
//				texto.append(contador+". Factura del proveedor "+c.getProveedor().getNombre()+" con "+c.getProductos().size()+" productos NO PAGADA\n");
//				}
//				contador++;
//			}
//			}
//		}
//		return texto;
//	}
	
//	public StringBuilder imprimirFacturas(Cliente cliente) {
//		StringBuilder texto=new StringBuilder();
//		int contador=1;
//		for(Carrito i:cliente.getFacturas()) {
//			texto.append("Estas son las facturas que ha pagado usted\n");
//			if(i.isPagado()) {
//				texto.append(contador+". Factura de la tienda "+i.getTienda().getNombre()+" con "+i.getProductos().size()+" productos\n");
//			}
//			contador++;
//		}
//		contador=1;
//		for(Carrito i:cliente.getFacturas()) {
//			texto.append("Estas son las facturas sin pagar\n");
//			if(!i.isPagado()) {
//				texto.append(contador+". Factura de la tienda "+i.getTienda().getNombre()+" con "+i.getProductos().size()+" productos\n");
//			}
//			contador++;
//		}
//		return texto;
//	}
	
//	public StringBuilder obtenerContadorProductos(Persona persona ) {
//		StringBuilder string = new StringBuilder();
//		for (Tienda tienda : persona.getTiendas()) {
//			for(Carrito carrito: tienda.getCarritos()) {
//				 Map<String, Integer> contadorProductos = new HashMap<>();
//
//		        for (Producto producto : carrito.getProductos()) {
//		            String clave = producto.getNombre() + "\t" + producto.getTamaño() + "\t" + producto.getPrecio();
//		            contadorProductos.put(clave, contadorProductos.getOrDefault(clave, 0) + 1);
//		        }
//
//		        string.append(""+contadorProductos);
//		        
//		    }
//		}return string;
//	}
//	
//	 public Map<String, Integer> obtenerContadorProductos(Cliente cliente) {
//		 
//	        Map<String, Integer> contadorProductos = new HashMap<>();
//
//	        for (Producto producto : cliente.getCarrito().getProductos()) {
//	            String clave = producto.getNombre() + "\t" + producto.getTamaño() + "\t" + producto.getPrecio();
//	            contadorProductos.put(clave, contadorProductos.getOrDefault(clave, 0) + 1);
//	        }
//
//	        return contadorProductos;
//	    }
//	
//	 
	
	
	
	

	 public ArrayList<Carrito> obtenerFacturas(boolean pagadas) {
	        ArrayList<Carrito> facturas = new ArrayList<>();
	        for (Tienda tienda : getTiendas()) {
	            for (Carrito carrito : tienda.getFacturas()) {
	                if (carrito.isPagado() == pagadas) {
	                    facturas.add(carrito);
	                }
	            }
	        }
	        return facturas;
	    }

	    public Map<String, Integer> obtenerContadorProductos(Cliente cliente) {
	        Map<String, Integer> contadorProductos = new HashMap<>();

	        for (Tienda tienda : cliente.getTiendas()) {
	            for (Carrito carrito : tienda.getCarritos()) {
	                for (Producto producto : carrito.getProductos()) {
	                    String clave = producto.getNombre() + "\t" + producto.getMarca() + "\t" + producto.getTamaño() + "\t" + producto.getPrecio();
	                    contadorProductos.put(clave, contadorProductos.getOrDefault(clave, 0) + 1);
	                }
	            }
	        }

	        return contadorProductos;
	    }
	 
	 //Asigna una tienda y un carrito a un cliente en función de su edad.
	 // Si el cliente es mayor de edad, se le asigna un carrito para adultos y se le otorgan 100,000 en dinero.
	 //Si el cliente es menor de edad, se le asigna un carrito para menores y se le otorgan 50,000 en dinero.
	
	
	
	public static void asignaciones(Cliente cliente,Tienda tienda) {
		 if (cliente.mayorEdad() ) {
	        	Carrito carrito =new Carrito(cliente,tienda,Edades.ADULTOS);
	            cliente.setTienda(tienda);
	            cliente.setCarrito(carrito);
	            carrito.setCliente(cliente);
	            cliente.setDinero(100000);
	        } else if (!cliente.mayorEdad()) {
	        	Carrito carrito =new Carrito(cliente,tienda,Edades.MENORES);
	        	cliente.setTienda(tienda);
	        	cliente.setCarrito(carrito);
	        	cliente.setDinero(50000);
	        	carrito.setCliente(cliente);
	        }
	}
	
	//Asigna una tienda y un carrito a un cliente en función de su edad, y establece un monto de dinero personalizado.
	//Si el cliente es mayor de edad, se le asigna un carrito para adultos.
	//Si el cliente es menor de edad, se le asigna un carrito para menores.
	//El monto de dinero se asigna según el parámetro proporcionado.
	
	public static void asignaciones(Cliente cliente,Tienda tienda,double dinero ) {
		 if (cliente.mayorEdad() ) {
	        	Carrito carrito =new Carrito(cliente,tienda,Edades.ADULTOS);
	            cliente.setTienda(tienda);
	            cliente.setCarrito(carrito);
	            cliente.setDinero(dinero);
	        } else if (!cliente.mayorEdad()) {
	        	Carrito carrito =new Carrito(cliente,tienda,Edades.MENORES);
	        	cliente.setTienda(tienda);
	        	cliente.setCarrito(carrito);
	        	cliente.setDinero(dinero);
	        }
	}
	
	

//----Membresias----------------------------------------------------------------------------------------------
	//Determina el perfil demográfico de un cliente en función de su edad y género. 
	//@param cliente El cliente cuya información demográfica será evaluada.
	//@return Un `String` que representa el perfil demográfico del cliente. 
	//Posibles valores incluyen "Mujer Joven", "Mujer Adulta", "Mujer Anciana", 
	//"Hombre Joven", "Hombre Adulto", "Hombre Anciano" o "Desconocido" si no se cumple ninguna categoría.
	 
	public static String PerfilDemografico(Cliente cliente) {
		
	    int edad = cliente.getEdad();
	    Genero genero = cliente.getGenero();

	    if (edad >= 18 && edad <= 26) {
	        return (genero == Genero.M) ? "Mujer Joven" : "Hombre Joven";
	    } else if (edad >= 27 && edad <= 59) {
	        return (genero == Genero.M) ? "Mujer Adulta" : "Hombre Adulto";
	    } else if (edad >= 60) {
	        return (genero == Genero.M) ? "Mujer Anciana" : "Hombre Anciano";
	    } else {
	        return "Desconocido";
	    }
	}
	
	// Genera un mensaje personalizado para el cliente según su perfil demográfico y el nivel de membresía que posee.
	 
	public static String getMensajePorPerfil(String perfilDemografico, Membresia membresia) {
	    String mensaje;
	    switch (membresia) {
	        case BASICO:
	            mensaje = """
	                Membresía Básica:
	                Como miembro Básico, %s
	                - Disfruta de descuentos especiales según tu perfil demográfico.
	                - Mantente al tanto de nuestras ofertas en el boletín mensual.
	                """;
	            break;
	        case PREMIUM:
	            mensaje = """
	                Membresía Premium:
	                Como miembro Premium, %s
	                - Obtén descuentos exclusivos y acceso anticipado a las últimas tendencias.
	                - Disfruta de atención prioritaria en cada compra.
	                - Participa en eventos exclusivos diseñados para ti.
	                """;
	            break;
	        case VIP:
	            mensaje = """
	                Membresía VIP:
	                Como miembro VIP, %s
	                - Disfruta de los mayores descuentos y acceso anticipado a colecciones exclusivas.
	                - Recibe asesoramiento personal y participa en eventos VIP diseñados especialmente para ti.
	                - Obtén beneficios máximos adaptados a tus preferencias.
	                """;
	            break;
	        default:
	            mensaje = """
	                Beneficios Personalizados:
	                Te ofrecemos beneficios adaptados a tu perfil demográfico.
	                - Disfruta de descuentos y ofertas exclusivas.
	                - Consulta nuestras novedades en el boletín mensual.
	                """;
	            break;
	    }

	    // Personalizar el mensaje según el perfil demográfico
	    return switch (perfilDemografico) {
	        case "Mujer Joven" -> String.format(mensaje, "disfrutarás de descuentos en productos ideales para tu estilo joven y vibrante.\n"+"¡No te pierdas nuestras ofertas!");
	        case "Mujer Adulta" -> String.format(mensaje, "obtendrás descuentos en productos que complementan tu estilo sofisticado.\n"+" Mantente al tanto de nuestras ofertas especiales.");
	        case "Mujer Anciana" -> String.format(mensaje, "te ofrecemos descuentos en productos adaptados a tus necesidades y confort.\n"+" Consulta nuestras ofertas en el boletín mensual.");
	        case "Hombre Joven" -> String.format(mensaje, "tendrás descuentos en productos que se adaptan a tu estilo dinámico.\n"+" No olvides revisar el boletín mensual para novedades y ofertas.");
	        case "Hombre Adulto" -> String.format(mensaje, "disfrutarás de descuentos en productos que se ajustan a tu estilo profesional.\n"+" Consulta nuestras ofertas en el boletín mensual.");
	        case "Hombre Anciano" -> String.format(mensaje, "te ofrecemos descuentos en productos que se adaptan a tus preferencias y comodidad.\n"+" Revisa el boletín mensual para más detalles.");
	        default -> String.format(mensaje, "te ofrecemos descuentos en productos seleccionados.");
	    };
	}
	
	//Permite a un cliente evolucionar su membresía a un nivel superior si tiene suficiente saldo.
	public static String evolucionarMembresia(Cliente cliente, Membresia nuevaMembresia) {
	    if (nuevaMembresia != null) {
	        double costoEvolucion = calcularCostoEvolucion(cliente.getMembresia(), nuevaMembresia); // Suponiendo que tienes un método para calcular el costo
	        if (cliente.getDinero() >= costoEvolucion) {
	            cliente.setDinero(cliente.getDinero() - costoEvolucion); // Deduce el costo del saldo del cliente
	            cliente.setMembresia(nuevaMembresia); // Actualiza la membresía del cliente
	            return"¡Felicidades! Ahora eres miembro de la membresía " + nuevaMembresia.toString()+"tu saldo actual quedo en $"+ cliente.getDinero() ;
	        } else {
	            return "Lo siento, no tienes suficiente saldo para evolucionar a " +  nuevaMembresia.toString();
	        }
	    } else {
	        return"Selección inválida. Volviendo al menú de consulta.";
	    }
	}
	
	//Calcula el costo de evolución de una membresía a una nueva membresía.

	public static double calcularCostoEvolucion(Membresia membresiaActual, Membresia nuevaMembresia) {
	    if (membresiaActual == null || nuevaMembresia == null) {
	    	double costoNueva = nuevaMembresia.getPrecio();
	        return costoNueva; // Si alguna membresía es nula, no hay costo de evolución
	    }

	    double costoActual = membresiaActual.getPrecio();
	    double costoNueva = nuevaMembresia.getPrecio();
	    return costoNueva - costoActual; // Diferencia de costo
	}

	@Override
	public ArrayList<Tienda> getTiendasConFacturas() {
		ArrayList<Tienda> tiendas=new ArrayList<Tienda>();
		for(Carrito c:facturas) {
			tiendas.add(c.getTienda());
		}
		return tiendas;
	}
	
	public double calcularDescuentoPorMembresia() {
	    switch (this.getMembresia()) {
	        case Membresia.BASICO:
	            return 0.05;
	        case Membresia.PREMIUM:
	            return 0.10;
	        case Membresia.VIP:
	            return 0.20;
	        default:
	            return 0.0;
	    }
	}
	
//-------------------------------------------------------------------------------------------------------------
}
