package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;

public class VentanaCerrarMesa extends JFrame implements IVista{

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private DefaultListModel modeloLista;
	private JButton btnSalir;
	private ActionListener actionListener;
	private JButton btnCerrar;
	private JLabel lblNewLabel;
	private JSpinner spinner;
	private JLabel lblNewLabel_1;
	private JSpinner spinner_1;
	private JLabel lblNewLabel_2;
	private JScrollPane scrollPane;
	private JList list;
	private JLabel lblNewLabel_3;
	private JTextField textField;
	private JLabel lblNewLabel_4;
	private JSpinner spinner_2;
	private JLabel lblNewLabel_5;
	private JScrollPane scrollPane_1;
	private JList list_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panel_13;

	public VentanaCerrarMesa() {
		setTitle("Cerrar mesa");
		this.modeloLista = new DefaultListModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
		
		this.panel = new JPanel();
		this.contentPane.add(this.panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(6, 2, 0, 0));
		
		panel_2 = new JPanel();
		panel.add(panel_2);
		
		lblNewLabel = new JLabel("Fecha");
		panel_2.add(lblNewLabel);
		
		panel_3 = new JPanel();
		panel.add(panel_3);
		
		spinner = new JSpinner();
		panel_3.add(spinner);
		spinner.setModel(new SpinnerDateModel(new Date(1668222000000L), null, null, Calendar.DAY_OF_YEAR));
		
		panel_4 = new JPanel();
		panel.add(panel_4);
		
		lblNewLabel_1 = new JLabel("Mesa");
		panel_4.add(lblNewLabel_1);
		
		panel_5 = new JPanel();
		panel.add(panel_5);
		
		spinner_1 = new JSpinner();
		panel_5.add(spinner_1);
		spinner_1.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		
		panel_6 = new JPanel();
		panel.add(panel_6);
		
		lblNewLabel_2 = new JLabel("Productos");
		panel_6.add(lblNewLabel_2);
		
		panel_7 = new JPanel();
		panel.add(panel_7);
		
		scrollPane = new JScrollPane();
		panel_7.add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		
		panel_8 = new JPanel();
		panel.add(panel_8);
		
		lblNewLabel_3 = new JLabel("Total: $");
		panel_8.add(lblNewLabel_3);
		
		panel_9 = new JPanel();
		panel.add(panel_9);
		
		spinner_2 = new JSpinner();
		panel_9.add(spinner_2);
		spinner_2.setModel(new SpinnerNumberModel(Double.valueOf(0), Double.valueOf(0), null, Double.valueOf(1)));
		
		panel_10 = new JPanel();
		panel.add(panel_10);
		
		lblNewLabel_4 = new JLabel("Forma de pago");
		panel_10.add(lblNewLabel_4);
		
		panel_11 = new JPanel();
		panel.add(panel_11);
		
		textField = new JTextField();
		panel_11.add(textField);
		textField.setColumns(10);
		
		panel_12 = new JPanel();
		panel.add(panel_12);
		
		lblNewLabel_5 = new JLabel("Promociones aplicadas");
		panel_12.add(lblNewLabel_5);
		
		panel_13 = new JPanel();
		panel.add(panel_13);
		
		scrollPane_1 = new JScrollPane();
		panel_13.add(scrollPane_1);
		
		list_1 = new JList();
		scrollPane_1.setViewportView(list_1);
		
		this.panel_1 = new JPanel();
		this.panel_1.setBackground(SystemColor.inactiveCaption);
		this.contentPane.add(this.panel_1, BorderLayout.SOUTH);
		
		this.btnCerrar = new JButton("Cerrar mesa");
		this.btnCerrar.setActionCommand("Cerrar");
		this.btnCerrar.setBackground(SystemColor.textHighlight);
		this.btnCerrar.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
		this.panel_1.add(this.btnCerrar);
		
		this.btnSalir = new JButton("Salir");
		this.btnSalir.setBackground(SystemColor.textHighlight);
		this.btnSalir.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
		this.panel_1.add(this.btnSalir);
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
		this.btnCerrar.addActionListener(actionListener);
		this.btnSalir.addActionListener(actionListener);
		this.actionListener=actionListener;	
	}

	public DefaultListModel getModeloLista() {
		return modeloLista;
	}

	public JList getList() {
		return list;
	}
	
	public JList getList_1() {
		return list_1;
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public JSpinner getSpinner_1() {
		return spinner_1;
	}
	
	public JSpinner getSpinner_2() {
		return spinner_2;
	}
	
}
