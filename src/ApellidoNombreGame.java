import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase encargada de manejar la lógica principal del juego "Guess the movie".
 */
public class ApellidoNombreGame {
    private List<String> peliculas; // Lista de peliculas disponibles
    private String peliculaSeleccionada; // Película seleccionada para el juego

    /**
     * Constructor de la clase "ApellidoNombreGame".
     * Inicializa el juego y configura los elementos necesarios.
     */
    public ApellidoNombreGame() {
        // Inicialización de variables y lógica del juego.
        peliculas = new ArrayList<>(); // Inicializamos la lista
        cargarPeliculas(); // Llamamos al método para cargar las películas
        peliculaSeleccionada = ""; // Inicializamos con una cadena vacía.
    }

    /**
     * Carga la lista de peliculas disponibles para el juego.
     */
    private void cargarPeliculas() {
        peliculas.add("The Terminator");
        peliculas.add("Back to the Future");
        peliculas.add("E.T");
        peliculas.add("Ghostbusters");
        peliculas.add("The Goonies");
        peliculas.add("Top Gun");
        peliculas.add("Blade Runner");
        peliculas.add("The Breakfast Club");
        peliculas.add("Die Hard");
        peliculas.add("Indiana Jones and the Last Crusade");
    }

    /**
     * Devuelve la lista de peliculas cargadas
     *
     * @return Lista de películas.
     */
    public List<String> getPeliculas() {
        return peliculas;
    }

    /**
     * Selecciona una pelicula aleatoria de la lista de peliculas.
     *
     * @return Película seleccionada aleatoriamente.
     */
    public String seleccionarPeliculaAleatoria() {
        Random random = new Random();
        int indice = random.nextInt(peliculas.size()); // Selecciona un índice aleatorio
        peliculaSeleccionada = peliculas.get(indice); // Guarda la película seleccionada
        return peliculaSeleccionada; // Devuelve la película en ese índice
    }

    /**
     * Muestra el progreso del jugador para la película seleccionada.
     * Las letra no adivinadas se representan con '*'.
     *
     * @param letrasAdivinadas Lista de Letras que el jugador ha adivinado.
     * @return Progreso actual de la película en formato String.
     */
    public String mostrarProgreso(List<Character> letrasAdivinadas) {
        StringBuilder progreso = new StringBuilder();

        for (char letra : peliculaSeleccionada.toCharArray()) {
            if (letrasAdivinadas.contains(letra) || !Character.isLetter(letra)) {
                progreso.append(letra); // Muestra la letra adivinada o cualquier carácter que no sea letra
            } else {
                progreso.append('*'); // Reemplaza las letras no adivinadas
            }
        }

        return progreso.toString();

    }

    /**
     * Mostramos un menú con opciones para leer la elección del usuario.
     *
     * @return Opción elegida por el usuario.
     */

    public int mostrarMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. 🎥 Adivinar una letra");
        System.out.println("2. 🏆 Adivinar el título completo");
        System.out.println("3. ❌ Salir");
        System.out.println("Elige una opción: ");

        Scanner scanner = new Scanner(System.in);
        String opcionStr = scanner.nextLine(); // Capturamos como String

        // Verificamos si la entrada es un número válido
        int opcion = -1; // Valor defecto en caso de que la opción no sea válida
        boolean valido = false;

        while (!valido) {
            try {
                opcion = Integer.parseInt(opcionStr); // Convertimos a int
                if (opcion >= 1 && opcion <= 3) {
                    valido = true; // La opción es válida
                } else {
                    System.out.println("Opción no válida. Por favor, elige una opción del menú");
                    System.out.println("Elige una opción: ");
                    opcionStr = scanner.nextLine(); // Volvemos a pedir la opción
                }
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                System.out.println("Elige una opción: ");
                opcionStr = scanner.nextLine(); // Volvemos a pedir la opción
            }
        }
        return opcion; // Aseguramos de retornar la opción valida
    }
}


