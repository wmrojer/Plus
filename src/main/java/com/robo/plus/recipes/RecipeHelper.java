package com.robo.plus.recipes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.robo.plus.Plus;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

@SuppressWarnings("unchecked")
public class RecipeHelper {


	public static List<IRecipe> removeRecipes(Block block) {
		return removeRecipes(Item.getItemFromBlock(block));
	}
	public static List<IRecipe> removeRecipes(Item item) {
		List<IRecipe> removedRecipes = new ArrayList<IRecipe>();
		Iterator<IRecipe> recipeItr = CraftingManager.getInstance().getRecipeList().iterator();
		while (recipeItr.hasNext()) {
			IRecipe recipe = recipeItr.next();
			ItemStack itemStack = recipe.getRecipeOutput();
			if (itemStack != null && itemStack.getItem() == item) {
				recipeItr.remove();
				removedRecipes.add(recipe);
			}
		}
		return removedRecipes;
	}
	
	public static List<IRecipe> removeRecipes(Block block, int metadata) {
		return removeRecipes(Item.getItemFromBlock(block), metadata);
	}
	public static List<IRecipe> removeRecipes(Item item, int metadata) {
		List<IRecipe> removedRecipes = new ArrayList<IRecipe>();
		Iterator<IRecipe> recipeItr = CraftingManager.getInstance().getRecipeList().iterator();
		while (recipeItr.hasNext()) {
			IRecipe recipe = recipeItr.next();
			ItemStack itemStack = recipe.getRecipeOutput();
			if (itemStack != null && itemStack.getItem() == item && itemStack.getItemDamage() == metadata) {
				recipeItr.remove();
				removedRecipes.add(recipe);
			}
		}
		return removedRecipes;
	}

	
	public static void addRecipes(List<IRecipe> recipes) {
		Iterator<IRecipe> recipeItr = recipes.iterator();
		while (recipeItr.hasNext()) {
			GameRegistry.addRecipe(recipeItr.next());
		}
	}
	
	public static void moveRecipeToTop(IRecipe recipe) {
		List<IRecipe> recipeList = CraftingManager.getInstance().getRecipeList();
		recipeList.remove(recipe);
		recipeList.add(0, recipe);
	}

	
	public static void dumpRecipes() {
		List<IRecipe> rl = CraftingManager.getInstance().getRecipeList();
		for (int i = 0; i < rl.size(); i++) {
			try {
				IRecipe recipe = rl.get(i);
				Plus.log.info(String.format("%-4d Recipe:%-32s Class:%s ", i, recipe.getRecipeOutput().getDisplayName(), recipe.getClass().getName()));
			} catch(Exception e) {
				Plus.log.info(String.format("%-4d ",i));
			}
		}
	}
		
}
