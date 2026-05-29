package controlador;

import general.Sistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.frmPrincipal;
import vista.frmIniciar;
import vista.frmComprar;
import controlador.ControladorComprar;

public class ControladorPrincipal {
    private frmPrincipal vista;

    public ControladorPrincipal(frmPrincipal vista) {
        this.vista = vista;
        
        // Acción para cerrar sesión
        this.vista.btnCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sistema.conectado = null; // Limpiamos el usuario actual
                vista.dispose(); // Cerramos el menú principal
                
                // Volvemos a abrir el login
                frmIniciar fInicio = new frmIniciar();
                ControladorInicio controlador = new ControladorInicio(Sistema.clientes, fInicio);
                controlador.iniciar();
            }
        });
        
        // Acción para el botón de Comprar (Solo Clientes)
        this.vista.btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Sistema.conectado != Sistema.admin) {
                   vista.dispose(); 
                   frmComprar fComprar = new frmComprar();
                   ControladorComprar ctrlComprar = new ControladorComprar(fComprar);
                   ctrlComprar.iniciar();   
                } else {
                    JOptionPane.showMessageDialog(vista, "El administrador no puede comprar entradas.", "Acceso denegado", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        // Acción para el botón de Gestionar Zonas (Solo Admin)
        this.vista.btnGestionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Sistema.conectado == Sistema.admin) {
                    JOptionPane.showMessageDialog(vista, "Abriendo panel de gestión de zonas...");
                    // TODO: Aquí conectaremos con la ventana de Zonas en la siguiente entrega
                } else {
                    JOptionPane.showMessageDialog(vista, "Solo el administrador puede gestionar zonas.", "Acceso denegado", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
        // Si pusiste el label de bienvenida, lo actualizamos aquí:
        // vista.lblBienvenida.setText("Bienvenido, " + Sistema.conectado.getNombres());
        vista.setVisible(true);
    }
}