package at.nathi.listeners;


import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import at.nathi.kit.kits;
import at.nathi.main.Main;
import at.nathi.mysql.SQLStats;
import at.nathi.title.TitleAPI;

public class JoinAndQuitListener implements Listener {
	public static int taskID;

	public JoinAndQuitListener(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	
	} 
	
	@EventHandler()
	public void onJoin(PlayerJoinEvent e) {

		
		Player p = e.getPlayer();
		SQLStats.createPlayer(p.getUniqueId().toString());
		p.sendMessage("§1");
		p.sendMessage("§2");
		p.sendMessage("§3");
		p.sendMessage("§4");
		p.sendMessage("§5");
		p.sendMessage("§6");
		p.sendMessage("§7");
		p.sendMessage("§8");
		p.sendMessage("§9");
		p.sendMessage("§a");
		p.sendMessage("§b");
		p.sendMessage("§c");
		p.sendMessage("§d");
		p.sendMessage("§e");
		TitleAPI.sendTitle(p, 20, 20, 20, Main.prefix, "");
		SQLStats.setName(p.getUniqueId().toString(), p.getName());
		e.setJoinMessage("§7[§b+§7] §7" + p.getName() + "");


	
		//BESTEN:NOTE_SNARE_DRUM,
		p.getInventory().clear();
		kits.uhckit(p);
		p.playSound(p.getLocation(), Sound.NOTE_SNARE_DRUM, 15, 15);
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 15, 15);
		p.setHealth(20);
		p.setFoodLevel(20);
		p.setLevel(2021);
	
		
		p.setGameMode(GameMode.SURVIVAL);
		
	
		
		double x = (double) Main.getInstance().getConfig().getDouble("builduhc.spawns.lobby.X");
		double y = (double) Main.getInstance().getConfig().getDouble("builduhc.spawns.lobby.Y");
		double z = (double) Main.getInstance().getConfig().getDouble("builduhc.spawns.lobby.Z");
		String w = (String) Main.getInstance().getConfig().getString("builduhc.spawns.lobby.World");
		float yaw = (float) Main.getInstance().getConfig().getDouble("builduhc.spawns.lobby.Yaw");
		float pitch = (float) Main.getInstance().getConfig().getDouble("builduhc.spawns.lobby.Pitch");
		World world = Bukkit.getWorld(w);
		
		Location loc = new Location(world, x, y, z, yaw, pitch);
		p.teleport(loc);
		

		

	}
	

		
		
	//SCOREBOARD
	

		public static void setScoreboard(Player p) {
			ScoreboardManager sm = Bukkit.getScoreboardManager();
			final Scoreboard board = sm.getNewScoreboard();
			final Objective o = board.registerNewObjective("test", "dummy");

			int tode = SQLStats.getTode(p.getUniqueId().toString());
			int kills = SQLStats.getKills(p.getUniqueId().toString());
			
			double KD = ((double) kills) / ((double) tode);
			KD = Math.round(KD * 100) /100.00;
			if(KD > 1000000000) {
				KD = kills;
			}
			String kc = Double.valueOf(KD).toString();
		

		o.setDisplaySlot(DisplaySlot.SIDEBAR);

		o.getScore("§0").setScore(11);
		o.getScore("§7➠Kills:").setScore(10);
		o.getScore("§b➟ " + kills).setScore(9);
		o.getScore("§p").setScore(8);
		o.getScore("§7➠Tode:" ).setScore(7);
		o.getScore("§a§b➟ " + tode).setScore(6);
		o.getScore("§a").setScore(5);
		o.getScore("§7➠KD:").setScore(4);
		o.getScore("§b➟ " + kc.replace("Infinity", "0").replace("NaN", "0")).setScore(3);
		o.getScore("§b").setScore(2);
		o.getScore("§f➠ DeinServer.at").setScore(1);
		p.setScoreboard(board);
			
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
			
			public int animation = 11;
			
			@Override
			public void run() {
//"§7§l✘ §d§lBuild§5§lFFA §7§l✘ "
				
				animation--;
		

				
				switch(animation) {
				case 10:
					o.setDisplayName("§7§l✘");
					break;
				case 9:
					o.setDisplayName("§7§l✘ §3§lB");
					break;
				case 8:
					o.setDisplayName("§7§l✘ §3§lBu");
					break;
				case 7:
					o.setDisplayName("§7§l✘ §3§lBui");
					break;
				case 6:
					o.setDisplayName("§7§l✘ §3§lBuil");
					break;
				case 5:
					o.setDisplayName("§7§l✘ §3§lBuild");
					break;
				case 4:
					o.setDisplayName("§7§l✘ §3§lBuild§b§lU");
					break;
				case 3:
					o.setDisplayName("§7§l✘ §3§lBuild§b§lUH");
					break;
				case 2:
					o.setDisplayName("§7§l✘ §3§lBuild§b§lUHC");
					break;
				case 1:
					o.setDisplayName("§7§l✘ §3§lBuild§b§lUHC §7§l✘ ");
					break;
				default:
					break;
		
				}
				
				
			}
		}, 0, 15);

		}


		
	
		@EventHandler
		public void onPlayerJoin(PlayerJoinEvent e) {

			new BukkitRunnable() {
				
				@Override
				public void run() {
					for(Player all : Bukkit.getOnlinePlayers()) {
					setScoreboard(all);
					}
					
				}
			}.runTaskLater(Main.getInstance(), 1);

			}
	
	@EventHandler()
	public void onQuit(PlayerQuitEvent e) {

	 Player p = e.getPlayer();

		e.setQuitMessage("§7[§c-§7] §7" + p.getName() + "");
		for(Player all : Bukkit.getOnlinePlayers()) {
			
		new BukkitRunnable() {
			@Override
			public void run() {
				setScoreboard(all);
				
			}
		}.runTaskLater(Main.getInstance(), 1);
}
		
	}
}
	