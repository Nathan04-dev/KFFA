package at.nathi.main;



import java.io.IOException;
import java.util.ArrayList;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;

import at.nathi.commands.BuildCommand;
import at.nathi.commands.ChatclearCommand;
import at.nathi.commands.CoinsCommand;
import at.nathi.commands.FreezeCommand;
import at.nathi.commands.GamemodeCommand;
import at.nathi.commands.InvseeCommand;
import at.nathi.commands.StatsCommand;
import at.nathi.commands.VanishCommand;
import at.nathi.listeners.BasicListeners;
import at.nathi.listeners.AutoRespawnListener;
import at.nathi.listeners.BlockPlaceListener;
import at.nathi.listeners.CombatloggListener;
import at.nathi.listeners.EinstellungenListener;
import at.nathi.listeners.EnderpearlListener;
import at.nathi.listeners.ExplosionListener;
import at.nathi.listeners.JoinAndQuitListener;
import at.nathi.listeners.KillStreakListener;
import at.nathi.listeners.RettungsPlattformListener;
import at.nathi.listeners.SQLDeathListener;
import at.nathi.mysql.MySQL;
import at.nathi.mysql.MySQLFile;
import at.nathi.mysql.SQLLobby;
import at.nathi.mysql.SQLStats;
import at.nathi.mysql.SQLTop10;
import at.nathi.title.PluginPlaceholder;
import at.nathi.villager.InventoryManager;
import at.nathi.villager.InventorySpecify;
import at.nathi.villager.ShopSpecify;
import config.CoinsElo;
import config.GUI;
import config.kit;
import config.locations;
import config.messages;
import config.scoreboard;
import config.shop;
import at.nathi.villager.ShopManager;



public class Main extends JavaPlugin {
	

	private ArrayList<Player> players;
	
	

