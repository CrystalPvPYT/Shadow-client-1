package me.mystra.management.command.commands;

import org.lwjgl.input.Keyboard;

import me.mystra.Mystra;
import me.mystra.management.command.Command;
import me.mystra.module.Module;

public class Bind extends Command {

	public Bind(String[] names, String description) {
		super(names, description);
	}

	@Override
	public String getAlias() {
		return "bind";
	}

	@Override
	public String getDescription() {
		return "Allows user to change keybind of module";
	}

	@Override
	public String getSyntax() {
		return ".bind set [MOD] [Key] | .bind del [MOD] | .bind clear";
	}

	@Override
	public String executeCommand(String line, String[] args) {
		if(args[0].equalsIgnoreCase("")) {
			Mystra.addChatMessage(getSyntax());
		}
		
		if(args[0].equalsIgnoreCase("set")) {
			args[2] = args[2].toUpperCase();
			int key = Keyboard.getKeyIndex(args[2]);
			
			for(Module m: Mystra.instance.moduleManager.getModules()) {
				if(args[1].equalsIgnoreCase(m.getName())) {
					m.setKey(Keyboard.getKeyIndex(Keyboard.getKeyName(key)));
					Mystra.addChatMessage(args[1] + " has been binded to " + key);
				}
			}
		} else if (args[0].equalsIgnoreCase("del")){
			for (Module m: Mystra.instance.moduleManager.getModules()) {
				if(m.getName().equalsIgnoreCase(args[1])) {
					m.setKey(0);
					Mystra.addChatMessage(args[1] + " has been unbinded");
				}
			}
		} else if (args[0].equalsIgnoreCase("clear")) {
			for(Module m: Mystra.instance.moduleManager.getModules()) {
				m.setKey(0);
			}
			Mystra.addChatMessage("All keys has been cleared");
		}
		return line;
	}

}
