package at.nathi.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import at.nathi.main.Main;


public class InvseeCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command commands, String label, String[] args) {

		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.isOp()) {
				if(args.length == 1) {
					Player t = Bukkit.getPlayer(args[0]);
					
					
			
					p.openInventory(t.getInventory());
					p.sendMessage(Main.prefix + "§7Inventar von §b" + t.getName());
					
					
					
				} else
					p.sendMessage("§7Bitte benutze /invsee §b§l<SPIELER>");
				
			} else
				p.sendMessage(Main.prefix + "§7Du hast keine §b§lRechte §7für das §b§lSetup§7!");
		}
		
		return false;
	}

}
