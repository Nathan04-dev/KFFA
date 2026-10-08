
package at.nathi.listeners;


import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent; 
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;


import at.nathi.main.Main;
import at.nathi.mysql.SQLStats;
import config.CoinsElo;
import config.SQLRank;
import config.kit;
import config.locations;
import config.messages;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
public class BasicListeners implements Listener{
	
	public static int taskID;
	public static int seconds = 10;
	public static int arrowtaskID;
	public static int arrowseconds = 16;
	public BasicListeners(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
	}

	
	
	@EventHandler()
	public static void onRespawn(PlayerRespawnEvent e) {
		   Player p = e.getPlayer();
			double x = (double) locations.LocationConfig.getDouble("Map1.X");
			double y = (double) locations.LocationConfig.getDouble("Map1.Y");
			double z = (double) locations.LocationConfig.getDouble("Map1.Z");
			String w = (String) locations.LocationConfig.getString("Map1.World");
			float yaw = (float) locations.LocationConfig.getDouble("Map1.Yaw");
			float pitch = (float) locations.LocationConfig.getDouble("Map1.Pitch");
			World world = Bukkit.getWorld(w);
			
			Location loc = new Location(world, x, y, z, yaw, pitch);
		
			loc.setX(x);
			loc.setY(y);
			loc.setZ(z);
		   e.setRespawnLocation(loc);
		   p.setHealth(20);  
		   p.setFoodLevel(20);
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
	public void onPlayerDeath (PlayerDeathEvent e) {
		
		Player p = e.getEntity();
		if(e.getDeathMessage().contains("blew up")) {
			for(Player all: Bukkit.getOnlinePlayers()) {
			String death = messages.messageConfig.getString("MSGConfig.PlayerDeath");
			death = death.replace("%player%", p.getName());
			String coins = messages.messageConfig.getString("CoinsElo.CoinsDeadPlayerMessage");
			coins = coins.replace("%Coins%", String.valueOf(CoinsElo.CoinsEloConfig.getInt("CoinsElo.CoinsDeadPlayer")));
			all.sendMessage(death);
			p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Main.prefix + coins));
			SQLStats.removeCoins(p.getPlayer().getUniqueId().toString(), CoinsElo.CoinsEloConfig.getInt("CoinsElo.CoinsDeadPlayer"));
		
			return;
			}
		}

