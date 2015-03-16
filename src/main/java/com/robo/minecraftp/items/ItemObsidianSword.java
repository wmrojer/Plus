package com.robo.minecraftp.items;

import com.robo.minecraftp.info.ModInfo;

import net.minecraft.item.ItemSword;

public class ItemObsidianSword extends ItemSword {

	public ItemObsidianSword(String name, ToolMaterial toolMaterial) {
		super(toolMaterial);
		this.setUnlocalizedName(name);
		this.setTextureName(ModInfo.MODID + ":" + name);
	}

}
