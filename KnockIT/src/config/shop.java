package config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;



public class shop {

	public static File ShopFile = new File("plugins/KnockbackFFA", "Shop.yml");
	public static FileConfiguration ShopConfig = YamlConfiguration.loadConfiguration(ShopFile);
	
	
	public static void save() throws IOException {
		ShopConfig.save(ShopFile);

	}
	public static void loadConfig() throws IOException {
		ShopConfig.addDefault("Shop.VillagerName", "§e§lShop");
		ShopConfig.addDefault("Shop.Money_Status", "§7Du besitzt nun über §e§l%coins% §7Coin(s)");
		ShopConfig.addDefault("Shop.NotEnough_Money", "§cDu besitzt nicht über genügend Coins §7(Zurzeit: %coins%)");
		//SHOP-RÜSTUNGEN
		ShopConfig.addDefault("Shop.Rüstungen.Name", "§e§lRüstungen");
		ShopConfig.addDefault("Shop.Rüstungen.Farbe.ALREADY_TAKEN", "§cDu hast die Rüstung bereits ausgewählt");
		ShopConfig.addDefault("Shop.Rüstungen.Farbe.Lila.Name", "§d§lLila");
		ShopConfig.addDefault("Shop.Rüstungen.Farbe.Lila.TAKEN", "§7Du hast die §d§lLila Rüstung §7ausgewählt");
		ShopConfig.addDefault("Shop.Rüstungen.Farbe.Weiß.Name", "§f§lWeiß");
		ShopConfig.addDefault("Shop.Rüstungen.Farbe.Weiß.TAKEN", "§7Du hast die §f§lWeiße Rüstung §7ausgewählt");
		ShopConfig.addDefault("Shop.Rüstungen.Farbe.Blau.Name", "§3§lBlau");
		ShopConfig.addDefault("Shop.Rüstungen.Farbe.Blau.TAKEN", "§7Du hast die §3§lBlaue Rüstung §7ausgewählt");
		ShopConfig.addDefault("Shop.Rüstungen.Farbe.Rot.Name", "§c§lRot");
		ShopConfig.addDefault("Shop.Rüstungen.Farbe.Rot.TAKEN", "§7Du hast die §c§lRote Rüstung §7ausgewählt");
		//SHOP-BLÖCKE
		ShopConfig.addDefault("Shop.Blöcke.Name", "§6§lBlöcke");
		ShopConfig.addDefault("Shop.Blöcke.ALREADY_TAKEN", "§cDu hast die Blöcke bereits ausgewählt");
		ShopConfig.addDefault("Shop.Blöcke.SANDSTONE_AnimationSeconds", 10);
		ShopConfig.addDefault("Shop.Blöcke.COBWEB_AnimationSeconds", 10);
		ShopConfig.addDefault("Shop.Blöcke.PRESSUREPLATE_AnimationSeconds", 10);
		ShopConfig.addDefault("Shop.Blöcke.Block1.Name", "§a§lBlock1");
		ShopConfig.addDefault("Shop.Blöcke.Block1.Coins", 0);
		ShopConfig.addDefault("Shop.Blöcke.Block1.AnimationSeconds", 10);
		ShopConfig.addDefault("Shop.Blöcke.Block2.Name", "§9§lBlock2");
		ShopConfig.addDefault("Shop.Blöcke.Block2.Coins", 0);
		ShopConfig.addDefault("Shop.Blöcke.Block2.AnimationSeconds", 10);
		ShopConfig.addDefault("Shop.Blöcke.Block3.Name", "§6§lBlock3");
		ShopConfig.addDefault("Shop.Blöcke.Block3.Coins", 0);
		ShopConfig.addDefault("Shop.Blöcke.Block3.AnimationSeconds", 10);
		//SHOP-KITS
		ShopConfig.addDefault("Shop.Kits.Name", "§e§lSPECIALITEMS");
		ShopConfig.addDefault("Shop.Kits.ALREADY_TAKEN", "§cDu hast das Item bereits gekauft");
		ShopConfig.addDefault("Shop.Kits.Kit1.Name", "§f§lWitherArrow");
		ShopConfig.addDefault("Shop.Kits.Kit1.Coins", 0);
		ShopConfig.addDefault("Shop.Kits.Kit1.Cooldown", 5);
		ShopConfig.addDefault("Shop.Kits.Kit2.Name", "§3§lMine");
		ShopConfig.addDefault("Shop.Kits.Kit2.Coins", 0);
		ShopConfig.addDefault("Shop.Kits.Kit2.Cooldown", 5);
		ShopConfig.addDefault("Shop.Kits.Kit3.Name", "§a§lRettungsplattform");
		ShopConfig.addDefault("Shop.Kits.Kit3.Coins", 0);
		ShopConfig.addDefault("Shop.Kits.Kit3.Cooldown", 5);
		ShopConfig.options().copyDefaults(true);
		save();
		
	}

	
	

	

}
