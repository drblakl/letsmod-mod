package com.drblakl.letsmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.MinecraftForge;

import com.drblakl.letsmod.lib.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid=Reference.MOD_ID , name=Reference.MOD_NAME, version=Reference.VERSION)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class LetsMod {

    @Instance("LetsMod")
    public static LetsMod instance;

    /*
     * Item Creation
     * 
     */
    // Base GenericItem
    private final static Item genericItem = new GenericItem(5000);
    int MyItemID = genericItem.itemID;
    
    // Using initial constructor
    public final static Item genericIngot = new GenericItem(5001).setMaxStackSize(16).setUnlocalizedName("genericIngot");
    
    public final static Block genericDirt = new GenericBlock(500, Material.ground).
            setHardness(0.5F).
            setStepSound(Block.soundGravelFootstep).
            setUnlocalizedName("genericDirt").
            setCreativeTab(CreativeTabs.tabBlock);
    
    public final static Block genericOre = new GenericOre(501, Material.rock);
    
    // Tutorial: http://www.minecraftforge.net/wiki/Metadata_Based_Subblocks
    public static final int multiBlockId = 502;
    public static final Block multiBlock = new MultiBlock(multiBlockId);
    
    private static final String[] multiBlockNames = { 
        "White Block", "Orange Block", "Magenta Block", "Light Blue Block",
        "Yellow Block", "Light Green Block", "Pink Block", "Dark Grey Block",
        "Light Grey Block", "Cyan Block", "Purple Block", "Blue Block",
        "Brown Block", "Green Block", "Red Block", "Black Block"
    };    
    
    
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="com.drblakl.letsmod.client.ClientProxy", serverSide="com.drblakl.letsmod.CommonProxy")
    public static CommonProxy proxy;
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event){
        /*
         * PreInit is before turning on
         */
    }
    
    @Init
    public void init(FMLInitializationEvent event){
        /*
         * Init is when turning on
         */
        
        /*
         * Start Tutorial: 
         * 
         * http://www.minecraftforge.net/wiki/Crafting_and_Smelting#Shaped_Crafting
         */
        
        ItemStack dirtStack = new ItemStack(Block.dirt);
        ItemStack diamondsStack = new ItemStack(Item.diamond, 64);
        ItemStack gravelStack = new ItemStack(Block.gravel);
        ItemStack cobbleStack = new ItemStack(Block.cobblestone);
        
        GameRegistry.addShapelessRecipe(diamondsStack, dirtStack);
        
        GameRegistry.addShapelessRecipe(diamondsStack, dirtStack, dirtStack, dirtStack, dirtStack, dirtStack, dirtStack, new ItemStack(Block.sand), gravelStack, cobbleStack);
        
        // 2 x 2
        /*
         * Dirt goes in x
         * Gravel goes in y
         * 
         * xy
         * yx
         * 
         * [Dirt  ][Gravel]
         * [Gravel][Dirt  ]
         */
        GameRegistry.addRecipe(new ItemStack(Block.cobblestone), "xy", "yx", 'x', dirtStack, 'y', gravelStack);
        
        // 3 x 3
        /*
         * Dirt goes in x
         * Gravel goes in y
         * 
         * xyx
         * y y
         * xyx
         * 
         * [Dirt  ][Gravel][Dirt  ]
         * [Gravel][Empty ][Gravel]
         * [Dirt  ][Gravel][Dirt  ]
         */
        GameRegistry.addRecipe(new ItemStack(Block.stone), "xyx", "y y", "xyx", 'x', dirtStack, 'y', gravelStack);
        
        // 3 x 3
        /*
         * Testing output
         * 
         * Dirt goes in x
         * Gravel goes in y
         * 
         * xyx
         * x x
         * xyx
         * 
         * [Dirt  ][Gravel][Dirt  ]
         * [Dirt  ][Empty ][Dirt  ]
         * [Dirt  ][Gravel][Dirt  ]
         */
        GameRegistry.addRecipe(new ItemStack(Item.eyeOfEnder), "xyx", "x x", "xyx", 'x', dirtStack, 'y', gravelStack);
        
        // stone brick created from stone block
        GameRegistry.addSmelting(Block.stone.blockID, new ItemStack(Block.stoneBrick), 0.1f);
        
        // burning black wool to get white wool
        FurnaceRecipes.smelting().addSmelting(Block.cloth.blockID, 15, new ItemStack(Block.cloth, 1, 0), 0.1f);
        
        /*
         * End Tutorial: 
         * 
         * http://www.minecraftforge.net/wiki/Crafting_and_Smelting#Shaped_Crafting
         */        
        
        
        /*
         * Start Tutorial: 
         * 
         * http://www.minecraftforge.net/wiki/Basic_Items
         */        
        
        // Can also be done in PreInit()
        LanguageRegistry.addName(genericItem, "Genric Item");
        LanguageRegistry.addName(genericIngot, "Generic Ingot");
        
        /*
         * End Tutorial: 
         * 
         * http://www.minecraftforge.net/wiki/Basic_Items
         */
        
        /*
         * Start Tutorial:
         * 
         * http://www.minecraftforge.net/wiki/Basic_Blocks
         */
        
        /*
         * Dirt
         */
        GameRegistry.registerBlock(genericDirt, "genericDirt");
        LanguageRegistry.addName(genericDirt, "Generic Dirt");
        MinecraftForge.setBlockHarvestLevel(genericDirt, "shovel", 0);
        
        
        /*
         * Ore
         */
        GameRegistry.registerBlock(genericOre, "genericOre");
        LanguageRegistry.addName(genericOre, "Generic Ore");
        MinecraftForge.setBlockHarvestLevel(genericOre, "pickaxe",  3);
        
        /*
         * End Tutorial:
         * 
         * http://www.minecraftforge.net/wiki/Basic_Blocks
         */     
        
        // Added in smelting for Generic Ingot
        FurnaceRecipes.smelting().addSmelting(genericOre.blockID, new ItemStack(genericIngot, 1), 0.1f);    
        
        proxy.registerRenderers();
        
        /*
         * Start Tutorial:
         * 
         * http://www.minecraftforge.net/wiki/Metadata_Based_Subblocks
         */
        
        GameRegistry.registerBlock(multiBlock, MultiItemBlock.class);
        
        for (int ix = 0; ix < 16; ix++) {
            ItemStack cloth = new ItemStack(Block.cloth, 1, ix);
            ItemStack multiBlockStack = new ItemStack(multiBlock, 1, ix);
            
            GameRegistry.addShapelessRecipe(multiBlockStack, cloth, cloth);
            LanguageRegistry.addName(multiBlockStack, multiBlockNames[multiBlockStack.getItemDamage()]);
        }
        
        /*
         * End Tutorial:
         * 
         * http://www.minecraftforge.net/wiki/Metadata_Based_Subblocks
         */        
    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event){
        /*
         * PostInit is after all of the mods have been loaded
         * 
         * Good to interact with other mods
         */       
        
    }
    
}


