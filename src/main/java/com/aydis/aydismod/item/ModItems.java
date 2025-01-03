package com.aydis.aydismod.item;

import com.aydis.aydismod.aydis;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.aydis.aydismod.item.custom.ModFoodProperties;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, aydis.MOD_ID);

    // Item dragonfruit
    public static final RegistryObject<Item> DRAGONFRUIT = ITEMS.register("dragonfruit",
            () -> new Item(new Item.Properties().food(ModFoodProperties.DRAGON_FRUIT)));

    // Item crying bottle (Potion Item)
    public static final RegistryObject<Item> CRYING_BOTTLE = ITEMS.register("crying_bottle",
            () -> new Item(new Item.Properties()) {
                @Override
                public InteractionResult useOn(UseOnContext context) {
                    // Get Darkness-Effect
                    if (!context.getLevel().isClientSide()) {
                        context.getPlayer().addEffect(new MobEffectInstance(MobEffects.DARKNESS, 400, 3));
                    }
                    return InteractionResult.sidedSuccess(context.getLevel().isClientSide());
                }
            });

    public static void register(IEventBus eventBUS) {
        ITEMS.register(eventBUS);
    }
}
