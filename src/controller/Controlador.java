package controller;

import excepciones.CreateException;
import model.Coleccion;
import model.Partida;
import model.Usuario;
import java.util.ArrayList;
import java.sql.*;

/**
 * Clase que implementa la interfaz IControlador y proporciona las funcionalidades del controlador del sistema.
 */
public class Controlador implements IControlador {

    private Connection con;
    private PreparedStatement stmt;
    private ConnectionOpenClose conection = new ConnectionOpenClose();

    // Sentencias SQL
    final String INSERTjugador = "INSERT INTO Usuario VALUES (?, ?, ?, ?, ?, ?, ?, 0)";
    final String INSERTcoleccion = "INSERT INTO Coleccion VALUES (?, ?, ?, ?, ?)";
    final String INSERTpartida = "INSERT INTO Partida VALUES (?, ?, ?)";
    final String INSERTparticipa = "INSERT INTO Participa VALUES (?, ?)";

    final String UPDATEcoleccion = "UPDATE Coleccion SET armaFav = ?, skinFav = ?, agenteFav = ? WHERE dni_jugador = ?";
    final String UPDATEesAdmin = "UPDATE Usuario SET esAdmin = 1 WHERE dni = ?";
    final String UPDATEpartida = "UPDATE Partida SET mapa = ?, fecha = ? WHERE partida_ID = ?";
    final String UPDATEjugador = "UPDATE Usuario SET nombre = ?, apellido = ?, contrasena = ?, sexo = ? WHERE dni = ?";

    final String SELECTusuario = "SELECT * FROM Usuario WHERE username = ? AND contrasena = ?";
    final String SELECTpartidas = "SELECT pa.partida_ID, mapa, fecha FROM Partida pa, Participa pp, Usuario u WHERE pa.partida_ID = pp.partida_ID AND u.dni = pp.dni AND u.dni = ?";
    final String SELECTpartidasTodo = "SELECT * FROM Partida";
    final String SELECTjugadores = "SELECT * FROM Usuario WHERE esAdmin = 0";
    final String SELECTcoleccion = "{CALL SelectColeccion(?)}";
    final String SELECToponente = "SELECT ObtenerOponente(?, ?) AS oponente";

    final String DELETEjugador = "DELETE FROM Usuario WHERE dni = ?";

    /**
     * Realiza el inicio de sesión de un usuario.
     *
     * @param user       Nombre de usuario.
     * @param contrasena Contraseña del usuario.
     * @return El usuario que inició sesión.
     * @throws CreateException Si ocurre un error durante el inicio de sesión.
     */
	@Override
	public Usuario logIn(String user, String contrasena) throws CreateException {

		// Declaro las variables
		ResultSet rs = null;
		Usuario usuario = null;

		// Abro la conexióm
		con = conection.openConnection();

		try {

			// Preparo la query
			stmt = con.prepareStatement(SELECTusuario);

			// Meto los valores de la query
			stmt.setString(1, user);
			stmt.setString(2, contrasena);

			// Ejecuto la sentencia
			rs = stmt.executeQuery();

			// Elijo los valores que quiero sacar y meter a la variable cliente
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setDni(rs.getString("dni"));
				usuario.setNombre(rs.getNString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setUsername(user);
				usuario.setContrasena(contrasena);
				usuario.setSexo(rs.getString("sexo"));
				usuario.setNacimiento(rs.getDate("fecha_nac"));
				usuario.setEsAdmin(rs.getBoolean("esAdmin"));
			}

		} catch (SQLException e) {

			System.out.println("Error al ejecutar la query (error en los datos)");
			String error = "Usuario o contraseña incorrectos";
			CreateException ex = new CreateException(error);
			throw ex;

		} finally {
			// Cerramos ResultSet
			if (rs != null) {
				try {

					// Cierro el resultset
					rs.close();
				} catch (SQLException e1) {

					System.out.println("Error al cerrar ResultSet");
					String error = "Usuario o contraseña incorrectos";
					CreateException ex = new CreateException(error);
					throw ex;
				}
			}
			// Cierro la conexión
			conection.closeConnection(stmt, con);
		}
		// devuelve el usuario completo
		return usuario;
	}
	
