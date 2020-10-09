package me.thyraxx;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;


public class OnBlockDamageEventListener implements Listener {

    private final static int MAX_INVENTORY_INDEX = 8;

    private Predicate<? super Map.Entry<Integer, ? extends ItemStack>> inHotBar()
    {
        return itemEntry -> itemEntry.getKey() <= MAX_INVENTORY_INDEX;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onBlockDamageEvent(BlockDamageEvent event) {
        Material blockMaterial = event.getBlock().getType();
        Material toolMaterial = MaterialUtils.getToolFor(blockMaterial);

        if (toolMaterial == null) {
            return;
        }

        HashMap<Integer, ? extends ItemStack> itemSlot = event.getPlayer().getInventory().all(toolMaterial);
        itemSlot.entrySet().stream()
                .filter(inHotBar())
                .findFirst().ifPresent(slotEntry -> event.getPlayer().getInventory().setHeldItemSlot(slotEntry.getKey())
        );
    }
}
