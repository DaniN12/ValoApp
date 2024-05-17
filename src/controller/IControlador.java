package controller;

import excepciones.CreateException;
import model.Coleccion;
import model.Partida;
import model.Usuario;
import java.util.ArrayList;

/**
 * Interfaz que define las operaciones que puede realizar el controlador del sistema.
 */
public interface IControlador {

    /**
     * Realiza el inicio de sesión de un usuario.
     *
     * @param user       Nombre de usuario.
     * @param contrasena Contraseña del usuario.
     * @return El usuario que inició sesión.
     * @throws CreateException Si ocurre un error durante el inicio de sesión.
     */
    public Usuario logIn(String user, String contrasena) throws CreateException;

    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param usuario El usuario a registrar.
     * @throws CreateException Si ocurre un error durante el registro.
     */
    public void registro(Usuario usuario) throws CreateException;

    /**
     * Crea una nueva colección para un usuario.
     *
     * @param dni DNI del usuario.
     * @throws CreateException Si ocurre un error durante la creación de la colección.
     */
    public void crearColeccion(String dni) throws CreateException;

    /**
     * Obtiene la colección de un usuario.
     *
     * @param dni DNI del usuario.
     * @return La colección del usuario.
     * @throws CreateException Si ocurre un error al obtener la colección.
     */
    public Coleccion getColeccion(String dni) throws CreateException;

    /**
     * Asciende a un usuario.
     *
     * @param dni DNI del usuario.
     * @throws CreateException Si ocurre un error durante la operación de ascenso.
     */
    public void ascender(String dni) throws CreateException;

    /**
     * Actualiza la colección de un usuario.
     *
     * @param dni       DNI del usuario.
     * @param coleccion La colección actualizada.
     * @throws CreateException Si ocurre un error durante la actualización de la colección.
     */
    public void actualizarColeccion(String dni, Coleccion coleccion) throws CreateException;

    /**
     * Crea una nueva partida.
     *
     * @param partida La partida a crear.
     * @throws CreateException Si ocurre un error durante la creación de la partida.
     */
    public void crearPartida(Partida partida) throws CreateException;

    /**
     * Asigna jugadores a una partida.
     *
     * @param partida_id    ID de la partida.
     * @param jugadores_dni Array de DNI de los jugadores.
     * @throws CreateException Si ocurre un error durante la asignación de jugadores.
     */
    public void asignarJugadoresAPartida(int partida_id, String jugadores_dni[]) throws CreateException;

    /**
     * Modifica una partida existente.
     *
     * @param partida La partida modificada.
     * @throws CreateException Si ocurre un error durante la modificación de la partida.
     */
    public void modificarPartida(Partida partida) throws CreateException;

    /**
     * Obtiene las partidas de un usuario.
     *
     * @param dni DNI del usuario.
     * @return Una lista de partidas del usuario.
     * @throws CreateException Si ocurre un error al obtener las partidas.
     */
    public ArrayList<Partida> verPartidas(String dni) throws CreateException;

    /**
     * Obtiene todas las partidas.
     *
     * @return Una lista de todas las partidas.
     * @throws CreateException Si ocurre un error al obtener las partidas.
     */
    public ArrayList<Partida> verPartidas() throws CreateException;

    /**
     * Obtiene todos los jugadores registrados en el sistema.
     *
     * @return Una lista de todos los jugadores.
     * @throws CreateException Si ocurre un error al obtener los jugadores.
     */
    public ArrayList<Usuario> verJugadores() throws CreateException;

    /**
     * Elimina un jugador del sistema.
     *
     * @param dni DNI del jugador a eliminar.
     * @throws CreateException Si ocurre un error durante la eliminación del jugador.
     */
    public void eliminarJugador(String dni) throws CreateException;

    /**
     * Modifica la información de un jugador.
     *
     * @param usuario El jugador con la información modificada.
     * @throws CreateException Si ocurre un error durante la modificación del jugador.
     */
    public void modificarJugador(Usuario usuario) throws CreateException;

    /**
     * Obtiene el oponente de un jugador en una partida.
     *
     * @param dniJugador DNI del jugador.
     * @param partida_id ID de la partida.
     * @param oponente   DNI del oponente.
     * @return El DNI del oponente del jugador en la partida especificada.
     * @throws CreateException Si ocurre un error al obtener el oponente.
     */
    public String getOponente(String dniJugador, int partida_id, String oponente) throws CreateException;
}
