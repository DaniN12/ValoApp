package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Administrador extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton crearEliminar, modificar, ascender;
	private JButton temporal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrador frame = new Administrador();
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
	public Administrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700,433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(211, 44, 101, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Administrador");
		lblNewLabel_1.setBounds(296, 60, 84, 13);
		contentPane.add(lblNewLabel_1);
		
		crearEliminar = new JButton("Crear/Eliminar partida");
		crearEliminar.setBounds(114, 156, 144, 21);
		contentPane.add(crearEliminar);
		
		modificar = new JButton("Modificar partida");
		modificar.setBounds(114, 187, 144, 21);
		contentPane.add(modificar);
		
		ascender = new JButton("Ascender jugador");
		ascender.setBounds(114, 218, 144, 21);
		contentPane.add(ascender);
		
		temporal = new JButton("Jugador");
		temporal.setBounds(504, 56, 85, 21);
		contentPane.add(temporal);
		
		crearEliminar.addActionListener(this);
		modificar.addActionListener(this);
		ascender.addActionListener(this);
		temporal.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o==crearEliminar) {
			CrearEliminar eleccion = new CrearEliminar();
			eleccion.setVisible(true);
			dispose();
		}
		if(o==modificar) {
			Modificar modify = new Modificar();
			modify.setVisible(true);
			dispose();
		}
		if(o==ascender) {
			Ascender ascenso = new Ascender();
			ascenso.setVisible(true);
			dispose();
		}
		if(o==temporal) {
			Jugador tenporal =new Jugador();
			tenporal.setVisible(true);
			dispose();
		}
		
	}
}
