import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal que inicializa y ejecuta el juego Guess the Movie.
 */
public class ApellidoNombreMain {
    /**
     * Método principal donde comienza la ejecución del programa.
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[]args) {
        System.out.println("Bienvenido a Guess the Movie!");

        // Creamos una instancia del juego
        ApellidoNombreGame game = new ApellidoNombreGame();

        // Mostramos las peliculas cargadas para probar
        System.out.println("Peliculas cargadas: " + game.getPeliculas());

        // Seleccionamos una pelicula aleatoria y la mostramos
        String peliculaSeleccionada = game.seleccionarPeliculaAleatoria();
        System.out.println("Película seleccionada: " + peliculaSeleccionada);

        // Simulamos el progreso del juego
        List<Character> letrasAdivinadas = new ArrayList<>();
        letrasAdivinadas.add('T'); // Simulamos que el jugador adivinó la letra 'T'
        letrasAdivinadas.add('E'); // Simulamos que el jugador adivinó la letra 'E'

        System.out.println("Progreso actual: " + game.mostrarProgreso(letrasAdivinadas));

        // Agregamos otra letra simulada
        letrasAdivinadas.add('R'); // Simulamos que el jugador adivinó la letra 'R'
        System.out.println("Progreso actual: " + game.mostrarProgreso(letrasAdivinadas));
    }
 }