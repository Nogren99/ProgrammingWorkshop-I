package presentacion;

import java.util.Scanner;

import javax.swing.JOptionPane;

import modelo.Operario;
import modelo.Usuario;

import negocio.BeerHouse;

public class Main {

    public static void main(String[] args) {
    	BeerHouse sistema = BeerHouse.getInstancia();
    	sistema.inicializaMesas();
        Controlador controlador = new Controlador();
        ControladorPersistencia controladorPersistencia = new ControladorPersistencia();

       /* BeerHouse sistema = negocio.BeerHouse.getInstancia();

        String username = JOptionPane.showInputDialog(null, "Ingresa nombre de usuario");
        String password = JOptionPane.showInputDialog(null, "Ingrese password");
        Operario user;

        try {
            user = (Operario) sistema.login(username, password);
            sistema.agregaOperario(user);
            System.out.println("Username:" + user.getUsername() + " Password: " + user.getPassword());
        } catch (Exception e) {
            System.out.println("ERROR");
        }

        username = JOptionPane.showInputDialog(null, "Ingresa nombre de usuario");
        password = JOptionPane.showInputDialog(null, "Ingrese password");

        try {
            user = (Operario) sistema.login(username, password);
            sistema.agregaOperario(user);
            System.out.println("Username:" + user.getUsername() + " Password: " + user.getPassword());
        } catch (Exception e) {
            System.out.println("ERROR");
        }*/
        
    } 

}
