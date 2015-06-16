package com.robo.plus.event;

import com.robo.plus.config.ConfigHandler;
import com.robo.plus.recipes.RecipeHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PlayerEnterWorld {

	private static boolean done = false;
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
    public void joinEvent(EntityJoinWorldEvent e){
		if (ConfigHandler.dumpRecipes && !done) {
			if(!e.world.isRemote){
				if(e.entity instanceof EntityPlayer){
					EntityPlayer player = (EntityPlayer)e.entity;
					if(player.getDisplayName() != null){
						done = true;
						RecipeHelper.dumpRecipes();
					}
				}
			}
		}
	}
	
}
