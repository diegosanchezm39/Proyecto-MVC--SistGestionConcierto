package modelo;

public class Cliente extends Persona {
    private int puntos;
    private Tarjeta tarjeta; 

    public Cliente(String nombres, String apellidos, String dni, String contraseña, int puntos) {
        super(nombres, apellidos, dni, contraseña);
        this.puntos = puntos;
        this.tarjeta = null; 
    }

    public void ingresar(String usuario, String clave) {
        if (this.getDni().equals(usuario) && this.getContraseña().equals(clave)) {
            System.out.println("Ingreso exitoso como Cliente.");
        }
    }

    public void setTarjeta(Tarjeta tarjeta) { this.tarjeta = tarjeta; }
    public int getPuntos() { return puntos; }
    public Tarjeta getTarjeta() { return tarjeta; }
}