package me.mystra.management.command.commands;

import me.mystra.Mystra;
import me.mystra.management.command.Command;

public class Help extends Command {

	public Help(String[] names, String description) {
		super(names, description);
	}

	@Override
	public String getAlias() {
		return "help";
	}

	@Override
	public String getDescription() {
		return "Shows all commands";
	}

	@Override
	public String getSyntax() {
		return ".help";
	}

	@Override
	public String executeCommand(String line, String[] args) {
		
		if(args[0].equalsIgnoreCase("")) {
			Mystra.instance.addChatMessage("---------------- \247bHelp \247f----------------");
            for (Command cmd : Mystra.instance.cmdManager.getCommands()) {
            	Mystra.instance.addChatMessage(" ." + cmd.getName() + " : \2477" + cmd.getDescription());
            }
			
		}
		return line;
	}

}
