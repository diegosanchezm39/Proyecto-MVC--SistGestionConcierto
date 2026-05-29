package controlador;

import general.Sistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Zona;
import vista.frmGestionar;
import vista.frmPrincipal;

public class ControladorGestionar {
    private frmGestionar vista;

    public ControladorGestionar(frmGestionar vista) {
        this.vista = vista;
        
        // 1. Cargamos las zonas en el cuadro de texto al abrir la ventana
        actualizarListado();

        // 2. Acción para regresar al menú principal
        this.vista.btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose();
                frmPrincipal fPrincipal = new frmPrincipal();
                ControladorPrincipal ctrlPrincipal = new ControladorPrincipal(fPrincipal);
                ctrlPrincipal.iniciar();
            }
        });

        // 3. Acción para agregar una nueva zona
        this.vista.btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = vista.txtNombre.getText();
                String capStr = vista.txtCapacidad.getText();
                String precStr = vista.txtPrecio.getText();

                if (nombre.isEmpty() || capStr.isEmpty() || precStr.isEmpty()) {
                    JOptionPane.showMessageDialog(vista, "Llene todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int capacidad = Integer.parseInt(capStr);
                    int precio = Integer.parseInt(precStr);

                    // Intentamos agregar al arreglo del concierto
                    boolean exito = Sistema.concierto.agregarZona(nombre, capacidad, precio);

                    if (exito) {
                        JOptionPane.showMessageDialog(vista, "Zona agregada correctamente.");
                        vista.txtNombre.setText("");
                        vista.txtCapacidad.setText("");
                        vista.txtPrecio.setText("");
                        actualizarListado(); // Refresca el cuadro de texto
                    } else {
                        JOptionPane.showMessageDialog(vista, "No se pueden agregar más zonas (Máximo 4 según las reglas).", "Límite alcanzado", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(vista, "Capacidad y Precio deben ser valores numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void actualizarListado() {
        vista.txtListado.setText("ZONAS ACTUALES:\n------------------------\n");
        Zona[] zonas = Sistema.concierto.getZonas();
        for (int i = 0; i < Sistema.concierto.getNumZonas(); i++) {
            if (zonas[i] != null) {
                vista.txtListado.append("- " + zonas[i].getNombre() + " | Capacidad: " + zonas[i].getCapacidad() + " | Precio: S/." + zonas[i].getPrecio() + "\n");
            }
        }
    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
}