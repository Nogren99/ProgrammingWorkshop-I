package vista;

import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public interface IVista {
    void cerrar();

    void mostrar();

    void setActionListener(ActionListener actionListener);

}
