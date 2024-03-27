package gestorAplicación;

import java.util.*;

public class Tienda {
	private String nit;
	private Persona dueño;
	private String nombre;
	private String direccion;
	private float saldo;
	private String estado;
	private ArrayList <Persona> empleados=new ArrayList<Persona>();
	private ArrayList <ArrayList<Producto>> pasillos=new ArrayList<ArrayList<Producto>>();
	private ArrayList <Persona> candidatos=new ArrayList<Persona>();
	private ArrayList <Proveedor> proveedores=new ArrayList<Proveedor>();
}
