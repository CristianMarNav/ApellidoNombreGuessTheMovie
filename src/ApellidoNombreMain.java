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
    }
 }