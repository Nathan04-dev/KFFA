package at.nathi.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import at.nathi.main.Main;

public class ChatclearCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command commands, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.isOp()) {
			if(args.length == 0) {
				
				for(int i = 0; i <= 150; i++)
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage("§7Der Chat wurde von §b§l" + p.getName() + " §7gecleart.");
				
				
			} else
				p.sendMessage("§7Bitte benutze §5§l/cc§7!");
		} else
			p.sendMessage(Main.prefix + "§7Du hast keine §b§lRechte §7für das §b§lSetup§7!");
			
	}
		
		
		return false;
	}

}
