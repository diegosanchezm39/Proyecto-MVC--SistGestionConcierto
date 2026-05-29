package modelo;

public class VentaArreglo {
    private Venta[] ventas;
    private int indice;

    public VentaArreglo(int tamaño) {
        this.ventas = new Venta[tamaño];
        this.indice = 0;
    }

    public boolean add(Venta v) {
        if (this.indice < this.ventas.length) {
            this.ventas[this.indice] = v;
            this.indice++;
            return true;
        }
        return false;
    }
}