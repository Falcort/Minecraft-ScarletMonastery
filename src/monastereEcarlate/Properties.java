package monastereEcarlate;

import org.bukkit.Bukkit;

public class Properties
{
	private MonastereEcarlate plugin;
	private ConstructZone ZoneTest;
	private ConstructSignLocs SignEnter;
	private ConstructSignLocs SignExit;
	
	/**
	 * JavaDoc Construcor Properties
	 * This class import the configuration file and read the text
	 * The constructor chack if the directory or the file exist and creat them if needed
	 * 
	 * @author Falcort alias Thibault SOUQUET
	 * @version 0.1
	 */
	public Properties(MonastereEcarlate plugin)
	{
		this.plugin = plugin;
	}
	
	/**
	 * JavaDoc loadConfiguration
	 * This method create of load the default config of the plugin
	 * Then laucnh the private method to construct the object
	 * 
	 * @author Falcort alias Thibault SOUQUET
	 * @version 0.1
	 */
	public void loadConfiguration()
	{
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.InstanceName", "Monastère");
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.Number", 1);
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.MapName", "survival");
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.InstanceSize", 5);

		plugin.getConfig().addDefault("MonastereEcarlate.Instance.Cuboid.Point1.x", 21);
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.Cuboid.Point1.y", 175);
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.Cuboid.Point1.z", 164);
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.Cuboid.Point2.x", 31);
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.Cuboid.Point2.y", 190);
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.Cuboid.Point2.z", 170);

		plugin.getConfig().addDefault("MonastereEcarlate.Instance.SignEnter.Coord.x", 27);
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.SignEnter.Coord.y", 180);
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.SignEnter.Coord.z", 176);
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.SignEnter.TP.x", 24.5);
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.SignEnter.TP.y", 179);
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.SignEnter.TP.z", 167.5);
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.SignEnter.TP.Yaw", -90);
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.SignEnter.TP.Pitch", 0);

		plugin.getConfig().addDefault("MonastereEcarlate.Instance.SignExit.Coord.x", 22);
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.SignExit.Coord.y", 180);
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.SignExit.Coord.z", 167);
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.SignExit.TP.x", 24.5);
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.SignExit.TP.y", 179);
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.SignExit.TP.z", 178.5);
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.SignExit.TP.Yaw", -90);
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.SignExit.TP.Pitch", 0);

		plugin.getConfig().options().copyDefaults(true);
		plugin.saveConfig();
		
		this.ConstructFromConfig();
	}
	
	/**
	 * JavaDoc reload
	 * This method just reload the config file of the plugin
	 * 
	 * @author Falcort alias Thibault SOUQUET
	 * @version 0.1
	 */
	public void reload()
	{
		plugin.reloadConfig();
	}
	
	/**
	 * JavaDoc ConstructFromConfig
	 * This method construct the object needed for the plugin
	 * 
	 * @author Falcort alias Thibault SOUQUET
	 * @version 0.1
	 */
	private void ConstructFromConfig()
	{
		Bukkit.broadcastMessage("" + (float) plugin.getConfig().getDouble("MonastereEcarlate.Instance.SignEnter.TP.x"));
		Bukkit.broadcastMessage("" + (float) plugin.getConfig().getDouble("MonastereEcarlate.Instance.SignEnter.TP.z"));
		String world = plugin.getConfig().getString("MonastereEcarlate.Instance.MapName");
		ZoneTest = new ConstructZone(world, plugin.getConfig().getInt("MonastereEcarlate.Instance.Cuboid.Point1.x"), plugin.getConfig().getInt("MonastereEcarlate.Instance.Cuboid.Point1.y"), plugin.getConfig().getInt("MonastereEcarlate.Instance.Cuboid.Point1.z"), plugin.getConfig().getInt("MonastereEcarlate.Instance.Cuboid.Point2.x"), plugin.getConfig().getInt("MonastereEcarlate.Instance.Cuboid.Point2.y"), plugin.getConfig().getInt("MonastereEcarlate.Instance.Cuboid.Point2.z"));
		SignEnter = new ConstructSignLocs(world, plugin.getConfig().getDouble("MonastereEcarlate.Instance.SignEnter.Coord.x"), plugin.getConfig().getDouble("MonastereEcarlate.Instance.SignEnter.Coord.y"), plugin.getConfig().getDouble("MonastereEcarlate.Instance.SignEnter.Coord.z"), plugin.getConfig().getDouble("MonastereEcarlate.Instance.SignEnter.TP.x"), plugin.getConfig().getDouble("MonastereEcarlate.Instance.SignEnter.TP.y"), plugin.getConfig().getDouble("MonastereEcarlate.Instance.SignEnter.TP.z"), (float) plugin.getConfig().getDouble("MonastereEcarlate.Instance.SignEnter.TP.Yaw"), (float) plugin.getConfig().getDouble("MonastereEcarlate.Instance.SignEnter.TP.Picth"));
		SignExit = new ConstructSignLocs(world, plugin.getConfig().getDouble("MonastereEcarlate.Instance.SignExit.Coord.x"), plugin.getConfig().getDouble("MonastereEcarlate.Instance.SignExit.Coord.y"), plugin.getConfig().getDouble("MonastereEcarlate.Instance.SignExit.Coord.z"), plugin.getConfig().getDouble("MonastereEcarlate.Instance.SignExit.TP.x"), plugin.getConfig().getDouble("MonastereEcarlate.Instance.SignExit.TP.y"), plugin.getConfig().getDouble("MonastereEcarlate.Instance.SignExit.TP.z"), (float) plugin.getConfig().getDouble("MonastereEcarlate.Instance.SignExit.TP.Yaw"), (float) plugin.getConfig().getDouble("MonastereEcarlate.Instance.SignExit.TP.Picth"));
	}
	
	/**
	 * JavaDoc getWorld
	 * This method return the MapName
	 * The map name is taken from the config file
	 *
	 * @author Falcort alias Thibault SOUQUET
	 * @version 0.1
	 * @return MapName
	 */
	public String getWorld()
	{
		return plugin.getConfig().getString("MonastereEcarlate.Instance.MapName");
	}
	
	/**
	 * JavaDoc getInstanceSize
	 * This method return the InstanceSize
	 * The InstanceSiez is taken from the config file
	 * 
	 * @author Falcort alias Thibault SOUQUET
	 * @version 0.1
	 * @return IstanceSize
	 */
	public int getInstanceSize()
	{
		return plugin.getConfig().getInt("MonastereEcarlate.Instance.InstanceSize");
	}
	
	/**
	 * JavaDoc getZoneTest
	 * This method return the Object ConstructZone
	 * All the agruments needed to construct the object are taken from the config file
	 * 
	 * @author Falcort alias Thibault SOUQUET
	 * @version 0.1
	 * @return ZoneTest
	 */
	public ConstructZone getZoneTest()
	{
		return ZoneTest;
	}
	
	/**
	 * JavaDoc getSignEnter
	 * This method return the Object SignEnter
	 * All the agruments needed to construct the object are taken from the config file
	 * 
	 * @author Falcort alias Thibault SOUQUET
	 * @version 0.1
	 * @return SignEnter
	 */
	public ConstructSignLocs getSignEnter()
	{
		return SignEnter;
	}
	
	/**
	 * JavaDoc getSignExit
	 * This method return the Object SignExit
	 * All the agruments needed to construct the object are taken from the config file
	 * 
	 * @author Falcort alias Thibault SOUQUET
	 * @version 0.1
	 * @return SignExit
	 */
	public ConstructSignLocs getSignExit()
	{
		return SignExit;
	}
}
