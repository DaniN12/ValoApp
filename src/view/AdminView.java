package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import controller.Controlador;
import excepciones.CreateException;
import model.Partida;
import model.Usuario;

public class AdminView extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextArea tfInformacion;
	private JButton btnBanear;
	private JButton btnRevisarBan;
	private JButton btnModificar;
	private JButton btnAscender;
	private JDateChooser calendarModificar;
	private JComboBox<String> cbJugadorBan;
	private JComboBox<String> cbJugadorAscender;
	private JPanel panelBaneo;
	private JPanel panelCrearPartida;
	private JPanel panelModificar;
	private JPanel panelAscend;
	private JLabel lblFondoCrear;
	private JLabel lblFondo;
	private JLabel lblFondoAscender;
	private JLabel lblFondoBaneo;
	private JLabel lblMapa;
	private JLabel lblFecha;
	private JLabel lblPartida_ID;
	private JLabel lblSeleccionaMapa;
	private JLabel lblFechaPartida;
	private JTextField tfPartida_ID;
	private JComboBox<String> cbJugadorEq1;
	private JComboBox<String> cbJugadorEq2;
	private JComboBox<String> cbMapaCrear;
	private JComboBox<Integer> cbPartidaMod;
	private JComboBox<String> cbMapaMod;
	private ArrayList<Usuario> jugadores;
	private ArrayList<Partida> partidas;
	private String[] mapas = { "-", "Sunset", "Lotus", "Pearl", "Bind", "Haven", "Split", "Ascent", "Icebox", "Breeze",
			"Fracture", "Distric", "Piazza", "Kasbah" };
	private Controlador datos;
	private JButton btnCrear;
	private JDateChooser calendarFechaPartida;
	private JButton btnRevisarAsc;
	private JTextArea tfInfoAscender;

	/**
	 * @param loginView
	 * @param loggedProf
	 */

	// LoginView login dentro del constructor
	public AdminView(Usuario admin, Controlador datos) {

		this.datos = datos;

		panelBaneo = new JPanel();
		panelCrearPartida = new JPanel();
		panelCrearPartida.setBackground(new Color(63, 204, 220));
		panelModificar = new JPanel();
		panelModificar.setBackground(new Color(63, 204, 220));
		panelAscend = new JPanel();
		panelAscend.setBackground(new Color(63, 204, 220));
		JTabbedPane pestanas = new JTabbedPane();

		cbJugadorBan = new JComboBox<String>();
		cbJugadorBan.setMaximumRowCount(20);
		cbJugadorBan.setForeground(new Color(0, 0, 0));
		cbJugadorBan.setBackground(SystemColor.control);
		cbJugadorBan.setBounds(208, 153, 237, 53);
		panelBaneo.add(cbJugadorBan);

		cbJugadorAscender = new JComboBox<String>();
		cbJugadorAscender.setBounds(404, 91, 222, 31);
		cbJugadorAscender.addActionListener(this);
		panelAscend.add(cbJugadorAscender);

		panelBaneo.setBackground(new Color(192, 192, 192));
		pestanas.addTab("BANEOS", panelBaneo);

		panelBaneo.setLayout(null);

		btnBanear = new JButton("BANEAR");
		btnBanear.setBounds(10, 389, 142, 49);
		panelBaneo.add(btnBanear);
		btnBanear.addActionListener(this);

		btnRevisarBan = new JButton("REVISAR");
		btnRevisarBan.setBounds(10, 291, 142, 55);
		panelBaneo.add(btnRevisarBan);
		btnRevisarBan.addActionListener(this);

		JLabel labelJugador = new JLabel("Selecciona Jugador:");
		labelJugador.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		labelJugador.setBounds(10, 150, 175, 53);
		panelBaneo.add(labelJugador);

		/*
		 * This one is the TextArean where the players info is going to be shown it is
		 * an area and not a normal text field because it has to show more than one line
		 * and a label can not handle it
		 */
		tfInformacion = new JTextArea(2, 30);
		tfInformacion.setBackground(new Color(200, 243, 249));
		tfInformacion.setEditable(false);
		tfInformacion.setBounds(188, 286, 280, 175);
		panelBaneo.add(tfInformacion);
		btnBanear.setEnabled(false);

		// The JLabel under this comment has no text because a picture is on
		// this Label
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(667, 178, 188, 341);
		panelBaneo.add(lblImagen);

		JLabel lblBienvenido = new JLabel("Bienvenido/a, " + admin.getNombre() + " :)");
		lblBienvenido.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 17));
		lblBienvenido.setBounds(24, 30, 294, 28);
		panelBaneo.add(lblBienvenido);

		lblFondoBaneo = new JLabel("");
		lblFondoBaneo.setBounds(0, 0, 1061, 543);
		panelBaneo.add(lblFondoBaneo);

		// 2.Crear partida

		pestanas.addTab("CREAR", panelCrearPartida);
		panelCrearPartida.setLayout(null);

		JLabel lblCrearPartida = new JLabel("Crea una partida");
		lblCrearPartida.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 18));
		lblCrearPartida.setBounds(27, 26, 337, 17);
		panelCrearPartida.add(lblCrearPartida);

		lblPartida_ID = new JLabel("Introduce el ID de la Partida");
		lblPartida_ID.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPartida_ID.setBounds(49, 63, 228, 25);
		panelCrearPartida.add(lblPartida_ID);

		lblSeleccionaMapa = new JLabel("Selecciona un Mapa");
		lblSeleccionaMapa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSeleccionaMapa.setBounds(471, 63, 141, 25);
		panelCrearPartida.add(lblSeleccionaMapa);

		lblFechaPartida = new JLabel("Selecciona una fecha para la Partida");
		lblFechaPartida.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaPartida.setBounds(742, 63, 254, 25);
		panelCrearPartida.add(lblFechaPartida);

		calendarFechaPartida = new JDateChooser();
		calendarFechaPartida.setDateFormatString("dd-MM-yyyy");
		calendarFechaPartida.setBounds(742, 97, 233, 20);
		panelCrearPartida.add(calendarFechaPartida);

		tfPartida_ID = new JTextField();
		tfPartida_ID.setBounds(49, 98, 228, 19);
		panelCrearPartida.add(tfPartida_ID);
		tfPartida_ID.setColumns(10);

		cbMapaCrear = new JComboBox<String>(mapas);
		cbMapaCrear.setBounds(471, 98, 141, 21);
		panelCrearPartida.add(cbMapaCrear);

		btnCrear = new JButton("CREAR");
		btnCrear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCrear.setBounds(471, 435, 141, 43);
		panelCrearPartida.add(btnCrear);
		btnCrear.addActionListener(this);

		JLabel lblEquipo1 = new JLabel("EQUIPO 1");
		lblEquipo1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEquipo1.setBounds(49, 184, 228, 25);
		panelCrearPartida.add(lblEquipo1);

		JLabel lblEquipo2 = new JLabel("EQUIPO 2");
		lblEquipo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEquipo2.setBounds(768, 191, 228, 25);
		panelCrearPartida.add(lblEquipo2);

		cbJugadorEq1 = new JComboBox<String>();
		cbJugadorEq1.setBounds(97, 219, 141, 21);
		panelCrearPartida.add(cbJugadorEq1);

		cbJugadorEq2 = new JComboBox<String>();
		cbJugadorEq2.setBounds(804, 219, 141, 21);
		panelCrearPartida.add(cbJugadorEq2);

		lblFondoCrear = new JLabel("");
		lblFondoCrear.setBounds(0, 0, 1061, 543);
		panelCrearPartida.add(lblFondoCrear);
		pestanas.addTab("MODIFICAR", panelModificar);
		panelModificar.setLayout(null);

		calendarModificar = new JDateChooser();
		calendarModificar.setDateFormatString("yyyy-MM-dd");
		calendarModificar.setBounds(223, 254, 108, 20);
		panelModificar.add(calendarModificar);

		JLabel lblPartidaModificar = new JLabel("PARTIDA A MODIFICAR");
		lblPartidaModificar.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPartidaModificar.setHorizontalAlignment(SwingConstants.LEFT);
		lblPartidaModificar.setBounds(40, 135, 173, 14);
		panelModificar.add(lblPartidaModificar);

		lblMapa = new JLabel("MAPA");
		lblMapa.setHorizontalAlignment(SwingConstants.LEFT);
		lblMapa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMapa.setBounds(40, 201, 62, 14);
		panelModificar.add(lblMapa);

		lblFecha = new JLabel("FECHA");
		lblFecha.setHorizontalAlignment(SwingConstants.LEFT);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFecha.setBounds(40, 260, 62, 14);
		panelModificar.add(lblFecha);

		cbPartidaMod = new JComboBox<Integer>();
		cbPartidaMod.setBounds(223, 133, 108, 21);
		panelModificar.add(cbPartidaMod);

		cbMapaMod = new JComboBox<String>(mapas);
		cbMapaMod.setBounds(223, 199, 108, 21);
		panelModificar.add(cbMapaMod);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnModificar.setBounds(206, 364, 125, 44);
		panelModificar.add(btnModificar);
		btnModificar.addActionListener(this);

		JLabel lblImagenModificar = new JLabel("vguhgvhjg");
		lblImagenModificar.setBounds(728, 125, 290, 346);
		panelModificar.add(lblImagenModificar);

		lblFondo = new JLabel("ahbd");
		lblFondo.setBounds(0, 0, 1061, 543);
		panelModificar.add(lblFondo);

		// PestaÃ±a4
		pestanas.addTab("ASCENDER", panelAscend);
		panelAscend.setLayout(null);

		JLabel lblSelecJugadorAscender = new JLabel("Selecciona un Jugador");
		lblSelecJugadorAscender.setForeground(Color.BLACK);
		lblSelecJugadorAscender.setBackground(new Color(255, 255, 255));
		lblSelecJugadorAscender.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSelecJugadorAscender.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecJugadorAscender.setBounds(424, 56, 180, 25);
		panelAscend.add(lblSelecJugadorAscender);

		btnAscender = new JButton("ASCENDER");
		btnAscender.addActionListener(this);
		btnAscender.setBounds(446, 368, 122, 69);
		panelAscend.add(btnAscender);
		btnAscender.setEnabled(false);
		btnAscender.addActionListener(this);

		tfInfoAscender = new JTextArea(2, 30);
		tfInfoAscender.setEditable(false);
		tfInfoAscender.setBackground(new Color(200, 243, 249));
		tfInfoAscender.setBounds(372, 157, 280, 175);
		panelAscend.add(tfInfoAscender);

		lblFondoAscender = new JLabel("");
		lblFondoAscender.setBounds(0, 0, 1061, 543);
		panelAscend.add(lblFondoAscender);

		btnRevisarAsc = new JButton("REVISAR");
		btnRevisarAsc.setBounds(191, 221, 142, 55);
		panelAscend.add(btnRevisarAsc);
		btnRevisarAsc.addActionListener(this);

		getContentPane().add(pestanas);
		// Using @param name = null because I want all
		// players to be added and none to be removed

		// Configuramos la ventana

		setSize(1080, 607);

		cargarJugadores(datos);
		cargarPartidas(datos);

	}

	private void cargarPartidas(Controlador datos) {

		try {
			partidas = datos.verPartidas();
		} catch (CreateException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error al buscar las partidas",
					JOptionPane.ERROR_MESSAGE);
		}

		cbPartidaMod.removeAllItems();
		for (Partida par : partidas) {
			cbPartidaMod.addItem(par.getPartida_id());
		}
		cbPartidaMod.setSelectedIndex(-1);

	}

	private void cargarJugadores(Controlador datos) {
		// Hemos delcarado el arraylist de jugadores anteriormente y lo usamos al
		// entrar en el mÃ©todo listarJugadores, que nos devuelve todos
		// los objetos Usuario con esAdmin = 0
		try {
			jugadores = datos.verJugadores();
		} catch (CreateException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error al buscar los jugadores",
					JOptionPane.ERROR_MESSAGE);
		}
		// Si no hay jugadores lo comuicamos en las combo box
		if (jugadores == null || jugadores.size() == 0) {
			cbJugadorBan.addItem("No hay jugadores disponibles");
			cbJugadorEq1.addItem("No hay jugadores disponibles");
			cbJugadorEq2.addItem("No hay jugadores disponibles");
			cbJugadorAscender.addItem("No hay jugadores disponibles");

		} else {

			// Si hay jugadores hacemos un for-each donde devuelve el nombre de cada uno de
			// ellos

			cbJugadorBan.removeAllItems();
			cbJugadorEq1.removeAllItems();
			cbJugadorEq2.removeAllItems();
			cbJugadorAscender.removeAllItems();
			for (Usuario usu : jugadores) {
				cbJugadorBan.addItem(usu.getUsername());
				cbJugadorEq1.addItem(usu.getUsername());
				cbJugadorEq2.addItem(usu.getUsername());
				cbJugadorAscender.addItem(usu.getUsername());
			}
			cbJugadorBan.setSelectedIndex(-1);
			cbJugadorEq1.setSelectedIndex(-1);
			cbJugadorEq2.setSelectedIndex(-1);
			cbJugadorAscender.setSelectedIndex(-1);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnRevisarBan)) {
			revisarJugadorBan();
		}
		if (e.getSource().equals(btnBanear)) {
			banear(datos);
		}
		if (e.getSource().equals(btnCrear)) {
			crearPartida(datos);
		}
		if (e.getSource().equals(btnModificar)) {
			modificarPartida(datos);
		}
		if (e.getSource().equals(btnRevisarAsc)) {
			revisarJugadorAscender();
		}
		if (e.getSource().equals(btnAscender)) {
			ascenderJugador(datos);
		}
	}

	private void revisarJugadorAscender() {
		if (cbJugadorAscender.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, "Selecciona un jugador", "FATAL ERROR", JOptionPane.WARNING_MESSAGE);
		} else {
			btnAscender.setEnabled(true);
			int pos = cbJugadorAscender.getSelectedIndex();

			tfInfoAscender.setText("\n");
			tfInfoAscender.append("    Nombre y Apellido/s:\n    " + jugadores.get(pos).getNombre() + " "
					+ jugadores.get(pos).getApellido() + "\n\n");
			tfInfoAscender.append("    DNI: " + jugadores.get(pos).getDni() + "\n\n");
			tfInfoAscender.append("    Sexo: " + jugadores.get(pos).getSexo() + "\n\n");
			tfInfoAscender.append("    Fecha de nacimiento: " + jugadores.get(pos).getNacimiento() + "\n\n");
		}
	}

	private void revisarJugadorBan() {
		if (cbJugadorBan.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, "Selecciona un jugador", "FATAL ERROR", JOptionPane.WARNING_MESSAGE);
		} else {
			btnBanear.setEnabled(true);
			int pos = cbJugadorBan.getSelectedIndex();

			tfInformacion.setText("\n");
			tfInformacion.append("    Nombre y Apellido/s:\n    " + jugadores.get(pos).getNombre() + " "
					+ jugadores.get(pos).getApellido() + "\n\n");
			tfInformacion.append("    DNI: " + jugadores.get(pos).getDni() + "\n\n");
			tfInformacion.append("    Sexo: " + jugadores.get(pos).getSexo() + "\n\n");
			tfInformacion.append("    Fecha de nacimiento: " + jugadores.get(pos).getNacimiento() + "\n\n");
		}
	}

	private void banear(Controlador datos) {
		int pos = cbJugadorBan.getSelectedIndex();

		Usuario usu = jugadores.get(pos);
		try {
			datos.eliminarJugador(usu.getDni());
			btnBanear.setEnabled(false);
			tfInformacion.setText("");
			JOptionPane.showMessageDialog(this, usu.getUsername() + " ha sido baneado");
			cargarJugadores(datos);
		} catch (CreateException e) {
			JOptionPane.showMessageDialog(this, "No se ha podido banear", "FATAL ERROR", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}

	}

	private void ascenderJugador(Controlador datos) {
		int pos = cbJugadorAscender.getSelectedIndex();

		try {
			Usuario usu = jugadores.get(pos);
			try {
				datos.ascender(usu.getDni());
				btnAscender.setEnabled(false);
				tfInfoAscender.setText("");
				JOptionPane.showMessageDialog(this, usu.getUsername() + " ha sido ascendido");
				// aqui cuando le das a aceptar como que vuelve al metodo ascender con pos == -1
				// y da error en jugadores.get(pos)
				cargarJugadores(datos);
			} catch (CreateException e) {
				JOptionPane.showMessageDialog(this, "No se ha podido ascender", "FATAL ERROR",
						JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();
			}
		} catch (IndexOutOfBoundsException e) {

		}

	}

	private void crearPartida(Controlador datos) {
		Date fechaActual = new Date();

		try {
			if (tfPartida_ID.getText().isEmpty() || cbMapaCrear.getSelectedIndex() == 0
					|| cbJugadorEq1.getSelectedIndex() == -1 || cbJugadorEq2.getSelectedIndex() == -1
					|| calendarFechaPartida.getDate().before(fechaActual)) {
				JOptionPane.showMessageDialog(this, "Introduce todos los datos correctamente", "FATAL ERROR",
						JOptionPane.WARNING_MESSAGE);
			} else if (cbJugadorEq1.getSelectedIndex() == cbJugadorEq2.getSelectedIndex()) {
				JOptionPane.showMessageDialog(this, "Ha seleccionado el mismo jugador para ambos equipos",
						"FATAL ERROR", JOptionPane.WARNING_MESSAGE);
			} else {
				Partida partida = new Partida();
				String[] jugadoresDni = new String[2];
				int pos1 = cbJugadorEq1.getSelectedIndex();
				int pos2 = cbJugadorEq2.getSelectedIndex();
				Usuario usu = jugadores.get(pos1);
				jugadoresDni[0] = usu.getDni();
				usu = jugadores.get(pos2);
				jugadoresDni[1] = usu.getDni();
				partida.setPartida_id(Integer.parseInt(tfPartida_ID.getText().trim()));
				java.sql.Date date = new java.sql.Date(calendarFechaPartida.getDate().toInstant().toEpochMilli());
				partida.setFecha(date);
				partida.setMapa((String) cbMapaCrear.getSelectedItem());

				datos.crearPartida(partida);
				datos.asignarJugadoresAPartida(partida.getPartida_id(), jugadoresDni);

				calendarFechaPartida.cleanup();
				limpiarCrearPartida();
				JOptionPane.showMessageDialog(this, "Partida creada correctamente");
			}

		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(this, "Ingrese solo nÃºmeros en el ID de partida", "FATAL ERROR",
					JOptionPane.WARNING_MESSAGE);
		} catch (CreateException e) {
			JOptionPane.showMessageDialog(this, "No se ha podido crear la partida", "FATAL ERROR",
					JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}

	}

	private void limpiarCrearPartida() {
		tfPartida_ID.setText("");
		cbMapaCrear.setSelectedIndex(0);
		cbJugadorEq1.setSelectedIndex(-1);
		cbJugadorEq2.setSelectedIndex(-1);
	}

	private void modificarPartida(Controlador datos) {
		Date fechaActual = new Date();

		if (cbMapaMod.getSelectedIndex() == 0 || cbPartidaMod.getSelectedIndex() == -1
				|| calendarModificar.getDate().before(fechaActual)) {
			JOptionPane.showMessageDialog(this, "Introduce todos los datos correctamente", "FATAL ERROR",
					JOptionPane.WARNING_MESSAGE);
		} else {
			Partida partida = new Partida();
			partida.setPartida_id((int) cbPartidaMod.getSelectedItem());
			java.sql.Date date = new java.sql.Date(calendarModificar.getDate().toInstant().toEpochMilli());
			partida.setFecha(date);
			partida.setMapa((String) cbMapaMod.getSelectedItem());
			JOptionPane.showMessageDialog(this, "Partida modificada correctamente");
			try {
				datos.modificarPartida(partida);
			} catch (CreateException e) {
				JOptionPane.showMessageDialog(this, "No se ha podido modificar la partida", "FATAL ERROR",
						JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();
			}
		}

	}
}