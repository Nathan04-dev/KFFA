package config;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import at.nathi.main.Main;

public class locations {
	
	public static int taskID1;
	public static int taskID2;
	public static int taskID3;
	public static int mapseconds1 = 20;
	public static int mapseconds2 = 900;
	public static int mapseconds3 = 900;
	public static File locationsfile = new File("plugins/KnockbackFFA", "locations.yml");
	public static FileConfiguration LocationConfig = YamlConfiguration.loadConfiguration(locationsfile);
	
	
	public static void save() throws IOException {
		LocationConfig.save(locationsfile);

	}
	public static void loadConfig() throws IOException {
		LocationConfig.options().copyDefaults(true);
		save();
	}
	public static void startloc1() {
		
		

		Bukkit.getScheduler().cancelTask(taskID3);
		taskID1 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				mapseconds1--;
				switch(mapseconds1) {
				case 19:
				for(Player all : Bukkit.getOnlinePlayers()) {
				all.closeInventory();
				all.sendMessage(Main.prefix + "§7Es wird nun §e§l" + LocationConfig.getString("Map1.Name") + " §7gespielt");
				all.sendMessage(Main.prefix + "§7Die Map wird in §e§l15 Minuten §7gewechselt");
				all.sendTitle(Main.prefix, null, 20, 20, 20);
				all.playSound(all.getLocation(), Sound.BLOCK_NOTE_BLOCK_SNARE, 15, 15);
				all.playSound(all.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 15, 15);
				}
				break;
				case 18:
					Bukkit.broadcastMessage(Main.prefix + "§7Die Map wird in §e§l8 §7Minuten gewechselt");
					break;
				case 16:
					Bukkit.broadcastMessage(Main.prefix + "§7Die Map wird in §e§l5 §7Minuten gewechselt");
					break;
				case 15:
					Bukkit.broadcastMessage(Main.prefix + "§7Die Map wird in §e§l3 §7Minuten gewechselt");
					break;
				case 14:
					Bukkit.broadcastMessage(Main.prefix + "§7Die Map wird in §e§l2 §7Minuten gewechselt");
					break;
				case 13:
					Bukkit.broadcastMessage(Main.prefix + "§7Die Map wird in §e§l1 §7Minute gewechselt");
					break;
				
				case 10: case 8: case 7: case 6: case 5: case 4: case 3: case 2: 
					Bukkit.broadcastMessage(Main.prefix + "§7Die Map wird in §e§l" +mapseconds1+ " §7Seknuden gewechselt");
				break;
				case 1:
					Bukkit.broadcastMessage(Main.prefix + "§7Die Map wird in §e§l" +mapseconds1+ " §7Sekunde gewechselt");
					break;
				case 0:
					
					startloc2();
					
					break;
					default:
						break;
			}
			}
		}, 0, 20);
	

}
public static void startloc2() {
double x2 = (double) locations.LocationConfig.getDouble("Map2.X");
double y2 = (double) locations.LocationConfig.getDouble("Map2.Y");
double z2 = (double) locations.LocationConfig.getDouble("Map2.Z");
String w2 = (String) locations.LocationConfig.getString("Map2.World");
float yaw2 = (float) locations.LocationConfig.getDouble("Map2.Yaw");
float pitch2 = (float) locations.LocationConfig.getDouble("Map2.Pitch");
World world2 = Bukkit.getWorld(w2);
Location loc2 = new Location(world2, x2, y2, z2, yaw2, pitch2);
Bukkit.getScheduler().cancelTask(taskID1);
taskID2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
	@Override
	public void run() {
		mapseconds2--;
		switch(mapseconds2) {
		case 899:
			for(Player all : Bukkit.getOnlinePlayers()) {
		all.closeInventory();
		all.teleport(loc2);
		all.sendMessage(Main.prefix + "§7Es wird nun §e§l" + LocationConfig.getString("Map2.Name") + " §7gespielt");
		all.sendMessage(Main.prefix + "§7Die Map wird in §e§l15 Minuten §7gewechselt");
		all.sendTitle(Main.prefix, null, 20, 20, 20);
		all.playSound(all.getLocation(), Sound.BLOCK_NOTE_BLOCK_SNARE, 15, 15);
		all.playSound(all.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 15, 15);
			}
		break;
		case 480:
			Bukkit.broadcastMessage(Main.prefix + "§7Die Map wird in §e§l8 §7Minuten gewechselt");
			break;
		case 300:
			Bukkit.broadcastMessage(Main.prefix + "§7Die Map wird in §e§l5 §7Minuten gewechselt");
			break;
		case 180:
			Bukkit.broadcastMessage(Main.prefix + "§7Die Map wird in §e§l3 §7Minuten gewechselt");
			break;
		case 120:
			Bukkit.broadcastMessage(Main.prefix + "§7Die Map wird in §e§l2 §7Minuten gewechselt");
			break;
		case 60:
			Bukkit.broadcastMessage(Main.prefix + "§7Die Map wird in §e§l1 §7Minute gewechselt");
			break;
		
		case 10: case 8: case 7: case 6: case 5: case 4: case 3: case 2: 
			Bukkit.broadcastMessage(Main.prefix + "§7Die Map wird in §e§l" +mapseconds2+ " §7Seknuden gewechselt");
		break;
		case 1:
			Bukkit.broadcastMessage(Main.prefix + "§7Die Map wird in §e§l" +mapseconds2+ " §7Sekunde gewechselt");
			break;
		case 0:
			startloc3();
			break;
			default:
				break;
	}
	}
}, 0, 20);
}
public static void startloc3() {

double x3 = (double) locations.LocationConfig.getDouble("Map3.X");
double y3 = (double) locations.LocationConfig.getDouble("Map3.Y");
double z3 = (double) locations.LocationConfig.getDouble("Map3.Z");
String w3 = (String) locations.LocationConfig.getString("Map3.World");
float yaw3 = (float) locations.LocationConfig.getDouble("Map3.Yaw");
float pitch3 = (float) locations.LocationConfig.getDouble("Map3.Pitch");
World world3 = Bukkit.getWorld(w3);
Bukkit.getScheduler().cancelTask(taskID2);
Location loc3 = new Location(world3, x3, y3, z3, yaw3, pitch3);
taskID3 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
	@Override
	public void run() {
		mapseconds3--;
		switch(mapseconds3) {
		case 899:
			for(Player all : Bukkit.getOnlinePlayers()) {
		all.closeInventory();
		all.teleport(loc3);
		all.sendMessage(Main.prefix + "§7Es wird nun §e§l" + LocationConfig.getString("Map3.Name") + " §7gespielt");
		all.sendMessage(Main.prefix + "§7Die Map wird in §e§l15 Minuten §7gewechselt");
		all.sendTitle(Main.prefix, null, 20, 20, 20);
		all.playSound(all.getLocation(), Sound.BLOCK_NOTE_BLOCK_SNARE, 15, 15);
		all.playSound(all.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 15, 15);
			}
		break;
		case 480:
			Bukkit.broadcastMessage(Main.prefix + "§7Die Map wird in §e§l8 Minuten §7gewechselt");
			break;
		case 300:
			Bukkit.broadcastMessage(Main.prefix + "§7Die Map wird in §e§l5 Minuten §7gewechselt");
			break;
		case 180:
			Bukkit.broadcastMessage(Main.prefix + "§7Die Map wird in §e§l3 Minuten §7gewechselt");
			break;
		case 120:
			Bukkit.broadcastMessage(Main.prefix + "§7Die Map wird in §e§l2 Minuten §7gewechselt");
			break;
		case 60:
			Bukkit.broadcastMessage(Main.prefix + "§7Die Map wird in §e§l1 Minute §7gewechselt");
			break;
		
		case 10: case 8: case 7: case 6: case 5: case 4: case 3: case 2: 
			Bukkit.broadcastMessage(Main.prefix + "§7Die Map wird in §e§l" +mapseconds3+ " §7Seknuden gewechselt");
		break;
		case 1:
			Bukkit.broadcastMessage(Main.prefix + "§7Die Map wird in §e§l" +mapseconds3+ " §7Sekunde gewechselt");
			break;
		case 0:
		
				startloc1();
			
			break;
			default:
				break;
	}
	}
}, 0, 20);
}
}
