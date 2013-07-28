package com.cdspacedash.letsmod;

import com.cdspacedash.letsmod.lib.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=Reference.MOD_ID , name=Reference.MOD_NAME, version=Reference.VERSION)

public class LetsMod {

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


