package com.robo.minecraftp.doors;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.robo.minecraftp.MinecraftP;
import com.robo.minecraftp.blocks.BlockDoorP;
import com.robo.minecraftp.config.ConfigHandler;
import com.robo.minecraftp.items.ItemDoorP;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class DoorsP {
	private static String[] doorNames = {"door_oak", "door_spruce", "door_birch", "door_jungle", "door_acacia", "door_dark_oak" };

	public static Block[] door;
	public static Item[] door_item;
	
	public static void register() {
		if (ConfigHandler.enableWoodSpecificDoors) {
			door = new Block[doorNames.length];
			door_item = new Item[doorNames.length];
			
			if (Loader.isModLoaded("malisisdoors")) {
				MinecraftP.log.info("malisisdoors detected. Creating advanced doors");
				for (int i = 0; i < doorNames.length; ++i ) 
				{
					MinecraftP.log.info("creating door " + i + " : " + doorNames[i]);
					WoodDoor woodDoor = new WoodDoor(doorNames[i], new ItemStack(Blocks.planks, 1, i));
					woodDoor.register();
					door[i] = woodDoor.getBlock();
					door_item[i] = woodDoor.getItem();
					
				}
			} else {
				MinecraftP.log.info("malisisdoors not detected. Creating standrard doors");
				for (int i = 0; i < doorNames.length; i++ )
				{
					door[i] = new BlockDoorP(doorNames[i], Material.wood);
					door_item[i] = new ItemDoorP(doorNames[i], Material.wood, door[i]);
					((BlockDoorP) door[i]).setDoorItem(door_item[i]);
					GameRegistry.registerBlock(door[i], doorNames[i]);
					GameRegistry.registerItem(door_item[i], doorNames[i]);
					
					// GameRegistry.addRecipe(new ItemStack(door_item[i]), new Object[] { "AA", "AA", "AA", 'A', new ItemStack(Blocks.planks, 1, i) });
				}
			}
		}
	}

}
