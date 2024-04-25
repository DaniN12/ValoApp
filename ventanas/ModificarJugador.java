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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarJugador extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField usuario;
	private JPasswordField contrasena;
	private JPasswordField confirmarContrasena;
	private JTextField genero;
	private JButton btContinuar;
	private JPasswordField antiguo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarJugador frame = new ModificarJugador();
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
	public ModificarJugador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(103, 141, 45, 13);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido: ");
		lblApellido.setBounds(103, 164, 45, 13);
		contentPane.add(lblApellido);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setBounds(103, 187, 45, 13);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasena = new JLabel("Contraseña: ");
		lblContrasena.setBounds(292, 164, 59, 13);
		contentPane.add(lblContrasena);
		
		JLabel lblSexo = new JLabel("Sexo: ");
		lblSexo.setBounds(103, 222, 45, 13);
		contentPane.add(lblSexo);
		
		nombre = new JTextField();
		nombre.setBounds(149, 138, 96, 19);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		apellido = new JTextField();
		apellido.setColumns(10);
		apellido.setBounds(149, 161, 96, 19);
		contentPane.add(apellido);
		
		usuario = new JTextField();
		usuario.setColumns(10);
		usuario.setBounds(149, 184, 96, 19);
		contentPane.add(usuario);
		
		contrasena = new JPasswordField();
		contrasena.setBounds(358, 162, 89, 16);
		contentPane.add(contrasena);
		
		JLabel lblConfirmarContrasena = new JLabel("Confirmar contraseña: ");
		lblConfirmarContrasena.setBounds(292, 187, 118, 13);
		contentPane.add(lblConfirmarContrasena);
		
		confirmarContrasena = new JPasswordField();
		confirmarContrasena.setBounds(409, 185, 89, 16);
		contentPane.add(confirmarContrasena);
		
		JRadioButton rbHombre = new JRadioButton("HOMBRE");
		rbHombre.setBounds(142, 218, 71, 21);
		contentPane.add(rbHombre);
		
		JRadioButton rbMujer = new JRadioButton("MUJER");
		rbMujer.setBounds(215, 218, 56, 21);
		contentPane.add(rbMujer);
		
		JRadioButton rbOtro = new JRadioButton("Otro:");
		rbOtro.setBounds(273, 218, 50, 21);
		contentPane.add(rbOtro);
		
		genero = new JTextField();
		genero.setBounds(329, 219, 96, 19);
		contentPane.add(genero);
		genero.setColumns(10);
		
		btContinuar = new JButton("Continuar");
		btContinuar.setBounds(245, 316, 167, 21);
		contentPane.add(btContinuar);
		
		JLabel lblNewLabel = new JLabel("Contraseña actual:");
		lblNewLabel.setBounds(292, 141, 101, 13);
		contentPane.add(lblNewLabel);
		
		antiguo = new JPasswordField();
		antiguo.setBounds(379, 138, 89, 16);
		contentPane.add(antiguo);
		
		btContinuar.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btContinuar) {
			Login login = new Login();
			login.setVisible(true);
			dispose();
		}
	}
}