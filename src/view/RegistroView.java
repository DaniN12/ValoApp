package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import controller.Controlador;
import excepciones.CreateException;
import model.Usuario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class RegistroView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfUsuario;
	private JTextField tfDni;
	private JPasswordField tfContrasena;
	private JPasswordField tfConfirmarContrasena;
	private JButton btnRegistro;
	private final ButtonGroup bgGenero = new ButtonGroup();
	private Controlador datos;
	private JRadioButton rbHombre;
	private JRadioButton rbMujer;
	private JRadioButton rbOtro;
	private JDateChooser calendarNacimiento;
	private JLabel lblContraseaNueva;
	private JLabel lblConfirmarContra;
	private JLabel lblSexo;
	private JLabel lblFecha_nac;
	private JLabel lblDNI;

	public RegistroView(Controlador datos) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroView.class.getResource("/resources/logoApp.jpg")));
		this.datos = datos;
		setBounds(100, 100, 969, 541);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfNombre = new JTextField();
		tfNombre.setToolTipText("Nombre");
		tfNombre.setBounds(151, 121, 96, 19);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);

		tfApellido = new JTextField();
		tfApellido.setToolTipText("Apellido");
		tfApellido.setColumns(10);
		tfApellido.setBounds(151, 151, 96, 19);
		contentPane.add(tfApellido);

		tfUsuario = new JTextField();
		tfUsuario.setToolTipText("Usuario");
		tfUsuario.setColumns(10);
		tfUsuario.setBounds(151, 179, 96, 19);
		contentPane.add(tfUsuario);

		tfDni = new JTextField();
		tfDni.setColumns(10);
		tfDni.setBounds(679, 205, 109, 19);
		contentPane.add(tfDni);

		tfContrasena = new JPasswordField();
		tfContrasena.setToolTipText("Contraseña");
		tfContrasena.setBounds(192, 208, 96, 16);
		contentPane.add(tfContrasena);

		tfConfirmarContrasena = new JPasswordField();
		tfConfirmarContrasena.setToolTipText("Confirmar contraseña");
		tfConfirmarContrasena.setBounds(192, 246, 96, 16);
		contentPane.add(tfConfirmarContrasena);

		rbHombre = new JRadioButton("HOMBRE");
		rbHombre.setBounds(608, 151, 96, 21);
		contentPane.add(rbHombre);
		bgGenero.add(rbHombre);

		rbMujer = new JRadioButton("MUJER");
		rbMujer.setBounds(706, 151, 82, 21);
		contentPane.add(rbMujer);
		bgGenero.add(rbMujer);

		rbOtro = new JRadioButton("OTRO");
		rbOtro.setBounds(790, 151, 71, 21);
		contentPane.add(rbOtro);
		bgGenero.add(rbOtro);

		btnRegistro = new JButton("REGISTRARME");
		btnRegistro.setBounds(387, 304, 146, 45);
		contentPane.add(btnRegistro);
		btnRegistro.addActionListener(this);

		calendarNacimiento = new JDateChooser();
		calendarNacimiento.setDateFormatString("yyyy-MM-dd");
		calendarNacimiento.setBounds(679, 178, 108, 20);
		contentPane.add(calendarNacimiento);
		
		JLabel lblNewLabel = new JLabel("BIENVENIDO A VALOAPP");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 11, 315, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblRegstrese = new JLabel("REGÍSTRESE");
		lblRegstrese.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegstrese.setForeground(Color.WHITE);
		lblRegstrese.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblRegstrese.setBounds(0, 44, 315, 45);
		contentPane.add(lblRegstrese);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(83, 176, 96, 21);
		contentPane.add(lblUsuario);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(83, 118, 96, 21);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido.setBounds(83, 150, 96, 21);
		contentPane.add(lblApellido);
		
		lblContraseaNueva = new JLabel("CONTRASEÑA:");
		lblContraseaNueva.setForeground(new Color(255, 255, 255));
		lblContraseaNueva.setHorizontalAlignment(SwingConstants.LEFT);
		lblContraseaNueva.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblContraseaNueva.setBounds(97, 209, 149, 14);
		contentPane.add(lblContraseaNueva);
		
		lblConfirmarContra = new JLabel("CONFIRMAR CONTRASEÑA:");
		lblConfirmarContra.setForeground(new Color(255, 255, 255));
		lblConfirmarContra.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmarContra.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConfirmarContra.setBounds(15, 246, 223, 14);
		contentPane.add(lblConfirmarContra);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setForeground(Color.WHITE);
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSexo.setBounds(564, 151, 96, 21);
		contentPane.add(lblSexo);
		
		lblFecha_nac = new JLabel("Fecha de nacimiento:");
		lblFecha_nac.setForeground(Color.WHITE);
		lblFecha_nac.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFecha_nac.setBounds(528, 176, 185, 21);
		contentPane.add(lblFecha_nac);
		
		lblDNI = new JLabel("DNI:");
		lblDNI.setForeground(Color.WHITE);
		lblDNI.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDNI.setBounds(641, 202, 96, 21);
		contentPane.add(lblDNI);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(RegistroView.class.getResource("/resources/fondoRegistro.jpg")));
		lblFondo.setBounds(-488, 0, 1506, 739);
		contentPane.add(lblFondo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnRegistro)) {
			registro(datos);
		}
	}

	private void registro(Controlador datos) {
		Date fechaActual = new Date();

		if (tfNombre.getText().isBlank() || tfApellido.getText().isBlank() || tfUsuario.getText().isBlank()
				|| tfDni.getText().isBlank() || tfContrasena.getPassword().length == 0
				|| tfConfirmarContrasena.getPassword().length == 0 || tfDni.getText().isBlank()
				|| bgGenero.getSelection() == null || calendarNacimiento.getDate() == null || calendarNacimiento.getDate().after(fechaActual)) {

			JOptionPane.showMessageDialog(this, "Rellene todos los campos correctamente para continuar", "INCOMPLETO",
					JOptionPane.ERROR_MESSAGE);

		} else if (!Arrays.equals(tfContrasena.getPassword(), tfConfirmarContrasena.getPassword())) {
			JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "INCOMPLETO",
					JOptionPane.ERROR_MESSAGE);
		} else {
			Usuario usuario = new Usuario();

			usuario.setNombre(tfNombre.getText());
			usuario.setApellido(tfApellido.getText());
			usuario.setDni(tfDni.getText());
			usuario.setUsername(tfUsuario.getText());
			usuario.setEsAdmin(false);
			usuario.setContrasena(new String(tfContrasena.getPassword()));
			if (rbOtro.isSelected()) {
				usuario.setSexo("Otro");
			} else if (rbHombre.isSelected()) {
				usuario.setSexo("Hombre");
			} else {
				usuario.setSexo("Mujer");
			}
			java.sql.Date date = new java.sql.Date(calendarNacimiento.getDate().toInstant().toEpochMilli());
			usuario.setNacimiento(date);
			try {
				datos.registro(usuario);
				datos.crearColeccion(usuario.getDni());
				JOptionPane.showMessageDialog(this, "Jugador registrado correctamente");
				this.dispose();
				LoginView lv = new LoginView(datos);
				lv.setVisible(true);
				JugadorView jv = new JugadorView(lv, true, usuario, datos);
				jv.setVisible(true);
			} catch (CreateException e) {
				JOptionPane.showMessageDialog(this, "No se ha podido registrar", "INCOMPLETO",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}

	}
}