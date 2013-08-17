package com.drblakl.letsmod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class GenericOre extends Block {

    public GenericOre(int oreID, Material material) {
        super(oreID, material);
        setHardness(4.0F);
        setStepSound(Block.soundStoneFootstep);
        setUnlocalizedName("genericOre");
        setCreativeTab(CreativeTabs.tabBlock);
    }
    
    public int idDropped(int par1, Random random, int zero){
        return LetsMod.genericIngot.itemID;
    }
}
