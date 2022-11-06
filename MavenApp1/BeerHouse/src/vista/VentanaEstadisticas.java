package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

import javax.swing.border.MatteBorder;
import java.awt.Font;

public class VentanaEstadisticas extends JFrame implements IVista {

	private JPanel contentPane;
	private JPanel panelListas;
	private JPanel panelEmpleadoVentas;
	private JPanel panelBotones;
	private JPanel panelMasVentas;
	private JPanel panelMenosVentas;
	private JLabel lblMasVentas;
	private JLabel lblMenosVentas;
	private JPanel panelListaEmpleados;
	private JPanel panelListaMesas;
	private JScrollPane scrollPane;
	private JList listaEmpleados;
	private JPanel panelAuxNorte;
	private JPanel panelAuxSur;
	private JPanel panelAuxOeste;
	private JPanel panelAuxEste;
	private JScrollPane scrollPane_1;
	private JList listaMesas;
	private DefaultListModel modeloListaEmpleados;
	private DefaultListModel modeloListaMesas;
	private JPanel panelAuxNorte1;
	private JPanel panelAuxSur1;
	private JPanel panelAuxOeste1;
	private JPanel panelAuxEste1;
	private JLabel lblListaEmpleados;
	private JLabel lblListaMesas;
	private JPanel panelBtnEmpleados;
	private JPanel panelBtnMesas;
	private JButton btnEmpleado;
	private JButton btnMesa;
	private ActionListener actionListener;

