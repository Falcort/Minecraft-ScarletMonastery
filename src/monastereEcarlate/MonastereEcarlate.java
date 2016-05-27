package monastereEcarlate;

import org.bukkit.plugin.java.JavaPlugin;

public class MonastereEcarlate extends JavaPlugin
{
	@Override
	public void onEnable()
	{

		Properties properties = new Properties(this);

		properties.loadConfiguration();

		new LobbySystem(this, properties.getWorld(), properties.getInstanceSize(), properties.getZoneTest(), properties.getSignEnter(), properties.getSignExit());

	}
}