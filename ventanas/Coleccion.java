package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Coleccion extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton guardar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Coleccion frame = new Coleccion();
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
	public Coleccion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox armas = new JComboBox();
		armas.setBounds(148, 146, 141, 21);
		contentPane.add(armas);
		
		JComboBox skins = new JComboBox();
		skins.setBounds(421, 146, 141, 21);
		contentPane.add(skins);
		
		JComboBox agentes = new JComboBox();
		agentes.setBounds(148, 84, 141, 21);
		contentPane.add(agentes);
		
		JLabel labelAgente = new JLabel("Agente:");
		labelAgente.setBounds(44, 88, 45, 13);
		contentPane.add(labelAgente);
		
		JLabel labelArma = new JLabel("Arma:");
		labelArma.setBounds(44, 150, 45, 13);
		contentPane.add(labelArma);
		
		JLabel labelSkin = new JLabel("Skin Favorita:");
		labelSkin.setBounds(317, 150, 94, 13);
		contentPane.add(labelSkin);
		
		guardar = new JButton("Guardar y volver");
		guardar.setBounds(297, 328, 141, 21);
		contentPane.add(guardar);
		
		guardar.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == guardar) {
			Jugador jugar = new Jugador();
			jugar.setVisible(true);
			dispose();
		}
		
	}

}
