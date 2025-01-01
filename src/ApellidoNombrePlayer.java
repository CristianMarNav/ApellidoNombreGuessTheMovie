/**
 * Clase que representa al jugador en el juego "Guess the Movie".
 */
public class ApellidoNombrePlayer {
    private String nombre;
    private int intentos;

    /**
     * Constructor de la clase "ApellidoNombrePlayer".
     * @param nombre Nombre del jugador.
     */
    public ApellidoNombrePlayer(String nombre) {
        this.nombre = nombre;
        this.intentos = 0; // Inicializamos los intentos a 0
    }

    /**
     * Obtiene el nombre del jugador.
     * @return Nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Incrementa el número de intentos del jugador.
     */
    public void incrementarIntentos() {
        intentos++;
    }

    /**
     * Obtiene el número de intentos del jugador.
     * @return Número de intentos.
     */
    public int getIntentos() {
        return intentos;
    }
}
