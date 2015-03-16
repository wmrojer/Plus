package com.robo.minecraftp.recipes;

import java.util.Iterator;
import java.util.List;

import com.robo.minecraftp.blocks.BlocksP;
import com.robo.minecraftp.config.ConfigHandler;
import com.robo.minecraftp.doors.DoorsP;
import com.robo.minecraftp.items.ItemsP;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

public class RecipeHandler {

	public static void removeRecipe(Block block) {
		removeRecipe(Item.getItemFromBlock(block));
	}
	@SuppressWarnings("unchecked")
	public static void removeRecipe(Item item) {
		List<IRecipe> recipeList = CraftingManager.getInstance().getRecipeList();
		Iterator<IRecipe> recipe = recipeList.iterator();
		while (recipe.hasNext()) {
			ItemStack itemStack = recipe.next().getRecipeOutput();
			if (itemStack != null && itemStack.getItem() == item) {
				recipe.remove();
			}
		}
	}
	
	public static void removeRecipe(Block block, int metadata) {
		removeRecipe(Item.getItemFromBlock(block), metadata);
	}
	@SuppressWarnings("unchecked")
	public static void removeRecipe(Item item, int metadata) {
		List<IRecipe> recipeList = CraftingManager.getInstance().getRecipeList();
		Iterator<IRecipe> recipe = recipeList.iterator();
		while (recipe.hasNext()) {
			ItemStack itemStack = recipe.next().getRecipeOutput();
			if (itemStack != null && itemStack.getItem() == item && itemStack.getItemDamage() == metadata) {
				recipe.remove();
			}
		}
	}
	
	
	public static void registerRecipes() {
		
		// Walls
		if (ConfigHandler.replaceVanillaWalls) {
			removeRecipe(Blocks.cobblestone_wall);
			safeAddShaped(BlocksP.cobblestone_wall, 6, new Object[] {"###", "###", '#', Blocks.cobblestone});
			safeAddShaped(BlocksP.cobblestone_mossy_wall, 6, new Object[] {"###", "###", '#', Blocks.mossy_cobblestone});
			GameRegistry.addShapelessRecipe(new ItemStack(BlocksP.cobblestone_wall, 1), new ItemStack(Blocks.cobblestone_wall, 1, 0)); // Convert vanilla to minecraft+
			GameRegistry.addShapelessRecipe(new ItemStack(BlocksP.cobblestone_mossy_wall, 1), new ItemStack(Blocks.cobblestone_wall, 1, 1)); // Convert vanilla to minecraft+
		}

		if (ConfigHandler.enableStoneWall) {
			safeAddShaped(BlocksP.stone_wall, 6, new Object[] {"###", "###", '#', Blocks.stone});
		}
		
		if (ConfigHandler.enableStoneBrickWall) {
			safeAddShaped(BlocksP.stonebrick_wall, 6, new Object[] {"###", "###", '#', new ItemStack(Blocks.stonebrick, 1, 0)});
			safeAddShaped(BlocksP.stonebrick_mossy_wall, 6, new Object[] {"###", "###", '#', new ItemStack(Blocks.stonebrick, 1, 1)});
			safeAddShaped(BlocksP.stonebrick_cracked_wall, 6, new Object[] {"###", "###", '#', new ItemStack(Blocks.stonebrick, 1, 2)});
			safeAddShaped(BlocksP.stonebrick_chiseled_wall, 6, new Object[] {"###", "###", '#', new ItemStack(Blocks.stonebrick, 1, 3)});
		}
		
		if (ConfigHandler.enableSandstoneWall) {
			safeAddShaped(BlocksP.sandstone_wall, 6, new Object[] {"###", "###", '#', new ItemStack(Blocks.sandstone, 1, 0)});
			safeAddShaped(BlocksP.sandstone_chiseled_wall, 6, new Object[] {"###", "###", '#', new ItemStack(Blocks.sandstone, 1, 1)});
			safeAddShaped(BlocksP.sandstone_smooth_wall, 6, new Object[] {"###", "###", '#', new ItemStack(Blocks.sandstone, 1, 2)});
		}
		
		if (ConfigHandler.enableBrickWall) {
			safeAddShaped(BlocksP.brick_wall, 6, new Object[] {"###", "###", '#', Blocks.brick_block});
		}
		if (ConfigHandler.enableNetherBrickWall) {
			safeAddShaped(BlocksP.nether_brick_wall, 7, new Object[] {" # ", "###", "###", '#', Blocks.nether_brick});
		}
		
		if (ConfigHandler.enableQuartzWall) {
			safeAddShaped(BlocksP.quartz_wall, 6, new Object[] {"###", "###", '#', new ItemStack(Blocks.quartz_block, 1, 0)});
			safeAddShaped(BlocksP.quartz_chiseled_wall, 6, new Object[] {"###", "###", '#', new ItemStack(Blocks.quartz_block, 1, 1)});
			safeAddShaped(BlocksP.quartz_pillar_wall, 6, new Object[] {"###", "###", '#', new ItemStack(Blocks.quartz_block, 1, 2)});
		}
		
		// Stairs

		if (ConfigHandler.moreStoneBricksBlocks) {
			removeRecipe(Blocks.stone_brick_stairs);
			safeAddShaped(Blocks.stone_brick_stairs, 4, new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.stonebrick, 1, 0)});
			safeAddShaped(BlocksP.stonebrick_mossy_stairs, 4, new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.stonebrick, 1, 1)});
			safeAddShaped(BlocksP.stonebrick_cracked_stairs, 4, new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.stonebrick, 1, 2)});
			safeAddShaped(BlocksP.stonebrick_chiseled_stairs, 4, new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.stonebrick, 1, 3)});
			removeRecipe(Blocks.stone_slab,5);
			safeAddShaped(Blocks.stone_slab, 6, 5, new Object[] {"###", '#', new ItemStack(Blocks.stonebrick, 1, 0)});
			safeAddShaped(BlocksP.stonebrick_mossy_slab, 6, new Object[] {"###", '#', new ItemStack(Blocks.stonebrick, 1, 1)});
			safeAddShaped(BlocksP.stonebrick_cracked_slab, 6, new Object[] {"###", '#', new ItemStack(Blocks.stonebrick, 1, 2)});
			safeAddShaped(BlocksP.stonebrick_chiseled_slab, 6, new Object[] {"###", '#', new ItemStack(Blocks.stonebrick, 1, 3)});
		}
		
		if (ConfigHandler.moreSandstoneBlocks) {
			removeRecipe(Blocks.sandstone_stairs);
			safeAddShaped(Blocks.sandstone_stairs, 4, new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.sandstone, 1, 0)});
			safeAddShaped(BlocksP.sandstone_chiseled_stairs, 4, new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.sandstone, 1, 1)});
			safeAddShaped(BlocksP.sandstone_smooth_stairs, 4, new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.sandstone, 1, 2)});
			removeRecipe(Blocks.stone_slab,1);
			safeAddShaped(Blocks.stone_slab, 6, 1, new Object[] {"###", '#', new ItemStack(Blocks.sandstone, 1, 0)});
			safeAddShaped(BlocksP.sandstone_chiseled_slab, 6, new Object[] {"###", '#', new ItemStack(Blocks.sandstone, 1, 1)});
			safeAddShaped(BlocksP.sandstone_smooth_slab, 6, new Object[] {"###", '#', new ItemStack(Blocks.sandstone, 1, 2)});
		}

		if (ConfigHandler.moreQuartzBlocks) {
			removeRecipe(Blocks.quartz_stairs);
			safeAddShaped(Blocks.quartz_stairs, 4, new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.quartz_block, 1, 0)});
			safeAddShaped(BlocksP.quartz_chiseled_stairs, 4, new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.quartz_block, 1, 1)});
			safeAddShaped(BlocksP.quartz_pillar_stairs, 4, new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.quartz_block, 1, 2)});
			removeRecipe(Blocks.stone_slab,7);
			safeAddShaped(Blocks.stone_slab, 6, 7, new Object[] {"###", '#', new ItemStack(Blocks.quartz_block, 1, 0)});
			safeAddShaped(BlocksP.quartz_chiseled_slab, 6, new Object[] {"###", '#', new ItemStack(Blocks.quartz_block, 1, 1)});
			safeAddShaped(BlocksP.quartz_pillar_slab, 6, new Object[] {"###", '#', new ItemStack(Blocks.quartz_block, 1, 2)});
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
			safeAddShaped(BlocksP.stone_stairs, 4, new Object[] {"#  ", "## ", "###", '#', Blocks.stone});
		}

		if (ConfigHandler.moreMossyCobblestoneBlocks ) {
			safeAddShaped(BlocksP.cobblestone_mossy_stairs, 4, new Object[] {"#  ", "## ", "###", '#', Blocks.mossy_cobblestone});
			safeAddShaped(BlocksP.cobblestone_mossy_slab, 6, new Object[] {"###", '#', Blocks.mossy_cobblestone});
		}

		// Fences of all wood types
		if (ConfigHandler.enableWoodSpecificFences) {
			safeAddShaped(BlocksP.oak_fence, 3, new Object[] {"I#I", "I#I", '#', new ItemStack(Blocks.planks, 1, 0), 'I', Items.stick});
			safeAddShaped(BlocksP.spruce_fence, 3, new Object[] {"I#I", "I#I", '#', new ItemStack(Blocks.planks, 1, 1), 'I', Items.stick});
			safeAddShaped(BlocksP.birch_fence, 3, new Object[] {"I#I", "I#I", '#', new ItemStack(Blocks.planks, 1, 2), 'I', Items.stick});
			safeAddShaped(BlocksP.jungle_fence, 3, new Object[] {"I#I", "I#I", '#', new ItemStack(Blocks.planks, 1, 3), 'I', Items.stick});
			safeAddShaped(BlocksP.acacia_fence, 3, new Object[] {"I#I", "I#I", '#', new ItemStack(Blocks.planks, 1, 4), 'I', Items.stick});
			safeAddShaped(BlocksP.big_oak_fence, 3, new Object[] {"I#I", "I#I", '#', new ItemStack(Blocks.planks, 1, 5), 'I', Items.stick});
			if (ConfigHandler.replaceVanillaFences) {
				removeRecipe(Blocks.fence);
				GameRegistry.addShapelessRecipe(new ItemStack(BlocksP.birch_fence, 1), Blocks.fence);
			}
		}
		
		// Fence gates of all wood types
		if (ConfigHandler.enableWoodSpecificFenceGates) {
			removeRecipe(Blocks.fence_gate);
			safeAddShaped(BlocksP.oak_fence_gate, 1, new Object[] {"#I#", "#I#", '#', new ItemStack(Blocks.planks, 1, 0), 'I', Items.stick});
			safeAddShaped(BlocksP.spruce_fence_gate, 1, new Object[] {"#I#", "#I#", '#', new ItemStack(Blocks.planks, 1, 1), 'I', Items.stick});
			safeAddShaped(BlocksP.birch_fence_gate, 1, new Object[] {"#I#", "#I#", '#', new ItemStack(Blocks.planks, 1, 2), 'I', Items.stick});
			safeAddShaped(BlocksP.jungle_fence_gate, 1, new Object[] {"#I#", "#I#", '#', new ItemStack(Blocks.planks, 1, 3), 'I', Items.stick});
			safeAddShaped(BlocksP.acacia_fence_gate, 1, new Object[] {"#I#", "#I#", '#', new ItemStack(Blocks.planks, 1, 4), 'I', Items.stick});
			safeAddShaped(BlocksP.big_oak_fence_gate, 1, new Object[] {"#I#", "#I#", '#', new ItemStack(Blocks.planks, 1, 5), 'I', Items.stick});
			GameRegistry.addShapelessRecipe(new ItemStack(BlocksP.birch_fence_gate, 1), Blocks.fence_gate);
		}

		if (ConfigHandler.enableWoodSpecificDoors) {
			int numDoor = 3;
			removeRecipe(Items.wooden_door);
//			safeAddShaped(Items.wooden_door, numDoor, new Object[] {"##", "##", "##", '#', new ItemStack(Blocks.planks, 1, 0)});  // Wood Door from Oak Planks
			safeAddShaped(DoorsP.door_item[0], numDoor, new Object[] {"##", "##", "##", '#', new ItemStack(Blocks.planks, 1, 0)}); // Oak Door from Oak Planks
			safeAddShaped(DoorsP.door_item[1], numDoor, new Object[] {"##", "##", "##", '#', new ItemStack(Blocks.planks, 1, 1)});
			safeAddShaped(DoorsP.door_item[2], numDoor, new Object[] {"##", "##", "##", '#', new ItemStack(Blocks.planks, 1, 2)});
			safeAddShaped(DoorsP.door_item[3], numDoor, new Object[] {"##", "##", "##", '#', new ItemStack(Blocks.planks, 1, 3)});
			safeAddShaped(DoorsP.door_item[4], numDoor, new Object[] {"##", "##", "##", '#', new ItemStack(Blocks.planks, 1, 4)});
			safeAddShaped(DoorsP.door_item[5], numDoor, new Object[] {"##", "##", "##", '#', new ItemStack(Blocks.planks, 1, 5)});
		}
	
		if (ConfigHandler.enableObsidianTools) {
			GameRegistry.addShapedRecipe(new ItemStack(ItemsP.obsidian_sword, 1), new Object[] {"#", "#", "I", '#', Blocks.obsidian, 'I', Items.iron_ingot});
			GameRegistry.addShapedRecipe(new ItemStack(ItemsP.obsidian_axe, 1), new Object[] {"##", "I#", "I ", '#', Blocks.obsidian, 'I', Items.iron_ingot});
			GameRegistry.addShapedRecipe(new ItemStack(ItemsP.obsidian_hoe, 1), new Object[] {"##", "I ", "I ", '#', Blocks.obsidian, 'I', Items.iron_ingot});
			GameRegistry.addShapedRecipe(new ItemStack(ItemsP.obsidian_pickaxe, 1), new Object[] {"###", " I ", " I ", '#', Blocks.obsidian, 'I', Items.iron_ingot});
			GameRegistry.addShapedRecipe(new ItemStack(ItemsP.obsidian_shovel, 1), new Object[] {"#", "I", "I", '#', Blocks.obsidian, 'I', Items.iron_ingot});
		}

		if (ConfigHandler.addMutton) {
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
	

	private static void safeAddShaped(Item item, int num, Object... params) {
		safeAddShaped(item, num, 0, params);
	}

	private static void safeAddShaped(Item item, int num, int meta, Object... params)
	{
		if (item != null) {
			GameRegistry.addShapedRecipe(new ItemStack(item, num, meta), params);
		}
	}

	private static void safeAddShaped(Block block, int num, Object... params) {
		safeAddShaped(block, num, 0, params);
	}
	
	private static void safeAddShaped(Block block, int num, int meta, Object... params)
	{
		if (block != null) {
			GameRegistry.addShapedRecipe(new ItemStack(block, num, meta), params);
		}
	}
}