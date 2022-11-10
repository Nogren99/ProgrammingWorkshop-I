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
import java.awt.SystemColor;

public class VentanaAdmin extends JFrame implements IVista, ActionListener
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
	private JButton btnDesloguearse;

	
	public VentanaAdmin()
	{
		setBackground(new Color(0, 114, 114));
		setTitle("Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new GridLayout(6, 0, 0, 0));
		
		this.panel = new JPanel();
		this.panel.setBackground(SystemColor.inactiveCaption);
		this.contentPane.add(this.panel);
		
		this.operariosButton = new JButton("Operarios");
		this.operariosButton.setToolTipText("Operarios");
		panel.add(this.operariosButton);
		
		this.panel_1 = new JPanel();
		this.panel_1.setBackground(SystemColor.inactiveCaption);
		this.contentPane.add(this.panel_1);
		
		this.mozosButton = new JButton("Mozos");
		this.mozosButton.setToolTipText("Mozos");
		this.panel_1.add(this.mozosButton);
		
		this.panel_2 = new JPanel();
		this.panel_2.setBackground(SystemColor.inactiveCaption);
		this.contentPane.add(this.panel_2);
		
		this.mesasButton = new JButton("Mesas");
		this.mesasButton.setToolTipText("Mesas");
		this.panel_2.add(this.mesasButton);
		
		this.panel_3 = new JPanel();
		this.panel_3.setBackground(SystemColor.inactiveCaption);
		this.contentPane.add(this.panel_3);
		
		this.productosEnVentaButton = new JButton("Productos en venta");
		productosEnVentaButton.setActionCommand("Productos");
		this.productosEnVentaButton.setToolTipText("Productos en venta");
		this.panel_3.add(this.productosEnVentaButton);
		
		this.panel_4 = new JPanel();
		this.panel_4.setBackground(SystemColor.inactiveCaption);
		this.contentPane.add(this.panel_4);
		
		this.estadisticasButton = new JButton("Estad\u00edsticas");
		this.estadisticasButton.setToolTipText("Estad\u00EDsticas");
		this.panel_4.add(this.estadisticasButton);
		
		this.panel_5 = new JPanel();
		this.panel_5.setBackground(SystemColor.inactiveCaption);
		this.contentPane.add(this.panel_5);
		
		this.promocionesButton = new JButton("Promociones");
		this.promocionesButton.setToolTipText("Promociones");
		this.panel_5.add(this.promocionesButton);
		
		this.btnDesloguearse = new JButton("Desloguearse");
		this.btnDesloguearse.addActionListener(this);
		this.panel_5.add(this.btnDesloguearse);
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
		this.estadisticasButton.addActionListener(actionListener);
		this.mesasButton.addActionListener(actionListener);
		this.mozosButton.addActionListener(actionListener);
		this.operariosButton.addActionListener(actionListener);
		this.productosEnVentaButton.addActionListener(actionListener);
		this.promocionesButton.addActionListener(actionListener);
		this.btnDesloguearse.addActionListener(actionListener);
		this.actionListener = actionListener;
	}

	public void actionPerformed(ActionEvent e) {
	}
}
