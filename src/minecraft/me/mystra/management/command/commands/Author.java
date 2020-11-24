package me.mystra.management.command.commands;

import me.mystra.Mystra;
import me.mystra.management.command.Command;

public class Author extends Command {

	public Author(String[] names, String description) {
		super(names, description);
	}

	@Override
	public String getAlias() {
		return "author";
	}

	@Override
	public String getDescription() {
		return "Shows author / creator";
	}

	@Override
	public String getSyntax() {
		return ".author";
	}

	@Override
	public String executeCommand(String line, String[] args) {
		if(args[0].equalsIgnoreCase("")) {
			Mystra.instance.addChatMessage("Mystra coded / made by Crystal");
		}
		return line;
			
	}

}
