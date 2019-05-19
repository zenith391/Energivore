package io.zenith391.energivore.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import io.zenith391.energivore.init.ItemsInit;
import io.zenith391.energivore.tiles.BECapacitor;
import nerdhub.cardinal.components.api.BlockComponentProvider;
import nerdhub.cardinal.components.api.ComponentType;
import nerdhub.cardinal.components.api.component.Component;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.loot.context.LootContextParameters;
import net.minecraft.world.loot.context.LootContext.Builder;

public class BlockCapacitorT1 extends BlockWithEntity implements BlockComponentProvider, IBlockCapacitor {

	public BlockCapacitorT1() {
		super(FabricBlockSettings.of(Material.METAL)
				.build());
		
	}
	
	@Override
	public List<ItemStack> getDroppedStacks(BlockState state, Builder builder) {
		ItemStack stack = new ItemStack(ItemsInit.REGISTERED_ITEMS.get("capacitor_tier1"));
		stack.setAmount(1);
		CompoundTag tag = new CompoundTag();
		tag.putInt("energy", getEnergy(builder.getWorld(), builder.getNullable(LootContextParameters.BLOCK_ENTITY).getPos()));
		stack.setTag(tag);
		stack.setDamage(tag.getInt("energy"));
		ArrayList<ItemStack> list = new ArrayList<>();
		list.add(stack);
		return list;
	}
	
	@Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return new BECapacitor(getCapacity());
    }

    /**
     * Check if the ComponentType given is the Cardinal Energy Component
     *
     */
    @Override
    public <T extends Component> boolean hasComponent(BlockView blockView, BlockPos pos, ComponentType<T> type, Direction side) {
        return type == null; // cardinal energy not yet updated
    }

    /**
     * Get the IEnergyHandler Component the ComponentType given is the Cardinal Energy Component
     */
    @Override
    public <T extends Component> T getComponent(BlockView blockView, BlockPos pos, ComponentType<T> type, Direction side) {
        //return type == DefaultTypes.CARDINAL_ENERGY ? (T) blockView.getBlockEntity(pos) :  null;
    	return null;
    }

    /**
     * Get a list of all valid components this block supports
     */
    @Override
    public Set<ComponentType<? extends Component>> getComponentTypes(BlockView blockView, BlockPos pos, Direction side) {
        //return Collections.singleton(DefaultTypes.CARDINAL_ENERGY);
        return null;
	}

	@Override
	public int getCapacity() {
		return 15000;
	}

	@Override
	public int getEnergy(World world, BlockPos pos) {
		return ((BECapacitor) world.getBlockEntity(pos)).getEnergyStorage(Direction.UP).getEnergyStored();
	}
    

}
