package com.robo.plus.recipes;

import java.util.List;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;
import thaumcraft.common.config.ConfigBlocks;

import com.robo.plus.blocks.BlocksP;
import com.robo.plus.config.ConfigHandler;
import com.robo.plus.doors.DoorsP;
import com.robo.plus.items.ItemsP;
import com.robo.plus.plugins.BiomesOPlentyPlugin;
import com.robo.plus.plugins.EtFuturumPlugin;
import com.robo.plus.recipes.RecipeHelper;

public class RecipeHandler {

	public static void registerRecipes() {
		
		//OreDictionary.registerOre("stickWood", Items.stick);
		Object stickWood = "stickWood";
		Object ingotIron = "ingotIron";
		Object blockCobblestone = "cobblestone";
		Object blockQuartz = "blockQuartz";
		Object blockStone = "stone";
		Object blockSandstone = "sandstone";
		if (!ConfigHandler.useOreDict) {
			stickWood = Items.stick;
			ingotIron = Items.iron_ingot;
			blockCobblestone = Blocks.cobblestone;
			blockQuartz = Blocks.quartz_block;
			blockStone = Blocks.stone;
			blockSandstone = Blocks.sandstone;
		}
		
		
		// Walls
		if (ConfigHandler.replaceVanillaWalls) {
			
			RecipeHelper.removeRecipes(Blocks.cobblestone_wall);
			if (Loader.isModLoaded("malisiscore")) {
				safeAddShaped(BlocksP.cobblestone_wall, 6, 1, new Object[] {"###", "###", '#', Blocks.mossy_cobblestone});
				safeAddOreShaped(BlocksP.cobblestone_wall, 6, 0, new Object[] {"###", "###", '#', blockCobblestone});
			} else {
				safeAddShaped(BlocksP.cobblestone_mossy_wall, 6, new Object[] {"###", "###", '#', Blocks.mossy_cobblestone});
				safeAddOreShaped(BlocksP.cobblestone_wall, 6, new Object[] {"###", "###", '#', blockCobblestone});
				GameRegistry.addShapelessRecipe(new ItemStack(BlocksP.cobblestone_wall, 1), new ItemStack(Blocks.cobblestone_wall, 1, 0)); // Convert vanilla to minecraft+
				GameRegistry.addShapelessRecipe(new ItemStack(BlocksP.cobblestone_mossy_wall, 1), new ItemStack(Blocks.cobblestone_wall, 1, 1)); // Convert vanilla to minecraft+
			}
			if (!ConfigHandler.useOreDict)
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlocksP.cobblestone_wall, 6), new Object[] {"###", "###", '#', "cobblestone"})); // Fallback
		}

		if (ConfigHandler.enableStoneWall) {
			safeAddOreShaped(BlocksP.stone_wall, 6, new Object[] {"###", "###", '#', blockStone});
		}
		
		if (ConfigHandler.enableStoneBrickWall) {
			safeAddShaped(BlocksP.stonebrick_mossy_wall, 6, new Object[] {"###", "###", '#', new ItemStack(Blocks.stonebrick, 1, 1)});
			safeAddShaped(BlocksP.stonebrick_cracked_wall, 6, new Object[] {"###", "###", '#', new ItemStack(Blocks.stonebrick, 1, 2)});
			safeAddShaped(BlocksP.stonebrick_chiseled_wall, 6, new Object[] {"###", "###", '#', new ItemStack(Blocks.stonebrick, 1, 3)});
			safeAddShaped(BlocksP.stonebrick_wall, 6, new Object[] {"###", "###", '#', new ItemStack(Blocks.stonebrick, 1, 0)});
		}
		
		if (ConfigHandler.enableSandstoneWall) {
			safeAddShaped(BlocksP.sandstone_chiseled_wall, 6, new Object[] {"###", "###", '#', new ItemStack(Blocks.sandstone, 1, 1)});
			safeAddShaped(BlocksP.sandstone_smooth_wall, 6, new Object[] {"###", "###", '#', new ItemStack(Blocks.sandstone, 1, 2)});
			safeAddOreShaped(BlocksP.sandstone_wall, 6, new Object[] {"###", "###", '#', blockSandstone});
			if (!ConfigHandler.useOreDict)
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlocksP.sandstone_wall, 6), new Object[] {"###", "###", '#', "sandstone"})); // Fallback
		}
		
		if (ConfigHandler.enableBrickWall) {
			safeAddShaped(BlocksP.brick_wall, 6, new Object[] {"###", "###", '#', Blocks.brick_block});
		}
		if (ConfigHandler.enableNetherBrickWall) {
			safeAddShaped(BlocksP.nether_brick_wall, 7, new Object[] {" # ", "###", "###", '#', Blocks.nether_brick});
		}
		if (ConfigHandler.enableNetherrackWall) {
			safeAddShaped(BlocksP.netherrack_wall, 6, new Object[] {"###", "###", '#', Blocks.netherrack});
		}
		if (ConfigHandler.enableQuartzWall) {
			safeAddShaped(BlocksP.quartz_chiseled_wall, 6, new Object[] {"###", "###", '#', new ItemStack(Blocks.quartz_block, 1, 1)});
			safeAddShaped(BlocksP.quartz_pillar_wall, 6, new Object[] {"###", "###", '#', new ItemStack(Blocks.quartz_block, 1, 2)});
			safeAddOreShaped(BlocksP.quartz_wall, 6, new Object[] {"###", "###", '#', blockQuartz});
		}
		
		if (ConfigHandler.enableThaumcraftWalls) {
			if (Loader.isModLoaded("Thaumcraft")) {
				safeAddShaped(BlocksP.arcane_stone_wall, 6, new Object[] {"###", "###", '#', new ItemStack(ConfigBlocks.blockCosmeticSolid, 1, 6)});
				safeAddShaped(BlocksP.arcane_brick_wall, 6, new Object[] {"###", "###", '#', new ItemStack(ConfigBlocks.blockCosmeticSolid, 1, 7)});
				safeAddShaped(BlocksP.ancient_stone_wall, 6, new Object[] {"###", "###", '#', new ItemStack(ConfigBlocks.blockCosmeticSolid, 1, 11)});
			}
		}
		// Stairs

		if (ConfigHandler.moreStoneBricksBlocks) {
			List<IRecipe> oldRecipes = RecipeHelper.removeRecipes(Blocks.stone_brick_stairs);
			safeAddShaped(BlocksP.stonebrick_mossy_stairs, 4, new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.stonebrick, 1, 1)});
			safeAddShaped(BlocksP.stonebrick_cracked_stairs, 4, new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.stonebrick, 1, 2)});
			safeAddShaped(BlocksP.stonebrick_chiseled_stairs, 4, new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.stonebrick, 1, 3)});
