package me.joyride;

import java.util.*;
import net.md_5.bungee.api.plugin.*;

public class Main extends Plugin
{
    public void onEnable() {
        Utils.loadProperties();
        Utils.message = Utils.properties.getProperty("message", "&c&lPixelwarp &8&l> &7You are now at the hub.");
        Utils.alreadyConnectedMessage = Utils.properties.getProperty("message.already.connected", "&c&lPixelhub &8&l> &7You are already at the hub.");
        Utils.hubServer = Utils.properties.getProperty("hubserver", "lobby");
        Utils.permission = Utils.properties.getProperty("permission", "");
        final String[] aliases = Utils.properties.getProperty("aliases", "").split(",");
        final ArrayList<String> aliasesList = new ArrayList<String>();
        for (int i = 0; i < aliases.length; ++i) {
            if (i == 0) {
                Utils.command = aliases[i].toLowerCase();
            }
            else {
                aliasesList.add(aliases[i].toLowerCase());
            }
        }
        Utils.aliases = aliasesList.stream().toArray(String[]::new);
        this.getProxy().getPluginManager().registerCommand((Plugin)this, (Command)new HubCommand(Utils.command.equals("") ? "hub" : Utils.command, Utils.permission, Utils.aliases));
    }
    
    public void onDisable() {
    }
}
