package com.robo.minecraftp.blocks;

import java.util.Random;

import com.robo.minecraftp.info.ModInfo;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockDoorP extends BlockDoor {

	private Item doorItem;
	
	public BlockDoorP(String unlocalizedName, Material material) {
		super(material);
		setBlockName(unlocalizedName);
		if (!unlocalizedName.equals("door_wood") && !unlocalizedName.equals("door_iron")) {
			setBlockTextureName(ModInfo.MODID + ":" + unlocalizedName);
		} else {
			setBlockTextureName(unlocalizedName);
		}
	}

	public void setDoorItem(Item doorItem) {
		this.doorItem = doorItem;
	}
	
	@Override
	public Item getItem(World world, int x, int y, int z)
	{
		return doorItem;
	}

	@Override
	public Item getItemDropped(int metadata, Random rand, int fortuneLevel)
	{
		return (metadata & 8) != 0 ? null : doorItem;
	}

}
