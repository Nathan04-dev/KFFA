package at.nathi.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import at.nathi.main.Main;
import config.messages;


public class InvseeCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command commands, String label, String[] args) {

		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.isOp() || p.hasPermission("knockffa.moderator") || p.hasPermission("knockffa.admin")) {
				if(args.length == 1) {
					Player t = Bukkit.getPlayer(args[0]);
					
					p.openInventory(t.getInventory());
					String invsee = messages.messageConfig.getString("MSGConfig.INVSEE");
					invsee = invsee.replace("%player%", t.getName());
					p.sendMessage(Main.prefix + invsee);
					
				} else
					p.sendMessage(Main.prefix + "§7Bitte benutze §e§l/invsee <SPIELER>");
				
			} else
				p.sendMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.KNOCKFFA_NoPermission"));
		}
		
		return false;
	}

}
