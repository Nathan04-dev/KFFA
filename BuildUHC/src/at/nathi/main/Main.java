package at.nathi.main;




import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import at.nathi.commands.ChatclearCommand;
import at.nathi.commands.FreezeCommand;
import at.nathi.commands.GamemodeCommand;
import at.nathi.commands.InvseeCommand;
import at.nathi.commands.StatsCommand;
import at.nathi.commands.buildCommand;
import at.nathi.commands.gmCommand;
import at.nathi.commands.setStatsCommand;
import at.nathi.config.ConfigFile;
import at.nathi.listeners.BasicListeners;
import at.nathi.listeners.BlockPlaceListener;
import at.nathi.listeners.AutoRespawnListener;
import at.nathi.listeners.DeathStatsListener;
import at.nathi.listeners.JoinAndQuitListener;
import at.nathi.listeners.KillStreakListener;
import at.nathi.mysql.MySQL;
import at.nathi.mysql.MySQLFile;
import at.nathi.mysql.SQLStats;



public class Main extends JavaPlugin {
	

	
	public static HashMap<String, Long> cooldown = new HashMap<>();
	
	public static Main instance;

	public void onEnable() {


		System.out.println("------------------");
		Bukkit.getConsoleSender().sendMessage("§b§lBUILDUHC by Nathy");
		Bukkit.getConsoleSender().sendMessage("§b§lVersion: §71.0");
		Bukkit.getConsoleSender().sendMessage("§b§lPlugin for §7..");
		Bukkit.getConsoleSender().sendMessage("§c§lYoutube Channel: §7Nathy");
		Bukkit.getConsoleSender().sendMessage("------------------");

		new JoinAndQuitListener(this);
		new BasicListeners(this);
		new AutoRespawnListener(this);
		new DeathStatsListener(this);
		new BlockPlaceListener(this);
		new KillStreakListener(this);

		MySQLFile file = new MySQLFile();
		file.setStandard();
		file.readData();
		
		ConfigFile configfile = new ConfigFile();
		configfile.setStandard();
		configfile.readData();
		
		
		MySQL.connect();
		MySQL.update("CREATE TABLE IF NOT EXISTS Stats (UUID VARCHAR(64), Name text, Kills int, Tode int, Coins int);");

		FreezeCommand freezecommand = new FreezeCommand();
		StatsCommand statscommand = new StatsCommand();
		buildCommand buildcommand = new buildCommand();

		
		getCommand("freeze").setExecutor(freezecommand);
		getCommand("stats").setExecutor(statscommand);
		getCommand("setstats").setExecutor(new setStatsCommand());
		getCommand("invsee").setExecutor(new InvseeCommand());
		getCommand("gamemode").setExecutor(new GamemodeCommand());
		getCommand("gm").setExecutor(new gmCommand());
		getCommand("cc").setExecutor(new ChatclearCommand());

		
		
		PluginManager pmanager = Bukkit.getPluginManager();
		pmanager.registerEvents(freezecommand, this);
		pmanager.registerEvents(statscommand, this);
		pmanager.registerEvents(buildcommand, this);




	
		
		
		
		instance = this;

	}
	


