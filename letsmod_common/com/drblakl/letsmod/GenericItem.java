package com.drblakl.letsmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GenericItem extends Item {
       
    public GenericItem(int itemID) {
        super(itemID);
        setMaxStackSize(64);
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("genericItem");
    }
    
    public GenericItem(int itemID, int maxStackSize, CreativeTabs tab, int texture, String name){
        super(itemID);
        setMaxStackSize(maxStackSize);
        setCreativeTab(tab);
        setUnlocalizedName(name);
    }
    
    // Registers Icon to the Mod
    /*
     * Only use if you want all created items including ingots to have same icon
     */
    /*
    public void registerIcons(IconRegister par1iconregister){
        this.itemIcon = par1iconregister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "genericItem");
    }
    */
}
