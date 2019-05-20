package io.zenith391.energivore.item;

import java.util.List;

import io.zenith391.energivore.block.IBlockCapacitor;
import io.zenith391.energivore.tiles.BECapacitor;
import nerdhub.cardinal.components.api.ItemComponentProvider;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class EnergyBlockItem extends BlockItem {
	
	public static Settings getSettings(ItemGroup group, Block block) {
		return new Settings().itemGroup(group)
				.stackSize(1);
	}
	
	public EnergyBlockItem(Block block, ItemGroup group) {
		super(block, getSettings(group, block));
	}
	
	@Override
	public void buildTooltip(ItemStack stack, World world, List<Component> components, TooltipContext context) {
		if (stack.hasTag()) {
			if (stack.getTag().containsKey("energy")) {
				int energy = stack.getTag().getInt("energy");
				components.add(new TextComponent(energy + "/" + ((IBlockCapacitor) getBlock()).getCapacity() + " CE"));
			}
		}
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

}
