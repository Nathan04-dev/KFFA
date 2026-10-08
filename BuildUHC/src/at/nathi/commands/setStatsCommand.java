package at.nathi.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import at.nathi.main.Main;

public class setStatsCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(p.isOp()) {
		if(args.length == 0) {
			p.sendMessage("§3/setstats §7<Kills/Tode> <SPIELER> <Anzahl>");
		} else if(args[0].equalsIgnoreCase("Kills")) {
			Player t = Bukkit.getPlayer(args[1]);
			if(t == null) {
				p.sendMessage("§7Der Spieler §3" + args[1] + " §7ist nicht auf den Server");
			} else {
			try {
				int i = Integer.parseInt(args[2]);
				Main.getInstance().getConfig().set(t.getName() + ".Kills", i); 
				Main.getInstance().saveConfig();
				p.sendMessage(Main.prefix + "§7Du hast die Kills von§3 " + t.getName() + " §7auf§3 "+ i + " §7gesetzt");
				
			} catch(NumberFormatException e) {
				p.sendMessage("§7Das ist keine §3Zahl");
				p.sendMessage("§3/setstats §7<Kills/Tode> <Anzahl>");
			}
			}
			
			
			} else if(args[0].equalsIgnoreCase("Tode")) {
				Player t = Bukkit.getPlayer(args[1]);
				if(t == null) {
					p.sendMessage("§7Der Spieler §3" + args[1] + " §7ist nicht auf den Server");
				} else {
				try {
					int i = Integer.parseInt(args[2]);
					Main.getInstance().getConfig().set(t.getName() + ".Deaths", i); 
					Main.getInstance().saveConfig();
					p.sendMessage(Main.prefix + "§7Du hast die Tode von§3 " + t.getName() + " §7auf§3 "+ i + " §7gesetzt");
					
					
				} catch(NumberFormatException e) {
					p.sendMessage("§7Das ist keine §3Zahl");
					p.sendMessage("§3/setstats §7<Kills/Tode> <Anzahl>");
				}
				}

			}
			} else
				p.sendMessage(Main.prefix + "§7Du hast keine §3Rechte §7für das §3Setup§7!");
		return false;
	}

}
