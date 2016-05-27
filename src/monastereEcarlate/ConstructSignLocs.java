package monastereEcarlate;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class ConstructSignLocs
{
	private Location Sign;
	private Location SignTP;
	
	/**
	 * JavaDoc Constructor ConstructSignLocs
	 * This class create location for the sign, and the teleport of the sign
	 * This version use double, and add the Eyes locations (Yaw, Pitch) for the Location
	 * 
	 * @param world
	 * @param SignX
	 * @param SignY
	 * @param SignZ
	 * @param SignTpX
	 * @param SignTpY
	 * @param SignTpZ
	 * @param SignTpYaw
	 * @param SignTpPicth
	 * @author Falcort alias Thibault SOUQUET
	 * @version 1
	 */
	public ConstructSignLocs(String world, double SignX, double SignY, double SignZ, double SignTpX, double SignTpY, double SignTpZ, float Yaw, float Pitch)
	{
		Sign = new Location(Bukkit.getServer().getWorld(world), SignX, SignY, SignZ);
		SignTP = new Location(Bukkit.getServer().getWorld(world), SignTpX, SignTpY, SignTpZ, Yaw, Pitch);
	}
	
	/**
	 * JavaDoc Constructor ConstructSignLocs
	 * This class create location for the sign, and the teleport of the sign
	 * 
	 * @param world
	 * @param SignX
	 * @param SignY
	 * @param SignZ
	 * @param SignTpX
	 * @param SignTpY
	 * @param SignTpZ
	 * @author Falcort alias Thibault SOUQUET
	 * @version 1
	 */
	public ConstructSignLocs(String world, int SignX, int SignY, int SignZ, int SignTpX, int SignTpY, int SignTpZ)
	{
		Sign = new Location(Bukkit.getServer().getWorld(world), SignX, SignY, SignZ);
		SignTP = new Location(Bukkit.getServer().getWorld(world), SignTpX, SignTpY, SignTpZ);
	}
	
	/**
	 * JavaDoc getSign
	 * Return the Sign Location
	 * 
	 * @return Sign
	 * @author Falcort alias Thibault SOUQUET
	 * @version 1
	 */
	public Location getSign()
	{
		return Sign;
	}
	
	/**
	 * JavaDoc getSignTP
	 * Return the Sign Location
	 * 
	 * @return SignTP
	 * @author Falcort alias Thibault SOUQUET
	 * @version 1
	 */
	public Location getSignTP()
	{
		return SignTP;
	}
}
