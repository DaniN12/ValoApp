package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import view.JugadorView;

import com.toedter.calendar.JDateChooser;


import model.MyException;

public class AdminView extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea resulttextField;
	private JButton teamButton;
	private JButton informationButton;
	private JButton btnGuardarModi;
	private JButton upgradeButton;
	private JDateChooser addCalender;
	private JComboBox<String> trainersComboBox;
	private JComboBox<String> comoBoxAscenderJugador;
	private DefaultTableModel tableModel;
	private DefaultTableModel tableModel2;
	private JPanel panelBattle;
	private JPanel paneDelete;
	private JPanel panelModify;
	private JPanel panelAscend;
	private JLabel lblFondoCrear;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblFondoLabo;
	private JLabel lblMapa;
	private JLabel lblFecha;
	private JLabel lblIntroducirNombreParti;
	private JLabel lblSelecMapa;
	private JLabel lblSelecFechaPartida;
	private JTextField textFieldNombrePartida;

	/**
	 * @param loginView
	 * @param loggedProf
	 */
	public AdminView() {

		panelBattle = new JPanel();
		paneDelete = new JPanel();
		paneDelete.setBackground(new Color(63, 204, 220));
		panelModify = new JPanel();
		panelModify.setBackground(new Color(63, 204, 220));
		panelAscend = new JPanel();
		panelAscend.setBackground(new Color(63, 204, 220));
		JTabbedPane pestanas = new JTabbedPane();

		trainersComboBox = new JComboBox<String>();
		trainersComboBox.setMaximumRowCount(20);
		trainersComboBox.setForeground(new Color(0, 0, 0));
		trainersComboBox.setBackground(SystemColor.control);
		trainersComboBox.setBounds(208, 153, 237, 53);
		panelBattle.add(trainersComboBox);
		trainersComboBox.addActionListener(this);

		comoBoxAscenderJugador = new JComboBox<String>();
		comoBoxAscenderJugador.setBounds(404, 91, 222, 31);
		comoBoxAscenderJugador.addActionListener(this);
		panelAscend.add(comoBoxAscenderJugador);

		// 1.Battles View
		panelBattle.setBackground(new Color(192, 192, 192));
		pestanas.addTab("BANEOS", panelBattle);

		panelBattle.setLayout(null);

		teamButton = new JButton("BANEAR");
		teamButton.setBounds(10, 389, 142, 49);
		panelBattle.add(teamButton);
		teamButton.addActionListener(this);

		informationButton = new JButton("REVISAR");
		informationButton.setBounds(10, 291, 142, 55);
		panelBattle.add(informationButton);
		informationButton.addActionListener(this);

		JLabel selectTrainerLabel = new JLabel("Select Trainner:");
		selectTrainerLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		selectTrainerLabel.setBounds(10, 150, 142, 53);
		panelBattle.add(selectTrainerLabel);

		/*
		 * This one is the TextArean where the trainers info is going to be shown it is
		 * an area and not a normal text field because it has to show more than one line
		 * and a label can not handle it
		 */
		resulttextField = new JTextArea(2, 30);
		resulttextField.setBackground(new Color(200, 243, 249));
		resulttextField.setEditable(false);
		resulttextField.setBounds(188, 286, 280, 175);
		panelBattle.add(resulttextField);

		informationButton.setEnabled(false);
		teamButton.setEnabled(false);

		// The JLabel under this comment has no text because the picture of Oak is on
		// this Label
		JLabel professorImageLabel = new JLabel("");
		professorImageLabel.setBounds(667, 178, 188, 341);
		panelBattle.add(professorImageLabel);

		JLabel welcomeProfessorLabel = new JLabel("Bienvenido señor Administrador!!");
		welcomeProfessorLabel.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 17));
		welcomeProfessorLabel.setBounds(24, 30, 294, 28);
		panelBattle.add(welcomeProfessorLabel);

		tableModel = new DefaultTableModel();
		String[] tableHeaders = { "PokedexID", "Name", "Nickname", "Region", "type1", "type2", "level" };
		tableModel.setColumnIdentifiers(tableHeaders);

		tableModel2 = new DefaultTableModel();
		String[] tableHeaders2 = { "TrainerID1", "TrainerID2", "WinnerID" };
		tableModel2.setColumnIdentifiers(tableHeaders2);

		lblFondoLabo = new JLabel("");
		lblFondoLabo.setBounds(0, 0, 1061, 543);
		panelBattle.add(lblFondoLabo);

		// 2.Delete View

		pestanas.addTab("CREAR", paneDelete);
		paneDelete.setLayout(null);

		JLabel deleteMessage = new JLabel("Which trainer do you want to delete?");
		deleteMessage.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 18));
		deleteMessage.setBounds(27, 26, 337, 17);
		paneDelete.add(deleteMessage);

		lblIntroducirNombreParti = new JLabel("Introduce el nombre de la Partida");
		lblIntroducirNombreParti.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIntroducirNombreParti.setBounds(49, 63, 228, 25);
		paneDelete.add(lblIntroducirNombreParti);

		lblSelecMapa = new JLabel("Selecciona un Mapa");
		lblSelecMapa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelecMapa.setBounds(471, 63, 141, 25);
		paneDelete.add(lblSelecMapa);

		lblSelecFechaPartida = new JLabel("Selecciona una fecha para la Partida");
		lblSelecFechaPartida.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelecFechaPartida.setBounds(742, 63, 254, 25);
		paneDelete.add(lblSelecFechaPartida);

		JDateChooser calenderSelecFechaPartida = new JDateChooser();
		calenderSelecFechaPartida.setEnabled(false);
		calenderSelecFechaPartida.setDateFormatString("yyyy-MM-dd");
		calenderSelecFechaPartida.setBounds(742, 97, 233, 20);
		paneDelete.add(calenderSelecFechaPartida);

		textFieldNombrePartida = new JTextField();
		textFieldNombrePartida.setBounds(49, 98, 228, 19);
		paneDelete.add(textFieldNombrePartida);
		textFieldNombrePartida.setColumns(10);

		JComboBox comboBoxSelecMapa = new JComboBox();
		comboBoxSelecMapa.setBounds(471, 98, 141, 21);
		paneDelete.add(comboBoxSelecMapa);

		JButton btnGuardarCrearPartida = new JButton("GUARDAR");
		btnGuardarCrearPartida.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGuardarCrearPartida.setBounds(471, 435, 141, 43);
		paneDelete.add(btnGuardarCrearPartida);

		JLabel lblEquipo = new JLabel("EQUIPO 1");
		lblEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEquipo.setBounds(49, 184, 228, 25);
		paneDelete.add(lblEquipo);

		JLabel lblEquipo_2 = new JLabel("EQUIPO 2");
		lblEquipo_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEquipo_2.setBounds(768, 191, 228, 25);
		paneDelete.add(lblEquipo_2);

		JComboBox comboBoxEquipo1Jugador1 = new JComboBox();
		comboBoxEquipo1Jugador1.setBounds(97, 219, 141, 21);
		paneDelete.add(comboBoxEquipo1Jugador1);

		JComboBox comboBoxEquipo1Jugador2 = new JComboBox();
		comboBoxEquipo1Jugador2.setBounds(97, 263, 141, 21);
		paneDelete.add(comboBoxEquipo1Jugador2);

		JComboBox comboBoxEquipo1Jugador3 = new JComboBox();
		comboBoxEquipo1Jugador3.setBounds(97, 304, 141, 21);
		paneDelete.add(comboBoxEquipo1Jugador3);

		JComboBox comboBoxEquipo1Jugador4 = new JComboBox();
		comboBoxEquipo1Jugador4.setBounds(97, 349, 141, 21);
		paneDelete.add(comboBoxEquipo1Jugador4);

		JComboBox comboBoxEquipo1Jugador5 = new JComboBox();
		comboBoxEquipo1Jugador5.setBounds(97, 392, 141, 21);
		paneDelete.add(comboBoxEquipo1Jugador5);

		JComboBox comboBoxEquipo2Jugador1 = new JComboBox();
		comboBoxEquipo2Jugador1.setBounds(804, 219, 141, 21);
		paneDelete.add(comboBoxEquipo2Jugador1);

		JComboBox comboBoxEquipo2Jugador2 = new JComboBox();
		comboBoxEquipo2Jugador2.setBounds(804, 263, 141, 21);
		paneDelete.add(comboBoxEquipo2Jugador2);

		JComboBox comboBoxEquipo2Jugador3 = new JComboBox();
		comboBoxEquipo2Jugador3.setBounds(804, 304, 141, 21);
		paneDelete.add(comboBoxEquipo2Jugador3);

		JComboBox comboBoxEquipo2Jugador4 = new JComboBox();
		comboBoxEquipo2Jugador4.setBounds(804, 349, 141, 21);
		paneDelete.add(comboBoxEquipo2Jugador4);

		JComboBox comboBoxEquipo2Jugador5 = new JComboBox();
		comboBoxEquipo2Jugador5.setBounds(804, 392, 141, 21);
		paneDelete.add(comboBoxEquipo2Jugador5);

		lblFondoCrear = new JLabel("");
		lblFondoCrear.setBounds(0, 0, 1061, 543);
		paneDelete.add(lblFondoCrear);
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

		JComboBox comboBoxPartidaModi = new JComboBox();
		comboBoxPartidaModi.setBounds(223, 133, 108, 21);
		panelModify.add(comboBoxPartidaModi);

		JComboBox comboBoxMapa = new JComboBox();
		comboBoxMapa.setBounds(223, 199, 108, 21);
		panelModify.add(comboBoxMapa);

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

		// Pestaña4
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
		// trainers to be added and none to be removed

		// Configuramos la ventana

		setSize(1080, 607);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}