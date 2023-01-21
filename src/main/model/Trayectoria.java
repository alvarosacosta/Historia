package main.model;

public class Trayectoria {
    private final String nombre;
    private final int[] periodo;

    public Trayectoria(String name, int[] periodo) {
        this.nombre = name;
        this.periodo = periodo;
    }

    public String getNombre() {
        return nombre;
    }

    public int[] getPeriodo() {
        return periodo;
    }
    
    @Override
    public String toString(){
        return "Nombre de trayectoria: " + this.nombre + " | Periodo: " + 
               String.valueOf(this.periodo[0]) + "-" + String.valueOf(this.periodo[1]);
    }
}
