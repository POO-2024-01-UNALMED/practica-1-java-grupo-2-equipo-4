package gestorAplicación;
import java.util.*;

public class Membresia {
	private Cliente cliente;
	private TipoEdad tipo;
	private int puntosMembresia;
	private Arraylist <Tienda> tiendas = new Arraylist<Tienda>();
	
	
	
	public  Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Persona cliente) {
		this.cliente=cliente;
	}
	
	public TipoEdad getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoEdad tipo) {
		this.tipo=tipo;
	}
	
	public int getPuntosMembresia() {
		return puntosMembresia;
	}
	
	public void setPuntosMembresia(int PuntosMembresia) {
		this.PuntosMembresia=PuntosMembresia;
	}
	
	public ArrayList<Tienda> getTiendas() {
		return tiendas;
	}
	
	public void setTiendas(ArrayList<Tienda> tiendas) {
		this.tiendas=tiendas;
	}
	
	public int restarPuntosFidelidad(int restar){
		return this.puntosMembresia-restar;
	}
	
	public void aplicarDescuentos (double descuento ) {
		
	}
	

}
