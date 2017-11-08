package be.pxl.collections.opdracht2;

public class PrioBot extends Robot {
	public PrioBot(String name) {
		super(name);
	}
	
	public void addCommand(Action action, String value, int priority){
		getCommands().add(new Command(action, value, priority));
	}
}
