package me.joyride;

import net.md_5.bungee.api.plugin.*;
import net.md_5.bungee.api.connection.*;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.*;
import net.md_5.bungee.api.*;
import net.md_5.bungee.api.config.*;

public class HubCommand extends Command
{
    public HubCommand(final String name, final String permission, final String... aliases) {
        super(name, permission, aliases);
    }
    
    public void execute(final CommandSender cs, final String[] args) {
        if (!(cs instanceof ProxiedPlayer)) {
            cs.sendMessage(TextComponent.fromLegacyText("Please use this command only as a Player!"));
            return;
        }
        final ProxiedPlayer p = (ProxiedPlayer)cs;
        final ServerInfo server = BungeeCord.getInstance().getServerInfo(Utils.hubServer);
        if (server == null) {
            System.out.println("The server '" + Utils.hubServer + "' could not be found!");
            return;
        }
        if (server.getName().equalsIgnoreCase(p.getServer().getInfo().getName())) {
            if (!Utils.alreadyConnectedMessage.equals("")) {
                p.sendMessage(TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', Utils.alreadyConnectedMessage)));
            }
            return;
        }
        p.connect(server);
        if (!Utils.message.equals("")) {
            p.sendMessage(TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', Utils.message)));
        }
    }
}
