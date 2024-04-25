package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class Crear extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton guardar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crear frame = new Crear();
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
	public Crear() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(249, 53, 134, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Introduce la nueva partida:");
		lblNewLabel.setBounds(49, 56, 154, 13);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(218, 123, 107, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Elije el mapa:");
		lblNewLabel_1.setBounds(49, 127, 86, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Elije el dia de partida:");
		lblNewLabel_2.setBounds(49, 213, 122, 13);
		contentPane.add(lblNewLabel_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(223, 213, 102, 19);
		contentPane.add(dateChooser);
		
		guardar = new JButton("Guardar y volver");
		guardar.setBounds(251, 309, 132, 21);
		contentPane.add(guardar);
		
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
