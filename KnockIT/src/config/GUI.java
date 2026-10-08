package config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;



public class GUI {

	public static File GuiFile = new File("plugins/KnockbackFFA", "GUI.yml");
	public static FileConfiguration GUIConfig = YamlConfiguration.loadConfiguration(GuiFile);
	
	
	public static void save() throws IOException {
		GUIConfig.save(GuiFile);

	}
	public static void loadConfig() throws IOException {
		GUIConfig.addDefault("StatsGUI.Name", "§6§l%player%'s §6§lStats");
		GUIConfig.addDefault("StatsGUI.Kills", "§6§lKills: §7%knockffa_kills%");
		GUIConfig.addDefault("StatsGUI.Tode", "§6§lTode: §7§7%knockffa_deaths%");
		GUIConfig.addDefault("StatsGUI.Kdr", "§6§lKD: §7%knockffa_kdr%");
		GUIConfig.addDefault("StatsGUI.Elo", "§6§lElo: §7%knockffa_elo%");
		GUIConfig.addDefault("StatsGUI.EloRank", "%knockffa_elorank%");
		
		
		GUIConfig.addDefault("MapsGUI.Name", "§e§lMaps");
		GUIConfig.addDefault("MapsGUI.Map1_Select", "§7Es wird nun §e§l%Map1_Name% §7gespielt");
		GUIConfig.addDefault("MapsGUI.Map2_Select", "§7Es wird nun §e§l%Map2_Name% §7gespielt");
		GUIConfig.addDefault("MapsGUI.Map3_Select", "§7Es wird nun §e§l%Map3_Name% §7gespielt");
		
		GUIConfig.addDefault("EffectsGUI.Name", "§e§lEffects");
		GUIConfig.addDefault("EffectsGUI.Aktivieren", "§a§lRandomEffekte Aktivieren");
		GUIConfig.addDefault("EffectsGUI.Deaktivieren", "§c§lRandomEffekte Deaktivieren");
		GUIConfig.addDefault("EffectsGUI.AktiviertMessage", "§7Random Effekte §a§laktiviert");
		GUIConfig.addDefault("EffectsGUI.DeaktiviertMessage", "§§7Random Effekte §c§ldeaktiviert");
		
		GUIConfig.options().copyDefaults(true);
		save();
	}


	

}
