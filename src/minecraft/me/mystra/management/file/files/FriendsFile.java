package me.mystra.management.file.files;

import me.mystra.Mystra;
import me.mystra.management.file.ClientFile;
import me.mystra.management.command.variables.Friend;

public class FriendsFile extends ClientFile {

	public FriendsFile(String path) {
		super(path);
	}
	
	public void saveFriends() {
		String content = "";
		for (Friend friend : Mystra.instance.friendManager.getFriends()) {
			content += friend.getUsername() + (friend.getAlias().isEmpty() ? "":  ":" + friend.getAlias()) + "\n";
		}
		saveFile(content);
	}
	
	public void readFriends() {
		final String content = loadFile();
		if (content.isEmpty()) return;
		final String[] lines = content.split("\n");
		for (String line : lines) {
			if (line.contains(":")) {
				Mystra.instance.friendManager.add(line.split(":")[0], line.split(":")[1]);
			} else {
				Mystra.instance.friendManager.add(line);
			}
		}
	}
}
