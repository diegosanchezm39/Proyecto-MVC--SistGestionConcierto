package modelo;

public abstract class Persona {
    private String nombres;
    private String apellidos;
    private String dni;
    private String contraseña;

    public Persona(String nombres, String apellidos, String dni, String contraseña) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.contraseña = contraseña;
    }

    public boolean registrarTarjeta() { return false; }
    public boolean eliminarTarjeta() { return false; }
    public boolean anularVenta() { return false; }
    public boolean comprar() { return false; }

    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getDni() { return dni; }
    public String getContraseña() { return contraseña; }
}