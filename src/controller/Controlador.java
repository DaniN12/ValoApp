package controller;

import java.sql.*;
import java.util.ArrayList;

import model.Coleccion;
import model.Partida;
import model.Usuario;
import excepciones.CreateException;

public class Controlador implements IControlador {

	private Connection con;
	private PreparedStatement stmt;
	private ConnectionOpenClose conection = new ConnectionOpenClose();

	// Sentencias SQL
	final String INSERTjugador = "INSERT INTO Usuario VALUES (?, ?, ?, ?, ?, ?, ?, 0)";
	final String INSERTcoleccion = "INSERT INTO Coleccion VALUES (?, Vandal, Default, Astra, ?)";
	final String INSERTpartida = "INSERT INTO Partida VALUES (?, ?, ?)";
	final String INSERTparticipa = "INSERT INTO Participa VALUES (?, ?)";

	final String UPDATEcoleccion = "UPDATE Coleccion SET armaFav = ?, skinFav = ?, agenteFav = ? WHERE dni_jugador = ?";
	final String UPDATEesAdmin = "UPDATE Usuario SET esAdmin = 1 WHERE username = ?";
	final String UPDATEpartida = "UPDATE Partida SET mapa = ?, fecha = ? WHERE partida_ID = ?";

	final String SELECTusuario = "SELECT * FROM Usuario WHERE username = ? AND contrasena = ?";
	final String SELECTpartidas = "SELECT pa.partida_ID, mapa, fecha FROM Partida pa, Participa pp, Usuario u WHERE pa.partida_ID = pp.partida_ID AND u.dni = pp.dni AND u.dni = ?";
	final String SELECTjugadores = "SELECT * FROM Usuario WHERE esAdmin = 0";

