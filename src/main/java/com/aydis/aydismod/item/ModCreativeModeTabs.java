package com.aydis.aydismod.item;

import com.aydis.aydismod.aydis;
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
                        // Verwende das bereits registrierte Crying Bottle Item
                        return new ItemStack(ModItems.CRYING_BOTTLE.get());
                    })
                    .title(Component.translatable("creativetab.course_tab"))
                    .displayItems((displayParameters, output) -> {
                        // Füge das Crying Bottle Item dem Creative Tab hinzu
                        output.accept(ModItems.CRYING_BOTTLE.get());

                        // Füge hier ggf. weitere Items oder Blöcke hinzu
                        // output.accept(ModBlocks.PURPURONYXSTONE_STAIRS.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
