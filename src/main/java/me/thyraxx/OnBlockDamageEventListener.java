package me.thyraxx;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;
import java.util.function.Predicate;


public class OnBlockDamageEventListener implements Listener {

    private int unbreakingLevel = 0;
    private final static int MAX_INVENTORY_INDEX = 8;

    private Predicate<? super Map.Entry<Integer, ? extends ItemStack>> inHotBar()
    {
        return itemEntry -> itemEntry.getKey() <= MAX_INVENTORY_INDEX;
    }

    // TODO: remove
    // Replaced by Diggable
    private static Material[] shovelables = new Material[]{
            Material.DIRT,
            Material.GRASS_BLOCK,
            Material.GRAVEL,
            Material.SAND,
            Material.COARSE_DIRT,
            Material.PODZOL,
            //Material.MYCELIUM, Do not enable this until enchantment check is enabled?
    };

    private static Material[] mineable = new Material[]{

    };

    private static Material[] cuttable = new Material[]{
            // Buttons
            Material.STONE_BUTTON,
            Material.OAK_BUTTON,
            Material.SPRUCE_BUTTON,
            Material.BIRCH_BUTTON,
            Material.JUNGLE_BUTTON,
            Material.ACACIA_BUTTON,
            Material.DARK_OAK_BUTTON,
            Material.CRIMSON_BUTTON,
            Material.WARPED_BUTTON,

            // Gates
            Material.OAK_FENCE_GATE,
            Material.SPRUCE_FENCE_GATE,
            Material.BIRCH_FENCE_GATE,
            Material.JUNGLE_FENCE_GATE,
            Material.ACACIA_FENCE_GATE,
            Material.DARK_OAK_FENCE_GATE,
            Material.CRIMSON_FENCE_GATE,
            Material.WARPED_FENCE_GATE,

            // Fences
            Material.OAK_FENCE,
            Material.SPRUCE_FENCE,
            Material.BIRCH_FENCE,
            Material.JUNGLE_FENCE,
            Material.ACACIA_FENCE,
            Material.DARK_OAK_FENCE,
            Material.CRIMSON_FENCE,
            Material.WARPED_FENCE,

            // Slabs
            Material.OAK_SLAB,
            Material.SPRUCE_SLAB,
            Material.BIRCH_SLAB,
            Material.JUNGLE_SLAB,
            Material.ACACIA_SLAB,
            Material.DARK_OAK_SLAB,
            Material.CRIMSON_SLAB,
            Material.WARPED_SLAB,

            // Stairs
            Material.OAK_STAIRS,
            Material.SPRUCE_STAIRS,
            Material.BIRCH_STAIRS,
            Material.JUNGLE_STAIRS,
            Material.ACACIA_STAIRS,
            Material.DARK_OAK_STAIRS,
            Material.WARPED_STAIRS

            // Planks
            Material.OAK_PLANKS,
            Material.SPRUCE_PLANKS,
            Material.BIRCH_PLANKS,
            Material.JUNGLE_PLANKS,
            Material.ACACIA_PLANKS,
            Material.DARK_OAK_PLANKS,
            Material.CRIMSON_PLANKS,
            Material.WARPED_PLANKS,


            // Logs
            Material.OAK_LOG,
            Material.SPRUCE_LOG,
            Material.BIRCH_LOG,
            Material.JUNGLE_LOG,
            Material.ACACIA_LOG,
            Material.DARK_OAK_LOG,
            Material.WARPED_STEM,

            Material.CHEST,
            Material.TRAPPED_CHEST,
    };

    @EventHandler(priority = EventPriority.NORMAL)
    public void onBlockDamageEvent(BlockDamageEvent event) {
        Material blockMaterial = event.getBlock().getType();

        HashMap<Integer, ? extends ItemStack> itemSlot = event.getPlayer().getInventory().all((Arrays.asList(shovelables).contains(blockMaterial)) ? Material.DIAMOND_SHOVEL : Material.DIAMOND_PICKAXE);

        itemSlot.entrySet().stream()
                .filter(inHotBar())
                .findFirst().ifPresent( slotEntry -> event.getPlayer().getInventory().setHeldItemSlot(slotEntry.getKey())
        );
    }
}
