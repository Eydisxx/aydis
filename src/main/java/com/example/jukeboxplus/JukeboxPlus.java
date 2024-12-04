package com.example.jukeboxplus;

import com.example.jukeboxplus.block.ModBlocks;
import com.example.jukeboxplus.item.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * Hauptklasse der Mod "JukeboxPlus".
 * Hier werden alle grundlegenden Registrierungen und Events initialisiert.
 */
@Mod(JukeboxPlus.MODID)
public class JukeboxPlus {
    // Die Mod-ID für die Identifikation im Spiel und bei Forge.
    public static final String MODID = "jukeboxplus";

    /**
     * Konstruktor der Mod. Hier wird der Event-Bus initialisiert
     * und alle wichtigen Registrierungsaufrufe durchgeführt.
     */
    public JukeboxPlus() {
        // Event-Bus für Mod-spezifische Events
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Registriere Blöcke und Items
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);

        // Event-Listener für verschiedene Lebenszyklen hinzufügen
        modEventBus.addListener(this::setupCommon);
        modEventBus.addListener(this::setupClient);
    }

    /**
     * Setup-Methode für serverseitige Logik.
     * Wird während der Initialisierungsphase aufgerufen.
     *
     * @param event Das Common-Setup-Event.
     */
    private void setupCommon(FMLCommonSetupEvent event) {
        System.out.println("JukeboxPlus wird serverseitig initialisiert!");
        // Allgemeine Registrierungen oder Konfigurationen
    }

    /**
     * Setup-Methode für clientseitige Logik.
     * Wird während der Initialisierungsphase aufgerufen.
     *
     * @param event Das Client-Setup-Event.
     */
    private void setupClient(FMLClientSetupEvent event) {
        System.out.println("JukeboxPlus wird clientseitig initialisiert!");
        // Client-spezifische Konfigurationen, wie Render-Registrierungen
    }
}
