package com.robo.minecraftp.blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSlabP extends BlockSlab {

    @SideOnly(Side.CLIENT)
    private IIcon sideIcon;
	private Block textureBlock;
	private int meta;
	private Block halfBlock;
	String sideTexture;
	String topTexture;
	
	public BlockSlabP(boolean doubleSlab, Block block) {
		this(doubleSlab, block, 0, null, null);
	}
	
	public BlockSlabP(boolean doubleSlab, Block block, int metadata, String topTexture, String sideTexture) {
		super(doubleSlab, block.getMaterial());
		if (!doubleSlab) {
			this.setCreativeTab(CreativeTabs.tabBlock);
		}
		textureBlock = block;
		if (!doubleSlab) {
			halfBlock = this;
		}
		this.meta = metadata;
		this.topTexture = topTexture;
		this.sideTexture = sideTexture;
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
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side)
    {
    	boolean renderSide = super.shouldSideBeRendered(blockAccess, x, y, z, side);
        if (this.field_150004_a)
        {
            return renderSide;
        }
        else if (side != 1 && side != 0 && !renderSide)
        {
            return false;
        }
        else
        {
            int i1 = x + Facing.offsetsXForSide[Facing.oppositeSide[side]];
            int j1 = y + Facing.offsetsYForSide[Facing.oppositeSide[side]];
            int k1 = z + Facing.offsetsZForSide[Facing.oppositeSide[side]];
            if (func_150003_a(blockAccess.getBlock(i1, j1, k1))) {
            	boolean flag = (blockAccess.getBlockMetadata(i1, j1, k1) & 8) != 0;
//            	boolean flag2 = (blockAccess.getBlockMetadata(x, y, z) & 8) == 0;
            	return flag ? (side == 0 ? true : (side == 1 && renderSide ? true : renderSide)) 
            		    : (side == 1 ? true : (side == 0 && renderSide ? true : renderSide));
            }
            return renderSide;
//            return flag ? (side == 0 ? true : (side == 1 && super.shouldSideBeRendered(blockAccess, x, y, z, side) ? true : !func_150003_a(blockAccess.getBlock(x, y, z)) || (blockAccess.getBlockMetadata(x, y, z) & 8) == 0)) 
//            		    : (side == 1 ? true : (side == 0 && super.shouldSideBeRendered(blockAccess, x, y, z, side) ? true : !func_150003_a(blockAccess.getBlock(x, y, z)) || (blockAccess.getBlockMetadata(x, y, z) & 8) != 0));
        }
    }

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
        return side != 1 && side != 0 ? (sideTexture != null ? this.sideIcon : textureBlock.getIcon(side, this.meta)) : (topTexture != null ? this.blockIcon : textureBlock.getIcon(side, this.meta));
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
