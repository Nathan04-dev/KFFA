package at.nathi.config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import at.nathi.main.Main;

public class ConfigFile {
	
	public void setStandard() {
		FileConfiguration M = getFileConfiguration();
		
		Main.getInstance().getConfig().options().copyDefaults(true);
		Main.getInstance().getConfig().addDefault("SB_Kills", "");
		Main.getInstance().getConfig().addDefault("SB_Deaths", "");
		Main.getInstance().getConfig().addDefault("SB_KD", "");
		Main.getInstance().getConfig().addDefault("SB_IP", "");
		try {
			Main.getInstance().getConfig().save(getFile());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	private File getFile() {
		return new File("plugins/BuildUHC", "config.yml");

	}
	private FileConfiguration getFileConfiguration() {
		return YamlConfiguration.loadConfiguration(getFile());
	}
	public void readData() {
	
		
		Config.SB_Kills = Main.getInstance().getConfig().getString("SB_Kills");
		Config.SB_Tode = Main.getInstance().getConfig().getString("SB_Tode");
		Config.SB_KD = Main.getInstance().getConfig().getString("SB_KD");
		Config.SB_IP= Main.getInstance().getConfig().getString("SB_IP");
	}
}
