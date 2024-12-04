package com.example.jukeboxplus.item;

import com.example.jukeboxplus.JukeboxPlus;
import com.example.jukeboxplus.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, JukeboxPlus.MODID);

    public static final RegistryObject<Item> JUKEBOX_PLUS = ITEMS.register("jukebox_plus",
            () -> new BlockItem(ModBlocks.JUKEBOX_PLUS.get(), new Item.Properties()));

    // Zusätzliche Items können hier registriert werden
}
