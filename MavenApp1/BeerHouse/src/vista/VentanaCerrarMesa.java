package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.Font;

public class VentanaCerrarMesa extends JFrame implements IVista{

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JScrollPane scrollPane;
	private JList list;
	private ActionListener actionListener;
	private DefaultListModel modeloLista;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	public VentanaCerrarMesa() {
		modeloLista = new DefaultListModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
		
		this.panel = new JPanel();
		this.panel.setBackground(SystemColor.inactiveCaption);
		this.contentPane.add(this.panel, BorderLayout.NORTH);
		
		this.panel_1 = new JPanel();
		this.panel_1.setBackground(SystemColor.inactiveCaption);
		this.contentPane.add(this.panel_1, BorderLayout.SOUTH);
		
		this.btnNewButton = new JButton("Cerrar Mesa");
		this.btnNewButton.setActionCommand("CerrarMesaSeleccionada");
		this.btnNewButton.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
		this.btnNewButton.setBackground(SystemColor.textHighlight);
		this.panel_1.add(this.btnNewButton);
		
		this.btnNewButton_1 = new JButton("Atr\u00E1s");
		this.btnNewButton_1.setBackground(SystemColor.textHighlight);
		this.btnNewButton_1.setForeground(SystemColor.desktop);
		this.btnNewButton_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
		this.btnNewButton_1.setActionCommand("Atras");
		this.panel_1.add(this.btnNewButton_1);
		
		this.panel_2 = new JPanel();
		this.panel_2.setBackground(SystemColor.inactiveCaption);
		this.contentPane.add(this.panel_2, BorderLayout.WEST);
		
		this.panel_3 = new JPanel();
		this.panel_3.setBackground(SystemColor.inactiveCaption);
		this.contentPane.add(this.panel_3, BorderLayout.EAST);
		
		this.panel_4 = new JPanel();
		this.contentPane.add(this.panel_4, BorderLayout.CENTER);
		this.panel_4.setLayout(new BorderLayout(0, 0));
		
		this.scrollPane = new JScrollPane();
		this.panel_4.add(this.scrollPane);
		
		this.list = new JList();
		this.list.setModel(modeloLista);
		this.scrollPane.setViewportView(this.list);
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
		this.btnNewButton.addActionListener(actionListener);
		this.btnNewButton_1.addActionListener(actionListener);
		this.actionListener=actionListener;
	}

	public JList getList() {
		return list;
	}

	public DefaultListModel getModeloLista() {
		return modeloLista;
	}
	
	

}
