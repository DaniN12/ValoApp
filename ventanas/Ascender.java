package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;

public class Ascender extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable informacion;
	private JButton guardar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ascender frame = new Ascender();
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
	public Ascender() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelUsuario = new JLabel("Elige el usuario:");
		labelUsuario.setBounds(85, 91, 123, 13);
		contentPane.add(labelUsuario);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(200, 89, 123, 17);
		contentPane.add(comboBox);
		
		guardar = new JButton("Ascender y volver");
		guardar.setBounds(243, 320, 156, 21);
		contentPane.add(guardar);
		
		informacion = new JTable();
		informacion.setBounds(243, 142, 156, 84);
		contentPane.add(informacion);
		
		JLabel labelInfo = new JLabel("Informacion del usuarion:");
		labelInfo.setBounds(88, 143, 145, 13);
		contentPane.add(labelInfo);
		
		guardar.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object g = e.getSource();
		if(g==guardar) {
			Administrador volver = new Administrador();
			volver.setVisible(true);
			dispose();
		}
		
	}
}
