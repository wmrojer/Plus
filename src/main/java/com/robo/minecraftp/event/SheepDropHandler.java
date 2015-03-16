package com.robo.minecraftp.event;

import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import com.robo.minecraftp.MinecraftP;
import com.robo.minecraftp.items.ItemsP;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SheepDropHandler {
	private Random rand;
	
	public SheepDropHandler()
	{
		rand = new Random();
	}

	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onLivingDropsEvent(LivingDropsEvent event)
	{
	    if (event.entity instanceof EntitySheep)
	    {
	        int num = rand.nextInt(3) + 1 + rand.nextInt(1 + event.lootingLevel);
	        ItemStack itemStackToDrop = new ItemStack(event.entity.isBurning() ? ItemsP.mutton_cooked : ItemsP.mutton_raw, 1);
	        MinecraftP.log.debug("Adding " + num + " " + itemStackToDrop.getDisplayName() + " drop to EntitySheep" );
	        for (int i = 0; i < num; i++ )
	        {
	        	event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, itemStackToDrop));
	        }
	    }
	} 
	
}
