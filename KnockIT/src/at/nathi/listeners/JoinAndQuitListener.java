package at.nathi.listeners;




import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import at.nathi.kits.StartKit;
import at.nathi.main.Main;
import at.nathi.mysql.SQLStats;
import at.nathi.villager.InventoryManager;
import config.locations;
import config.messages;
import config.scoreboard;


public class JoinAndQuitListener implements Listener {
	public static int taskID;

	public JoinAndQuitListener(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	
	} 
	
	@EventHandler()
	public void onJoin(PlayerJoinEvent e) {

		
		Player p = e.getPlayer();
		SQLStats.createPlayer(p.getUniqueId().toString());
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
		p.sendMessage("§e");
		p.sendMessage("§e");
		
		SQLStats.setName(p.getUniqueId().toString(), p.getName());
		p.sendTitle(Main.prefix, null, 20, 20, 20);
	
		RandomMaps.starting();
		p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_SNARE, 15, 15);
		p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 15, 15);
		p.getInventory().clear();
		p.setHealth(20);
		p.setFoodLevel(20);
		p.setLevel(0);
		String msg = messages.messageConfig.getString("MSGConfig.LOBBY_JOIN");
		msg = msg.replace("%Player%", p.getName());
			e.setJoinMessage(msg);
			double x = (double) locations.LocationConfig.getDouble("Map1.X");
			double y = (double) locations.LocationConfig.getDouble("Map1.Y");
			double z = (double) locations.LocationConfig.getDouble("Map1.Z");
			String w = (String) locations.LocationConfig.getString("Map1.World");
			float yaw = (float) locations.LocationConfig.getDouble("Map1.Yaw");
			float pitch = (float) locations.LocationConfig.getDouble("Map1.Pitch");
			World world = Bukkit.getWorld(w);
			
			Location loc = new Location(world, x, y, z, yaw, pitch);
			
			
			p.teleport(loc);
		if(InventoryManager.inventory.containsKey(p.getName())) {
			ItemStack[] contents = InventoryManager.inventory.get(p.getName());
			ItemStack lederbrust = new ItemStack(Material.LEATHER_CHESTPLATE);
			ItemMeta lederbrustmeta = lederbrust.getItemMeta();
			lederbrustmeta.setUnbreakable(true);
			lederbrustmeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 5, false);
			lederbrustmeta.setDisplayName("§6Leder Rüstung");
			lederbrust.setItemMeta(lederbrustmeta);
			p.getInventory().setChestplate(lederbrust);
			p.getInventory().setContents(contents);
			p.setGameMode(GameMode.SURVIVAL);
		} else {
			StartKit.onRusherMethod(p);
		}
	}
	//SCOREBOARD
	

		public static void setScoreboard(Player p) {
			ScoreboardManager sm = Bukkit.getScoreboardManager();
			final Scoreboard board = sm.getNewScoreboard();
			@SuppressWarnings("deprecation")
			final Objective o = board.registerNewObjective("test", "dummy");

			int tode = SQLStats.getTode(p.getUniqueId().toString());
			int kills = SQLStats.getKills(p.getUniqueId().toString());
			
			double KD = ((double) kills) / ((double) tode);
			KD = Math.round(KD * 100) /100.00;
			if(KD > 1000000000) {
				KD = kills;
			}
			String kc = Double.valueOf(KD).toString();
		
		String Score11 = scoreboard.scoreboardConfig.getString("Scoreboard.Score_11");
		String Score10 = scoreboard.scoreboardConfig.getString("Scoreboard.Score_10");
		String Score9 = scoreboard.scoreboardConfig.getString("Scoreboard.Score_9");
		String Score8 = scoreboard.scoreboardConfig.getString("Scoreboard.Score_8");
		String Score7 = scoreboard.scoreboardConfig.getString("Scoreboard.Score_7");
		String Score6 = scoreboard.scoreboardConfig.getString("Scoreboard.Score_6");
		String Score5 = scoreboard.scoreboardConfig.getString("Scoreboard.Score_5");
		String Score4 = scoreboard.scoreboardConfig.getString("Scoreboard.Score_4");
		String Score3 = scoreboard.scoreboardConfig.getString("Scoreboard.Score_3");
		String Score2 = scoreboard.scoreboardConfig.getString("Scoreboard.Score_2");
		String Score1 = scoreboard.scoreboardConfig.getString("Scoreboard.Score_1");
		
		Score11 = Score11.replace("%knockffa_kills%", String.valueOf(kills));	
		Score11 = Score11.replace("%knockffa_deaths%", String.valueOf(tode));	
		Score11 = Score11.replace("%knockffa_kdr%", String.valueOf(kc.replace("Infinity", "0").replace("NaN", "0")));	
		Score11 = Score11.replace("%knockffa_onlineplayers%", String.valueOf(Bukkit.getOnlinePlayers().size()));	
		
		Score10 = Score10.replace("%knockffa_kills%", String.valueOf(kills));	
		Score10 = Score10.replace("%knockffa_deaths%", String.valueOf(tode));	
		Score10 = Score10.replace("%knockffa_kdr%", String.valueOf(kc.replace("Infinity", "0").replace("NaN", "0")));	
		Score10 = Score10.replace("%knockffa_onlineplayers%", String.valueOf(Bukkit.getOnlinePlayers().size()));	
		
		Score9 = Score9.replace("%knockffa_kills%", String.valueOf(kills));	
		Score9 = Score9.replace("%knockffa_deaths%", String.valueOf(tode));	
		Score9 = Score9.replace("%knockffa_kdr%", String.valueOf(kc.replace("Infinity", "0").replace("NaN", "0")));	
		Score9 = Score9.replace("%knockffa_onlineplayers%", String.valueOf(Bukkit.getOnlinePlayers().size()));	
		
		Score8 = Score8.replace("%knockffa_kills%", String.valueOf(kills));	
		Score8 = Score8.replace("%knockffa_deaths%", String.valueOf(tode));	
		Score8 = Score8.replace("%knockffa_kdr%", String.valueOf(kc.replace("Infinity", "0").replace("NaN", "0")));	
		Score8 = Score8.replace("%knockffa_onlineplayers%", String.valueOf(Bukkit.getOnlinePlayers().size()));	
		
		Score7 = Score7.replace("%knockffa_kills%", String.valueOf(kills));	
		Score7 = Score7.replace("%knockffa_deaths%", String.valueOf(tode));	
		Score7 = Score7.replace("%knockffa_kdr%", String.valueOf(kc.replace("Infinity", "0").replace("NaN", "0")));	
		Score7 = Score7.replace("%knockffa_onlineplayers%", String.valueOf(Bukkit.getOnlinePlayers().size()));	
		
		Score6 = Score6.replace("%knockffa_kills%", String.valueOf(kills));	
		Score6 = Score6.replace("%knockffa_deaths%", String.valueOf(tode));
		Score6 = Score6.replace("%knockffa_kdr%", String.valueOf(kc.replace("Infinity", "0").replace("NaN", "0")));	
		Score6 = Score6.replace("%knockffa_onlineplayers%", String.valueOf(Bukkit.getOnlinePlayers().size()));	
		Score3 = Score3.replace("%knockffa_deaths%", String.valueOf(tode));
		
		Score5 = Score5.replace("%knockffa_kdr%", String.valueOf(kc.replace("Infinity", "0").replace("NaN", "0")));
		Score5 = Score5.replace("%knockffa_onlineplayers%", String.valueOf(Bukkit.getOnlinePlayers().size()));	
		Score5 = Score5.replace("%knockffa_kills%", String.valueOf(kills));	
		Score5 = Score5.replace("%knockffa_deaths%", String.valueOf(tode));
		
		Score4 = Score4.replace("%knockffa_deaths%", String.valueOf(tode));
		Score4 = Score4.replace("%knockffa_kdr%", String.valueOf(kc.replace("Infinity", "0").replace("NaN", "0")));
		Score4 = Score4.replace("%knockffa_onlineplayers%", String.valueOf(Bukkit.getOnlinePlayers().size()));	
		Score4 = Score4.replace("%knockffa_kills%", String.valueOf(kills));	
		
		Score3 = Score3.replace("%knockffa_kdr%", String.valueOf(kc.replace("Infinity", "0").replace("NaN", "0")));
		Score3 = Score3.replace("%knockffa_onlineplayers%", String.valueOf(Bukkit.getOnlinePlayers().size()));	
		Score3 = Score3.replace("%knockffa_kills%", String.valueOf(kills));	
		Score3 = Score3.replace("%knockffa_deaths%", String.valueOf(tode));
		
		Score2 = Score2.replace("%knockffa_onlineplayers%", String.valueOf(Bukkit.getOnlinePlayers().size()));
		Score2 = Score2.replace("%knockffa_deaths%", String.valueOf(tode));
		Score2 = Score2.replace("%knockffa_kills%", String.valueOf(kills));	
		Score2 = Score2.replace("%knockffa_kdr%", String.valueOf(kc.replace("Infinity", "0").replace("NaN", "0")));
		
		Score1 = Score1.replace("%knockffa_onlineplayers%", String.valueOf(Bukkit.getOnlinePlayers().size()));
		Score1 = Score1.replace("%knockffa_deaths%", String.valueOf(tode));
		Score1 = Score1.replace("%knockffa_kills%", String.valueOf(kills));	
		Score1 = Score1.replace("%knockffa_kdr%", String.valueOf(kc.replace("Infinity", "0").replace("NaN", "0")));
		
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName(scoreboard.scoreboardConfig.getString("Scoreboard.Score_Name"));
		o.getScore(Score11).setScore(11);
		o.getScore(Score10).setScore(10);
		o.getScore(Score9).setScore(9);
		o.getScore(Score8).setScore(8);
		o.getScore(Score7).setScore(7);
		o.getScore(Score6).setScore(6);
		o.getScore(Score5).setScore(5);
		o.getScore(Score4).setScore(4);
		o.getScore(Score3).setScore(3);
		o.getScore(Score2).setScore(2);
		o.getScore(Score1).setScore(1);
		p.setScoreboard(board);
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
		Player p = (Player) e.getPlayer();
		p.removePotionEffect(PotionEffectType.JUMP);
		p.removePotionEffect(PotionEffectType.HEAL);
		p.removePotionEffect(PotionEffectType.ABSORPTION);
		String msg = messages.messageConfig.getString("MSGConfig.LOBBY_QUIT");
		msg = msg.replace("%Player%", p.getName());
		e.setQuitMessage(msg);
		new BukkitRunnable() {
			
			@Override
			public void run() {
				for(Player all : Bukkit.getOnlinePlayers()) {
				setScoreboard(all);
			}
			}
		}.runTaskLater(Main.getInstance(), 1);
		
	}
}
	