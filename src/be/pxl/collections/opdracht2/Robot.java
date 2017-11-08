package be.pxl.collections.opdracht2;

import java.util.Vector;

public class Robot {
	private String name;
	private Vector<Command> commands;

	public Robot(String name) {
		this.setName(name);
		commands = new Vector<Command>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int countCommands() {
		return commands.size();
	}

	public Command execute() {
		Command returnCommand = new Command(Action.NONE, "");
		if (commands.size() > 0) {
			returnCommand = commands.stream().reduce((accumulator, element) -> accumulator.priority < element.priority
					? accumulator = element : accumulator).get();
			commands.remove(returnCommand);
		}
		return returnCommand;
	}

	public void addCommand(Action action, String value) {
		commands.add(new Command(action, value));
	}

	public void addCommand(Action action, String value, int priority) {
		if (!this.getClass().getSimpleName().equals("PrioBot")) {
			System.out.println("Only PrioBots are able to use priority!");
		} else {
			commands.add(new Command(action, value, priority));
		}
	}

	public void runCommands() {
		while (commands.size() != 0) {
			this.execute();
		}
	}

	class Command {
		private Action action;
		private String value;
		private int priority;

		public Command(Action action, String value, int priority) {
			this(action, value);
			this.priority = priority;
		}

		public Command(Action action, String value) {
			this.action = action;
			this.value = value;
			priority = 0;
		}

		public String display() {
			return action.toString() + " > " + value;
		}

		public Action action() {
			return action;
		}

		public int priority() {
			return priority;
		}

		public int compareTo(Command c) {
			if (this.priority > c.priority()) {
				return 1;
			} else if (this.priority < c.priority()) {
				return -1;
			}
			return 0;
		}
	}
}
