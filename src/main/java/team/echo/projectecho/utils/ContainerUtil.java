package team.echo.projectecho.utils;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import team.echo.projectecho.core.ProjectEchoBlocks;
import team.echo.projectecho.core.ProjectEchoCrafting;

import java.util.Random;

public class ContainerUtil {

    public static void spawnChestWithItems(World world, BlockPos pos, ChestType type, PlayerEntity player) {
        ServerWorld serverWorld = ((ServerWorld) world).getWorld();
        Direction facing = player.getHorizontalFacing().getOpposite();
        BlockState chestState = Blocks.CHEST.getDefaultState().with(BlockStateProperties.HORIZONTAL_FACING, facing);
        world.setBlockState(pos, chestState, 3);
        if (serverWorld.getTileEntity(pos) instanceof ChestTileEntity) {
            ChestTileEntity chestTile = (ChestTileEntity) world.getTileEntity(pos);
            Random random = new Random();
            if (chestTile != null) {
                switch (type) {
                    case OMAHGAWD: {
                        ItemStack[] loot = {
                                new ItemStack(Items.DIAMOND, MathUtil.getRandomInt(2, 15)),
                                new ItemStack(Items.ENCHANTED_GOLDEN_APPLE, MathUtil.getRandomInt(1, 5)),
                                new ItemStack(Items.EMERALD, MathUtil.getRandomInt(2, 15)),
                                new ItemStack(ProjectEchoBlocks.LOOT_BLOCK.get(), MathUtil.getRandomInt(1, 8)),
                                new ItemStack(ProjectEchoCrafting.ECHO_INGOT.get(), MathUtil.getRandomInt(1, 8)),
                                new ItemStack(ProjectEchoCrafting.BASIC_ECHO_CORE.get(), MathUtil.getRandomInt(1, 8))};
                        for (ItemStack item : loot) {
                            int randomSlot = random.nextInt(chestTile.getSizeInventory());
                            chestTile.setInventorySlotContents(randomSlot, item);
                        }
                        break;
                    }
                    case MEH: {
                        ItemStack[] loot = {
                                new ItemStack(Items.IRON_INGOT, MathUtil.getRandomInt(2, 8)),
                                new ItemStack(Items.OAK_PLANKS, MathUtil.getRandomInt(1, 8)),
                                new ItemStack(Items.STICK, MathUtil.getRandomInt(1, 3)),
                                new ItemStack(Items.APPLE, MathUtil.getRandomInt(1, 5)),
                                new ItemStack(Items.IRON_SWORD, 1)};
                        for (ItemStack item : loot) {
                            int randomSlot = random.nextInt(chestTile.getSizeInventory());
                            chestTile.setInventorySlotContents(randomSlot, item);
                        }
                        break;
                    }
                    case COMEONBRUHIJUSTWANTSOMEGOODLOOT: {
                        ItemStack[] loot = {
                                new ItemStack(Items.OAK_LEAVES, MathUtil.getRandomInt(1, 3)),
                                new ItemStack(Items.BLUE_BED, 1),
                                new ItemStack(Items.GLOWSTONE_DUST, MathUtil.getRandomInt(1, 7)),
                                new ItemStack(Items.APPLE, MathUtil.getRandomInt(1, 5)),
                                new ItemStack(Items.CHICKEN, MathUtil.getRandomInt(1, 4))};
                        for (ItemStack item : loot) {
                            int randomSlot = random.nextInt(chestTile.getSizeInventory());
                            chestTile.setInventorySlotContents(randomSlot, item);
                        }
                        break;
                    }
                }
            }
        }
    }

    public enum ChestType {
        COMEONBRUHIJUSTWANTSOMEGOODLOOT, MEH, OMAHGAWD
    }
}