//			safeAddShaped(Blocks.stone_brick_stairs, 4, new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.stonebrick, 1, 0)});
			RecipeHelper.addRecipes(oldRecipes);
			oldRecipes = RecipeHelper.removeRecipes(Blocks.stone_slab,5);
			safeAddShaped(BlocksP.stonebrick_mossy_slab, 6, new Object[] {"###", '#', new ItemStack(Blocks.stonebrick, 1, 1)});
			safeAddShaped(BlocksP.stonebrick_cracked_slab, 6, new Object[] {"###", '#', new ItemStack(Blocks.stonebrick, 1, 2)});
			safeAddShaped(BlocksP.stonebrick_chiseled_slab, 6, new Object[] {"###", '#', new ItemStack(Blocks.stonebrick, 1, 3)});
//			safeAddShaped(Blocks.stone_slab, 6, 5, new Object[] {"###", '#', new ItemStack(Blocks.stonebrick, 1, 0)});
			RecipeHelper.addRecipes(oldRecipes);
		}
		
		if (ConfigHandler.moreSandstoneBlocks) {
			List<IRecipe> oldRecipes = RecipeHelper.removeRecipes(Blocks.sandstone_stairs);
			safeAddShaped(BlocksP.sandstone_chiseled_stairs, 4, new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.sandstone, 1, 1)});
			safeAddShaped(BlocksP.sandstone_smooth_stairs, 4, new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.sandstone, 1, 2)});
