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
	public static boolean replaceVanillaFences = true;

	public static boolean enableStoneWall = true;
	public static boolean enableStoneBrickWall = true;
	public static boolean enableSandstoneWall = true;
	public static boolean enableBrickWall = true;
	public static boolean enableNetherBrickWall = true;
	public static boolean enableQuartzWall = true;
	
	public static boolean enableDirtStairs = true;
	public static boolean enableDirtSlab = true;
	public static boolean enableStoneStairs = true;

	public static boolean enableWoodSpecificFences = true;
	public static boolean enableWoodSpecificFenceGates = true;
	
	public static boolean moreMossyCobblestoneBlocks = true;
	public static boolean moreStoneBricksBlocks = true;
	public static boolean moreSandstoneBlocks = true;
	public static boolean moreQuartzBlocks = true;

	public static boolean enableObsidianTools = true;
	
	public static boolean enableMissingRecipes = true;

	public static boolean addMissingVanillaAspects = true;
	public static boolean addMissingThaumcraftAspects = true;
	
	public static boolean addMutton = true;
	
	public static boolean enableWoodSpecificDoors = true;
	
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
		replaceVanillaWalls = config.get(Configuration.CATEGORY_GENERAL, "ReplaceVanillaWalls", true, "Replace Vanilla Walls with versions that connect to Minecraft+ walls").getBoolean();
		enableStoneWall = config.get(Configuration.CATEGORY_GENERAL, "EnableStoneWall", true, "Enable Stone Wall (not cobblestone)").getBoolean();
		enableStoneBrickWall = config.get(Configuration.CATEGORY_GENERAL, "EnableStoneBrickWall", true, "Enable StoneBrick Wall").getBoolean();
		enableSandstoneWall = config.get(Configuration.CATEGORY_GENERAL, "EnableSandstoneWall", true, "Enable Sandstone Wall").getBoolean();
		enableBrickWall = config.get(Configuration.CATEGORY_GENERAL, "EnableBrickWall", true, "Enable Brick Wall").getBoolean();
		enableNetherBrickWall = config.get(Configuration.CATEGORY_GENERAL, "EnableNetherBrickWall", true, "Enable NetherBrick Wall").getBoolean();
		enableQuartzWall = config.get(Configuration.CATEGORY_GENERAL, "EnableQuartzWall", true, "Enable Quartz Wall").getBoolean();

		enableDirtStairs = config.get(Configuration.CATEGORY_GENERAL, "EnableDirtStairs", true, "Enable Dirt Stairs").getBoolean();
		enableDirtSlab = config.get(Configuration.CATEGORY_GENERAL, "EnableDirtSlab", true, "Enable Dirt Slab").getBoolean();
		enableStoneStairs = config.get(Configuration.CATEGORY_GENERAL, "EnableStoneStairs", true, "Enable Stone Stairs (not cobblestone)").getBoolean();

		moreMossyCobblestoneBlocks = config.get(Configuration.CATEGORY_GENERAL, "MoreMossyCobblestoneBlocks", true, "Slabs and Stairs from Mossy Cobblestone").getBoolean();
		moreStoneBricksBlocks = config.get(Configuration.CATEGORY_GENERAL, "MoreStoneBricksBlocks", true, "Slabs and Stairs from Mossy, Carved & Cracked Stonebricks").getBoolean();
		moreSandstoneBlocks = config.get(Configuration.CATEGORY_GENERAL, "MoreSandstoneBlocks", true, "Slabs and Stairs from Carved & Smooth Sandstone").getBoolean();
		moreQuartzBlocks = config.get(Configuration.CATEGORY_GENERAL, "MoreQuartzBlocks", true, "Slabs and Stairs from Chiseled & Pillar Quartz").getBoolean();

		replaceVanillaFences = config.get(Configuration.CATEGORY_GENERAL, "ReplaceVanillaFences", true, "Replace vanilla fences with versions that connect to Minecraft+ fences and gates").getBoolean();
		enableWoodSpecificFences = config.get(Configuration.CATEGORY_GENERAL, "EnableWoodSpecificFences", true, "Enable wood specific fences").getBoolean();
		enableWoodSpecificFenceGates = config.get(Configuration.CATEGORY_GENERAL, "EnableWoodSpecificFenceGates", true, "Enable wood specific fence gates").getBoolean();
		enableWoodSpecificDoors = config.get(Configuration.CATEGORY_GENERAL, "EnableWoodSpecificDoors", true, "Enabled wood specific doors").getBoolean();
		
		enableObsidianTools = config.get(Configuration.CATEGORY_GENERAL, "EnableObsidianTools", true, "Enable Obsidian tools").getBoolean();

		enableMissingRecipes = config.get(Configuration.CATEGORY_GENERAL, "EnableMissingRecipes", true, "Enable missing recipes for vanilla blocks").getBoolean();

		addMutton = config.get(Configuration.CATEGORY_GENERAL, "AddMutton", true, "Add Mutton as drop from Sheeps").getBoolean();
		
		
		if (Loader.isModLoaded("Thaumcraft")) {
			addMissingVanillaAspects = config.get(Configuration.CATEGORY_GENERAL, "AddMissingVanillaAspects", true, "Add Thaumcraft aspects to vanilla blocks that are missing them").getBoolean();
			addMissingThaumcraftAspects = config.get(Configuration.CATEGORY_GENERAL, "AddMissingThaumcraftAspects", true, "Add Thaumcraft aspects to Thaumcraft blocks that are missing them").getBoolean();
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
