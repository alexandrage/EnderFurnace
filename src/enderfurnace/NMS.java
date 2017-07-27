package enderfurnace;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftInventoryFurnace;
import org.bukkit.inventory.FurnaceInventory;

import net.minecraft.server.v1_12_R1.TileEntityFurnace;

public class NMS {
	public static HashMap<String, TileEntityFurnace> tiles = new HashMap<String, TileEntityFurnace>();
	public static HashMap<String, FurnaceInventory> furnaces = new HashMap<String, FurnaceInventory>();
	public static void put(String name) {
		int x = 10000000;
		int y = 255;
		int z = 10000000;
		World w = Bukkit.getWorlds().get(0);
		w.getBlockAt(x, y, z).setType(Material.FURNACE);
		TileEntityFurnace furnace = ((TileEntityFurnace) (((CraftWorld) w).getTileEntityAt(x, y, z)));
		furnace.setCustomName("Ender furnace");
		tiles.put(name, furnace);
		furnaces.put(name, new CraftInventoryFurnace(furnace));
		w.getBlockAt(x, y, z).setType(Material.AIR);
	}
}