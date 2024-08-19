package uiMain;
import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicación.servicios.Producto;
import gestorAplicación.servicios.Tienda;
import gestorAplicación.servicios.Enums.Categoria;
import gestorAplicación.sujetos.Cliente;
import gestorAplicación.sujetos.Persona;

import static uiMain.Main.print;
import static uiMain.Main.escaner;
import static uiMain.Main.lineas;

public class Funcionalidad3 extends Identidad {
	public static void mostrarFacturas() {
		Persona persona = identificarPersona();
		print("Desea mirar sus facturas como cliente o ver las facturas de sus tiendas");
		print("1. Ver las facturas de compras que he hecho");
		print("2. Ver las facturas de mis tiendas");
		int decision=escaner(2);
		switch(decision) {
		case 1:
			System.out.println(persona.imprimirFacturas((Cliente)persona));
			break;
		case 2:
			System.out.println(persona.imprimirFacturas(persona));
			break;
		}
	}
}