	/**
     * Registra un nuevo usuario en el sistema.
     *
     * @param usuario El usuario a registrar.
     * @throws CreateException Si ocurre un error durante el registro.
     */

	@Override
	public void registro(Usuario usuario) throws CreateException {
		// Abrimos la conexión
		con = conection.openConnection();
		try {
			stmt = con.prepareStatement(INSERTjugador);

			stmt.setString(1, usuario.getDni());
			stmt.setString(2, usuario.getNombre());
			stmt.setString(3, usuario.getApellido());
			stmt.setString(4, usuario.getUsername());
			stmt.setString(5, usuario.getContrasena());
			stmt.setString(6, usuario.getSexo());
			stmt.setDate(7, usuario.getNacimiento());

			// Ejecuto la actualización de la base de datos
			stmt.executeUpdate();

		} catch (SQLException e1) {

			System.out.println("Error al ejecutar la query");
			String error = "Error al registrar el jugador";
			CreateException ex = new CreateException(error);
			throw ex;

		} finally {
			// Cierro la conexión con la base de datos
			conection.closeConnection(stmt, con);
		}

	}

	/**
     * Asciende a un usuario.
     *
     * @param dni DNI del usuario.
     * @throws CreateException Si ocurre un error durante la operación de ascenso.
     */
	
	@Override
	public void ascender(String dni) throws CreateException {
		con = conection.openConnection();
		try {
			stmt = con.prepareStatement(UPDATEesAdmin);

			stmt.setString(1, dni);
			// Ejecuto la actualización de la base de datos
			stmt.executeUpdate();

		} catch (SQLException e1) {

			System.out.println("Error al ejecutar la query");
			String error = "Error al ascender al jugador";
			CreateException ex = new CreateException(error);
			throw ex;

		} finally {
			// Cierro la conexión con la base de datos
			conection.closeConnection(stmt, con);
		}

	}
	
	/**
     * Actualiza la colección de un usuario.
     *
     * @param dni       DNI del usuario.
     * @param coleccion La colección actualizada.
     * @throws CreateException Si ocurre un error durante la actualización de la colección.
     */

	@Override
	public void actualizarColeccion(String dni, Coleccion coleccion) throws CreateException {
		con = conection.openConnection();
		try {
			stmt = con.prepareStatement(UPDATEcoleccion);
			// UPDATE Coleccion SET armaFav = 1, skinFav = 2, agenteFav = 3 WHERE
			// dni_jugador = 4
			stmt.setString(1, coleccion.getArmaFav());
			stmt.setString(2, coleccion.getSkinFav());
			stmt.setString(3, coleccion.getAgenteFav());
			stmt.setString(4, dni);
			// Ejecuto la actualización de la base de datos
			stmt.executeUpdate();

		} catch (SQLException e1) {

			System.out.println("Error al ejecutar la query");
			String error = "Error al actualizar la colección";
			CreateException ex = new CreateException(error);
			throw ex;

		} finally {
			// Cierro la conexión con la base de datos
			conection.closeConnection(stmt, con);
		}

	}
	
	/**
     * Crea una nueva partida.
     *
     * @param partida La partida a crear.
     * @throws CreateException Si ocurre un error durante la creación de la partida.
     */

	@Override
	public void crearPartida(Partida partida) throws CreateException {
		con = conection.openConnection();
		try {
			stmt = con.prepareStatement(INSERTpartida);
			// INSERTpartida = "INSERT INTO Partida VALUES (?, ?, ?)"
			stmt.setInt(1, partida.getPartida_id());
			stmt.setString(2, partida.getMapa());
			stmt.setDate(3, partida.getFecha());
			// Ejecuto la actualización de la base de datos
			stmt.executeUpdate();

		} catch (SQLException e1) {

			System.out.println("Error al ejecutar la query");
			String error = "Error al crear la partida";
			CreateException ex = new CreateException(error);
			throw ex;

		} finally {
			// Cierro la conexión con la base de datos
			conection.closeConnection(stmt, con);
		}

	}
	
