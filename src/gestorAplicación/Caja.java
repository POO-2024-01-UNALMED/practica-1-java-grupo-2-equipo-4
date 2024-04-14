package gestorAplicación;

public class Caja {
	private Empleado empleado;
	private String nombre;
	private int estado=2;
	private TipoCaja tipo;
	private Tienda tienda;
	private String descuento;
	private Cliente cliente;
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public Caja(){
	}
	
	public Caja(String nombre, TipoCaja tipo, Tienda tienda){
		this.nombre=nombre;
		this.tipo=tipo;
		this.tienda=tienda;
	}
	
	public Empleado getEmpleado() {
		return empleado;
	}
	
	public void ponerEnCaja(Empleado empleado) {
		this.setEmpleado(empleado);
	}
	
	public void setEmpleado(Empleado empleado) {
		this.empleado=empleado;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public int getEstado() {
		return estado;
	}
	
	public void setEstado(int estado) {
		this.estado=estado;
	}
	
	public TipoCaja getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoCaja tipo) {
		this.tipo=tipo;
	}
	
	public Tienda setTienda() {
		return tienda;
	}
	
	public void setTienda(Tienda tienda) {
		this.tienda=tienda;
	}
	
	public String setDescuento() {
		return descuento;
	}
	
	public void setDescuento(String descuento) {
		this.descuento=descuento;		
		
	}
}
