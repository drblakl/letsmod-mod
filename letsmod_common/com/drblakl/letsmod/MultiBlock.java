package com.drblakl.letsmod;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.block.material.Material;

public class MultiBlock extends Block {
    public MultiBlock (int id) {
        super(id, Material.ground);
        setUnlocalizedName("multiBlock");
        setCreativeTab(CreativeTabs.tabBlock);
    }
    
    public int getBlockTextureFromSideAndMetadata (int side, int metadata) {
        return 16 + metadata;
    }
    
    public String getTextureFile () {
        return CommonProxy.BLOCK_PNG;
    }
    
    @Override
    public int damageDropped (int metadata) {
        return metadata;
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1, CreativeTabs tab, List subItems) {
        for (int ix = 0; ix < 16; ix++) {
            subItems.add(new ItemStack(this, 1, ix));
        }
    }
}