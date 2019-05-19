package io.zenith391.energivore.item;

import io.zenith391.energivore.block.IBlockCapacitor;
import io.zenith391.energivore.tiles.BECapacitor;
import nerdhub.cardinal.components.api.ItemComponentProvider;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;

public class EnergyBlockItem extends BlockItem implements ItemComponentProvider {

	public static Settings getSettings(ItemGroup group, Block block) {
		return new Settings().itemGroup(group)
				.stackSize(1)
				.durability((block instanceof IBlockCapacitor) ? ((IBlockCapacitor) block).getCapacity() : 0);
	}
	
	public EnergyBlockItem(Block block, ItemGroup group) {
		super(block, getSettings(group, block));
	}
	
	@Override
	public ActionResult place(ItemPlacementContext context) {
		ActionResult result = super.place(context);
		if (result == ActionResult.SUCCESS) {
			int energy = 0;
			if (context.getItemStack().hasTag()) {
				if (context.getItemStack().getTag().containsKey("energy")) {
					energy = context.getItemStack().getTag().getInt("energy");
				}
			}
			((BECapacitor) context.getWorld().getBlockEntity(context.getBlockPos())).getEnergyStorage(context.getFacing()).setEnergyStored(energy);
		}
		return result;
	}
	
	@Override
	public void createComponents(ItemStack stack) {
		
	}

}
