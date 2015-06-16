package com.robo.plus.config;

import java.util.ArrayList;
import java.util.List;

import com.robo.plus.info.ModInfo;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.config.DummyConfigElement;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import cpw.mods.fml.common.Loader;

public class ConfigGui extends GuiConfig {

	public ConfigGui(GuiScreen gui)
	{
		super(gui,
				getConfigElements(),
				ModInfo.MODID,
				false,
				true,
				GuiConfig.getAbridgedConfigPath(ConfigHandler.config.toString()));
		
	}
	
    /** Compiles a list of config elements */
    @SuppressWarnings("rawtypes")
	private static List<IConfigElement> getConfigElements() {
        List<IConfigElement> list = new ArrayList<IConfigElement>();
      
        //Add categories to config GUI
        list.add(categoryElement(Configuration.CATEGORY_GENERAL, "General", "config.category.general"));
        list.add(categoryElement(ConfigHandler.Category.WALLSFENCES, "Walls'n'Fences", "config.category.wallsfences"));
        list.add(categoryElement(ConfigHandler.Category.STAIRSSLABS, "Stairs'n'Slabs", "config.category.starisslabs"));
        list.add(categoryElement(ConfigHandler.Category.MODCOMP, "Mod Compatibility", "config.category.modcomp"));
        if(Loader.isModLoaded("Thaumcraft")) {
        	list.add(categoryElement(ConfigHandler.Category.THAUMCRAFT, "Thaumcraft", "config.category.thaumcraft"));
        }
      
        return list;
    }
  
    /** Creates a button linking to another screen where all options of the category are available */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private static IConfigElement categoryElement(String category, String name, String tooltip_key) {
        return new DummyConfigElement.DummyCategoryElement(name, tooltip_key,
                new ConfigElement(ConfigHandler.config.getCategory(category)).getChildElements());
    }
	

}
