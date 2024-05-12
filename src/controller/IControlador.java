package controller;

import java.util.ArrayList;

import excepciones.CreateException;
import model.Coleccion;
import model.Partida;
import model.Usuario;

public interface IControlador {

    public Usuario logIn(String user, String contrasena) throws CreateException;

    public void registro(Usuario usuario) throws CreateException;

    public void crearColeccion(String dni) throws CreateException;

    public Coleccion getColeccion(String dni) throws CreateException;

    public void ascender(String dni) throws CreateException;

    public void actualizarColeccion(String dni, Coleccion coleccion) throws CreateException;

    public void crearPartida(Partida partida) throws CreateException;

    public void asignarJugadoresAPartida(int partida_id, String jugadores_dni[]) throws CreateException;

    public void modificarPartida(Partida partida) throws CreateException;

    public ArrayList<Partida> verPartidas(String dni) throws CreateException;

    public ArrayList<Partida> verPartidas() throws CreateException;

    public ArrayList<Usuario> verJugadores() throws CreateException;

    public void eliminarJugador(String dni) throws CreateException;
}

