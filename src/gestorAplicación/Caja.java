package gestorAplicación;

public class Caja {
	private Empleado empleado;
	private String numero;
	private String nombre;
	private int estado;
	private TipoCaja tipo;
	private Tienda tienda;
	private String descuento;
	
	public Empleado getEmpleado() {
		return empleado;
	}
	
	public void setEmpleado(Empleado empleado) {
		this.empleado=empleado;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero=numero;
		
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
	
	public Empleado getTipo() {
		return empleado;
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
