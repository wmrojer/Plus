package com.robo.plus.items;

import com.robo.plus.config.ConfigHandler;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public final class ItemsP {

	public static ToolMaterial OBSIDIAN = EnumHelper.addToolMaterial("OBSIDIAN", 1, 4000, 4.0F, 1.0F, 5);
	
	public static Item obsidian_sword;
	public static Item obsidian_axe;
	public static Item obsidian_hoe;
	public static Item obsidian_pickaxe;
	public static Item obsidian_shovel;
	public static Item obsidian_bow;
	public static Item iron_bow;
	
	public static Item mutton_raw;
	public static Item mutton_cooked;
	
	public static final void registerItems() 
	{

		if (ConfigHandler.enableObsidianTools)
		{
			OBSIDIAN.setRepairItem(new ItemStack(Blocks.obsidian, 1));
			
			GameRegistry.registerItem(obsidian_sword = new ItemObsidianSword("obsidian_sword", OBSIDIAN), "obsidian_sword");
			GameRegistry.registerItem(obsidian_axe = new ItemObsidianAxe("obsidian_axe", OBSIDIAN), "obsidian_axe");
			GameRegistry.registerItem(obsidian_hoe = new ItemObsidianHoe("obsidian_hoe", OBSIDIAN), "obsidian_hoe");
			GameRegistry.registerItem(obsidian_pickaxe = new ItemObsidianPickaxe("obsidian_pickaxe", OBSIDIAN), "obsidian_pickaxe");
			GameRegistry.registerItem(obsidian_shovel = new ItemObsidianShovel("obsidian_shovel", OBSIDIAN), "obsidian_shovel");
			GameRegistry.registerItem(obsidian_bow = new ItemBowP("obsidian_bow", 1536), "obsidian_bow");
		}
		if (ConfigHandler.enableIronBow) {
			GameRegistry.registerItem(iron_bow = new ItemBowP("iron_bow", 768), "iron_bow");
		}
		if (ConfigHandler.addMuttonToSheep) {
			GameRegistry.registerItem(mutton_raw = new ItemFoodP("mutton_raw", 2, 0.3F, true), "mutton_raw");
			GameRegistry.registerItem(mutton_cooked = new ItemFoodP("mutton_cooked", 6, 0.8F, true), "mutton_cooked");
		}

		/*
		GameRegistry.registerItem(chocolate = 
			    new ItemFoodP("chocolate", 2, 0.2f, false, 
			    new PotionEffect(Potion.moveSpeed.id, 1200, 1), 
			    new PotionEffect(Potion.jump.id, 600, 0), 
			    new PotionEffect(Potion.regeneration.id, 200, 1))
			    .setAlwaysEdible(), "chocolate");
		*/
	}
}