		if(p.getName() == p.getKiller().getName()) {
		if(e.getDeathMessage().contains("was blown up by")) {
			String death = messages.messageConfig.getString("MSGConfig.PlayerDeath");
			death = death.replace("%player%", p.getName());
			e.setDeathMessage(death);
			SQLStats.addTode(p.getUniqueId().toString(), 1);
			}
		} 	
		if(e.getDeathMessage().contains("pummeled")) {
			double x = (double) locations.LocationConfig.getDouble("Map1.X");
			double y = (double) locations.LocationConfig.getDouble("Map1.Y");
			double z = (double) locations.LocationConfig.getDouble("Map1.Z");
			String w = (String) locations.LocationConfig.getString("Map1.World");
			float yaw = (float) locations.LocationConfig.getDouble("Map1.Yaw");
			float pitch = (float) locations.LocationConfig.getDouble("Map1.Pitch");
			World world = Bukkit.getWorld(w);
			
			Location loc = new Location(world, x, y, z, yaw, pitch);
			p.teleport(loc);
			String DeathMessage = messages.messageConfig.getString("MSGConfig.PlayerDeathByPlayer");
			DeathMessage = DeathMessage.replace("%deadplayer%", p.getName());
			DeathMessage = DeathMessage.replace("%player%", e.getEntity().getKiller().getName());
		e.setDeathMessage(DeathMessage);
		
		String coins = messages.messageConfig.getString("CoinsElo.CoinsDeadPlayerMessage");
		coins = coins.replace("%Coins%", String.valueOf(CoinsElo.CoinsEloConfig.getInt("CoinsElo.CoinsDeadPlayer")));
		SQLStats.addCoins(p.getKiller().getUniqueId().toString(), CoinsElo.CoinsEloConfig.getInt("CoinsElo.CoinsPerPlayerKill"));
		p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Main.prefix + coins));
		}
		if(e.getDeathMessage().contains("died")) {
		String death = messages.messageConfig.getString("MSGConfig.PlayerDeath");
		death = death.replace("%player%", p.getName());
		e.setDeathMessage(death);
		}
	
	}
	
	@EventHandler
	public void onPlayerDeath2(PlayerDeathEvent e) {
		e.getDrops().clear();
	e.setKeepInventory(true);
		
	}
	
	@EventHandler
	public void onItemDrop(PlayerDropItemEvent e) {
	
			e.setCancelled(true);
	}	

	

	

	
	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent e) {

	if(e.getEntityType() == EntityType.ZOMBIE) {
		e.setCancelled(true);
	}
	if(e.getEntityType() == EntityType.CREEPER) {
		e.setCancelled(true);
	}
	if(e.getEntityType() == EntityType.ENDERMAN) {
		e.setCancelled(true);
	}
	if(e.getEntityType() == EntityType.SKELETON) {
		e.setCancelled(true);
	}
	if(e.getEntityType() == EntityType.SPIDER) {
		e.setCancelled(true);
	}
	if(e.getEntityType() == EntityType.SLIME) {
		e.setCancelled(true);
	}
	if(e.getEntityType() == EntityType.ZOMBIE_VILLAGER) {
		e.setCancelled(true);
	}
	if(e.getEntityType() == EntityType.ZOMBIE_HORSE) {
		e.setCancelled(true);
	}
	if(e.getEntityType() == EntityType.WITCH) {
		e.setCancelled(true);
	}
	if(e.getEntityType() == EntityType.ENDERMITE) {
		e.setCancelled(true);
	}

	}
	



	@EventHandler
	public void onPickupItem(EntityPickupItemEvent e) {
		Player p = (Player) e.getEntity();
		if(p.isOp() || p.hasPermission("knockffa.admin") || p.hasPermission("knockffa.moderator")) {
			e.setCancelled(false);
		} else
			e.setCancelled(true);
}
	@EventHandler
	public void onWeatherChange(WeatherChangeEvent e) {
		e.setCancelled(true);
		
	}
	
	@EventHandler
	public void onAchievementAward(PlayerAdvancementDoneEvent e) {
        Player player = e.getPlayer();
        Advancement advancement = e.getAdvancement();
     
        for (String criteria : advancement.getCriteria()) {
            player.getAdvancementProgress(advancement).revokeCriteria(criteria);
        }
	}
	
	@EventHandler
	public void onDeathMove(PlayerMoveEvent e) throws IOException {
		Player p = e.getPlayer();
		if(SQLStats.getElo(p.getUniqueId().toString()) >= 100) {
			SQLRank.setRank(p);
		}
			if(p.getLocation().getBlockY() <= locations.LocationConfig.getInt("Deathheight.Y")) {

			
				if(p.getLastDamageCause() != e.getPlayer()) {
					for(Player all: Bukkit.getOnlinePlayers()) {
						String death = messages.messageConfig.getString("MSGConfig.PlayerDeath");
						death = death.replace("%player%", p.getName());
						all.sendMessage(death);  
					}
				}
				
				
				double x = (double) locations.LocationConfig.getDouble("Map1.X");
				double y = (double) locations.LocationConfig.getDouble("Map1.Y");
				double z = (double) locations.LocationConfig.getDouble("Map1.Z");
				String w = (String) locations.LocationConfig.getString("Map1.World");
				float yaw = (float) locations.LocationConfig.getDouble("Map1.Yaw");
				float pitch = (float) locations.LocationConfig.getDouble("Map1.Pitch");
				World world = Bukkit.getWorld(w);
				
				Location loc = new Location(world, x, y, z, yaw, pitch);

				p.teleport(loc);
				SQLStats.addTode(p.getUniqueId().toString(), 1);
				SQLStats.removeCoins(p.getUniqueId().toString(), CoinsElo.CoinsEloConfig.getInt("CoinsElo.CoinsDeadPlayer"));
				SQLStats.removeElo(p.getUniqueId().toString(), CoinsElo.CoinsEloConfig.getInt("CoinsElo.EloDeadPlayer"));
				String coins = CoinsElo.CoinsEloConfig.getString("CoinsElo.CoinsDeadPlayerMessage");
				coins = coins.replace("%Coins%", String.valueOf(CoinsElo.CoinsEloConfig.getInt("CoinsElo.CoinsDeadPlayer")));
				p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Main.prefix + coins));
				KillStreakListener.killStreak.remove(p.getName());
		
				p.setHealth(20);
				p.setFoodLevel(20);
				ItemStack enderperle = new ItemStack(Material.ENDER_PEARL);
				ItemMeta epmeta = enderperle.getItemMeta();
				epmeta.setDisplayName("§6Enderperle");
				enderperle.setItemMeta(epmeta);
				p.getInventory().setItem(7, enderperle);
				p.getInventory().remove(Material.GOLDEN_APPLE);
				p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 3, 1);
				

				new BukkitRunnable() {
					
					@Override
					public void run() {
						JoinAndQuitListener.setScoreboard(p);
					
					}
				}.runTaskLater(Main.getInstance(), 1);
				
		}	
		
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent e) {
	    if (e.getDamager() instanceof Player) {
		Player p = (Player) e.getDamager();
	
			if(p.getLocation().getBlockY() >= locations.LocationConfig.getInt("Spawnheight.Y")) {
					e.setCancelled(true);
					
				} else {
					e.setCancelled(false);
		
				}
			}
	}
	
	@EventHandler
	public void onEntityDamage(BlockPlaceEvent e) {
	    if (e.getPlayer() instanceof Player) {
	    	Player p = (Player) e.getPlayer();
	
			if(p.getLocation().getBlockY() >= locations.LocationConfig.getInt("Spawnheight.Y")) {
					e.setCancelled(true);
					Bukkit.getScheduler().cancelTask(BlockPlaceListener.taskID);
					
				} else {
					e.setCancelled(false);
				}
			}
	} 


	
		 
	@EventHandler
	public void onFoodChange(FoodLevelChangeEvent e) {
		e.setCancelled(true);
		
	}

	@EventHandler
    public void onHit(ProjectileHitEvent e) 
    {
   
   
                    Arrow travel = (Arrow) e.getEntity();
                    Entity en = (Entity) travel.getShooter();
                    travel.setCustomName(kit.KitConfig.getString("KIT.ARROW"));
				     if(en instanceof Player) {
							ItemStack pfeil = new ItemStack(Material.ARROW);
							ItemMeta arrowmeta = pfeil.getItemMeta();
							arrowmeta.setDisplayName(kit.KitConfig.getString("KIT.ARROW"));
							pfeil.setItemMeta(arrowmeta);
							pfeil.setAmount(1);
				  
				         Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
							
							@Override
							public void run() {
								arrowseconds--;
								switch(arrowseconds) {
								case 15:
					                
			                        travel.remove();
			                  
			                 break;
							case 0:
			
							      ((Player) en).getInventory().addItem(pfeil);
							
						break;
						default:
							break;
							
									
								}
								
							
				         }
							
						}, 0, 20);
				    	 
                
                }
    }

        
    

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
 
		String Message = e.getMessage();
		Message.replace("%", "Prozent");
		e.setFormat("§7"+ p.getName() + "§8 ⋗⋗ §7" + Message);
	}
}
