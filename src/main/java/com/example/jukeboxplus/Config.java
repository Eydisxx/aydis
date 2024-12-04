package com.example.jukeboxplus;

import com.example.jukeboxplus.block.ModBlocks;
import com.example.jukeboxplus.item.ModItems;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Diese Klasse dient als zentrale Konfigurationsstelle für die Mod.
 * Hier können serverseitige Events und andere zentrale Funktionen hinzugefügt werden.
 */
@Mod.EventBusSubscriber(modid = JukeboxPlus.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Config {

    /**
     * Dieses Event wird ausgelöst, wenn der Server startet.
     * Hier können serverseitige Initialisierungen durchgeführt werden.
     *
     * @param event Das Server-Start-Event.
     */
    @SubscribeEvent
    public static void onServerStarting(ServerStartingEvent event) {
        System.out.println("Der Server startet mit JukeboxPlus-Mod!");
    }

    /**
     * Beispielmethode für spätere Erweiterungen.
     * Hier können weitere Events hinzugefügt werden.
     */
    public static void registerServerEvents() {
        // Hier könnte man Listener registrieren, z. B. für bestimmte GameEvents.
    }
}
