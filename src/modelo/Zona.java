package modelo;

public class Zona {
    private String nombre;
    private int capacidad;
    private int precio;
    private Entrada[] entradas; // Composición: arreglo de entradas

    public Zona(String nombre, int capacidad, int precio) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precio = precio;
        this.entradas = new Entrada[capacidad];
        generarEntradas(); // Se instancian las partes inmediatamente
    }

    private boolean generarEntradas() {
        for (int i = 0; i < capacidad; i++) {
            entradas[i] = new Entrada(i + 1);
        }
        return true;
    }

    public Entrada[] mostrarEntrada() {
        return entradas;
    }

    public Entrada[] venderEntrada(int cantidadRequerida) {
        Entrada[] vendidas = new Entrada[cantidadRequerida];
        int asignadas = 0;
        
        for (int i = 0; i < capacidad && asignadas < cantidadRequerida; i++) {
            if (entradas[i].getEstado().equals("Disponible")) {
                entradas[i].vender();
                vendidas[asignadas] = entradas[i];
                asignadas++;
            }
        }
        return vendidas;
    }

    public int getCapacidadDisponible() {
        int disp = 0;
        for (int i = 0; i < capacidad; i++) {
            if (entradas[i].getEstado().equals("Disponible")) {
                disp++;
            }
        }
        return disp;
    }
    
    public String getNombre() { return nombre; }
    public int getCapacidad() { return capacidad; }
    public int getPrecio() { return precio; }
}