package main.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Catalogo {
    private final String nombre;
    private ArrayList<EventoHistorico> eventos = new ArrayList<>();

    public Catalogo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    public ArrayList<EventoHistorico> getEventosSimulation(int[] simulationPeriod) {
        ArrayList<EventoHistorico> result = new ArrayList<>();
        
        for (EventoHistorico evento : eventos) {
            if(evento.getPeriodo()[0] >= simulationPeriod[0] && evento.getPeriodo()[1] <= simulationPeriod[1]){
                result.add(evento);
            }
        }
        
        Collections.sort(result, new Comparator<>(){
            
            @Override
            public int compare(EventoHistorico o1, EventoHistorico o2) {
                return o1.getPeriodo()[0] - o2.getPeriodo()[0];
            }
            
        });
        
        
        return result;
    }
    
    public EventoHistorico getEvento(String n) {
        for (EventoHistorico evento : eventos) {
            if(evento.getNombre().equals(n)){
                return evento;
            }
        }
        
        return new EventoHistorico("none", "none", 
                "none", new int[]{0, 0}, new String[]{"none"});
    }
    
    public boolean thereIsEvento(String n) {
        for (EventoHistorico evento : eventos) {
            if(evento.getNombre().equals(n)){
                return true;
            }
        }
        return false;
    }

    public void add(EventoHistorico h){
        eventos.add(h);
    }
    
    @Override
    public String toString(){
        String result = "";
        
        for (EventoHistorico evento : eventos) {
            result += evento.toString() + "\n";
        }
        
        return result;
    }

}
