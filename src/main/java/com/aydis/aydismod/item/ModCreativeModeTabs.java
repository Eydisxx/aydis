package com.aydis.aydismod.item;

import com.aydis.aydismod.aydis;
import com.aydis.aydismod.potion.ModPotions;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, aydis.MOD_ID);

    public static final RegistryObject<CreativeModeTab> COURSE_TAB = CREATIVE_MODE_TABS.register("course_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> {
                        // Create an ItemStack with the Crying Potion
                        ItemStack cryingPotion = new ItemStack(Items.POTION);
                        cryingPotion.getOrCreateTag().putString("Potion", ModPotions.CRYING_BOTTLE.getId().toString());
                        return cryingPotion;
                    })

                    .title(Component.translatable("creativetab.course_tab"))
                    .displayItems((displayParameters, output) -> {
                        // Add the Crying Potion to the Creative Tab
                        ItemStack cryingPotion = new ItemStack(Items.POTION);
                        cryingPotion.getOrCreateTag().putString("Potion", ModPotions.CRYING_BOTTLE.getId().toString());
                        output.accept(cryingPotion);

                        // Uncomment to add blocks or other items to the tab
                        // output.accept(ModBlocks.PURPURONYXSTONE_STAIRS.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
