package modelo;

public class Entrada {
    private int numero;
    private String estado;

    public Entrada(int numero) {
        this.numero = numero;
        this.estado = "Disponible"; // Estado inicial por defecto
    }

    public boolean vender() {
        if (this.estado.equals("Disponible")) {
            this.estado = "Vendido";
            return true;
        }
        return false;
    }

    public boolean liberar() {
        if (this.estado.equals("Vendido")) {
            this.estado = "Disponible";
            return true;
        }
        return false;
    }

    public int getNumero() { return numero; }
    public String getEstado() { return estado; }
}