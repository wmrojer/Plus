package com.robo.plus.items;

import com.robo.plus.info.ModInfo;

import net.minecraft.item.ItemSpade;

public class ItemObsidianShovel extends ItemSpade {

	public ItemObsidianShovel(String name, ToolMaterial toolMaterial) {
		super(toolMaterial);
		this.setUnlocalizedName(name);
		this.setTextureName(ModInfo.MODID + ":" + name);
	}

}
