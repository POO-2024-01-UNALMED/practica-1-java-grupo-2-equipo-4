package gestorAplicación.servicios;

public interface Juego {
    void iniciar();
    boolean jugar(int posicion);
    boolean haGanado();
    boolean haPerdido();
    String obtenerEstado();
}
