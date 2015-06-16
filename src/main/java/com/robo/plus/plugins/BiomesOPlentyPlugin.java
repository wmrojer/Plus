package com.robo.plus.plugins;

import net.minecraft.block.Block;

import com.robo.plus.config.ConfigHandler;

import cpw.mods.fml.common.Loader;
import biomesoplenty.api.content.BOPCBlocks;

public class BiomesOPlentyPlugin {

	public static final String[] woodTypes = new String[] {"sacredoak", "cherry", "dark", "fir", "ethereal", "magic", "mangrove", "palm", "redwood", "willow", "bambooThatching", "pine", "hellBark", "jacaranda", "mahogany"};	
	
	public static Block getWoodPlanks() {
		return BOPCBlocks.planks;
	}
	
	public static boolean isLoaded() {
		return Loader.isModLoaded("BiomesOPlenty");
	}
	public static boolean use() {
		return Loader.isModLoaded("BiomesOPlenty") && ConfigHandler.enableBiomesOPlenty;
	}
	
}
