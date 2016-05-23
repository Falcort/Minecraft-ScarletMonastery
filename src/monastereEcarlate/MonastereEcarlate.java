package monastereEcarlate;

import org.bukkit.plugin.java.JavaPlugin;

public class MonastereEcarlate extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		ConstructZone ZoneTest = new ConstructZone("world", -213, 70, 247, -218, 75, 241);
		ConstructSignLocs SignEnter = new ConstructSignLocs("world", -216, 71, 248, -216, 70, 243);
		ConstructSignLocs SignExit = new ConstructSignLocs("world", -216, 71, 242, -217, 84, 253);
		new LobbySystem(this, "world", 1, ZoneTest, SignEnter, SignExit);
	}
}