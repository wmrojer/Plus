package com.robo.minecraftp.doors;

import com.robo.minecraftp.info.ModInfo;

import net.malisis.doors.door.DoorDescriptor;
import net.malisis.doors.door.DoorRegistry;
import net.malisis.doors.door.movement.RotatingDoorMovement;
import net.malisis.doors.door.sound.VanillaDoorSound;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class WoodDoor extends DoorDescriptor {

	public WoodDoor(String unlocalizedName, ItemStack constructionStack ) {

		setMaterial(Material.wood); 
		setSoundType(Block.soundTypeWood); 
		setHardness(3.0F); 

		setMaxStackSize(64);
		setName(unlocalizedName);
		setTextureName(ModInfo.MODID + ":" + unlocalizedName);
		setMovement(DoorRegistry.getMovement(RotatingDoorMovement.class)); 
		setSound(DoorRegistry.getSound(VanillaDoorSound.class));
		setOpeningTime(6);
		setDoubleDoor(true);
		setRequireRedstone(false);

		setTab(CreativeTabs.tabRedstone);

		// setRecipe(new Object[] { "AA", "AA", "AA", 'A', constructionStack });
	}


}
