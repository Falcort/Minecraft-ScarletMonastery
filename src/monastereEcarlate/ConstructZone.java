package monastereEcarlate;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class ConstructZone
{
	private Location aLoc;
	private Location bLoc;
	private Cuboid cuboid;
	
	/**
	 * JavaDoc Constructor ConstructZone
	 * This class is here to build the cuboid of the first lobby
	 * 
	 * @param world
	 * @param ax
	 * @param ay
	 * @param az
	 * @param bx
	 * @param by
	 * @param bz
	 * @author Falcort alias Thibault SOUQUET
	 * @version 1
	 */
	public ConstructZone(String world, int ax, int ay, int az, int bx, int by, int bz)
	{
		aLoc = new Location(Bukkit.getServer().getWorld(world), ax, ay, az);
		bLoc = new Location(Bukkit.getServer().getWorld(world), bx, by, bz);
		cuboid = new Cuboid(aLoc, bLoc);
	}
	
	/**
	 * JavaDoc getCuboid
	 * This method return the cuboid create by the 2 location given in arguments
	 * 
	 * @return cuboid
	 * @author Falcort alias Thibault SOUQUET
	 * @version 1
	 */
	public Cuboid getCuboid()
	{
		return cuboid;
	}
}
