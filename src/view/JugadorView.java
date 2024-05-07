package view;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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


import javax.swing.JRadioButton;

public class JugadorView extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldApellidoMod;
	private JTextField textFieldUsuarioMod;
	private JTextField textFieldContraActualMod;
	private JTextField textFieldConfirmarContra;
	private JButton btnGuardarMod;
	private DefaultTableModel tableModel;
	private DefaultTableModel tableModel2;
	private JPanel panelInfo;
	private JPanel panelColección;
	private JPanel panelModificar;
	private JPanel panelPartidas;
	private JLabel lblFondo;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblFondoLabo;
	private JTextField textFieldNombreMod;
	private JTextField textFieldContraNueva;
	private JTextField textFieldUsuario;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldSexo;
	private JTextField textFieldAgente;
	private JTextField textFieldArma;
	private JTextField textFieldSkinFav;
	private JLabel lblAgenteColec;
	private JLabel lblArmaColec;
	private JLabel lblSkinFavColec;
	private JComboBox comboBoxArma;
	private JComboBox comboBoxSkinFav;
	private JLabel armaImagen;
	private JLabel skinFavImagen;
	private JTextField textFieldOtro;
	private JTable table;

	/**
	 * @param loginView
	 * @param loggedProf
	 */
	public JugadorView() {
		

		panelInfo = new JPanel();
		panelColección = new JPanel();
		panelColección.setBackground(new Color(63, 204, 220));
		panelModificar = new JPanel();
		panelModificar.setBackground(new Color(63, 204, 220));
		panelPartidas = new JPanel();
		panelPartidas.setBackground(new Color(63, 204, 220));
		JTabbedPane pestanas = new JTabbedPane();

		// 1.Battles View
		panelInfo.setBackground(new Color(192, 192, 192));
		pestanas.addTab("INFO", panelInfo);

		panelInfo.setLayout(null);

		// The JLabel under this comment has no text because the picture of Oak is on
		// this Label
		JLabel imagenJugadorLabel = new JLabel("rggrgrg");
		imagenJugadorLabel.setIcon(new ImageIcon(JugadorView.class.getResource("/resources/oak.png")));
		imagenJugadorLabel.setBounds(667, 178, 188, 341);
		panelInfo.add(imagenJugadorLabel);

		JLabel bienvenidoJugadorLabel = new JLabel("Bienvenido Jugador!!");
		bienvenidoJugadorLabel.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 17));
		bienvenidoJugadorLabel.setBounds(24, 30, 248, 28);
		panelInfo.add(bienvenidoJugadorLabel);

		tableModel = new DefaultTableModel();
		String[] tableHeaders = { "PokedexID", "Name", "Nickname", "Region", "type1", "type2", "level" };
		tableModel.setColumnIdentifiers(tableHeaders);

		tableModel2 = new DefaultTableModel();
		String[] tableHeaders2 = { "TrainerID1", "TrainerID2", "WinnerID" };
		tableModel2.setColumnIdentifiers(tableHeaders2);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(59, 105, 96, 21);
		panelInfo.add(lblUsuario);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(59, 140, 96, 21);
		panelInfo.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido.setBounds(59, 171, 96, 21);
		panelInfo.add(lblApellido);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSexo.setBounds(59, 202, 96, 21);
		panelInfo.add(lblSexo);
		
		JLabel lblAgente = new JLabel("Agente");
		lblAgente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAgente.setBounds(59, 236, 96, 21);
		panelInfo.add(lblAgente);
		
		JLabel lblArma = new JLabel("Arma");
		lblArma.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblArma.setBounds(59, 267, 106, 21);
		panelInfo.add(lblArma);
		
		JLabel lblSkinFav = new JLabel("Skin Favorita:");
		lblSkinFav.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSkinFav.setBounds(59, 299, 106, 21);
		panelInfo.add(lblSkinFav);
				
				textFieldUsuario = new JTextField();
				textFieldUsuario.setEditable(false);
				textFieldUsuario.setBounds(181, 105, 106, 22);
				panelInfo.add(textFieldUsuario);
				textFieldUsuario.setColumns(10);
						
						textFieldNombre = new JTextField();
						textFieldNombre.setEditable(false);
						textFieldNombre.setColumns(10);
						textFieldNombre.setBounds(181, 139, 106, 22);
						panelInfo.add(textFieldNombre);
						
						textFieldApellido = new JTextField();
						textFieldApellido.setEditable(false);
						textFieldApellido.setColumns(10);
						textFieldApellido.setBounds(181, 171, 106, 22);
						panelInfo.add(textFieldApellido);
						
						textFieldSexo = new JTextField();
						textFieldSexo.setEditable(false);
						textFieldSexo.setColumns(10);
						textFieldSexo.setBounds(181, 203, 106, 22);
						panelInfo.add(textFieldSexo);
								
								textFieldAgente = new JTextField();
								textFieldAgente.setEditable(false);
								textFieldAgente.setColumns(10);
								textFieldAgente.setBounds(181, 235, 106, 22);
								panelInfo.add(textFieldAgente);
								
								textFieldArma = new JTextField();
								textFieldArma.setEditable(false);
								textFieldArma.setColumns(10);
								textFieldArma.setBounds(181, 267, 106, 22);
								panelInfo.add(textFieldArma);
								
								textFieldSkinFav = new JTextField();
								textFieldSkinFav.setEditable(false);
								textFieldSkinFav.setColumns(10);
								textFieldSkinFav.setBounds(181, 299, 106, 22);
								panelInfo.add(textFieldSkinFav);
								
										lblFondoLabo = new JLabel("");
										lblFondoLabo.setIcon(new ImageIcon(JugadorView.class.getResource("/resources/labo.png")));
										lblFondoLabo.setBounds(0, 0, 1061, 543);
										panelInfo.add(lblFondoLabo);

		// 2.Delete View

		pestanas.addTab("COLECCIÓN", panelColección);
		panelColección.setLayout(null);

		JLabel deleteMessage = new JLabel("Bienvenido a tu Colección");
		deleteMessage.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 18));
		deleteMessage.setBounds(27, 26, 337, 17);
		panelColección.add(deleteMessage);

		// Pestaña3
		JLabel agenteImagen = new JLabel("sgdssgfghgf");
		agenteImagen.setIcon(new ImageIcon(JugadorView.class.getResource("/resources/brocks-removebg-preview.png")));
		agenteImagen.setBounds(64, 183, 205, 149);
		panelColección.add(agenteImagen);
		
		armaImagen = new JLabel("sgdssgfghgf");
		armaImagen.setBounds(441, 183, 205, 149);
		panelColección.add(armaImagen);
		
		skinFavImagen = new JLabel("sgdssgfghgf");
		skinFavImagen.setBounds(831, 183, 205, 149);
		panelColección.add(skinFavImagen);
		
		lblAgenteColec = new JLabel("Agente");
		lblAgenteColec.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgenteColec.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAgenteColec.setBounds(111, 91, 104, 24);
		panelColección.add(lblAgenteColec);
				
				lblArmaColec = new JLabel("Arma");
				lblArmaColec.setHorizontalAlignment(SwingConstants.CENTER);
				lblArmaColec.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblArmaColec.setBounds(485, 91, 104, 24);
				panelColección.add(lblArmaColec);
				
				lblSkinFavColec = new JLabel("Skin Favorita");
				lblSkinFavColec.setHorizontalAlignment(SwingConstants.CENTER);
				lblSkinFavColec.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblSkinFavColec.setBounds(831, 91, 133, 24);
				panelColección.add(lblSkinFavColec);
				
				JComboBox comboBoxAgente = new JComboBox();
				comboBoxAgente.setBounds(81, 125, 168, 34);
				panelColección.add(comboBoxAgente);
				
				comboBoxArma = new JComboBox();
				comboBoxArma.setBounds(456, 125, 168, 34);
				panelColección.add(comboBoxArma);
				
				comboBoxSkinFav = new JComboBox();
				comboBoxSkinFav.setBounds(824, 125, 168, 34);
				panelColección.add(comboBoxSkinFav);
				
				JButton btnGuardarColec = new JButton("GUARDAR");
				btnGuardarColec.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnGuardarColec.setBounds(476, 434, 148, 52);
				panelColección.add(btnGuardarColec);
		
				lblFondo = new JLabel("");
				lblFondo.setIcon(new ImageIcon(JugadorView.class.getResource("/resources/fondo2.png")));
				lblFondo.setBounds(0, 0, 1061, 543);
				panelColección.add(lblFondo);
		pestanas.addTab("MODIFICAR", panelModificar);
		panelModificar.setLayout(null);
		
				JLabel lblNombreMod = new JLabel("NOMBRE");
				lblNombreMod.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblNombreMod.setHorizontalAlignment(SwingConstants.LEFT);
				lblNombreMod.setBounds(151, 137, 86, 14);
				panelModificar.add(lblNombreMod);
		
				JLabel lblApellidoMod = new JLabel("APELLIDO");
				lblApellidoMod.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblApellidoMod.setHorizontalAlignment(SwingConstants.LEFT);
				lblApellidoMod.setBounds(151, 168, 86, 14);
				panelModificar.add(lblApellidoMod);
		
				JLabel lblUsuarioMod = new JLabel("USUARIO");
				lblUsuarioMod.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblUsuarioMod.setHorizontalAlignment(SwingConstants.LEFT);
				lblUsuarioMod.setBounds(151, 199, 86, 14);
				panelModificar.add(lblUsuarioMod);
		
				JLabel lblContraAcutal = new JLabel("CONTRASEÑA ACTUAL");
				lblContraAcutal.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblContraAcutal.setHorizontalAlignment(SwingConstants.LEFT);
				lblContraAcutal.setBounds(151, 230, 149, 14);
				panelModificar.add(lblContraAcutal);
		
				JLabel lblContraNueva = new JLabel("CONTRASEÑA NUEVA");
				lblContraNueva.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblContraNueva.setHorizontalAlignment(SwingConstants.LEFT);
				lblContraNueva.setBounds(151, 263, 149, 14);
				panelModificar.add(lblContraNueva);
		
				JLabel lblConfirmarContra = new JLabel("CONFIRMAR CONTRASEÑA");
				lblConfirmarContra.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblConfirmarContra.setHorizontalAlignment(SwingConstants.LEFT);
				lblConfirmarContra.setBounds(151, 292, 178, 14);
				panelModificar.add(lblConfirmarContra);
		
		JLabel lblSexoMod = new JLabel("SEXO");
		lblSexoMod.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSexoMod.setHorizontalAlignment(SwingConstants.LEFT);
		lblSexoMod.setBounds(151, 326, 53, 14);
		panelModificar.add(lblSexoMod);
		
		textFieldNombreMod = new JTextField();
		textFieldNombreMod.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNombreMod.setEnabled(false);
		textFieldNombreMod.setColumns(10);
		textFieldNombreMod.setBounds(341, 136, 101, 20);
		panelModificar.add(textFieldNombreMod);
		
				textFieldApellidoMod = new JTextField();
				textFieldApellidoMod.setHorizontalAlignment(SwingConstants.CENTER);
				textFieldApellidoMod.setBounds(341, 167, 101, 20);
				panelModificar.add(textFieldApellidoMod);
				textFieldApellidoMod.setColumns(10);
				textFieldApellidoMod.setEnabled(false);
		
				textFieldUsuarioMod = new JTextField();
				textFieldUsuarioMod.setHorizontalAlignment(SwingConstants.CENTER);
				textFieldUsuarioMod.setColumns(10);
				textFieldUsuarioMod.setBounds(341, 197, 101, 20);
				panelModificar.add(textFieldUsuarioMod);
				textFieldUsuarioMod.setEnabled(false);
		
				textFieldContraActualMod = new JTextField();
				textFieldContraActualMod.setHorizontalAlignment(SwingConstants.CENTER);
				textFieldContraActualMod.setColumns(10);
				textFieldContraActualMod.setBounds(341, 227, 101, 20);
				panelModificar.add(textFieldContraActualMod);
				textFieldContraActualMod.setEnabled(false);
		
		textFieldContraNueva = new JTextField();
		textFieldContraNueva.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldContraNueva.setEnabled(false);
		textFieldContraNueva.setColumns(10);
		textFieldContraNueva.setBounds(341, 262, 101, 20);
		panelModificar.add(textFieldContraNueva);

		textFieldConfirmarContra = new JTextField();
		textFieldConfirmarContra.setEditable(false);
		textFieldConfirmarContra.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldConfirmarContra.setColumns(10);
		textFieldConfirmarContra.setBounds(341, 291, 101, 20);
		panelModificar.add(textFieldConfirmarContra);

		btnGuardarMod = new JButton("GUARDAR");
		btnGuardarMod.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGuardarMod.addActionListener(this);
		btnGuardarMod.setBounds(207, 419, 122, 31);
		panelModificar.add(btnGuardarMod);
		textFieldConfirmarContra.setEnabled(false);

		JLabel lblNewLabel = new JLabel("OBHBJHKBJH");
		lblNewLabel.setIcon(new ImageIcon(JugadorView.class.getResource("/resources/joven.png")));
		lblNewLabel.setBounds(728, 125, 290, 346);
		panelModificar.add(lblNewLabel);
		
		JRadioButton rdbtnMasculino = new JRadioButton("MASCULINO");
		rdbtnMasculino.setBounds(207, 324, 103, 21);
		panelModificar.add(rdbtnMasculino);
		
		JRadioButton rdbtnFemenino = new JRadioButton("FEMENINO");
		rdbtnFemenino.setBounds(341, 324, 103, 21);
		panelModificar.add(rdbtnFemenino);
		
		JRadioButton rdbtnOtro = new JRadioButton("OTRO:");
		rdbtnOtro.setBounds(479, 324, 65, 21);
		panelModificar.add(rdbtnOtro);
		
		textFieldOtro = new JTextField();
		textFieldOtro.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldOtro.setEnabled(false);
		textFieldOtro.setColumns(10);
		textFieldOtro.setBounds(550, 325, 101, 20);
		panelModificar.add(textFieldOtro);
		
				lblNewLabel_2 = new JLabel("");
				lblNewLabel_2.setIcon(new ImageIcon(JugadorView.class.getResource("/resources/fondo3.png")));
				lblNewLabel_2.setBounds(0, 0, 1061, 543);
				panelModificar.add(lblNewLabel_2);

		// Pestaña4
		pestanas.addTab("PARTIDAS", panelPartidas);
		panelPartidas.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Bienvenido a tu Trayectoria!!");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setBackground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(414, 10, 286, 37);
		panelPartidas.add(lblNewLabel_4);
		
		table = new JTable();
		table.setBounds(214, 93, 662, 402);
		panelPartidas.add(table);
		
				lblNewLabel_3 = new JLabel("");
				lblNewLabel_3.setIcon(new ImageIcon(JugadorView.class.getResource("/resources/ashfin.png")));
				lblNewLabel_3.setBounds(0, 0, 1061, 543);
				panelPartidas.add(lblNewLabel_3);

		getContentPane().add(pestanas);
		// Using @param name = null because I want all
		// trainers to be added and none to be removed
		
		// Configuramos la ventana

		setSize(1080, 607);
	}

	 @Override
	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == btnGuardarMod) {
	            
	            JOptionPane.showMessageDialog(this, "Los cambios han sido guardados", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
	        }
	    }
	}



