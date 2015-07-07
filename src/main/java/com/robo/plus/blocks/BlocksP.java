package com.robo.plus.blocks;

import thaumcraft.common.config.ConfigBlocks;

import com.robo.plus.config.ConfigHandler;
import com.robo.plus.items.ItemSlabP;
import com.robo.plus.plugins.BiomesOPlentyPlugin;
import com.robo.plus.plugins.EtFuturumPlugin;
import com.robo.plus.plugins.ThaumcraftPlugin;


// MalisisCore 1.7.10-0.11.4
import net.malisis.core.util.replacement.ReplacementTool;
//MalisisCore 1.7.10-0.10.6
//import net.malisis.core.ReplacementTool;

import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlocksP {
	
	public static BlockWall cobblestone_wall;
	public static BlockWall cobblestone_mossy_wall;
	public static BlockWall stone_wall;
	public static BlockWall stonebrick_wall;
	public static BlockWall stonebrick_mossy_wall;
	public static BlockWall stonebrick_cracked_wall;
	public static BlockWall stonebrick_chiseled_wall;
	public static BlockWall sandstone_wall;
	public static BlockWall sandstone_chiseled_wall;
	public static BlockWall sandstone_smooth_wall;
	public static BlockWall brick_wall;
	public static BlockWall nether_brick_wall;
	public static BlockWall quartz_wall;
	public static BlockWall quartz_chiseled_wall;
	public static BlockWall quartz_pillar_wall;
	public static BlockWall netherrack_wall;
	public static BlockWall arcane_stone_wall;
	public static BlockWall arcane_brick_wall;
	public static BlockWall ancient_stone_wall;
	public static BlockWall[] etfuturum_wall;
	
	public static BlockStairs dirt_stairs;
	public static BlockStairs stone_stairs;
	public static BlockStairs cobblestone_mossy_stairs;
	public static BlockStairs stonebrick_mossy_stairs;
	public static BlockStairs stonebrick_cracked_stairs;
	public static BlockStairs stonebrick_chiseled_stairs;
	public static BlockStairs sandstone_chiseled_stairs;
	public static BlockStairs sandstone_smooth_stairs;
	public static BlockStairs quartz_stairs;
	public static BlockStairs quartz_chiseled_stairs;
	public static BlockStairs quartz_pillar_stairs;
	public static BlockStairs netherrack_stairs;
	public static BlockStairs[] etfuturum_stairs;
	
	public static BlockSlab dirt_slab;
	public static BlockSlab cobblestone_mossy_slab;
	public static BlockSlab stonebrick_mossy_slab;
	public static BlockSlab stonebrick_cracked_slab;
	public static BlockSlab stonebrick_chiseled_slab; 
	public static BlockSlab sandstone_chiseled_slab;
	public static BlockSlab sandstone_smooth_slab;
	public static BlockSlab quartz_chiseled_slab;
	public static BlockSlab quartz_pillar_slab;
	public static BlockSlab netherrack_slab;
	public static BlockSlab[] etfuturum_slab;
	
	public static BlockFence oak_fence;
	public static BlockFence spruce_fence;
	public static BlockFence birch_fence;
	public static BlockFence jungle_fence;
	public static BlockFence acacia_fence;
	public static BlockFence big_oak_fence;
	public static BlockFence nether_brick_fence;
	public static BlockFence greatwood_fence;
	public static BlockFence silverwood_fence;
	public static BlockFence[] bop_fence;
	
//	public static BlockFenceGate oak_fence_gate;
	public static BlockFenceGate spruce_fence_gate;
	public static BlockFenceGate birch_fence_gate;
	public static BlockFenceGate jungle_fence_gate;
	public static BlockFenceGate acacia_fence_gate;
	public static BlockFenceGate big_oak_fence_gate;
	public static BlockFenceGate nether_brick_fence_gate;
	public static BlockFenceGate greatwood_fence_gate;
	public static BlockFenceGate silverwood_fence_gate;
	public static BlockFenceGate[] bop_fence_gate;
	
	public static void registerBlocks() 
	{
		
		if (ConfigHandler.replaceVanillaWalls) {
			if (Loader.isModLoaded("malisiscore") && ConfigHandler.enableMalisisDoors) {
				cobblestone_wall = new BlockCobblestoneWall(Blocks.cobblestone);
				cobblestone_mossy_wall = cobblestone_wall;
				ReplacementTool.replaceVanillaBlock(139, "cobblestone_wall", "field_150463_bK", cobblestone_wall, Blocks.cobblestone_wall);
			} else {
				cobblestone_wall = addWall("cobblestone_wall", Blocks.cobblestone);
				cobblestone_mossy_wall = addWall("cobblestone_mossy_wall", Blocks.mossy_cobblestone);
			}
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
		if (ConfigHandler.enableNetherrackWall) {
			netherrack_wall = addWall("netherrack_wall", Blocks.netherrack);
		}

		if (ConfigHandler.enableQuartzWall) {
			quartz_wall = addWall("quartz_wall", Blocks.quartz_block);
			quartz_chiseled_wall = addWall("quartz_chiseled_wall", Blocks.quartz_block, 1);
			quartz_pillar_wall = addWall("quartz_pillar_wall", Blocks.quartz_block, 2);
		}

		if (ConfigHandler.enableThaumcraftWalls) {
			if (Loader.isModLoaded("Thaumcraft")) {
				arcane_stone_wall = addWall("arcane_stone_wall", ConfigBlocks.blockCosmeticSolid, 6);
				arcane_stone_wall.setResistance(20.0F);
				arcane_brick_wall = addWall("arcane_brick_wall", ConfigBlocks.blockCosmeticSolid, 7);
				arcane_brick_wall.setHardness(4.0F).setResistance(20.0F);
				ancient_stone_wall = addWall("ancient_stone_wall", ConfigBlocks.blockCosmeticSolid, 11);
			}
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
		if (ConfigHandler.enableNetherrackStairs) {
			netherrack_stairs = addStairs("netherrack_stairs", Blocks.netherrack, 0);
		}
		if (ConfigHandler.enableNetherrackSlab) {
			netherrack_slab = addSlab("netherrack_slab",Blocks.netherrack, 2.0F);
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

		if (ConfigHandler.enableEtFuturum) {
			etfuturum_wall = new BlockWall[EtFuturumPlugin.stoneTypes.length];
			etfuturum_stairs = new BlockStairs[EtFuturumPlugin.stoneTypes.length];
			etfuturum_slab = new BlockSlab[EtFuturumPlugin.stoneTypes.length];
			for (int i = 1; i <= EtFuturumPlugin.stoneTypes.length; i++) {
				etfuturum_wall[i] = addWall( EtFuturumPlugin.stoneTypes[i]+"_wall", EtFuturumPlugin.getStone(), i);
				etfuturum_stairs[i] = addStairs( EtFuturumPlugin.stoneTypes[i]+"_stairs", EtFuturumPlugin.getStone(), i);
				etfuturum_slab[i] = addSlab( EtFuturumPlugin.stoneTypes[i]+"_slab", EtFuturumPlugin.getStone(), i);
			}
		}
		
		if (ConfigHandler.enableWoodSpecificFences) {
			if (ConfigHandler.replaceVanillaFences && Loader.isModLoaded("malisiscore") && ConfigHandler.enableMalisisDoors) {
				oak_fence = new BlockFenceP("oak_fence", Blocks.planks, 0);
				//oak_fence.setBlockName("oak_fence").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood);
				ReplacementTool.replaceVanillaBlock(85, "fence", "field_150422_aJ", oak_fence, Blocks.fence);
				nether_brick_fence = new BlockFenceP("nether_brick_fence", Blocks.nether_brick, 0);
				ReplacementTool.replaceVanillaBlock(113, "nether_brick_fence", "field_150386_bk", nether_brick_fence, Blocks.nether_brick_fence);
			} else {
				oak_fence = addFence("oak_fence", Blocks.planks);
				nether_brick_fence = addFence("nether_brick_fence", Blocks.nether_brick);
			}
			spruce_fence = addFence("spruce_fence", Blocks.planks, 1);
			birch_fence = addFence("birch_fence", Blocks.planks, 2);
			jungle_fence = addFence("jungle_fence", Blocks.planks, 3);
			acacia_fence = addFence("acacia_fence", Blocks.planks, 4);
			big_oak_fence = addFence("big_oak_fence", Blocks.planks, 5);
			
			if (ConfigHandler.enableBiomesOPlenty) {
				bop_fence = new BlockFence[BiomesOPlentyPlugin.woodTypes.length];
				for (int i = 0; i < BiomesOPlentyPlugin.woodTypes.length; i++) {
					bop_fence[i] = addFence( BiomesOPlentyPlugin.woodTypes[i]+"_fence", BiomesOPlentyPlugin.getWoodPlanks(), i);
				}
			}
		}
		
		if (ConfigHandler.enableWoodSpecificFenceGates) {
			// oak_fence_gate = addFenceGate("oak_fence_gate", Blocks.planks);
			spruce_fence_gate = addFenceGate("spruce_fence_gate", Blocks.planks, 1);
			birch_fence_gate = addFenceGate("birch_fence_gate", Blocks.planks, 2);
			jungle_fence_gate = addFenceGate("jungle_fence_gate", Blocks.planks, 3);
			acacia_fence_gate = addFenceGate("acacia_fence_gate", Blocks.planks, 4);
			big_oak_fence_gate = addFenceGate("big_oak_fence_gate", Blocks.planks, 5);
			nether_brick_fence_gate = addFenceGate("nether_brick_fence_gate", Blocks.nether_brick, 0);

			if (ConfigHandler.enableBiomesOPlenty) {
				bop_fence_gate = new BlockFenceGate[BiomesOPlentyPlugin.woodTypes.length];
				for (int i = 0; i < BiomesOPlentyPlugin.woodTypes.length; i++) {
					bop_fence_gate[i] = addFenceGate( BiomesOPlentyPlugin.woodTypes[i]+"_fence_gate", BiomesOPlentyPlugin.getWoodPlanks(), i);
				}
			}
		}

		if (ConfigHandler.enableThaumcraftFences) {
			if (ThaumcraftPlugin.use()) {
				greatwood_fence = addFence("greatwood_fence", ConfigBlocks.blockWoodenDevice, 6);
				silverwood_fence = addFence("silverwood_fence", ConfigBlocks.blockWoodenDevice, 7);
				greatwood_fence_gate = addFenceGate("greatwood_fence_gate", ConfigBlocks.blockWoodenDevice, 6);
				silverwood_fence_gate = addFenceGate("silverwood_fence_gate", ConfigBlocks.blockWoodenDevice, 7);
			}
		}
	
	}
	
	public static BlockWall addWall(String name, Block block)
	{
		return addWall(name, block, 0);
	}

	public static BlockWall addWall(String name, Block block, int meta)
	{
		BlockWallP wall = new BlockWallP(block, meta);
		wall.setBlockName(name);
		GameRegistry.registerBlock(wall, name);
		return wall;
	}

	public static BlockFence addFence(String name, Block block)
	{
		return addFence(name, block, 0);
	}
	
	public static BlockFence addFence(String name, Block block, int meta)
	{
		BlockFenceP fence = new BlockFenceP(name, block, meta);
		//fence.setBlockName(name).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood);
		GameRegistry.registerBlock(fence, name);
		return fence;
	}
	
	public static BlockFenceGate addFenceGate(String name, Block block)
	{
		return addFenceGate(name, block, 0);
	}
	
	public static BlockFenceGate addFenceGate(String name, Block block, int meta)
	{
		BlockFenceGate gate;
		gate = new BlockFenceGateP(block, meta);
		gate.setBlockName(name).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood);
		GameRegistry.registerBlock(gate, name);
		return gate;
	}

	public static BlockStairs addStairs(String name, Block block)
	{
		return addStairs(name, block, 0);
	}
	
	public static BlockStairs addStairs(String name, Block block, int meta)
	{
		BlockStairsP stair = new BlockStairsP(name, block, meta);
		GameRegistry.registerBlock(stair, name);
		return stair;
	}
	
	public static BlockSlab addSlab(String name, Block block) {
		return addSlab(name, block, 0);
	}
	public static BlockSlab addSlab(String name, Block block, float hardness) {
		return addSlab(name, block, 0, null, null, hardness);
	}
	public static BlockSlab addSlab(String name, Block block, int meta) {
		return addSlab(name, block, meta, null, null);
	}
	public static BlockSlab addSlab(String name, Block block, String topTexture, String sideTexture) {
		return addSlab(name, block, 0, topTexture, sideTexture);
	}
	public static BlockSlab addSlab(String name, Block block, int meta, String topTexture, String sideTexture) {
		return addSlab(name, block, meta, topTexture, sideTexture, 2.0f);
	}
	public static BlockSlab addSlab(String name, Block block, int meta, String topTexture, String sideTexture, float hardness) {
		return addSlab(name, block, meta, topTexture, sideTexture, hardness, hardness*5);
	}
	public static BlockSlab addSlab(String name, Block block, int meta, String topTexture, String sideTexture, float hardness, float resistance) {
		BlockSlabP singleSlab = new BlockSlabP(name, false, block, meta, topTexture, sideTexture);
		//singleSlab.setHardness(hardness).setResistance(resistance).setStepSound(Block.soundTypePiston);
		BlockSlabP doubleSlab = new BlockSlabP(name, true, block, meta, topTexture, sideTexture);
		//doubleSlab.setHardness(hardness).setResistance(resistance).setStepSound(Block.soundTypePiston);
		doubleSlab.setHalfBlock(singleSlab);
		GameRegistry.registerBlock(singleSlab, ItemSlabP.class, name, singleSlab, doubleSlab, false);
		GameRegistry.registerBlock(doubleSlab, ItemSlabP.class, name+"_double", singleSlab, doubleSlab, true);
		
		return singleSlab;
	}
	
	public static SoundType getSoundFromMaterial(Material material) {
		if (material == Material.ground) {
			return Block.soundTypeGravel;
		} else if (material == Material.wood ) {
			return Block.soundTypeWood;
		} else if (material == Material.grass ) {
			return Block.soundTypeGrass;
		} else if (material == Material.sand ) {
			return Block.soundTypeSand;
		} else if (material == Material.glass ) {
			return Block.soundTypeGlass;
		} else if (material == Material.iron ) {
			return Block.soundTypeMetal;
		}
		return Block.soundTypeStone;
	}
}
