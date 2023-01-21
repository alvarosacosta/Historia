package main;

import main.model.*;
import main.view.*;
import main.control.*;

public class Historia {

    public static void main(String[] args) {
         Catalogo catalogo = new Catalogo("TipoA");
         
         catalogo.add(new EventoHistorico("GuerraA", "Espana", 
                "Murio mucha gente.", new int[]{1952, 2023}, new String[]{"FotoA", "FotoB", "FotoC"}));
         catalogo.add(new EventoHistorico("GuerraB", "Portugal", 
                "Gano Cristiano.", new int[]{1832, 2099}, new String[]{"FotoD", "FotoE", "FotoF"}));
         catalogo.add(new EventoHistorico("GuerraC", "LoloLandia", 
                "Lolo la lio parda.", new int[]{2001, 2002}, new String[]{"FotoG", "FotoH", "FotoI"}));
         catalogo.add(new EventoHistorico("GuerraD", "AAAALandia", 
                "AAAAAAAAA.", new int[]{1000, 1048}, new String[]{"FotoG", "FotoH", "FotoI"}));
         catalogo.add(new EventoHistorico("GuerraE", "Burgos de los no muertos", 
                "Yosra deja a Ita.", new int[]{1500, 2023}, new String[]{"FotoG", "FotoH", "FotoI"}));
         catalogo.add(new EventoHistorico("GuerraF", "Imperio Setup", 
                "Invasion de los SpecInt2000, y la revolucion de los SpecInt1000.", new int[]{1831, 1951}, new String[]{"FotoG", "FotoH", "FotoI"}));
         catalogo.add(new EventoHistorico("GuerraG", "Pero tiene 8 o 4 por coordenada", 
                "EL CILINDRO FOTOCONDUCTOR SOLO SE CARGA EN LA ZONAS PROXIMAS AL COROTRON", new int[]{2992, 2992}, new String[]{"FotoG", "FotoH", "FotoI"}));
         
         Display display = new DisplayTerminal(catalogo);
         display.addCommand("Trayectoria", new CommandCreateTrayectory(catalogo, display));
         
         display.display();
    }
    
}
