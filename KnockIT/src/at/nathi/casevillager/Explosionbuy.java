package at.nathi.casevillager;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import at.nathi.main.Main;
import at.nathi.mysql.SQLStats;
import config.shop;

public class Explosionbuy {
	
	public static void ExplosionMethode(Player p) {
		

			
			int pcoins = SQLStats.getCoins(p.getUniqueId().toString());
			int kcoins = shop.ShopConfig.getInt("Shop.Kits.Kit1.Coins");
			int coinrest = pcoins - kcoins;
			ItemStack arrow = new ItemStack(Material.ARROW);
			ItemMeta explosionmeta = arrow.getItemMeta();
			if(p.getInventory().contains(Material.ARROW, 0)) {
			if(SQLStats.getCoins(p.getUniqueId().toString()) >= shop.ShopConfig.getInt("Shop.Kits.Kit1.Coins")) {
			SQLStats.removeCoins(p.getUniqueId().toString(), kcoins);
			String fertigkauf = shop.ShopConfig.getString("Shop.Money_Status");
			fertigkauf = fertigkauf.replace("%coins%", String.valueOf(coinrest));
			p.sendMessage(Main.prefix + fertigkauf);
			explosionmeta.setDisplayName(shop.ShopConfig.getString("Shop.Kits.Kit1.Name"));
			arrow.setItemMeta(explosionmeta);
			p.getInventory().addItem(arrow);
			p.closeInventory();
			p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
			p.setGameMode(GameMode.SURVIVAL);
			p.setLevel(0);
	
			} else {
				
				String abbruchkauf = shop.ShopConfig.getString("Shop.NotEnough_Money");
				abbruchkauf = abbruchkauf.replace("%coins%", String.valueOf(SQLStats.getCoins(p.getUniqueId().toString())));
				p.sendMessage(Main.prefix + abbruchkauf);
				p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 15, 15);
			}
			
			}
	}
	


}
