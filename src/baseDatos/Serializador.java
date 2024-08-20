package baseDatos;

import java.io.File;  
import java.io.FileOutputStream;  
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gestorAplicación.servicios.*;
import gestorAplicación.servicios.Enums.Categoria;
import gestorAplicación.servicios.Enums.Edades;
import gestorAplicación.servicios.Enums.Genero;
import gestorAplicación.servicios.Enums.Tamaño;
import gestorAplicación.servicios.Enums.TipoCaja;
import gestorAplicación.sujetos.Administrador;
import gestorAplicación.sujetos.Cajero;
import gestorAplicación.sujetos.Cliente;
import gestorAplicación.sujetos.Conserje;
import gestorAplicación.sujetos.Domiciliario;
import gestorAplicación.sujetos.Persona;

import java.io.IOException; 
import java.io.FileNotFoundException;

public class Serializador {
	private static File archivo = new File("");
	
	public static void serializar(ArrayList<? extends Object> lista, String nombre) {
		 try { 
			 FileOutputStream f = new FileOutputStream(new File(archivo.getAbsolutePath()+  "\\src\\baseDatos\\temp\\"+nombre+".txt"));
			 ObjectOutputStream o = new ObjectOutputStream(f);
			 o.writeObject(lista);
			 o.close(); f.close();
		 } catch (FileNotFoundException e) { 
			 e.printStackTrace();
			 
		 } catch (IOException e) { 
			 e.printStackTrace();
			 
		 	} 
		}
	public static void serializarTodo() {
		serializar(Tienda.getTiendas(),"tiendas");
		serializar(Tienda.getDesempleados(),"empleados");
		serializar(Proveedor.getSeisProveedores(),"proveedores");
		serializar(Persona.getPersonas(),"clientes");
		}
	public static void main(String[] args){
//		Deserializador.deserializarListas();
////		Producto producto1 = new Producto(
////		            "Leche Entera", "La Vaquita", 1.50, Tamaño.GRANDE, Edades.MENORES, Categoria.ALIMENTO,
////		            "Leche entera de vaca, fortificada con vitaminas A y D.", "15/10/2024", 101
////		        );
////		Producto producto12 = new Producto(
////		            "Leche Entera", "La Vaquita", 1.50, Tamaño.GRANDE, Edades.MENORES, Categoria.ALIMENTO,
////		            "Leche entera de vaca, fortificada con vitaminas A y D.", "15/10/2024", 101
////		        );
////	        Producto producto13 = new Producto(
////		            "Leche Entera", "La Vaquita", 1.50, Tamaño.GRANDE, Edades.MENORES, Categoria.ALIMENTO,
////		            "Leche entera de vaca, fortificada con vitaminas A y D.", "15/10/2024", 101
////		        );
////
////	        Producto producto2 = new Producto(
////	            "Pan Integral", "PanRico", 2.00, Tamaño.MEDIANO, Edades.MENORES, Categoria.ALIMENTO,
////	            "Pan integral alto en fibra, ideal para una dieta saludable.", "22/08/2024", 102
////	        );
////
////	        Producto producto3 = new Producto(
////	            "Yogur Natural", "BioLácteos", 3.25, Tamaño.MEDIANO, Edades.ADULTOS, Categoria.ALIMENTO,
////	            "Yogur natural sin azúcar añadido, fuente de probióticos.", "10/09/2024", 103
////	        );
////
////	        Producto producto4 = new Producto(
////	            "Queso Cheddar", "La Gran Quesería", 4.50, Tamaño.MEDIANO, Edades.ADULTOS, Categoria.ALIMENTO,
////	            "Queso cheddar madurado, ideal para sandwiches y gratinados.", "30/09/2024", 104
////	        );
////
////	        Producto producto5 = new Producto(
////	            "Galletas de Avena", "Cerealia", 2.75, Tamaño.PEQUEÑO, Edades.MENORES, Categoria.ALIMENTO,
////	            "Galletas de avena y miel, perfectas para un snack saludable.", "05/11/2024", 105
////	        );
////	        ArrayList<Tienda> t=new ArrayList<>();
////	        ArrayList<Producto> entrega=new ArrayList<>();
////	     new Domiciliario("Pablo",10101,20,Genero.H,100000,null,true,true,true,"moto");
////	     new Cajero("Carlos", 3030, 30, Genero.M, 25000, null, true, true);
////	     new Conserje("Sara",1313,21,Genero.M,100000,null,true,false);
//		// Cajero
////		new Cajero("Javier", 4040, 25, Genero.H, 30000, null, true, false, 5,null);
////		new Cajero("Elena", 5050, 26, Genero.M, 28000, null, false, true, 6,null);
////		new Cajero("Fernando", 6060, 24, Genero.H, 29000, null, true, true, 4,null);
////		new Cajero("Sofía", 7070, 27, Genero.M, 31000, null, true, false, 7 ,null);
////		new Cajero("Miguel", 8080, 29, Genero.H, 27000, null, false, true, 8,null);
////		
////		new Conserje("Ana", 1616, 26, Genero.M, 90000, null, false, true, 7);  // Cumple
////		new Conserje("Luis", 2020, 27, Genero.H, 95000, null, true, false, 8);  // Cumple
////		new Conserje("Carmen", 5050, 30, Genero.M, 94000, null, true, false, 9); // Cumple
////		new Conserje("Rosa", 6060, 28, Genero.H, 96000, null, true, true, 3);  
////		new Conserje("Julia", 3030, 24, Genero.M, 92000, null, true, true, 10); 
////		Cliente cliente1 = new Cliente("Carlos", 11001, 30, Genero.H, 50000, null); // Hombre
////		Cliente cliente2 = new Cliente("Ana", 22002, 25, Genero.M, 60000, null);   // Mujer
////		Cliente cliente3 = new Cliente("Luis", 33003, 35, Genero.H, 70000, null); // Hombre
////		Cliente cliente4 = new Cliente("Maria", 44004, 28, Genero.M, 80000, null); // Mujer
////		Cliente cliente5 = new Cliente("Jorge", 55005, 40, Genero.H, 90000, null); 
////		serializar(Tienda.getDesempleados(),"empleados");
//		Administrador adm=new Administrador("Bob", 9898, 20, Genero.H, 20000);
//		
//		Cliente cliente1 = (Cliente) Persona.getPersonas().get(0);
//		Cliente cliente2 = (Cliente) Persona.getPersonas().get(1);
//		Cliente cliente3 = (Cliente) Persona.getPersonas().get(2);
//		Cliente cliente4 = (Cliente) Persona.getPersonas().get(3);
//		Cliente cliente5 = (Cliente) Persona.getPersonas().get(4);
//
//		// Crear carritos con diferentes configuraciones
//		Carrito car1 = new Carrito(cliente1, false, null, Edades.MENORES);
//		Carrito car2 = new Carrito(cliente2, true, null, Edades.ADULTOS);
//		Carrito car3 = new Carrito(cliente3, false, null, Edades.ADULTOS);
//		Carrito car4 = new Carrito(cliente4, true, null, Edades.MENORES);
//		Carrito car5 = new Carrito(cliente5, false, null, Edades.MENORES);
//		ArrayList<Carrito> cars=new ArrayList<>();
//		cars.add(car1);
//		cars.add(car2);
//		cars.add(car3);
//		cars.add(car4);
//		cars.add(car5);
//		Caja caja1 = new Caja("Caja Principal", TipoCaja.NORMAL, null);
//		Caja caja2 = new Caja("Caja 2", TipoCaja.RAPIDA, null);
//		Caja caja3 = new Caja("Caja Express", TipoCaja.RAPIDA, null);
//		Caja caja4 = new Caja("Caja 4", TipoCaja.NORMAL, null);
//		Caja caja5 = new Caja("Caja VIP", TipoCaja.RAPIDA, null);
//		ArrayList<Caja> cajs=new ArrayList<>();
//		cajs.add(caja1);
//		cajs.add(caja2);
//		cajs.add(caja3);
//		cajs.add(caja4);
//		cajs.add(caja5);
//		Producto producto6 = new Producto(
//			    "Jugo de Manzana", "Frutas del Valle", 2.50, Tamaño.MEDIANO, Edades.MENORES, Categoria.BEBIDA,
//			    "Jugo de manzana natural, sin azúcares añadidos.", "01/12/2024", 106
//			);
//
//			Producto producto7 = new Producto(
//			    "Agua Mineral", "Pureza Total", 1.00, Tamaño.GRANDE, Edades.MENORES, Categoria.BEBIDA,
//			    "Agua mineral natural, embotellada en origen.", "15/11/2024", 107
//			);
//
//			Producto producto8 = new Producto(
//			    "Refresco de Cola", "SodaFresca", 1.75, Tamaño.MEDIANO, Edades.ADULTOS, Categoria.BEBIDA,
//			    "Refresco de cola con gas, sabor intenso y refrescante.", "20/11/2024", 108
//			);
//
//			Producto producto9 = new Producto(
//			    "Bebida Energética", "PowerUp", 3.00, Tamaño.PEQUEÑO, Edades.ADULTOS, Categoria.BEBIDA,
//			    "Bebida energética con vitaminas y cafeína para un impulso rápido.", "10/12/2024", 109
//			);
//
//			Producto producto10 = new Producto(
//			    "Té Helado", "TeaTime", 2.00, Tamaño.MEDIANO, Edades.MENORES, Categoria.BEBIDA,
//			    "Té helado con sabor a limón, refrescante y sin calorías.", "30/12/2024", 110
//			);
//			Pasillo pasilloBebidas = new Pasillo(
//				    "Pasillo de Bebidas", 
//				    new ArrayList<>(List.of(
//				        producto6, producto7, producto8, producto9, producto10
//				    )), 
//				    Categoria.BEBIDA, 
//				    null
//				);
//			Producto producto11 = new Producto(
//				    "Desodorante Aerosol", "FreshUp", 2.50, Tamaño.MEDIANO, Edades.ADULTOS, Categoria.PERSONAL,
//				    "Desodorante en aerosol con fragancia duradera y protección antitranspirante.", "01/01/2025", 111
//				);
//
//				Producto producto12 = new Producto(
//				    "Crema Dental", "WhiteSmile", 1.80, Tamaño.PEQUEÑO, Edades.MENORES, Categoria.PERSONAL,
//				    "Crema dental con flúor, para una limpieza completa y protección contra caries.", "15/02/2025", 112
//				);
//
//				Producto producto13 = new Producto(
//				    "Jabón Líquido", "CleanTouch", 2.00, Tamaño.MEDIANO, Edades.ADULTOS, Categoria.PERSONAL,
//				    "Jabón líquido para manos con ingredientes naturales y fragancia fresca.", "10/03/2025", 113
//				);
//
//				Producto producto14 = new Producto(
//				    "Acondicionador Hidratante", "HydraSoft", 3.50, Tamaño.MEDIANO, Edades.ADULTOS, Categoria.PERSONAL,
//				    "Acondicionador hidratante para cabello seco, con extracto de coco.", "25/04/2025", 114
//				);
//
//				Producto producto15 = new Producto(
//				    "Gel Antibacterial", "SafeHands", 1.50, Tamaño.PEQUEÑO, Edades.MENORES, Categoria.PERSONAL,
//				    "Gel antibacteriano para manos, con un 70% de alcohol y fragancia ligera.", "05/05/2025", 115
//				);
//
//				// Crear pasillo con la lista de productos
//				Pasillo pasilloPersonal = new Pasillo(
//				    "Pasillo de Personal", 
//				    new ArrayList<>(List.of(
//				        producto11, producto12, producto13, producto14, producto15
//				    )), Categoria.PERSONAL, 
//				    null
//						);
//			// Crear lista de productos
//			List<Producto> productos = new ArrayList<>(List.of(
//			    producto6, producto7, producto8, producto9, producto10
//			));
//			Producto producto16 = new Producto(
//				    "Detergente en Polvo", "LimpiaFacil", 4.00, Tamaño.GRANDE, Edades.ADULTOS, Categoria.LIMPIEZA,
//				    "Detergente en polvo para ropa, eficaz en manchas difíciles.", "01/06/2025", 116
//				);
//
//				Producto producto17 = new Producto(
//				    "Limpiador Multiusos", "Sparkle", 3.50, Tamaño.MEDIANO, Edades.ADULTOS, Categoria.LIMPIEZA,
//				    "Limpiador multiusos para superficies, con fragancia cítrica.", "15/07/2025", 117
//				);
//
//				Producto producto18 = new Producto(
//				    "Desinfectante de Baño", "Sanitex", 2.75, Tamaño.PEQUEÑO, Edades.ADULTOS, Categoria.LIMPIEZA,
//				    "Desinfectante para baño, elimina bacterias y malos olores.", "30/08/2025", 118
//				);
//
//				Producto producto19 = new Producto(
//				    "Esponjas de Cocina", "ScrubPlus", 1.50, Tamaño.PEQUEÑO, Edades.MENORES, Categoria.LIMPIEZA,
//				    "Esponjas de cocina, resistentes y eficaces para limpiar utensilios.", "10/09/2025", 119
//				);
//
//				Producto producto20 = new Producto(
//				    "Toallas de Papel", "CleanTowel", 2.00, Tamaño.MEDIANO, Edades.MENORES, Categoria.LIMPIEZA,
//				    "Toallas de papel absorbentes, ideales para la limpieza de superficies.", "25/10/2025", 120
//				);
//				
//				// Crear pasillo con la lista de productos
//				Pasillo pasilloLimpieza = new Pasillo(
//				    "Pasillo de Limpieza", 
//				    new ArrayList<>(List.of(
//				        producto16, producto17, producto18, producto19, producto20
//				    )), 
//				    Categoria.LIMPIEZA, 
//				    null
//				);
//				List<Pasillo> pasillos = new ArrayList<>(List.of(
//					    pasilloBebidas,   // Pasillo con productos de la categoría BEBIDAS
//					    pasilloPersonal,  // Pasillo con productos de la categoría PERSONAL
//					    pasilloLimpieza   // Pasillo con productos de la categoría LIMPIEZA
//					));
//			
//		Tienda t=new Tienda("NIT123456", adm, "Exito", 1000000, "abierto",car1, cars, Proveedor.getSeisProveedores(), cajs, Tienda.getDesempleados(),(ArrayList<Pasillo>) pasillos );
//		ArrayList<Caja> r=new ArrayList<>();
//		for(Caja c:cajs) {
//			r.add(c);}
//		for(Caja c:r) {
//		t.getCajas().add(c);}
//		
//		ArrayList<Pasillo> q=new ArrayList<>();
//		for(Pasillo c:(ArrayList<Pasillo>)pasillos){
//			q.add(c);}
//		for(Pasillo c:q) {
//			t.getPasillos().add(c);}
//
//		Tienda.getTiendas().add(t);
//		serializar(Tienda.getTiendas(),"tiendas");
	}
}

