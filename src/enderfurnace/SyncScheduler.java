package enderfurnace;

import org.bukkit.scheduler.BukkitRunnable;

public class SyncScheduler extends BukkitRunnable {
	String name;

	SyncScheduler(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		NMS.put(this.name);
	}
}