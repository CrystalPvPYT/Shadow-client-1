package me.mystra.management.command.commands;

import me.mystra.Mystra;
import me.mystra.management.command.Command;
import me.mystra.module.Module;

public class Toggle extends Command {

	public Toggle(String[] names, String description) {
		super(names, description);
	}

	@Override
	public String getAlias() {
		return "toggle";
	}

	@Override
	public String getDescription() {
		return "Allows you to toggle a module";
	}

	@Override
	public String getSyntax() {
		return ".toggle [MOD]";
	}

	@Override
	public String executeCommand(String line, String[] args) {
		
		if(args[0].equalsIgnoreCase("")) {
			Mystra.addChatMessage(getSyntax());
		}
		
		boolean found = false;
		for(Module m: Mystra.instance.moduleManager.getModules()) {
			if(args[0].equalsIgnoreCase(m.getName())) {
				if(m.isToggled()) {
				Mystra.addChatMessage(m.getName() + " has been §cdisabled!");
			}else {
				Mystra.addChatMessage(m.getName() + " has been §aenabled!");
			}
				m.toggle();
				found = true;
			}
		}
		if(found == false) {
			Mystra.addChatMessage("§cInvalid Module!");
		}
		return line;
	}

}
