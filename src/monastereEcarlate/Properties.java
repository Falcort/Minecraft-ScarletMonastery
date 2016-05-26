package monastereEcarlate;

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
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.SignEnter.TP.x", 24);
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.SignEnter.TP.y", 179);
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.SignEnter.TP.z", 167);

		plugin.getConfig().addDefault("MonastereEcarlate.Instance.SignExit.Coord.x", 22);
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.SignExit.Coord.y", 180);
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.SignExit.Coord.z", 167);
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.SignExit.TP.x", 24);
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.SignExit.TP.y", 179);
		plugin.getConfig().addDefault("MonastereEcarlate.Instance.SignExit.TP.z", 178);

		plugin.getConfig().options().copyDefaults(true);
		plugin.saveConfig();
		
		this.ConstructFromConfig();
	}
	
	public void reload()
	{
		plugin.reloadConfig();
	}
	
	private void ConstructFromConfig()
	{
		String world = plugin.getConfig().getString("MonastereEcarlate.Instance.MapName");
		ZoneTest = new ConstructZone(world, plugin.getConfig().getInt("MonastereEcarlate.Instance.Cuboid.Point1.x"), plugin.getConfig().getInt("MonastereEcarlate.Instance.Cuboid.Point1.y"), plugin.getConfig().getInt("MonastereEcarlate.Instance.Cuboid.Point1.z"), plugin.getConfig().getInt("MonastereEcarlate.Instance.Cuboid.Point2.x"), plugin.getConfig().getInt("MonastereEcarlate.Instance.Cuboid.Point2.y"), plugin.getConfig().getInt("MonastereEcarlate.Instance.Cuboid.Point2.z"));
		SignEnter = new ConstructSignLocs(world, plugin.getConfig().getInt("MonastereEcarlate.Instance.SignEnter.Coord.x"), plugin.getConfig().getInt("MonastereEcarlate.Instance.SignEnter.Coord.y"), plugin.getConfig().getInt("MonastereEcarlate.Instance.SignEnter.Coord.z"), plugin.getConfig().getInt("MonastereEcarlate.Instance.SignEnter.TP.x"), plugin.getConfig().getInt("MonastereEcarlate.Instance.SignEnter.TP.y"), plugin.getConfig().getInt("MonastereEcarlate.Instance.SignEnter.TP.z"));
		SignExit = new ConstructSignLocs(world, plugin.getConfig().getInt("MonastereEcarlate.Instance.SignExit.Coord.x"), plugin.getConfig().getInt("MonastereEcarlate.Instance.SignExit.Coord.y"), plugin.getConfig().getInt("MonastereEcarlate.Instance.SignExit.Coord.z"), plugin.getConfig().getInt("MonastereEcarlate.Instance.SignExit.TP.x"), plugin.getConfig().getInt("MonastereEcarlate.Instance.SignExit.TP.y"), plugin.getConfig().getInt("MonastereEcarlate.Instance.SignExit.TP.z"));
	}
	
	public String getWorld()
	{
		return plugin.getConfig().getString("MonastereEcarlate.Instance.MapName");
	}
	
	public int getInstanceSize()
	{
		return plugin.getConfig().getInt("MonastereEcarlate.Instance.InstanceSize");
	}
	
	public ConstructZone getZoneTest()
	{
		return ZoneTest;
	}
	
	public ConstructSignLocs getSignEntrer()
	{
		return SignEnter;
	}
	
	public ConstructSignLocs getSignExit()
	{
		return SignExit;
	}
}
