package com.drblakl.letsmod;

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

@Mod(modid=Reference.MOD_ID , name=Reference.MOD_NAME, version=Reference.VERSION)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class LetsMod {

    @Instance("LetsMod")
    public static LetsMod instance;
    
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


