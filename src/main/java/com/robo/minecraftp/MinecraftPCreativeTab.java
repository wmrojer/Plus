package com.robo.minecraftp;

import java.util.List;

import com.robo.minecraftp.blocks.BlocksP;
import com.robo.minecraftp.info.ModInfo;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MinecraftPCreativeTab extends CreativeTabs {

	@SuppressWarnings("rawtypes")
	List list;
	public static MinecraftPCreativeTab INSTANCE = new MinecraftPCreativeTab();

	public MinecraftPCreativeTab() {
		super(ModInfo.MODID);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void displayAllReleventItems(List list) {
		this.list = list;
		
		addBlock(BlocksP.cobblestone_wall);
		addBlock(BlocksP.cobblestone_mossy_wall);
		addBlock(BlocksP.stonebrick_wall);
		
		addBlock(BlocksP.oak_fence_gate);
		addBlock(BlocksP.spruce_fence_gate);
		
	}

	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(BlocksP.cobblestone_mossy_wall);
	}

	@Override
	public Item getTabIconItem() {
		return getIconItemStack().getItem();
	}

	private void addBlock(Block block) {
		ItemStack stack = new ItemStack(block);
		block.getSubBlocks(stack.getItem(), this, list);
	}
	
}
