package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class VentanaPersistir extends JFrame implements IVista {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnPersistir;
	private JButton btnLeerPersistencia;
	private ActionListener actionListener;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPersistir frame = new VentanaPersistir();
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
	public VentanaPersistir() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) this.panel.getLayout();
		this.contentPane.add(this.panel);
		
		this.btnPersistir = new JButton("Persistir");
		this.panel.add(this.btnPersistir);
		
		this.panel_1 = new JPanel();
		this.contentPane.add(this.panel_1);
		
		this.btnLeerPersistencia = new JButton("LeerPersistencia");
		this.panel_1.add(this.btnLeerPersistencia);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btnLeerPersistencia.addActionListener(actionListener);
		this.btnPersistir.addActionListener(actionListener);
		this.actionListener=actionListener;
	}

	@Override
	public void cerrar() {
		this.dispose();
	}

	@Override
	public void mostrar() {
		this.setVisible(true);
		
	}

}
