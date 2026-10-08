package at.nathi.title;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Objective;

import at.nathi.main.Main;

public class Scoreboardtitle {
	
	public static int taskID;
	
	
	public static void onSoreboard(Objective o) {
	taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
		
		public int animation = 11;
		
		@Override
		public void run() {
//"§7§l✘ §e§lBuild§5§lFFA §7§l✘ "	
			animation--;
			
			switch(animation) {
			case 10:
				o.setDisplayName("§7§l✘");
				break;
			case 9:
				o.setDisplayName("§7§l✘ §e§lB");
				break;
			case 8:
				o.setDisplayName("§7§l✘ §e§lBu");
				break;
			case 7:
				o.setDisplayName("§7§l✘ §e§lBui");
				break;
			case 6:
				o.setDisplayName("§7§l✘ §e§lBuil");
				break;
			case 5:
				o.setDisplayName("§7§l✘ §e§lBuild");
				break;
			case 4:
				o.setDisplayName("§7§l✘ §e§lBuild§5§lF");
				break;
			case 3:
				o.setDisplayName("§7§l✘ §e§lBuild§5§lFF");
				break;
			case 2:
				o.setDisplayName("§7§l✘ §e§lBuild§5§lFFA");
				break;
			case 1:
				o.setDisplayName("§7§l✘ §e§lBuild§5§lFFA §7§l✘ ");
				break;
			default:
				break;
	
			}
		}
			
		
	}, 0, 20);
	}
}
