package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnRegstrate,iniciar;
	private JLabel olvidar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(225, 140, 48, 19);
		contentPane.add(lblNewLabel);

		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setBounds(213, 169, 56, 19);
		contentPane.add(lblContrasea);

		iniciar = new JButton("Iniciar sesión");
		iniciar.setBounds(273, 279, 118, 21);
		contentPane.add(iniciar);

		JLabel lblNewLabel_1 = new JLabel("¿No tienes una cuenta?");
		lblNewLabel_1.setBounds(202, 340, 111, 19);
		contentPane.add(lblNewLabel_1);

		btnRegstrate = new JButton("Regístrate");
		btnRegstrate.setBounds(315, 339, 118, 21);
		contentPane.add(btnRegstrate);

		textField = new JTextField();
		textField.setBounds(283, 140, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(283, 169, 96, 19);
		contentPane.add(passwordField);
		
		olvidar = new JLabel("Se te olvido la contraseña?");
		olvidar.setBounds(240, 216, 151, 13);
		contentPane.add(olvidar);
		olvidar.setVisible(false);
		
		iniciar.addActionListener(this);
		btnRegstrate.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		Object i = e.getSource();
		Object r  = e.getSource();
		if (i == iniciar) {
			olvidar.setVisible(true);
		}
		if (r == btnRegstrate) {
			Registro registrar = new Registro();
			registrar.setVisible(true);
			dispose();
	}
	}
	
}