package com.aydis.aydismod.potion;

import com.aydis.aydismod.aydis;
import com.aydis.aydismod.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, aydis.MOD_ID);

    public static final RegistryObject<Potion> CRYING_BOTTLE = POTIONS.register("crying_bottle",
            () -> new Potion(new MobEffectInstance(ModEffects.SUPPRESSED_EFFECT.get(), 600, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
