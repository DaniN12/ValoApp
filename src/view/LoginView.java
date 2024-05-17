/**
 * Esta clase representa la vista de inicio de sesión de la aplicación.
 * Proporciona una interfaz gráfica para que los usuarios ingresen sus credenciales.
 * Los usuarios pueden iniciar sesión con un nombre de usuario y una contraseña o registrarse como nuevos usuarios.
 * 
 * La vista contiene campos de texto para ingresar el nombre de usuario y la contraseña, así como botones para iniciar sesión y registrarse.
 * Cuando un usuario intenta iniciar sesión, se verifica la validez de las credenciales proporcionadas.
 * Si las credenciales son válidas y el usuario es administrador, se abre la vista de administrador.
 * Si las credenciales son válidas y el usuario es un jugador regular, se abre la vista de jugador.
 * Si las credenciales no son válidas, se muestra un mensaje de error.
 * 
 * Esta clase implementa la interfaz ActionListener para manejar eventos de botones.
 */

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

/**
 * Constructor de la clase LoginView.
 * 
 * @param datos Objeto Controlador que proporciona acceso a los datos y métodos necesarios.
 */

public class LoginView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldUsuario;
	private JButton btnLogin;
	private JButton btnRegistrarse;
	private JPasswordField passContrasena;
	private Controlador datos;

	public LoginView(Controlador datos) {
		setTitle("ValoApp");
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
	
	/**
     * Maneja los eventos de los botones.
     * 
     * @param e Objeto ActionEvent que representa el evento que ocurrió.
     */

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnRegistrarse)) {
			RegistroView registroView = new RegistroView(this, true, datos);
			registroView.setVisible(true);
		}

		if (e.getSource().equals(btnLogin)) {
			login(datos);
		}
	}
	
	/**
     * Método para manejar el inicio de sesión.
     * 
     * @param datos Objeto Controlador que proporciona acceso a los datos y métodos necesarios.
     */

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