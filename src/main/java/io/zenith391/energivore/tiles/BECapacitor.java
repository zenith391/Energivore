package io.zenith391.energivore.tiles;

import nerdhub.cardinalenergy.api.IEnergyHandler;
import nerdhub.cardinalenergy.impl.EnergyStorage;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.math.Direction;

public class BECapacitor extends BlockEntity implements IEnergyHandler {

	private EnergyStorage storage;
	
	public BECapacitor(int size) {
		super(null);
		storage = new EnergyStorage(size);
	}
	
	public CompoundTag toTag(CompoundTag tag) {
		super.toTag(tag);
		storage.writeEnergyToTag(tag);
		return tag;
	}
	
	public void fromTag(CompoundTag tag) {
		super.fromTag(tag);
		storage.readEnergyFromTag(tag);
	}

	@Override
	public EnergyStorage getEnergyStorage(Direction direction) {
		return storage;
	}

}
