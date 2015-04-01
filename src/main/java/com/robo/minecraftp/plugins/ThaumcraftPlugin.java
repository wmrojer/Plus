package com.robo.minecraftp.plugins;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Loader;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.config.ConfigBlocks;

import com.robo.minecraftp.MinecraftP;
import com.robo.minecraftp.blocks.BlocksP;
import com.robo.minecraftp.config.ConfigHandler;
import com.robo.minecraftp.doors.DoorsP;
import com.robo.minecraftp.items.ItemsP;


public class ThaumcraftPlugin {

	public ThaumcraftPlugin() {
		// TODO Auto-generated constructor stub
	}

	public static void register()
	{
		if (Loader.isModLoaded("Thaumcraft")) {
			MinecraftP.log.info("Thaumcraft detected. Registering aspects on blocks");
			try {
				if (ConfigHandler.replaceVanillaWalls) {
					safeAdd(BlocksP.cobblestone_wall, (new AspectList()).add(Aspect.EARTH, 1).add(Aspect.ENTROPY, 1));
					if (!Loader.isModLoaded("malisiscore")) {
						safeAdd(BlocksP.cobblestone_mossy_wall, (new AspectList()).add(Aspect.EARTH, 1).add(Aspect.MAGIC, 1).add(Aspect.PLANT, 1));
					}
				}

				if (ConfigHandler.enableStoneWall) {
					safeAdd(BlocksP.stone_wall, (new AspectList()).add(Aspect.EARTH, 2));
				}

				if (ConfigHandler.enableStoneBrickWall) {
					safeAdd(BlocksP.stonebrick_wall, (new AspectList()).add(Aspect.EARTH, 2));
					safeAdd(BlocksP.stonebrick_mossy_wall, (new AspectList()).add(Aspect.EARTH, 1).add(Aspect.PLANT, 1));
					safeAdd(BlocksP.stonebrick_cracked_wall, (new AspectList()).add(Aspect.EARTH, 1).add(Aspect.ENTROPY, 1));
					safeAdd(BlocksP.stonebrick_chiseled_wall, (new AspectList()).add(Aspect.EARTH, 1).add(Aspect.ORDER, 1));
				}
				
				if (ConfigHandler.enableSandstoneWall) {
					safeAdd(BlocksP.sandstone_wall, (new AspectList()).add(Aspect.EARTH, 3).add(Aspect.ENTROPY, 3));
					safeAdd(BlocksP.sandstone_chiseled_wall, (new AspectList()).add(Aspect.EARTH, 2).add(Aspect.ENTROPY, 3).add(Aspect.MAGIC, 1));
					safeAdd(BlocksP.sandstone_smooth_wall, (new AspectList()).add(Aspect.EARTH, 2).add(Aspect.ENTROPY, 3).add(Aspect.ORDER, 1));
				}
				
				if (ConfigHandler.enableBrickWall) {
					safeAdd(BlocksP.brick_wall, (new AspectList()).add(Aspect.EARTH, 3).add(Aspect.FIRE, 3));
				}
				if (ConfigHandler.enableNetherBrickWall) {
					safeAdd(BlocksP.nether_brick_wall, (new AspectList()).add(Aspect.EARTH, 2).add(Aspect.FIRE, 1));
				}
				if (ConfigHandler.enableNetherrackWall) {
					safeAdd(BlocksP.netherrack_wall, (new AspectList()).add(Aspect.EARTH, 2).add(Aspect.FIRE, 1));
				}
				if (ConfigHandler.enableQuartzWall) {
					safeAdd(BlocksP.quartz_wall, (new AspectList()).add(Aspect.ENERGY, 3).add(Aspect.CRYSTAL, 3));
					safeAdd(BlocksP.quartz_chiseled_wall, (new AspectList()).add(Aspect.ENERGY, 3).add(Aspect.CRYSTAL, 3));
					safeAdd(BlocksP.quartz_pillar_wall, (new AspectList()).add(Aspect.ENERGY, 3).add(Aspect.CRYSTAL, 3));
				}

				if (ConfigHandler.enableThaumcraftWalls) {
					safeAdd(BlocksP.arcane_stone_wall, (new AspectList()).add(Aspect.EARTH, 1).add(Aspect.MAGIC, 1));
					safeAdd(BlocksP.arcane_brick_wall, (new AspectList()).add(Aspect.EARTH, 1).add(Aspect.MAGIC, 1));
					safeAdd(BlocksP.ancient_stone_wall, (new AspectList()).add(Aspect.EARTH, 1).add(Aspect.ELDRITCH, 1));
				}

				
				if (ConfigHandler.enableDirtStairs) {
					safeAdd(BlocksP.dirt_stairs, (new AspectList()).add(Aspect.EARTH, 2));
				}
				if (ConfigHandler.enableDirtSlab) {
					safeAdd(BlocksP.dirt_slab, (new AspectList()).add(Aspect.EARTH, 1));
				}
				if (ConfigHandler.enableStoneStairs) {
					safeAdd(BlocksP.stone_stairs, (new AspectList()).add(Aspect.EARTH, 2));
				}
				if (ConfigHandler.enableNetherrackStairs) {
					safeAdd(BlocksP.netherrack_stairs, (new AspectList()).add(Aspect.EARTH, 2).add(Aspect.FIRE, 1));
				}
				if (ConfigHandler.enableNetherrackSlab) {
					safeAdd(BlocksP.netherrack_slab, (new AspectList()).add(Aspect.EARTH, 1));
				}

				if (ConfigHandler.moreMossyCobblestoneBlocks ) {
					safeAdd(BlocksP.cobblestone_mossy_stairs, (new AspectList()).add(Aspect.EARTH, 1).add(Aspect.PLANT, 1).add(Aspect.MAGIC, 1));
					safeAdd(BlocksP.cobblestone_mossy_slab, (new AspectList()).add(Aspect.EARTH, 1));
				}

				if (ConfigHandler.moreStoneBricksBlocks) {
					safeAdd(BlocksP.stonebrick_mossy_stairs, (new AspectList()).add(Aspect.EARTH, 1).add(Aspect.PLANT, 1));
					safeAdd(BlocksP.stonebrick_cracked_stairs, (new AspectList()).add(Aspect.EARTH, 1).add(Aspect.ENTROPY, 1));
					safeAdd(BlocksP.stonebrick_chiseled_stairs, (new AspectList()).add(Aspect.EARTH, 1).add(Aspect.ORDER, 1));
					safeAdd(BlocksP.stonebrick_mossy_slab, (new AspectList()).add(Aspect.EARTH, 1));
					safeAdd(BlocksP.stonebrick_cracked_slab, (new AspectList()).add(Aspect.EARTH, 1));
					safeAdd(BlocksP.stonebrick_chiseled_slab, (new AspectList()).add(Aspect.EARTH, 1));
				}

				if (ConfigHandler.moreSandstoneBlocks) {
					safeAdd(BlocksP.sandstone_chiseled_stairs, (new AspectList()).add(Aspect.EARTH, 2).add(Aspect.ENTROPY, 3).add(Aspect.MAGIC, 1));
					safeAdd(BlocksP.sandstone_smooth_stairs, (new AspectList()).add(Aspect.EARTH, 2).add(Aspect.ENTROPY, 3).add(Aspect.ORDER, 1));
					safeAdd(BlocksP.sandstone_chiseled_slab, (new AspectList()).add(Aspect.EARTH, 1).add(Aspect.ENTROPY, 1));
					safeAdd(BlocksP.sandstone_smooth_slab, (new AspectList()).add(Aspect.EARTH, 1).add(Aspect.ENTROPY, 1));
				}

				if (ConfigHandler.moreQuartzBlocks) {
					safeAdd(BlocksP.quartz_chiseled_stairs, (new AspectList()).add(Aspect.ENERGY, 3).add(Aspect.CRYSTAL, 3));
					safeAdd(BlocksP.quartz_pillar_stairs, (new AspectList()).add(Aspect.ENERGY, 3).add(Aspect.CRYSTAL, 3));
					safeAdd(BlocksP.quartz_chiseled_slab, (new AspectList()).add(Aspect.ENERGY, 1).add(Aspect.CRYSTAL, 1));
					safeAdd(BlocksP.quartz_pillar_slab, (new AspectList()).add(Aspect.ENERGY, 1).add(Aspect.CRYSTAL, 1));
				}

				if (ConfigHandler.enableWoodSpecificFences) {
					safeAdd(BlocksP.oak_fence, (new AspectList()).add(Aspect.TREE, 1));
					safeAdd(BlocksP.spruce_fence, (new AspectList()).add(Aspect.TREE, 1));
					safeAdd(BlocksP.birch_fence, (new AspectList()).add(Aspect.TREE, 1));
					safeAdd(BlocksP.jungle_fence, (new AspectList()).add(Aspect.TREE, 1));
					safeAdd(BlocksP.acacia_fence, (new AspectList()).add(Aspect.TREE, 1));
					safeAdd(BlocksP.big_oak_fence, (new AspectList()).add(Aspect.TREE, 1));
				}
				if (ConfigHandler.enableThaumcraftFences) {
					safeAdd(BlocksP.greatwood_fence, (new AspectList()).add(Aspect.TREE, 1));
					safeAdd(BlocksP.silverwood_fence, (new AspectList()).add(Aspect.TREE, 1));
					safeAdd(BlocksP.greatwood_fence_gate, (new AspectList()).add(Aspect.TREE, 4).add(Aspect.TRAVEL, 1).add(Aspect.MECHANISM, 1));
					safeAdd(BlocksP.silverwood_fence_gate, (new AspectList()).add(Aspect.TREE, 4).add(Aspect.TRAVEL, 1).add(Aspect.MECHANISM, 1));
				}
				
				if (ConfigHandler.enableWoodSpecificFenceGates) {
					//safeAdd(BlocksP.oak_fence_gate, (new AspectList()).add(Aspect.TRAVEL, 1).add(Aspect.MECHANISM, 1));
					safeAdd(BlocksP.spruce_fence_gate, (new AspectList()).add(Aspect.TREE, 4).add(Aspect.TRAVEL, 1).add(Aspect.MECHANISM, 1));
					safeAdd(BlocksP.birch_fence_gate, (new AspectList()).add(Aspect.TREE, 4).add(Aspect.TRAVEL, 1).add(Aspect.MECHANISM, 1));
					safeAdd(BlocksP.jungle_fence_gate, (new AspectList()).add(Aspect.TREE, 4).add(Aspect.TRAVEL, 1).add(Aspect.MECHANISM, 1));
					safeAdd(BlocksP.acacia_fence_gate, (new AspectList()).add(Aspect.TREE, 4).add(Aspect.TRAVEL, 1).add(Aspect.MECHANISM, 1));
					safeAdd(BlocksP.big_oak_fence_gate, (new AspectList()).add(Aspect.TREE, 4).add(Aspect.TRAVEL, 1).add(Aspect.MECHANISM, 1));
					safeAdd(BlocksP.nether_brick_fence_gate, (new AspectList()).add(Aspect.EARTH, 2).add(Aspect.FIRE, 1).add(Aspect.TRAVEL, 1).add(Aspect.MECHANISM, 1));
				}
				
				if (ConfigHandler.enableWoodSpecificDoors) {
					int numTree = 4;
					if (ConfigHandler.replaceVanillaDoors) {
						numTree = 1;
						safeAdd(DoorsP.door_item[0], (new AspectList()).add(Aspect.TREE, numTree).add(Aspect.MOTION, 1).add(Aspect.MECHANISM, 1));
					}
					safeAdd(DoorsP.door_item[1], (new AspectList()).add(Aspect.TREE, numTree).add(Aspect.MOTION, 1).add(Aspect.MECHANISM, 1));
					safeAdd(DoorsP.door_item[2], (new AspectList()).add(Aspect.TREE, numTree).add(Aspect.MOTION, 1).add(Aspect.MECHANISM, 1));
					safeAdd(DoorsP.door_item[3], (new AspectList()).add(Aspect.TREE, numTree).add(Aspect.MOTION, 1).add(Aspect.MECHANISM, 1));
					safeAdd(DoorsP.door_item[4], (new AspectList()).add(Aspect.TREE, numTree).add(Aspect.MOTION, 1).add(Aspect.MECHANISM, 1));
					safeAdd(DoorsP.door_item[5], (new AspectList()).add(Aspect.TREE, numTree).add(Aspect.MOTION, 1).add(Aspect.MECHANISM, 1));
				}
				
				if (ConfigHandler.enableObsidianTools) {
					safeAdd(ItemsP.obsidian_sword, (new AspectList()).add(Aspect.METAL, 3).add(Aspect.EARTH, 3).add(Aspect.FIRE, 3).add(Aspect.DARKNESS, 1).add(Aspect.WEAPON, 2));
					safeAdd(ItemsP.obsidian_axe, (new AspectList()).add(Aspect.METAL, 6).add(Aspect.EARTH, 4).add(Aspect.FIRE, 4).add(Aspect.DARKNESS, 2).add(Aspect.TOOL, 2));
					safeAdd(ItemsP.obsidian_hoe, (new AspectList()).add(Aspect.METAL, 6).add(Aspect.EARTH, 3).add(Aspect.FIRE, 3).add(Aspect.DARKNESS, 1).add(Aspect.HARVEST, 1));
					safeAdd(ItemsP.obsidian_pickaxe, (new AspectList()).add(Aspect.METAL, 6).add(Aspect.EARTH, 4).add(Aspect.FIRE, 4).add(Aspect.DARKNESS, 2).add(Aspect.MINE, 2));
					safeAdd(ItemsP.obsidian_shovel, (new AspectList()).add(Aspect.METAL, 6).add(Aspect.EARTH, 2).add(Aspect.FIRE, 2).add(Aspect.TOOL, 2));
				}

				if (ConfigHandler.addMutton) {
					safeAdd(ItemsP.mutton_raw, (new AspectList()).add(Aspect.FLESH, 2).add(Aspect.LIFE, 1).add(Aspect.BEAST, 1));
					safeAdd(ItemsP.mutton_cooked, (new AspectList()).add(Aspect.FLESH, 2).add(Aspect.HUNGER, 2).add(Aspect.CRAFT, 1));
				}
				
				// Add aspects to some vanilla objects that are missing aspects
				if (ConfigHandler.addMissingVanillaAspects) {
					safeAdd(Blocks.stone_slab, 1, 0, (new AspectList()).add(Aspect.EARTH, 1)); // Stone
					safeAdd(Blocks.stone_slab, 1, 3, (new AspectList()).add(Aspect.EARTH, 1)); // Cobblestone
					safeAdd(Blocks.stone_slab, 1, 5, (new AspectList()).add(Aspect.EARTH, 1)); // Stone Brick
					safeAdd(Blocks.stone_slab, 1, 6, (new AspectList()).add(Aspect.EARTH, 1)); // Nether Brick
				
					safeAdd(Blocks.fence, 1, 6, (new AspectList()).add(Aspect.TREE, 1));
				}

				// Add aspects to some Thaumcraft objects that are missing aspects
				if (ConfigHandler.addMissingThaumcraftAspects) {
					safeAdd(ConfigBlocks.blockSlabStone, 1, 0, (new AspectList()).add(Aspect.EARTH, 1));
					safeAdd(ConfigBlocks.blockSlabStone, 1, 1, (new AspectList()).add(Aspect.EARTH, 1));
					safeAdd(ConfigBlocks.blockSlabWood, 1, 0, (new AspectList()).add(Aspect.TREE, 1));
					safeAdd(ConfigBlocks.blockSlabWood, 1, 1, (new AspectList()).add(Aspect.TREE, 1));
					safeAdd(ConfigBlocks.blockStairsEldritch, 1, 0, (new AspectList()).add(Aspect.EARTH, 1).add(Aspect.ELDRITCH, 1));
				}
/*
				ThaumcraftApi.registerObjectTag(new ItemStack(BlocksP.), (new AspectList()).add(Aspect.EARTH, 1).add(Aspect.ORDER, 1));
*/				
			} catch (Exception e) {
				MinecraftP.log.error("Error registring Thaumcraft Aspects on Minecraft+ blocks", e);
			}
		} else {
			MinecraftP.log.info("Thaumcraft not detected.");
		}
	}
	
	private static void safeAdd(Block block, AspectList aspects) {
		safeAdd(block, 1, aspects);
	}
	
	private static void safeAdd(Block block, int num, AspectList aspects) {
		safeAdd(block, num, 0, aspects);
	}
	
	private static void safeAdd(Block block, int num, int meta, AspectList aspects)
	{
		if (block != null) {
			try
			{
				ThaumcraftApi.registerObjectTag(new ItemStack(block, num, meta), aspects);
			}
			catch(Exception e)
			{
				MinecraftP.log.error("Error registring Thaumcraft Aspects on Minecraft+ block " + block.getUnlocalizedName(), e);
			}
		}
		
	}

	private static void safeAdd(Item item, AspectList aspects)
	{
		if (item != null) {
			try
			{
				ThaumcraftApi.registerObjectTag(new ItemStack(item), aspects);
			}
			catch(Exception e)
			{
				MinecraftP.log.error("Error registring Thaumcraft Aspects on Minecraft+ item " + item.getUnlocalizedName(), e);
			}
		}
	}
}
