package com.robo.plus.config;

import java.io.File;

import com.robo.plus.Plus;
import com.robo.plus.info.ModInfo;
import com.robo.plus.plugins.BiomesOPlentyPlugin;
import com.robo.plus.plugins.EtFuturumPlugin;
import com.robo.plus.plugins.ThaumcraftPlugin;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {

	public static Configuration config;

	public static boolean replaceVanillaWalls = true;

	public static boolean enableStoneWall = true;
	public static boolean enableStoneBrickWall = true;
	public static boolean enableSandstoneWall = true;
	public static boolean enableBrickWall = true;
	public static boolean enableNetherBrickWall = true;
	public static boolean enableQuartzWall = true;
	public static boolean enableNetherrackWall = true;
	public static boolean interconnectWalls = true;
	public static boolean connectWallsFences;
	
	public static boolean enableDirtStairs = true;
	public static boolean enableDirtSlab = true;
	public static boolean enableStoneStairs = true;
	public static boolean enableNetherrackStairs = true;
	public static boolean enableNetherrackSlab = true;
	
	public static boolean moreMossyCobblestoneBlocks = true;
	public static boolean moreStoneBricksBlocks = true;
	public static boolean moreSandstoneBlocks = true;
	public static boolean moreQuartzBlocks = true;

	public static boolean enableWoodSpecificFences = true;
	public static boolean replaceVanillaFences = true;
	public static boolean interconnectFences = true;
	
	public static boolean enableWoodSpecificFenceGates = true;
	public static boolean enableWoodSpecificDoors = true;
	public static boolean replaceVanillaDoors = true;
	
	public static boolean enableObsidianTools = true;
	public static boolean enableIronBow = true;
	
	public static boolean enableMissingRecipes = true;

	public static boolean addMissingVanillaAspects = true;
	public static boolean addMissingThaumcraftAspects = true;
	public static boolean enableThaumcraftFences = true;
	public static boolean enableThaumcraftWalls = true;

	public static boolean addMuttonToSheep = true;
	public static boolean addLeatherToSheep = true;
	public static boolean addLeatherToPig = true;
	public static boolean addMoreLeatherToCow = true;
	
	public static boolean enableThaumcraft = true;
	public static boolean enableMalisisDoors = true;
	public static boolean enableBiomesOPlenty = true;
	public static boolean enableEtFuturum = true;
	
	public static boolean useOreDict = false;
	public static boolean dumpRecipes = false;
	public static boolean recipesFirst = true;

	
	public static class Category { 
		public static String WALLSFENCES = "wallsfences";
		public static String STAIRSSLABS = "stairsslabs";
		public static String THAUMCRAFT = "thaumcraft";
		public static String MODCOMP = "modcompatibility";
	}
	
	public static void init(File file) {
		if (config == null)
		{
			config = new Configuration(file);
			try 
			{
				config.load();
			}
			catch (Exception e)
			{
				Plus.log.error("Error loading config! " + e.getMessage());
			}
			updateConfig();
		}
	}

	private static void updateConfig()
	{
		replaceVanillaWalls = config.get(Category.WALLSFENCES, "ReplaceVanillaWalls", true, "Replace Vanilla Walls with versions that connect to Plus walls").setRequiresMcRestart(true).getBoolean();
		enableStoneWall = config.get(Category.WALLSFENCES, "EnableStoneWall", true, "Enable Stone Wall (not cobblestone)").setRequiresMcRestart(true).getBoolean();
		enableStoneBrickWall = config.get(Category.WALLSFENCES, "EnableStoneBrickWall", true, "Enable StoneBrick Wall").setRequiresMcRestart(true).getBoolean();
		enableSandstoneWall = config.get(Category.WALLSFENCES, "EnableSandstoneWall", true, "Enable Sandstone Wall").setRequiresMcRestart(true).getBoolean();
		enableBrickWall = config.get(Category.WALLSFENCES, "EnableBrickWall", true, "Enable Brick Wall").setRequiresMcRestart(true).getBoolean();
		enableNetherBrickWall = config.get(Category.WALLSFENCES, "EnableNetherBrickWall", true, "Enable NetherBrick Wall").setRequiresMcRestart(true).getBoolean();
		enableQuartzWall = config.get(Category.WALLSFENCES, "EnableQuartzWall", true, "Enable Quartz Wall").setRequiresMcRestart(true).getBoolean();
		enableNetherrackWall = config.get(Category.WALLSFENCES, "EnableNetherrackWall", true, "Enable Netherrack Wall").setRequiresMcRestart(true).getBoolean();
		interconnectWalls = config.get(Category.WALLSFENCES, "InterconnectWalls", true, "Should different type of walls connect").getBoolean();

		enableWoodSpecificFences = config.get(Category.WALLSFENCES, "EnableWoodSpecificFences", true, "Enable wood specific fences").setRequiresMcRestart(true).getBoolean();
		replaceVanillaFences = config.get(Category.WALLSFENCES, "ReplaceVanillaFences", true, "Replace vanilla fences with versions that connect to Plus fences and gates").setRequiresMcRestart(true).getBoolean();
		enableWoodSpecificFenceGates = config.get(Category.WALLSFENCES, "EnableWoodSpecificFenceGates", true, "Enable wood specific fence gates").setRequiresMcRestart(true).getBoolean();
		interconnectFences = config.get(Category.WALLSFENCES, "InterconnectFences", true, "Should different type of fences connect").getBoolean();
		
		connectWallsFences = config.get(Category.WALLSFENCES, "Connect Walls and Fences", false, "Should walls and fences connect").getBoolean();
		
		enableDirtStairs = config.get(Category.STAIRSSLABS, "EnableDirtStairs", true, "Enable Dirt Stairs").setRequiresMcRestart(true).getBoolean();
		enableDirtSlab = config.get(Category.STAIRSSLABS, "EnableDirtSlab", true, "Enable Dirt Slab").setRequiresMcRestart(true).getBoolean();
		enableStoneStairs = config.get(Category.STAIRSSLABS, "EnableStoneStairs", true, "Enable Stone Stairs (not cobblestone)").setRequiresMcRestart(true).getBoolean();
		enableNetherrackStairs = config.get(Category.STAIRSSLABS, "EnableNetherrackStairs", true, "Enable Netherrack Stairs").setRequiresMcRestart(true).getBoolean();
		enableNetherrackSlab = config.get(Category.STAIRSSLABS, "EnableNetherrackSlab", true, "Enable Netherrack Slab").setRequiresMcRestart(true).getBoolean();

		moreMossyCobblestoneBlocks = config.get(Category.STAIRSSLABS, "MoreMossyCobblestoneBlocks", true, "Slabs and Stairs from Mossy Cobblestone").setRequiresMcRestart(true).getBoolean();
		moreStoneBricksBlocks = config.get(Category.STAIRSSLABS, "MoreStoneBricksBlocks", true, "Slabs and Stairs from Mossy, Carved & Cracked Stonebricks").setRequiresMcRestart(true).getBoolean();
		moreSandstoneBlocks = config.get(Category.STAIRSSLABS, "MoreSandstoneBlocks", true, "Slabs and Stairs from Carved & Smooth Sandstone").setRequiresMcRestart(true).getBoolean();
		moreQuartzBlocks = config.get(Category.STAIRSSLABS, "MoreQuartzBlocks", true, "Slabs and Stairs from Chiseled & Pillar Quartz").setRequiresMcRestart(true).getBoolean();

		replaceVanillaDoors = config.get(Configuration.CATEGORY_GENERAL, "ReplaceVanillaDoors", true, "Replace vanilla doors with versions that stack").setRequiresMcRestart(true).getBoolean();
		enableWoodSpecificDoors = config.get(Configuration.CATEGORY_GENERAL, "EnableWoodSpecificDoors", true, "Enabled wood specific doors").setRequiresMcRestart(true).getBoolean();
		
		enableObsidianTools = config.get(Configuration.CATEGORY_GENERAL, "EnableObsidianTools", true, "Enable Obsidian tools").setRequiresMcRestart(true).getBoolean();
		enableIronBow = config.get(Configuration.CATEGORY_GENERAL, "EnableIronBow", true, "Enable Iron Bow").setRequiresMcRestart(true).getBoolean();

		enableMissingRecipes = config.get(Configuration.CATEGORY_GENERAL, "EnableMissingRecipes", true, "Enable missing recipes for vanilla blocks").setRequiresMcRestart(true).getBoolean();

		addMuttonToSheep = config.get(Configuration.CATEGORY_GENERAL, "AddMuttonToSheep", true, "Add Mutton as drop from Sheeps").setRequiresMcRestart(true).getBoolean();
		addLeatherToSheep = config.get(Configuration.CATEGORY_GENERAL, "AddLeatherToSheep", true, "Add Leather as drop from Sheeps").setRequiresMcRestart(true).getBoolean();
		addLeatherToPig = config.get(Configuration.CATEGORY_GENERAL, "AddLeatherToPig", true, "Add Leather as drop from Pigs").setRequiresMcRestart(true).getBoolean();
		addMoreLeatherToCow = config.get(Configuration.CATEGORY_GENERAL, "AddMoreLeatherToCow", true, "Add more Leather as drop from cows (They always drop at least 1)").setRequiresMcRestart(true).getBoolean();
		
		enableThaumcraft = config.get(Category.MODCOMP, "EnableThumcraft", true, "Thaumcraft mod support").setRequiresMcRestart(true).getBoolean();
		enableMalisisDoors = config.get(Category.MODCOMP, "EnableMalisisDoors", true, "MalisisDoors mod support").setRequiresMcRestart(true).getBoolean();

		if (ThaumcraftPlugin.isLoaded()) {
			enableThaumcraftFences = config.get(Category.THAUMCRAFT, "EnableThaumcraftFences", true, "Add Fences for Thaumcraft wood").setRequiresMcRestart(true).getBoolean();
			enableThaumcraftWalls = config.get(Category.THAUMCRAFT, "EnableThaumcraftWalls", true, "Add Walls for Thaumcraft stone").setRequiresMcRestart(true).getBoolean();
			addMissingVanillaAspects = config.get(Category.THAUMCRAFT, "AddMissingVanillaAspects", true, "Add Thaumcraft aspects to vanilla blocks that are missing them").setRequiresMcRestart(true).getBoolean();
			addMissingThaumcraftAspects = config.get(Category.THAUMCRAFT, "AddMissingThaumcraftAspects", true, "Add Thaumcraft aspects to Thaumcraft blocks that are missing them").setRequiresMcRestart(true).getBoolean();
		} else {
			enableThaumcraftFences = false;
			enableThaumcraftWalls = false;
			addMissingVanillaAspects = false;
			addMissingThaumcraftAspects = false;
		}
		
		if (BiomesOPlentyPlugin.isLoaded()) {
			enableBiomesOPlenty = config.get(Category.MODCOMP, "EnableBiomesOPlenty", true, "BiomesO'Plenty mod support").setRequiresMcRestart(true).getBoolean();
		} else {
			enableBiomesOPlenty = false;
		}

		if (EtFuturumPlugin.isLoaded()) {
			enableEtFuturum = config.get(Category.MODCOMP, "EnableEtFuturum", true, "Et Futurum mod support").setRequiresMcRestart(true).getBoolean();
		} else {
			enableEtFuturum = false;
		}

		useOreDict = config.get(Configuration.CATEGORY_GENERAL, "UseOreDict", false, "Use Ore Dictionary for recipes").setRequiresMcRestart(true).getBoolean();
		dumpRecipes = config.get(Configuration.CATEGORY_GENERAL, "DumpRecipes", false, "List recipe order in log on player entering world").setRequiresMcRestart(false).getBoolean();
		recipesFirst = config.get(Configuration.CATEGORY_GENERAL, "RecipesFirst", true, "Recipes are sorted first in the crafting list").setRequiresMcRestart(true).getBoolean();
		
		if (config.hasChanged()) {
			config.save();
		}
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if(event.modID.equalsIgnoreCase(ModInfo.MODID))
		{
			updateConfig();
		}
	}
}
