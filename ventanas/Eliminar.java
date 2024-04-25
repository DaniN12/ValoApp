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

public class Eliminar extends JFrame implements ActionListener {

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
					Eliminar frame = new Eliminar();
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
	public Eliminar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(171, 51, 137, 27);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Mapa:");
		lblNewLabel.setBounds(69, 58, 68, 13);
		contentPane.add(lblNewLabel);
		
		guardar = new JButton("Guardar y volver");
		guardar.setBounds(282, 291, 137, 21);
		contentPane.add(guardar);
		
		guardar.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object v = e.getSource();
		if(v==guardar) {
			Administrador volver = new Administrador();
			volver.setVisible(true);
			dispose();
		}
	}
}
