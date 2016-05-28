package monastereEcarlate;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class LobbySystem implements Listener
{
	private MonastereEcarlate plugin;
	private int nbPlayerInstance;
	private Cuboid cuboid;
	private Location SignEnter;
	private Location SignEnterTP;
	private Location SignExit;
	private Location SignExitTP;
	
	private boolean complet;
	private int numberPlayerInArea;

	public LobbySystem(MonastereEcarlate plugin, String world, int nbPlayerInstance, ConstructZone zone, ConstructSignLocs SignEnter, ConstructSignLocs SignExit)
	{
		this.plugin = plugin;
		this.nbPlayerInstance = nbPlayerInstance;
		this.cuboid = zone.getCuboid();
		this.SignEnter = SignEnter.getSign();
		this.SignEnterTP = SignEnter.getSignTP();
		this.SignExit = SignExit.getSign();
		this.SignExitTP = SignExit.getSignTP();
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		placeSign();
	}
	
	/**
	 * JavaDoc onMove
	 * This method listenner to every moves of players.
	 * if players are in the cuboid, "numberPlayerInArea" increase.
	 * giving the exact number of player in the cuboid.
	 * Next this start "updateSign" that update the sign which show the number of player inside.
	 * 
	 * @param event
	 * @author Falcort alias Thibault SOUQUET
	 * @version 0.2
	 */
	@EventHandler
	public void onMove(PlayerMoveEvent event)
	{
		Location playerLoc;
		numberPlayerInArea = 0;
		for(Player player: Bukkit.getOnlinePlayers())
		{
			playerLoc = player.getLocation();
			if (cuboid.containsLocation(playerLoc))
			{
				numberPlayerInArea++;
			}
			updateSign();
		}
		numberPlayerInArea = 0;
	}
	
	/**
	 * JavaDoc onPlayerInteract
	 * This method listen for a player to interact with an object.
	 * If the interaction is a right click, then i go next, if it do nothing.
	 * Next i make a couple of check for the 2 sign and validate
	 * 
	 * @param event
	 * @author Falcort alias Thibault SOUQUET
	 * @version 0.2
	 */
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event)
	{
		if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
		{
			if(event.getClickedBlock().getLocation().equals(SignEnter) && complet == false)
			{
				event.getPlayer().teleport(SignEnterTP);
			}
			else if(event.getClickedBlock().getLocation().equals(SignExit))
			{
				event.getPlayer().teleport(SignExitTP);
			}
		}
	}
	
	/**
	 * JavaDoc onPlayerLogin
	 * this method teleport the player if the login into the cuboid
	 * This mays apply if a player disconnect in the cuboid, there will not be 6/5 donjons
	 * 
	 * @author Falcort alias Thibault SOUQUET
	 * @version 0.2
	 */
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent event)
	{
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
		{
			public void run()
			{
				if (cuboid.containsLocation(event.getPlayer().getLocation()))
				{
					event.getPlayer().teleport(SignExitTP);
				}
			}
		}, 60);
	}
	
	/**
	 * JavaDoc PlaceSign
	 * This method replace the Signs if they are missing
	 * 
	 * @author Falcort alias Thibault SOUQUET
	 * @version 0.1
	 */
	@SuppressWarnings("deprecation")
	private void placeSign()
	{
		SignEnter.getBlock().setType(Material.WALL_SIGN);
		SignEnter.getBlock().setData((byte)0x04);
		SignExit.getBlock().setType(Material.WALL_SIGN);
		SignExit.getBlock().setData((byte)0x05);
		Block b = SignExit.getBlock();
		Sign s = (Sign) b.getState();
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
		{
			public void run()
			{
				s.setLine(1, "Quittez ?");
				s.update();
			}
		}, 30);
	}
	
	/**
	 * JavaDoc PlaceSign
	 * This method update the sign content
	 * If there is place, the uodate show the amout of player in the area
	 * Else the update prevent prevent the teleportation from the sign
	 * 
	 * @author Falcort alias Thibault SOUQUET
	 * @version 0.3
	 */
	private void updateSign()
	{
		Block b = SignEnter.getBlock();
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
