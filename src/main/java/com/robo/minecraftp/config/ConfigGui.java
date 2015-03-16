package com.robo.minecraftp.config;

import com.robo.minecraftp.info.ModInfo;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.config.GuiConfig;

public class ConfigGui extends GuiConfig {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ConfigGui(GuiScreen gui)
	{
		super(gui,
				new ConfigElement(ConfigHandler.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
				ModInfo.MODID,
				false,
				true,
				GuiConfig.getAbridgedConfigPath(ConfigHandler.config.toString()));
		
	}

}
