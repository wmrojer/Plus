package com.robo.plus.items;

import com.robo.plus.info.ModInfo;

import net.minecraft.item.ItemPickaxe;

public class ItemObsidianPickaxe extends ItemPickaxe {

	public ItemObsidianPickaxe(String name, ToolMaterial toolMaterial) {
		super(toolMaterial);
		this.setUnlocalizedName(name);
		this.setTextureName(ModInfo.MODID + ":" + name);
	}

}
