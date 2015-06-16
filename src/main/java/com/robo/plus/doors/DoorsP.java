package com.robo.plus.doors;

//MalisisCore 1.7.10-0.11.4
import net.malisis.core.util.replacement.ReplacementTool;
//MalisisCore 1.7.10-0.10.6
//import net.malisis.core.ReplacementTool;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.robo.plus.Plus;
import com.robo.plus.blocks.BlockDoorP;
import com.robo.plus.config.ConfigHandler;
import com.robo.plus.items.ItemDoorP;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class DoorsP {
	private static String[] doorNames = {"door_wood", "door_spruce", "door_birch", "door_jungle", "door_acacia", "door_dark_oak" };

	public static Block[] door;
	public static Item[] door_item;
	public static Block door_iron;
	public static Item door_iron_item;
	
	public static void registerDoors() {
		if (ConfigHandler.enableWoodSpecificDoors) {
			door = new Block[doorNames.length];
			door_item = new Item[doorNames.length];
			
			if (Loader.isModLoaded("malisisdoors") && ConfigHandler.enableMalisisDoors) {
				Plus.log.info("malisisdoors detected. Creating advanced doors");
				if (ConfigHandler.replaceVanillaDoors) { 
					// Create a new Oak Door to replace the vanilla Wood Door
					MalisisDoor oakDoor = new MalisisDoor("door_wood", Material.wood, new ItemStack(Blocks.planks, 1, 0));
					oakDoor.create();
					ReplacementTool.replaceVanillaItem(324, "wooden_door", "field_151135_aq", oakDoor.getItem(), Items.wooden_door);
					ReplacementTool.replaceVanillaBlock(64, "wooden_door", "field_150466_ao", oakDoor.getBlock(), Blocks.wooden_door);
					door[0] = oakDoor.getBlock();
					door_item[0] = oakDoor.getItem();
					// Create a new Iron Door to replace the vanilla Iron Door
					MalisisDoor ironDoor = new MalisisDoor("door_iron", Material.iron, new ItemStack(Blocks.planks, 1, 0));
					ironDoor.create();
					ReplacementTool.replaceVanillaItem(330, "iron_door", "field_151139_aw", ironDoor.getItem(), Items.iron_door);
					ReplacementTool.replaceVanillaBlock(71, "iron_door", "field_150454_av", ironDoor.getBlock(), Blocks.iron_door);
					door_iron = ironDoor.getBlock();
					door_iron_item = ironDoor.getItem();
				}
				for (int i = 1; i < doorNames.length; ++i ) 
				{
					MalisisDoor woodDoor = new MalisisDoor(doorNames[i], Material.wood, new ItemStack(Blocks.planks, 1, i) );
					woodDoor.register();
					door[i] = woodDoor.getBlock();
					door_item[i] = woodDoor.getItem();
					
				}
			} else {
				//Plus.log.info("malisisdoors not detected. Creating standard doors");
				int start = 1;
				if (ConfigHandler.replaceVanillaDoors) { 
					start = 0;
					door_iron = new BlockDoorP("door_iron", Material.wood);
					door_iron_item = new ItemDoorP("door_iron", Material.wood, door_iron);
					((BlockDoorP) door_iron).setDoorItem(door_iron_item);
					GameRegistry.registerBlock(door_iron, "door_iron");
					GameRegistry.registerItem(door_iron_item, "item.door_iron");
				}
				for (int i = start; i < doorNames.length; ++i )
				{
					door[i] = new BlockDoorP(doorNames[i], Material.wood);
					door_item[i] = new ItemDoorP(doorNames[i], Material.wood, door[i]);
					((BlockDoorP) door[i]).setDoorItem(door_item[i]);
					GameRegistry.registerBlock(door[i], doorNames[i]);
					GameRegistry.registerItem(door_item[i], "item." + doorNames[i]);
					
					// GameRegistry.addRecipe(new ItemStack(door_item[i]), new Object[] { "AA", "AA", "AA", 'A', new ItemStack(Blocks.planks, 1, i) });
				}
			}
		}
	}

}
