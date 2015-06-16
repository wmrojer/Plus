package com.robo.plus.blocks;

import com.robo.plus.config.ConfigHandler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCobblestoneWall extends BlockWall {

	public BlockCobblestoneWall(Block p_i45435_1_) {
		super(p_i45435_1_);
		setBlockName("cobbleWall");
	}

	@Override
	public boolean canConnectWallTo(IBlockAccess blockAccess, int x, int y, int z) {
        Block block = blockAccess.getBlock(x, y, z);
        boolean flag = (ConfigHandler.interconnectWalls && block instanceof BlockWall) || block == this;
        return !flag && !(block instanceof BlockFenceGate) ? (block.getMaterial().isOpaque() && block.renderAsNormalBlock() ? block.getMaterial() != Material.gourd : false) : true;
	}

	@Override
	public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
		return true;
	}

}