//			safeAddOreShaped(Blocks.sandstone_stairs, 4, new Object[] {"#  ", "## ", "###", '#', blockSandstone});
			RecipeHelper.addRecipes(oldRecipes);
			oldRecipes = RecipeHelper.removeRecipes(Blocks.stone_slab,1);
			safeAddShaped(BlocksP.sandstone_chiseled_slab, 6, new Object[] {"###", '#', new ItemStack(Blocks.sandstone, 1, 1)});
			safeAddShaped(BlocksP.sandstone_smooth_slab, 6, new Object[] {"###", '#', new ItemStack(Blocks.sandstone, 1, 2)});
//			safeAddOreShaped(Blocks.stone_slab, 6, 1, new Object[] {"###", '#', blockSandstone});
			RecipeHelper.addRecipes(oldRecipes);
		}

		if (ConfigHandler.moreQuartzBlocks) {
			List<IRecipe> oldRecipes = RecipeHelper.removeRecipes(Blocks.quartz_stairs); 
			safeAddShaped(BlocksP.quartz_chiseled_stairs, 4, new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.quartz_block, 1, 1)});
			safeAddShaped(BlocksP.quartz_pillar_stairs, 4, new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.quartz_block, 1, 2)});
//			safeAddOreShaped(Blocks.quartz_stairs, 4, new Object[] {"#  ", "## ", "###", '#', blockQuartz});
			RecipeHelper.addRecipes(oldRecipes);
			oldRecipes = RecipeHelper.removeRecipes(Blocks.stone_slab,7);
			safeAddShaped(BlocksP.quartz_chiseled_slab, 6, new Object[] {"###", '#', new ItemStack(Blocks.quartz_block, 1, 1)});
			safeAddShaped(BlocksP.quartz_pillar_slab, 6, new Object[] {"###", '#', new ItemStack(Blocks.quartz_block, 1, 2)});
