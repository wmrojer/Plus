package com.robo.minecraftp.items;

import com.robo.minecraftp.blocks.BlockSlabP;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

public class ItemSlabP extends ItemSlab {

	public ItemSlabP(Block block, BlockSlabP single_slab, BlockSlabP double_slab, Boolean isDoubleSlab) {
		super(block, single_slab, double_slab, isDoubleSlab);
	}

}
