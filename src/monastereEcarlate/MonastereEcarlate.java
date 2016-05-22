package monastereEcarlate;

import org.bukkit.plugin.java.JavaPlugin;

public class MonastereEcarlate extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		new PlayerListernerLobbyUn(this);
	}
}
