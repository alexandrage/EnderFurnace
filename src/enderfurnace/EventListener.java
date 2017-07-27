package enderfurnace;

import org.bukkit.Bukkit;
import org.bukkit.block.BlockState;
import org.bukkit.block.Furnace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import enderfurnace.events.TickUpdateEvent;

public class EventListener implements Listener {
	Main plugin;

	EventListener(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void on(TickUpdateEvent e) {
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (!NMS.furnaces.containsKey(p.getName())) {
				new SyncScheduler(p.getName()).runTaskLater(this.plugin, 0);
			} else {
				try {
					NMS.tiles.get(p.getName()).e();
				} catch (Exception x) {

				}
			}
		}
	}

	@EventHandler
	public void on(PlayerInteractEvent e) {
		if (e.getAction() != Action.RIGHT_CLICK_BLOCK)
			return;
		BlockState state = e.getClickedBlock().getState();
		if (state instanceof Furnace) {
			Furnace f = (Furnace) state;
			String name = f.getCustomName();
			if (name == null)
				return;
			if (name.contains("Ender")) {
				e.setCancelled(true);
				Player p = e.getPlayer();
				p.openInventory(NMS.furnaces.get(p.getName()));
			}
		}
	}
}