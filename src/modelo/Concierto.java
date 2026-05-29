package modelo;
import java.util.Date;

public class Concierto {
    private String nombre;
    private Date fecha;
    private Zona[] zonas;
    private int numZonas;

    public Concierto(String nombre, Date fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.zonas = new Zona[4];
        this.numZonas = 0;
    }

   public boolean agregarZona(String nombreZona, int capacidad, int precio) {
    if (numZonas < 4) {
        zonas[numZonas] = new Zona(nombreZona, capacidad, precio);
        numZonas++;
        return true;
    }
    return false;
}

    public boolean eliminarZona(String nombreZona) {
        for (int i = 0; i < numZonas; i++) {
            if (zonas[i]!= null && zonas[i].getNombre().equalsIgnoreCase(nombreZona)) {
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

   public String getNombre() { return nombre; }
   public Date getFecha() { return fecha; }
   public Zona[] getZonas() { return zonas; }
   public int getNumZonas() { return numZonas; }
}