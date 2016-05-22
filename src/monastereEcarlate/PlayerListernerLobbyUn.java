package monastereEcarlate;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

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
	private int nbPlayerInstance = 5;
	
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
	
	public PlayerListernerLobbyUn(MonastereEcarlate plugin)
	{
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
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
	
	public void updateSign()
	{
		String commande = "blockdata " + sx + " " + sy + " " + sz + " {Text1:\"{\\\"text\\\":\\\"Monastère\\\",\\\"color\\\":\\\"red\\\"}\", Text2:\"{\\\"text\\\":\\\"Instance n°1\\\",\\\"color\\\":\\\"green\\\"}\", Text3:\"{\\\"text\\\":\\\"" + numberPlayerInArea + " / " + nbPlayerInstance + "\\\", \\\"color\\\":\\\"aqua\\\"}\", Text4:\"{\\\"text\\\":\\\"Rejoindre ?\\\", \\\"color\\\":\\\"green\\\", \\\"clickEvent\\\":{\\\"action\\\":\\\"run_command\\\",\\\"value\\\":\\\"tp @p " + tpsx + " " + tpsy + " " + tpsz + "\\\"}}\"}";
		Bukkit.broadcastMessage(commande);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), commande);
	}
}
