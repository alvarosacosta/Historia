package main.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import main.control.Command;
import main.model.Catalogo;
import main.model.EventoHistorico;

public class DisplayTerminal implements Display {
    private final Catalogo catalogo;
    private Map<String, Command> comandos = new HashMap<>();
    
    private String trayectoryName;
    private int[] trayectoryPeriod = new int[2];
    private String eventName;
    
    private int[] simulationPeriod = new int[2];
    
    public DisplayTerminal(Catalogo catalogo) {
        this.catalogo = catalogo;
    }
    
    @Override
    public void addCommand(String na, Command cm){
        this.comandos.put(na, cm);
    }
    
    @Override
    public void display(){
        showCata();
        
        System.out.print("Elige(por nombre) al evento historico al que quieras acceder "
                + "o escribe \"Simulacion\" si quieres ver una simulacion temporal: ");

        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        
        if(n.equals("Simulacion")){
            System.out.print("Elige ano de inicio de simulacion temporal: ");
            
            simulationPeriod[0] = Integer.parseInt(sc.nextLine());
            
            System.out.print("Elige ano final de simulacion temporal: ");
            
            simulationPeriod[1] = Integer.parseInt(sc.nextLine());
            
            showSimulation();
            
        }
        
        this.eventName = n;
        IsEvento();
        
        System.out.println(catalogo.getEvento(this.eventName).toString());
        System.out.println("Escribe: "
                + "\n Definir: Si quieres definir una trayectoria para este evento."
                + "\n Ver: Si ya la creaste, para ver la trayectoria.");
        
        String line = sc.nextLine();
        
        if(line.equals("Ver")){
            if(catalogo.getEvento(this.eventName).getTrayectory() == null){
                System.out.println("No tiene trayectoria.");
                
                display();
            }
            
            System.out.println(catalogo.getEvento(this.eventName).getTrayectory().toString());
            System.out.print("Escribe \"Exit\" si quieres volver atras: ");
            
            line = sc.nextLine();
            
            if(line.equals("Exit")){
                display();
            }
            
        } else if(line.equals("Definir")){
            System.out.print("Introduce el nombre de la trayectoria: ");
            
            this.trayectoryName = sc.nextLine();
            
            System.out.print("Introduce cuando empieza la trayectoria: ");
            
            int number = Integer.parseInt(sc.nextLine());
            isInPeriod(number);
            
            this.trayectoryPeriod[0] = number;
            
            System.out.print("Introduce cuando termina la trayectoria: ");
            
            number = Integer.parseInt(sc.nextLine());
            isInPeriod(number);
            
            this.trayectoryPeriod[1] = number;
            
            comandos.get("Trayectoria").execute();
            System.out.println("Hecho!");
            
            display();
            
        }
    }
    
    @Override
    public String getTrayectoryName(){
        return this.trayectoryName;
    }
    
    @Override
    public int[] getTrayectoryPeriod(){
        return this.trayectoryPeriod;
    }
    
    @Override
    public String getEventName(){
        return this.eventName;
    }
    
    public void showCata(){
        System.out.println("Catalogo: " + catalogo.getNombre());
        System.out.println(catalogo.toString());
    }
    
    public void isInPeriod(int number){
        if(number < this.catalogo.getEvento(this.eventName).getPeriodo()[0] 
                    || number > this.catalogo.getEvento(this.eventName).getPeriodo()[1]){
            System.out.println("No puedes introducir una trayectoria que sobrepase el periodo del evento historico elegido.");
                
            display();
        }
    }
    
    public void IsEvento(){
        if(!catalogo.thereIsEvento(this.eventName)){
            System.out.println("No existe ese evento.");
            
            display();
        }
    }

    private void showSimulation() {
        String result = "";
        for (EventoHistorico i : catalogo.getEventosSimulation(this.simulationPeriod)) {
            result += i.toString() + "\n";
        }
        
        System.out.println("\nSIMULACION: ");
        System.out.println(result);
        
        System.out.print("Escribe \"Exit\" si quieres volver atras: ");
        
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            
            if(line.equals("Exit")){
                display();
            }

    }
    
    
    
}