	public void onEnable() {


		System.out.println("------------------");
		Bukkit.getConsoleSender().sendMessage("§6Knockback§eFFA by Sorpex");
		Bukkit.getConsoleSender().sendMessage("§6Version: §71.0");
		Bukkit.getConsoleSender().sendMessage("§6Plugin for §7Jonnigames");
		Bukkit.getConsoleSender().sendMessage("§cYoutube Channel: §7Sorpex");
		Bukkit.getConsoleSender().sendMessage("------------------");
		if (!Bukkit.getPluginManager().isPluginEnabled("HolographicDisplays")) {
			getLogger().severe("*** HolographicDisplays is not installed or not enabled. ***");
			getLogger().severe("*** This plugin will be disabled. ***");
			this.setEnabled(false);
			return;
		}
		HologramsAPI.getHolograms(this).forEach(Hologram::delete);
		HologramsAPI.unregisterPlaceholders(this);
		HologramsAPI.registerPlaceholder(this, "&u", 1.0, new PluginPlaceholder(Bukkit.getServer().getPluginManager().getPlugins().length));
		new JoinAndQuitListener(this);
		new BasicListeners(this);
		new AutoRespawnListener(this);
		new BlockPlaceListener(this);
		new SQLDeathListener(this);
		new ExplosionListener(this);
		new CombatloggListener(this);
		new RettungsPlattformListener(this);
		new KillStreakListener(this);
		new EnderpearlListener(this);
		new EinstellungenListener(this);
	
		loadConfig();
		try {

			locations.loadConfig();
			scoreboard.loadConfig();;
			messages.loadConfig();
			GUI.loadConfig();
			shop.loadConfig();
			kit.loadConfig();
			CoinsElo.loadConfig();
			
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
		MySQLFile file = new MySQLFile();
		file.setStandard();
		file.readData();


		MySQL.connect();

		MySQL.update("CREATE TABLE IF NOT EXISTS Stats (UUID VARCHAR(64), Name text, Kills int, Tode int, Coins int, Elo int);");
		MySQL.update("CREATE TABLE IF NOT EXISTS Lobby (UUID VARCHAR(64), X double, Y double, Z double, World text, Yaw float, Pitch float);");

		ShopManager villagerHandler = new ShopManager();
		FreezeCommand freezecommand = new FreezeCommand();
		BuildCommand buildcommand = new BuildCommand();
		StatsCommand statscommand = new StatsCommand();
		InventoryManager inventar = new InventoryManager();
		

		getCommand("freeze").setExecutor(freezecommand);
		getCommand("stats").setExecutor(statscommand);
		getCommand("build").setExecutor(buildcommand);
		getCommand("invsee").setExecutor(new InvseeCommand());
		getCommand("gamemode").setExecutor(new GamemodeCommand());
		getCommand("cc").setExecutor(new ChatclearCommand());
		getCommand("coins").setExecutor(new CoinsCommand());
		getCommand("vanish").setExecutor(new VanishCommand());
	
		
		PluginManager pmanager = Bukkit.getPluginManager();
		pmanager.registerEvents(freezecommand, this);
		pmanager.registerEvents(buildcommand, this);
		pmanager.registerEvents(villagerHandler, this);
		pmanager.registerEvents(statscommand, this);
		pmanager.registerEvents(inventar, this);
	
		

	
		instance = this;
		
	}
	
	public void onDisable() {
		MySQL.disconnect();
	}
	
	public static Main instance;
	
	public static Main getInstance() {
		return instance;
		
	}
	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void loadConfig() {
		getConfig().options().copyDefaults(true);
	}
	public static String prefix = messages.messageConfig.getString("MSGConfig.KNOCKFFA_Prefix");


	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	Player p = (Player) sender;
	
//HELP COMMMAND
	
	if(cmd.getName().equalsIgnoreCase("KnockFFA")) {
		if(args.length >= 1) {
			if(p.isOp() || p.hasPermission("knockffa.moderator") || p.hasPermission("knockffa.admin")) {
				if(args[0].equalsIgnoreCase("help")) {
					p.sendMessage(Main.prefix +"§e§l/KnockFFA set Lobby §7Setzt den Lobby Spawn");
					p.sendMessage(Main.prefix +"§e§l/KnockFFA set Invmanager §7Setzt den Inv-Manager");
					p.sendMessage(Main.prefix +"§e§l/KnockFFA set Shop §7Setzt den KIT-Manager");
					p.sendMessage(Main.prefix +"§e§l/KnockFFA set Deathheight §7Setzt den Todespunkt");
					p.sendMessage(Main.prefix +"§e§l/KnockFFA set Spawnheight §7Setzt die Spawngröße");
					p.sendMessage(Main.prefix +"§e§l/KnockFFA set Stats §7<Kills/Tode/Coins/Elo> §7<Spieler> §7<Anzahl>");
					p.sendMessage(Main.prefix +"§e§l/KnockFFA set Hologram §7Erstellt das Stats Hologram");
					p.sendMessage(Main.prefix +"§e§l/KnockFFA set map1 §7<Name/Location)");
					p.sendMessage(Main.prefix +"§e§l/KnockFFA set map2 §7<Name/Location)");
					p.sendMessage(Main.prefix +"§e§l/KnockFFA set map3 §7<Name/Location)");
					p.sendMessage(Main.prefix +"§e§l/KnockFFA maps §7Hier werden alle KnockFFA Maps angezeigt");
					p.sendMessage(Main.prefix +"§e§l/KnockFFA EFFECTS §7Hier werden alle KnockFFA Maps angezeigt");
					p.sendMessage(Main.prefix +"§e§l/Stats   §7Sehe die Statistiken eiens Spielers nach");
					p.sendMessage(Main.prefix +"§e§l/freeze   §7Lässt den Spieler freezen");
					p.sendMessage(Main.prefix +"§e§l/cc   §7Leert den Chat");
					p.sendMessage(Main.prefix +"§e§l/Vanish   §7Macht dich unsichtbar");
		
					
				}
				if(args[0].equalsIgnoreCase("setup")) {
					p.sendMessage(Main.prefix +"§e§l/KnockFFA set Lobby §7Setzt den Lobby Spawn");
					p.sendMessage(Main.prefix +"§e§l/KnockFFA set Invmanager §7Setzt den Inv-Manager");
					p.sendMessage(Main.prefix +"§e§l/KnockFFA set Shop §7Setzt den KIT-Manager");
					p.sendMessage(Main.prefix +"§e§l/KnockFFA set Deathheight §7Setzt den Todespunkt");
					p.sendMessage(Main.prefix +"§e§l/KnockFFA set Spawnheight §7Setzt die Spawngröße");
					p.sendMessage(Main.prefix +"§e§l/KnockFFA set Stats §7<Kills/Tode/Coins/Elo> §7<Spieler> §7<Anzahl>");
					p.sendMessage(Main.prefix +"§e§l/KnockFFA set Hologram §7Erstellt das Stats Hologram");
					p.sendMessage(Main.prefix +"§e§l/KnockFFA set map1 §7<Name/Location)");
					p.sendMessage(Main.prefix +"§e§l/KnockFFA set map2 §7<Name/Location)");
					p.sendMessage(Main.prefix +"§e§l/KnockFFA set map3 §7<Name/Location)");
					p.sendMessage(Main.prefix +"§e§l/KnockFFA maps §7Hier werden alle KnockFFA Maps angezeigt");
					p.sendMessage(Main.prefix +"§e§l/KnockFFA effects §7Hier werden alle KnockFFA Maps angezeigt");
					
					
					p.sendMessage(Main.prefix +"§e§l/KnockFFA maps §7Hier werden alle KnockFFA Maps angezeigt");
				
					p.sendMessage(Main.prefix +"§e§l/KnockFFA Effects §7Random-Effekte");
				}
				if(args[0].equalsIgnoreCase("effects")) {
					Inventory inv = Bukkit.createInventory(null, 9*1, GUI.GUIConfig.getString("EffectsGUI.Name"));
					ItemStack aktivieren = new ItemStack(Material.GREEN_WOOL);
					ItemStack abbrechen = new ItemStack(Material.RED_WOOL);
					ItemMeta iMeta = aktivieren.getItemMeta();
					ItemMeta iMeta2 = abbrechen.getItemMeta();
					iMeta.setDisplayName(GUI.GUIConfig.getString("EffectsGUI.Aktivieren"));
					iMeta2.setDisplayName(GUI.GUIConfig.getString("EffectsGUI.Deaktivieren"));
					aktivieren.setItemMeta(iMeta);
					abbrechen.setItemMeta(iMeta2);
					inv.setItem(0, aktivieren);
					inv.setItem(8, abbrechen);
					p.openInventory(inv);
				}
				if(args[0].equalsIgnoreCase("maps")) {
					Inventory inv = Bukkit.createInventory(null, 9*1, GUI.GUIConfig.getString("MapsGUI.Name"));
					ItemStack Map1 = new ItemStack( Material.YELLOW_WOOL);
					ItemStack Map2 = new ItemStack( Material.YELLOW_WOOL);
					ItemStack Map3 = new ItemStack( Material.YELLOW_WOOL);
					ItemMeta iMeta1 = Map1.getItemMeta();
					ItemMeta iMeta2 = Map2.getItemMeta();
					ItemMeta iMeta3 = Map3.getItemMeta();
					iMeta1.setDisplayName("§eMap §7§l1");
					iMeta2.setDisplayName("§eMap §7§l2");
					iMeta3.setDisplayName("§eMap §7§l3");
					Map1.setItemMeta(iMeta1);
					Map2.setItemMeta(iMeta2);
					Map3.setItemMeta(iMeta3);
					
					inv.setItem(0, Map1);
					inv.setItem(4, Map2);
					inv.setItem(8, Map3);
					
					p.openInventory(inv);
				}
				if(args[0].equalsIgnoreCase("set")) {
					if(args[1].equalsIgnoreCase("lobby")) { 
					
						double x = p.getLocation().getX();
						double y = p.getLocation().getY();
						double z = p.getLocation().getZ();
						String w = p.getWorld().getName();
						float yaw = p.getLocation().getYaw();
						float pitch = p.getLocation().getPitch();
						SQLLobby.setX(p.getUniqueId().toString(), x);
						SQLLobby.setY(p.getUniqueId().toString(), y);
						SQLLobby.setZ(p.getUniqueId().toString(), z);
						SQLLobby.setWorld(p.getUniqueId().toString(), w);
						SQLLobby.setYaw(p.getUniqueId().toString(), yaw);
						SQLLobby.setPitch(p.getUniqueId().toString(), pitch);
		
						p.sendMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.SET_LOBBY"));
					
					
					}
					if(args[1].equalsIgnoreCase("shop")) {
						new ShopSpecify(p.getLocation(), p);
						p.sendMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.SET_SHOP"));
						return false;
					}
					if(args[1].equalsIgnoreCase("invmanager")) {
						new InventorySpecify(p.getLocation(), p);
						p.sendMessage(Main.prefix +  messages.messageConfig.getString("MSGConfig.SET_INVMANAGER"));
						return false;
					}
					if(args[1].equalsIgnoreCase("Hologram")) {
						SQLTop10.set(p);
						p.sendMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.SET_HOLOGRAM"));
						return false;
					}

//DEATHHEIGHT UND SPAWNHEIGHT----------------------------------------------------------------
				if(args[1].equalsIgnoreCase("deathheight")) {
					  double y2 = p.getLocation().getBlockY();
					  locations.LocationConfig.set("Deathheight.Y", y2);
					  try {
						locations.save();
					} catch (IOException e) {
						e.printStackTrace();
					}
					  
					  String deathheight = messages.messageConfig.getString("MSGConfig.SET_DEATHHEIGHT");
					  deathheight = deathheight.replace("%Deathheight%", locations.LocationConfig.getString("Deathheight.Y"));
					  p.sendMessage(Main.prefix + deathheight);			
				}
				if(args[1].equalsIgnoreCase("spawnheight")) {
					double y2 = p.getLocation().getBlockY();
					  locations.LocationConfig.set("Spawnheight.Y", y2);
					  try {
							locations.save();
						} catch (IOException e) {
							e.printStackTrace();
						}
					  String spawnheight = messages.messageConfig.getString("MSGConfig.SET_SPAWNHEIGHT");
					  spawnheight = spawnheight.replace("%Spawnheight%", locations.LocationConfig.getString("Spawnheight.Y"));
					  p.sendMessage(Main.prefix + spawnheight);			
				}
				//SETSTATS COMMAND
				if(args[1].equalsIgnoreCase("stats")) {
					if(args[2].equalsIgnoreCase("Kills")) {
						Player t = Bukkit.getPlayer(args[3]);
						if(t == null) {
							String notonline = messages.messageConfig.getString("MSGConfig.SETSTATS.PlayerNotOnline");
							notonline = notonline.replace("%player%", args[3]);
							p.sendMessage(Main.prefix + notonline);
						} else {
						try {
							int i = Integer.parseInt(args[4]); 
							SQLStats.setKills(t.getUniqueId().toString(), i);
							
							String kills = messages.messageConfig.getString("MSGConfig.SETSTATS.Kills.Player");
							kills = kills.replace("%Kills%", String.valueOf(i));
							kills = kills.replace("%player%", t.getName());
							p.sendMessage(Main.prefix + kills);
							
						} catch(NumberFormatException e) {
							p.sendMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.SETSTATS.NoNumber1"));
							p.sendMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.SETSTATS.NoNumber2"));
						}
						}
						new BukkitRunnable() {
							
							@Override
							public void run() {
							for(Player all : Bukkit.getOnlinePlayers()) {
								JoinAndQuitListener.setScoreboard(all);
							}
							}
						}.runTaskLater(Main.getInstance(), 1);
						
						} else if(args[2].equalsIgnoreCase("Tode")) {
							Player t = Bukkit.getPlayer(args[3]);
							if(t == null) {
								String notonline = messages.messageConfig.getString("MSGConfig.SETSTATS.PlayerNotOnline");
								notonline = notonline.replace("%player%", args[3]);
								p.sendMessage(Main.prefix + notonline);
							} else {
							try {
								int i = Integer.parseInt(args[4]);
								SQLStats.setTode(t.getUniqueId().toString(), i);
								String tode = messages.messageConfig.getString("MSGConfig.SETSTATS.Tode");
								tode = tode.replace("%Tode%", String.valueOf(i));
								tode = tode.replace("%player%", t.getName());
								p.sendMessage(Main.prefix + tode);
								
								
							} catch(NumberFormatException e) {
								p.sendMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.SETSTATS.NoNumber1"));
								p.sendMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.SETSTATS.NoNumber2"));
							}
							}
							new BukkitRunnable() {
								
								@Override
								public void run() {
								for(Player all : Bukkit.getOnlinePlayers()) {
									JoinAndQuitListener.setScoreboard(all);
								}
								}
							}.runTaskLater(Main.getInstance(), 1);

						} else if(args[2].equalsIgnoreCase("Coins")) {
							Player t = Bukkit.getPlayer(args[3]);
							if(t == null) {
								String notonline = messages.messageConfig.getString("MSGConfig.SETSTATS.PlayerNotOnline");
								notonline = notonline.replace("%player%", args[3]);
								p.sendMessage(Main.prefix + notonline);
							} else {
							try {
								int i = Integer.parseInt(args[4]);
								SQLStats.setCoins(t.getUniqueId().toString(), i);
								String coins = messages.messageConfig.getString("MSGConfig.SETSTATS.Coins");
								coins = coins.replace("%Coins%", String.valueOf(i));
								coins = coins.replace("%player%", t.getName());
								p.sendMessage(Main.prefix + coins);
								
								
							} catch(NumberFormatException e) {
								p.sendMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.SETSTATS.NoNumber1"));
								p.sendMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.SETSTATS.NoNumber2"));
							}
							}
							new BukkitRunnable() {
								
								@Override
								public void run() {
								for(Player all : Bukkit.getOnlinePlayers()) {
									JoinAndQuitListener.setScoreboard(all);
								}
								}
							}.runTaskLater(Main.getInstance(), 1);
						} else if(args[2].equalsIgnoreCase("Elo")) {
							Player t = Bukkit.getPlayer(args[3]);
							if(t == null) {
								String notonline = messages.messageConfig.getString("MSGConfig.SETSTATS.PlayerNotOnline");
								notonline = notonline.replace("%player%", args[3]);
								p.sendMessage(Main.prefix + notonline);
							} else {
							try {
								int i = Integer.parseInt(args[4]);
								SQLStats.setElo(t.getUniqueId().toString(), i);
								String coins = messages.messageConfig.getString("MSGConfig.SETSTATS.Elo");
								coins = coins.replace("%Elo%", String.valueOf(i));
								coins = coins.replace("%player%", t.getName());
								p.sendMessage(Main.prefix + coins);
								
								
							} catch(NumberFormatException e) {
								p.sendMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.SETSTATS.NoNumber1"));
								p.sendMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.SETSTATS.NoNumber2"));
							}
							}
							new BukkitRunnable() {
								
								@Override
								public void run() {
								for(Player all : Bukkit.getOnlinePlayers()) {
									JoinAndQuitListener.setScoreboard(all);
								}
								}
							}.runTaskLater(Main.getInstance(), 1);
						}
				}
				//MAPS
				if(args[1].equalsIgnoreCase("map1")) {
					if(args[2].equalsIgnoreCase("name")) {
						String name = args[3];
						locations.LocationConfig.set("Map1.Name", name);
						p.sendMessage(Main.prefix + "§7Du hast den namen der Map auf §e§l" + locations.LocationConfig.get("Map1.Name") + " §7gesetzt");
						try {
							locations.save();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if(args[2].equalsIgnoreCase("location")) {
					
					double x = p.getLocation().getX();
					double y = p.getLocation().getY();
					double z = p.getLocation().getZ();
					String w = p.getWorld().getName();
					float yaw = p.getLocation().getYaw();
					float pitch = p.getLocation().getPitch();
					locations.LocationConfig.set("Map1.X", x);
					locations.LocationConfig.set("Map1.Y", y);
					locations.LocationConfig.set("Map1.Z", z);
					locations.LocationConfig.set("Map1.World", w);
					locations.LocationConfig.set("Map1.Yaw", yaw);
					locations.LocationConfig.set("Map1.Pitch", pitch);
		
					p.sendMessage(Main.prefix + "§7Der Spawnpunkt für §e§l" + locations.LocationConfig.get("Map1.Name") +" §7wurde erstellt.");
					try {
						locations.save();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			
					}
						
					
				} 
				if(args[1].equalsIgnoreCase("map2")) {
					if(args[2].equalsIgnoreCase("name")) {
						String name = args[3];
						locations.LocationConfig.set("Map2.Name", name);
						p.sendMessage(Main.prefix + "§7Du hast den namen der Map auf §e§l" + locations.LocationConfig.get("Map2.Name") + " §7gesetzt");
						try {
							locations.save();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if(args[2].equalsIgnoreCase("location")) {
					double x = p.getLocation().getX();
					double y = p.getLocation().getY();
					double z = p.getLocation().getZ();
					String w = p.getWorld().getName();
					float yaw = p.getLocation().getYaw();
					float pitch = p.getLocation().getPitch();
					locations.LocationConfig.set("Map2.X", x);
					locations.LocationConfig.set("Map2.Y", y);
					locations.LocationConfig.set("Map2.Z", z);
					locations.LocationConfig.set("Map2.World", w);
					locations.LocationConfig.set("Map2.Yaw", yaw);
					locations.LocationConfig.set("Map2.Pitch", pitch);
		
					p.sendMessage(Main.prefix + "§7Der Spawnpunkt für §e§l" + locations.LocationConfig.get("Map2.Name") +" §7wurde erstellt.");
					try {
						locations.save();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				
			
				}
				if(args[1].equalsIgnoreCase("map3")) {
					if(args[2].equalsIgnoreCase("name")) {
						String name = args[3];
						locations.LocationConfig.set("Map3.Name", name);
						p.sendMessage(Main.prefix + "§7Du hast den namen der Map auf §e§l" + locations.LocationConfig.get("Map3.Name") + " §7gesetzt");
						try {
							locations.save();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if(args[2].equalsIgnoreCase("location")) {
					double x = p.getLocation().getX();
					double y = p.getLocation().getY();
					double z = p.getLocation().getZ();
					String w = p.getWorld().getName();
					float yaw = p.getLocation().getYaw();
					float pitch = p.getLocation().getPitch();
					locations.LocationConfig.set("Map3.X", x);
					locations.LocationConfig.set("Map3.Y", y);
					locations.LocationConfig.set("Map3.Z", z);
					locations.LocationConfig.set("Map3.World", w);
					locations.LocationConfig.set("Map3.Yaw", yaw);
					locations.LocationConfig.set("Map3.Pitch", pitch);
					
				
					p.sendMessage(Main.prefix + "§7Der Spawnpunkt für §e§l" + locations.LocationConfig.get("Map3.Name") +" §7wurde erstellt.");
					try {
						locations.save();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				
			
				}
			 }
			
			} else 
			p.sendMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.KNOCKFFA_NoPermission"));
		}
	}
	return true;
	
	
	}
}	
