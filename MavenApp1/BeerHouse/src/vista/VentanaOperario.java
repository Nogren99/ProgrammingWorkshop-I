package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaOperario extends JFrame implements IVistaOperario
{

	private JPanel contentPane;
	private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
	private JButton asignarMMButton;
	private JButton asignarComandaButton;
	private JButton cierreMesaButton;
	private ActionListener actionListener;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					VentanaOperario frame = new VentanaOperario();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaOperario()
	{
		setTitle("Operario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(new Color(90, 173, 221));
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new GridLayout(3, 0, 0, 0));
		
		this.panel = new JPanel();
		this.panel.setBackground(new Color(90, 173, 221));
		this.contentPane.add(this.panel);
		
		this.asignarMMButton = new JButton("Asignar mesa - mozo");
		this.asignarMMButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.asignarMMButton.setToolTipText("Asignar mesa - mozo");
		this.panel.add(this.asignarMMButton);
		
		this.panel_1 = new JPanel();
		this.panel_1.setBackground(new Color(90, 173, 221));
		this.contentPane.add(this.panel_1);
		
		this.asignarComandaButton = new JButton("Asignar comanda a mesa");
		this.asignarComandaButton.setToolTipText("Asignar comanda a mesa");
		this.asignarComandaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.panel_1.add(this.asignarComandaButton);
		
		this.panel_2 = new JPanel();
		this.panel_2.setBackground(new Color(90, 173, 221));
		this.contentPane.add(this.panel_2);
		
		this.cierreMesaButton = new JButton("Cerrar mesa");
		this.cierreMesaButton.setToolTipText("Cerrar mesa");
		this.cierreMesaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.panel_2.add(this.cierreMesaButton);
	}
	
	@Override
	public void cerrar()
	{
		this.dispose();
	}

	@Override
	public void mostrar()
	{
		this.setVisible(true);
	}

	@Override
	public void setActionListener(ActionListener actionListener)
	{
		this.actionListener = actionListener;
	}
}
