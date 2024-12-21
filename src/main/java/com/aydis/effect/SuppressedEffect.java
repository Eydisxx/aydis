package com.aydis.effect;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class SuppressedEffect extends MobEffect {
    public SuppressedEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        // Füge den Darkness-Effekt hinzu
        if (!entity.level().isClientSide()) {
            entity.addEffect(new net.minecraft.world.effect.MobEffectInstance(MobEffects.DARKNESS,
                    200, 0, false, false));
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        // Hier definierst du, wie oft der Effekt ausgelöst wird
        return duration % 20 == 0; // Alle 20 Ticks (1 Sekunde)
    }
}