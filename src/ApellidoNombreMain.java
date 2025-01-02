import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que inicializa y ejecuta el juego "Guess the Movie".
 */
public class ApellidoNombreMain {

    /**
     * Método principal donde comienza la ejecución del programa.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        System.out.println("Bienvenido a Guess the Movie!");
        System.out.println("¡Tienes que adivinar la película seleccionada!");
        System.out.println("Solo tienes 10 intentos. Cada vez que te equivoques, perderás un intento.");
        System.out.println("¡Buena suerte!\n");

        // Creamos una instancia del juego
        ApellidoNombreGame game = new ApellidoNombreGame();
        game.seleccionarPeliculaAleatoria(); // Seleccionamos la pelicula aleatoria

        // Mostramos los asteriscos por la pelicula
        System.out.println("Pelicula seleccionada: \"" + game.mostrarProgreso(new ArrayList<>()) + "\"");

        // Lista para simular letras adivinadas
        List<Character> letrasAdivinadas = new ArrayList<>();

        // Inicialización de intentos y puntuación
        int intentos = 10;
        int puntuacion = 0;

        //Bucle para mostrar el menú hasta que el usuario elija salir
        int opcion = 0;
        while (opcion != 3) { // Salir cuando se elija la opción 3
            opcion = mostrarMenu(); // Mostrar el menú

            switch (opcion) {
                case 1: // Opción - "Adivinar una letra"

                    char letra = pedirLetra(); // Capturamos la primera letra
                    letrasAdivinadas.add(letra); // Añadir la letra adivinada

                    // Verificamos si la letra está en el título
                    if (game.adivinarLetra(letra)) {
                        System.out.println("¡Correcto!");
                        puntuacion += 10; // Sumar 10 puntos por letra correcta
                    } else {
                        System.out.println("¡Incorrecto!");
                        intentos--; // Restar 1 intento por letra incorrecta
                        puntuacion -= 10; // Restar 10 puntos por letra incorrecta
                    }

                    //Mostrar progreso
                    System.out.println("Progreso actual: " + game.mostrarProgreso(letrasAdivinadas));
                    System.out.println("Puntuación actual: " + puntuacion);
                    System.out.println("Intentos restantes " + intentos);
                    break;

                case 2: // Opción - "Adivinar el título completo"

                    String titulo = pedirTituloCompleto(); // Capturamos el título completo

                    if (game.adivinarTitulo(titulo)) {
                        System.out.println("¡Correcto! Has adivinado la película.");
                        puntuacion += 20; // Sumar 20 puntos por adivinar el título completo
                    } else {
                        System.out.println("¡Incorrecto! Sigue intentando.");
                        intentos--; // Restar 20 puntos por no adivinar el título completo
                    }
                    break;

                case 3: // Opción - "Salir"

                    System.out.println("Gracias por jugar. ¡Hasta pronto!");
                    break;

                default:

                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
            }

            // Finalizar el juego si se acaban los intentos
            if (intentos == 0) {
                System.out.println("¡Te has quedado sin intentos! El juego ha terminado.");
                System.out.println("El título era: " + game.seleccionarPeliculaAleatoria());
                System.out.println("Tu puntuación final es: " + puntuacion);
            }
        }
    }

    /**
     * Mostramos un menú con opciones para leer la elección del usuario.
     *
     * @return Opción elegida por el usuario.
     */

    public static int mostrarMenu() {

        System.out.println("\n--- Menú ---");
        System.out.println("1. 🧠 Adivinar una letra");
        System.out.println("2. 🎥 Adivinar el título completo");
        System.out.println("3. ❌ Salir");
        System.out.println("Elige una opción: ");

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        boolean valido = false;

        while (!valido) {
            try {
                String opcionStr = scanner.nextLine(); // Leemos la opción
                opcion = Integer.parseInt(opcionStr); // Convertimos a un número entero
                if (opcion >= 1 && opcion <= 3) {
                    valido = true; // La opción es válida
                } else {
                    System.out.println("Opción no válida. Por favor, elige una opción del menú");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida. Por favor, elige una opción del menú.");
            }
        }
        return opcion; // Aseguramos de retornar la opción válida
    }

    /**
     * Método para pedir una letra.
     *
     * @return La letra introducida por el usuario.
     */

    public static char pedirLetra() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce una letra: ");
        String input = scanner.nextLine();

        while (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            System.out.println("Por favor, introduce una sola letra.");
            input = scanner.nextLine();
        }
        return input.charAt(0); // Devolvemos la letra
    }

    /**
     * Método para pedir el título completo de la pelicula.
     *
     * @return El título completo introducido por el usuario.
     */

    public static String pedirTituloCompleto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el título completo: ");
        return scanner.nextLine();
    }
}