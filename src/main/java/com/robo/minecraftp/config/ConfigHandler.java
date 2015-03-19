package com.robo.minecraftp.config;

import java.io.File;

import com.robo.minecraftp.MinecraftP;
import com.robo.minecraftp.info.ModInfo;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.Loader;
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
	public static boolean interconnectWalls = true;
	public static boolean connectWallsFences;
	
	public static boolean enableDirtStairs = true;
	public static boolean enableDirtSlab = true;
	public static boolean enableStoneStairs = true;

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
	
	public static boolean enableMissingRecipes = true;

	public static boolean addMissingVanillaAspects = true;
	public static boolean addMissingThaumcraftAspects = true;
	public static boolean enableThaumcraftFences = true;
	public static boolean enableThaumcraftWalls = true;

	public static boolean addMutton = true;
	
	
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
				MinecraftP.log.error("Error loading config! " + e.getMessage());
			}
			updateConfig();
			MinecraftP.log.info("Loaded config");
		}
	}

	private static void updateConfig()
	{
		replaceVanillaWalls = config.get(Configuration.CATEGORY_GENERAL, "ReplaceVanillaWalls", true, "Replace Vanilla Walls with versions that connect to Minecraft+ walls").setRequiresMcRestart(true).getBoolean();
		enableStoneWall = config.get(Configuration.CATEGORY_GENERAL, "EnableStoneWall", true, "Enable Stone Wall (not cobblestone)").setRequiresMcRestart(true).getBoolean();
		enableStoneBrickWall = config.get(Configuration.CATEGORY_GENERAL, "EnableStoneBrickWall", true, "Enable StoneBrick Wall").setRequiresMcRestart(true).getBoolean();
		enableSandstoneWall = config.get(Configuration.CATEGORY_GENERAL, "EnableSandstoneWall", true, "Enable Sandstone Wall").setRequiresMcRestart(true).getBoolean();
		enableBrickWall = config.get(Configuration.CATEGORY_GENERAL, "EnableBrickWall", true, "Enable Brick Wall").setRequiresMcRestart(true).getBoolean();
		enableNetherBrickWall = config.get(Configuration.CATEGORY_GENERAL, "EnableNetherBrickWall", true, "Enable NetherBrick Wall").setRequiresMcRestart(true).getBoolean();
		enableQuartzWall = config.get(Configuration.CATEGORY_GENERAL, "EnableQuartzWall", true, "Enable Quartz Wall").setRequiresMcRestart(true).getBoolean();

		interconnectWalls = config.get(Configuration.CATEGORY_GENERAL, "InterconnectWalls", true, "Should different type of walls connect").getBoolean();
		
		enableDirtStairs = config.get(Configuration.CATEGORY_GENERAL, "EnableDirtStairs", true, "Enable Dirt Stairs").setRequiresMcRestart(true).getBoolean();
		enableDirtSlab = config.get(Configuration.CATEGORY_GENERAL, "EnableDirtSlab", true, "Enable Dirt Slab").setRequiresMcRestart(true).getBoolean();
		enableStoneStairs = config.get(Configuration.CATEGORY_GENERAL, "EnableStoneStairs", true, "Enable Stone Stairs (not cobblestone)").setRequiresMcRestart(true).getBoolean();

		moreMossyCobblestoneBlocks = config.get(Configuration.CATEGORY_GENERAL, "MoreMossyCobblestoneBlocks", true, "Slabs and Stairs from Mossy Cobblestone").setRequiresMcRestart(true).getBoolean();
		moreStoneBricksBlocks = config.get(Configuration.CATEGORY_GENERAL, "MoreStoneBricksBlocks", true, "Slabs and Stairs from Mossy, Carved & Cracked Stonebricks").setRequiresMcRestart(true).getBoolean();
		moreSandstoneBlocks = config.get(Configuration.CATEGORY_GENERAL, "MoreSandstoneBlocks", true, "Slabs and Stairs from Carved & Smooth Sandstone").setRequiresMcRestart(true).getBoolean();
		moreQuartzBlocks = config.get(Configuration.CATEGORY_GENERAL, "MoreQuartzBlocks", true, "Slabs and Stairs from Chiseled & Pillar Quartz").setRequiresMcRestart(true).getBoolean();

		enableWoodSpecificFences = config.get(Configuration.CATEGORY_GENERAL, "EnableWoodSpecificFences", true, "Enable wood specific fences").setRequiresMcRestart(true).getBoolean();
		replaceVanillaFences = config.get(Configuration.CATEGORY_GENERAL, "ReplaceVanillaFences", true, "Replace vanilla fences with versions that connect to Minecraft+ fences and gates").setRequiresMcRestart(true).getBoolean();
		interconnectFences = config.get(Configuration.CATEGORY_GENERAL, "InterconnectFences", true, "Should different type of fences connect").getBoolean();
		enableWoodSpecificFenceGates = config.get(Configuration.CATEGORY_GENERAL, "EnableWoodSpecificFenceGates", true, "Enable wood specific fence gates").setRequiresMcRestart(true).getBoolean();
		enableWoodSpecificDoors = config.get(Configuration.CATEGORY_GENERAL, "EnableWoodSpecificDoors", true, "Enabled wood specific doors").setRequiresMcRestart(true).getBoolean();
		replaceVanillaDoors = config.get(Configuration.CATEGORY_GENERAL, "ReplaceVanillaDoors", true, "Replace vanilla doors with versions that stack").setRequiresMcRestart(true).getBoolean();
		
		enableObsidianTools = config.get(Configuration.CATEGORY_GENERAL, "EnableObsidianTools", true, "Enable Obsidian tools").setRequiresMcRestart(true).getBoolean();

		enableMissingRecipes = config.get(Configuration.CATEGORY_GENERAL, "EnableMissingRecipes", true, "Enable missing recipes for vanilla blocks").setRequiresMcRestart(true).getBoolean();

		addMutton = config.get(Configuration.CATEGORY_GENERAL, "AddMutton", true, "Add Mutton as drop from Sheeps").setRequiresMcRestart(true).getBoolean();
		
		connectWallsFences = config.get(Configuration.CATEGORY_GENERAL, "Connect Walls and Fences", false, "Should walls and fences connect").getBoolean();
		
		if (Loader.isModLoaded("Thaumcraft")) {
			enableThaumcraftFences = config.get(Configuration.CATEGORY_GENERAL, "EnableThaumcraftFences", true, "Add Fences for Thaumcraft wood").setRequiresMcRestart(true).getBoolean();
			enableThaumcraftWalls = config.get(Configuration.CATEGORY_GENERAL, "EnableThaumcraftWalls", true, "Add Walls for Thaumcraft stone").setRequiresMcRestart(true).getBoolean();
			addMissingVanillaAspects = config.get(Configuration.CATEGORY_GENERAL, "AddMissingVanillaAspects", true, "Add Thaumcraft aspects to vanilla blocks that are missing them").setRequiresMcRestart(true).getBoolean();
			addMissingThaumcraftAspects = config.get(Configuration.CATEGORY_GENERAL, "AddMissingThaumcraftAspects", true, "Add Thaumcraft aspects to Thaumcraft blocks that are missing them").setRequiresMcRestart(true).getBoolean();
		} else {
			enableThaumcraftFences = false;
			enableThaumcraftWalls = false;
			addMissingVanillaAspects = false;
			addMissingThaumcraftAspects = false;
		}

		if (config.hasChanged()) {
			config.save();
			MinecraftP.log.info("Saved config");
		}
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if(event.modID.equalsIgnoreCase(ModInfo.MODID))
		{
			MinecraftP.log.info("Config changed event");
			updateConfig();
		}
	}
}