//			safeAddOreShaped(Blocks.stone_slab, 6, 7, new Object[] {"###", '#', blockQuartz});
			RecipeHelper.addRecipes(oldRecipes);
		}


		if (ConfigHandler.enableDirtStairs) {
			safeAddShaped(BlocksP.dirt_stairs, 4, new Object[] {"#  ", "## ", "###", '#', Blocks.dirt});
			GameRegistry.addShapedRecipe(new ItemStack(Blocks.dirt, 2), new Object[] {"## ", '#', BlocksP.dirt_stairs}); // dirt_stairs -> dirt
		}
		if (ConfigHandler.enableDirtSlab) {
			safeAddShaped(BlocksP.dirt_slab, 6, new Object[] {"###", '#', Blocks.dirt});
			GameRegistry.addShapedRecipe(new ItemStack(Blocks.dirt, 2), new Object[] {"#", "#", '#', BlocksP.dirt_slab}); // dirt_slab -> dirt
		}

		if (ConfigHandler.enableStoneStairs) {
			safeAddOreShaped(BlocksP.stone_stairs, 4, new Object[] {"#  ", "## ", "###", '#', blockStone});
		}
		if (ConfigHandler.enableNetherrackStairs) {
			safeAddShaped(BlocksP.netherrack_stairs, 4, new Object[] {"#  ", "## ", "###", '#', Blocks.netherrack});
		}
		if (ConfigHandler.enableNetherrackSlab) {
			safeAddShaped(BlocksP.netherrack_slab, 6, new Object[] {"###", '#', Blocks.netherrack});
		}

		if (ConfigHandler.moreMossyCobblestoneBlocks ) {
			safeAddShaped(BlocksP.cobblestone_mossy_stairs, 4, new Object[] {"#  ", "## ", "###", '#', Blocks.mossy_cobblestone});
			safeAddShaped(BlocksP.cobblestone_mossy_slab, 6, new Object[] {"###", '#', Blocks.mossy_cobblestone});
		}

		if (ConfigHandler.enableEtFuturum) {
			for (int i = 0; i < EtFuturumPlugin.stoneTypes.length; i++) {
				safeAddShaped(BlocksP.etfuturum_wall[i], 3, new Object[] {"###", "###", '#', new ItemStack( EtFuturumPlugin.getStone(), 1, i+1)});
				safeAddShaped(BlocksP.etfuturum_stairs[i], 3, new Object[] {"#  ", "## ", "###", '#', new ItemStack( EtFuturumPlugin.getStone(), 1, i+1)});
				safeAddShaped(BlocksP.etfuturum_slab[i], 3, new Object[] {"###", '#', new ItemStack( EtFuturumPlugin.getStone(), 1, i+1)});
			}
		}
		
		// Fences of all wood types
		if (ConfigHandler.enableWoodSpecificFences) {
			//removeRecipes(Blocks.fence);  // This one does not conflict so no need to remove it
			if (ConfigHandler.replaceVanillaFences) {
				if (!Loader.isModLoaded("malisiscore")) {
					GameRegistry.addShapelessRecipe(new ItemStack(BlocksP.oak_fence, 1), Blocks.fence); // Vanilla Fence >> Plus Oak Fence
					RecipeHelper.removeRecipes(Blocks.nether_brick_fence);
					safeAddShaped(BlocksP.nether_brick_fence, 6, new Object[] {"###", "###", '#', Blocks.nether_brick});
					GameRegistry.addShapelessRecipe(new ItemStack(BlocksP.nether_brick_fence, 1), Blocks.nether_brick_fence); // Vanilla Nether Brick Fence >> Plus Nether Brick Fence
				}
			}
			safeAddOreShaped(BlocksP.oak_fence, 3, new Object[] {"#I#", "#I#", '#', new ItemStack(Blocks.planks, 1, 0), 'I', stickWood});
			safeAddOreShaped(BlocksP.spruce_fence, 3, new Object[] {"#I#", "#I#", '#', new ItemStack(Blocks.planks, 1, 1), 'I', stickWood});
			safeAddOreShaped(BlocksP.birch_fence, 3, new Object[] {"#I#", "#I#", '#', new ItemStack(Blocks.planks, 1, 2), 'I', stickWood});
			safeAddOreShaped(BlocksP.jungle_fence, 3, new Object[] {"#I#", "#I#", '#', new ItemStack(Blocks.planks, 1, 3), 'I', stickWood});
			safeAddOreShaped(BlocksP.acacia_fence, 3, new Object[] {"#I#", "#I#", '#', new ItemStack(Blocks.planks, 1, 4), 'I', stickWood});
			safeAddOreShaped(BlocksP.big_oak_fence, 3, new Object[] {"#I#", "#I#", '#', new ItemStack(Blocks.planks, 1, 5), 'I', stickWood});
			
			if (ConfigHandler.enableThaumcraftFences) {
				safeAddOreShaped(BlocksP.greatwood_fence, 3, new Object[] {"#I#", "#I#", '#', new ItemStack(ConfigBlocks.blockWoodenDevice, 1, 6), 'I', stickWood});
				safeAddOreShaped(BlocksP.silverwood_fence, 3, new Object[] {"#I#", "#I#", '#', new ItemStack(ConfigBlocks.blockWoodenDevice, 1, 7), 'I', stickWood});
			}

			if (ConfigHandler.enableBiomesOPlenty) {
				for (int i = 0; i < BiomesOPlentyPlugin.woodTypes.length; i++) {
					safeAddOreShaped(BlocksP.bop_fence[i], 3, new Object[] {"#I#", "#I#", '#', new ItemStack( BiomesOPlentyPlugin.getWoodPlanks(), 1, i), 'I', stickWood});
				}
			}
		}
		
		// Fence gates of all wood types
		if (ConfigHandler.enableWoodSpecificFenceGates) {
			List<IRecipe> oldFenceGateRecipes = RecipeHelper.removeRecipes(Blocks.fence_gate); // We re-add it again later so it comes after our recipe
			safeAddOreShaped(Blocks.fence_gate, 1, new Object[] {"I#I", "I#I", '#', new ItemStack(Blocks.planks, 1, 0), 'I', stickWood});
			safeAddOreShaped(BlocksP.spruce_fence_gate, 1, new Object[] {"I#I", "I#I", '#', new ItemStack(Blocks.planks, 1, 1), 'I', stickWood});
			safeAddOreShaped(BlocksP.birch_fence_gate, 1, new Object[] {"I#I", "I#I", '#', new ItemStack(Blocks.planks, 1, 2), 'I', stickWood});
			safeAddOreShaped(BlocksP.jungle_fence_gate, 1, new Object[] {"I#I", "I#I", '#', new ItemStack(Blocks.planks, 1, 3), 'I', stickWood});
			safeAddOreShaped(BlocksP.acacia_fence_gate, 1, new Object[] {"I#I", "I#I", '#', new ItemStack(Blocks.planks, 1, 4), 'I', stickWood});
			safeAddOreShaped(BlocksP.big_oak_fence_gate, 1, new Object[] {"I#I", "I#I", '#', new ItemStack(Blocks.planks, 1, 5), 'I', stickWood});
			safeAddOreShaped(BlocksP.nether_brick_fence_gate, 1, new Object[] {"I#I", "I#I", '#', new ItemStack(Blocks.nether_brick, 1, 0), 'I', stickWood});

			if (ConfigHandler.enableThaumcraftFences) {
				safeAddOreShaped(BlocksP.greatwood_fence_gate, 1, new Object[] {"I#I", "I#I", '#', new ItemStack(ConfigBlocks.blockWoodenDevice, 1, 6), 'I', stickWood});
				safeAddOreShaped(BlocksP.silverwood_fence_gate, 1, new Object[] {"I#I", "I#I", '#', new ItemStack(ConfigBlocks.blockWoodenDevice, 1, 7), 'I', stickWood});
			}

			if (ConfigHandler.enableBiomesOPlenty) {
				for (int i = 0; i < BiomesOPlentyPlugin.woodTypes.length; i++) {
					safeAddOreShaped(BlocksP.bop_fence_gate[i], 1, new Object[] {"I#I", "I#I", '#', new ItemStack(BiomesOPlentyPlugin.getWoodPlanks(), 1, i), 'I', stickWood});
				}
			}
			// Re-add vanilla fence gate recipe
			RecipeHelper.addRecipes(oldFenceGateRecipes);
			//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.fence_gate, 1), new Object[] {"I#I", "I#I", '#', "plankWood", 'I', "stickWood"}));
		}

		
		if (ConfigHandler.enableWoodSpecificDoors) {
			int numDoors = 3;
			List<IRecipe> oldDoorRecipes = RecipeHelper.removeRecipes(Items.wooden_door); // We re-add it again later so it comes after our recipe
			if (ConfigHandler.replaceVanillaDoors) {
				safeAddShaped(DoorsP.door_item[0], numDoors, new Object[] {"##", "##", "##", '#', new ItemStack(Blocks.planks, 1, 0)}); // Oak Door from Oak Planks
				List<IRecipe> oldIronDoorRecipes = RecipeHelper.removeRecipes(Items.iron_door);
				safeAddOreShaped(DoorsP.door_iron_item, numDoors, new Object[] {"##", "##", "##", '#', ingotIron});
				RecipeHelper.addRecipes(oldIronDoorRecipes);
				if (!Loader.isModLoaded("malisiscore")) {
					GameRegistry.addShapelessRecipe(new ItemStack(DoorsP.door_item[0], 1), Items.wooden_door);  // Vanilla Wood Door -> Minecraft+ Oak Door
					GameRegistry.addShapelessRecipe(new ItemStack(DoorsP.door_iron_item, 1), Items.iron_door);  // Vanilla Iron Door -> Minecraft+ Iron Door
				}
			} else {
				numDoors = 1;
				safeAddShaped(Items.wooden_door, numDoors, new Object[] {"##", "##", "##", '#', new ItemStack(Blocks.planks, 1, 0)}); // Vanilla Wood Door from Oak Planks
			}
			safeAddShaped(DoorsP.door_item[1], numDoors, new Object[] {"##", "##", "##", '#', new ItemStack(Blocks.planks, 1, 1)});
			safeAddShaped(DoorsP.door_item[2], numDoors, new Object[] {"##", "##", "##", '#', new ItemStack(Blocks.planks, 1, 2)});
			safeAddShaped(DoorsP.door_item[3], numDoors, new Object[] {"##", "##", "##", '#', new ItemStack(Blocks.planks, 1, 3)});
			safeAddShaped(DoorsP.door_item[4], numDoors, new Object[] {"##", "##", "##", '#', new ItemStack(Blocks.planks, 1, 4)});
			safeAddShaped(DoorsP.door_item[5], numDoors, new Object[] {"##", "##", "##", '#', new ItemStack(Blocks.planks, 1, 5)});
			// TODO: Add Thaumcraft Doors
			// TODO: Add BiomesOPlenty Doors
			// Re-add vanilla door recipes
			RecipeHelper.addRecipes(oldDoorRecipes);
		}
	
		if (ConfigHandler.enableObsidianTools) {
			safeAddOreShaped(ItemsP.obsidian_sword, 1, new Object[] {"#", "#", "I", '#', Blocks.obsidian, 'I', ingotIron});
			safeAddOreShaped(ItemsP.obsidian_axe, 1, new Object[] {"##", "I#", "I ", '#', Blocks.obsidian, 'I', ingotIron});
			safeAddOreShaped(ItemsP.obsidian_hoe, 1, new Object[] {"##", "I ", "I ", '#', Blocks.obsidian, 'I', ingotIron});
			safeAddOreShaped(ItemsP.obsidian_pickaxe, 1, new Object[] {"###", " I ", " I ", '#', Blocks.obsidian, 'I', ingotIron});
			safeAddOreShaped(ItemsP.obsidian_shovel, 1, new Object[] {"#", "I", "I", '#', Blocks.obsidian, 'I', ingotIron});
			safeAddOreShaped(ItemsP.obsidian_bow, 1, new Object[] {" #S", "I S", " #S", '#', Blocks.obsidian, 'I', ingotIron, 'S', Items.string});
		}
		if (ConfigHandler.enableIronBow) {
			safeAddOreShaped(ItemsP.iron_bow, 1, new Object[] {" IS", "I S", " IS", 'I', ingotIron, 'S', Items.string});
		}
		
		if (ConfigHandler.addMuttonToSheep) {
			GameRegistry.addSmelting(new ItemStack(ItemsP.mutton_raw, 1), new ItemStack(ItemsP.mutton_cooked, 1), 0.35F);
		}

		// Add missing recipes for vanilla items
		
		if (ConfigHandler.enableMissingRecipes) {
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.mossy_cobblestone, 1), new Object[] {Blocks.cobblestone, Blocks.vine});
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stonebrick, 1, 1), new Object[] {new ItemStack(Blocks.stonebrick, 1, 0), Blocks.vine});
			GameRegistry.addShapedRecipe(new ItemStack(Blocks.stonebrick, 1, 3), new Object[] {"#", "#", '#', new ItemStack(Blocks.stone_slab, 1, 5)});
			GameRegistry.addSmelting(new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 2), 0.1F);
		}
		
	}	
	

	private static IRecipe safeAddShaped(Item item, int num, Object... params) {
		return safeAddShaped(item, num, 0, params);
	}

	private static IRecipe safeAddShaped(Item item, int num, int meta, Object... params)
	{
		if (item != null) {
			IRecipe recipe = GameRegistry.addShapedRecipe(new ItemStack(item, num, meta), params);
			if (ConfigHandler.recipesFirst)
				RecipeHelper.moveRecipeToTop(recipe);
			return recipe;
		}
		return null;
	}

	private static IRecipe safeAddShaped(Block block, int num, Object... params) {
		return safeAddShaped(block, num, 0, params);
	}
	
	private static IRecipe safeAddShaped(Block block, int num, int meta, Object... params)
	{
		if (block != null) {
			return safeAddShaped(Item.getItemFromBlock(block), num, meta, params);
		}
		return null;
	}

// Ore Dict
	
	private static IRecipe safeAddOreShaped(Item item, int num, Object... params) {
		if (ConfigHandler.useOreDict)
			return safeAddOreShaped(item, num, 0, params);
		else
			return safeAddShaped(item, num, 0, params);
	}
	
	private static IRecipe safeAddOreShaped(Item item, int num, int meta, Object... params)
	{
		if (ConfigHandler.useOreDict) {
			if (item != null) {
				IRecipe recipe = new ShapedOreRecipe(new ItemStack(item, num, meta), params);
				GameRegistry.addRecipe(recipe);
				if (ConfigHandler.recipesFirst)
					RecipeHelper.moveRecipeToTop(recipe);
				return recipe;
			}
			return null;
		} else 
			return safeAddShaped(item, num, 0, params);
	}

	private static IRecipe safeAddOreShaped(Block block, int num, Object... params) {
		return safeAddOreShaped(block, num, 0, params);
	}
	
	private static IRecipe safeAddOreShaped(Block block, int num, int meta, Object... params)
	{
		if (block != null) {
			return safeAddOreShaped(Item.getItemFromBlock(block), num, meta, params);
		}
		return null;
	}
}
