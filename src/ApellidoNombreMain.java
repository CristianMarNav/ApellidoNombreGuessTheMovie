import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        // Lista para simular letras adivinadas
        List<Character> letrasAdivinadas = new ArrayList<>();

        //Bucle para mostrar el menú hasta que el usuario elija salir
        int opcion;
        do {
            opcion = game.mostrarMenu();
            switch (opcion) {
                case 1: // Adivinar una letra

                    System.out.println("Introduce una letra: ");
                    Scanner scannerLetra = new Scanner(System.in); // Nuevo scanner para capturar la letra
                    char letra = scannerLetra.nextLine().charAt(0); // Capturamos la primera letra
                    letrasAdivinadas.add(letra); // Simulamos que la letra se adivina

                    System.out.println("Progreso actual: " + game.mostrarProgreso(letrasAdivinadas));
                    break;

                case 2: // Adivinar el título completo

                    System.out.println("Introduce el título completo: ");
                    Scanner scannerTitulo = new Scanner(System.in); // Usamos otro scanner para el título
                    String titulo = scannerTitulo.nextLine(); // Captura del título completo

                    if (titulo.equalsIgnoreCase(peliculaSeleccionada)) {
                        System.out.println("¡Correcto! Has adivinado la película.");
                        opcion = 3; // Termina el juego
                    } else {
                        System.out.println("¡Incorrecto! Sigue intentando.");
                    }
                    break;

                case 3: // Salir

                    System.out.println("Gracias por jugar. ¡Hasta pronto!");
                    break;

                default:

                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");

            }
        } while (opcion != 3);

    }
}