	public static Main getInstance() {
		return instance;
		
	}

	
	public static String prefix = "§7§l✘ §3§lBuild§b§lUHC §7§l✘ ";
	
	


	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	Player p = (Player) sender;
	
	
	if(cmd.getName().equalsIgnoreCase("builduhc")) {
		if(args.length >= 1) {
			if(p.isOp()) {
				if(args[0].equalsIgnoreCase("help"))  {
						p.sendMessage(Main.prefix +"§b§l/BuildUHC set Lobby §7Setzt den Lobby Spawn");
						p.sendMessage(Main.prefix +"§b§l/BuildIUHC set Spawnheight §7Setzt die Spawngröße");
						p.sendMessage(Main.prefix +"§b§l/BuildUHC set Stats §7<KILLS/TODE> <SPIELER> <ANZAHL>");
						p.sendMessage(Main.prefix +"§b§l/Stats   §7Sehe die Statistiken eiens Spielers nach");
						p.sendMessage(Main.prefix +"§b§l/cc   §7Setze die Stats eines Spielers");
						p.sendMessage(Main.prefix +"§b§l/freeze   §7Lässt den Spieler freezen");
					
				}
				if(args[0].equalsIgnoreCase("set")) {
					if(args[1].equalsIgnoreCase("lobby")) {
						double x = p.getLocation().getX();
						double y = p.getLocation().getY();
						double z = p.getLocation().getZ();
						String w = p.getWorld().getName();
						float yaw = p.getLocation().getYaw();
						float pitch = p.getLocation().getPitch();
						p.sendMessage(Main.prefix + "§7Du hast den Spawnpunkt §b§lLobby §7gesetzt.");
						
						getConfig().set("builduhc.spawns." +  args[1] + ".X", x);
						getConfig().set("builduhc.spawns." +  args[1] + ".Y", y);
						getConfig().set("builduhc.spawns." +  args[1] + ".Z", z);				
						getConfig().set("builduhc.spawns." +  args[1] + ".World", w);
						getConfig().set("builduhc.spawns." +  args[1] + ".Yaw", yaw);
						getConfig().set("builduhc.spawns." +  args[1] + ".Pitch", pitch);
						saveConfig();
	
					}
					if(args[1].equalsIgnoreCase("spawnheight")) {
						double y = p.getLocation().getY();
						
						p.sendMessage(Main.prefix + "§7Du hast die §b§lSpawnheight §7auf §b§l" + p.getLocation().getBlockY() + " §7gesetzt");
						getConfig().set("builduhc.spawns." +  args[1] + ".Y", y);
						saveConfig();
					}
					//SETSTATS COMMAND
					if(args[1].equalsIgnoreCase("stats")) {
						if(args[2].equalsIgnoreCase("Kills")) {
							Player t = Bukkit.getPlayer(args[3]);
							if(t == null) {
								p.sendMessage(Main.prefix + "§7Der Spieler §b§l" + args[3] + " §7ist nicht auf den Server");
							} else {
							try {
								int i = Integer.parseInt(args[4]); 
								SQLStats.setKills(t.getUniqueId().toString(), i);
								p.sendMessage(Main.prefix + "§7Du hast die Kills von§b§l " + t.getName() + " §7auf§b§l "+ i + " §7gesetzt");
								
							} catch(NumberFormatException e) {
								p.sendMessage(Main.prefix + "§7Das ist keine Zahl");
								p.sendMessage(Main.prefix + "§b§l/setstats §7§l<Kills/Tode/Coins> <SPIELER> <Anzahl>");
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
									p.sendMessage(Main.prefix + "§7Der Spieler §b§l" + args[3] + " §7ist nicht auf den Server");
								} else {
								try {
									int i = Integer.parseInt(args[4]);
									SQLStats.setTode(t.getUniqueId().toString(), i);
									p.sendMessage(Main.prefix + "§7Du hast die Tode von§b§l " + t.getName() + " §7auf§b§l "+ i + " §7gesetzt");
									
									
								} catch(NumberFormatException e) {
									p.sendMessage(Main.prefix + "§7Das ist keine Zahl");
									p.sendMessage(Main.prefix + "§b§l/setstats §7§l<Kills/Tode/Coins> <SPIELER> <Anzahl>");
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
									p.sendMessage("§7Der Spieler §b§l" + args[3] + " §7ist nicht auf den Server");
								} else {
								try {
									int i = Integer.parseInt(args[4]);
									SQLStats.setCoins(t.getUniqueId().toString(), i);
									p.sendMessage(Main.prefix + "§7Du hast die Coins von§b§l " + t.getName() + " §7auf§b§l "+ i + " §7gesetzt");
									
									
								} catch(NumberFormatException e) {
									p.sendMessage(Main.prefix + "§7Das ist keine Zahl");
									p.sendMessage(Main.prefix + "§b§l/setstats §7§l<Kills/Tode/Coins> <SPIELER> <Anzahl>");
								}
								}
							}
					}
				}

			} else 
			p.sendMessage(Main.prefix + "§7Du hast keine §dRechte §7für das §dSetup§7!");
							
				
		}
	}
	


	

	
	
	return true;
	
	
	}
	


	



	}	


