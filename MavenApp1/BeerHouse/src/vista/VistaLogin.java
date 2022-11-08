package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Dimension;

import javax.swing.border.TitledBorder;

import java.awt.Insets;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;

public class VistaLogin extends JFrame implements IVista, KeyListener {

    private JPanel contentPane;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_3;
    private JPanel panel_4;
    private JPanel panel_5;
    private JPanel panel_6;
    private JPanel panel_7;
    private JPanel panel_8;
    private JPanel panel_9;
    private JPanel panel_10;
    private JButton btnNewButton;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private ActionListener actionListener;
    private JPanel panel_11;
    private JPanel panel_12;
    private JLabel lblNewLabel_2;
    private JPanel panel_13;
    private JPanel panel_14;
    private JTextField textField;
    private JPanel panel_16;
    private JPanel panel_15;
    private JPanel panel_17;
    private JPanel panel_18;
    private JLabel lblNewLabel_3;
    private JPanel panel_19;
    private JPanel panel_20;
    private JPasswordField passwordField;
    private JPanel panel_21;
    private JPanel panel_22;
    private JPanel panel_23;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VistaLogin frame = new VistaLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public VistaLogin() {
    	setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(this.contentPane);
        this.contentPane.setLayout(new BorderLayout(0, 0));

        this.panel = new JPanel();
        this.panel.setBorder(new LineBorder(SystemColor.inactiveCaption));
        this.contentPane.add(this.panel, BorderLayout.CENTER);
        this.panel.setLayout(new GridLayout(2, 1, 0, 0));

        this.panel_2 = new JPanel();
        this.panel.add(this.panel_2);
        this.panel_2.setLayout(new GridLayout(0, 1, 0, 0));

        this.panel_10 = new JPanel();
        this.panel_10.setBorder(new LineBorder(SystemColor.inactiveCaption));
        this.panel_2.add(this.panel_10);
        this.panel_10.setLayout(new GridLayout(0, 2, 0, 0));

        this.panel_7 = new JPanel();
        this.panel_10.add(this.panel_7);
        this.panel_7.setLayout(new GridLayout(3, 1, 0, 0));
        
        this.panel_11 = new JPanel();
        this.panel_11.setBackground(SystemColor.inactiveCaption);
        this.panel_7.add(this.panel_11);
        
        this.panel_12 = new JPanel();
        this.panel_12.setBackground(SystemColor.inactiveCaption);
        this.panel_7.add(this.panel_12);
        
        this.lblNewLabel_2 = new JLabel("Nombre de Usuario:");
        this.lblNewLabel_2.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 11));
        this.panel_12.add(this.lblNewLabel_2);
        
        this.panel_23 = new JPanel();
        this.panel_23.setBackground(SystemColor.inactiveCaption);
        this.panel_7.add(this.panel_23);

        this.panel_5 = new JPanel();
        this.panel_5.setBackground(SystemColor.inactiveCaption);
        this.panel_5.setBorder(null);
        this.panel_10.add(this.panel_5);
        this.panel_5.setLayout(new GridLayout(3, 1, 0, 0));
        
        this.panel_13 = new JPanel();
        this.panel_13.setBackground(SystemColor.inactiveCaption);
        this.panel_5.add(this.panel_13);
        
        this.panel_14 = new JPanel();
        this.panel_5.add(this.panel_14);
        this.panel_14.setLayout(new BorderLayout(0, 0));
        
        this.textField = new JTextField();
        this.panel_14.add(this.textField, BorderLayout.CENTER);
        this.textField.setColumns(10);
        
        this.panel_16 = new JPanel();
        this.panel_16.setBackground(SystemColor.inactiveCaption);
        this.panel_14.add(this.panel_16, BorderLayout.EAST);
        
        this.panel_15 = new JPanel();
        this.panel_15.setBackground(SystemColor.inactiveCaption);
        this.panel_14.add(this.panel_15, BorderLayout.WEST);

        this.panel_3 = new JPanel();
        this.panel_3.setBorder(new LineBorder(SystemColor.inactiveCaption));
        this.panel.add(this.panel_3);
        this.panel_3.setLayout(new GridLayout(0, 2, 0, 0));

        this.panel_6 = new JPanel();
        this.panel_6.setBackground(SystemColor.inactiveCaption);
        this.panel_3.add(this.panel_6);
        this.panel_6.setLayout(new GridLayout(3, 1, 0, 0));
        
        this.panel_17 = new JPanel();
        this.panel_17.setBackground(SystemColor.inactiveCaption);
        this.panel_6.add(this.panel_17);
        
        this.panel_18 = new JPanel();
        this.panel_18.setBackground(SystemColor.inactiveCaption);
        this.panel_6.add(this.panel_18);
        this.panel_18.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        this.lblNewLabel_3 = new JLabel("Contrase\u00F1a:");
        this.lblNewLabel_3.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 11));
        this.panel_18.add(this.lblNewLabel_3);

        this.panel_4 = new JPanel();
        this.panel_4.setBackground(SystemColor.inactiveCaption);
        this.panel_4.setBorder(null);
        this.panel_3.add(this.panel_4);
                this.panel_4.setLayout(new GridLayout(3, 1, 0, 0));
                
                this.panel_19 = new JPanel();
                this.panel_19.setBackground(SystemColor.inactiveCaption);
                this.panel_4.add(this.panel_19);
                
                this.panel_20 = new JPanel();
                this.panel_4.add(this.panel_20);
                this.panel_20.setLayout(new BorderLayout(0, 0));
                
                this.passwordField = new JPasswordField();
                this.panel_20.add(this.passwordField, BorderLayout.CENTER);
                
                this.panel_21 = new JPanel();
                this.panel_21.setBackground(SystemColor.inactiveCaption);
                this.panel_20.add(this.panel_21, BorderLayout.EAST);
                
                this.panel_22 = new JPanel();
                this.panel_22.setBackground(SystemColor.inactiveCaption);
                this.panel_20.add(this.panel_22, BorderLayout.WEST);

        this.panel_1 = new JPanel();
        this.panel_1.setBorder(new LineBorder(SystemColor.inactiveCaption));
        this.contentPane.add(this.panel_1, BorderLayout.NORTH);
        this.panel_1.setLayout(new GridLayout(2, 3, 0, 0));

        this.panel_8 = new JPanel();
        this.panel_8.setBackground(SystemColor.activeCaption);
        FlowLayout flowLayout = (FlowLayout) this.panel_8.getLayout();
        this.panel_1.add(this.panel_8);

        this.lblNewLabel = new JLabel("Sistema Cervecer\u00EDa 'Peppa'");
        this.lblNewLabel.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 14));
        this.panel_8.add(this.lblNewLabel);

        this.panel_9 = new JPanel();
        this.panel_9.setBackground(SystemColor.inactiveCaption);
        this.panel_1.add(this.panel_9);

        this.lblNewLabel_1 = new JLabel("Ingrese sus datos para loguearse ^^ ");
        this.lblNewLabel_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
        this.lblNewLabel_1.setBackground(SystemColor.activeCaption);
        this.panel_9.add(this.lblNewLabel_1);

        this.btnNewButton = new JButton("Ingresar");
        this.btnNewButton.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
        this.contentPane.add(this.btnNewButton, BorderLayout.SOUTH);
    }

    public void setActionListener(ActionListener actionListener) {
        this.btnNewButton.addActionListener(actionListener);
        this.actionListener = actionListener;
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
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub
		this.btnNewButton.setEnabled(!(this.textField.getText().isBlank() || this.passwordField.getText().isBlank()));
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	
	

	public JPasswordField getPasswordField()
	{
		return this.passwordField;
	}

	public JTextField getTextField()
	{
		return this.textField;
	}


}