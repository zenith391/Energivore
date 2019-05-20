package io.zenith391.energivore.tiles;

import io.zenith391.energivore.init.BlocksInit;
import nerdhub.cardinalenergy.impl.EnergyStorage;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.Direction;

public class BlockEntityCable extends BECapacitor {

	public BlockEntityCable() {
		this(0);
	}
	
	public BlockEntityCable(int size) {
		super(BlocksInit.CABLE);
		storage = new EnergyStorage(size);
	}
	
	@Override
	public EnergyStorage getEnergyStorage(Direction direction) {
		BlockState state = world.getBlockState(pos);
		
		return storage;
	}
	
}
