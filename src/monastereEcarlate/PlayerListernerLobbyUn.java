package monastereEcarlate;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import net.md_5.bungee.api.ChatColor;

public class PlayerListernerLobbyUn implements Listener
{
	//Coord du point a de la zone
	private int ax = -213;
	private int ay = 70;
	private int az = 247;
	
	//Coord du point b de la zone
	private int bx = -218;
	private int by = 75;
	private int bz = 241;
	
	//Nombre de joueur dans l'instance
	private int nbPlayerInstance = 1;
	
	//Nombre de joueur dans la zone
	private int numberPlayerInArea;

	//Coor de la sign
	private int sx = -216;
	private int sy = 71;
	private int sz = 248;
	
	//Coord de tp de la Sign
	private int tpsx = -216;
	private int tpsy = 70;
	private int tpsz = 243;
	
	//Coord Sign de retour
	private int tpsbx = -216;
	private int tpsby = 71;
	private int tpsbz = 242;
	
	//Cord de Tp de la sign de retour
	private int tpbx = -217;
	private int tpby = 84;
	private int tpbz = 253;
	
	private boolean complet;
	
	private MonastereEcarlate plugin;

	public PlayerListernerLobbyUn(MonastereEcarlate plugin)
	{
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		placeSign();
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent event)
	{
		Location ploc;
		Location aloc = new Location(event.getPlayer().getLocation().getWorld(), ax, ay, az);
		Location bloc = new Location(event.getPlayer().getLocation().getWorld(), bx, by, bz);
		Cuboid cuboid = new Cuboid(aloc, bloc);
		numberPlayerInArea = 0;
		for(Player player: Bukkit.getOnlinePlayers())
		{
			ploc = player.getLocation();
			if (cuboid.containsLocation(ploc))
			{
				numberPlayerInArea++;
			}
			updateSign();
		}
		numberPlayerInArea = 0;
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event)
	{
		Location SignEntrer = new Location(Bukkit.getServer().getWorld("world"), sx, sy, sz);
		Location SignEntrerTP = new Location(Bukkit.getServer().getWorld("world"), tpsx, tpsy, tpsz);
		
		Location SignQuitter = new Location(Bukkit.getServer().getWorld("world"), tpsbx, tpsby, tpsbz);
		Location SignQuitterTP = new Location(Bukkit.getServer().getWorld("world"), tpbx, tpby, tpbz);
		
		if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
		{

			if(event.getClickedBlock().getLocation().equals(SignEntrer) && complet == false)
			{
				event.getPlayer().teleport(SignEntrerTP);
			}
			else if(event.getClickedBlock().getLocation().equals(SignQuitter))
			{
				event.getPlayer().teleport(SignQuitterTP);
			}

		}
	}
	
	@SuppressWarnings("deprecation")
	public void placeSign()
	{
		Location SignEnterLoc = new Location(Bukkit.getServer().getWorld("world"), sx, sy, sz);
		Location SignExitLoc = new Location(Bukkit.getServer().getWorld("world"), tpsbx, tpsby, tpsbz);
		
		SignEnterLoc.getBlock().setType(Material.WALL_SIGN);
		SignExitLoc.getBlock().setType(Material.WALL_SIGN);
		SignExitLoc.getBlock().setData((byte)0x03);
		
		Block b = SignExitLoc.getBlock();
		Sign s = (Sign) b.getState();
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
		{
			public void run()
			{
				s.setLine(1, "Quittez ?");
				s.update();
			}
		}, 60);
	}
	
	public void updateSign()
	{
		Location Sign = new Location(Bukkit.getServer().getWorld("world"), sx, sy, sz);
		
		Block b = Sign.getBlock();
		Sign s = (Sign) b.getState();
		
		if (numberPlayerInArea < nbPlayerInstance)
		{
			s.setLine(0, ChatColor.RED + "Monastère");
			s.setLine(1, ChatColor.GREEN + "Instance n°1");
			s.setLine(2, ChatColor.AQUA + "" + numberPlayerInArea + " / " + nbPlayerInstance);
			s.setLine(3, ChatColor.GREEN + "Rejoindre ?");
			s.update();
			complet = false;
		}
		else
		{
			s.setLine(0, ChatColor.RED + "Monastère");
			s.setLine(1, ChatColor.GREEN + "Instance n°1");
			s.setLine(2, ChatColor.RED + "" + numberPlayerInArea + " / " + nbPlayerInstance);
			s.setLine(3, ChatColor.RED + "COMPLET");
			s.update();
			complet = true;
		}
	}
}
