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
import java.awt.Font;
import javax.swing.JPasswordField;

public class LoginView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldUsuario;
	private JButton btnLogin;
	private JLabel lblUsuario;
	private JLabel lblContraseña;
	private JButton btnRegistrarse;
	private JPasswordField passContrasena;

	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 433);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(192, 116, 96, 19);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);

		lblUsuario = new JLabel("USUARIO");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(81, 119, 68, 13);
		contentPane.add(lblUsuario);

		lblContraseña = new JLabel("CONTRASEÑA");
		lblContraseña.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContraseña.setBounds(81, 172, 101, 13);
		contentPane.add(lblContraseña);

		btnLogin = new JButton("LogIn");
		btnLogin.setBounds(345, 266, 85, 21);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(this);

		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(97, 266, 85, 21);
		contentPane.add(btnRegistrarse);
		contentPane.add(btnRegistrarse);
		btnRegistrarse.addActionListener(this);

		passContrasena = new JPasswordField();
		passContrasena.setBounds(192, 166, 96, 19);
		contentPane.add(passContrasena);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnRegistrarse)) {
			RegistroView registroView = new RegistroView();
			registroView.setVisible(true);
		}

		if (e.getSource().equals(btnLogin)) {
			// Declaro las variables y objetos
			Controlador datos = new Controlador();

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
				JOptionPane.showMessageDialog(this, "Usuario o contrasena incorrectos");

			} else {

				// Si existe desaparece la ventana y pasa a ARMenu
				this.dispose();
				
				if (user.isEsAdmin()) {
					AdminView av = new AdminView(user, datos);
					av.setVisible(true);
				} else {
					JugadorView jv = new JugadorView(user, datos);
					jv.setVisible(true);
				}

			}
		}
	}
}
