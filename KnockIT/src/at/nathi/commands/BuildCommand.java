package at.nathi.commands;


import java.util.ArrayList;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.bukkit.event.Listener;

import at.nathi.main.Main;

import config.messages;

public class BuildCommand implements CommandExecutor, Listener{
	


	public static ArrayList<Player> build = new ArrayList<Player>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;{
				if(p.isOp() || p.hasPermission("knockffa.admin") || p.hasPermission("knockffa.moderator")) {
					if(args.length == 0) {

						if(build.contains(p)) {
							build.remove(p);
							p.sendMessage("Du bist nicht mehr im Build Modus");
		
						} else {
							build.add(p);
							p.sendMessage("Du bist nun im Build Modus");
						
						}
							
						
					
					} else
						p.sendMessage(Main.prefix + "§7Bitte benutze §e/freeze <SPIELER>");
				
					}else 
						p.sendMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.KNOCKFFA_NoPermission"));
			}
		}
				
		
		

	return false;	
	}

}
