package at.nathi.villager;



import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;




public class ShopSpecify {
	
	
	


	public ShopSpecify(Location loc, Player p) {
			Villager tank = (Villager) p.getWorld().spawn(p.getLocation(), Villager.class);
			tank.setCustomName(ShopManager.kitm);
			tank.setCustomNameVisible(false);
			tank.setInvulnerable(true);
			tank.setAI(false);
			
	
			


	//	shop.setCustomNameVisible(true);
		//shop.setCustomName(VillagerHandler.kitm);
	//	shop.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 356000, 1000000000));
	
		
		
		
	}
	


	
	
	
}
