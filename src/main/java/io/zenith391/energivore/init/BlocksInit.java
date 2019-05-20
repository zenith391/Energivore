package io.zenith391.energivore.init;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import io.zenith391.energivore.EnergivoreMod;
import io.zenith391.energivore.block.BlockCableT1;
import io.zenith391.energivore.block.BlockCapacitorT1;
import io.zenith391.energivore.tiles.BECapacitor;
import io.zenith391.energivore.tiles.BlockEntityCable;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlocksInit {

	public static final HashMap<String, Block> REGISTERED_BLOCKS = new HashMap<>();
	public static BlockEntityType<BECapacitor> CAPACITOR; 
	public static BlockEntityType<BlockEntityCable> CABLE;
	
	public static BlockCapacitorT1 capacitorT1;
	public static BlockCableT1     cableT1;
	
	public static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(String id, Class<T> clazz) {
		BlockEntityType<T> type = new BlockEntityType<T>(() -> {
			try {
				return clazz.getConstructor().newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				System.err.println("COULD NOT INSTANCE " + clazz);
				return null;
			}
		}, null, null);
		Registry.register(Registry.BLOCK_ENTITY, new Identifier(EnergivoreMod.MODID, id), type);
		return type;
	}
	
	public static void register(String id, Block b) {
		REGISTERED_BLOCKS.put(id, b);
		Identifier identifier = new Identifier(EnergivoreMod.MODID, id);
		Registry.BLOCK.add(identifier, b);
	}
	
	public static void registerAll() {
		capacitorT1 = new BlockCapacitorT1();
		cableT1     = new BlockCableT1();
		
		CAPACITOR = registerBlockEntity("capacitor", BECapacitor.class);
		CABLE     = registerBlockEntity("cable", BlockEntityCable.class);
		
		register("capacitor_tier1", capacitorT1);
		register("cable_tier1", cableT1);
	}
	
}
