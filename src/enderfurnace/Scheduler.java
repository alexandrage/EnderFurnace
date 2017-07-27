package enderfurnace;

import org.bukkit.scheduler.BukkitRunnable;

import enderfurnace.events.TickUpdateEvent;

public class Scheduler extends BukkitRunnable {
	Main plugin;

	Scheduler(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public void run() {
		this.plugin.getServer().getPluginManager().callEvent(new TickUpdateEvent());
	}
}