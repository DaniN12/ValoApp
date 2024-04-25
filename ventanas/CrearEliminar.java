package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class CrearEliminar extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton crear, eliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearEliminar frame = new CrearEliminar();
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
	public CrearEliminar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		crear = new JButton("Crear Partida");
		crear.setBounds(55, 118, 117, 41);
		contentPane.add(crear);
		
		eliminar = new JButton("Eliminar Partida");
		eliminar.setBounds(239, 118, 137, 41);
		contentPane.add(eliminar);
		
		crear.addActionListener(this);
		eliminar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object c = e.getSource();
		Object el = e.getSource();
		if(c==crear) {
			Crear crea = new Crear();
			crea.setVisible(true);
			dispose();
		}
		if(el==eliminar) {
			Eliminar elimina = new Eliminar();
			elimina.setVisible(true);
			dispose();
		}
		
	}
}
