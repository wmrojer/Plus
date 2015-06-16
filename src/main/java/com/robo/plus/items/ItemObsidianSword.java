package com.robo.plus.items;

import com.robo.plus.info.ModInfo;

import net.minecraft.item.ItemSword;

public class ItemObsidianSword extends ItemSword {

	public ItemObsidianSword(String name, ToolMaterial toolMaterial) {
		super(toolMaterial);
		this.setUnlocalizedName(name);
		this.setTextureName(ModInfo.MODID + ":" + name);
	}

}
