package com.robo.plus;

import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import com.robo.plus.blocks.BlocksP;
import com.robo.plus.config.ConfigHandler;
import com.robo.plus.doors.DoorsP;
import com.robo.plus.event.EntityDropHandler;
import com.robo.plus.event.PlayerEnterWorld;
import com.robo.plus.info.ModInfo;
import com.robo.plus.items.ItemsP;
import com.robo.plus.plugins.ThaumcraftPlugin;
import com.robo.plus.proxies.CommonProxy;
import com.robo.plus.recipes.RecipeHandler;

@Mod(name = ModInfo.NAME, modid = ModInfo.MODID, version = ModInfo.VERSION, guiFactory = ModInfo.GUI_FACTORY_CLASS, dependencies=ModInfo.DEPENDENCY)
public class Plus 
{
    @SidedProxy(clientSide = ModInfo.CLIENT_PROXY_CLASS, serverSide = ModInfo.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static Logger log = LogManager.getLogger(ModInfo.MODID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	ConfigHandler.init(event.getSuggestedConfigurationFile());
    	FMLCommonHandler.instance().bus().register(new ConfigHandler());
//    	BlocksP.registerBlocks();
//    	ItemsP.registerItems();
    	DoorsP.registerDoors();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	BlocksP.registerBlocks();
    	ItemsP.registerItems();
    	RecipeHandler.registerRecipes();
    	if (ConfigHandler.addMuttonToSheep || ConfigHandler.addLeatherToSheep || ConfigHandler.addLeatherToPig || ConfigHandler.addMoreLeatherToCow) {
    		MinecraftForge.EVENT_BUS.register(new EntityDropHandler());
    	}
    	MinecraftForge.EVENT_BUS.register(new PlayerEnterWorld());
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        ThaumcraftPlugin.register();
    }
    
}
