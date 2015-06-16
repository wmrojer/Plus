package com.robo.plus.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockFenceGateP extends BlockFenceGate {

	private Block textureBlock;
	private int meta;
	
	public BlockFenceGateP(Block block) {
		this(block, 0);
	}

	public BlockFenceGateP(Block block, int meta) {
		super();
		textureBlock = block;
		this.meta = meta;
	}

	@Override
	public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
		return true;
	}

    /**
     * Gets the block's texture. Args: side, meta
     */
	@Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return textureBlock.getIcon(side, this.meta);
    }

}
