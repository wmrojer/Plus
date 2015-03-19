package com.robo.minecraftp.blocks;

import com.robo.minecraftp.MinecraftP;
import com.robo.minecraftp.config.ConfigHandler;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFenceP extends BlockFence {

	private Block textureBlock;
	private int textureBlockMetadata;
	
	public BlockFenceP(String name, Block block) {
		this(name, block, 0);
	}

	public BlockFenceP(String name, Block block, int meta) {
		super(name, block.getMaterial());
		this.setBlockName(name);
		this.setStepSound(block.stepSound);
		try {
			this.setHardness((Float)ObfuscationReflectionHelper.getPrivateValue(Block.class, block, "blockHardness", "field_149782_v"));
		} catch(Exception e) {
			MinecraftP.log.error("Unable to set blockHardness " + name + ". " + e.getMessage());
		}
		try {
			this.blockResistance = (Float)ObfuscationReflectionHelper.getPrivateValue(Block.class, block, "blockResistance", "field_149781_w");
		} catch(Exception e) {
			MinecraftP.log.error("Unable to set blockResistance for " + name + ". " + e.getMessage());
		}
		textureBlock = block;
		this.textureBlockMetadata = meta;
	}

	@Override
	public boolean canConnectFenceTo(IBlockAccess blockAccess, int x, int y, int z) {
        Block block = blockAccess.getBlock(x, y, z);
        boolean flag = (ConfigHandler.interconnectFences && block instanceof BlockFence) || block == this || (ConfigHandler.connectWallsFences && block instanceof BlockWall);
        return !flag && !(block instanceof BlockFenceGate) ? (block.getMaterial().isOpaque() && block.renderAsNormalBlock() ? block.getMaterial() != Material.gourd : false) : true;
		
	}

	@Override
	public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
		return true;
	}

	@Override
    @SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return textureBlock.getIcon(side, this.textureBlockMetadata);
	}

	@Override
    @SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_) {
	}

}
