package main;

import controller.Controlador;
import view.LoginView;


/**
 * La clase Main es la clase principal que inicia la aplicación.
 * Crea una instancia del controlador y la vista de inicio de sesión,
 * luego hace visible la vista.
 */
public class Main {

    /**
     * Método principal que inicia la aplicación.
     * @param args Los argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {

        // Crea una instancia del controlador
        Controlador datos = new Controlador();

        // Crea una instancia de la vista de inicio de sesión y la hace visible
        LoginView lv = new LoginView(datos);
        lv.setVisible(true);

    }
}
