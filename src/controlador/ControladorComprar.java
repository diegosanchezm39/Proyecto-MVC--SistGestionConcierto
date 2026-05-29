package controlador;

import general.Sistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Entrada;
import modelo.Venta;
import modelo.Zona;
import vista.frmComprar;
import vista.frmPrincipal;

public class ControladorComprar {
    private frmComprar vista;

    public ControladorComprar(frmComprar vista) {
        this.vista = vista;
        
        // 1. Llenamos el ComboBox con las zonas del concierto al abrir la ventana
        cargarZonas();

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

        // 3. Acción para procesar la compra
        this.vista.btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarCompra();
            }
        });
    }

    private void cargarZonas() {
        vista.cbxZonas.removeAllItems(); // Limpiamos por si acaso
        Zona[] zonas = Sistema.concierto.getZonas();
        
        for (int i = 0; i < Sistema.concierto.getNumZonas(); i++) {
            if (zonas[i] != null) {
                // Mostramos el nombre, precio y asientos disponibles
                vista.cbxZonas.addItem(zonas[i].getNombre() + " - S/." + zonas[i].getPrecio() + " (Disp: " + zonas[i].getCapacidadDisponible() + ")");
            }
        }
    }

    private void procesarCompra() {
        int indiceZona = vista.cbxZonas.getSelectedIndex();
        
        // Validar que se haya seleccionado una zona
        if (indiceZona == -1) {
            JOptionPane.showMessageDialog(vista, "Por favor seleccione una zona.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar que se haya ingresado la tarjeta
        if (vista.txtTarjeta.getText().isEmpty() || vista.txtCVV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Debe ingresar los datos de la tarjeta bancaria.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener la cantidad de entradas elegida
        int cantidad = Integer.parseInt(vista.cbxCantidad.getSelectedItem().toString());
        Zona zonaSeleccionada = Sistema.concierto.getZonas()[indiceZona];

        // Validar si hay capacidad suficiente
        if (zonaSeleccionada.getCapacidadDisponible() < cantidad) {
            JOptionPane.showMessageDialog(vista, "No hay suficientes entradas disponibles en esta zona.", "Capacidad Insuficiente", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Vender entradas y generar cobro
        Entrada[] entradasCompradas = zonaSeleccionada.venderEntrada(cantidad);
        int montoTotal = zonaSeleccionada.getPrecio() * cantidad;

        // Registrar la Venta en el Sistema (La relación de Agregación)
        Venta nuevaVenta = new Venta(new Date(), montoTotal, entradasCompradas);
        Sistema.ventas.add(nuevaVenta);

        JOptionPane.showMessageDialog(vista, "¡Compra exitosa!\nCompraste " + cantidad + " entrada(s) en " + zonaSeleccionada.getNombre() + ".\nTotal pagado: S/." + montoTotal);
        
        // Recargar las zonas para que se actualice la disponibilidad en pantalla
        cargarZonas();
        
        // Limpiar los campos de la tarjeta
        vista.txtTarjeta.setText("");
        vista.txtCVV.setText("");
    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
}