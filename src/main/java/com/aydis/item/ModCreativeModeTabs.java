package com.aydis.item;

import com.aydis.aydis;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

//Creative TAB
public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, aydis.MOD_ID);
    //Creative TAB ITEM DISPLAY
    public static final RegistryObject<CreativeModeTab> COURSE_TAB = CREATIVE_MODE_TABS.register("course_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CRYING_BOTTLE.get()))
                    .title(Component.translatable("creativetab.course_tab"))
                    .displayItems((displayParameters, output) -> {
                       // output.accept(ModItems.PURPURONYXSTONE_PICKAXE.get());
                        //output.accept(ModBlocks.PURPURONYXSTONE_STAIRS.get());
                    }).build());

    public static void register(IEventBus eventBus){

        CREATIVE_MODE_TABS.register(eventBus);
    }
}