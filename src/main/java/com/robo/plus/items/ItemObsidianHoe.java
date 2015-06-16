package com.robo.plus.items;

import com.robo.plus.info.ModInfo;

import net.minecraft.item.ItemHoe;

public class ItemObsidianHoe extends ItemHoe {

	public ItemObsidianHoe(String name, ToolMaterial toolMaterial) {
		super(toolMaterial);
		this.setUnlocalizedName(name);
		this.setTextureName(ModInfo.MODID + ":" + name);
	}

}