	/**
     * Crea una nueva colección para un usuario.
     *
     * @param dni DNI del usuario.
     * @throws CreateException Si ocurre un error durante la creación de la colección.
     */

	@Override
	public void crearColeccion(String dni) throws CreateException {

		con = conection.openConnection();
		try {
			stmt = con.prepareStatement(INSERTcoleccion);
			int id = (int) (Math.random() * (999));
			stmt.setInt(1, id);
			stmt.setString(2, "Vandal");
			stmt.setString(3, "Default");
			stmt.setString(4, "Astra");
			stmt.setString(5, dni);

			// Ejecuto la actualización de la base de datos
			stmt.executeUpdate();

		} catch (SQLException e1) {

			System.out.println("Error al ejecutar la query");
			String error = "Error al crear la coleccion";
			CreateException ex = new CreateException(error);
			throw ex;

		} finally {
			// Cierro la conexión con la base de datos
			conection.closeConnection(stmt, con);
		}
	}
	
	/**
     * Asigna jugadores a una partida.
     *
     * @param partida_id    ID de la partida.
     * @param jugadores_dni Array de DNI de los jugadores.
     * @throws CreateException Si ocurre un error durante la asignación de jugadores.
     */

	@Override
	public void asignarJugadoresAPartida(int partida_id, String[] jugadores) throws CreateException {
		// Abrimos la conexión
		con = conection.openConnection();
		try {

			for (int i = 0; i < 2; i++) {
				stmt = con.prepareStatement(INSERTparticipa);

				stmt.setString(1, jugadores[i]);
				stmt.setInt(2, partida_id);

				stmt.executeUpdate();
			}

		} catch (SQLException e1) {

			System.out.println("Error al ejecutar la query");
			String error = "Error al introducir los jugadores";
			CreateException ex = new CreateException(error);
			throw ex;

		} finally {
			// Cierro la conexión con la base de datos
			conection.closeConnection(stmt, con);
		}

	}
	
	 /**
     * Modifica una partida existente.
     *
     * @param partida La partida modificada.
     * @throws CreateException Si ocurre un error durante la modificación de la partida.
     */

	@Override
	public void modificarPartida(Partida partida) throws CreateException {
		// Abrimos la conexión
		con = conection.openConnection();
		try {

			for (int i = 0; i < 10; i++) {
				// UPDATEpartida = "UPDATE Partida SET mapa = ?, fecha = ? WHERE partida_ID = ?"
				stmt = con.prepareStatement(UPDATEpartida);

				stmt.setString(1, partida.getMapa());
				stmt.setDate(2, partida.getFecha());
				stmt.setInt(3, partida.getPartida_id());

				stmt.executeUpdate();
			}

		} catch (SQLException e1) {

			System.out.println("Error al ejecutar la query");
			String error = "Error al introducir los jugadores";
			CreateException ex = new CreateException(error);
			throw ex;

		} finally {
			// Cierro la conexión con la base de datos
			conection.closeConnection(stmt, con);
		}

	}
	
	/**
     * Obtiene las partidas de un usuario.
     *
     * @param dni DNI del usuario.
     * @return Una lista de partidas del usuario.
     * @throws CreateException Si ocurre un error al obtener las partidas.
     */

