package gestorAplicación;

import java.util.*;

public class Tienda {
	private String nit;
	private Persona dueño;
	private String nombre;
	private String direccion;
	private float saldo;
	private String estado;
	private ArrayList <Empleados> empleados=new ArrayList<Empleados>();
	private ArrayList <ArrayList<Producto>> pasillos=new ArrayList<ArrayList<Producto>>();
	private ArrayList <Persona> candidatos=new ArrayList<Persona>();
	private ArrayList <Proveedor> proveedores=new ArrayList<Proveedor>();
	
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
	
	public ArrayList<Persona> getEmpleados() {
		return empleados;
	}
	
	public void setEmpleados(ArrayList<Persona> empleados) {
		this.empleados=empleados;
	}
	
	public ArrayList<ArrayList<Producto>> getPasillos() {
		return pasillos;
	}
	
	public void setPasillos(ArrayList<ArrayList<Producto>> pasillos) {
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
}
