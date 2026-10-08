package at.nathi.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import at.nathi.main.Main;
import config.messages;

public class VanishCommand implements CommandExecutor{

	public static ArrayList<Player> vanish = new ArrayList<Player>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command commands, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("knockffa.admin") || p.isOp()) {
			if(args.length == 0) {
				if(vanish.contains(p)) {
					vanish.remove(p);
					p.sendMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.REMOVE_VANISH"));
					for(Player all : Bukkit.getOnlinePlayers()) {
						all.showPlayer(Main.getInstance(), p);
					} 
				} else {
					vanish.add(p);
					p.sendMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.ADD_VANISH"));
					for (Player all : Bukkit.getOnlinePlayers()) {
						all.hidePlayer(Main.getInstance(), p);
					}
				}

				
			} else
				p.sendMessage("§7Bitte benutze §5§l/vanish§7!");
		} else
			p.sendMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.KNOCKFFA_NoPermission"));
			
	}
		
		
		return false;
	}

}
