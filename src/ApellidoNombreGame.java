import java.io.BufferedReader; // Importa la clase "BufferedReader", se usa para leer datos de un archivo de texto línea por línea.
import java.io.FileReader; // Importa la clase "FileReader", permite abrir y leer archivos de texto.
import java.io.IOException; // Importa la clase IOException, maneja errores durante la lectura de archivos.
import java.util.ArrayList; // Importa la clase "ArrayList", implementación de lista dinámica.
import java.util.List; // Importa la interfaz "List", define la estructura de la lista, utilizada para almacenar las películas.
import java.util.Random; // Importa la clase "Random", genera números aleatorios, usada para seleccionar una película aleatoria.
import java.util.Scanner; // Importa la clase "Scanner", permite leer entradas del usuario desde la consola.

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
        cargarPeliculas();             // Llamamos al método para cargar las películas
        peliculaSeleccionada = "";     // Inicializamos con una cadena vacía.
    }

    /**
     * Carga la lista de peliculas disponibles para el juego desde el archivo "peliculas.txt"
     */
    private void cargarPeliculas() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/peliculas.txt"))) {
            String linea;
            while ((linea = br.readLine()) !=null) {
                peliculas.add(linea); // Añadimos cada pelicula a la lista
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de películas");
        }
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
        return peliculaSeleccionada.replaceAll(".","*"); // Oculta la película reemplazando las letras por asteriscos
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
        System.out.println("1. 🧠 Adivinar una letra");
        System.out.println("2. 🎥 Adivinar el título completo");
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


