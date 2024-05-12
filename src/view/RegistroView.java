package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistroView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField usuario;
	private JTextField dni;
	private JPasswordField contrasena;
	private JPasswordField confirmarContrasena;
	private JTextField genero;
	private JButton btContinuar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroView frame = new RegistroView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistroView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(105, 71, 45, 13);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido: ");
		lblApellido.setBounds(105, 94, 45, 13);
		contentPane.add(lblApellido);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setBounds(294, 71, 45, 13);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasena = new JLabel("Contraseña: ");
		lblContrasena.setBounds(294, 94, 59, 13);
		contentPane.add(lblContrasena);
		
		JLabel lblSexo = new JLabel("Sexo: ");
		lblSexo.setBounds(105, 152, 45, 13);
		contentPane.add(lblSexo);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento: ");
		lblFechaDeNacimiento.setBounds(100, 193, 102, 13);
		contentPane.add(lblFechaDeNacimiento);
		
		JLabel lblDni = new JLabel("DNI: ");
		lblDni.setBounds(105, 117, 45, 13);
		contentPane.add(lblDni);
		
		nombre = new JTextField();
		nombre.setBounds(151, 68, 96, 19);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		apellido = new JTextField();
		apellido.setColumns(10);
		apellido.setBounds(151, 91, 96, 19);
		contentPane.add(apellido);
		
		usuario = new JTextField();
		usuario.setColumns(10);
		usuario.setBounds(350, 68, 96, 19);
		contentPane.add(usuario);
		
		dni = new JTextField();
		dni.setColumns(10);
		dni.setBounds(151, 114, 96, 19);
		contentPane.add(dni);
		
		contrasena = new JPasswordField();
		contrasena.setBounds(360, 92, 89, 16);
		contentPane.add(contrasena);
		
		JLabel lblConfirmarContrasena = new JLabel("Confirmar contraseña: ");
		lblConfirmarContrasena.setBounds(294, 117, 118, 13);
		contentPane.add(lblConfirmarContrasena);
		
		confirmarContrasena = new JPasswordField();
		confirmarContrasena.setBounds(411, 115, 89, 16);
		contentPane.add(confirmarContrasena);
		
		JRadioButton rbHombre = new JRadioButton("HOMBRE");
		rbHombre.setBounds(144, 148, 71, 21);
		contentPane.add(rbHombre);
		
		JRadioButton rbMujer = new JRadioButton("MUJER");
		rbMujer.setBounds(217, 148, 56, 21);
		contentPane.add(rbMujer);
		
		JRadioButton rbOtro = new JRadioButton("Otro:");
		rbOtro.setBounds(275, 148, 50, 21);
		contentPane.add(rbOtro);
		
		genero = new JTextField();
		genero.setBounds(331, 149, 96, 19);
		contentPane.add(genero);
		genero.setColumns(10);
		
		btContinuar = new JButton("Guardar y volver");
		btContinuar.setBounds(245, 316, 167, 21);
		contentPane.add(btContinuar);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(212, 193, 127, 19);
		getContentPane().add(dateChooser);
		contentPane.add(dateChooser);
		
		btContinuar.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btContinuar) {
			LoginView login = new LoginView(user, datos);
			login.setVisible(true);
			dispose();
		}
	}
}