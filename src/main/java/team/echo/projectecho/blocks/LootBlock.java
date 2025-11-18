package team.echo.projectecho.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.potion.*;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import team.echo.projectecho.core.ProjectEchoArmor;
import team.echo.projectecho.core.ProjectEchoBlocks;
import team.echo.projectecho.core.ProjectEchoCrafting;
import team.echo.projectecho.core.ProjectEchoTools;
import team.echo.projectecho.utils.*;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LootBlock extends Block {
    public LootBlock(Properties prop) {
        super(prop);
    }

    @ParametersAreNonnullByDefault
    @Override
    public void onPlayerDestroy(IWorld world, BlockPos pos, BlockState state) {
        super.onPlayerDestroy(world, pos, state);
        randomLoot((World) world, pos);
    }

    @Override
    public void onExplosionDestroy(World p_180652_1_, BlockPos p_180652_2_, Explosion p_180652_3_) {
        super.onExplosionDestroy(p_180652_1_, p_180652_2_, p_180652_3_);
        randomLoot(p_180652_1_, p_180652_2_);
    }

    private void randomLoot(World world, BlockPos pos) {
        if (!world.isRemote() && world instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld) world;
//            int random = MathUtil.getRandomInt(1, 78);
            int random = MathUtil.getRandomInt(82, 95);
//            int random = 76;
            pickLoot(random, serverWorld, pos);
        }
    }

    private void pickLoot(int ran, World world, BlockPos pos) {
        PlayerEntity player = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 10, false);
        ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
        ChatUtil.broadcastMessage((ServerWorld) world, String.valueOf(ran));
        if (player == null)
            return;

        switch (ran) {
            case 1:
                for (int i = 0; i < MathUtil.getRandomInt(1, 20); i++) {
                    spawnAsEntity(world, pos, new net.minecraft.item.ItemStack(net.minecraft.item.Items.DIAMOND).
                            setDisplayName(new StringTextComponent("\2473\247lOoo shiny")));
                }
                break;
            case 2:
                BlockUtil.summonMultipleTNT(world, pos, MathUtil.getRandomInt(1, 30), 30);
                break;
            case 3:
                ((ServerWorld) world).getWorld().setDayTime(18000);
                EntityUtil.summonMultipleZombies(((ServerWorld) world).getWorld(), pos, 75);
                ChatUtil.broadcastMessage(((ServerWorld) world).getWorld(), "\2474\247lNOW YOURE REALLY FUCKED!!!! MUAHAHHAAHAH!!");
                break;
            case 4:
                world.createExplosion(null, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 4.0F, Explosion.Mode.BREAK);
                break;
            case 5:
                EntityUtil.spawnCustomZombieWithEnchantedGear(((ServerWorld) world).getWorld(), pos, "\2479\247lHarris",
                        ProjectEchoArmor.BASIC_ECHO_HELMET.get(), ProjectEchoArmor.BASIC_ECHO_CHESTPLATE.get(),
                        ProjectEchoArmor.BASIC_ECHO_LEGGINGS.get(), ProjectEchoArmor.BASIC_ECHO_BOOTS.get(), ProjectEchoTools.BASIC_ECHO_SWORD.get());
                break;
            case 6:
                ItemStack ultraEchoSword = new ItemStack(ProjectEchoTools.BASIC_ECHO_SWORD.get());
                ultraEchoSword.addEnchantment(Enchantments.SHARPNESS, MathUtil.getRandomInt(1, 5));
                ultraEchoSword.addEnchantment(Enchantments.KNOCKBACK, MathUtil.getRandomInt(1, 3));
                ultraEchoSword.addEnchantment(Enchantments.UNBREAKING, MathUtil.getRandomInt(1, 3));
                ultraEchoSword.addEnchantment(Enchantments.LOOTING, MathUtil.getRandomInt(1, 3));
                ultraEchoSword.setDisplayName(new StringTextComponent("\247b\247lUltra Echo Sword"));
                spawnAsEntity(world, pos, ultraEchoSword);
                break;
            case 7:
                ItemStack ultraEchoHelmet = new ItemStack(ProjectEchoArmor.BASIC_ECHO_HELMET.get());
                ultraEchoHelmet.addEnchantment(Enchantments.PROTECTION, MathUtil.getRandomInt(1, 4));
                ultraEchoHelmet.addEnchantment(Enchantments.UNBREAKING, MathUtil.getRandomInt(1, 3));
                ultraEchoHelmet.addEnchantment(Enchantments.THORNS, MathUtil.getRandomInt(1, 2));
                ultraEchoHelmet.setDisplayName(new StringTextComponent("\247b\247lUltra Echo Helmet"));
                spawnAsEntity(world, pos, ultraEchoHelmet);
                break;
            case 8:
                ItemStack ultraEchoChestplate = new ItemStack(ProjectEchoArmor.BASIC_ECHO_CHESTPLATE.get());
                ultraEchoChestplate.addEnchantment(Enchantments.PROTECTION, MathUtil.getRandomInt(1, 4));
                ultraEchoChestplate.addEnchantment(Enchantments.UNBREAKING, MathUtil.getRandomInt(1, 3));
                ultraEchoChestplate.addEnchantment(Enchantments.THORNS, MathUtil.getRandomInt(1, 2));
                ultraEchoChestplate.setDisplayName(new StringTextComponent("\247b\247lUltra Echo Chestplate"));
                spawnAsEntity(world, pos, ultraEchoChestplate);
                break;
            case 9:
                ItemStack ultraEchoTrousers = new ItemStack(ProjectEchoArmor.BASIC_ECHO_LEGGINGS.get());
                ultraEchoTrousers.addEnchantment(Enchantments.PROTECTION, MathUtil.getRandomInt(1, 4));
                ultraEchoTrousers.addEnchantment(Enchantments.UNBREAKING, MathUtil.getRandomInt(1, 3));
                ultraEchoTrousers.addEnchantment(Enchantments.THORNS, MathUtil.getRandomInt(1, 2));
                ultraEchoTrousers.setDisplayName(new StringTextComponent("\247b\247lUltra Echo Trousers"));
                spawnAsEntity(world, pos, ultraEchoTrousers);
                break;
            case 10:
                ItemStack ultraEchoBoots = new ItemStack(ProjectEchoArmor.BASIC_ECHO_BOOTS.get());
                ultraEchoBoots.addEnchantment(Enchantments.PROTECTION, MathUtil.getRandomInt(1, 4));
                ultraEchoBoots.addEnchantment(Enchantments.UNBREAKING, MathUtil.getRandomInt(1, 3));
                ultraEchoBoots.addEnchantment(Enchantments.THORNS, MathUtil.getRandomInt(1, 2));
                ultraEchoBoots.setDisplayName(new StringTextComponent("\247b\247lUltra Echo Boots"));
                spawnAsEntity(world, pos, ultraEchoBoots);
                break;
            case 12:
                ItemStack ultraEchoPickaxe = new ItemStack(ProjectEchoTools.BASIC_ECHO_PICKAXE.get());
                ultraEchoPickaxe.addEnchantment(Enchantments.EFFICIENCY, MathUtil.getRandomInt(1, 4));
                ultraEchoPickaxe.addEnchantment(Enchantments.UNBREAKING, MathUtil.getRandomInt(1, 3));
                ultraEchoPickaxe.addEnchantment(Enchantments.FORTUNE, MathUtil.getRandomInt(1, 3));
                ultraEchoPickaxe.setDisplayName(new StringTextComponent("\247b\247lUltra Echo Pickaxe"));
                spawnAsEntity(world, pos, ultraEchoPickaxe);
                break;
            case 13:
                ItemStack aBadPickaxe = new ItemStack(ProjectEchoTools.BASIC_ECHO_PICKAXE.get());
                aBadPickaxe.addEnchantment(Enchantments.FLAME, MathUtil.getRandomInt(1, 4));
                aBadPickaxe.addEnchantment(Enchantments.POWER, MathUtil.getRandomInt(1, 4));
                aBadPickaxe.addEnchantment(Enchantments.INFINITY, MathUtil.getRandomInt(1, 4));
                aBadPickaxe.addEnchantment(Enchantments.PUNCH, MathUtil.getRandomInt(1, 4));
                aBadPickaxe.addEnchantment(Enchantments.MULTISHOT, MathUtil.getRandomInt(1, 4));
                aBadPickaxe.setDisplayName(new StringTextComponent("\2474\247lA bad pickaxe"));
                spawnAsEntity(world, pos, aBadPickaxe);
                break;
            case 14:
                BlockUtil.spawnOneByOneFallingBlockTower(world, Blocks.GOLD_BLOCK, pos.getX(), pos.getY(), pos.getZ(), MathUtil.getRandomInt(4, 12), 8);
                break;
            case 15:
                BlockUtil.spawnOneByOneFallingBlockTower(world, Blocks.DIAMOND_BLOCK, pos.getX(), pos.getY(), pos.getZ(), MathUtil.getRandomInt(4, 12), 8);
                break;
            case 16:
                BlockUtil.spawnOneByOneFallingBlockTower(world, Blocks.IRON_BLOCK, pos.getX(), pos.getY(), pos.getZ(), MathUtil.getRandomInt(4, 12), 8);
                break;
            case 17:
                BlockUtil.spawnFallingBlockTower(world, Blocks.REDSTONE_BLOCK, pos.getX(), pos.getY(), pos.getZ(), 1);
                BlockUtil.spawnFallingBlockTower(world, Blocks.TNT, pos.getX(), pos.getY(), pos.getZ(), 12);
                break;
            case 18:
                BlockUtil.spawnFallingBlockTower(world, Blocks.REDSTONE_BLOCK, pos.getX(), pos.getY(), pos.getZ(), 1);
                BlockUtil.spawnFallingBlockTower(world, Blocks.TNT, pos.getX(), pos.getY(), pos.getZ(), 100);
                ChatUtil.broadcastMessage(((ServerWorld) world).getWorld(), "\2474\247lYOURE DONE!!!");
                break;
            case 19:
                ChatUtil.broadcastMessage(((ServerWorld) world).getWorld(), "\2474\247lNUKE INCOMING RUNNNN");
                world.createExplosion(null, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 220, Explosion.Mode.BREAK);
                break;
            case 20:
                EntityUtil.summonMultipleCats(world, pos, player, true, true, MathUtil.getRandomInt(4, 8));
                break;
            case 21:
                ItemStack notADiamond = new ItemStack(Items.EMERALD);
                notADiamond.addEnchantment(Enchantments.SHARPNESS, MathUtil.getRandomInt(4, 8));
                notADiamond.setDisplayName(new StringTextComponent("\247a\247lNot a diamond"));
                spawnAsEntity(world, pos, notADiamond);
                break;
            case 22:
                ItemStack fancyLight = new ItemStack(Items.BEACON);
                fancyLight.addEnchantment(Enchantments.FIRE_ASPECT, MathUtil.getRandomInt(1, 3));
                fancyLight.addEnchantment(Enchantments.UNBREAKING, MathUtil.getRandomInt(1, 3));
                fancyLight.setDisplayName(new StringTextComponent("A fancy light"));
                spawnAsEntity(world, pos, fancyLight);
                break;
            case 23:
                BlockUtil.generateGrid(2, Blocks.BRICKS, world, pos, false);
                BlockUtil.generateGrid(1, Blocks.TNT, world, pos, false);
                BlockUtil.generateGrid(1, Blocks.BRICKS, world, new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), false);
                world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 2, pos.getZ()), Blocks.TRAPPED_CHEST.getDefaultState(), 3);
                break;
            case 24:
                BlockUtil.generateGrid(3, Blocks.BRICKS, world, pos, false);
                BlockUtil.generateGrid(2, Blocks.TNT, world, pos, false);
                BlockUtil.generateGrid(2, Blocks.BRICKS, world, new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), false);
                BlockUtil.generateGrid(1, Blocks.TNT, world, new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), false);
                BlockUtil.generateGrid(1, Blocks.BRICKS, world, new BlockPos(pos.getX(), pos.getY() + 2, pos.getZ()), false);
                world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 3, pos.getZ()), Blocks.TRAPPED_CHEST.getDefaultState(), 3);
                break;
            case 25:
                BlockUtil.generateGrid(2, Blocks.BRICKS, world, pos, false);
                BlockUtil.generateGrid(1, Blocks.GOLD_BLOCK, world, pos, false);
                BlockUtil.generateGrid(1, Blocks.BRICKS, world, new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), false);
                world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 2, pos.getZ()), Blocks.TRAPPED_CHEST.getDefaultState(), 3);
                break;
            case 26:
                BlockUtil.generateGrid(3, Blocks.BRICKS, world, pos, false);
                BlockUtil.generateGrid(2, Blocks.GOLD_BLOCK, world, pos, false);
                BlockUtil.generateGrid(2, Blocks.BRICKS, world, new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), false);
                BlockUtil.generateGrid(1, Blocks.GOLD_BLOCK, world, new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), false);
                BlockUtil.generateGrid(1, Blocks.BRICKS, world, new BlockPos(pos.getX(), pos.getY() + 2, pos.getZ()), false);
                world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 3, pos.getZ()), Blocks.TRAPPED_CHEST.getDefaultState(), 3);
                break;
            case 27:
                BlockUtil.generateGrid(1, Blocks.IRON_BLOCK, world, pos, false);
                world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), Blocks.BEACON.getDefaultState(), 3);
                break;
            case 28:
                BlockUtil.generateGrid(1, Blocks.GOLD_BLOCK, world, pos, false);
                world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), Blocks.BEACON.getDefaultState(), 3);
                break;
            case 29:
                ItemStack excalibur = new ItemStack(ProjectEchoTools.GOLD_INFUSED_ECHO_SWORD.get());
                excalibur.addEnchantment(Enchantments.SHARPNESS, 20);
                excalibur.setDisplayName(new StringTextComponent("\2476\247lExcalibur"));
                spawnAsEntity(world, pos, excalibur);
                break;
            case 30:
                ItemUtil.spawnLoot(world, pos, 8, 24, Items.DIAMOND, Items.EMERALD, Items.GOLD_INGOT, Items.IRON_INGOT, Items.LAPIS_LAZULI);
                break;
            case 31:
                ItemUtil.spawnLoot(world, pos, 8, 24, ProjectEchoCrafting.BASIC_ECHO_CORE.get(), ProjectEchoCrafting.ECHO_INGOT.get(),
                        ProjectEchoCrafting.GOLD_INFUSED_ECHO_CORE.get(), ProjectEchoCrafting.GOLD_INFUSED_ECHO_INGOT.get(),
                        ProjectEchoCrafting.DIAMOND_INFUSED_ECHO_CORE.get(), ProjectEchoCrafting.DIAMOND_INFUSED_ECHO_INGOT.get(),
                        ProjectEchoCrafting.CARBON_INFUSED_ECHO_CORE.get(), ProjectEchoCrafting.CARBON_INFUSED_ECHO_INGOT.get());
                break;
            case 32:
                EntityUtil.teleportPlayerUp(serverPlayer, 100, false);
                ChatUtil.broadcastMessage(((ServerWorld) world).getWorld(), "I believe i can fly");
                break;
            case 33:
                ItemStack star = new ItemStack(Items.NETHER_STAR);
                star.setDisplayName(new StringTextComponent("\247lShooting star"));
                star.getOrCreateTag().putString("ShootingStar", "It's late and I'm awake");
                ItemEntity shootingStar = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), star);
                world.addEntity(shootingStar);
                break;
            case 34:
                ItemStack spongebob = new ItemStack(Items.WET_SPONGE);
                spongebob.setDisplayName(new StringTextComponent("\247lSpongebob"));
                spongebob.getOrCreateTag().putString("SPR34", "rule 34");
                ItemEntity spongebobEnt = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), spongebob);
                world.addEntity(spongebobEnt);
                break;
            case 35:
                EntityUtil.spawnFallingItems(world, ProjectEchoCrafting.ECHO_INGOT.get(), pos, 18, MathUtil.getRandomInt(12, 18), 6, "");
                break;
            case 36:
                EntityUtil.spawnFallingItems(world, ProjectEchoCrafting.ECHO_INGOT.get(), pos, 18, MathUtil.getRandomInt(12, 18), 6, "");
                EntityUtil.spawnFallingItems(world, ProjectEchoCrafting.GOLD_INFUSED_ECHO_INGOT.get(), pos, 18, MathUtil.getRandomInt(6, 10), 6, "");
                break;
            case 37:
                EntityUtil.spawnFallingItems(world, ProjectEchoCrafting.ECHO_INGOT.get(), pos, 18, MathUtil.getRandomInt(12, 18), 6, "");
                EntityUtil.spawnFallingItems(world, ProjectEchoCrafting.GOLD_INFUSED_ECHO_INGOT.get(), pos, 18, MathUtil.getRandomInt(6, 10), 6, "");
                EntityUtil.spawnFallingItems(world, ProjectEchoCrafting.DIAMOND_INFUSED_ECHO_INGOT.get(), pos, 18, MathUtil.getRandomInt(6, 10), 6, "");
                break;
            case 38:
                EntityUtil.spawnFallingItems(world, ProjectEchoCrafting.ECHO_INGOT.get(), pos, 18, MathUtil.getRandomInt(8, 14), 6, "");
                EntityUtil.spawnFallingItems(world, ProjectEchoCrafting.GOLD_INFUSED_ECHO_INGOT.get(), pos, 18, MathUtil.getRandomInt(6, 10), 6, "");
                EntityUtil.spawnFallingItems(world, ProjectEchoCrafting.DIAMOND_INFUSED_ECHO_INGOT.get(), pos, 18, MathUtil.getRandomInt(6, 10), 6, "");
                EntityUtil.spawnFallingItems(world, ProjectEchoCrafting.CARBON_INFUSED_ECHO_INGOT.get(), pos, 18, MathUtil.getRandomInt(6, 10), 6, "");
                break;
            case 39:
                EntityUtil.spawnCustomZombieWithEnchantedGear(((ServerWorld) world).getWorld(), pos, "\2476\247lGolden Harris",
                        ProjectEchoArmor.GOLD_INFUSED_ECHO_HELMET.get(), ProjectEchoArmor.GOLD_INFUSED_ECHO_CHESTPLATE.get(),
                        ProjectEchoArmor.GOLD_INFUSED_ECHO_TROUSERS.get(), ProjectEchoArmor.GOLD_INFUSED_ECHO_BOOTS.get(), ProjectEchoTools.GOLD_INFUSED_ECHO_SWORD.get());
                break;
            case 40:
                BlockUtil.spawnFallingBlockGrid(world, Blocks.ANVIL, false, player.getPosX() - 1, player.getPosY(), player.getPosZ() - 1, 3, 3);
                break;
            case 41:

                player.addPotionEffect(new EffectInstance(Effects.LEVITATION, 20, 30, false, false));
                break;
            case 42:

                ContainerUtil.spawnChestWithItems(world, pos, ContainerUtil.ChestType.COMEONBRUHIJUSTWANTSOMEGOODLOOT, player);
                break;
            case 43:

                ContainerUtil.spawnChestWithItems(world, pos, ContainerUtil.ChestType.MEH, player);
                break;
            case 44:

                ContainerUtil.spawnChestWithItems(world, pos, ContainerUtil.ChestType.OMAHGAWD, player);
                break;
            case 45:
                Direction facing = player.getHorizontalFacing().getOpposite();
                BlockState chestState = Blocks.CHEST.getDefaultState().with(BlockStateProperties.HORIZONTAL_FACING, facing);
                world.setBlockState(pos, chestState, 3);
                break;
            case 46:
                BlockUtil.spawnOneByOneFallingBlockTower(world, Blocks.EMERALD_BLOCK, pos.getX(), pos.getY(), pos.getZ(), MathUtil.getRandomInt(4, 12), 8);
            case 47:
                BlockUtil.generateGrid(2, Blocks.BRICKS, world, pos, false);
                BlockUtil.generateGrid(1, Blocks.DIAMOND_BLOCK, world, pos, false);
                BlockUtil.generateGrid(1, Blocks.BRICKS, world, new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), false);
                world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 2, pos.getZ()), Blocks.TRAPPED_CHEST.getDefaultState(), 3);
                break;
            case 48:
                BlockUtil.generateGrid(3, Blocks.BRICKS, world, pos, false);
                BlockUtil.generateGrid(2, Blocks.DIAMOND_BLOCK, world, pos, false);
                BlockUtil.generateGrid(2, Blocks.BRICKS, world, new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), false);
                BlockUtil.generateGrid(1, Blocks.DIAMOND_BLOCK, world, new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), false);
                BlockUtil.generateGrid(1, Blocks.BRICKS, world, new BlockPos(pos.getX(), pos.getY() + 2, pos.getZ()), false);
                world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 3, pos.getZ()), Blocks.TRAPPED_CHEST.getDefaultState(), 3);
                break;
            case 49:
                BlockUtil.spawnOneByOneFallingBlockTower(world, ProjectEchoBlocks.LOOT_BLOCK.get(), pos.getX(), pos.getY(), pos.getZ(), MathUtil.getRandomInt(4, 12), 8);
                break;
            case 50:
                BlockUtil.spawnFallingBlockGrid(world, Blocks.TNT, true, player.getPosX() - 1, player.getPosY(), player.getPosZ() - 1, 5, 5);
                BlockUtil.spawnOneByOneFallingBlockTower(world, Blocks.REDSTONE_BLOCK, player.getPosX(), player.getPosY(), player.getPosZ(), MathUtil.getRandomInt(1, 1), 8);
                break;
            case 51:
                EntityUtil.spawnCustomZombieWithEnchantedGear(((ServerWorld) world).getWorld(), pos, "\247b\247lDiamond Harris",
                        ProjectEchoArmor.DIAMOND_INFUSED_ECHO_HELMET.get(), ProjectEchoArmor.DIAMOND_INFUSED_ECHO_CHESTPLATE.get(),
                        ProjectEchoArmor.DIAMOND_INFUSED_ECHO_TROUSERS.get(), ProjectEchoArmor.DIAMOND_INFUSED_ECHO_BOOTS.get(), ProjectEchoTools.DIAMOND_INFUSED_ECHO_SWORD.get());
                break;
            case 52:
                EntityUtil.spawnCustomZombieWithEnchantedGear(((ServerWorld) world).getWorld(), pos, "\2471\247lFinal Boss Harris",
                        ProjectEchoArmor.CARBON_INFUSED_ECHO_HELMET.get(), ProjectEchoArmor.CARBON_INFUSED_ECHO_CHESTPLATE.get(),
                        ProjectEchoArmor.CARBON_INFUSED_ECHO_TROUSERS.get(), ProjectEchoArmor.CARBON_INFUSED_ECHO_BOOTS.get(), ProjectEchoTools.CARBON_INFUSED_ECHO_SWORD.get());
                break;
            case 53:
                for (int i = 0; i < MathUtil.getRandomInt(8, 100); i++)
                    EntityUtil.spawnCustomZombieWithEnchantedGear(((ServerWorld) world).getWorld(), pos, "\2479\247lHarris Gang",
                            ProjectEchoArmor.BASIC_ECHO_HELMET.get(), ProjectEchoArmor.BASIC_ECHO_CHESTPLATE.get(),
                            ProjectEchoArmor.BASIC_ECHO_LEGGINGS.get(), ProjectEchoArmor.BASIC_ECHO_BOOTS.get(), ProjectEchoTools.BASIC_ECHO_SWORD.get());
                break;
            case 54:
                for (int i = 0; i < MathUtil.getRandomInt(8, 100); i++)
                    EntityUtil.spawnCustomZombieWithEnchantedGear(((ServerWorld) world).getWorld(), pos, "\2476\247lGolden Harris Gang",
                            ProjectEchoArmor.GOLD_INFUSED_ECHO_HELMET.get(), ProjectEchoArmor.GOLD_INFUSED_ECHO_CHESTPLATE.get(),
                            ProjectEchoArmor.GOLD_INFUSED_ECHO_TROUSERS.get(), ProjectEchoArmor.GOLD_INFUSED_ECHO_BOOTS.get(), ProjectEchoTools.GOLD_INFUSED_ECHO_SWORD.get());
                break;
            case 55:
                for (int i = 0; i < MathUtil.getRandomInt(8, 100); i++)
                    EntityUtil.spawnCustomZombieWithEnchantedGear(((ServerWorld) world).getWorld(), pos, "\247b\247lDiamond Harris Gang",
                            ProjectEchoArmor.DIAMOND_INFUSED_ECHO_HELMET.get(), ProjectEchoArmor.DIAMOND_INFUSED_ECHO_CHESTPLATE.get(),
                            ProjectEchoArmor.DIAMOND_INFUSED_ECHO_TROUSERS.get(), ProjectEchoArmor.DIAMOND_INFUSED_ECHO_BOOTS.get(), ProjectEchoTools.DIAMOND_INFUSED_ECHO_SWORD.get());
                break;
            case 56:
                for (int i = 0; i < MathUtil.getRandomInt(8, 100); i++)
                    EntityUtil.spawnCustomZombieWithEnchantedGear(((ServerWorld) world).getWorld(), pos, "\2471\247lFinal Boss Harris Gang",
                            ProjectEchoArmor.CARBON_INFUSED_ECHO_HELMET.get(), ProjectEchoArmor.CARBON_INFUSED_ECHO_CHESTPLATE.get(),
                            ProjectEchoArmor.CARBON_INFUSED_ECHO_TROUSERS.get(), ProjectEchoArmor.CARBON_INFUSED_ECHO_BOOTS.get(), ProjectEchoTools.CARBON_INFUSED_ECHO_SWORD.get());
                break;
            case 57:
                ItemStack ultraGoldEchoSword = new ItemStack(ProjectEchoTools.GOLD_INFUSED_ECHO_SWORD.get());
                ultraGoldEchoSword.addEnchantment(Enchantments.SHARPNESS, MathUtil.getRandomInt(1, 5));
                ultraGoldEchoSword.addEnchantment(Enchantments.KNOCKBACK, MathUtil.getRandomInt(1, 3));
                ultraGoldEchoSword.addEnchantment(Enchantments.UNBREAKING, MathUtil.getRandomInt(1, 3));
                ultraGoldEchoSword.addEnchantment(Enchantments.LOOTING, MathUtil.getRandomInt(1, 3));
                ultraGoldEchoSword.setDisplayName(new StringTextComponent("\247b\247lUltra Gold Echo Sword"));
                spawnAsEntity(world, pos, ultraGoldEchoSword);
                break;
            case 58:
                ItemStack ultraGoldEchoHelmet = new ItemStack(ProjectEchoArmor.GOLD_INFUSED_ECHO_HELMET.get());
                ultraGoldEchoHelmet.addEnchantment(Enchantments.PROTECTION, MathUtil.getRandomInt(1, 4));
                ultraGoldEchoHelmet.addEnchantment(Enchantments.UNBREAKING, MathUtil.getRandomInt(1, 3));
                ultraGoldEchoHelmet.addEnchantment(Enchantments.THORNS, MathUtil.getRandomInt(1, 2));
                ultraGoldEchoHelmet.setDisplayName(new StringTextComponent("\247b\247lUltra Gold Echo Helmet"));
                spawnAsEntity(world, pos, ultraGoldEchoHelmet);
                break;
            case 59:
                ItemStack ultraGoldEchoChestplate = new ItemStack(ProjectEchoArmor.GOLD_INFUSED_ECHO_CHESTPLATE.get());
                ultraGoldEchoChestplate.addEnchantment(Enchantments.PROTECTION, MathUtil.getRandomInt(1, 4));
                ultraGoldEchoChestplate.addEnchantment(Enchantments.UNBREAKING, MathUtil.getRandomInt(1, 3));
                ultraGoldEchoChestplate.addEnchantment(Enchantments.THORNS, MathUtil.getRandomInt(1, 2));
                ultraGoldEchoChestplate.setDisplayName(new StringTextComponent("\247b\247lUltra Gold Echo Chestplate"));
                spawnAsEntity(world, pos, ultraGoldEchoChestplate);
                break;
            case 60:
                ItemStack ultraGoldEchoTrousers = new ItemStack(ProjectEchoArmor.GOLD_INFUSED_ECHO_TROUSERS.get());
                ultraGoldEchoTrousers.addEnchantment(Enchantments.PROTECTION, MathUtil.getRandomInt(1, 4));
                ultraGoldEchoTrousers.addEnchantment(Enchantments.UNBREAKING, MathUtil.getRandomInt(1, 3));
                ultraGoldEchoTrousers.addEnchantment(Enchantments.THORNS, MathUtil.getRandomInt(1, 2));
                ultraGoldEchoTrousers.setDisplayName(new StringTextComponent("\247b\247lUltra Gold Echo Trousers"));
                spawnAsEntity(world, pos, ultraGoldEchoTrousers);
                break;
            case 61:
                ItemStack ultraGoldEchoBoots = new ItemStack(ProjectEchoArmor.GOLD_INFUSED_ECHO_BOOTS.get());
                ultraGoldEchoBoots.addEnchantment(Enchantments.PROTECTION, MathUtil.getRandomInt(1, 4));
                ultraGoldEchoBoots.addEnchantment(Enchantments.UNBREAKING, MathUtil.getRandomInt(1, 3));
                ultraGoldEchoBoots.addEnchantment(Enchantments.THORNS, MathUtil.getRandomInt(1, 2));
                ultraGoldEchoBoots.setDisplayName(new StringTextComponent("\247b\247lUltra Gold Echo Boots"));
                spawnAsEntity(world, pos, ultraGoldEchoBoots);
                break;
            case 62:
                ItemStack ultraGoldEchoPickaxe = new ItemStack(ProjectEchoTools.GOLD_INFUSED_ECHO_PICKAXE.get());
                ultraGoldEchoPickaxe.addEnchantment(Enchantments.EFFICIENCY, MathUtil.getRandomInt(1, 4));
                ultraGoldEchoPickaxe.addEnchantment(Enchantments.UNBREAKING, MathUtil.getRandomInt(1, 3));
                ultraGoldEchoPickaxe.addEnchantment(Enchantments.FORTUNE, MathUtil.getRandomInt(1, 3));
                ultraGoldEchoPickaxe.setDisplayName(new StringTextComponent("\247b\247lUltra Gold Echo Pickaxe"));
                spawnAsEntity(world, pos, ultraGoldEchoPickaxe);
                break;
            case 63:
                ItemStack ultraDiamondEchoSword = new ItemStack(ProjectEchoTools.DIAMOND_INFUSED_ECHO_SWORD.get());
                ultraDiamondEchoSword.addEnchantment(Enchantments.SHARPNESS, MathUtil.getRandomInt(1, 5));
                ultraDiamondEchoSword.addEnchantment(Enchantments.KNOCKBACK, MathUtil.getRandomInt(1, 3));
                ultraDiamondEchoSword.addEnchantment(Enchantments.UNBREAKING, MathUtil.getRandomInt(1, 3));
                ultraDiamondEchoSword.addEnchantment(Enchantments.LOOTING, MathUtil.getRandomInt(1, 3));
                ultraDiamondEchoSword.setDisplayName(new StringTextComponent("\247b\247lUltra Diamond Echo Sword"));
                spawnAsEntity(world, pos, ultraDiamondEchoSword);
                break;
            case 64:
                ItemStack ultraDiamondEchoHelmet = new ItemStack(ProjectEchoArmor.DIAMOND_INFUSED_ECHO_HELMET.get());
                ultraDiamondEchoHelmet.addEnchantment(Enchantments.PROTECTION, MathUtil.getRandomInt(1, 4));
                ultraDiamondEchoHelmet.addEnchantment(Enchantments.UNBREAKING, MathUtil.getRandomInt(1, 3));
                ultraDiamondEchoHelmet.addEnchantment(Enchantments.THORNS, MathUtil.getRandomInt(1, 2));
                ultraDiamondEchoHelmet.setDisplayName(new StringTextComponent("\247b\247lUltra Diamond Echo Helmet"));
                spawnAsEntity(world, pos, ultraDiamondEchoHelmet);
                break;
            case 65:
                ItemStack ultraDiamondEchoChestplate = new ItemStack(ProjectEchoArmor.DIAMOND_INFUSED_ECHO_CHESTPLATE.get());
                ultraDiamondEchoChestplate.addEnchantment(Enchantments.PROTECTION, MathUtil.getRandomInt(1, 4));
                ultraDiamondEchoChestplate.addEnchantment(Enchantments.UNBREAKING, MathUtil.getRandomInt(1, 3));
                ultraDiamondEchoChestplate.addEnchantment(Enchantments.THORNS, MathUtil.getRandomInt(1, 2));
                ultraDiamondEchoChestplate.setDisplayName(new StringTextComponent("\247b\247lUltra Diamond Echo Chestplate"));
                spawnAsEntity(world, pos, ultraDiamondEchoChestplate);
                break;
            case 66:
                ItemStack ultraDiamondEchoTrousers = new ItemStack(ProjectEchoArmor.DIAMOND_INFUSED_ECHO_TROUSERS.get());
                ultraDiamondEchoTrousers.addEnchantment(Enchantments.PROTECTION, MathUtil.getRandomInt(1, 4));
                ultraDiamondEchoTrousers.addEnchantment(Enchantments.UNBREAKING, MathUtil.getRandomInt(1, 3));
                ultraDiamondEchoTrousers.addEnchantment(Enchantments.THORNS, MathUtil.getRandomInt(1, 2));
                ultraDiamondEchoTrousers.setDisplayName(new StringTextComponent("\247b\247lUltra Diamond Echo Trousers"));
                spawnAsEntity(world, pos, ultraDiamondEchoTrousers);
                break;
            case 67:
                ItemStack ultraDiamondEchoBoots = new ItemStack(ProjectEchoArmor.DIAMOND_INFUSED_ECHO_BOOTS.get());
                ultraDiamondEchoBoots.addEnchantment(Enchantments.PROTECTION, MathUtil.getRandomInt(1, 4));
                ultraDiamondEchoBoots.addEnchantment(Enchantments.UNBREAKING, MathUtil.getRandomInt(1, 3));
                ultraDiamondEchoBoots.addEnchantment(Enchantments.THORNS, MathUtil.getRandomInt(1, 2));
                ultraDiamondEchoBoots.setDisplayName(new StringTextComponent("\247b\247lUltra Diamond Echo Boots"));
                spawnAsEntity(world, pos, ultraDiamondEchoBoots);
                break;
            case 68:
                ItemStack ultraDiamondEchoPickaxe = new ItemStack(ProjectEchoTools.DIAMOND_INFUSED_ECHO_PICKAXE.get());
                ultraDiamondEchoPickaxe.addEnchantment(Enchantments.EFFICIENCY, MathUtil.getRandomInt(1, 4));
                ultraDiamondEchoPickaxe.addEnchantment(Enchantments.UNBREAKING, MathUtil.getRandomInt(1, 3));
                ultraDiamondEchoPickaxe.addEnchantment(Enchantments.FORTUNE, MathUtil.getRandomInt(1, 3));
                ultraDiamondEchoPickaxe.setDisplayName(new StringTextComponent("\247b\247lUltra Diamond Echo Pickaxe"));
                spawnAsEntity(world, pos, ultraDiamondEchoPickaxe);
                break;
            case 69:
                ItemStack ultraCarbonEchoSword = new ItemStack(ProjectEchoTools.CARBON_INFUSED_ECHO_SWORD.get());
                ultraCarbonEchoSword.addEnchantment(Enchantments.SHARPNESS, MathUtil.getRandomInt(1, 5));
                ultraCarbonEchoSword.addEnchantment(Enchantments.KNOCKBACK, MathUtil.getRandomInt(1, 3));
                ultraCarbonEchoSword.addEnchantment(Enchantments.UNBREAKING, MathUtil.getRandomInt(1, 3));
                ultraCarbonEchoSword.addEnchantment(Enchantments.LOOTING, MathUtil.getRandomInt(1, 3));
                ultraCarbonEchoSword.setDisplayName(new StringTextComponent("\247b\247lUltra Carbon Echo Sword"));
                spawnAsEntity(world, pos, ultraCarbonEchoSword);
                break;
            case 70:
                ItemStack ultraCarbonEchoHelmet = new ItemStack(ProjectEchoArmor.CARBON_INFUSED_ECHO_HELMET.get());
                ultraCarbonEchoHelmet.addEnchantment(Enchantments.PROTECTION, MathUtil.getRandomInt(1, 4));
                ultraCarbonEchoHelmet.addEnchantment(Enchantments.UNBREAKING, MathUtil.getRandomInt(1, 3));
                ultraCarbonEchoHelmet.addEnchantment(Enchantments.THORNS, MathUtil.getRandomInt(1, 2));
                ultraCarbonEchoHelmet.setDisplayName(new StringTextComponent("\247b\247lUltra Carbon Echo Helmet"));
                spawnAsEntity(world, pos, ultraCarbonEchoHelmet);
                break;
            case 71:
                ItemStack ultraCarbonEchoChestplate = new ItemStack(ProjectEchoArmor.CARBON_INFUSED_ECHO_CHESTPLATE.get());
                ultraCarbonEchoChestplate.addEnchantment(Enchantments.PROTECTION, MathUtil.getRandomInt(1, 4));
                ultraCarbonEchoChestplate.addEnchantment(Enchantments.UNBREAKING, MathUtil.getRandomInt(1, 3));
                ultraCarbonEchoChestplate.addEnchantment(Enchantments.THORNS, MathUtil.getRandomInt(1, 2));
                ultraCarbonEchoChestplate.setDisplayName(new StringTextComponent("\247b\247lUltra Carbon Echo Chestplate"));
                spawnAsEntity(world, pos, ultraCarbonEchoChestplate);
                break;
            case 72:
                ItemStack ultraCarbonEchoTrousers = new ItemStack(ProjectEchoArmor.CARBON_INFUSED_ECHO_TROUSERS.get());
                ultraCarbonEchoTrousers.addEnchantment(Enchantments.PROTECTION, MathUtil.getRandomInt(1, 4));
                ultraCarbonEchoTrousers.addEnchantment(Enchantments.UNBREAKING, MathUtil.getRandomInt(1, 3));
                ultraCarbonEchoTrousers.addEnchantment(Enchantments.THORNS, MathUtil.getRandomInt(1, 2));
                ultraCarbonEchoTrousers.setDisplayName(new StringTextComponent("\247b\247lUltra Carbon Echo Trousers"));
                spawnAsEntity(world, pos, ultraCarbonEchoTrousers);
                break;
            case 73:
                ItemStack ultraCarbonEchoBoots = new ItemStack(ProjectEchoArmor.CARBON_INFUSED_ECHO_BOOTS.get());
                ultraCarbonEchoBoots.addEnchantment(Enchantments.PROTECTION, MathUtil.getRandomInt(1, 4));
                ultraCarbonEchoBoots.addEnchantment(Enchantments.UNBREAKING, MathUtil.getRandomInt(1, 3));
                ultraCarbonEchoBoots.addEnchantment(Enchantments.THORNS, MathUtil.getRandomInt(1, 2));
                ultraCarbonEchoBoots.setDisplayName(new StringTextComponent("\247b\247lUltra Carbon Echo Boots"));
                spawnAsEntity(world, pos, ultraCarbonEchoBoots);
                break;
            case 74:
                ItemStack ultraCarbonEchoPickaxe = new ItemStack(ProjectEchoTools.CARBON_INFUSED_ECHO_PICKAXE.get());
                ultraCarbonEchoPickaxe.addEnchantment(Enchantments.EFFICIENCY, MathUtil.getRandomInt(1, 4));
                ultraCarbonEchoPickaxe.addEnchantment(Enchantments.UNBREAKING, MathUtil.getRandomInt(1, 3));
                ultraCarbonEchoPickaxe.addEnchantment(Enchantments.FORTUNE, MathUtil.getRandomInt(1, 3));
                ultraCarbonEchoPickaxe.setDisplayName(new StringTextComponent("\247b\247lUltra Carbon Echo Pickaxe"));
                spawnAsEntity(world, pos, ultraCarbonEchoPickaxe);
                break;
            case 75:
                List<EffectInstance> powerUpEffects = new ArrayList<>();
                List<EffectInstance> chosenPowerUpEffects = new ArrayList<>();
                powerUpEffects.add(new EffectInstance(Effects.STRENGTH, MathUtil.getRandomInt(3000, 9000), MathUtil.getRandomInt(0, 5)));
                powerUpEffects.add(new EffectInstance(Effects.REGENERATION, MathUtil.getRandomInt(3000, 9000), MathUtil.getRandomInt(0, 5)));
                powerUpEffects.add(new EffectInstance(Effects.RESISTANCE, MathUtil.getRandomInt(3000, 9000), MathUtil.getRandomInt(0, 5)));
                powerUpEffects.add(new EffectInstance(Effects.SATURATION, MathUtil.getRandomInt(3000, 9000), MathUtil.getRandomInt(0, 5)));
                powerUpEffects.add(new EffectInstance(Effects.INVISIBILITY, MathUtil.getRandomInt(3000, 9000), MathUtil.getRandomInt(0, 5)));
                powerUpEffects.add(new EffectInstance(Effects.INSTANT_HEALTH, MathUtil.getRandomInt(3000, 9000), MathUtil.getRandomInt(0, 5)));
                powerUpEffects.add(new EffectInstance(Effects.DOLPHINS_GRACE, MathUtil.getRandomInt(3000, 9000), MathUtil.getRandomInt(0, 5)));
                powerUpEffects.add(new EffectInstance(Effects.HASTE, MathUtil.getRandomInt(3000, 9000), MathUtil.getRandomInt(0, 5)));
                powerUpEffects.add(new EffectInstance(Effects.SPEED, MathUtil.getRandomInt(3000, 9000), MathUtil.getRandomInt(0, 5)));
                powerUpEffects.add(new EffectInstance(Effects.JUMP_BOOST, MathUtil.getRandomInt(3000, 9000), MathUtil.getRandomInt(0, 5)));
                powerUpEffects.add(new EffectInstance(Effects.LUCK, MathUtil.getRandomInt(3000, 9000), MathUtil.getRandomInt(0, 5)));
                powerUpEffects.add(new EffectInstance(Effects.NIGHT_VISION, MathUtil.getRandomInt(3000, 9000), MathUtil.getRandomInt(0, 5)));
                powerUpEffects.add(new EffectInstance(Effects.WATER_BREATHING, MathUtil.getRandomInt(3000, 9000), MathUtil.getRandomInt(0, 5)));
                powerUpEffects.add(new EffectInstance(Effects.HEALTH_BOOST, MathUtil.getRandomInt(3000, 9000), MathUtil.getRandomInt(0, 5)));
                powerUpEffects.add(new EffectInstance(Effects.CONDUIT_POWER, MathUtil.getRandomInt(3000, 9000), MathUtil.getRandomInt(0, 5)));

                for (EffectInstance effect : powerUpEffects) {
                    double randomDouble = MathUtil.getRandomDouble(0, 1.0);
                    if (randomDouble > 0.5) {
                        chosenPowerUpEffects.add(effect);
                    }
                }

                ItemStack powerUp = new ItemStack(Items.POTION);
                PotionUtils.addPotionToItemStack(powerUp, Potions.HEALING);
                PotionUtils.appendEffects(powerUp, chosenPowerUpEffects);
                powerUp.setDisplayName(new StringTextComponent("\2479\247lUltra PowerUp Potion"));
                world.addEntity(new ItemEntity(world, pos.getX() + 1, pos.getY(), pos.getZ() + 1, powerUp));
                break;
            case 76:
                List<EffectInstance> chemXEffects = new ArrayList<>();
                List<EffectInstance> chosenChemXEffects = new ArrayList<>();
                chemXEffects.add(new EffectInstance(Effects.INSTANT_DAMAGE, MathUtil.getRandomInt(3000, 9000), MathUtil.getRandomInt(0, 5)));
                chemXEffects.add(new EffectInstance(Effects.WEAKNESS, MathUtil.getRandomInt(3000, 9000), MathUtil.getRandomInt(0, 5)));
                chemXEffects.add(new EffectInstance(Effects.BAD_OMEN, MathUtil.getRandomInt(3000, 9000), MathUtil.getRandomInt(0, 5)));
                chemXEffects.add(new EffectInstance(Effects.MINING_FATIGUE, MathUtil.getRandomInt(3000, 9000), MathUtil.getRandomInt(0, 3)));
                chemXEffects.add(new EffectInstance(Effects.BLINDNESS, MathUtil.getRandomInt(3000, 9000), MathUtil.getRandomInt(0, 5)));
                chemXEffects.add(new EffectInstance(Effects.POISON, MathUtil.getRandomInt(3000, 9000), MathUtil.getRandomInt(0, 5)));
                chemXEffects.add(new EffectInstance(Effects.WITHER, MathUtil.getRandomInt(3000, 9000), MathUtil.getRandomInt(0, 5)));
                chemXEffects.add(new EffectInstance(Effects.SLOWNESS, MathUtil.getRandomInt(3000, 9000), MathUtil.getRandomInt(0, 5)));
                chemXEffects.add(new EffectInstance(Effects.UNLUCK, MathUtil.getRandomInt(3000, 9000), MathUtil.getRandomInt(0, 5)));
                chemXEffects.add(new EffectInstance(Effects.NAUSEA, MathUtil.getRandomInt(3000, 9000), MathUtil.getRandomInt(0, 5)));
                chemXEffects.add(new EffectInstance(Effects.HUNGER, MathUtil.getRandomInt(3000, 9000), MathUtil.getRandomInt(0, 5)));

                for (EffectInstance effect : chemXEffects) {
                    double randomDouble = MathUtil.getRandomDouble(0, 1.0);
                    if (randomDouble > 0.5) {
                        chosenChemXEffects.add(effect);
                    }
                }

                ItemStack chemX = new ItemStack(Items.SPLASH_POTION);
                PotionUtils.addPotionToItemStack(chemX, Potions.HARMING);
                PotionUtils.appendEffects(chemX, chosenChemXEffects);
                chemX.setDisplayName(new StringTextComponent("\247u\247lChemical X"));
                world.addEntity(new ItemEntity(world, pos.getX() + 1, pos.getY(), pos.getZ() + 1, chemX));
                break;
            case 77: {
                // Im putting all of these in curly brackets from now on
                // TODO Come back at a later date to add brackets to the rest of them
                // Adding brackets keeps everything properly separated
                CreeperEntity creeper = EntityType.CREEPER.create(world);
                if (creeper != null) {
                    creeper.setLocationAndAngles(
                            pos.getX() + 0.5,
                            pos.getY(),
                            pos.getZ() + 0.5,
                            world.rand.nextFloat() * 360,
                            0
                    );
                    world.addEntity(creeper);
                }
                break;
            }
            case 78: {
                for (int i = 0; i < MathUtil.getRandomInt(4, 100); i++) {
                    CreeperEntity creeper = EntityType.CREEPER.create(world);
                    if (creeper != null) {
                        creeper.setLocationAndAngles(
                                pos.getX() + 0.5,
                                pos.getY(),
                                pos.getZ() + 0.5,
                                world.rand.nextFloat() * 360,
                                0
                        );
                        world.addEntity(creeper);
                    }
                }
                break;
            }
            case 79: {
                EntityUtil.spawnFallingItems(world, Items.TNT, pos, 18, MathUtil.getRandomInt(8, 64), 4, "§4§lBoom Boom On A Stick");
                break;
            }
            case 80: {
                ItemStack item = new ItemStack(Items.RED_BED);
                item.setDisplayName(new StringTextComponent("§5§lBedwars"));
                world.addEntity(new ItemEntity(world, pos.getX() + 1, pos.getY(), pos.getZ() + 1, item));
                break;
            }
            case 81: {
                ItemStack item = new ItemStack(Items.PAPER);
                item.setDisplayName(new StringTextComponent("§lToilet Paper"));
                world.addEntity(new ItemEntity(world, pos.getX() + 1, pos.getY(), pos.getZ() + 1, item));
                break;
            }
            case 82: {
                ItemStack item = new ItemStack(ProjectEchoArmor.GOLD_INFUSED_ECHO_CHESTPLATE.get());
                item.setDisplayName(new StringTextComponent("§a§lCactus Chestplate"));
                item.addEnchantment(Enchantments.THORNS, 67);
                world.addEntity(new ItemEntity(world, pos.getX() + 1, pos.getY(), pos.getZ() + 1, item));
                break;
            }
            case 83: {
                ItemStack item = new ItemStack(ProjectEchoArmor.GOLD_INFUSED_ECHO_HELMET.get());
                item.setDisplayName(new StringTextComponent("§a§lCactus Helmet"));
                item.addEnchantment(Enchantments.THORNS, 67);
                world.addEntity(new ItemEntity(world, pos.getX() + 1, pos.getY(), pos.getZ() + 1, item));
                break;
            }
            case 84: {
                ItemStack item = new ItemStack(ProjectEchoArmor.GOLD_INFUSED_ECHO_TROUSERS.get());
                item.setDisplayName(new StringTextComponent("§a§lCactus Trousers"));
                item.addEnchantment(Enchantments.THORNS, 67);
                world.addEntity(new ItemEntity(world, pos.getX() + 1, pos.getY(), pos.getZ() + 1, item));
                break;
            }
            case 85: {
                ItemStack item = new ItemStack(ProjectEchoArmor.GOLD_INFUSED_ECHO_BOOTS.get());
                item.setDisplayName(new StringTextComponent("§a§lCactus Boots"));
                item.addEnchantment(Enchantments.THORNS, 67);
                world.addEntity(new ItemEntity(world, pos.getX() + 1, pos.getY(), pos.getZ() + 1, item));
                break;
            }
            case 86: {
                ItemStack item = new ItemStack(ProjectEchoTools.GOLD_INFUSED_ECHO_SWORD.get());
                item.setDisplayName(new StringTextComponent("§d§lA Sharp Sword"));
                item.addEnchantment(Enchantments.SHARPNESS, 25);
                world.addEntity(new ItemEntity(world, pos.getX() + 1, pos.getY(), pos.getZ() + 1, item));
                break;
            }
            case 87: {
                ItemStack item = new ItemStack(Items.STICK);
                item.setDisplayName(new StringTextComponent("§7§lToothpick"));
                item.addEnchantment(Enchantments.SHARPNESS, 20);
                world.addEntity(new ItemEntity(world, pos.getX() + 1, pos.getY(), pos.getZ() + 1, item));
                break;
            }
            case 88: {
                ItemStack item = new ItemStack(Items.STICK);
                item.setDisplayName(new StringTextComponent("§8§lEl Boost"));
                item.addEnchantment(Enchantments.KNOCKBACK, 100);
                world.addEntity(new ItemEntity(world, pos.getX() + 1, pos.getY(), pos.getZ() + 1, item));
                break;
            }
            case 89: {
                ItemStack item = new ItemStack(Items.CARROT);
                item.setDisplayName(new StringTextComponent("§4§lRed Hot Chili Pepper?"));
                item.addEnchantment(Enchantments.FIRE_ASPECT, 91);
                world.addEntity(new ItemEntity(world, pos.getX() + 1, pos.getY(), pos.getZ() + 1, item));
                break;
            }
            case 90: {
                BlockUtil.spawnOneByOneFallingBlockTower(world, Blocks.DIRT, pos.getX(), pos.getY(), pos.getZ(), 21, 8);
                break;
            }
            case 91: {
                BlockUtil.spawnOneByOneFallingBlockTower(world, Blocks.HAY_BLOCK, pos.getX(), pos.getY(), pos.getZ(), 21, 8);
                break;
            }
            case 92: {
                BlockUtil.spawnOneByOneFallingBlockTower(world, Blocks.COAL_BLOCK, pos.getX(), pos.getY(), pos.getZ(), 21, 8);
                break;
            }
            case 93: {
                BlockUtil.spawnOneByOneFallingBlockTower(world, Blocks.NETHER_QUARTZ_ORE, pos.getX(), pos.getY(), pos.getZ(), 21, 8);
                break;
            }
            case 94: {
                BlockUtil.spawnFallingBlockGrid(world, Blocks.LAVA, true, pos.getX(), pos.getY(), pos.getZ(), 9, 9);
                break;
            }
            case 95: {
                BlockUtil.spawnFallingBlockGrid(world, Blocks.WATER, true, pos.getX(), pos.getY(), pos.getZ(), 9, 9);
                break;
            }
        }
    }
}
