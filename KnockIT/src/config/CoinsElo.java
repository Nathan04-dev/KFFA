package config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;



public class CoinsElo {

	public static File CoinsEloFile = new File("plugins/KnockbackFFA", "CoinsElo.yml");
	public static FileConfiguration CoinsEloConfig = YamlConfiguration.loadConfiguration(CoinsEloFile);
	
	
	public static void save() throws IOException {
		CoinsEloConfig.save(CoinsEloFile);

	}
	public static void loadConfig() throws IOException {
		CoinsEloConfig.addDefault("CoinsElo.EloPerPlayerKill", 100);
		CoinsEloConfig.addDefault("CoinsElo.EloDeadPlayer", 30);
		CoinsEloConfig.addDefault("CoinsElo.CoinsPerPlayerKill", 50);
		CoinsEloConfig.addDefault("CoinsElo.CoinsDeadPlayer", 50);
		CoinsEloConfig.addDefault("CoinsElo.CoinsDeadPlayerByPlayerMessage", "§7§l+§e§l%Coins% Coins");
		CoinsEloConfig.addDefault("CoinsElo.CoinsDeadPlayerMessage", "§7§l-§e§l%Coins% Coins");
		CoinsEloConfig.options().copyDefaults(true);
		save();
	}


	

}
