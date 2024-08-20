package uiMain;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import gestorAplicación.servicios.*;
import gestorAplicación.sujetos.*;
import java.util.Scanner;

import gestorAplicación.servicios.Enums.TipoCaja;
import gestorAplicación.sujetos.Cliente;
import gestorAplicación.sujetos.Persona;

public class Funcionalidad3 extends Identidad {
	public static void impresionFacturas() {
		Persona persona = identificarPersona();
		Scanner scanner = new Scanner(System.in);
		ArrayList<Tienda> tiendas = persona.getTiendasConFacturas();

		if (tiendas.isEmpty()) {
		    System.out.println("No tienes facturas en ninguna tienda.");
		    Main.escogerFuncionalidad(); // Regresar al menú principal
		    scanner.close();
		    return; // Salir del método
		}

		Map<String, Integer> conteoTiendas = new HashMap<>();
		for (Tienda tienda : tiendas) {
		    conteoTiendas.put(tienda.getNombre(), conteoTiendas.getOrDefault(tienda.getNombre(), 0) + 1);
		}

		// Imprimir tabla de tiendas y cantidad de facturas
		System.out.println("Número de Facturas");
		System.out.println("+-----+----------------+-----------------+");
		System.out.println("| No. | Nombre         | Cantidad        |");
		System.out.println("+-----+----------------+-----------------+");

		int numero = 1;
		for (Map.Entry<String, Integer> entry : conteoTiendas.entrySet()) {
		    System.out.printf("| %-3d | %-14s | %-15d |%n", numero, entry.getKey(), entry.getValue());
		    numero++;
		}

		System.out.println("+-----+----------------+-----------------+");

		// Solicitar selección del usuario
		System.out.print("Seleccione el número de la tienda: ");
		int seleccion = scanner.nextInt();

		// Validar selección y buscar la tienda seleccionada
		Tienda tiendaSeleccionada = null;
		if (seleccion >= 1 && seleccion <= conteoTiendas.size()) {
		    numero = 1;
		    for (Tienda tienda : tiendas) {
		        if (numero == seleccion) {
		            tiendaSeleccionada = tienda;
		            break;
		        }
		        if (conteoTiendas.get(tienda.getNombre()) == null) {
		            continue;
		        }
		        numero++;
		    }
		}

		if (tiendaSeleccionada != null) {
		    System.out.println("Has seleccionado la tienda: " + tiendaSeleccionada.getNombre());

		    // Obtener las facturas de la tienda seleccionada
		    ArrayList<Carrito> misFacturas = persona.getFacturas(tiendaSeleccionada);

		    // Imprimir las facturas
		    System.out.println("+-----+--------------------+------------+-----------------+------------+----------+");
		    System.out.println("| No. | Tienda             | Fecha      | Productos        | Precio     | Pagada   |");
		    System.out.println("+-----+--------------------+------------+-----------------+------------+----------+");

		    numero = 1;
		    for (Carrito factura : misFacturas) {
		        boolean estadoPago = factura.isPagado();
		        System.out.printf("| %-3d | %-18s | %-10s | %-15d | %-10.2f | %-8s |%n",
		                numero,
		                factura.getTienda().getNombre(),
		                factura.getFechaFacturacion(),
		                factura.getProductos().size(),
		                Carrito.calcularTotal(factura.getProductos()),
		                estadoPago
		        );
		        numero++;
		    }

		    System.out.println("+-----+--------------------+------------+-----------------+------------+----------+");

		    // Solicitar selección de factura
		    System.out.print("Seleccione el número de la factura que desea imprimir: ");
		    seleccion = scanner.nextInt();

		    // Validar selección y mostrar la factura seleccionada
		    Carrito facturaSeleccionada = null;
		    if (seleccion >= 1 && seleccion <= misFacturas.size()) {
		        facturaSeleccionada = misFacturas.get(seleccion - 1);
		        System.out.println("Has seleccionado la factura de la tienda: " + facturaSeleccionada.getTienda().getNombre());

		        // Imprimir detalles de los productos de la factura seleccionada
		        System.out.println("+-----+--------------------+---------------+----------+------------+----------+");
		        System.out.println("| No. | Producto           | Marca         | Tamaño   | Categoría  | Precio   |");
		        System.out.println("+-----+--------------------+---------------+----------+------------+----------+");

		        int numeroProducto = 1;
		        for (Producto producto : facturaSeleccionada.getProductos()) {
		            System.out.printf("| %-3d | %-18s | %-13s | %-8s | %-10s | %-8.2f |%n",
		                    numeroProducto,
		                    producto.getNombre(),
		                    producto.getMarca(),
		                    producto.getTamaño().getTamaño(),
		                    producto.getCategoria().getTexto(),
		                    producto.getPrecio()
		            );
		            numeroProducto++;
		        }

		        System.out.println("+-----+--------------------+---------------+----------+------------+----------+");

		        // Opciones adicionales dependiendo del tipo de objeto
		        if (persona instanceof Administrador) {
		            System.out.println("Opciones:");
		            System.out.println("1. Escoger otra factura");
		            System.out.println("2. Salir de funcionalidad");

		            int opcion = scanner.nextInt();
		            switch (opcion) {
		                case 1:
		                    // Regresar a la selección de facturas
		                    break;
		                case 2:
		                    Main.escogerFuncionalidad(); // Llamar al método para salir de la funcionalidad
		                    break;
		                default:
		                    System.out.println("Opción no válida.");
		                    break;
		            }
		        } else if (persona instanceof Cliente) {
		            System.out.println("Opciones:");
		            System.out.println("1. Pagar factura");
		            System.out.println("2. Escoger otra factura");
		            System.out.println("3. Salir de funcionalidad");

		            int opcion = scanner.nextInt();
		            switch (opcion) {
		                case 1:
		                    // Llamar al método para seleccionar caja y proceder con el pago
		                    seleccionarCaja((Cliente) persona, facturaSeleccionada);
		                    break;
		                case 2:
		                    // Regresar a la selección de facturas
		                    break;
		                case 3:
		                    Main.escogerFuncionalidad(); // Llamar al método para salir de la funcionalidad
		                    break;
		                default:
		                    System.out.println("Opción no válida.");
		                    break;
		            }
		        }
		    } else {
		        System.out.println("Selección inválida.");
		    }
		} else {
		    System.out.println("Selección inválida.");
		}

		scanner.close();
	}
        
