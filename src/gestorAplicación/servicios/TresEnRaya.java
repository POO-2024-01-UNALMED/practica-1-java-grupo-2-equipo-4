package gestorAplicación.servicios;

import java.util.Random;

public class TresEnRaya implements Juego{
	    private char[][] tablero;
	    private char jugador = 'X';
	    private char maquina = 'O';

	    public TresEnRaya() {
	        tablero = new char[3][3];
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                tablero[i][j] = ' ';
	            }
	        }
	    }

	    @Override
	    public void iniciar() {
	        // Inicializa el tablero y establece el jugador inicial
	    }

	    @Override
	    public boolean jugar(int posicion) {
	        int fila = posicion / 3;
	        int columna = posicion % 3;
	        if (tablero[fila][columna] == ' ') {
	            tablero[fila][columna] = jugador;
	            if (!haGanado()) {
	                jugarMaquina();
	            }
	            return true;
	        }
	        return false;
	    }

	    private void jugarMaquina() {
	        Random rand = new Random();
	        int fila, columna;
	        do {
	            fila = rand.nextInt(3);
	            columna = rand.nextInt(3);
	        } while (tablero[fila][columna] != ' ');
	        tablero[fila][columna] = maquina;
	    }

	    @Override
	    public boolean haGanado() {
	        return checkWin(jugador) || checkWin(maquina);
	    }

	    private boolean checkWin(char jugador) {
	        for (int i = 0; i < 3; i++) {
	            if (tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) return true;
	            if (tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador) return true;
	        }
	        if (tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) return true;
	        if (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador) return true;
	        return false;
	    }

	    @Override
	    public boolean haPerdido() {
	        return haGanado() && !hayEspacios();
	    }

	    private boolean hayEspacios() {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                if (tablero[i][j] == ' ') return true;
	            }
	        }
	        return false;
	    }

	    @Override
	    public String obtenerEstado() {
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                sb.append(tablero[i][j]);
	                if (j < 2) sb.append(" | ");
	            }
	            sb.append("\n");
	            if (i < 2) sb.append("---------\n");
	        }
	        return sb.toString();
	    }
	}
