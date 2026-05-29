package general;

import modelo.*;
import java.util.Date;

public class Sistema {
    // Gestores de arreglos que simulan la base de datos
    public static ClienteArreglo clientes = new ClienteArreglo(100);
    public static VentaArreglo ventas = new VentaArreglo(500);
    
    // El administrador encargado de gestionar zonas
    public static Usuario admin = new Usuario("Admin", "Sistemas", "admin", "1234", true);
    
    // El concierto global del sistema
    public static Concierto concierto = new Concierto("Aniversario UNMSM", new Date());
    
    // Variable global para saber quién tiene la sesión iniciada en ese momento
    public static Persona conectado = null;
}