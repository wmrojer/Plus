package com.robo.plus.blocks;

import java.util.List;

import com.robo.plus.config.ConfigHandler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockWallP extends BlockWall {

	private Block textureBlock;
	private int textureBlockMetadata;
	
	public BlockWallP(Block block) {
		this(block, 0);
	}

	public BlockWallP(Block block, int metadata) {
		super(block);
		textureBlock = block;
		this.textureBlockMetadata = metadata;
	}

	@Override
	public boolean canConnectWallTo(IBlockAccess blockAccess, int x, int y, int z) {
        Block block = blockAccess.getBlock(x, y, z);
        boolean flag = (ConfigHandler.interconnectWalls && block instanceof BlockWall) || block == this || (ConfigHandler.connectWallsFences && block instanceof BlockFence);
        return !flag && !(block instanceof BlockFenceGate) ? (block.getMaterial().isOpaque() && block.renderAsNormalBlock() ? block.getMaterial() != Material.gourd : false) : true;
	}

	@Override
	public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
		return true;
	}

	@Override
	public int damageDropped(int p_149692_1_) {
		return 0;
	}

	@Override
    @SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
        return textureBlock.getIcon(side, this.textureBlockMetadata);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    @SideOnly(Side.CLIENT)
	public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_,List p_149666_3_) {
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
	}

}
