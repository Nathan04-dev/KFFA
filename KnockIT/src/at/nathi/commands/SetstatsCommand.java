package at.nathi.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import at.nathi.listeners.JoinAndQuitListener;
import at.nathi.main.Main;
import at.nathi.mysql.SQLStats;

public class SetstatsCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(p.isOp() ) {
		if(args.length == 0) {
			p.sendMessage(Main.prefix + "§e§l/setstats §7§l<Kills/Tode/Coins> <SPIELER> <Anzahl>");
		} else if(args[0].equalsIgnoreCase("Kills")) {
			Player t = Bukkit.getPlayer(args[1]);
			if(t == null) {
				p.sendMessage(Main.prefix + "§7Der Spieler §e§l" + args[1] + " §7ist nicht auf den Server");
			} else {
			try {
				int i = Integer.parseInt(args[2]); 
				SQLStats.setKills(t.getUniqueId().toString(), i);
				p.sendMessage(Main.prefix + "§7Du hast die Kills von§e§l " + t.getName() + " §7auf§e§l "+ i + " §7gesetzt");
				
			} catch(NumberFormatException e) {
				p.sendMessage(Main.prefix + "§7Das ist keine Zahl");
				p.sendMessage(Main.prefix + "§e§l/setstats §7§l<Kills/Tode/Coins> <SPIELER> <Anzahl>");
			}
			}
			new BukkitRunnable() {
				
				@Override
				public void run() {
				for(Player all : Bukkit.getOnlinePlayers()) {
					JoinAndQuitListener.setScoreboard(all);
				}
				}
			}.runTaskLater(Main.getInstance(), 1);
			
			} else if(args[0].equalsIgnoreCase("Tode")) {
				Player t = Bukkit.getPlayer(args[1]);
				if(t == null) {
					p.sendMessage("§7Der Spieler §3" + args[1] + " §7ist nicht auf den Server");
				} else {
				try {
					int i = Integer.parseInt(args[2]);
					SQLStats.setTode(t.getUniqueId().toString(), i);
					p.sendMessage(Main.prefix + "§7Du hast die Tode von§e§l " + t.getName() + " §7auf§e§l "+ i + " §7gesetzt");
					
					
				} catch(NumberFormatException e) {
					p.sendMessage(Main.prefix + "§7Das ist keine Zahl");
					p.sendMessage(Main.prefix + "§e§l/setstats §7§l<Kills/Tode/Coins> <SPIELER> <Anzahl>");
				}
				}
				new BukkitRunnable() {
					
					@Override
					public void run() {
					for(Player all : Bukkit.getOnlinePlayers()) {
						JoinAndQuitListener.setScoreboard(all);
					}
					}
				}.runTaskLater(Main.getInstance(), 1);

			} else if(args[0].equalsIgnoreCase("Coins")) {
				Player t = Bukkit.getPlayer(args[1]);
				if(t == null) {
					p.sendMessage("§7Der Spieler §3" + args[1] + " §7ist nicht auf den Server");
				} else {
				try {
					int i = Integer.parseInt(args[2]);
					SQLStats.setCoins(t.getUniqueId().toString(), i);
					p.sendMessage(Main.prefix + "§7Du hast die Coins von§e§l " + t.getName() + " §7auf§e§l "+ i + " §7gesetzt");
					
					
				} catch(NumberFormatException e) {
					p.sendMessage(Main.prefix + "§7Das ist keine Zahl");
					p.sendMessage(Main.prefix + "§e§l/setstats §7§l<Kills/Tode/Coins> <SPIELER> <Anzahl>");
				}
				}
			}
			} else
				p.sendMessage(Main.prefix + "§7Du hast keine §3Rechte §7für das §3Setup§7!");
		return false;
	}

}
