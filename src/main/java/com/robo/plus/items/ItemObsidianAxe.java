package com.robo.plus.items;

import com.robo.plus.info.ModInfo;

import net.minecraft.item.ItemAxe;

public class ItemObsidianAxe extends ItemAxe {

	public ItemObsidianAxe(String name, ToolMaterial toolMaterial) {
		super(toolMaterial);
		this.setUnlocalizedName(name);
		this.setTextureName(ModInfo.MODID + ":" + name);
	}

}