	@Override
	public Usuario logIn(String user, String contrasena) throws CreateException {

		// Declaro las variables
		ResultSet rs = null;
		Usuario usuario = null;

		try {

			// Abro la conexióm
			con = conection.openConnection();
		} catch (SQLException e1) {

			System.out.println("Error al abrir la conexión");
			String error = "Usuario o contraseña incorrectos";
			CreateException ex = new CreateException(error);
			throw ex;
		}

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
			try {

				// Cierro la conexión
				conection.closeConnection(stmt, con);
			} catch (SQLException e) {

				System.out.println("Error al cerrar la conexión");
				String error = "Usuario o contraseña incorrectos";
				CreateException ex = new CreateException(error);
				throw ex;
			}
		}
		// devuelve el usuario completo
		return usuario;
	}

	@Override
	public void registro(Usuario usuario) throws CreateException {
		try {
			// Abrimos la conexión
			con = conection.openConnection();
		} catch (SQLException e2) {

			System.out.println("Error al abrir la conexión");
			String error = "Error al registrar el jugador";
			CreateException ex = new CreateException(error);
			throw ex;

		}
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
			try {
				// Cierro la conexión con la base de datos
				conection.closeConnection(stmt, con);
			} catch (SQLException e) {

				System.out.println("Error al cerrar la conexión");
				String error = "Error al registrar el jugador";
				CreateException ex = new CreateException(error);
				throw ex;
			}
		}

	}

	@Override
	public void ascender(String username) throws CreateException {
		try {

			con = conection.openConnection();
		} catch (SQLException e2) {

			System.out.println("Error al abrir la conexión");
			String error = "Error al ascender al jugador";
			CreateException ex = new CreateException(error);
			throw ex;

		}
		try {
			stmt = con.prepareStatement(UPDATEesAdmin);

			stmt.setString(1, username);
			// Ejecuto la actualización de la base de datos
			stmt.executeUpdate();

		} catch (SQLException e1) {

			System.out.println("Error al ejecutar la query");
			String error = "Error al ascender al jugador";
			CreateException ex = new CreateException(error);
			throw ex;

		} finally {
			try {
				// Cierro la conexión con la base de datos
				conection.closeConnection(stmt, con);
			} catch (SQLException e) {

				System.out.println("Error al cerrar la conexión");
				String error = "Error al ascender al jugador";
				CreateException ex = new CreateException(error);
				throw ex;
			}
		}

	}

	@Override
	public void actualizarColeccion(String dni, Coleccion coleccion) throws CreateException {
		try {

			con = conection.openConnection();
		} catch (SQLException e2) {

			System.out.println("Error al abrir la conexión");
			String error = "Error al actualizar la colección";
			CreateException ex = new CreateException(error);
			throw ex;

		}
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
			try {
				// Cierro la conexión con la base de datos
				conection.closeConnection(stmt, con);
			} catch (SQLException e) {

				System.out.println("Error al cerrar la conexión");
				String error = "Error al actualizar la colección";
				CreateException ex = new CreateException(error);
				throw ex;
			}
		}

	}

	@Override
	public void crearPartida(Partida partida) throws CreateException {
		try {

			con = conection.openConnection();
		} catch (SQLException e2) {

			System.out.println("Error al abrir la conexión");
			String error = "Error al crear la partida";
			CreateException ex = new CreateException(error);
			throw ex;

		}
		try {
			stmt = con.prepareStatement(UPDATEcoleccion);
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
			try {
				// Cierro la conexión con la base de datos
				conection.closeConnection(stmt, con);
			} catch (SQLException e) {

				System.out.println("Error al cerrar la conexión");
				String error = "Error al crear la partida";
				CreateException ex = new CreateException(error);
				throw ex;
			}
		}

	}

	@Override
	public void crearColeccion(String dni) throws CreateException {

		try {

			con = conection.openConnection();
		} catch (SQLException e2) {

			System.out.println("Error al abrir la conexión");
			String error = "Error al crear la coleccion";
			CreateException ex = new CreateException(error);
			throw ex;

		}
		try {
			stmt = con.prepareStatement(INSERTcoleccion);

			stmt.setInt(1, (int) Math.random() * (9999));
			stmt.setString(5, dni);

			// Ejecuto la actualización de la base de datos
			stmt.executeUpdate();

		} catch (SQLException e1) {

			System.out.println("Error al ejecutar la query");
			String error = "Error al crear la coleccion";
			CreateException ex = new CreateException(error);
			throw ex;

		} finally {
			try {
				// Cierro la conexión con la base de datos
				conection.closeConnection(stmt, con);
			} catch (SQLException e) {

				System.out.println("Error al cerrar la conexión");
				String error = "Error al crear la coleccion";
				CreateException ex = new CreateException(error);
				throw ex;
			}
		}
	}

	@Override
	public void asignarJugadoresAPartida(int partida_id, String[] jugadores) throws CreateException {
		try {
			// Abrimos la conexión
			con = conection.openConnection();
		} catch (SQLException e2) {

			System.out.println("Error al abrir la conexión");
			String error = "Error al introducir los jugadores";
			CreateException ex = new CreateException(error);
			throw ex;

		}
		try {

			for (int i = 0; i < 10; i++) {
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
			try {
				// Cierro la conexión con la base de datos
				conection.closeConnection(stmt, con);
			} catch (SQLException e) {

				System.out.println("Error al cerrar la conexión");
				String error = "Error al introducir los jugadores";
				CreateException ex = new CreateException(error);
				throw ex;
			}
		}

	}

	@Override
	public void modificarPartida(Partida partida) throws CreateException {
		try {
			// Abrimos la conexión
			con = conection.openConnection();
		} catch (SQLException e2) {

			System.out.println("Error al abrir la conexión");
			String error = "Error al introducir los jugadores";
			CreateException ex = new CreateException(error);
			throw ex;

		}
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
			try {
				// Cierro la conexión con la base de datos
				conection.closeConnection(stmt, con);
			} catch (SQLException e) {

				System.out.println("Error al cerrar la conexión");
				String error = "Error al introducir los jugadores";
				CreateException ex = new CreateException(error);
				throw ex;
			}
		}

	}

	@Override
	public ArrayList<Partida> verPartidas(String dni) throws CreateException {

		ResultSet rs = null;
		Partida p;
		ArrayList<Partida> ps = new ArrayList<>();

		try {
			con = conection.openConnection();
		} catch (SQLException e1) {

			System.out.println("Error al abrir la conexión");
			String error = "Error al buscar las partidas";
			CreateException ex = new CreateException(error);
			throw ex;
		}
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
			try {
				conection.closeConnection(stmt, con);
			} catch (SQLException e) {

				System.out.println("Error al cerrar la conexión");
				String error = "Error al buscar las partidas";
				CreateException ex = new CreateException(error);
				throw ex;
			}
		}

		return ps;
	}

	@Override
	public ArrayList<Usuario> verJugadores() throws CreateException {
		ResultSet rs = null;
		Usuario u;
		ArrayList<Usuario> jugadores = new ArrayList<>();

		try {
			con = conection.openConnection();
		} catch (SQLException e1) {

			System.out.println("Error al abrir la conexión");
			String error = "Error al buscar los jugadores";
			CreateException ex = new CreateException(error);
			throw ex;
		}
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
			try {
				conection.closeConnection(stmt, con);
			} catch (SQLException e) {

				System.out.println("Error al cerrar la conexión");
				String error = "Error al buscar los jugadores";
				CreateException ex = new CreateException(error);
				throw ex;
			}
		}

		return jugadores;
	}

	
	
}
