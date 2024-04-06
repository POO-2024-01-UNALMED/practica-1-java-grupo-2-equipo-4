package gestorAplicación;

import java.util.*;

public class Tienda {
	private String nit;
	private Persona dueño;
	private String nombre;
	private String direccion;
	private float saldo;
	private String estado;
	private Inventario inventario;
	private ArrayList <Empleado> empleados=new ArrayList<Empleado>();
	private ArrayList <Pasillo> pasillos=new ArrayList<Pasillo>();
	private ArrayList <Persona> candidatos=new ArrayList<Persona>();
	private ArrayList <Proveedor> proveedores=new ArrayList<Proveedor>();
	private ArrayList <Caja> cajas= new ArrayList<Caja>();
	
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
	
	public float getSaldo() {
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
	
	public boolean disponibilidadProductos() {
		boolean pasillo = false;
		boolean bodega = false;
		for (Pasillo i:pasillos) {
			if (i.getProductos().size()!=0){
				pasillo=true;
				break;
			}
		}
		for (Pasillo p:inventario.getBodegas()) {
			if (p.getProductos().size()!=0) {
				bodega=true;
				break;
			}
		}
		boolean resultado=pasillo | bodega;
		return resultado;
   }
	public void cajasDisponibles(ArrayList<Caja> cajas) {
		for(Caja i:this.cajas) {
			if(i.getEstado()==2 & i.getEmpleado()!=null) {
				cajas.add(i);
			}
		}
	}
}
