package main;

import controller.Controlador;
import view.LoginView;

public class Main {

    public static void main(String[] args) {

        Controlador datos = new Controlador();

        LoginView lv = new LoginView(datos);
        lv.setVisible(true);

    }
}