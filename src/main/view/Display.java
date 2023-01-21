package main.view;

import main.control.Command;

public interface Display {
    void display();
    void addCommand(String na, Command cm);
    public String getTrayectoryName();
    public int[] getTrayectoryPeriod();
    public String getEventName();
}
