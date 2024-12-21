package com.aydis;

import com.aydis.effect.ModEffects;
import com.aydis.potion.BetterBrewingRecipe;
import com.aydis.potion.ModPotions;
import com.mojang.logging.LogUtils;
import com.aydis.item.ModCreativeModeTabs;
import com.aydis.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(aydis.MOD_ID)
public class  aydis
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "aydis";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public aydis()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        //ModBlocks.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        ModPotions.register(modEventBus);
        ModEffects.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD, Items.CRYING_OBSIDIAN,ModPotions.CRYING_POTION.get()));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            //Item 1
            //event.accept(ModItems.PURPURONYXSTONE);
        }
        if(event.getTabKey()== CreativeModeTabs.BUILDING_BLOCKS) {
            //Block 1
            //event.accept(ModBlocks.PURPURONYXSTONEBLOCK);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }
    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}