package io.zenith391.energivore.init;

import java.util.HashMap;

import io.zenith391.energivore.EnergivoreMod;
import io.zenith391.energivore.block.BlockCapacitorT1;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlocksInit {

	public static final HashMap<String, Block> REGISTERED_BLOCKS = new HashMap<>();
	
	public static BlockCapacitorT1 capacitorT1;
	
	public static void register(String id, Block b) {
		REGISTERED_BLOCKS.put(id, b);
		Identifier identifier = new Identifier(EnergivoreMod.MODID, id);
		Registry.BLOCK.add(identifier, b);
	}
	
	public static void registerAll() {
		capacitorT1 = new BlockCapacitorT1();
		
		register("capacitor_tier1", capacitorT1);
	}
	
}
