package modelo;

public class Usuario extends Persona {
    private boolean estado;

    public Usuario(String nombres, String apellidos, String dni, String contraseña, boolean estado) {
        super(nombres, apellidos, dni, contraseña);
        this.estado = estado;
    }

    public void registrarZonas() {
        System.out.println("Zonas registradas.");
    }

    public boolean isEstado() { return estado; }
}