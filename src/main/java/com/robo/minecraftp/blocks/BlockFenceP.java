package com.robo.minecraftp.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFenceP extends BlockFence {

	private Block textureBlock;
	private int meta;
	
	public BlockFenceP(Block block) {
		this(block, 0);
	}

	public BlockFenceP(Block block, int meta) {
		super("", block.getMaterial());
		textureBlock = block;
		this.meta = meta;
	}

	@Override
	public boolean canConnectFenceTo(IBlockAccess blockAccess, int x, int y, int z) {
        Block block = blockAccess.getBlock(x, y, z);
        return !(block instanceof BlockFence) && !(block instanceof BlockFenceGate) ? (block.getMaterial().isOpaque() && block.renderAsNormalBlock() ? block.getMaterial() != Material.gourd : false) : true;
		
	}

	@Override
	public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
		return true;
	}

	@Override
    @SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return textureBlock.getIcon(side, this.meta);
	}

	@Override
    @SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_) {
	}

}
