package at.nathi.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import at.nathi.main.Main;
import config.messages;

public class ChatclearCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command commands, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.isOp() || p.hasPermission("knockffa.moderator") || p.hasPermission("knockffa.admin")) {
			if(args.length == 0) {
				

				String a = messages.messageConfig.getString("MSGConfig.CHAT_CLEAR");
				a = a.replace("%player%", p.getName());
				
				for(int i = 0; i <= 150; i++)
		
				
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(Main.prefix + a);
				
				
			} else
				p.sendMessage("§7Bitte benutze §5§l/cc§7!");
		} else
			p.sendMessage(messages.messageConfig.getString("MSGConfig.KNOCKFFA_NoPermission"));
			
	}
		
		
		return false;
	}

}
