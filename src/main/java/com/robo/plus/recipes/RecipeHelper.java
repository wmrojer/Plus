package com.robo.plus.recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.robo.plus.Plus;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
//		Iterator<IRecipe> itr = CraftingManager.getInstance().getRecipeList().iterator();
//		while (itr.hasNext()) {
//			try {
//				IRecipe recipe = (IRecipe)itr.next();
//				Plus.log.info("Recipe : " + recipe.getRecipeOutput().getDisplayName() +" class : " +recipe.getClass().getName());
//			} catch(Exception e) {}
//		}
	}
	
    @SuppressWarnings("unchecked")
	public static ShapedRecipesP addRecipe(ItemStack p_92103_1_, Object ... p_92103_2_)
    {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (p_92103_2_[i] instanceof String[])
        {
            String[] astring = (String[])((String[])p_92103_2_[i++]);

            for (int l = 0; l < astring.length; ++l)
            {
                String s1 = astring[l];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }
        else
        {
            while (p_92103_2_[i] instanceof String)
            {
                String s2 = (String)p_92103_2_[i++];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }

        HashMap hashmap;

        for (hashmap = new HashMap(); i < p_92103_2_.length; i += 2)
        {
            Character character = (Character)p_92103_2_[i];
            ItemStack itemstack1 = null;

            if (p_92103_2_[i + 1] instanceof Item)
            {
                itemstack1 = new ItemStack((Item)p_92103_2_[i + 1]);
            }
            else if (p_92103_2_[i + 1] instanceof Block)
            {
                itemstack1 = new ItemStack((Block)p_92103_2_[i + 1], 1, 32767);
            }
            else if (p_92103_2_[i + 1] instanceof ItemStack)
            {
                itemstack1 = (ItemStack)p_92103_2_[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1)
        {
            char c0 = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c0)))
            {
                aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();
            }
            else
            {
                aitemstack[i1] = null;
            }
        }

        ShapedRecipesP shapedrecipes = new ShapedRecipesP(j, k, aitemstack, p_92103_1_);
        CraftingManager.getInstance().getRecipeList().add(shapedrecipes);
        return shapedrecipes;
    }
	
}
