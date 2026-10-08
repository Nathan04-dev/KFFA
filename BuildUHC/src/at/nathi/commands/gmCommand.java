 package at.nathi.commands;



import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import at.nathi.main.Main;




public class gmCommand implements CommandExecutor{
	
	public int gamemode;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(cmd.getName().equalsIgnoreCase("gm")) {
				if(args.length == 0) {
				p.sendMessage(Main.prefix + "Bitte benutze GM §7<§b0§7,§b1§7,§b2§7,§b3§7>");
				}
				if(args.length == 1) {
					if(p.isOp()) {
						
						if(args[0].equalsIgnoreCase("0")) {
							p.setGameMode(GameMode.SURVIVAL);
							p.sendMessage(Main.prefix + "§7Du bist nun im Gamemode §b§l0");
						}
						if(args[0].equalsIgnoreCase("1")) {
							p.setGameMode(GameMode.CREATIVE);
							p.sendMessage(Main.prefix + "§7Du bist nun im Gamemode §b§l1");
						}
						if(args[0].equalsIgnoreCase("2")) {
							p.setGameMode(GameMode.ADVENTURE);
							p.sendMessage(Main.prefix + "§7Du bist nun im Gamemode §b§l2");
						}
						if(args[0].equalsIgnoreCase("3")) {
							p.setGameMode(GameMode.SPECTATOR);
							p.sendMessage(Main.prefix + "§7Du bist nun im Gamemode §b§l3");
						}
					}
					
				}
			}
		}
		return false;
	}

}
