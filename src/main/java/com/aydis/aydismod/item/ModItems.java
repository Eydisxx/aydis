package com.aydis.aydismod.item;


import com.aydis.aydismod.aydis;
import com.aydis.aydismod.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.aydis.aydismod.item.custom.ModFoodProperties;
import net.minecraft.world.item.*;


import static com.aydis.aydismod.potion.ModPotions.POTIONS;

public class ModItems {
    public static final DeferredRegister <Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, aydis.MOD_ID);

    //Item dragonfruit
    public static  final RegistryObject<Item> DRAGONFRUIT = ITEMS.register("dragonfruit",
            () -> new Item(new Item.Properties().food(ModFoodProperties.DRAGON_FRUIT)));
    //Item crying bottle




    public static void register(IEventBus eventBUS) {
        ITEMS.register(eventBUS);
    }

}