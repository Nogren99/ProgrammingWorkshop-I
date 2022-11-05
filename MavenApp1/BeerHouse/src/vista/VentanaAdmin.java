package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VentanaAdmin extends JFrame implements IVistaAdmin
{

	private JPanel contentPane;
	private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_3;
    private JPanel panel_4;
    private JPanel panel_5;
	private JButton operariosButton;
	private JButton mozosButton;
	private JButton mesasButton;
	private JButton productosEnVentaButton;
	private JButton estadisticasButton;
	private JButton promocionesButton;
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
					VentanaAdmin frame = new VentanaAdmin();
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
	public VentanaAdmin()
	{
		setBackground(new Color(0, 114, 114));
		setTitle("Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 114, 114));
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new GridLayout(6, 0, 0, 0));
		
		this.panel = new JPanel();
		this.panel.setBackground(new Color(0, 114, 114));
		this.contentPane.add(this.panel);
		
		this.operariosButton = new JButton("Operarios");
		operariosButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.operariosButton.setToolTipText("Operarios");
		panel.add(this.operariosButton);
		
		this.panel_1 = new JPanel();
		this.panel_1.setBackground(new Color(0, 114, 114));
		this.contentPane.add(this.panel_1);
		
		this.mozosButton = new JButton("Mozos");
		this.mozosButton.setToolTipText("Mozos");
		this.mozosButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.panel_1.add(this.mozosButton);
		
		this.panel_2 = new JPanel();
		this.panel_2.setBackground(new Color(0, 114, 114));
		this.contentPane.add(this.panel_2);
		
		this.mesasButton = new JButton("Mesas");
		this.mesasButton.setToolTipText("Mesas");
		this.mesasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.panel_2.add(this.mesasButton);
		
		this.panel_3 = new JPanel();
		this.panel_3.setBackground(new Color(0, 114, 114));
		this.contentPane.add(this.panel_3);
		
		this.productosEnVentaButton = new JButton("Productos en venta");
		this.productosEnVentaButton.setToolTipText("Productos en venta");
		this.productosEnVentaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.panel_3.add(this.productosEnVentaButton);
		
		this.panel_4 = new JPanel();
		this.panel_4.setBackground(new Color(0, 114, 114));
		this.contentPane.add(this.panel_4);
		
		this.estadisticasButton = new JButton("Estad\u00edsticas");
		this.estadisticasButton.setToolTipText("Estad\u00EDsticas");
		this.estadisticasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.panel_4.add(this.estadisticasButton);
		
		this.panel_5 = new JPanel();
		this.panel_5.setBackground(new Color(0, 114, 114));
		this.contentPane.add(this.panel_5);
		
		this.promocionesButton = new JButton("Promociones");
		this.promocionesButton.setToolTipText("Promociones");
		this.promocionesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.panel_5.add(this.promocionesButton);
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
