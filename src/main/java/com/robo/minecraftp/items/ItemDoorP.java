package com.robo.minecraftp.items;

import com.robo.minecraftp.info.ModInfo;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemDoorP extends ItemDoor {

	private Block doorBlock;
	
	public ItemDoorP(String unlocalizedName, Material material, Block doorBlock) {
		super(material);
        this.maxStackSize = 64;		
		setUnlocalizedName(unlocalizedName);
		setTextureName(ModInfo.MODID + ":" +unlocalizedName);
		this.doorBlock = doorBlock;
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (side != 1)
		{
			return false;
		}
		else
		{
			++y;

			if (player.canPlayerEdit(x, y, z, side, itemStack) && player.canPlayerEdit(x, y + 1, z, side, itemStack))
			{
				if (!doorBlock.canPlaceBlockAt(world, x, y, z))
				{
					return false;
				}
				else
				{
					int i1 = MathHelper.floor_double((player.rotationYaw + 180.0F) * 4.0F / 360.0F - 0.5D) & 3;
					placeDoorBlock(world, x, y, z, i1, doorBlock);
					--itemStack.stackSize;
					return true;
				}
			}
			else
			{
				return false;
			}
		}
	}

}
