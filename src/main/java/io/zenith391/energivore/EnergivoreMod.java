package io.zenith391.energivore;

import io.zenith391.energivore.init.BlocksInit;
import io.zenith391.energivore.init.ItemsInit;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class EnergivoreMod implements ModInitializer {
	
	public static final String VERSION = "1.0";
	public static final String MODID   = "energivore";
	public static final String MODNAME = "Energivore";
	
	public static final ItemGroup ENERGIVORE_GROUP = FabricItemGroupBuilder.create(
			new Identifier(MODID, "group"))
			.icon(() -> {
				return new ItemStack(ItemsInit.REGISTERED_ITEMS.get("capacitor_tier1"));
			}).build();
	
	@Override
	public void onInitialize() {
		System.out.println("(Energivore) Registering blocks..");
		BlocksInit.registerAll();
		System.out.println("(Energivore) Registering items..");
		ItemsInit.registerAll();
		System.out.println("(Energivore) Registration terminated!");
	}
	
}
