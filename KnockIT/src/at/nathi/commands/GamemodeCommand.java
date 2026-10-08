 package at.nathi.commands;



import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import at.nathi.main.Main;
import config.messages;




public class GamemodeCommand implements CommandExecutor{
	
	public int gamemode;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(cmd.getName().equalsIgnoreCase("gamemode")) {
				if(p.isOp() || p.hasPermission("knockffa.moderator") || p.hasPermission("knockffa.admin")) {
				if(args.length == 0) {
				p.sendMessage(Main.prefix + "§7Bitte benutze Gamemode §7<§e0§7,§e1§7,§e2§7,§e3§7>");
				}
				if(args.length == 1) {
						if(args[0].equalsIgnoreCase("0")) {
							p.setGameMode(GameMode.SURVIVAL);
							p.sendMessage(Main.prefix + "§7Du bist nun im Gamemode §e§l0");
						}
						if(args[0].equalsIgnoreCase("1")) {
							p.setGameMode(GameMode.CREATIVE);
							p.sendMessage(Main.prefix + "§7Du bist nun im Gamemode §e§l1");
						}
						if(args[0].equalsIgnoreCase("2")) {
							p.setGameMode(GameMode.ADVENTURE);
							p.sendMessage(Main.prefix + "§7Du bist nun im Gamemode §e§l2");
						}
						if(args[0].equalsIgnoreCase("3")) {
							p.setGameMode(GameMode.SPECTATOR);
							p.sendMessage(Main.prefix + "§7Du bist nun im Gamemode §e§l3");
						}
					}
					
				} else {
					p.sendMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.KNOCKFFA_NoPermission"));
				}
			}
		}
		return false;
	}

}
