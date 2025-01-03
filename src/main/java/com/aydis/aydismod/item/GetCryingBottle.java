package com.aydis.aydismod.item;

import com.aydis.aydismod.aydis;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = aydis.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class GetCryingBottle {
    @SubscribeEvent
    public static void onBlockRightClick(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        Player player = event.getEntity();
        BlockPos pos = event.getPos();
        BlockState blockState = level.getBlockState(pos);

        // Check if the block is Crying Obsidian
        if (blockState.is(Blocks.CRYING_OBSIDIAN)) {
            InteractionHand hand = event.getHand();
            ItemStack heldItem = player.getItemInHand(hand);

            // Check if the held item is a glass bottle
            if (heldItem.is(Items.GLASS_BOTTLE)) {
                if (!level.isClientSide) {
                    // Replace block with Obsidian
                    level.setBlock(pos, Blocks.OBSIDIAN.defaultBlockState(), 3);

                    // Give the player a Crying Bottle (already registered Item)
                    ItemStack cryingBottle = new ItemStack(ModItems.CRYING_BOTTLE.get());
                    heldItem.shrink(1); // Removes one Glass Bottle from the player's hand
                    if (!player.addItem(cryingBottle)) {
                        player.drop(cryingBottle, false); // Drop if inventory is full
                    }

                    // Play sound after right clicking with a bottle
                    level.playSound(null, pos, SoundEvents.BOTTLE_FILL, // Predefined sound
                            net.minecraft.sounds.SoundSource.BLOCKS, // Sound source
                            1.0F, // Volume
                            1.0F); // Pitch
                }
                event.setCanceled(true);
                event.setCancellationResult(InteractionResult.SUCCESS);
            }
        }
    }
}
