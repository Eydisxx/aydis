package com.example.jukeboxplus.block;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;

import java.util.ArrayList;
import java.util.List;

public class JukeboxPlusBlock extends Block {
    // Liste zur Speicherung der Schallplatten
    private final List<ItemStack> records = new ArrayList<>();

    public JukeboxPlusBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldItem = player.getItemInHand(hand);

        // Prüfen, ob der Spieler eine Schallplatte hält
        if (heldItem.getItem() instanceof RecordItem) {
            if (records.size() < 5) { // Begrenzung auf z.B. 5 Schallplatten
                records.add(heldItem.copy());
                heldItem.shrink(1); // Eine Schallplatte vom Stack entfernen
                player.displayClientMessage(Component.literal("Schallplatte hinzugefügt!"), true);

                return InteractionResult.SUCCESS;
            } else {
                player.displayClientMessage(Component.literal("Die Jukebox ist voll!"), true);

                return InteractionResult.FAIL;
            }
        } else {
            // Öffnen der GUI für die Jukebox (GUI später implementieren)
            if (!level.isClientSide) {
                if (player instanceof ServerPlayer) {
                    NetworkHooks.openScreen((ServerPlayer) player, this.getMenuProvider(state, level, pos), pos);
                }

            }
            return InteractionResult.SUCCESS;
        }
    }

    // Methode zum Abspielen der Schallplatten
    public void playNextRecord(Level level, BlockPos pos) {
        if (!records.isEmpty()) {
            ItemStack record = records.remove(0);
            // Hier könnte man die Logik für das Abspielen einer Schallplatte hinzufügen
            level.playSound(null, pos, ((RecordItem) record.getItem()).getSound(), net.minecraft.sounds.SoundSource.RECORDS, 1.0F, 1.0F);
        }
    }

    // Methode für zufällige Wiedergabe
    public void playRandomRecord(Level level, BlockPos pos) {
        if (!records.isEmpty()) {
            int randomIndex = level.random.nextInt(records.size());
            ItemStack record = records.remove(randomIndex);
            level.playSound(null, pos, ((RecordItem) record.getItem()).getSound(), net.minecraft.sounds.SoundSource.RECORDS, 1.0F, 1.0F);
        }
    }
}
