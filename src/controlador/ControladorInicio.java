package controlador;

import general.Sistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ClienteArreglo;
import modelo.Cliente;
import vista.frmIniciar;

public class ControladorInicio {
    private ClienteArreglo modelo;
    private frmIniciar vista;

    public ControladorInicio(ClienteArreglo modelo, frmIniciar vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        // Evento para el botón Salir
        this.vista.btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        // Evento para el botón Ingresar
        this.vista.btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = vista.txtUsuario.getText();
                String clave = vista.txtContraseña.getText();
                
                // 1. Verificamos si es el administrador
                if (usuario.equals(Sistema.admin.getDni()) && clave.equals(Sistema.admin.getContraseña())) {
                    Sistema.conectado = Sistema.admin;
                    vista.dispose(); // Cierra el login
                    JOptionPane.showMessageDialog(null, "Bienvenido Administrador");
                    
                    // TODO: Aquí abriremos la ventana principal de Admin más adelante
                    
                } else {
                    // 2. Verificamos si es un cliente registrado
                    Cliente c = modelo.ingresar(usuario, clave);
                    if (c != null) {
                        Sistema.conectado = c;
                        vista.dispose(); // Cierra el login
                        JOptionPane.showMessageDialog(null, "Bienvenido Cliente: " + c.getNombres());
                        
                        // TODO: Aquí abriremos la ventana principal de Cliente más adelante
                        
                    } else {
                        // Credenciales incorrectas
                        JOptionPane.showMessageDialog(vista, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }
    
    // Método para arrancar la ventana centrada
    public void iniciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
}