package io.zenith391.energivore.init;

import java.util.HashMap;

import io.zenith391.energivore.EnergivoreMod;
import io.zenith391.energivore.item.EnergyBlockItem;
import nerdhub.cardinal.components.api.BlockComponentProvider;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemsInit {

	public static final HashMap<String, Item> REGISTERED_ITEMS = new HashMap<>();
	
	public static void register(String id, Item i) {
		REGISTERED_ITEMS.put(id, i);
		Identifier identifier = new Identifier(EnergivoreMod.MODID, id);
		Registry.ITEM.add(identifier, i);
	}
	
	public static void registerAll() {
		for (String key : BlocksInit.REGISTERED_BLOCKS.keySet()) {
			Block b = BlocksInit.REGISTERED_BLOCKS.get(key);
			if (b instanceof BlockComponentProvider) {
				register(key, new EnergyBlockItem(b, EnergivoreMod.ENERGIVORE_GROUP));
			} else {
				register(key, new BlockItem(b, new Item.Settings().itemGroup(EnergivoreMod.ENERGIVORE_GROUP)));
			}
		}
	}
	
}
