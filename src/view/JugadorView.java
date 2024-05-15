package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.Controlador;
import excepciones.CreateException;
import model.Coleccion;
import model.Partida;
import model.Usuario;

import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class JugadorView extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario jugador;
	private Coleccion coleccion;
	private JPanel panelInfo;
	private JPanel panelColección;
	private JPanel panelModificar;
	private JPanel panelPartidas;
	private JTextField tfNombreMod;
	private JTextField tfApellidoMod;
	private JTextField tfUsuarioMod;
	private JTextField tfUsuario;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfSexo;
	private JTextField tfAgente;
	private JTextField tfArma;
	private JTextField tfSkin;
	private JLabel lblFondoColec;
	private JLabel lblFondoMod;
	private JLabel lblFondoPart;
	private JLabel lblFondoInfo;
	private JLabel lblAgenteColec;
	private JLabel lblArmaColec;
	private JLabel lblSkinFavColec;
	private JLabel lblIimagen;
	private JLabel lblBienvenido;
	private JLabel lblUsuario;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblSexo;
	private JLabel lblAgente;
	private JLabel lblArma;
	private JLabel lblSkinFav;
	private JLabel lblBienvenidoColec;
	private JLabel lblNombreMod;
	private JLabel lblApellidoMod;
	private JLabel lblUsuarioMod;
	private JLabel lblContraNueva;
	private JLabel lblConfirmarContra;
	private JLabel lblSexoMod;
	private JLabel lblNewLabel;
	private JComboBox<String> cbArma;
	private JComboBox<String> cbSkinFav;
	private JComboBox<String> cbAgente;
	private JButton btnGuardarColec;
	private JButton btnGuardarMod;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFemenino;
	private JRadioButton rdbtnOtro;
	private Controlador datos;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel tableModel2;
	private final ButtonGroup bgGenero = new ButtonGroup();
	private String[] armas = { "-", "CLASSIC", "SHORTY", "FRENZY", "GHOST", "SHERIFF", "STINGER", "SPECTRE", "BUCKY",
			"JUDGE", "BULLDOG", "GUARDIAN", "PHANTOM", "VANDAL", "MARSHAL", "OPERATOR", "ARES", "ODIN" };
	private String[] agentes = { "-", "JETT", "RAZE", "BREACH", "OMEN", "BRIMSTONE", "PHOENIX", "SAGE", "SOVA", "VIPER",
			"CYPHER", "REYNA", "KILLJOY", "SKYE", "YORU", "ASTRA", "KAY/O", "CHAMBER", "NEON", "FADE", "HARBOR",
			"GEKKO", "DEADLOCK", "ISO", "CLOVE" };
	private String[] skins = { "-", "Elderflames", "Protocol 781-A", "Zedd X Valorant SPECTRUM",
			"Radiant Entertainment System", "MYSTBLOOM", "VCT x", "Primordium", "Ignite", "BlastX", "Glitchpop",
			"ChronoVoid", "Sentinels of light", "Imperium", "Neo Frontier", "Prelude to Chaos", "RGX", "Ruination",
			"Singularity ", "Araxy", "Overdrive", "XERØFANG", "Cryostasis", "Forsaken", "Gaia", "Ion", "Magepunk",
			"Oni", "Prime", "Reaver", "Sovereign", "Valiant Hero", "Kuronami", "Gaia", "Gaia" };
	private JPasswordField tfContrasena;
	private JPasswordField tfConfirmarContrasena;
	private String dniJugador;
	private String username;

	public JugadorView(LoginView loginView, boolean b, Usuario jugador, Controlador datos) {
		super(loginView);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JugadorView.class.getResource("/resources/logoApp.jpg")));
		setModal(b);
		this.datos = datos;
		this.jugador = jugador;
		try {
			this.coleccion = datos.getColeccion(this.jugador.getDni());
		} catch (CreateException e) {
			System.err.println(e.getMessage());
		}
		panelInfo = new JPanel();
		panelColección = new JPanel();
		panelColección.setBackground(new Color(63, 204, 220));
		panelModificar = new JPanel();
		panelModificar.setBackground(new Color(63, 204, 220));
		panelPartidas = new JPanel();
		panelPartidas.setBackground(new Color(63, 204, 220));
		JTabbedPane pestanas = new JTabbedPane();

		// 1.Info View
		panelInfo.setBackground(new Color(192, 192, 192));
		pestanas.addTab("INFO", panelInfo);

		panelInfo.setLayout(null);

		// The JLabel under this comment has no text because the picture of Oak is on
		// this Label
		lblIimagen = new JLabel("");
		lblIimagen.setIcon(new ImageIcon(JugadorView.class.getResource("/resources/sage.png")));
		lblIimagen.setBounds(392, -46, 627, 975);
		panelInfo.add(lblIimagen);

		lblBienvenido = new JLabel("BIENVENIDO JUGADOR!!");
		lblBienvenido.setForeground(new Color(255, 255, 255));
		lblBienvenido.setFont(new Font("Segoe UI Black", Font.BOLD, 21));
		lblBienvenido.setBounds(20, 480, 287, 28);
		panelInfo.add(lblBienvenido);

		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(59, 105, 96, 21);
		panelInfo.add(lblUsuario);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(59, 140, 96, 21);
		panelInfo.add(lblNombre);

		lblApellido = new JLabel("Apellido:");
		lblApellido.setForeground(new Color(255, 255, 255));
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido.setBounds(59, 171, 96, 21);
		panelInfo.add(lblApellido);

		lblSexo = new JLabel("Sexo:");
		lblSexo.setForeground(new Color(255, 255, 255));
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSexo.setBounds(59, 202, 96, 21);
		panelInfo.add(lblSexo);

		lblAgente = new JLabel("Agente");
		lblAgente.setForeground(new Color(255, 255, 255));
		lblAgente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAgente.setBounds(59, 236, 96, 21);
		panelInfo.add(lblAgente);

		lblArma = new JLabel("Arma");
		lblArma.setForeground(new Color(255, 255, 255));
		lblArma.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblArma.setBounds(59, 267, 106, 21);
		panelInfo.add(lblArma);

		lblSkinFav = new JLabel("Skin Favorita:");
		lblSkinFav.setForeground(new Color(255, 255, 255));
		lblSkinFav.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSkinFav.setBounds(59, 299, 106, 21);
		panelInfo.add(lblSkinFav);

		tfUsuario = new JTextField(jugador.getUsername());
		tfUsuario.setEditable(false);
		tfUsuario.setBounds(181, 105, 126, 22);
		panelInfo.add(tfUsuario);
		tfUsuario.setColumns(10);

		tfNombre = new JTextField(jugador.getNombre());
		tfNombre.setEditable(false);
		tfNombre.setColumns(10);
		tfNombre.setBounds(181, 139, 126, 22);
		panelInfo.add(tfNombre);

		tfApellido = new JTextField(jugador.getApellido());
		tfApellido.setEditable(false);
		tfApellido.setColumns(10);
		tfApellido.setBounds(181, 171, 126, 22);
		panelInfo.add(tfApellido);

		tfSexo = new JTextField(jugador.getSexo());
		tfSexo.setEditable(false);
		tfSexo.setColumns(10);
		tfSexo.setBounds(181, 203, 126, 22);
		panelInfo.add(tfSexo);

		tfAgente = new JTextField();
		tfAgente.setText(coleccion.getAgenteFav());
		tfAgente.setEditable(false);
		tfAgente.setColumns(10);
		tfAgente.setBounds(181, 235, 126, 22);
		panelInfo.add(tfAgente);

		tfArma = new JTextField();
		tfArma.setText(coleccion.getArmaFav());
		tfArma.setEditable(false);
		tfArma.setColumns(10);
		tfArma.setBounds(181, 267, 126, 22);
		panelInfo.add(tfArma);

		tfSkin = new JTextField();
		tfSkin.setText(coleccion.getSkinFav());
		tfSkin.setEditable(false);
		tfSkin.setColumns(10);
		tfSkin.setBounds(181, 299, 126, 22);
		panelInfo.add(tfSkin);

		lblFondoInfo = new JLabel("");
		lblFondoInfo.setIcon(new ImageIcon(JugadorView.class.getResource("/resources/fondoInfo.png")));
		lblFondoInfo.setBounds(-373, -47, 1585, 587);
		panelInfo.add(lblFondoInfo);

		// 2.Colección View

		pestanas.addTab("COLECCIÓN", panelColección);
		panelColección.setLayout(null);

		lblBienvenidoColec = new JLabel("Bienvenido a tu Colección");
		lblBienvenidoColec.setFont(new Font("Verdana", Font.BOLD, 24));
		lblBienvenidoColec.setBounds(10, 11, 356, 34);
		panelColección.add(lblBienvenidoColec);

		lblAgenteColec = new JLabel("Agente");
		lblAgenteColec.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgenteColec.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAgenteColec.setBounds(81, 91, 168, 24);
		panelColección.add(lblAgenteColec);

		lblArmaColec = new JLabel("Arma");
		lblArmaColec.setHorizontalAlignment(SwingConstants.CENTER);
		lblArmaColec.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblArmaColec.setBounds(81, 168, 159, 24);
		panelColección.add(lblArmaColec);

		lblSkinFavColec = new JLabel("Skin Favorita");
		lblSkinFavColec.setHorizontalAlignment(SwingConstants.CENTER);
		lblSkinFavColec.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSkinFavColec.setBounds(81, 248, 168, 24);
		panelColección.add(lblSkinFavColec);

		cbAgente = new JComboBox<String>(agentes);
		cbAgente.setBounds(81, 125, 168, 34);
		panelColección.add(cbAgente);

		cbArma = new JComboBox<String>(armas);
		cbArma.setBounds(81, 203, 168, 34);
		panelColección.add(cbArma);

		cbSkinFav = new JComboBox<String>(skins);
		cbSkinFav.setBounds(81, 283, 168, 34);
		panelColección.add(cbSkinFav);

		btnGuardarColec = new JButton("GUARDAR");
		btnGuardarColec.addActionListener(this);
		btnGuardarColec.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGuardarColec.setBounds(772, 192, 148, 52);
		panelColección.add(btnGuardarColec);

		// modificar view
		lblFondoColec = new JLabel("");
		lblFondoColec.setIcon(new ImageIcon(JugadorView.class.getResource("/resources/fondoColección.jpg")));
		lblFondoColec.setBounds(-489, 0, 1548, 543);
		panelColección.add(lblFondoColec);
		pestanas.addTab("MODIFICAR", panelModificar);
		panelModificar.setLayout(null);

		lblNombreMod = new JLabel("NOMBRE");
		lblNombreMod.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreMod.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreMod.setBounds(787, 137, 86, 14);
		panelModificar.add(lblNombreMod);

		lblApellidoMod = new JLabel("APELLIDO");
		lblApellidoMod.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellidoMod.setHorizontalAlignment(SwingConstants.LEFT);
		lblApellidoMod.setBounds(787, 168, 86, 14);
		panelModificar.add(lblApellidoMod);

		lblUsuarioMod = new JLabel("USUARIO");
		lblUsuarioMod.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsuarioMod.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuarioMod.setBounds(787, 199, 86, 14);
		panelModificar.add(lblUsuarioMod);

		lblContraNueva = new JLabel("CONTRASEÑA NUEVA");
		lblContraNueva.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblContraNueva.setHorizontalAlignment(SwingConstants.LEFT);
		lblContraNueva.setBounds(724, 230, 149, 14);
		panelModificar.add(lblContraNueva);

		lblConfirmarContra = new JLabel("CONFIRMAR CONTRASEÑA");
		lblConfirmarContra.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConfirmarContra.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmarContra.setBounds(689, 266, 178, 14);
		panelModificar.add(lblConfirmarContra);

		lblSexoMod = new JLabel("SEXO");
		lblSexoMod.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSexoMod.setHorizontalAlignment(SwingConstants.LEFT);
		lblSexoMod.setBounds(689, 303, 53, 14);
		panelModificar.add(lblSexoMod);

		tfNombreMod = new JTextField(jugador.getNombre());
		tfNombreMod.setHorizontalAlignment(SwingConstants.CENTER);
		tfNombreMod.setColumns(10);
		tfNombreMod.setBounds(895, 135, 101, 20);
		panelModificar.add(tfNombreMod);

		tfApellidoMod = new JTextField(jugador.getApellido());
		tfApellidoMod.setHorizontalAlignment(SwingConstants.CENTER);
		tfApellidoMod.setBounds(895, 166, 101, 20);
		panelModificar.add(tfApellidoMod);
		tfApellidoMod.setColumns(10);

		tfUsuarioMod = new JTextField(jugador.getUsername());
		tfUsuarioMod.setEditable(false);
		tfUsuarioMod.setHorizontalAlignment(SwingConstants.CENTER);
		tfUsuarioMod.setColumns(10);
		tfUsuarioMod.setBounds(895, 197, 101, 20);
		panelModificar.add(tfUsuarioMod);

		btnGuardarMod = new JButton("GUARDAR");
		btnGuardarMod.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGuardarMod.addActionListener(this);
		btnGuardarMod.setBounds(803, 350, 122, 31);
		panelModificar.add(btnGuardarMod);

		lblNewLabel = new JLabel("OBHBJHKBJH");
		lblNewLabel.setIcon(new ImageIcon(JugadorView.class.getResource("/resources/clove.jpg")));
		lblNewLabel.setBounds(-146, 0, 860, 813);
		panelModificar.add(lblNewLabel);

		rdbtnMasculino = new JRadioButton("MASCULINO");
		rdbtnMasculino.setBounds(748, 301, 103, 21);
		panelModificar.add(rdbtnMasculino);
		bgGenero.add(rdbtnMasculino);

		rdbtnFemenino = new JRadioButton("FEMENINO");
		rdbtnFemenino.setBounds(853, 301, 103, 21);
		panelModificar.add(rdbtnFemenino);
		bgGenero.add(rdbtnFemenino);

		rdbtnOtro = new JRadioButton("OTRO");
		rdbtnOtro.setBounds(958, 301, 65, 21);
		panelModificar.add(rdbtnOtro);
		bgGenero.add(rdbtnOtro);

		tfContrasena = new JPasswordField();
		tfContrasena.setBounds(895, 228, 101, 19);
		panelModificar.add(tfContrasena);

		tfConfirmarContrasena = new JPasswordField();
		tfConfirmarContrasena.setBounds(895, 264, 101, 19);
		panelModificar.add(tfConfirmarContrasena);

		lblFondoMod = new JLabel("");
		lblFondoMod.setIcon(new ImageIcon(JugadorView.class.getResource("/resources/fondoModificar1.jpg")));
		lblFondoMod.setBounds(-810, 0, 1869, 543);
		panelModificar.add(lblFondoMod);

		// Partidas View
		pestanas.addTab("PARTIDAS", panelPartidas);
		panelPartidas.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(254, 57, 563, 376);
		panelPartidas.add(scrollPane);

		tableModel2 = new DefaultTableModel();
		String[] tableHeaders = { "Partida", "Mapa", "Fecha", "Oponente" };
		tableModel2.setColumnIdentifiers(tableHeaders);
		table = new JTable(tableModel2);
		table.setEnabled(true);

		scrollPane.setViewportView(table);
		table.setVisible(true);
		scrollPane.setVisible(true);

		JLabel lblBienvenidoPart = new JLabel("Bienvenido a tu Trayectoria!!");
		lblBienvenidoPart.setForeground(Color.BLACK);
		lblBienvenidoPart.setBackground(new Color(255, 255, 255));
		lblBienvenidoPart.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
		lblBienvenidoPart.setHorizontalAlignment(SwingConstants.LEFT);
		lblBienvenidoPart.setBounds(55, 0, 493, 37);
		panelPartidas.add(lblBienvenidoPart);

		lblFondoPart = new JLabel("");
		lblFondoPart.setIcon(new ImageIcon(JugadorView.class.getResource("/resources/fondoPartida.jpg")));
		lblFondoPart.setBounds(-516, 0, 1575, 543);
		panelPartidas.add(lblFondoPart);

		getContentPane().add(pestanas);

		setSize(1080, 607);

		dniJugador = jugador.getDni();
		username = jugador.getUsername();

		verPartidas(datos, dniJugador);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btnGuardarMod)) {
			editarDatos(datos);
		}

		if (e.getSource().equals(btnGuardarColec)) {
			editarColeccion(datos);
		}

	}

	private void verPartidas(Controlador datos, String dniJugador) {
		ArrayList<Partida> partidas = new ArrayList<>();
		String oponente = null;
		try {
			partidas = datos.verPartidas(dniJugador);
		} catch (CreateException e) {
			JOptionPane.showMessageDialog(this, "Error al buscar las partidas", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		for (int i = 0; i < partidas.size(); i++) {
			try {
				oponente = datos.getOponente(dniJugador, partidas.get(i).getPartida_id(), oponente);
			} catch (CreateException e) {
				JOptionPane.showMessageDialog(this, "No se pudo buscar el oponente", "ERROR",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			Object[] row = new Object[4];

			row[0] = partidas.get(i).getPartida_id();
			row[1] = partidas.get(i).getMapa();
			row[2] = partidas.get(i).getFecha();
			row[3] = oponente;
			tableModel2.addRow(row);
		}
	}

	private void editarDatos(Controlador datos) {
		if (tfNombre.getText().isBlank() || tfApellido.getText().isBlank() || tfContrasena.getPassword().length == 0
				|| bgGenero.getSelection() == null) {
			JOptionPane.showMessageDialog(this, "Rellene todos los campos correctamente para continuar", "INCOMPLETO",
					JOptionPane.ERROR_MESSAGE);
		} else if (!Arrays.equals(tfContrasena.getPassword(), tfConfirmarContrasena.getPassword())) {
			JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "INCOMPLETO",
					JOptionPane.ERROR_MESSAGE);
		} else {
			Usuario usuario = new Usuario();

			usuario.setUsername(username);
			usuario.setDni(dniJugador);
			usuario.setNombre(tfNombreMod.getText());
			usuario.setApellido(tfApellidoMod.getText());
			usuario.setContrasena(new String(tfContrasena.getPassword()));
			if (rdbtnOtro.isSelected()) {
				usuario.setSexo("Otro");
			} else if (rdbtnMasculino.isSelected()) {
				usuario.setSexo("Hombre");
			} else {
				usuario.setSexo("Mujer");
			}
			try {
				datos.modificarJugador(usuario);
				JOptionPane.showMessageDialog(this, "Jugador modificado correctamente");
				tfUsuario.setText(username);
				tfNombre.setText(usuario.getNombre());
				tfApellido.setText(usuario.getApellido());
				tfSexo.setText(usuario.getSexo());

			} catch (CreateException e) {
				JOptionPane.showMessageDialog(this, "No se ha podido modificar", "INCOMPLETO",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
	}

	private void editarColeccion(Controlador datos) {
		if (cbAgente.getSelectedIndex() == 0 || cbArma.getSelectedIndex() == 0 || cbSkinFav.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Rellena todos campos", "INCOMPLETO", JOptionPane.WARNING_MESSAGE);
		} else {
			try {
				coleccion.setAgenteFav((String) cbAgente.getSelectedItem());
				coleccion.setSkinFav((String) cbSkinFav.getSelectedItem());
				coleccion.setArmaFav((String) cbArma.getSelectedItem());
				datos.actualizarColeccion(jugador.getDni(), coleccion);
				JOptionPane.showMessageDialog(this, "Los cambios han sido guardados", "Confirmación",
						JOptionPane.INFORMATION_MESSAGE);
				coleccion = datos.getColeccion(jugador.getDni());
				tfAgente.setText(coleccion.getAgenteFav());
				tfArma.setText(coleccion.getArmaFav());
				tfSkin.setText(coleccion.getSkinFav());
			} catch (CreateException e) {
				JOptionPane.showMessageDialog(this, "No se pudo modificar la colección", "INCOMPLETO",
						JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();
			}
		}
	}
}