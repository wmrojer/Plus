package com.robo.plus.event;

import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import com.robo.plus.config.ConfigHandler;
import com.robo.plus.items.ItemsP;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EntityDropHandler {
	private Random rand;
	
	public EntityDropHandler()
	{
		rand = new Random();
	}

	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onLivingDropsEvent(LivingDropsEvent event) {
	    if (event.entity instanceof EntitySheep) {
	    	if (ConfigHandler.addMuttonToSheep) {
		        int num = rand.nextInt(3) + 1 + rand.nextInt(1 + event.lootingLevel);
		        ItemStack itemStackToDrop = new ItemStack(event.entity.isBurning() ? ItemsP.mutton_cooked : ItemsP.mutton_raw, 1);
		        for (int i = 0; i < num; i++ ) {
		        	event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, itemStackToDrop));
		        }
	    	}
	    	if (ConfigHandler.addLeatherToSheep) {
		        int num = rand.nextInt(3) + rand.nextInt(1 + event.lootingLevel / 2);
		        ItemStack itemStackToDrop = new ItemStack(Items.leather, 1);
		        for (int i = 0; i < num; i++ ) {
		        	event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, itemStackToDrop));
		        }
	    	}
	    }
	    if (event.entity instanceof EntityPig) {
	    	if (ConfigHandler.addLeatherToPig) {
		        int num = rand.nextInt(3) + rand.nextInt(1 + event.lootingLevel / 2);
		        ItemStack itemStackToDrop = new ItemStack(Items.leather, 1);
		        for (int i = 0; i < num; i++ ) {
		        	event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, itemStackToDrop));
		        }
	    	}
		}
	    if (event.entity instanceof EntityCow) {
	    	if (ConfigHandler.addMoreLeatherToCow) {
	        	event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, new ItemStack(Items.leather, 1)));
	    	}
		}
	} 
	
}