	@Override
	public ArrayList<Partida> verPartidas(String dni) throws CreateException {

		ResultSet rs = null;
		Partida p;
		ArrayList<Partida> ps = new ArrayList<>();

		con = conection.openConnection();
		try {
			stmt = con.prepareStatement(SELECTpartidas);
			stmt.setString(1, dni);
			rs = stmt.executeQuery();

			while (rs.next()) {

				p = new Partida();
				p.setPartida_id(rs.getInt("partida_ID"));
				p.setMapa(rs.getString("mapa"));
				p.setFecha(rs.getDate("fecha"));

				ps.add(p);

			}

		} catch (SQLException e) {

			System.out.println("Error al ejecutar la query");
			String error = "Error al buscar las partidas";
			CreateException ex = new CreateException(error);
			throw ex;
		} finally {
			// Cerramos ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println("Error al cerrar ResultSet");
					String error = "Error al buscar las partidas";
					CreateException ex = new CreateException(error);
					throw ex;
				}
			}
			conection.closeConnection(stmt, con);
		}

		return ps;
	}

	 /**
     * Obtiene todos los jugadores registrados en el sistema.
     *
     * @return Una lista de todos los jugadores.
     * @throws CreateException Si ocurre un error al obtener los jugadores.
     */
	
	@Override
	public ArrayList<Usuario> verJugadores() throws CreateException {
		ResultSet rs = null;
		Usuario u;
		ArrayList<Usuario> jugadores = new ArrayList<>();

		con = conection.openConnection();
		try {
			stmt = con.prepareStatement(SELECTjugadores);
			rs = stmt.executeQuery();

			while (rs.next()) {

				u = new Usuario();
				u.setDni(rs.getString("dni"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido(rs.getString("apellido"));
				u.setUsername(rs.getString("username"));
				u.setContrasena(rs.getString("contrasena"));
				u.setSexo(rs.getString("Sexo"));
				u.setNacimiento(rs.getDate("fecha_nac"));
				u.setEsAdmin(false);

				jugadores.add(u);

			}

		} catch (SQLException e) {

			System.out.println("Error al ejecutar la query");
			String error = "Error al buscar los jugadores";
			CreateException ex = new CreateException(error);
			throw ex;
		} finally {
			// Cerramos ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println("Error al cerrar ResultSet");
					String error = "Error al buscar los jugadores";
					CreateException ex = new CreateException(error);
					throw ex;
				}
			}
			conection.closeConnection(stmt, con);
		}

		return jugadores;
	}
	
	/**
     * Elimina un jugador del sistema.
     *
     * @param dni DNI del jugador a eliminar.
     * @throws CreateException Si ocurre un error durante la eliminación del jugador.
     */

	@Override
	public void eliminarJugador(String dni) throws CreateException {

		// Abrimos la conexión
		con = conection.openConnection();

		// Meto los valores del artículo dentro del stmt:
		try {

			stmt = con.prepareStatement(DELETEjugador);
			stmt.setString(1, dni);

			// Ejecuto la sentencia
			stmt.executeUpdate();

		} catch (SQLException e1) {

			System.out.println("Error al ejecutar la query");
			String error = "Error al banear al jugador";
			CreateException ex = new CreateException(error);
			throw ex;
		} finally {
			// Cierro la conexión
			conection.closeConnection(stmt, con);
		}

	}
	
	/**
     * Obtiene todas las partidas.
     *
     * @return Una lista de todas las partidas.
     * @throws CreateException Si ocurre un error al obtener las partidas.
     */

	@Override
	public ArrayList<Partida> verPartidas() throws CreateException {
		ResultSet rs = null;
		Partida p;
		ArrayList<Partida> partidas = new ArrayList<>();

		con = conection.openConnection();
		try {
			stmt = con.prepareStatement(SELECTpartidasTodo);
			rs = stmt.executeQuery();

			while (rs.next()) {

				p = new Partida();
				p.setFecha(rs.getDate("fecha"));
				p.setMapa(rs.getString("mapa"));
				p.setPartida_id(rs.getInt("partida_ID"));

				partidas.add(p);

			}

		} catch (SQLException e) {

			System.out.println("Error al ejecutar la query");
			String error = "Error al buscar las partidas";
			CreateException ex = new CreateException(error);
			throw ex;
		} finally {
			// Cerramos ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println("Error al cerrar ResultSet");
					String error = "Error al buscar las partidas";
					CreateException ex = new CreateException(error);
					throw ex;
				}
			}
			conection.closeConnection(stmt, con);
		}

		return partidas;
	}

	/**
     * Modifica la información de un jugador.
     *
     * @param usuario El jugador con la información modificada.
     * @throws CreateException Si ocurre un error durante la modificación del jugador.
     */

	@Override
	public void modificarJugador(Usuario usuario) throws CreateException {
		con = conection.openConnection();
		try {
			stmt = con.prepareStatement(UPDATEjugador);
			// UPDATE Usuario SET nombre = 1, apellido = 2, contrasena = 3, sexo = 4 WHERE
			// dni = ?
			stmt.setString(1, usuario.getNombre());
			stmt.setString(2, usuario.getApellido());
			stmt.setString(3, usuario.getContrasena());
			stmt.setString(4, usuario.getSexo());
			stmt.setString(5, usuario.getDni());

			// Ejecuto la actualización de la base de datos
			stmt.executeUpdate();

		} catch (SQLException e1) {

			System.out.println("Error al ejecutar la query");
			String error = "Error al actualizar el jugador";
			CreateException ex = new CreateException(error);
			throw ex;

		} finally {
			// Cierro la conexión con la base de datos
			conection.closeConnection(stmt, con);
		}

	}
	
	/**
     * Obtiene la colección de un usuario.
     *
     * @param dni DNI del usuario.
     * @return La colección del usuario.
     * @throws CreateException Si ocurre un error al obtener la colección.
     */
	
	@Override
	public Coleccion getColeccion(String dni) throws CreateException {
		ResultSet rs = null;
		Coleccion c = new Coleccion();

		con = conection.openConnection();
		try {
			CallableStatement llamarProc = (CallableStatement) this.con.prepareCall(SELECTcoleccion);
			llamarProc.setString(1, dni);
			rs = llamarProc.executeQuery();

			while (rs.next()) {
				c.setArmaFav(rs.getString("arma"));
				c.setAgenteFav(rs.getString("agente"));
				c.setColeccion_id(rs.getInt("idCol"));
				c.setDni_jugador(dni);
				c.setSkinFav(rs.getString("skin"));
			}

		} catch (SQLException e) {
			System.out.println("Error al ejecutar la query");
			throw new CreateException("Error al obtener la coleccion del usuario");
		} finally {
			// Cerramos ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println("Error al cerrar ResultSet");
					throw new CreateException("Error al cerrar el result set");
				}
			}
			conection.closeConnection(stmt, con);
		}
		return c;
	}

	/**
     * Obtiene el oponente de un jugador en una partida.
     *
     * @param dniJugador DNI del jugador.
     * @param partida_id ID de la partida.
     * @param oponente   DNI del oponente.
     * @return El DNI del oponente del jugador en la partida especificada.
     * @throws CreateException Si ocurre un error al obtener el oponente.
     */
	
	@Override
	public String getOponente(String dniJugador, int partida_id, String oponente) throws CreateException {
		ResultSet rs = null;

		con = conection.openConnection();
		try {
			CallableStatement llamarProc = (CallableStatement) this.con.prepareCall(SELECToponente);
			llamarProc.setString(1, dniJugador);
			llamarProc.setInt(2, partida_id);;
			rs = llamarProc.executeQuery();

			while (rs.next()) {
				oponente = rs.getString("oponente");
			}

		} catch (SQLException e) {
			System.out.println("Error al ejecutar la query");
			throw new CreateException("Error al obtener al oponente");
		} finally {
			// Cerramos ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println("Error al cerrar ResultSet");
					throw new CreateException("Error al obtener al oponente");
				}
			}
			conection.closeConnection(stmt, con);
		}
		
		return oponente;
	}

}