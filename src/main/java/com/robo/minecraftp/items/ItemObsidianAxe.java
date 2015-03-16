package com.robo.minecraftp.items;

import com.robo.minecraftp.info.ModInfo;

import net.minecraft.item.ItemAxe;

public class ItemObsidianAxe extends ItemAxe {

	public ItemObsidianAxe(String name, ToolMaterial toolMaterial) {
		super(toolMaterial);
		this.setUnlocalizedName(name);
		this.setTextureName(ModInfo.MODID + ":" + name);
	}

}
