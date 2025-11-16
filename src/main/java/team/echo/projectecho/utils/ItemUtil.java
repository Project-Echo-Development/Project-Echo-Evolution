package team.echo.projectecho.utils;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import team.echo.projectecho.blocks.LootBlock;
import team.echo.projectecho.core.ProjectEchoCrafting;

public class ItemUtil {

    public static void spawnLoot(World world, BlockPos pos, int min, int max, Item... loot) {
        for (Item item : loot)
            for (int i = 0; i < MathUtil.getRandomInt(min, max); i++)
                Block.spawnAsEntity(world, pos, new net.minecraft.item.ItemStack(item));

        BlockUtil.spawnFireworks(world, pos, .5);
        BlockUtil.spawnFireworks(world, pos, .5);
    }
}
