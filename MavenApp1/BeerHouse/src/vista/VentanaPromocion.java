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
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class VentanaPromocion extends JFrame implements IVista{

	private JPanel contentPane;
	private DefaultListModel modeloLista;
	private ActionListener actionListener;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JPanel panel_3;
	private JButton btnAtras;
	private JPanel panel_4;
	private JPanel panel_5;
	private JScrollPane scrollPane;
	private JList list;
	private JPanel panel_2;
	private JButton btnNuevaPromocion;
	private JPanel panel_6;
	private JLabel lblNewLabel_1;
	private JSpinner spinner;
	private JLabel lblNewLabel_2;
	private JTextField textField;
	private JLabel lblNewLabel_3;
	private JPanel panel_12;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxNewCheckBox_1;
	private JCheckBox chckbxNewCheckBox_2;
	private JCheckBox chckbxNewCheckBox_3;
	private JCheckBox chckbxNewCheckBox_4;
	private JCheckBox chckbxNewCheckBox_5;
	private JCheckBox chckbxNewCheckBox_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JLabel lblNewLabel_4;
	private JPanel panel_13;
	private JPanel panel_14;
	private JLabel lblNewLabel_5;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JPanel panel_15;
	private JPanel panel_16;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_3;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JSpinner spinner_1;
	private JSpinner spinner_2;
	private JPanel panel_17;
	private JPanel panel_18;
	private JPanel panel_19;
	private JPanel panel_20;
	private JPanel panel_21;
	private JPanel panel_22;
	private JRadioButton rdbtnNewRadioButton_4;
	private JRadioButton rdbtnNewRadioButton_5;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JPanel panel_23;
	private JPanel panel_24;
	private JButton btnNuevaPromocion_1;
	private JPanel panel_25;
	private JPanel panel_26;
	private JLabel lblNewLabel_9;
	private JPanel panel_27;
	private JPanel panel_28;
	private JLabel lblNewLabel_10;
	private JPanel panel_29;
	private JTextField textField_1;
	private JPanel panel_30;
	private JLabel lblNewLabel_11;
	private JPanel panel_31;
	private JCheckBox chckbxNewCheckBox_7;
	private JCheckBox chckbxNewCheckBox_8;
	private JCheckBox chckbxNewCheckBox_9;
	private JCheckBox chckbxNewCheckBox_10;
	private JCheckBox chckbxNewCheckBox_11;
	private JCheckBox chckbxNewCheckBox_12;
	private JCheckBox chckbxNewCheckBox_13;
	private JPanel panel_32;
	private JLabel lblNewLabel_12;
	private JPanel panel_33;
	private JRadioButton rdbtnNewRadioButton_6;
	private JRadioButton rdbtnNewRadioButton_7;
	private JPanel panel_36;
	private JLabel lblNewLabel_14;
	private JPanel panel_37;
	private JSpinner spinner_4;
	private JPanel panel_40;
	private JLabel lblNewLabel_16;
	private JPanel panel_41;
	private JRadioButton rdbtnNewRadioButton_10;
	private JRadioButton rdbtnNewRadioButton_11;
	private JTextField textField_2;

	public VentanaPromocion() {
		setTitle("Promociones");
		this.modeloLista = new DefaultListModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 392);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		panel_4 = new JPanel();
		tabbedPane.addTab("Lista de promociones", null, panel_4, null);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel_4.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		list = new JList();
		scrollPane.setViewportView(list);
		
		panel_1 = new JPanel();
		panel_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_4.add(panel_1, BorderLayout.NORTH);
		
		lblNewLabel = new JLabel("Promociones");
		lblNewLabel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		lblNewLabel.setBackground(SystemColor.activeCaption);
		panel_1.add(lblNewLabel);
		
		panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.inactiveCaption);
		panel_4.add(panel_3, BorderLayout.SOUTH);
		
		btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
		btnAtras.setBackground(SystemColor.textHighlight);
		panel_3.add(btnAtras);
		
		panel_5 = new JPanel();
		tabbedPane.addTab("Nueva promoci\u00F3n", null, panel_5, null);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_5.add(panel_2, BorderLayout.SOUTH);
		
		btnNuevaPromocion = new JButton("Nueva Promoci\u00F3n");
		btnNuevaPromocion.setForeground(Color.BLACK);
		btnNuevaPromocion.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
		btnNuevaPromocion.setBackground(SystemColor.textHighlight);
		btnNuevaPromocion.setActionCommand("AsignarMM");
		panel_2.add(btnNuevaPromocion);
		
		panel_6 = new JPanel();
		panel_5.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new GridLayout(8, 2, 0, 0));
		
		panel_7 = new JPanel();
		panel_6.add(panel_7);
		
		lblNewLabel_1 = new JLabel("ID");
		panel_7.add(lblNewLabel_1);
		
		panel_8 = new JPanel();
		panel_6.add(panel_8);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		panel_8.add(spinner);
		
		panel_9 = new JPanel();
		panel_6.add(panel_9);
		
		lblNewLabel_2 = new JLabel("Producto");
		panel_9.add(lblNewLabel_2);
		
		panel_10 = new JPanel();
		panel_6.add(panel_10);
		
		textField = new JTextField();
		panel_10.add(textField);
		textField.setColumns(10);
		
		panel_11 = new JPanel();
		panel_6.add(panel_11);
		
		lblNewLabel_3 = new JLabel("D\u00EDas de promo");
		panel_11.add(lblNewLabel_3);
		
		panel_12 = new JPanel();
		panel_6.add(panel_12);
		
		chckbxNewCheckBox = new JCheckBox("Lunes");
		panel_12.add(chckbxNewCheckBox);
		
		chckbxNewCheckBox_1 = new JCheckBox("Martes");
		panel_12.add(chckbxNewCheckBox_1);
		
		chckbxNewCheckBox_2 = new JCheckBox("Mi\u00E9rcoles");
		panel_12.add(chckbxNewCheckBox_2);
		
		chckbxNewCheckBox_3 = new JCheckBox("Jueves");
		panel_12.add(chckbxNewCheckBox_3);
		
		chckbxNewCheckBox_4 = new JCheckBox("Viernes");
		panel_12.add(chckbxNewCheckBox_4);
		
		chckbxNewCheckBox_5 = new JCheckBox("S\u00E1bado");
		panel_12.add(chckbxNewCheckBox_5);
		
		chckbxNewCheckBox_6 = new JCheckBox("Domingo");
		panel_12.add(chckbxNewCheckBox_6);
		
		panel_13 = new JPanel();
		panel_6.add(panel_13);
		
		lblNewLabel_4 = new JLabel("Aplica 2\u00D71");
		panel_13.add(lblNewLabel_4);
		
		panel_14 = new JPanel();
		panel_6.add(panel_14);
		
		rdbtnNewRadioButton = new JRadioButton("S\u00ED");
		buttonGroup.add(rdbtnNewRadioButton);
		panel_14.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("No");
		buttonGroup.add(rdbtnNewRadioButton_1);
		panel_14.add(rdbtnNewRadioButton_1);
		
		panel_15 = new JPanel();
		panel_6.add(panel_15);
		
		lblNewLabel_5 = new JLabel("Descuento por cantidad");
		panel_15.add(lblNewLabel_5);
		
		panel_16 = new JPanel();
		panel_6.add(panel_16);
		
		rdbtnNewRadioButton_2 = new JRadioButton("S\u00ED");
		buttonGroup_1.add(rdbtnNewRadioButton_2);
		panel_16.add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_3 = new JRadioButton("No");
		buttonGroup_1.add(rdbtnNewRadioButton_3);
		panel_16.add(rdbtnNewRadioButton_3);
		
		panel_17 = new JPanel();
		panel_6.add(panel_17);
		
		lblNewLabel_6 = new JLabel("Cantidad m\u00EDnima");
		panel_17.add(lblNewLabel_6);
		
		panel_18 = new JPanel();
		panel_6.add(panel_18);
		
		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		panel_18.add(spinner_1);
		
		panel_19 = new JPanel();
		panel_6.add(panel_19);
		
		lblNewLabel_7 = new JLabel("Precio unitario");
		panel_19.add(lblNewLabel_7);
		
		panel_20 = new JPanel();
		panel_6.add(panel_20);
		
		spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(Double.valueOf(0), Double.valueOf(0), null, Double.valueOf(1)));
		panel_20.add(spinner_2);
		
		panel_21 = new JPanel();
		panel_6.add(panel_21);
		
		lblNewLabel_8 = new JLabel("\u00BFActiva?");
		panel_21.add(lblNewLabel_8);
		
		panel_22 = new JPanel();
		panel_6.add(panel_22);
		
		rdbtnNewRadioButton_4 = new JRadioButton("S\u00ED");
		buttonGroup_2.add(rdbtnNewRadioButton_4);
		panel_22.add(rdbtnNewRadioButton_4);
		
		rdbtnNewRadioButton_5 = new JRadioButton("No");
		buttonGroup_2.add(rdbtnNewRadioButton_5);
		panel_22.add(rdbtnNewRadioButton_5);
		
		this.panel_23 = new JPanel();
		tabbedPane.addTab("Oferta Temporal", null, this.panel_23, null);
		this.panel_23.setLayout(new BorderLayout(0, 0));
		
		this.panel_24 = new JPanel();
		this.panel_24.setBackground(SystemColor.inactiveCaption);
		this.panel_23.add(this.panel_24, BorderLayout.SOUTH);
		
		this.btnNuevaPromocion_1 = new JButton("Nueva Promoci\u00F3n");
		this.btnNuevaPromocion_1.setForeground(Color.BLACK);
		this.btnNuevaPromocion_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
		this.btnNuevaPromocion_1.setBackground(SystemColor.textHighlight);
		this.btnNuevaPromocion_1.setActionCommand("AsignarMM");
		this.panel_24.add(this.btnNuevaPromocion_1);
		
		this.panel_25 = new JPanel();
		this.panel_23.add(this.panel_25, BorderLayout.CENTER);
		this.panel_25.setLayout(new GridLayout(6, 2, 0, 0));
		
		this.panel_26 = new JPanel();
		this.panel_25.add(this.panel_26);
		
		this.lblNewLabel_9 = new JLabel("Nombre");
		this.panel_26.add(this.lblNewLabel_9);
		
		this.panel_27 = new JPanel();
		this.panel_25.add(this.panel_27);
		
		this.textField_2 = new JTextField();
		this.textField_2.setColumns(10);
		this.panel_27.add(this.textField_2);
		
		this.panel_28 = new JPanel();
		this.panel_25.add(this.panel_28);
		
		this.lblNewLabel_10 = new JLabel("Forma de pago");
		this.panel_28.add(this.lblNewLabel_10);
		
		this.panel_29 = new JPanel();
		this.panel_25.add(this.panel_29);
		
		this.textField_1 = new JTextField();
		this.textField_1.setColumns(10);
		this.panel_29.add(this.textField_1);
		
		this.panel_30 = new JPanel();
		this.panel_25.add(this.panel_30);
		
		this.lblNewLabel_11 = new JLabel("Dias de promo");
		this.panel_30.add(this.lblNewLabel_11);
		
		this.panel_31 = new JPanel();
		this.panel_25.add(this.panel_31);
		
		this.chckbxNewCheckBox_7 = new JCheckBox("Lunes");
		this.panel_31.add(this.chckbxNewCheckBox_7);
		
		this.chckbxNewCheckBox_8 = new JCheckBox("Martes");
		this.panel_31.add(this.chckbxNewCheckBox_8);
		
		this.chckbxNewCheckBox_9 = new JCheckBox("Mi\u00E9rcoles");
		this.panel_31.add(this.chckbxNewCheckBox_9);
		
		this.chckbxNewCheckBox_10 = new JCheckBox("Jueves");
		this.panel_31.add(this.chckbxNewCheckBox_10);
		
		this.chckbxNewCheckBox_11 = new JCheckBox("Viernes");
		this.panel_31.add(this.chckbxNewCheckBox_11);
		
		this.chckbxNewCheckBox_12 = new JCheckBox("S\u00E1bado");
		this.panel_31.add(this.chckbxNewCheckBox_12);
		
		this.chckbxNewCheckBox_13 = new JCheckBox("Domingo");
		this.panel_31.add(this.chckbxNewCheckBox_13);
		
		this.panel_36 = new JPanel();
		this.panel_25.add(this.panel_36);
		
		this.lblNewLabel_14 = new JLabel("Porcentaje Descuento");
		this.panel_36.add(this.lblNewLabel_14);
		
		this.panel_37 = new JPanel();
		this.panel_25.add(this.panel_37);
		
		this.spinner_4 = new JSpinner();
		this.spinner_4.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		this.panel_37.add(this.spinner_4);
		
		this.panel_32 = new JPanel();
		this.panel_25.add(this.panel_32);
		
		this.lblNewLabel_12 = new JLabel("Es acumulable");
		this.panel_32.add(this.lblNewLabel_12);
		
		this.panel_33 = new JPanel();
		this.panel_25.add(this.panel_33);
		
		this.rdbtnNewRadioButton_6 = new JRadioButton("S\u00ED");
		this.panel_33.add(this.rdbtnNewRadioButton_6);
		
		this.rdbtnNewRadioButton_7 = new JRadioButton("No");
		this.panel_33.add(this.rdbtnNewRadioButton_7);
		
		this.panel_40 = new JPanel();
		this.panel_25.add(this.panel_40);
		
		this.lblNewLabel_16 = new JLabel("\u00BFActiva?");
		this.panel_40.add(this.lblNewLabel_16);
		
		this.panel_41 = new JPanel();
		this.panel_25.add(this.panel_41);
		
		this.rdbtnNewRadioButton_10 = new JRadioButton("S\u00ED");
		this.panel_41.add(this.rdbtnNewRadioButton_10);
		
		this.rdbtnNewRadioButton_11 = new JRadioButton("No");
		this.panel_41.add(this.rdbtnNewRadioButton_11);
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
		this.btnNuevaPromocion.addActionListener(actionListener);
		this.btnAtras.addActionListener(actionListener);
		this.actionListener=actionListener;	
	}

	public DefaultListModel getModeloLista() {
		return modeloLista;
	}

	public JList getList() {
		return list;
	}

	public JButton getBtnNuevaPromocion() {
		return btnNuevaPromocion;
	}

	public JPanel getPanel_3() {
		return panel_3;
	}

}
