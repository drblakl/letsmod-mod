package com.drblakl.letsmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class MultiBlock extends Block {

    
    public MultiBlock(int id) {
        super(id, Material.ground);
        setUnlocalizedName("multiBlock");
        setCreativeTab(CreativeTabs.tabBlock);        
    }

    @Override
    public int damageDropped(int metadata){
        return metadata;
    }
    
}
