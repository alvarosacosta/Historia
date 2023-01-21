package main.control;

import main.model.Catalogo;
import main.view.Display;

public class CommandCreateTrayectory implements Command {

    private final Catalogo catalogo;
    private final Display display;

    public CommandCreateTrayectory(Catalogo catalogo, Display display) {
        this.catalogo = catalogo;
        this.display = display;
        
    }

    @Override
    public void execute() {
        catalogo.getEvento(display.getEventName()).createTrayectory(display.getTrayectoryName(), 
                           display.getTrayectoryPeriod());
    }
    
}
