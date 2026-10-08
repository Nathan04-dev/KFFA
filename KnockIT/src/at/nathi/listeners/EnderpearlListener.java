package at.nathi.listeners;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import at.nathi.main.Main;


public class EnderpearlListener implements Listener {
	
	private HashMap<Player, EnderPearl> enderpearls = new HashMap<>();
	public EnderpearlListener(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		ItemStack enderperle = new ItemStack(Material.ENDER_PEARL);
		ItemMeta epmeta = enderperle.getItemMeta();
		epmeta.setDisplayName("§6Enderperle");
		enderperle.setItemMeta(epmeta);
		if(e.getItem() != null && e.getItem().isSimilar(enderperle)) {
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				EnderPearl enderPearl = p.launchProjectile(EnderPearl.class);
				enderPearl.setPassenger(p);
				enderpearls.put(p, enderPearl);
			}
		}
		}

	@EventHandler
	public void onVehicleExit(VehicleExitEvent e) {

		if(e.getExited() instanceof Player) {
			if(enderpearls.containsKey(e.getExited())) {
				enderpearls.get(e.getExited()).remove();
			}
		}
	}
}