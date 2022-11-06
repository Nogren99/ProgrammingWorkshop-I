package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import java.awt.ComponentOrientation;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.Font;

public class VentanaAsignacion extends JFrame implements IVista{

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JScrollPane scrollPane;
	private JList list;
	private DefaultListModel modeloLista;
	private JLabel lblNewLabel;
	private JPanel panel_4;
	private JSpinner spinner;
	private JPanel panel_5;
	private JPanel panel_6;
	private JButton btnSalir;
	private JButton btnAsignar;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panel_13;
	private JPanel panel_14;
	private ActionListener actionListener;
	private JPanel panel_15;
	private JPanel panel_16;
	private JPanel panel_17;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	public VentanaAsignacion() {
		setTitle("Asignación");
		this.modeloLista = new DefaultListModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
		
		this.panel = new JPanel();
		this.contentPane.add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(new BorderLayout(0, 0));
		
		this.scrollPane = new JScrollPane();
		this.panel.add(this.scrollPane, BorderLayout.CENTER);
		
		this.list = new JList();
		this.list.setModel(modeloLista);
		this.scrollPane.setViewportView(this.list);
		
		this.panel_11 = new JPanel();
		this.panel_11.setBackground(SystemColor.inactiveCaption);
		this.panel.add(this.panel_11, BorderLayout.NORTH);
		
		this.lblNewLabel_2 = new JLabel("Mozo:");
		this.lblNewLabel_2.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 11));
		this.panel_11.add(this.lblNewLabel_2);
		
		this.panel_12 = new JPanel();
		this.panel_12.setBackground(SystemColor.inactiveCaption);
		this.panel.add(this.panel_12, BorderLayout.SOUTH);
		
		this.panel_13 = new JPanel();
		this.panel_13.setBackground(SystemColor.inactiveCaption);
		this.panel.add(this.panel_13, BorderLayout.WEST);
		
		this.panel_14 = new JPanel();
		this.panel_14.setBackground(SystemColor.inactiveCaption);
		this.panel.add(this.panel_14, BorderLayout.EAST);
		
		this.panel_1 = new JPanel();
		this.panel_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		this.panel_1.setBackground(SystemColor.activeCaption);
		this.contentPane.add(this.panel_1, BorderLayout.NORTH);
		
		this.lblNewLabel = new JLabel("Asignaciones Mesa-Mozo");
		this.lblNewLabel.setBackground(SystemColor.activeCaption);
		this.lblNewLabel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		this.panel_1.add(this.lblNewLabel);
		
		this.panel_2 = new JPanel();
		this.contentPane.add(this.panel_2, BorderLayout.EAST);
		this.panel_2.setLayout(new GridLayout(3, 1, 0, 0));
		
		this.panel_4 = new JPanel();
		this.panel_4.setBackground(SystemColor.inactiveCaption);
		this.panel_2.add(this.panel_4);
		this.panel_4.setLayout(new GridLayout(3, 0, 0, 0));
		
		this.panel_15 = new JPanel();
		this.panel_15.setBackground(SystemColor.inactiveCaption);
		this.panel_4.add(this.panel_15);
		
		this.panel_16 = new JPanel();
		this.panel_16.setBackground(SystemColor.inactiveCaption);
		this.panel_4.add(this.panel_16);
		
		this.lblNewLabel_1 = new JLabel("Mesa:");
		this.lblNewLabel_1.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 11));
		this.panel_16.add(this.lblNewLabel_1);
		
		this.panel_17 = new JPanel();
		this.panel_17.setBackground(SystemColor.inactiveCaption);
		this.panel_4.add(this.panel_17);
		
		this.panel_6 = new JPanel();
		this.panel_6.setBackground(SystemColor.inactiveCaption);
		this.panel_2.add(this.panel_6);
		this.panel_6.setLayout(new BorderLayout(0, 0));
		
		this.spinner = new JSpinner();
		this.spinner.setBackground(SystemColor.activeCaption);
		this.panel_6.add(this.spinner);
		
		this.panel_7 = new JPanel();
		this.panel_7.setBackground(SystemColor.inactiveCaption);
		FlowLayout flowLayout = (FlowLayout) this.panel_7.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		this.panel_6.add(this.panel_7, BorderLayout.WEST);
		
		this.panel_8 = new JPanel();
		this.panel_8.setBackground(SystemColor.inactiveCaption);
		FlowLayout flowLayout_1 = (FlowLayout) this.panel_8.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		this.panel_6.add(this.panel_8, BorderLayout.EAST);
		
		this.panel_9 = new JPanel();
		this.panel_9.setBackground(SystemColor.inactiveCaption);
		this.panel_6.add(this.panel_9, BorderLayout.NORTH);
		
		this.panel_10 = new JPanel();
		this.panel_10.setBackground(SystemColor.inactiveCaption);
		this.panel_6.add(this.panel_10, BorderLayout.SOUTH);
		
		this.panel_5 = new JPanel();
		this.panel_5.setBackground(SystemColor.inactiveCaption);
		this.panel_2.add(this.panel_5);
		
		this.panel_3 = new JPanel();
		this.panel_3.setBackground(SystemColor.inactiveCaption);
		this.contentPane.add(this.panel_3, BorderLayout.SOUTH);
		
		this.btnAsignar = new JButton("Asignar");
		this.btnAsignar.setBackground(SystemColor.textHighlight);
		this.btnAsignar.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
		this.btnAsignar.setForeground(SystemColor.desktop);
		this.panel_3.add(btnAsignar);
		
		this.btnSalir = new JButton("Salir");
		this.btnSalir.setBackground(SystemColor.textHighlight);
		this.btnSalir.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
		this.panel_3.add(this.btnSalir);
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
		this.btnAsignar.addActionListener(actionListener);
		this.btnSalir.addActionListener(actionListener);
		this.actionListener=actionListener;	
	}

	public DefaultListModel getModeloLista() {
		return modeloLista;
	}
	
	

}
