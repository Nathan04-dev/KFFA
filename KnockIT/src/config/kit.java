package config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;



public class kit {

	public static File KitFile = new File("plugins/KnockbackFFA", "Kit.yml");
	public static FileConfiguration KitConfig = YamlConfiguration.loadConfiguration(KitFile);
	
	
	public static void save() throws IOException {
		KitConfig.save(KitFile);

	}
	public static void loadConfig() throws IOException {
		KitConfig.addDefault("KIT.SWORD", "§6Holzschwert");
		KitConfig.addDefault("KIT.BOW", "§6Bogen");
		KitConfig.addDefault("KIT.COBWEB", "§6Spinnennetz");
		KitConfig.addDefault("KIT.BLÖCKE", "§6Sandsteins");
		KitConfig.addDefault("KIT.CHESTPLATE", "§6Leder Rüstung");
		KitConfig.addDefault("KIT.ARROW", "§6Pfeile");
		KitConfig.addDefault("KIT.ENDERPEARL", "§6Enderperle");
		KitConfig.addDefault("KIT.KNOCKSTICK", "§6Knockstick");
		KitConfig.options().copyDefaults(true);
		save();
	}


	

}
