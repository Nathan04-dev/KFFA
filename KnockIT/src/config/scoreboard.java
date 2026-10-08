package config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class scoreboard {
	
	public static File scoreboardFile = new File("plugins/KnockbackFFA", "scoreboard.yml");
	public static FileConfiguration scoreboardConfig = YamlConfiguration.loadConfiguration(scoreboardFile);
	
	
	public static void save() throws IOException {
		scoreboardConfig.save(scoreboardFile);

	}
	public static void loadConfig() throws IOException {
		scoreboardConfig.addDefault("Scoreboard.Score_Name", "§7§l✘ §e§lKnock§6§lFFA §7§l✘");
		scoreboardConfig.addDefault("Scoreboard.Score_11", "§0");
		scoreboardConfig.addDefault("Scoreboard.Score_10", "§7➠Kills:");
		scoreboardConfig.addDefault("Scoreboard.Score_9", "§e➟ %knockffa_kills%");
		scoreboardConfig.addDefault("Scoreboard.Score_8", "§p");
		scoreboardConfig.addDefault("Scoreboard.Score_7", "§7➠Tode:");
		scoreboardConfig.addDefault("Scoreboard.Score_6", "§a§e➟ %knockffa_deaths%");
		scoreboardConfig.addDefault("Scoreboard.Score_5", "§a");
		scoreboardConfig.addDefault("Scoreboard.Score_4", "§7➠KD:");
		scoreboardConfig.addDefault("Scoreboard.Score_3", "§e➟ %knockffa_kdr%");
		scoreboardConfig.addDefault("Scoreboard.Score_2", "§b");
		scoreboardConfig.addDefault("Scoreboard.Score_1", "§7➠ Spieler: §e%knockffa_onlineplayers%");
		scoreboardConfig.options().copyDefaults(true);
		save();
	}
	

	

}
