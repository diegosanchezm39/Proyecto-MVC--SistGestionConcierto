import general.Sistema;
import controlador.ControladorInicio;
import modelo.Cliente;
import vista.frmIniciar;

public class App {
    
    public static void main(String[] args) {
        
        // 1. Cargamos datos de prueba en la base de datos en memoria (Sistema)
        // OJO: El administrador ya está creado en la clase Sistema (usuario: admin, clave: 1234)
        Sistema.clientes.add(new Cliente("Diego", "Sanchez", "71234567", "123", 0));
        Sistema.clientes.add(new Cliente("Jorge", "Zapata", "77654321", "123", 0));
        
        // 2. Instanciamos la Vista
        frmIniciar fInicio = new frmIniciar();
        
        // 3. Instanciamos el Controlador enviándole el modelo y la vista
        ControladorInicio controlador = new ControladorInicio(Sistema.clientes, fInicio);
        
        // 4. Arrancamos el programa
        controlador.iniciar();
    }
}
