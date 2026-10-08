package config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;


import at.nathi.villager.InventoryManager;


 


public class messages {

	public static File messagesFile = new File("plugins/KnockbackFFA", "messages.yml");
	public static FileConfiguration messageConfig = YamlConfiguration.loadConfiguration(messagesFile);
	
	
	public static void save() throws IOException {
		messageConfig.save(messagesFile);

	}
	public static void loadConfig() throws IOException {
		messageConfig.addDefault("MSGConfig.KNOCKFFA_Prefix", "§7§l✘ §e§lKnock§6§lFFA §7§l✘ ");
		messageConfig.addDefault("MSGConfig.KNOCKFFA_NoPermission", "§7Du hast keine §e§lRechte §7für das §e§lSetup§7!");
		messageConfig.addDefault("MSGConfig.InventarSoriteurng_Prefix", "§a§lInventarsortierung");
		messageConfig.addDefault("MSGConfig.INVENTAR_SAVE", "§7Dein Inventar wurde §a§labgespeichert");
		messageConfig.addDefault("MSGConfig.INVENTAR_Abgespeichert", "§7Dein Inventar wurde §a§labgespeichert");
		messageConfig.addDefault("MSGConfig.INVENTAR_DELETE", "§7Der §e§lInventarSortierungs-Villager §7wurde erfolgreich entfernt");
		messageConfig.addDefault("MSGConfig.SHOP_Prefix", "§e§lShop");
		messageConfig.addDefault("MSGConfig.SHOP_DELETE", "§7Der §e§lShop §7wurde erfolgreich erfolgreich entfernt");
		messageConfig.addDefault("MSGConfig.LOBBY_JOIN", "§7[§e+§7] §7%Player%");
		messageConfig.addDefault("MSGConfig.LOBBY_QUIT", "§7§7[§c-§7] §7%Player%");
		messageConfig.addDefault("MSGConfig.SET_LOBBY", "§7Du hast den Spawnpunkt §e§lLobby §7gesetzt.");
		messageConfig.addDefault("MSGConfig.SET_HOLOGRAM", "§7Das §e§lHolgramm §7wurde erfolgreich erstellt.");
		messageConfig.addDefault("MSGConfig.SET_INVMANAGER", "§7Der " + InventoryManager.InventarCustom +  "Villager §7wurde erfolgreich erstellt.");
		messageConfig.addDefault("MSGConfig.SET_SHOP", "§7Der §e§lShop §7wurde erfolgreich erstellt");	
		messageConfig.addDefault("MSGConfig.SET_DEATHHEIGHT", "§7Du hast die §e§lDeathheight §7auf §e§l%Deathheight% §7gesetzt");	
		messageConfig.addDefault("MSGConfig.SET_SPAWNHEIGHT", "§7Du hast die §e§lSpawnheight §7auf §e§l%Spawnheight% §7gesetzt");	
		messageConfig.addDefault("MSGConfig.REMOVE_VANISH", "§7Du bist nun nicht mehr im §e§lVanish-Modus");	
		messageConfig.addDefault("MSGConfig.ADD_VANISH", "§7Du bist nun im §e§lVanish-Modus");	
		messageConfig.addDefault("MSGConfig.ADD_FREEZE", "§7Der Spieler §e§l%target_player% §7wurde gefreezed!");
		messageConfig.addDefault("MSGConfig.REMOVE_FREEZE", "§7Der Spieler §e§l%target_player% §7wurde entfreezed!");	
		messageConfig.addDefault("MSGConfig.CHAT_CLEAR", "§7Der Chat wurde von §e§l%player% §7gecleart.");
		messageConfig.addDefault("MSGConfig.Rettungsplattform_COOLDOWN", "§7Warte §e§l%cooldown% §7bis du das Item wieder benutzen kannst");
		messageConfig.addDefault("MSGConfig.Rettungsplattform_READY", "§e§lRettungsplattform §7verschwindet wieder nach §e§l%cooldown% §7Sekunde(n)");
		messageConfig.addDefault("MSGConfig.Rettungsplattform_FINISHED", "§e§lRettungsplattform §7erfolgreich entfernt");
		messageConfig.addDefault("MSGConfig.Arrow_COOLDOWN", "§7Warte §e§l%cooldown% §7bis du das Item wieder benutzen kannst");
		messageConfig.addDefault("MSGConfig.Arrow_READY", "§f§lWitherArrow §7verschwindet wieder nach §e§l5 §7Sekunde(n)");
		messageConfig.addDefault("MSGConfig.Arrow_FINISHED", "§e§lWitherArrow §7erfolgreich entfernt");
		messageConfig.addDefault("MSGConfig.PlayerDeathByPlayer", "§e§l%deadplayer% §7wurde von §e§l%player% §7getötet");
		messageConfig.addDefault("MSGConfig.PlayerDeath", "§e§l%player% §7ist gestorben");
		messageConfig.addDefault("MSGConfig.INVSEE", "§7Inventar von §e§l%player%");
		messageConfig.addDefault("MSGConfig.PlayerKillStreak", "§7Der Spieler §e§l%player% §7hat eine Killstreak von §e§l%killstreak%");
		messageConfig.addDefault("MSGConfig.KillStreakTitle", "§7Killstreak: §e§l");
		messageConfig.addDefault("MSGConfig.WEAKNESS_EFFEKT", "§7Neuer Effekt: §e§lWeakness");
		messageConfig.addDefault("MSGConfig.JUMP_EFFEKT", "§7Neuer Effekt: §e§lJump-Boost");
		messageConfig.addDefault("MSGConfig.ABSORPTION_EFFEKT", "§7Neuer Effekt: §e§lAbsorption");
		messageConfig.addDefault("MSGConfig.SETSTATS.PlayerNotOnline", "§7Der Spieler §e§l%player% §7ist nicht auf den Server");
		messageConfig.addDefault("MSGConfig.SETSTATS.NoNumber1", "§7Das ist keine Zahl!");
		messageConfig.addDefault("MSGConfig.SETSTATS.NoNumber2", "§e§l/setstats §7<Kills/Tode/Coins> <SPIELER> <Anzahl>");
		messageConfig.addDefault("MSGConfig.SETSTATS.Kills", "§7Du hast die Kills von §e§l%player% §7auf §e§l%Kills% §7gesetzt");
		messageConfig.addDefault("MSGConfig.SETSTATS.Tode", "§7Du hast die Tode von §e§l%player% §7auf §e§l%Tode% §7gesetzt");
		messageConfig.addDefault("MSGConfig.SETSTATS.Coins", "§7Du hast die Coins von §e§l%player% §7auf §e§l%Coins% §7gesetzt");
		messageConfig.addDefault("MSGConfig.SETSTATS.Elo", "§7Du hast die Elo von §e§l%player% §7auf §e§l%Elo% §7gesetzt");
		messageConfig.addDefault("MSGConfig.Map_Minute", "§7Die Map wird in §e15 §7Minuten gewechselt");
		messageConfig.addDefault("MSGConfig.Map_Second10","§7Die Map wird in §e10 §7Sekunde(n) gewechselt");
		messageConfig.addDefault("MSGConfig.Map_Second9", "§7Die Map wird in §e9 §7Sekunde(n) gewechselt");
		messageConfig.addDefault("MSGConfig.Map_Second8", "§7Die Map wird in §e8 §7Sekunde(n) gewechselt");
		messageConfig.addDefault("MSGConfig.Map_Second7", "§7Die Map wird in §e7 §7Sekunde(n) gewechselt");
		messageConfig.addDefault("MSGConfig.Map_Second6", "§7Die Map wird in §e6 §7Sekunde(n) gewechselt");
		messageConfig.addDefault("MSGConfig.Map_Second5", "§7Die Map wird in §e5 §7Sekunde(n) gewechselt");
		messageConfig.addDefault("MSGConfig.Map_Second4", "§7Die Map wird in §e4 §7Sekunde(n) gewechselt");
		messageConfig.addDefault("MSGConfig.Map_Second3", "§7Die Map wird in §e3 §7Sekunde(n) gewechselt");
		messageConfig.addDefault("MSGConfig.Map_Second2", "§7Die Map wird in §e2 §7Sekunde(n) gewechselt");
		messageConfig.addDefault("MSGConfig.Map_Second1", "§7Die Map wird in §e1 §7Sekunde(n) gewechselt");
		messageConfig.addDefault("MSGConfig.Effect_Minute", "§7Der Effekt wird in §e10 §7Minuten gewechselt");
		messageConfig.addDefault("MSGConfig.Effect_Second10","§7Der Effekt wird in §e10 §7Sekunde(n) gewechselt");
		messageConfig.addDefault("MSGConfig.Effect_Second9", "§7Der Effekt wird in §e9 §7Sekunde(n) gewechselt");
		messageConfig.addDefault("MSGConfig.Effect_Second8", "§7Der Effekt wird in §e8 §7Sekunde(n) gewechselt");
		messageConfig.addDefault("MSGConfig.Effect_Second7", "§7Der Effekt wird in §e7 §7Sekunde(n) gewechselt");
		messageConfig.addDefault("MSGConfig.Effect_Second6", "§7Der Effekt wird in §e6 §7Sekunde(n) gewechselt");
		messageConfig.addDefault("MSGConfig.Effect_Second5", "§7Der Effekt wird in §e5 §7Sekunde(n) gewechselt");
		messageConfig.addDefault("MSGConfig.Effect_Second4", "§7Der Effekt wird in §e4 §7Sekunde(n) gewechselt");
		messageConfig.addDefault("MSGConfig.Effect_Second3", "§7Der Effekt wird in §e3 §7Sekunde(n) gewechselt");
		messageConfig.addDefault("MSGConfig.Effect_Second2", "§7Der Effekt wird in §e2 §7Sekunde(n) gewechselt");
		messageConfig.addDefault("MSGConfig.Effect_Second1", "§7Der Effekt wird in §e1 §7Sekunde(n) gewechselt");

		
		messageConfig.options().copyDefaults(true);
		save();
	}


	

}
