package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class VentanaRegistro extends JFrame implements IVista, KeyListener
{

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
    private JButton siguienteButton;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_1;
    private ActionListener actionListener;
    private JPasswordField passwordField;
    private JTextField textField;
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
					VentanaRegistro frame = new VentanaRegistro();
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
	public VentanaRegistro()
	{
		setTitle("Registro");
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

        this.lblNewLabel_2 = new JLabel("Nombre de Usuario");
        this.panel_7.add(this.lblNewLabel_2);

        this.panel_5 = new JPanel();
        this.panel_5.setBorder(null);
        this.panel_10.add(this.panel_5);

        this.textField = new JTextField();
        this.panel_5.add(this.textField);
        this.textField.setColumns(10);
        this.textField.addKeyListener(this);

        this.panel_3 = new JPanel();
        this.panel_3.setBorder(new LineBorder(SystemColor.inactiveCaption));
        this.panel.add(this.panel_3);
        this.panel_3.setLayout(new GridLayout(0, 2, 0, 0));

        this.panel_6 = new JPanel();
        this.panel_3.add(this.panel_6);

        this.lblNewLabel_3 = new JLabel("Contrase\u00F1a");
        this.panel_6.add(this.lblNewLabel_3);

        this.panel_4 = new JPanel();
        this.panel_4.setBorder(null);
        this.panel_3.add(this.panel_4);

        this.passwordField = new JPasswordField();
        this.passwordField.setColumns(10);
        this.panel_4.add(this.passwordField);
        this.passwordField.addKeyListener(this);

        this.panel_1 = new JPanel();
        this.panel_1.setBorder(new LineBorder(SystemColor.inactiveCaption));
        this.contentPane.add(this.panel_1, BorderLayout.NORTH);
        this.panel_1.setLayout(new GridLayout(2, 3, 0, 0));

        this.panel_8 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) this.panel_8.getLayout();
        this.panel_1.add(this.panel_8);

        this.lblNewLabel = new JLabel("Sistema Cervecer\u00EDa 'Peppa'");
        this.panel_8.add(this.lblNewLabel);

        this.panel_9 = new JPanel();
        this.panel_1.add(this.panel_9);

        this.lblNewLabel_1 = new JLabel("Ingrese sus datos para registrarse ^^ ");
        this.panel_9.add(this.lblNewLabel_1);

        this.siguienteButton = new JButton("Siguiente");
        this.siguienteButton.setToolTipText("Siguiente");
        this.siguienteButton.setEnabled(false);
        this.siguienteButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        this.contentPane.add(this.siguienteButton, BorderLayout.SOUTH);
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
		this.siguienteButton.addActionListener(actionListener);
        this.actionListener = actionListener;
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		this.siguienteButton.setEnabled(!(this.textField.getText().isBlank() || this.passwordField.getText().isBlank()));
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

	@Override
	public JPasswordField getPasswordField()
	{
		return this.passwordField;
	}

	@Override
	public JTextField getTextField()
	{
		return this.textField;
	}

}
