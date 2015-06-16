package com.robo.plus.doors;

import com.robo.plus.info.ModInfo;

import net.malisis.doors.door.DoorDescriptor;
import net.malisis.doors.door.DoorRegistry;
import net.malisis.doors.door.movement.RotatingDoorMovement;
import net.malisis.doors.door.sound.VanillaDoorSound;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MalisisDoor extends DoorDescriptor {

	public MalisisDoor(String unlocalizedName, Material material, ItemStack constructionStack) {
		setMaterial(material);
		if (material == Material.iron) {
			setSoundType(Block.soundTypeMetal);
			setOpeningTime(6);
			setHardness(5.0F);
			setRequireRedstone(true);
		} else if (material == Material.rock ) {
			setSoundType(Block.soundTypeStone);
			setOpeningTime(12);
			setHardness(4.0F);
			setRequireRedstone(false);
		} else {
			setSoundType(Block.soundTypeWood);
			setOpeningTime(4);
			setHardness(3.0F);
			setRequireRedstone(false);
		}
		try {
			if ( this.getClass().getMethod("setMaxStackSize", int.class) != null) {
				setMaxStackSize(64);
			}
		} catch (Exception e) {}
		setName(unlocalizedName);
		if (!unlocalizedName.equals("door_wood") && !unlocalizedName.equals("door_iron")) {
			setTextureName(ModInfo.MODID + ":" + unlocalizedName);
		} else {
			setTextureName(unlocalizedName);
		}
		setMovement(DoorRegistry.getMovement(RotatingDoorMovement.class)); 
		setSound(DoorRegistry.getSound(VanillaDoorSound.class));
		setDoubleDoor(true);

		setTab(CreativeTabs.tabRedstone);

		// setRecipe(new Object[] { "AA", "AA", "AA", 'A', constructionStack });
	}


}