        //Debes imprimir que facturas hay, y para que el usuario escoja una y pase a pagarla, si es administrador solo las mostrara

	public static boolean tresEnRaya() {

        // Juego de Tres en Raya
        Juego juegoTresEnRaya = new TresEnRaya();
        juegoTresEnRaya.iniciar();
        while (!juegoTresEnRaya.haGanado() && !juegoTresEnRaya.haPerdido()) {
            System.out.println(juegoTresEnRaya.obtenerEstado());
            System.out.print("Elige una posición (0-8): ");
            int posicion = sc.nextInt();
            juegoTresEnRaya.jugar(posicion);
        }
        System.out.println(juegoTresEnRaya.obtenerEstado());
        System.out.println(juegoTresEnRaya.haGanado() ? "¡Ganaste!" : "¡Perdiste!");
        if((juegoTresEnRaya.haGanado() ? "¡Ganaste!" : "¡Perdiste!").equals("¡Ganaste!")) {
        	return true;
        }
        else {
        	return false;
        }
	}
	
	public static boolean juegoAhorcado() {
		Juego juegoAhorcado = new Ahorcado("java");
        juegoAhorcado.iniciar();
        while (!juegoAhorcado.haGanado() && !juegoAhorcado.haPerdido()) {
            System.out.println(juegoAhorcado.obtenerEstado());
            System.out.print("Introduce una letra: ");
            char letra = sc.next().charAt(0);
            juegoAhorcado.jugar(letra);
        }
        System.out.println(juegoAhorcado.obtenerEstado());
        System.out.println(juegoAhorcado.haGanado() ? "¡Ganaste!" : "¡Perdiste!");
        if((juegoAhorcado.haGanado() ? "¡Ganaste!" : "¡Perdiste!").equals("¡Ganaste!")) {
        	return true;
        }
        else {
        	return false;
        }
	}
	
	
	public static void seleccionarCaja(Cliente cliente, Carrito carrito) {
		ArrayList<Caja> cajas = cliente.getTienda().cajasDisponibles();
		Caja cajaSeleccionada = null;

		while (true) {
		    if (cajas.isEmpty()) {
		        System.out.println("No hay cajas disponibles.");
		        System.out.println("1. Esperar a que una caja esté disponible.");
		        System.out.println("2. No pagar y salir.");
		        System.out.print("Seleccione una opción: ");
		        int opcion = sc.nextInt();

		        if (opcion == 1) {

		        	Tienda tienda = cliente.getTienda();
		        	tienda.asignarCajero(Tienda.encontrarCajero(tienda.getEmpleados())); // Método para asignar un empleado a una caja

		            continue; // Repetir el proceso después de asignar un empleado
		        } else if (opcion == 2) {
		            System.out.println("Ha decidido no pagar. Saliendo del proceso.");
		            return; // Salir del método
		        } else {
		            System.out.println("Opción no válida. Inténtelo de nuevo.");
		            continue;
		        }
		    }

		    System.out.println("Seleccione una caja para pagar:");
		    for (int i = 0; i < cajas.size(); i++) {
		        Caja caja = cajas.get(i);
		        System.out.printf("%d. Caja: %s, Tipo: %s, Empleado: %s\n", 
		                          i + 1, caja.getNombre(), caja.getTipo(), caja.getCajero().getNombre());
		    }

		    System.out.print("Seleccione el número de la caja: ");
		    int seleccion = sc.nextInt();

		    if (seleccion > 0 && seleccion <= cajas.size()) {
		        cajaSeleccionada = cajas.get(seleccion - 1);

		        if (cajaSeleccionada.getTipo() == TipoCaja.RAPIDA && cliente.getCarrito().getProductos().size() > 5) {
		            System.out.println("No puede usar la caja rápida porque tiene más de 5 productos.");
		            System.out.println("Por favor, seleccione otra caja.");
		            continue;
		        }

		        System.out.println("Ha seleccionado la caja: " + cajaSeleccionada.getNombre());
		        break; // Caja seleccionada correctamente, salir del bucle
		    } else {
		        System.out.println("Selección inválida. Inténtelo de nuevo.");
		    }
		}

		cajaSeleccionada.setCliente(cliente);
		cliente.setCarrito(carrito); // Asignar el carrito al cliente

		// Aplicar descuento por membresía
		double descuentoMembresia = cliente.calcularDescuentoPorMembresia();
		double precioTotal = Carrito.calcularTotal(carrito.getProductos());
		double precioConDescuento = precioTotal * (1 - descuentoMembresia);

		// Imprimir factura con descuento por membresía
		System.out.println(carrito.generarDetallesFactura(descuentoMembresia, false));

		// Opción de borrar la factura antes de pagar
		System.out.println("¿Desea borrar esta factura antes de pagar?");
		System.out.println("1. Sí");
		System.out.println("2. No");
		int opcionBorrar = sc.nextInt();

		if (opcionBorrar == 1) {
		    carrito.eliminarCarrito(); // Eliminar carrito y devolver productos
		    cliente.setCarrito(null); // Desasignar carrito del cliente
		    cajaSeleccionada.setCliente(null); // Desasignar cliente de la caja
		    System.out.println("Factura eliminada y productos devueltos al inventario.");
		    return;
		}

		// Opción de jugar para obtener más descuento
		System.out.println("¿Desea intentar obtener un descuento adicional jugando?");
		System.out.println("1. Sí");
		System.out.println("2. No");
		int opcionJuego = sc.nextInt();

		boolean ganoJuego = false;
		if (opcionJuego == 1) {
		    boolean tieneMembresia = cliente.getMembresia() != null;
		    if (!tieneMembresia) {
		        System.out.println("Debe pagar 10 mil para intentar jugar.");
		        carrito.incrementarCosto(10000);
		        precioTotal += 10000; // Aumentar el precio total antes de aplicar descuento del juego
		    }

		    // Selección del juego
		    System.out.println("Seleccione un juego:");
		    System.out.println("1. Tres en Raya");
		    System.out.println("2. Ahorcado");
		    int seleccionJuego = sc.nextInt();

		    if (seleccionJuego == 1) {
		        ganoJuego = tresEnRaya();
		    } else if (seleccionJuego == 2) {
		        ganoJuego = juegoAhorcado();
		    }

		    if (ganoJuego) {
		        System.out.println("¡Felicidades! Ha ganado un descuento adicional del 10%.");
		        precioConDescuento *= 0.9; // Aplicar descuento adicional del juego
		    } else {
		        System.out.println("Lo sentimos, no ha ganado el juego.");
		    }
		}

		// Imprimir factura con descuento adicional si ganó el juego
		System.out.println(carrito.generarDetallesFactura(descuentoMembresia, ganoJuego));

		// Confirmar si el cliente desea pagar la factura
		System.out.println("¿Desea pagar la factura?");
		System.out.println("1. Sí");
		System.out.println("2. No");
		int opcionPago = sc.nextInt();

		if (opcionPago == 2) {
		    System.out.println("Ha decidido no pagar la factura. Regresando a la tienda...");
		    cliente.setCarrito(null); // Desasignar carrito del cliente
		    cajaSeleccionada.setCliente(null); // Desasignar cliente de la caja
		    return;
		} else if (opcionPago == 1) {
		    // Verificar si el cliente tiene suficiente saldo
		    double precioFinal = precioConDescuento; // Usar el precio con descuento
		    if (cliente.getDinero() < precioFinal) {
		        System.out.println("No tiene suficiente saldo para pagar la factura. Regresando a la tienda...");
		        cliente.setCarrito(null); // Desasignar carrito del cliente
		        cajaSeleccionada.setCliente(null); // Desasignar cliente de la caja
		        return;
		    }

		    // Marcar la factura como pagada
		    carrito.setPagado(true);
		    cliente.getFacturas().add(carrito); // Registrar la factura en las facturas del cliente

		    // Actualizar saldo de la tienda
		    cliente.getTienda().bajarSaldo(precioFinal);

		    // Restar el monto al saldo del cliente
		    cliente.bajarDinero(precioFinal);

		    // Calcular y descontar el pago del cajero
		    Empleado cajero = cajaSeleccionada.getCajero();
		    double pagoCajero = 20000; // Pago inicial
		    if (cajero.isPrestacionPension()) {
		        pagoCajero += 5000;
		    }
		    if (cajero.isPrestacionSalud()) {
		        pagoCajero += 5000;
		    }
		    cliente.getTienda().bajarSaldo(pagoCajero);

		    // Desasignar referencias
		    cliente.setCarrito(null); // Desasignar carrito del cliente
		    cajaSeleccionada.setCliente(null); // Desasignar cliente de la caja
		    carrito.setCaja(null); // Desasignar caja del carrito

		    System.out.println("La factura ha sido pagada exitosamente.");
		 }


		sc.close();

	}
}

