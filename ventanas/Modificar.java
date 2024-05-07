package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

public class Modificar extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox partidas, mapSeleccion;
	private JLabel modPartida,mapas,fechaPartida;
	private JDateChooser dateChooser;
	private JButton comprobar;
	private JButton guardar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modificar frame = new Modificar();
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
	public Modificar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		modPartida = new JLabel("Partida a modificar:");
		modPartida.setBounds(85, 91, 123, 13);
		contentPane.add(modPartida);
		
		partidas = new JComboBox();
		partidas.setBounds(221, 88, 139, 19);
		contentPane.add(partidas);
		
		comprobar = new JButton("Comprobar existencia");
		comprobar.setBounds(422, 87, 183, 21);
		contentPane.add(comprobar);
		
		mapSeleccion = new JComboBox();
		mapSeleccion.setBounds(159, 178, 139, 19);
		contentPane.add(mapSeleccion);
		
		mapas = new JLabel("Mapa:");
		mapas.setBounds(85, 181, 45, 13);
		contentPane.add(mapas);
		
		fechaPartida = new JLabel("Fecha:");
		fechaPartida.setBounds(85, 253, 45, 13);
		contentPane.add(fechaPartida);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(172, 253, 126, 19);
		contentPane.add(dateChooser);
		
		guardar = new JButton("Guardar y volver");
		guardar.setBounds(302, 341, 123, 21);
		contentPane.add(guardar);
		
		mapSeleccion.setVisible(false);
		fechaPartida.setVisible(false);
		dateChooser.setVisible(false);
		mapas.setVisible(false);
		
		comprobar.addActionListener(this);
		guardar.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		Object g = e.getSource();
		if (o == comprobar) {
	        JOptionPane.showMessageDialog(this,(String)"Esta partida ha sido jugada","Error",JOptionPane.INFORMATION_MESSAGE);
			mapSeleccion.setVisible(true);
			fechaPartida.setVisible(true);
			dateChooser.setVisible(true);
			mapas.setVisible(true);
		}
		if(g==guardar) {
			Administrador volver = new Administrador();
			volver.setVisible(true);
			dispose();
		}
	}
}
