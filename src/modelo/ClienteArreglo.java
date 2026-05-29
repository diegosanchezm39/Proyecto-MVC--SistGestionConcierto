package modelo;

public class ClienteArreglo {
    private Cliente[] clientes;
    private int indice;

    public ClienteArreglo(int tamaño) {
        this.clientes = new Cliente[tamaño];
        this.indice = 0;
    }

    public boolean add(Cliente c) {
        if (this.indice < this.clientes.length) {
            this.clientes[this.indice] = c;
            this.indice++;
            return true;
        }
        return false;
    }

    public Cliente ingresar(String dni, String clave) {
        for (int i = 0; i < this.indice; i++) {
            if (this.clientes[i].getDni().equals(dni) && this.clientes[i].getContraseña().equals(clave)) {
                return this.clientes[i];
            }
        }
        return null;
    }
}