package io.zenith391.energivore.block;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IBlockCapacitor {

	public int getCapacity();
	public int getEnergy(World world, BlockPos pos);
	public int getEnergy(World world, BlockEntity tile);
	
}
