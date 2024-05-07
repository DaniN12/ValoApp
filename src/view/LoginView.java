package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

public class LoginView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldUsuario;
	private JTextField textFieldContraseña;
	private JButton btnLogin;
	private JLabel lblUsuario;
	private JLabel lblContraseña;
	private JButton btnRegistrarse;

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

		textFieldContraseña = new JTextField();
		textFieldContraseña.setBounds(192, 169, 96, 19);
		contentPane.add(textFieldContraseña);
		textFieldContraseña.setColumns(10);

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

		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(97, 266, 85, 21);
		contentPane.add(btnRegistrarse);
		contentPane.add(btnRegistrarse);
		btnRegistrarse.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnRegistrarse)) {
			RegistroView registroView = new RegistroView();
			registroView.setVisible(true);
		}
	}
}