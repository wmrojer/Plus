package com.robo.plus.plugins;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Loader;

import com.robo.plus.config.ConfigHandler;

public class EtFuturumPlugin {

	public static final String[] stoneTypes = new String[] {"granite", "granite_polished",  "diorite", "diorite_polished", "andesite", "andesite_polished"};	
	
	public static boolean isLoaded() {
		return Loader.isModLoaded("etfuturum");
	}
	public static boolean use() {
		return Loader.isModLoaded("etfuturum") && ConfigHandler.enableEtFuturum;
	}
	
	public static Block getStone() {
		return (Block)Block.blockRegistry.getObject("etfuturum:stone");
	}
	
	public static ItemStack getStone(int i) {
		if (i>2) i = 0;
		i = i * 2 + 1;
		return new ItemStack((Block)Block.blockRegistry.getObject("etfuturum:stone"), 1, i);
	}
}
