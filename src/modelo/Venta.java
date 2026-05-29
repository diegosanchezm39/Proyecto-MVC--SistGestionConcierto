package modelo;
import java.util.Date;

public class Venta {
    private Date fecha;
    private int monto;
    private Entrada[] entradasCompradas; // Agregación: máximo 4 según el enunciado

    public Venta(Date fecha, int monto, Entrada[] entradasCompradas) {
        this.fecha = fecha;
        this.monto = monto;
        this.entradasCompradas = entradasCompradas;
    }

    public boolean anular() {
        boolean anulado = false;
        for (int i = 0; i < entradasCompradas.length; i++) {
            if (entradasCompradas[i] != null) {
                entradasCompradas[i].liberar();
                anulado = true;
            }
        }
        return anulado;
    }

    public Date getFecha() { return fecha; }
    public int getMonto() { return monto; }
    public Entrada[] getEntradasCompradas() { return entradasCompradas; }
}