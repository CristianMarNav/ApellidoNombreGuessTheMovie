import java.io.BufferedReader; // Importa la clase "BufferedReader", se usa para leer datos de un archivo de texto línea por línea
import java.io.FileReader;     // Importa la clase "FileReader", permite abrir y leer archivos de texto
import java.io.IOException;    // Importa la clase IOException, maneja errores durante la lectura de archivos
import java.util.ArrayList;    // Importa la clase "ArrayList", implementación de lista dinámica
import java.util.List;         // Importa la interfaz "List", define la estructura de la lista, utilizada para almacenar las películas
import java.util.Random;       // Importa la clase "Random", genera números aleatorios, usada para seleccionar una película aleatoria

/**
 * Clase encargada de manejar la lógica principal del juego "Guess the movie".
 */
public class ApellidoNombreGame {
    private final List<String> peliculas;      // Lista de peliculas disponibles
    private String peliculaSeleccionada; // Película seleccionada para el juego
    private int intentos; // Número de intentos restantes
    private int puntuacion; // Puntuación del jugador

    /**
     * Constructor de la clase "ApellidoNombreGame".
     * Inicializa el juego y configura los elementos necesarios.
     */
    public ApellidoNombreGame() {
        // Inicialización de variables y lógica del juego.
        intentos = 10;                   // 10 intentos al principio
        puntuacion = 0;                  // Puntuación inicial
        peliculas = new ArrayList<>();
        cargarPeliculas();               // Cargamos las películas desde el archivo
    }

    /**
     * Carga la lista de peliculas disponibles para el juego desde el archivo "peliculas.txt"
     * Lee desde el archivo y las agrega a la lista de películas
     */
    private void cargarPeliculas() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/peliculas.txt"))) {
            String linea;
            while ((linea = br.readLine()) !=null) {
                peliculas.add(linea.trim()); // Añade cada pelicula a la lista
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de películas");
        }
    }

    /**
     * Selecciona una pelicula aleatoria de la lista de peliculas.
     * @return Película seleccionada aleatoriamente.
     */
    public String seleccionarPeliculaAleatoria() {
        Random random = new Random();
        int indice = random.nextInt(peliculas.size()); // Selecciona un índice aleatorio
        peliculaSeleccionada = peliculas.get(indice);  // Guarda la película seleccionada
        return peliculaSeleccionada;                   // Oculta la película reemplazando las letras por asteriscos
    }

    /**
     * Muestra el progreso del jugador para la película seleccionada.
     * Las letra no adivinadas se representan con '*'.
     *
     * @param  letrasAdivinadas Lista de Letras que el jugador ha adivinado.
     * @return Progreso actual de la película en formato String.
     */
    public String mostrarProgreso(List<Character> letrasAdivinadas) {
        StringBuilder progreso = new StringBuilder();

        // Recorremos cada letra del título de la película
        for (char letra : peliculaSeleccionada.toCharArray()) {
            if (letrasAdivinadas.contains(Character.toLowerCase(letra)) || !Character.isLetter(letra)) {
                progreso.append(letra); // Muestra la letra adivinada o cualquier carácter que no sea letra
            } else {
                progreso.append('*'); // Reemplaza las letras no adivinadas con '*'
            }
        }
        return progreso.toString(); // Retorna el progreso actual como cadena
    }

    /**
     * Permite al jugador adivinar una letra en la película.
     *
     * @param letra "La Letra que el jugador intenta adivinar".
     * @param letrasAdivinadas "Lista de letras que ya han sido adivinada".
     * @return true si la letra está en la película, false si no está.
     */
    public boolean adivinarLetra(char letra, List<Character> letrasAdivinadas) {

        if (letrasAdivinadas.contains(letra)) {
            System.out.println("Ya has adivinado esta letra anteriormente.");
            return false;      // Si la letra ya ha sido adivinada, no restamos puntos ni intentos
        }

        // Si la letra está en la película, incrementamos la puntuación y agregamos la letra a la lista
        if (peliculaSeleccionada.toLowerCase().contains(String.valueOf(Character.toLowerCase(letra)))) {
            puntuacion += 10;            // Aumenta los puntos si la letra es correcta
            letrasAdivinadas.add(letra); // Agrega la letra adivinada a la lista
            return true;                 // Letra correcta
        } else {
            intentos --;                 // Resta un intento si la letra es incorrecta
            letrasAdivinadas.add(letra); // Agrega la letra adivinada a la lista aunque sea incorrecta
            return false;                // Letra incorrecta
        }
    }

    /**
     * Permite al jugador adivinar el título completo de la película.
     *
     * @param titulo "El titulo completo adivinado por el jugador".
     * @return true si el título adivinado es correcto, false si
     */
    public boolean adivinarTitulo(String titulo) {
        return peliculaSeleccionada.equalsIgnoreCase(titulo); // Compara el título ignorando mayúsculas/minúsculas
    }
}