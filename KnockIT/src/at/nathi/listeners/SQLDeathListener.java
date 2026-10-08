package at.nathi.listeners;





import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import at.nathi.main.Main;
import at.nathi.mysql.SQLStats;
import config.CoinsElo;
import config.messages;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class SQLDeathListener implements Listener{
	
	public SQLDeathListener(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
	}
	

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = (Player) e.getEntity();

		if(p.getKiller() instanceof Player) {
			
			ItemStack enderperle = new ItemStack(Material.ENDER_PEARL);
			ItemMeta epmeta = enderperle.getItemMeta();
			epmeta.setDisplayName("§6Enderperle");
			enderperle.setItemMeta(epmeta);
			ItemStack pfeil = new ItemStack(Material.ARROW);
			ItemMeta arrowmeta = pfeil.getItemMeta();
			arrowmeta.setDisplayName("§6Pfeile");
			pfeil.setItemMeta(arrowmeta);
			p.getKiller().getInventory().addItem(enderperle);
			p.getKiller().getInventory().addItem(pfeil);
			SQLStats.addTode(p.getUniqueId().toString(), 1);
			SQLStats.addKills(p.getKiller().getUniqueId().toString(), 1);
			SQLStats.addElo(p.getKiller().getUniqueId().toString(), CoinsElo.CoinsEloConfig.getInt("CoinsElo.EloPerPlayerKill"));
			SQLStats.addCoins(p.getKiller().getUniqueId().toString(), CoinsElo.CoinsEloConfig.getInt("CoinsElo.CoinsPerPlayerKill"));
			
			e.setDeathMessage(CoinsElo.CoinsEloConfig.getString("MSGConfig.PlayerDeathByPlayer"));
			SQLStats.removeCoins(p.getUniqueId().toString(), CoinsElo.CoinsEloConfig.getInt("CoinsElo.CoinsDeadPlayer"));
			SQLStats.removeElo(p.getUniqueId().toString(), CoinsElo.CoinsEloConfig.getInt("CoinsElo.EloDeadPlayer"));
		
			
			String coins1 = CoinsElo.CoinsEloConfig.getString("CoinsElo.CoinsDeadPlayerByPlayerMessage");
			coins1 = coins1.replace("%Coins%", String.valueOf(CoinsElo.CoinsEloConfig.getInt("CoinsElo.CoinsDeadPlayer")));
			p.getKiller().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Main.prefix + coins1));
			String DeathMessage = messages.messageConfig.getString("MSGConfig.PlayerDeathByPlayer");
			DeathMessage = DeathMessage.replace("%deadplayer%", p.getName());
			DeathMessage = DeathMessage.replace("%player%", e.getEntity().getKiller().getName());
		
			e.setDeathMessage(DeathMessage);
			p.getKiller().playSound(p.getKiller().getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3, 1);
			p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 3, 1);
			String coins = CoinsElo.CoinsEloConfig.getString("CoinsElo.CoinsDeadPlayerMessage");
			coins = coins.replace("%Coins%", String.valueOf(CoinsElo.CoinsEloConfig.getInt("CoinsElo.CoinsDeadPlayer")));
			p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Main.prefix + coins));
			new BukkitRunnable() {
				
				@Override
				public void run() {
				
 				for(Player all : Bukkit.getOnlinePlayers()) {
					 JoinAndQuitListener.setScoreboard(all);
				}
				}
			}.runTaskLater(Main.getInstance(), 1);
		} else {
			SQLStats.addTode(p.getUniqueId().toString(), 1);;
		}
	

	}
}
