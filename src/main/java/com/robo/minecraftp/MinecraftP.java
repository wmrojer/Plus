package com.robo.minecraftp;

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
import cpw.mods.fml.common.event.FMLServerStartingEvent;

import com.robo.minecraftp.plugins.ThaumcraftPlugin;
import com.robo.minecraftp.proxies.CommonProxy;
import com.robo.minecraftp.recipes.RecipeHandler;
import com.robo.minecraftp.blocks.BlocksP;
import com.robo.minecraftp.config.ConfigHandler;
import com.robo.minecraftp.doors.DoorsP;
import com.robo.minecraftp.event.SheepDropHandler;
import com.robo.minecraftp.info.ModInfo;
import com.robo.minecraftp.items.ItemsP;

@Mod(name = ModInfo.NAME, modid = ModInfo.MODID, version = ModInfo.VERSION, guiFactory = ModInfo.GUI_FACTORY_CLASS, dependencies=ModInfo.DEPENDENCY)
public class MinecraftP 
{
    @SidedProxy(clientSide = ModInfo.CLIENT_PROXY_CLASS, serverSide = ModInfo.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static Logger log = LogManager.getLogger(ModInfo.MODID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	ConfigHandler.init(event.getSuggestedConfigurationFile());
    	FMLCommonHandler.instance().bus().register(new ConfigHandler());
    	BlocksP.registerBlocks();
    	ItemsP.registerItems();
    	DoorsP.registerDoors();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	RecipeHandler.registerRecipes();
    	if (ConfigHandler.addMutton) {
    		MinecraftForge.EVENT_BUS.register(new SheepDropHandler());
    	}
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        ThaumcraftPlugin.register();
    }
    
    @EventHandler
    public static void serverLoad(FMLServerStartingEvent event)
    {
    	
    }
}
