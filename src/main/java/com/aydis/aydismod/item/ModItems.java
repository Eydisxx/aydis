package com.aydis.aydismod.item;

import com.aydis.aydis;
import com.aydis.aydismod.event.InfinitePowder;
import net.minecraft.world.item.*;
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
            () -> new PotionItem(new Item.Properties().stacksTo(1).craftRemainder(Items.GLASS_BOTTLE))); // Add other properties as needed

    // Item Everbloom Powder
    public static final RegistryObject<Item> EVERBLOOM_POWDER = ITEMS.register("everbloom_powder",
            () -> new InfinitePowder(new Item.Properties()));






    public static void register(IEventBus eventBUS) {
        ITEMS.register(eventBUS);
    }
}
