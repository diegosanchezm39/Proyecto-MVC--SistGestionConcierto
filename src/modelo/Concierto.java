package modelo;
import java.util.Date;

public class Concierto {
    private String nombre;
    private Date fecha;
    private Zona[] zonas;
    private int numZonas;

    public Concierto(String nombre, Date fecha, int maxZonas) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.zonas = new Zona[maxZonas];
        this.numZonas = 0;
    }

    public boolean agregarZona(String nombre, int capacidad, int precio) {
        if (numZonas < zonas.length) {
            zonas[numZonas] = new Zona(nombre, capacidad, precio);
            numZonas++;
            return true;
        }
        return false;
    }

    public boolean eliminarZona(String nombre) {
        for (int i = 0; i < numZonas; i++) {
            if (zonas[i].getNombre().equalsIgnoreCase(nombre)) {
                // Desplazar elementos para no dejar huecos
                for (int j = i; j < numZonas - 1; j++) {
                    zonas[j] = zonas[j + 1];
                }
                zonas[numZonas - 1] = null;
                numZonas--;
                return true;
            }
        }
        return false;
    }

    public Zona[] getZonas() { return zonas; }
}