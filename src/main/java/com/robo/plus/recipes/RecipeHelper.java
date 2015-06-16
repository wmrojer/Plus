package com.robo.plus.recipes;

import java.util.List;

import com.robo.plus.Plus;

import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

public class RecipeHelper {

	@SuppressWarnings("unchecked")
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
