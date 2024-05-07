package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;

public class VerPartida extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable infoPartidas;
	private JButton volver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerPartida frame = new VerPartida();
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
	public VerPartida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		infoPartidas = new JTable();
		infoPartidas.setBounds(64, 22, 537, 335);
		contentPane.add(infoPartidas);
		
		volver = new JButton("Volver");
		volver.setBounds(321, 367, 85, 21);
		contentPane.add(volver);
		
		volver.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object j = e.getSource();
		if(j==volver) {
			Jugador jugar = new Jugador();
			jugar.setVisible(true);
			dispose();
		}
	}
}
