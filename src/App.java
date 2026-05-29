import general.Sistema;
import controlador.ControladorInicio;
import modelo.Cliente;
import vista.frmIniciar;

public class App {
    
    public static void main(String[] args) {
        
        //Datos
        System.out.println("--- DATOS PARA PRUEBAS ---");
        System.out.println("ADMINISTRADOR -> Usuario: admin | Clave: 1234");
        System.out.println("CLIENTE -> DNI: 71234567 | Clave: 123");
        System.out.println("___________________________");
        // 1. Cargamos datos de prueba
        // El administrador ya está creado(usuario: admin, clave: 1234)
        Sistema.clientes.add(new Cliente("Diego", "Sanchez", "71234567", "123", 0));
        Sistema.clientes.add(new Cliente("Jorge", "Zapata", "77654321", "123", 0));
        //Zonas de prueba para el concierto
        Sistema.concierto.agregarZona("VIP", 50, 300);
        Sistema.concierto.agregarZona("General", 200, 100);
        // 2. Instanciamos la Vista
        frmIniciar fInicio = new frmIniciar();
        
        // 3. Instanciamos el Controlador enviándole el modelo y la vista
        ControladorInicio controlador = new ControladorInicio(Sistema.clientes, fInicio);
        
        // 4. Arrancamos el programa
        controlador.iniciar();
    }
}
