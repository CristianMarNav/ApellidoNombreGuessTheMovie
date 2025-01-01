import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de manejar la lógica principal del juego "Guess the movie".
 */
public class ApellidoNombreGame {

    private List<String> peliculas; // Lista de peliculas disponibles

    /**
     * Constructor de la clase "ApellidoNombreGame".
     * Inicializa el juego y configura los elementos necesarios.
     */
    public ApellidoNombreGame() {
        // Inicialización de variables y lógica del juego.
        peliculas = new ArrayList<>(); // Inicializamos la lista
        cargarPeliculas(); // Llamamos al método para cargar las películas
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
}