	public VentanaEstadisticas() {
		setTitle("Estadísticas");
		this.modeloListaEmpleados = new DefaultListModel();
		this.modeloListaMesas = new DefaultListModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
		
		this.panelListas = new JPanel();
		this.panelListas.setBackground(SystemColor.inactiveCaption);
		this.panelListas.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		this.contentPane.add(this.panelListas, BorderLayout.CENTER);
		this.panelListas.setLayout(new GridLayout(1, 2, 0, 0));
		
		this.panelListaEmpleados = new JPanel();
		this.panelListaEmpleados.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		this.panelListas.add(this.panelListaEmpleados);
		this.panelListaEmpleados.setLayout(new BorderLayout(0, 0));
		
		this.scrollPane = new JScrollPane();
		this.panelListaEmpleados.add(this.scrollPane, BorderLayout.CENTER);
		
		this.listaEmpleados = new JList();
		this.listaEmpleados.setModel(modeloListaEmpleados);
		this.scrollPane.setViewportView(this.listaEmpleados);
		
		this.panelAuxNorte = new JPanel();
		this.panelAuxNorte.setBackground(SystemColor.inactiveCaption);
		this.panelListaEmpleados.add(this.panelAuxNorte, BorderLayout.NORTH);
		this.panelAuxNorte.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.lblListaEmpleados = new JLabel("Empleados:");
		this.lblListaEmpleados.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 11));
		this.panelAuxNorte.add(this.lblListaEmpleados);
		
		this.panelAuxSur = new JPanel();
		this.panelAuxSur.setBackground(SystemColor.inactiveCaption);
		this.panelListaEmpleados.add(this.panelAuxSur, BorderLayout.SOUTH);
		
		this.panelAuxOeste = new JPanel();
		this.panelAuxOeste.setBackground(SystemColor.inactiveCaption);
		this.panelListaEmpleados.add(this.panelAuxOeste, BorderLayout.WEST);
		
		this.panelAuxEste = new JPanel();
		this.panelAuxEste.setBackground(SystemColor.inactiveCaption);
		this.panelListaEmpleados.add(this.panelAuxEste, BorderLayout.EAST);
		
		this.panelListaMesas = new JPanel();
		this.panelListas.add(this.panelListaMesas);
		this.panelListaMesas.setLayout(new BorderLayout(0, 0));
		
		this.scrollPane_1 = new JScrollPane();
		this.panelListaMesas.add(this.scrollPane_1, BorderLayout.CENTER);
		
		this.listaMesas = new JList();
		this.listaMesas.setModel(modeloListaMesas);
		this.scrollPane_1.setViewportView(this.listaMesas);
		
		this.panelAuxNorte1 = new JPanel();
		this.panelAuxNorte1.setBackground(SystemColor.inactiveCaption);
		this.panelListaMesas.add(this.panelAuxNorte1, BorderLayout.NORTH);
		
		this.lblListaMesas = new JLabel("Mesas:");
		this.lblListaMesas.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 11));
		this.panelAuxNorte1.add(this.lblListaMesas);
		
		this.panelAuxSur1 = new JPanel();
		this.panelAuxSur1.setBackground(SystemColor.inactiveCaption);
		this.panelListaMesas.add(this.panelAuxSur1, BorderLayout.SOUTH);
		
		this.panelAuxOeste1 = new JPanel();
		this.panelAuxOeste1.setBackground(SystemColor.inactiveCaption);
		this.panelListaMesas.add(this.panelAuxOeste1, BorderLayout.WEST);
		
		this.panelAuxEste1 = new JPanel();
		this.panelAuxEste1.setBackground(SystemColor.inactiveCaption);
		this.panelListaMesas.add(this.panelAuxEste1, BorderLayout.EAST);
		
		this.panelEmpleadoVentas = new JPanel();
		this.panelEmpleadoVentas.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		this.contentPane.add(this.panelEmpleadoVentas, BorderLayout.NORTH);
		this.panelEmpleadoVentas.setLayout(new GridLayout(1, 2, 0, 0));
		
		this.panelMasVentas = new JPanel();
		this.panelMasVentas.setBackground(SystemColor.activeCaption);
		this.panelEmpleadoVentas.add(this.panelMasVentas);
		
		this.lblMasVentas = new JLabel("Empleado con mayor volumen de ventas:");
		this.lblMasVentas.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 11));
		this.panelMasVentas.add(this.lblMasVentas);
		
		this.panelMenosVentas = new JPanel();
		this.panelMenosVentas.setBackground(SystemColor.activeCaption);
		this.panelEmpleadoVentas.add(this.panelMenosVentas);
		
		this.lblMenosVentas = new JLabel("Empleado con menor volumen de ventas:");
		this.lblMenosVentas.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 11));
		this.panelMenosVentas.add(this.lblMenosVentas);
		
		this.panelBotones = new JPanel();
		this.panelBotones.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		this.contentPane.add(this.panelBotones, BorderLayout.SOUTH);
		this.panelBotones.setLayout(new GridLayout(1, 2, 0, 0));
		
		this.panelBtnEmpleados = new JPanel();
		this.panelBtnEmpleados.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		this.panelBtnEmpleados.setBackground(SystemColor.inactiveCaption);
		this.panelBotones.add(this.panelBtnEmpleados);
		
		this.btnEmpleado = new JButton("Ver empleado");
		this.btnEmpleado.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
		this.btnEmpleado.setBackground(SystemColor.textHighlight);
		this.panelBtnEmpleados.add(this.btnEmpleado);
		
		this.panelBtnMesas = new JPanel();
		this.panelBtnMesas.setBackground(SystemColor.inactiveCaption);
		this.panelBotones.add(this.panelBtnMesas);
		
		this.btnMesa = new JButton("Ver Mesa");
		this.btnMesa.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
		this.btnMesa.setBackground(SystemColor.textHighlight);
		this.panelBtnMesas.add(this.btnMesa);
	}

	@Override
	public void cerrar() {
		this.dispose();
	}

	@Override
	public void mostrar() {
		this.setVisible(true);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btnEmpleado.addActionListener(actionListener);
		this.btnMesa.addActionListener(actionListener);
		this.setActionListener(actionListener);	
	}

	public DefaultListModel getModeloListaEmpleados() {
		return modeloListaEmpleados;
	}

	public DefaultListModel getModeloListaMesas() {
		return modeloListaMesas;
	}
	
	

}
