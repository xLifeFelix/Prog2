package de.hasa.g17.fatsquirrel.util.ui.consoletest;

public class Command {
	private CommandTypeInfo commandType;
	private Object[] params;
	
	public Command(CommandTypeInfo commandType, Object[] params) {
		this.commandType = commandType;
		this.params = params;
	}

	public CommandTypeInfo getCommandType() {
		return commandType;
	}

	public Object[] getParams() {
		return params;
	}
}
