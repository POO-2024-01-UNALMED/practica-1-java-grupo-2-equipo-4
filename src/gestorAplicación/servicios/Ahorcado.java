package gestorAplicación.servicios;
import java.util.HashSet;
import java.util.Set;

public class Ahorcado implements Juego {
    private String palabra;
    private Set<Character> letrasAdivinadas;
    private Set<Character> letrasIncorrectas;
    private int errores;

    public Ahorcado(String palabra) {
        this.palabra = palabra.toLowerCase();
        letrasAdivinadas = new HashSet<>();
        letrasIncorrectas = new HashSet<>();
        errores = 0;
    }

    @Override
    public void iniciar() {
        // Inicializa el juego
    }

    @Override
    public boolean jugar(int posicion) {
        char letra = (char) posicion;
        if (palabra.indexOf(letra) != -1) {
            letrasAdivinadas.add(letra);
            return true;
        } else {
            letrasIncorrectas.add(letra);
            errores++;
            return false;
        }
    }

    @Override
    public boolean haGanado() {
        for (char letra : palabra.toCharArray()) {
            if (!letrasAdivinadas.contains(letra)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean haPerdido() {
        return errores >= 6;
    }

    @Override
    public String obtenerEstado() {
        StringBuilder sb = new StringBuilder();
        for (char letra : palabra.toCharArray()) {
            if (letrasAdivinadas.contains(letra)) {
                sb.append(letra);
            } else {
                sb.append('_');
            }
        }
        sb.append("\nLetras incorrectas: ").append(letrasIncorrectas);
        sb.append("\nErrores: ").append(errores);
        return sb.toString();
    }
}
