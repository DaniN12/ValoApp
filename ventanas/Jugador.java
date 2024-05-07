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

public class Jugador extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton modificar, coleccion, ver,tenporal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jugador frame = new Jugador();
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
	public Jugador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelBienvenido = new JLabel("Bienvenido:");
		labelBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelBienvenido.setBounds(182, 10, 78, 62);
		contentPane.add(labelBienvenido);
		
		ver = new JButton("Ver partida");
		ver.setBounds(397, 327, 141, 21);
		contentPane.add(ver);
		
		coleccion = new JButton("Coleccion");
		coleccion.setBounds(397, 284, 141, 21);
		contentPane.add(coleccion);
		
		JLabel labelNivel = new JLabel("Nivel");
		labelNivel.setBounds(72, 103, 45, 13);
		contentPane.add(labelNivel);
		
		JLabel labelRango = new JLabel("Rango");
		labelRango.setBounds(72, 158, 45, 13);
		contentPane.add(labelRango);
		
		modificar = new JButton("Modificar datos");
		modificar.setBounds(397, 244, 141, 21);
		contentPane.add(modificar);
		
		tenporal = new JButton("Admin");
		tenporal.setBounds(437, 33, 85, 21);
		contentPane.add(tenporal);
		
		modificar.addActionListener(this);
		coleccion.addActionListener(this);
		ver.addActionListener(this);
		tenporal.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object j = e.getSource();
		if(j==modificar) {
			ModificarJugador jugador = new ModificarJugador();
			jugador.setVisible(true);
			dispose();
		}
		if(j==coleccion) {
			Coleccion colecta = new Coleccion();
			colecta.setVisible(true);
			dispose();
		}
		if(j==ver) {
			VerPartida partida = new VerPartida();
			partida.setVisible(true);
			dispose();
		}
		if(j==tenporal){
			Administrador temporal = new Administrador();
			temporal.setVisible(true);
			dispose();
		}
		}
}
