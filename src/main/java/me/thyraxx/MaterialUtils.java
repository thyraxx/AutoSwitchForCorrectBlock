package me.thyraxx;

import org.bukkit.Material;

import java.util.Arrays;

public class MaterialUtils {

    private final static Material[] diggable = new Material[]{
            Material.DIRT,
            Material.GRASS_BLOCK,
            Material.GRAVEL,
            Material.SAND,
            Material.COARSE_DIRT,
            Material.PODZOL,
            //Material.MYCELIUM, Do not enable this until enchantment check is enabled?
    };

    private final static Material[] mineable = new Material[]{

            //Cobblestone
            Material.COBBLESTONE,
            Material.COBBLESTONE_SLAB,
            Material.COBBLESTONE_STAIRS,
            Material.COBBLESTONE_WALL,

            //MOSSY Cobblestone
            Material.MOSSY_COBBLESTONE,
            Material.MOSSY_COBBLESTONE_SLAB,
            Material.MOSSY_COBBLESTONE_STAIRS,
            Material.MOSSY_COBBLESTONE_WALL,

            //Stone
            Material.STONE,
            Material.STONE_SLAB,
            Material.STONE_STAIRS,

            //StoneBrick
            Material.STONE_BRICKS,
            Material.STONE_BRICK_SLAB,
            Material.STONE_BRICK_STAIRS,
            Material.STONE_BRICK_WALL,

            //SandStone
            Material.SANDSTONE,
            Material.SANDSTONE_SLAB,
            Material.SANDSTONE_STAIRS,
            Material.SANDSTONE_WALL,

            //ANDESITE
            Material.ANDESITE,
            Material.ANDESITE_SLAB,
            Material.ANDESITE_STAIRS,
            Material.ANDESITE_WALL,
            Material.POLISHED_ANDESITE,
            Material.POLISHED_ANDESITE_SLAB,
            Material.POLISHED_ANDESITE_STAIRS,

            //DIORITE
            Material.DIORITE,
            Material.DIORITE_SLAB,
            Material.DIORITE_STAIRS,
            Material.DIORITE_WALL,
            Material.POLISHED_DIORITE,
            Material.POLISHED_DIORITE_SLAB,
            Material.POLISHED_DIORITE_STAIRS,

            //Granite
            Material.GRANITE,
            Material.GRANITE_SLAB,
            Material.GRANITE_STAIRS,
            Material.GRANITE_WALL,
            Material.POLISHED_GRANITE,
            Material.POLISHED_GRANITE_SLAB,
            Material.POLISHED_GRANITE_STAIRS,

            //Lapis
            Material.LAPIS_ORE,
            Material.LAPIS_BLOCK,

            //Redstone
            Material.REDSTONE_ORE,
            Material.REDSTONE_BLOCK,

            //IRON
            Material.IRON_ORE,
            Material.IRON_BLOCK,

            //GOLD
            Material.GOLD_ORE,
            Material.GOLD_BLOCK,

            //Emerald
            Material.EMERALD_ORE,
            Material.EMERALD_BLOCK,

            //Diamond
            Material.DIAMOND_ORE,
            Material.DIAMOND_BLOCK,

            //BLACKSTONE
            Material.BLACKSTONE,
            Material.BLACKSTONE_SLAB,
            Material.BLACKSTONE_STAIRS,
            Material.BLACKSTONE_WALL,

            //NETHER_BRICK
            Material.NETHER_BRICK,
            Material.NETHER_BRICK_SLAB,
            Material.NETHER_BRICK_STAIRS,
            Material.NETHER_BRICK_WALL,

            //QUARTZ
            Material.QUARTZ,
            Material.QUARTZ_BLOCK,
            Material.QUARTZ_BRICKS,
            Material.QUARTZ_PILLAR,
            Material.QUARTZ_SLAB,
            Material.QUARTZ_STAIRS,

            //NETHER materials
            Material.NETHER_GOLD_ORE,
            Material.NETHER_QUARTZ_ORE,
            Material.NETHERITE_BLOCK,
            Material.ANCIENT_DEBRIS,

            Material.OBSIDIAN,
            Material.FURNACE,

            // Redstone
            Material.OBSERVER,
    };

    private final static Material[] cuttable = new Material[]{
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
            Material.WARPED_STAIRS,

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

    public static boolean isDiggable(Material material) {
        return Arrays.asList(diggable).contains(material);
    }

    public static boolean isMineable(Material material) {
        return Arrays.asList(mineable).contains(material);
    }

    public static boolean isCuttable(Material material) {
        return Arrays.asList(cuttable).contains(material);
    }


    public static Material getToolFor(Material material) {
        if (MaterialUtils.isDiggable(material)) {
            return Material.DIAMOND_SHOVEL;
        }

        if (MaterialUtils.isCuttable(material)) {
            return Material.DIAMOND_AXE;
        }

        if (MaterialUtils.isMineable(material)) {
            return Material.DIAMOND_PICKAXE;
        }

        return null;
    }
}
