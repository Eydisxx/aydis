package com.aydis.aydismod.item;


import com.aydis.aydismod.aydis;
import com.aydis.aydismod.potion.ModPotions;
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
public class get_crying_bottle {
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

            // Check if the held item is a bottle
            if (heldItem.is(Items.GLASS_BOTTLE)) {
                if (!level.isClientSide) {
                    // Replace block with Obsidian
                    level.setBlock(pos, Blocks.OBSIDIAN.defaultBlockState(), 3);
                    // Give the player a Crying Bottle
                    // Create a potion ItemStack with the Crying Potion
                    ItemStack cryingBottle = new ItemStack(Items.POTION);
                    cryingBottle.getOrCreateTag().putString("Potion", ModPotions.CRYING_BOTTLE.getId().toString());
                    heldItem.shrink(1); // Entfernt eine Glasflasche
                    if (!player.addItem(cryingBottle)) {
                        player.drop(cryingBottle, false); // Droppt, wenn das Inventar voll ist
                    }

                    // Sound after right clicking with a bottle
                    level.playSound(null, pos, SoundEvents.BOTTLE_FILL , // Vordefinierter Sound
                            net.minecraft.sounds.SoundSource.BLOCKS, // Soundquelle
                            1.0F, // Lautstärke
                            1.0F); // Tonhöhe
                }
                event.setCanceled(true);
                event.setCancellationResult(InteractionResult.SUCCESS);
            }
        }
    }
}