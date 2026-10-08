package at.nathi.listeners;



import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import at.nathi.main.Main;

@SuppressWarnings("deprecation")
public class BasicListeners implements Listener{


	public BasicListeners(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
	}

	
	
	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent e) {
	    if (e.getDamager() instanceof Player) {
		Player p = (Player) e.getDamager();
		
			if(p.getLocation().getBlockY() >= Main.getInstance().getConfig().getDouble("builduhc.spawns.spawnheight.Y")) {
					e.setCancelled(true);
					
				} else {
					e.setCancelled(false);
		
				}
			}
	}
	
	@EventHandler()
	public void onPlayerMove(PlayerMoveEvent e) {

		if(e.getPlayer().getFoodLevel() != 20) {
			e.getPlayer().setFoodLevel(20);
		}
		
		
	}

	
	@EventHandler()
	public static void onRespawn(PlayerRespawnEvent e) {
		   Player p = e.getPlayer();
		   Location spawn = p.getWorld().getSpawnLocation();
		   p.setHealth(20);

		   spawn.setX(Main.getInstance().getConfig().getDouble("builduhc.spawns.lobby.X"));
		   spawn.setY(Main.getInstance().getConfig().getDouble("builduhc.spawns.lobby.Y"));
		   spawn.setZ(Main.getInstance().getConfig().getDouble("builduhc.spawns.lobby.Z"));
		   e.setRespawnLocation(spawn);
			p.setHealth(20);

		   
		
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e){
		
		if(!(e.getEntity() instanceof Player)){
			return;
		}else{
			if(e.getCause().equals(DamageCause.FALL)){
				e.setCancelled(true);
			}
		}
	
	
}

	@EventHandler
	public void onDamage2(EntityDamageEvent e){
		
		Player p = (Player) e.getEntity();
		if(!(e.getEntity() instanceof Player)){
			return;
			
		}else{
	
			if(e.getCause().equals(DamageCause.VOID)){
				e.setCancelled(true);
				ItemStack sand = new ItemStack(Material.SANDSTONE);
			
		double x = (double) Main.getInstance().getConfig().getDouble("builduhc.spawns.lobby.X");
		double y = (double) Main.getInstance().getConfig().getDouble("builduhc.spawns.lobby.Y");
		double z = (double) Main.getInstance().getConfig().getDouble("builduhc.spawns.lobby.Z");
		String w = (String) Main.getInstance().getConfig().getString("builduhc.spawns.lobby.World");
		float yaw = (float) Main.getInstance().getConfig().getDouble("builduhc.spawns.lobby.Yaw");
		float pitch = (float) Main.getInstance().getConfig().getDouble("builduhc.spawns.lobby.Pitch");
		World world = Bukkit.getWorld(w);
		
		Location loc = new Location(world, x, y, z, yaw, pitch);

		p.teleport(loc);
		p.playSound(p.getLocation(), Sound.NOTE_PLING, 15, 15);
		p.setHealth(20);
		p.setFoodLevel(20); 
		sand.setAmount(32);
		
		

		new BukkitRunnable() {
			
			@Override
			public void run() {
			for(Player all : Bukkit.getOnlinePlayers()) {
				JoinAndQuitListener.setScoreboard(all);
			}
			}
		}.runTaskLater(Main.getInstance(), 1);

		
		
		String killed = e.getEntity().getName();

	
		for(Player all : Bukkit.getOnlinePlayers()) {
		all.sendMessage("§7Der Spieler §d" + killed +" §7ist gestorben");
		p.setHealth(20);


		}

			}
	
		
		}


	}


	@EventHandler
	public void onPlayerDeath (PlayerDeathEvent e) {
		

	
		e.setKeepInventory(true);
		String getötet = e.getEntity().getName();
		String töter = e.getEntity().getKiller().getName();
		e.setDeathMessage("§d§l" + getötet +  " §7wurde von §d§l" + töter + " §7getötet");
		

			}
		
		

	

	
	@EventHandler
	public void onPlayerDrop(PlayerDropItemEvent e) {
	
		e.setCancelled(true);
		
		
	}


	
	@EventHandler
	public void onEntitySpawn(EntitySpawnEvent e) {
		e.setCancelled(true);
		if(e.getEntityType()== EntityType.VILLAGER) {
			e.setCancelled(false);
		}
	}
	
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
		
		e.setCancelled(false);

		
	}
	

	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent e) {
		if(e.getCreatureType()== CreatureType.ZOMBIE) {

			e.setCancelled(true);
		
		}
		if(e.getCreatureType()== CreatureType.CREEPER) {
			e.setCancelled(true);
		}
		if(e.getCreatureType()== CreatureType.SPIDER) {
			e.setCancelled(true);
		}
		if(e.getCreatureType()== CreatureType.SKELETON) {
			e.setCancelled(true);
		}
		if(e.getCreatureType()== CreatureType.ENDERMAN) {
			e.setCancelled(true);
		}
		if(e.getCreatureType()== CreatureType.CAVE_SPIDER) {
			e.setCancelled(true);
		}
		

		
		
	}
	@EventHandler
	public void onPickupItem(PlayerPickupItemEvent e) {
		Player p = e.getPlayer();
		if(p.isOp()) {
			e.setCancelled(false);
		} else
			e.setCancelled(true);
}
	

	
	@EventHandler
	public void onWeatherChange(WeatherChangeEvent e) {
		e.setCancelled(true);
		
	}
	
	@EventHandler
	public void onAchievementAward(PlayerAchievementAwardedEvent e) {
		e.setCancelled(true);
	}
	@EventHandler
	public void onEntityDamage(BlockPlaceEvent e) {
	    if (e.getPlayer() instanceof Player) {
		Player p = (Player) e.getPlayer();
	
			if(p.getLocation().getBlockY() >= Main.getInstance().getConfig().getDouble("builduhc.spawns.spawnheight.Y")) {
					e.setCancelled(true);
					Bukkit.getScheduler().cancelTask(BlockPlaceListener.taskID);
					
				} else {
					e.setCancelled(false);
				}
			}
	}
	@EventHandler
	public void onBlockFromTo(BlockFromToEvent event) {
	int id = event.getBlock().getTypeId();
	if(id == 8 || id == 9) {
	event.setCancelled(true);
	}
	}

	

	


}

