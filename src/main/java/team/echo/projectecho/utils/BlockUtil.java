package team.echo.projectecho.utils;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class BlockUtil {

    @Deprecated
    public static void spawnFallingBlockTower(World world, Block block, double x, double y, double z, int height) {
        for (int i = 0; i < height; i++) {
            // Offsetted to avoid bugs that disallow landing
            double spawnY = y + 50 + i;
            double centeredX = Math.floor(x) + 0.5;
            double centeredZ = Math.floor(z) + 0.5;
            FallingBlockEntity fallingBlock = new FallingBlockEntity(world, centeredX, spawnY, centeredZ, block.getDefaultState());
            fallingBlock.shouldDropItem = false;
            fallingBlock.setHurtEntities(false);
            fallingBlock.fallTime = 1;
            world.addEntity(fallingBlock);
        }
    }

    public static void spawnOneByOneFallingBlockTower(World world, Block block, double x, double y, double z, int height, int ticks) {
        for (int i = 0; i < height; i++) {
            int delay = i * ticks;
            int finalI = i;
            TickScheduler.schedule(((ServerWorld) world).getWorld(), () -> {
            // Offsetted to avoid bugs that disallow landing
            double spawnY = y + 50 + finalI;
            double centeredX = Math.floor(x) + 0.5;
            double centeredZ = Math.floor(z) + 0.5;
            FallingBlockEntity fallingBlock = new FallingBlockEntity(world, centeredX, spawnY, centeredZ, block.getDefaultState());
            fallingBlock.shouldDropItem = false;
            fallingBlock.setHurtEntities(false);
            fallingBlock.fallTime = 1;
            world.addEntity(fallingBlock);
            }, delay);
        }
    }

    public static void spawnMultipleFallingBlocks(World world, Block block, double startX, double startY, double startZ, int count) {
        for (int i = 0; i < count; i++) {
            // Offsetted to avoid bugs that disallow landing
            double centeredX = Math.floor(startX) + 0.5;
            double centeredZ = Math.floor(startZ) + 0.5;
            double randomX = centeredX + (Math.random() - 0.5) * 10;
            double y = startY + 50;
            double randomZ = centeredZ + (Math.random() - 0.5) * 10;

            // Create and spawn a falling block
            FallingBlockEntity fallingBlock = new FallingBlockEntity(world, randomX, y, randomZ, block.getDefaultState());
            fallingBlock.shouldDropItem = false;
            fallingBlock.setHurtEntities(false);
            fallingBlock.fallTime = 1;
            fallingBlock.setMotion(0, -0.5, 0); // Fall speed
            world.addEntity(fallingBlock);
        }
    }

    public static void spawnFallingBlockGrid(World world, Block block, boolean checkered, double startX, double startY, double startZ, int rows, int columns) {
        double centeredX = Math.floor(startX) + 0.5;
        double centeredZ = Math.floor(startZ) + 0.5;

        for (int row = 0; row < rows; row++)
            for (int col = 0; col < columns; col++) {
                if (checkered && ((row + col) % 2 != 0))
                    continue;

                // Offsetted to avoid bugs that disallow landing
                double x = centeredX + col;
                double y = startY + 50;
                double z = centeredZ + row;

                FallingBlockEntity fallingBlock = new FallingBlockEntity(world, x, y, z, block.getDefaultState());
                // The fall time and dropItem ensure the block lands and doesn't disappear like my ex
                fallingBlock.shouldDropItem = false;
                fallingBlock.setHurtEntities(false);
                fallingBlock.fallTime = 1;
                world.addEntity(fallingBlock);
            }
    }

    public static void summonMultipleTNT(World world, BlockPos pos, int count, int fuseTime) {
        if (!world.isRemote) {
            for (int i = 0; i < count; i++) {
                double offsetX = (world.getRandom().nextDouble() - 0.5) * 2.0; // The offset ensures the blocks fall
                double offsetZ = (world.getRandom().nextDouble() - 0.5) * 2.0; // centered on the block
                TNTEntity tnt = new TNTEntity(world, pos.getX() + 0.5 + offsetX, pos.getY(), pos.getZ() + 0.5 + offsetZ, null);
                tnt.setFuse(fuseTime);
                world.addEntity(tnt);
            }
        }
    }

    public static void generateGrid(int size, Block block, World world, BlockPos center, boolean fillAirOnly) {
        if (world.isRemote)
            return;
        for (int x = -size; x <= size; x++) { // default 1 = 3x3
            for (int z = -size; z <= size; z++) {
                BlockPos pos = center.add(x, 0, z);
                if (!fillAirOnly || world.isAirBlock(pos)) {
                    world.setBlockState(pos, block.getDefaultState(), 3);
                }
            }
        }
    }

    public static void spawnFireworks(World world, BlockPos pos, double time) {
        ItemStack firework = new ItemStack(Items.FIREWORK_ROCKET);
        CompoundNBT fireworkData = new CompoundNBT();
        CompoundNBT explosion = new CompoundNBT();
        ListNBT explosions = new ListNBT();
        explosion.putIntArray("Colors", new int[]{0xFF0000, 0x00FF00, 0x0000FF});
        explosion.putIntArray("FadeColors", new int[]{0xFFFFFF});
        explosion.putBoolean("Trail", true); // Add trail
        explosion.putBoolean("Flicker", true); // Add flicker
        explosion.putByte("Type", (byte) 1); // Type 1 = Large ball
        explosions.add(explosion);
        fireworkData.put("Explosions", explosions);
        fireworkData.putByte("Flight", (byte) time); // Duration
        firework.setTagInfo("Fireworks", fireworkData);
        FireworkRocketEntity fireworkEntity = new FireworkRocketEntity(world, pos.getX(), pos.getY(), pos.getZ(), firework);
        world.addEntity(fireworkEntity);
    }
}
