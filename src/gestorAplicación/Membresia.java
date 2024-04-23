package gestorAplicación;
import java.util.*;

public class Membresia {
//Atributos----------------------------------------------------------------------------------------------------
	
	private Cliente cliente;
	private TipoEdad tipo;
	private int puntosMembresia;
	private ArrayList <Tienda> tiendas = new ArrayList<Tienda>();

//-------------------------------------------------------------------------------------------------------------

//Getters and Setters------------------------------------------------------------------------------------------
	
	public  Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
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
		this.puntosMembresia=PuntosMembresia;
	}
	
	public ArrayList<Tienda> getTiendas() {
		return tiendas;
	}
	
	public void setTiendas(ArrayList<Tienda> tiendas) {
		this.tiendas=tiendas;
	}
	
//-------------------------------------------------------------------------------------------------------------
	
//Constructores------------------------------------------------------------------------------------------------

//-------------------------------------------------------------------------------------------------------------

//Metodos------------------------------------------------------------------------------------------------------
	
	public int restarPuntosFidelidad(int restar){
		return this.puntosMembresia-restar;
	}
	
	public Membresia(Cliente cliente, TipoEdad tipo, int puntosMembresia, ArrayList<Tienda> tiendas) {
		super();
		this.cliente = cliente;
		this.tipo = tipo;
		this.puntosMembresia = puntosMembresia;
		this.tiendas = tiendas;
	}

	public void aplicarDescuentos (double descuento ) {
		
	}
	
//-------------------------------------------------------------------------------------------------------------
}
