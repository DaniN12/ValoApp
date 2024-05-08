package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
import model.Usuario;

public class AdminView extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextArea tfInformacion;
	private JButton btnBanear;
	private JButton btnRevisar;
	private JButton btnGuardarModi;
	private JButton upgradeButton;
	private JDateChooser addCalender;
	private JComboBox<String> cbJugadorBan;
	private JComboBox<String> cbJugadorAscender;
	private JPanel panelBattle;
	private JPanel paneCrearPartida;
	private JPanel panelModify;
	private JPanel panelAscend;
	private JLabel lblFondoCrear;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblFondoBaneo;
	private JLabel lblMapa;
	private JLabel lblFecha;
	private JLabel lblNombreParti;
	private JLabel lblSeleccionaMapa;
	private JLabel lblFechaPartida;
	private JTextField tfNombrePartida;
	private JComboBox<String> cbJugadorEq1;
	private JComboBox<String> cbJugadorEq2;
	private JComboBox<String> cbMapaCrear;
	private JComboBox<Integer> cbPartidaMod;
	private JComboBox<String> cbMapaMod;
	private ArrayList<Usuario> jugadores;
	private String[] mapas = { "-", "Sunset", "Lotus", "Pearl", "The Range", "Bind", "Haven", "Split", "Ascent",
			"Icebox", "Breeze", "Fracture", "Distric", "Piazza", "Kasbah" };
	
	/**
	 * @param loginView
	 * @param loggedProf
	 */
	
	//LoginView login dentro del constructor
	public AdminView(Usuario admin, Controlador datos) {

		panelBattle = new JPanel();
		paneCrearPartida = new JPanel();
		paneCrearPartida.setBackground(new Color(63, 204, 220));
		panelModify = new JPanel();
		panelModify.setBackground(new Color(63, 204, 220));
		panelAscend = new JPanel();
		panelAscend.setBackground(new Color(63, 204, 220));
		JTabbedPane pestanas = new JTabbedPane();

		cbJugadorBan = new JComboBox<String>();
		cbJugadorBan.setMaximumRowCount(20);
		cbJugadorBan.setForeground(new Color(0, 0, 0));
		cbJugadorBan.setBackground(SystemColor.control);
		cbJugadorBan.setBounds(208, 153, 237, 53);
		panelBattle.add(cbJugadorBan);
		cbJugadorBan.addActionListener(this);

		cbJugadorAscender = new JComboBox<String>();
		cbJugadorAscender.setBounds(404, 91, 222, 31);
		cbJugadorAscender.addActionListener(this);
		panelAscend.add(cbJugadorAscender);

		panelBattle.setBackground(new Color(192, 192, 192));
		pestanas.addTab("BANEOS", panelBattle);

		panelBattle.setLayout(null);

		btnBanear = new JButton("BANEAR");
		btnBanear.setBounds(10, 389, 142, 49);
		panelBattle.add(btnBanear);
		btnBanear.addActionListener(this);

		btnRevisar = new JButton("REVISAR");
		btnRevisar.setBounds(10, 291, 142, 55);
		panelBattle.add(btnRevisar);
		btnRevisar.addActionListener(this);

		JLabel labelJugador = new JLabel("Selecciona Jugador:");
		labelJugador.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		labelJugador.setBounds(10, 150, 175, 53);
		panelBattle.add(labelJugador);

		/*
		 * This one is the TextArean where the players info is going to be shown it is
		 * an area and not a normal text field because it has to show more than one line
		 * and a label can not handle it
		 */
		tfInformacion = new JTextArea(2, 30);
		tfInformacion.setBackground(new Color(200, 243, 249));
		tfInformacion.setEditable(false);
		tfInformacion.setBounds(188, 286, 280, 175);
		panelBattle.add(tfInformacion);
		btnBanear.setEnabled(false);

		// The JLabel under this comment has no text because a picture is on
		// this Label
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(667, 178, 188, 341);
		panelBattle.add(lblImagen);

		JLabel lblBienvenido = new JLabel("Bienvenido/a, " + admin.getNombre() + " :)");
		lblBienvenido.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 17));
		lblBienvenido.setBounds(24, 30, 294, 28);
		panelBattle.add(lblBienvenido);

		lblFondoBaneo = new JLabel("");
		lblFondoBaneo.setBounds(0, 0, 1061, 543);
		panelBattle.add(lblFondoBaneo);

		// 2.Crear partida

		pestanas.addTab("CREAR", paneCrearPartida);
		paneCrearPartida.setLayout(null);

		JLabel lblCrearPartida = new JLabel("Crea una partida");
		lblCrearPartida.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 18));
		lblCrearPartida.setBounds(27, 26, 337, 17);
		paneCrearPartida.add(lblCrearPartida);

		lblNombreParti = new JLabel("Introduce el nombre de la Partida");
		lblNombreParti.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreParti.setBounds(49, 63, 228, 25);
		paneCrearPartida.add(lblNombreParti);

		lblSeleccionaMapa = new JLabel("Selecciona un Mapa");
		lblSeleccionaMapa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSeleccionaMapa.setBounds(471, 63, 141, 25);
		paneCrearPartida.add(lblSeleccionaMapa);

		lblFechaPartida = new JLabel("Selecciona una fecha para la Partida");
		lblFechaPartida.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaPartida.setBounds(742, 63, 254, 25);
		paneCrearPartida.add(lblFechaPartida);

		JDateChooser calenderFechaPartida = new JDateChooser();
		calenderFechaPartida.setEnabled(false);
		calenderFechaPartida.setDateFormatString("dd-MM-yyyy");
		calenderFechaPartida.setBounds(742, 97, 233, 20);
		paneCrearPartida.add(calenderFechaPartida);

		tfNombrePartida = new JTextField();
		tfNombrePartida.setBounds(49, 98, 228, 19);
		paneCrearPartida.add(tfNombrePartida);
		tfNombrePartida.setColumns(10);

		cbMapaCrear = new JComboBox<String>(mapas);
		cbMapaCrear.setBounds(471, 98, 141, 21);
		paneCrearPartida.add(cbMapaCrear);

		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGuardar.setBounds(471, 435, 141, 43);
		paneCrearPartida.add(btnGuardar);

		JLabel lblEquipo1 = new JLabel("EQUIPO 1");
		lblEquipo1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEquipo1.setBounds(49, 184, 228, 25);
		paneCrearPartida.add(lblEquipo1);

		JLabel lblEquipo2 = new JLabel("EQUIPO 2");
		lblEquipo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEquipo2.setBounds(768, 191, 228, 25);
		paneCrearPartida.add(lblEquipo2);

		cbJugadorEq1 = new JComboBox<String>();
		cbJugadorEq1.setBounds(97, 219, 141, 21);
		paneCrearPartida.add(cbJugadorEq1);

		cbJugadorEq2 = new JComboBox<String>();
		cbJugadorEq2.setBounds(804, 219, 141, 21);
		paneCrearPartida.add(cbJugadorEq2);

		lblFondoCrear = new JLabel("");
		lblFondoCrear.setBounds(0, 0, 1061, 543);
		paneCrearPartida.add(lblFondoCrear);
		pestanas.addTab("MODIFICAR", panelModify);
		panelModify.setLayout(null);

		addCalender = new JDateChooser();
		addCalender.setDateFormatString("yyyy-MM-dd");
		addCalender.setBounds(223, 254, 108, 20);
		panelModify.add(addCalender);

		JLabel lblPartidaModificar = new JLabel("PARTIDA A MODIFICAR");
		lblPartidaModificar.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPartidaModificar.setHorizontalAlignment(SwingConstants.LEFT);
		lblPartidaModificar.setBounds(40, 135, 173, 14);
		panelModify.add(lblPartidaModificar);

		// Desactivar los componentes relevantes
		addCalender.setEnabled(false);

		lblMapa = new JLabel("MAPA");
		lblMapa.setHorizontalAlignment(SwingConstants.LEFT);
		lblMapa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMapa.setBounds(40, 201, 62, 14);
		panelModify.add(lblMapa);

		lblFecha = new JLabel("FECHA");
		lblFecha.setHorizontalAlignment(SwingConstants.LEFT);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFecha.setBounds(40, 260, 62, 14);
		panelModify.add(lblFecha);

		cbPartidaMod = new JComboBox<Integer>();
		cbPartidaMod.setBounds(223, 133, 108, 21);
		panelModify.add(cbPartidaMod);

		cbMapaMod = new JComboBox<String>(mapas);
		cbMapaMod.setBounds(223, 199, 108, 21);
		panelModify.add(cbMapaMod);

		btnGuardarModi = new JButton("GUARDAR");
		btnGuardarModi.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGuardarModi.addActionListener(this);
		btnGuardarModi.setBounds(206, 364, 125, 44);
		panelModify.add(btnGuardarModi);

		JLabel lblNewLabel = new JLabel("vguhgvhjg");
		lblNewLabel.setBounds(728, 125, 290, 346);
		panelModify.add(lblNewLabel);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 1061, 543);
		panelModify.add(lblNewLabel_2);

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

		upgradeButton = new JButton("UPGRADE");
		upgradeButton.addActionListener(this);
		upgradeButton.setBounds(446, 368, 122, 69);
		panelAscend.add(upgradeButton);
		upgradeButton.setEnabled(false);
		upgradeButton.setEnabled(false);

		JTextArea resulttextFieldInfoJugadorAscender = new JTextArea(2, 30);
		resulttextFieldInfoJugadorAscender.setEditable(false);
		resulttextFieldInfoJugadorAscender.setBackground(new Color(200, 243, 249));
		resulttextFieldInfoJugadorAscender.setBounds(372, 157, 280, 175);
		panelAscend.add(resulttextFieldInfoJugadorAscender);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 0, 1061, 543);
		panelAscend.add(lblNewLabel_3);

		getContentPane().add(pestanas);
		// Using @param name = null because I want all
		// players to be added and none to be removed

		// Configuramos la ventana

		setSize(1080, 607);

		cargarJugadores(datos);
		cargarPartidas(datos);

	}

	private void cargarPartidas(Controlador datos) {
		// TODO Auto-generated method stub

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
		if (e.getSource().equals(btnRevisar)) {
			if (cbJugadorBan.getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(this, "Selecciona un jugador", "FATAL ERROR",
						JOptionPane.WARNING_MESSAGE);
			} else {
				tfInformacion.setText("Aqui va la info");
			}
		}
	}
}
