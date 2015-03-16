package com.robo.minecraftp.blocks;

import com.robo.minecraftp.config.ConfigHandler;
import com.robo.minecraftp.items.ItemSlabP;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlocksP {
	
	public static BlockWallP cobblestone_wall;
	public static BlockWallP cobblestone_mossy_wall;
	public static BlockWallP stone_wall;
	public static BlockWallP stonebrick_wall;
	public static BlockWallP stonebrick_mossy_wall;
	public static BlockWallP stonebrick_cracked_wall;
	public static BlockWallP stonebrick_chiseled_wall;
	public static BlockWallP sandstone_wall;
	public static BlockWallP sandstone_chiseled_wall;
	public static BlockWallP sandstone_smooth_wall;
	public static BlockWallP brick_wall;
	public static BlockWallP nether_brick_wall;
	public static BlockWallP quartz_wall;
	public static BlockWallP quartz_chiseled_wall;
	public static BlockWallP quartz_pillar_wall;
	
	public static BlockFenceP oak_fence;
	public static BlockFenceP spruce_fence;
	public static BlockFenceP birch_fence;
	public static BlockFenceP jungle_fence;
	public static BlockFenceP acacia_fence;
	public static BlockFenceP big_oak_fence;
	
	public static BlockFenceGateP oak_fence_gate;
	public static BlockFenceGateP spruce_fence_gate;
	public static BlockFenceGateP birch_fence_gate;
	public static BlockFenceGateP jungle_fence_gate;
	public static BlockFenceGateP acacia_fence_gate;
	public static BlockFenceGateP big_oak_fence_gate;
	
	public static BlockStairsP dirt_stairs;
	public static BlockStairsP stone_stairs;
	public static BlockStairsP cobblestone_mossy_stairs;
	public static BlockStairsP stonebrick_mossy_stairs;
	public static BlockStairsP stonebrick_cracked_stairs;
	public static BlockStairsP stonebrick_chiseled_stairs;
	public static BlockStairsP sandstone_chiseled_stairs;
	public static BlockStairsP sandstone_smooth_stairs;
	public static BlockStairsP quartz_stairs;
	public static BlockStairsP quartz_chiseled_stairs;
	public static BlockStairsP quartz_pillar_stairs;
	
	public static BlockSlabP dirt_slab;
	public static BlockSlabP cobblestone_mossy_slab;
	public static BlockSlabP stonebrick_mossy_slab;
	public static BlockSlabP stonebrick_cracked_slab;
	public static BlockSlabP stonebrick_chiseled_slab; 
	public static BlockSlabP sandstone_chiseled_slab;
	public static BlockSlabP sandstone_smooth_slab;
	public static BlockSlabP quartz_chiseled_slab;
	public static BlockSlabP quartz_pillar_slab;
	
	public static void registerBlocks() 
	{
		
		if (ConfigHandler.replaceVanillaWalls) {
			cobblestone_wall = addWall("cobblestone_wall", Blocks.cobblestone);
			cobblestone_mossy_wall = addWall("cobblestone_mossy_wall", Blocks.mossy_cobblestone);
		}

		if (ConfigHandler.enableStoneWall) {
			stone_wall = addWall("stone_wall", Blocks.stone);
		}

		if (ConfigHandler.enableStoneBrickWall) {
			stonebrick_wall = addWall("stonebrick_wall", Blocks.stonebrick);
			stonebrick_mossy_wall = addWall("stonebrick_mossy_wall", Blocks.stonebrick, 1);
			stonebrick_cracked_wall = addWall("stonebrick_cracked_wall", Blocks.stonebrick, 2);
			stonebrick_chiseled_wall = addWall("stonebrick_chiseled_wall", Blocks.stonebrick, 3);
		}
		if (ConfigHandler.enableSandstoneWall) {
			sandstone_wall = addWall("sandstone_wall", Blocks.sandstone,0);
			sandstone_chiseled_wall = addWall("sandstone_chiseled_wall", Blocks.sandstone,1);
			sandstone_smooth_wall = addWall("sandstone_smooth_wall", Blocks.sandstone,2);
		}

		if (ConfigHandler.enableBrickWall) {
			brick_wall = addWall("brick_wall", Blocks.brick_block);
		}
		if (ConfigHandler.enableNetherBrickWall) {
			nether_brick_wall = addWall("netherbrick_wall", Blocks.nether_brick);
		}

		if (ConfigHandler.enableQuartzWall) {
			quartz_wall = addWall("quartz_wall", Blocks.quartz_block);
			quartz_chiseled_wall = addWall("quartz_chiseled_wall", Blocks.quartz_block, 1);
			quartz_pillar_wall = addWall("quartz_pillar_wall", Blocks.quartz_block, 2);
		}
		
		if (ConfigHandler.enableDirtStairs) {
			dirt_stairs = addStairs("dirt_stairs", Blocks.dirt, 0);
		}
		if (ConfigHandler.enableDirtSlab) {
			dirt_slab = addSlab("dirt_slab",Blocks.dirt, 1.0F);
		}

		if (ConfigHandler.enableStoneStairs) {
			stone_stairs = addStairs("stone_stairs", Blocks.stone, 0);
		}

		if (ConfigHandler.moreMossyCobblestoneBlocks ) {
			cobblestone_mossy_stairs = addStairs("cobblestone_mossy_stairs", Blocks.mossy_cobblestone);
			cobblestone_mossy_slab = addSlab("cobblestone_mossy_slab", Blocks.mossy_cobblestone);
		}

		if (ConfigHandler.moreStoneBricksBlocks) {
			stonebrick_mossy_stairs = addStairs("stonebrick_mossy_stairs", Blocks.stonebrick, 1);
			stonebrick_cracked_stairs = addStairs("stonebrick_cracked_stairs", Blocks.stonebrick, 2);
			stonebrick_chiseled_stairs = addStairs("stonebrick_chiseled_stairs", Blocks.stonebrick, 3);
			stonebrick_mossy_slab = addSlab("stonebrick_mossy_slab", Blocks.stonebrick, 1);
			stonebrick_cracked_slab = addSlab("stonebrick_cracked_slab", Blocks.stonebrick, 2);
			stonebrick_chiseled_slab = addSlab("stonebrick_chiseled_slab", Blocks.stonebrick, 3);
		}

		if (ConfigHandler.moreSandstoneBlocks) {
			sandstone_chiseled_stairs = addStairs("sandstone_chiseled_stairs", Blocks.sandstone, 1);
			sandstone_smooth_stairs = addStairs("sandstone_smooth_stairs", Blocks.sandstone, 2);
			sandstone_chiseled_slab = addSlab("sandstone_chiseled_slab", Blocks.sandstone, 1);
			sandstone_smooth_slab = addSlab("sandstone_smooth_slab", Blocks.sandstone, 2);
		}

		if (ConfigHandler.moreQuartzBlocks) {
			quartz_chiseled_stairs = addStairs("quartz_chiseled_stairs", Blocks.quartz_block, 1);
			quartz_pillar_stairs = addStairs("quartz_pillar_stairs", Blocks.quartz_block, 2);
			quartz_chiseled_slab = addSlab("quartz_chiseled_slab", Blocks.quartz_block, 1);
			quartz_pillar_slab = addSlab("quartz_pillar_slab", Blocks.quartz_block, 2);
		}
		
		if (ConfigHandler.enableWoodSpecificFences) {
			oak_fence = addFence("oak_fence", Blocks.planks);
			spruce_fence = addFence("spruce_fence", Blocks.planks, 1);
			birch_fence = addFence("birch_fence", Blocks.planks, 2);
			jungle_fence = addFence("jungle_fence", Blocks.planks, 3);
			acacia_fence = addFence("acacia_fence", Blocks.planks, 4);
			big_oak_fence = addFence("big_oak_fence", Blocks.planks, 5);
		}
		
		if (ConfigHandler.enableWoodSpecificFenceGates) {
			oak_fence_gate = addFenceGate("oak_fence_gate", Blocks.planks);
			spruce_fence_gate = addFenceGate("spruce_fence_gate", Blocks.planks, 1);
			birch_fence_gate = addFenceGate("birch_fence_gate", Blocks.planks, 2);
			jungle_fence_gate = addFenceGate("jungle_fence_gate", Blocks.planks, 3);
			acacia_fence_gate = addFenceGate("acacia_fence_gate", Blocks.planks, 4);
			big_oak_fence_gate = addFenceGate("big_oak_fence_gate", Blocks.planks, 5);
		}
	
	}
	
	public static BlockWallP addWall(String name, Block block)
	{
		return addWall(name, block, 0);
	}

	public static BlockWallP addWall(String name, Block block, int meta)
	{
		BlockWallP wall = new BlockWallP(block, meta);
		wall.setBlockName(name);
		GameRegistry.registerBlock(wall, name);
		return wall;
	}

	public static BlockFenceP addFence(String name, Block block)
	{
		return addFence(name, block, 0);
	}
	
	public static BlockFenceP addFence(String name, Block block, int meta)
	{
		BlockFenceP fence = new BlockFenceP(block, meta);
		fence.setBlockName(name).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood);
		GameRegistry.registerBlock(fence, name);
		return fence;
	}
	
	public static BlockFenceGateP addFenceGate(String name, Block block)
	{
		return addFenceGate(name, block, 0);
	}
	
	public static BlockFenceGateP addFenceGate(String name, Block block, int meta)
	{
		BlockFenceGateP gate = new BlockFenceGateP(block, meta);
		gate.setBlockName(name).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood);
		GameRegistry.registerBlock(gate, name);
		return gate;
	}

	public static BlockStairsP addStairs(String name, Block block)
	{
		return addStairs(name, block, 0);
	}
	
	public static BlockStairsP addStairs(String name, Block block, int meta)
	{
		BlockStairsP stair = new BlockStairsP(block,meta);
		stair.setBlockName(name);
		GameRegistry.registerBlock(stair, name);
		return stair;
	}
	
	public static BlockSlabP addSlab(String name, Block block) {
		return addSlab(name, block, 0);
	}
	public static BlockSlabP addSlab(String name, Block block, float hardness) {
		return addSlab(name, block, 0, null, null, hardness);
	}
	public static BlockSlabP addSlab(String name, Block block, int meta) {
		return addSlab(name, block, meta, null, null);
	}
	public static BlockSlabP addSlab(String name, Block block, String topTexture, String sideTexture) {
		return addSlab(name, block, 0, topTexture, sideTexture);
	}
	public static BlockSlabP addSlab(String name, Block block, int meta, String topTexture, String sideTexture) {
		return addSlab(name, block, meta, topTexture, sideTexture, 2.0f);
	}
	public static BlockSlabP addSlab(String name, Block block, int meta, String topTexture, String sideTexture, float hardness) {
		return addSlab(name, block, meta, topTexture, sideTexture, hardness, hardness*5);
	}
	public static BlockSlabP addSlab(String name, Block block, int meta, String topTexture, String sideTexture, float hardness, float resistance) {
		BlockSlabP singleSlab = new BlockSlabP(false, block, meta, topTexture, sideTexture);
		singleSlab.setBlockName(name).setHardness(hardness).setResistance(resistance).setStepSound(Block.soundTypePiston);
		BlockSlabP doubleSlab = new BlockSlabP(true, block, meta, topTexture, sideTexture);
		doubleSlab.setBlockName(name).setHardness(hardness).setResistance(resistance).setStepSound(Block.soundTypePiston);
		doubleSlab.setHalfBlock(singleSlab);
		GameRegistry.registerBlock(singleSlab, ItemSlabP.class, name, singleSlab, doubleSlab, false);
		GameRegistry.registerBlock(doubleSlab, ItemSlabP.class, name+"_double", singleSlab, doubleSlab, false);
		
		return singleSlab;
	}
}
