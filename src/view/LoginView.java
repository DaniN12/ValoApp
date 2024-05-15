package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import controller.Controlador;
import excepciones.CreateException;
import model.Usuario;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class LoginView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldUsuario;
	private JButton btnLogin;
	private JButton btnRegistrarse;
	private JPasswordField passContrasena;
	private Controlador datos;

	public LoginView(Controlador datos) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/resources/logoApp.jpg")));

		this.datos = datos;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 541);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(32, 129, 183, 30);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);

		btnLogin = new JButton("LogIn");
		btnLogin.setBounds(60, 389, 122, 30);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(this);

		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(60, 452, 122, 30);
		contentPane.add(btnRegistrarse);
		contentPane.add(btnRegistrarse);
		btnRegistrarse.addActionListener(this);

		passContrasena = new JPasswordField();
		passContrasena.setBounds(32, 169, 183, 30);
		contentPane.add(passContrasena);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginView.class.getResource("/resources/fondoLogin.png")));
		lblNewLabel.setBounds(-51, 0, 1047, 506);
		contentPane.add(lblNewLabel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnRegistrarse)) {
			this.dispose();;
			RegistroView registroView = new RegistroView(datos);
			registroView.setVisible(true);
		}

		if (e.getSource().equals(btnLogin)) {
			login(datos);
		}
	}

	private void login(Controlador datos) {
		// Nombre del usuario, se mete en txtFieldUsuario
		String username = textFieldUsuario.getText();
		// Contrasena, contrasena que se mete en contrasenaField que hay que pasar a
		// String ya que es un array de caracteres
		String contrasena = new String(passContrasena.getPassword());

		// Método para validar el administrador, nombre y contrasena
		Usuario user = null;
		try {
			user = datos.logIn(username, contrasena);
		} catch (CreateException e1) {
			JOptionPane.showMessageDialog(this, "No se ha podido validar el usuario");
		}
		if (user == null) {

			// Si no existe en la base de datos
			JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");

		} else {

			if (user.isEsAdmin()) {
				AdminView av = new AdminView(this, true, user, datos);
				av.setVisible(true);
			} else {
				JugadorView jv = new JugadorView(this, true, user, datos);
				jv.setVisible(true);
			}

		}

	}
}