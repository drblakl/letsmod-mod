package com.drblakl.letsmod;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.stats.StatBase;

public class AchievementLib {
    private void addAchievementName(String ach, String name)
    {
            LanguageRegistry.instance().addStringLocalization("achievement." + ach, "en_US", name);
    }

    private void addAchievementDesc(String ach, String desc)
    {
            LanguageRegistry.instance().addStringLocalization("achievement." + ach + ".desc", "en_US", desc);
    }
}
