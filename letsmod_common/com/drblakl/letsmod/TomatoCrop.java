package com.drblakl.letsmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TomatoCrop extends GenericBlock {

    public TomatoCrop (int id) {
        super(id, 32, Material.plants);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.5F, 1.0F);
        setTickRandomly(true);
    }


}
