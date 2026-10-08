package config;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import at.nathi.mysql.SQLStats;
import at.nathi.mysql.SQLTop10;


public class SQLRank {

	public static File RankFile = new File("plugins/KnockbackFFA", "ranks.yml");
	public static FileConfiguration Config = YamlConfiguration.loadConfiguration(RankFile);
	
	public static void save() throws IOException {
		Config.save(RankFile);

	}
	

	public static void setRank(Player p) throws IOException {





			 Config.set(p.getName() + ".Elo:", SQLStats.getElo(p.getUniqueId().toString()));
				Config.set(p.getName() + ".Rank", 2);
				save();



		 
	}
	

}
