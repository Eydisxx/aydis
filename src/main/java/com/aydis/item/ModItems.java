package com.aydis.item;

import com.aydis.aydis;
import com.aydis.item.custom.ModFoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister <Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, aydis.MOD_ID);

    //Item dragonfruit
    public static  final RegistryObject<Item> DRAGONFRUIT = ITEMS.register("dragonfruit",
            () -> new Item(new Item.Properties().food(ModFoodProperties.DRAGON_FRUIT)));
    //Item crying bottle
    public static final RegistryObject<Item> CRYING_BOTTLE = ITEMS.register("crying_bottle",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBUS) {
        ITEMS.register(eventBUS);
    }

}