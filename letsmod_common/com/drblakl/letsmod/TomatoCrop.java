package com.drblakl.letsmod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class TomatoCrop extends GenericBlock {

    public TomatoCrop (int id) {
        super(id, 32, Material.plants);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.5F, 1.0F);
        setTickRandomly(true);
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z){
        return null;
    }
    
    public int getRenderType(){
        return 6; // Magic Number
    }
    
    public boolean isOpaqueCube(){
        return false;
    }
    
    public int getBlockTextureFromSideAndMetadata(int side, int metadata){
        return 32 + metadata;
    }
    
    @Override
    public void updateTick(World world, int x, int y, int z, Random random){
        if(world.getBlockMetadata(x,y,z) == 1){
            return;
        }
        
        if(world.getBlockLightValue(x,y + 1,z) < 9){
            return;
        }
        
        if(random.nextInt(isFertile(world, x, y - 1, z) ? 12 : 25) != 0){
            return;
        }        
        
        //world.setBlockMetadata(x, y, z, 1);
        world.setBlock(x, y, z, 1);
    }
    
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, int neighborId){
        if(!canBlockStay(world, x, y, z)){
            dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x,  y,  z), 0);
            world.setBlock(x,  y,  z,  0);
        }
    }
    
    @Override
    public boolean canBlockStay(World world, int x, int y, int z){
        Block soil = blocksList[world.getBlockId(x,  y - 1,  z)];
        return (world.getFullBlockLightValue(x,  y,  z) >= 8 
                || world.canBlockSeeTheSky(x,  y,  z) 
                && (soil != null && soil.canSustainPlant(world,  x,  y,  z,  ForgeDirection.UP,  LetsMod.tomatoSeeds)));
    }
    
    @Override
    public int idDropped(int metadata, Random random, int par2){
        switch(metadata){
            case 0:
                return LetsMod.tomatoSeeds.itemID;
            case 1:
                return LetsMod.tomatoFruit.itemID;
            default:
                return -1; // no item
        }
    }
    
    @Override
    public int idPicked(World world, int x, int y, int z){
        return LetsMod.tomatoSeeds.itemID;
    }
}
