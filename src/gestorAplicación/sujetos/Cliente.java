package gestorAplicación.sujetos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import gestorAplicación.servicios.Carrito;
import gestorAplicación.servicios.Enums;
//import gestorAplicación.servicios.Factura;
import gestorAplicación.servicios.Enums.Edades;
import gestorAplicación.servicios.Enums.Genero;
import gestorAplicación.servicios.Enums.Membresia;
import gestorAplicación.servicios.Producto;
import gestorAplicación.servicios.Tienda;

public class Cliente extends Persona implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = -6750540194444988134L;
//Atributos----------------------------------------------------------------------------------------------------
	

	private Membresia membresia;
	private Tienda tienda;
	private double dinero;
	private Carrito carrito;
	private ArrayList <Carrito> facturas= new ArrayList<>();

	
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
	
	
	public ArrayList<Carrito> getFacturas() {
		return facturas;
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
	
	
	
	 @Override
	    void mostrarFacturas() {
	        // Implementación específica para Cliente
	    }

	 public ArrayList<Carrito> obtenerFacturas(boolean pagadas) {
	        ArrayList<Carrito> facturas = new ArrayList<>();
	        for (Tienda tienda : getTiendas()) {
	            for (Carrito carrito : tienda.getCarritos()) {
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
	
	
	
	public static void asignaciones(Cliente cliente,Tienda tienda) {
		 if (cliente.mayorEdad() ) {
	        	Carrito carrito =new Carrito(cliente,tienda,Edades.ADULTOS);
	            cliente.setTienda(tienda);
	            cliente.setCarrito(carrito);
	            cliente.setDinero(100000);
	        } else if (!cliente.mayorEdad()) {
	        	Carrito carrito =new Carrito(cliente,tienda,Edades.MENORES);
	        	cliente.setTienda(tienda);
	        	cliente.setCarrito(carrito);
	        	cliente.setDinero(50000);
	        }
	}
	
	

//----Membresias----------------------------------------------------------------------------------------------

	
	
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
	
	public static String getMensajePorPerfil(String perfilDemografico, Membresia membresia) {
	    switch (membresia) {
	        case BASICO:
	            return switch (perfilDemografico) {
	                case "Mujer Joven" -> "disfrutarás de descuentos en productos ideales para tu estilo joven y vibrante. ¡No te pierdas nuestras ofertas en el boletín mensual!";
	                case "Mujer Adulta" -> "obtendrás descuentos en productos que complementan tu estilo sofisticado. Mantente al tanto de nuestras ofertas especiales.";
	                case "Mujer Anciana" -> "te ofrecemos descuentos en productos adaptados a tus necesidades y confort. Consulta nuestras ofertas en el boletín mensual.";
	                case "Hombre Joven" -> "tendrás descuentos en productos que se adaptan a tu estilo dinámico. No olvides revisar el boletín mensual para novedades y ofertas.";
	                case "Hombre Adulto" -> "disfrutarás de descuentos en productos que se ajustan a tu estilo profesional. Consulta nuestras ofertas en el boletín mensual.";
	                case "Hombre Anciano" -> "te ofrecemos descuentos en productos que se adaptan a tus preferencias y comodidad. Revisa el boletín mensual para más detalles.";
	                default -> "te ofrecemos descuentos en productos seleccionados.";
	            };
	        case PREMIUM:
	            return switch (perfilDemografico) {
	                case "Mujer Joven" -> "obtendrás descuentos exclusivos y acceso anticipado a las últimas tendencias. Además, disfruta de nuestra atención prioritaria en cada compra.";
	                case "Mujer Adulta" -> "tendrás acceso a descuentos adicionales y eventos exclusivos. Nuestra atención prioritaria te garantizará una experiencia superior.";
	                case "Mujer Anciana" -> "recibirás descuentos adicionales y atención prioritaria en cada compra. También tendrás acceso a eventos exclusivos diseñados pensando en tu comodidad.";
	                case "Hombre Joven" -> "obtendrás descuentos especiales y acceso anticipado a productos innovadores. Disfruta de nuestra atención prioritaria en cada compra.";
	                case "Hombre Adulto" -> "tendrás acceso a descuentos adicionales y eventos exclusivos. Nuestra atención prioritaria mejorará tu experiencia de compra.";
	                case "Hombre Anciano" -> "recibirás descuentos especiales y atención prioritaria. Además, tendrás acceso a eventos exclusivos adaptados a tus necesidades.";
	                default -> "obtendrás descuentos especiales y acceso a eventos exclusivos.";
	            };
	        case VIP:
	            return switch (perfilDemografico) {
	                case "Mujer Joven" -> "disfrutarás de descuentos máximos y acceso anticipado a colecciones exclusivas. Además, recibirás asesoramiento personal y podrás participar en eventos VIP diseñados especialmente para ti.";
	                case "Mujer Adulta" -> "obtendrás los mayores descuentos y acceso anticipado a nuevas colecciones. Además, contarás con asesoramiento personal y eventos VIP adaptados a tu estilo.";
	                case "Mujer Anciana" -> "te ofrecemos los mayores descuentos y acceso a productos antes que el público general. Además, recibirás asesoramiento personal y experiencias VIP adaptadas a tus preferencias.";
	                case "Hombre Joven" -> "tendrás acceso a descuentos máximos y colecciones antes que nadie. Además, disfrutarás de asesoramiento personal y eventos VIP diseñados para tu estilo dinámico.";
	                case "Hombre Adulto" -> "obtendrás los mayores descuentos y acceso anticipado a nuevas colecciones. Además, contarás con asesoramiento personal y eventos VIP adaptados a tu estilo profesional.";
	                case "Hombre Anciano" -> "disfrutarás de descuentos máximos y acceso anticipado a productos. Además, recibirás asesoramiento personal y experiencias VIP adaptadas a tus gustos y necesidades.";
	                default -> "disfrutarás de descuentos máximos y acceso anticipado a productos exclusivos.";
	            };
	        default:
	            return "te ofrecemos beneficios personalizados.";
	    }
	}
	
	public static String evolucionarMembresia(Cliente cliente, Membresia nuevaMembresia) {
	    if (nuevaMembresia != null) {
	        double costoEvolucion = calcularCostoEvolucion(cliente.getMembresia(), nuevaMembresia); // Suponiendo que tienes un método para calcular el costo
	        if (cliente.getDinero() >= costoEvolucion) {
	            cliente.setDinero(cliente.getDinero() - costoEvolucion); // Deduce el costo del saldo del cliente
	            cliente.setMembresia(nuevaMembresia); // Actualiza la membresía del cliente
	            return"¡Felicidades! Ahora eres miembro de la membresía " + nuevaMembresia.toString() ;
	        } else {
	            return "Lo siento, no tienes suficiente saldo para evolucionar a " +  nuevaMembresia.toString();
	        }
	    } else {
	        return"Selección inválida. Volviendo al menú de consulta.";
	    }
	}

	public static double calcularCostoEvolucion(Membresia membresiaActual, Membresia nuevaMembresia) {
	    if (membresiaActual == null || nuevaMembresia == null) {
	        return 0.0; // Si alguna membresía es nula, no hay costo de evolución
	    }

	    double costoActual = membresiaActual.getPrecio();
	    double costoNueva = nuevaMembresia.getPrecio();
	    return costoNueva - costoActual; // Diferencia de costo
	}
	
//-------------------------------------------------------------------------------------------------------------
}
