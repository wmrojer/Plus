package com.robo.plus.items;

import com.robo.plus.info.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ItemBowP extends ItemBow {
    @SideOnly(Side.CLIENT)
    public IIcon[] iconArray;

    public ItemBowP(String name, int duration)
    {
		this.setUnlocalizedName(name);
		this.setTextureName(ModInfo.MODID + ":" + name);
		this.maxStackSize = 1;
        this.setMaxDamage(duration);
        this.setCreativeTab(CreativeTabs.tabCombat);
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        ArrowNockEvent event = new ArrowNockEvent(p_77659_3_, p_77659_1_);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return event.result;
        }

        if (p_77659_3_.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, p_77659_1_) > 0 || p_77659_3_.inventory.hasItem(Items.arrow))
        {
            p_77659_3_.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
        }

        return p_77659_1_;
    }

	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister p_94581_1_)
    {
        this.itemIcon = p_94581_1_.registerIcon(this.getIconString());
        this.iconArray = new IIcon[3];

        for (int i = 0; i < 3; ++i)
        {
            this.iconArray[i] = p_94581_1_.registerIcon(this.getIconString() + "_" + i);
        }
    }

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon (ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
	    if (usingItem != null)
	    {
	        int time = stack.getMaxItemUseDuration() - useRemaining;
	        if (time < 8)
	            return iconArray[0];
	        if (time < 14)
	            return iconArray[1];
	        return iconArray[2];
	    }
	    return getIcon(stack, renderPass);
	}

	@Override
    @SideOnly(Side.CLIENT)
    public IIcon getItemIconForUseDuration(int p_94599_1_)
    {
        return this.iconArray[p_94599_1_];
    }
   
}
