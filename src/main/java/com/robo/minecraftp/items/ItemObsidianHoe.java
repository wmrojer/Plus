package com.robo.minecraftp.items;

import com.robo.minecraftp.info.ModInfo;

import net.minecraft.item.ItemHoe;

public class ItemObsidianHoe extends ItemHoe {

	public ItemObsidianHoe(String name, ToolMaterial toolMaterial) {
		super(toolMaterial);
		this.setUnlocalizedName(name);
		this.setTextureName(ModInfo.MODID + ":" + name);
	}

}
