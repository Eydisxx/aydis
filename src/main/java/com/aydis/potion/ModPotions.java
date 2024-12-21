package com.aydis.potion;

import com.aydis.aydis;

import com.aydis.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, aydis.MOD_ID);

    public static final RegistryObject<Potion> CRYING_POTION = POTIONS.register("crying_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.SUPPRESSED_EFFECT.get(), 200, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}