package com.robo.plus.blocks;

import java.util.List;
import java.util.Random;

import com.robo.plus.Plus;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockSlabP extends BlockSlab {

    @SideOnly(Side.CLIENT)
    private IIcon sideIcon;
	private Block textureBlock;
	private int textureBlockMetadata;
	private Block halfBlock;
	String sideTexture;
	String topTexture;
	
	public BlockSlabP(String name, boolean doubleSlab, Block block) {
		this(name, doubleSlab, block, 0, null, null);
	}
	
	public BlockSlabP(String name, boolean doubleSlab, Block textureBlock, int textureBlockMetadata, String topTexture, String sideTexture) {
		super(doubleSlab, textureBlock.getMaterial());
		this.setBlockName(name);
		this.setStepSound(textureBlock.stepSound);
		try {
			this.setHardness((Float)ObfuscationReflectionHelper.getPrivateValue(Block.class, textureBlock, "blockHardness", "field_149782_v"));
		} catch(Exception e) {
			Plus.log.error("Unable to set blockHardness " + name + ". " + e.getMessage());
		}
		try {
			this.blockResistance = (Float)ObfuscationReflectionHelper.getPrivateValue(Block.class, textureBlock, "blockResistance", "field_149781_w");
		} catch(Exception e) {
			Plus.log.error("Unable to set blockResistance for " + name + ". " + e.getMessage());
		}
		
		if (!doubleSlab) {
			this.setCreativeTab(CreativeTabs.tabBlock);
			halfBlock = this;
		}
		this.textureBlock = textureBlock;
		this.textureBlockMetadata = textureBlockMetadata;
		this.topTexture = topTexture;
		this.sideTexture = sideTexture;
		this.useNeighborBrightness = true;
		
	}

	public BlockSlabP setHalfBlock(Block block) {
		this.halfBlock = block;
		return this;
	}
	
	@Override
	public String func_150002_b(int metadata) {
		return super.getUnlocalizedName();
	}

	@Override
	public int damageDropped(int metadata) {
		return 0;
	}

	@Override
	public int getDamageValue(World world, int x, int y, int z) {
		return 0;
	}

	@Override
    public Item getItemDropped(int metadata, Random rand, int fortune)
    {
        return Item.getItemFromBlock(halfBlock);
    }

    /**
     * Returns true if the given block is a slab.
     * Args: block
     */
	@SideOnly(Side.CLIENT)
    private static boolean func_150003_a(Block block)
    {
        return block instanceof BlockSlab;
    }

	@Override
    @SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(halfBlock);
	}

    /**
     * Gets the block's texture. Args: side, meta
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return side != 1 && side != 0 ? (sideTexture != null ? this.sideIcon : textureBlock.getIcon(side, this.textureBlockMetadata)) : (topTexture != null ? this.blockIcon : textureBlock.getIcon(side, this.textureBlockMetadata));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
    	if (topTexture != null)
    		this.blockIcon = p_149651_1_.registerIcon(topTexture);
    	if (sideTexture != null)
    		this.sideIcon = p_149651_1_.registerIcon(sideTexture);
    }

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    @SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		if (!this.field_150004_a) { //Only if this is a single slab
			list.add(new ItemStack(item, 1, 0));
		}
	}

    
}
