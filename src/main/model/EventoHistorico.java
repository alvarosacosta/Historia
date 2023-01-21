package main.model;

public class EventoHistorico {
    private final String geografia;
    private final String nombre;
    private final String descripcion;
    private final int[] periodo;
    private final String[] galeria;
    private Trayectoria trayectoria;

    public EventoHistorico(String nombre, String geografia, String descripcion, int[] periodo, String[] galeria) {
        this.nombre = nombre;
        this.geografia = geografia;
        this.galeria = galeria;
        this.descripcion = descripcion;
        this.periodo = periodo;
    }

    public String getGeografia() {
        return geografia;
    }

    public String getNombre() {
        return nombre;
    }

    public String[] getGaleria() {
        return galeria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int[] getPeriodo() {
        return periodo;
    }
    
    public void createTrayectory(String nombre, int[] periodo){
        trayectoria = new Trayectoria(nombre, periodo);
    }
    
    public Trayectoria getTrayectory(){
        return trayectoria;
    }
    
    @Override
    public String toString(){
        String result = "Nombre: " + this.nombre + " | Geografia: " + 
                        this.geografia + " | Descripcion: " + this.descripcion + " | Periodo: " + 
                        String.valueOf(this.periodo[0]) + "-" + String.valueOf(this.periodo[1]) + " | Galeria: ";
        
        for (String i : galeria) {
            result += i + " ";
        }
        
        return result;
    }
    
}
