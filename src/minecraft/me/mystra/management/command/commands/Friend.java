package me.mystra.management.command.commands;

import me.mystra.Mystra;
import me.mystra.management.command.Command;
import net.minecraft.client.Minecraft;

public class Friend extends Command {

	protected static final Minecraft mc = Minecraft.getMinecraft();
	
	public Friend(String[] names, String description) {
		super(names, description);
	}

	@Override
	public String getAlias() {
		return "friend";
	}

	@Override
	public String getDescription() {
		return "Allows you to add friends.";
	}

	@Override
	public String getSyntax() {
		return ".friend add [PLAYER] | .friend del [PLAYER] | .friend clear";
	}

	@Override
	public String executeCommand(String line, String[] args) {
		if(args[0].equalsIgnoreCase("")) {
	            Mystra.instance.addChatMessage(".friend add <UserName>");
	            Mystra.instance.addChatMessage(".friend del <UserName>");
	            Mystra.instance.addChatMessage(".friend clear");
	        } else if (args.length == 1) {
	            if (args[0].equalsIgnoreCase("add")) {
	            	Mystra.instance.addChatMessage("Friend : .friend add <UserName>");
	            } else if (args[0].equalsIgnoreCase("del")) {
	            	Mystra.instance.addChatMessage("Friend : .friend del <UserName>");
	            } else if (args[0].equalsIgnoreCase("clear")) {
	                Mystra.getFriendManager().getFriends().clear();
	                Mystra.instance.addChatMessage("All friends has been cleared!");
	            } else if (args[0].equalsIgnoreCase("list")) {
	                Mystra.instance.addChatMessage("Friends" + "\2477 [\247f" + Mystra.getFriendManager().getFriends().size() + "\2477]\247f" + " : \247a" + Mystra.getFriendManager().getFriendsName());
	            }
	        } else if (args.length == 2) {
	            String nick = args[1];

	            if (nick.equalsIgnoreCase(mc.thePlayer.getName())) {
	            	Mystra.instance.addChatMessage("You cannot add yourself.");
	                return nick;
	            }
	            if (args[0].equalsIgnoreCase("add")) {
	                Mystra.getFriendManager().add(nick);
	                Mystra.instance.addChatMessage("\247aAdded Friend: " + nick);
	            } else if (args[0].equalsIgnoreCase("del")) {
	                Mystra.getFriendManager().remove(nick);
	                Mystra.instance.addChatMessage("\247cDeleted Friend: " + nick);
	            }
	        }
		return line;
	    }
}
