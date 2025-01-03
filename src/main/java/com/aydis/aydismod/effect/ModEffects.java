package com.aydis.aydismod.effect;

import com.aydis.aydismod.aydis;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, aydis.MOD_ID);

    public static final RegistryObject<MobEffect> SUPPRESSED_EFFECT = MOB_EFFECTS.register("suppressed",
            () -> new SuppressedEffect(MobEffectCategory.HARMFUL, 0x36ebac)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED,
                            "7107DE5E-7CE8-4030-940E-514C1F160890", -0.50f, AttributeModifier.Operation.MULTIPLY_TOTAL)

    );

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}