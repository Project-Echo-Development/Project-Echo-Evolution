package team.echo.projectecho.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potions;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import team.echo.projectecho.core.ProjectEchoArmor;
import team.echo.projectecho.core.ProjectEchoCrafting;
import team.echo.projectecho.core.ProjectEchoTools;
import team.echo.projectecho.utils.*;

import javax.annotation.ParametersAreNonnullByDefault;

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
            int random = MathUtil.getRandomInt(1, 43);
//            int random = 40;
            pickLoot(random, serverWorld, pos);
        }
    }

    private void pickLoot(int ran, World world, BlockPos pos) {
        PlayerEntity player = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 10, false);
        ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
        ChatUtil.broadcastMessage((ServerWorld) world, String.valueOf(ran));
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
                EntityUtil.spawnZombieWithEnchantedGear(((ServerWorld) world).getWorld(), pos);
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
                for (int i = 0; i < MathUtil.getRandomInt(8, 18); i++)
                    spawnAsEntity(world, pos, new net.minecraft.item.ItemStack(net.minecraft.item.Items.DIAMOND));
                for (int i = 0; i < MathUtil.getRandomInt(6, 16); i++)
                    spawnAsEntity(world, pos, new net.minecraft.item.ItemStack(Items.EMERALD));
                for (int i = 0; i < MathUtil.getRandomInt(10, 22); i++)
                    spawnAsEntity(world, pos, new net.minecraft.item.ItemStack(Items.GOLD_INGOT));
                for (int i = 0; i < MathUtil.getRandomInt(12, 24); i++)
                    spawnAsEntity(world, pos, new net.minecraft.item.ItemStack(Items.IRON_INGOT));
                BlockUtil.spawnFireworks(world, pos, .5);
                BlockUtil.spawnFireworks(world, pos, .5);
                break;
            case 31:
                for (int i = 0; i < MathUtil.getRandomInt(4, 10); i++)
                    spawnAsEntity(world, pos, new ItemStack(ProjectEchoCrafting.BASIC_ECHO_CORE.get()));
                for (int i = 0; i < MathUtil.getRandomInt(6, 12); i++)
                    spawnAsEntity(world, pos, new ItemStack(ProjectEchoCrafting.ECHO_INGOT.get()));
                for (int i = 0; i < MathUtil.getRandomInt(4, 10); i++)
                    spawnAsEntity(world, pos, new ItemStack(ProjectEchoCrafting.GOLD_INFUSED_ECHO_CORE.get()));
                for (int i = 0; i < MathUtil.getRandomInt(6, 12); i++)
                    spawnAsEntity(world, pos, new ItemStack(ProjectEchoCrafting.GOLD_INFUSED_ECHO_INGOT.get()));
                BlockUtil.spawnFireworks(world, pos, .5);
                BlockUtil.spawnFireworks(world, pos, .5);
                break;
            case 32:
                if (serverPlayer != null)
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
                EntityUtil.spawnFallingItems(world, ProjectEchoCrafting.ECHO_INGOT.get(), pos, 18, MathUtil.getRandomInt(12, 18), 6);
                break;
            case 36:
                EntityUtil.spawnFallingItems(world, ProjectEchoCrafting.ECHO_INGOT.get(), pos, 18, MathUtil.getRandomInt(8, 14), 6);
                EntityUtil.spawnFallingItems(world, ProjectEchoCrafting.GOLD_INFUSED_ECHO_INGOT.get(), pos, 18, MathUtil.getRandomInt(6, 10), 6);
                break;
            case 37:
                EntityUtil.spawnCustomZombieWithEnchantedGear(((ServerWorld) world).getWorld(), pos, "\2476\247lGolden Harris",
                        ProjectEchoArmor.GOLD_INFUSED_ECHO_HELMET.get(), ProjectEchoArmor.GOLD_INFUSED_ECHO_CHESTPLATE.get(),
                        ProjectEchoArmor.GOLD_INFUSED_ECHO_TROUSERS.get(), ProjectEchoArmor.GOLD_INFUSED_ECHO_BOOTS.get(), ProjectEchoTools.GOLD_INFUSED_ECHO_SWORD.get());
                break;
            case 38:
                if (player != null)
                    BlockUtil.spawnFallingBlockGrid(world, Blocks.ANVIL, player.getPosX() - 1, player.getPosY(), player.getPosZ() - 1, 3, 3);
                break;
            case 39:
                if (player != null)
                    player.addPotionEffect(new EffectInstance(Effects.LEVITATION, 20, 30, false, false));
                break;
            case 40:
                if (player != null)
                    ContainerUtil.spawnChestWithItems(world, pos, ContainerUtil.ChestType.COMEONBRUHIJUSTWANTSOMEGOODLOOT, player);
                break;
            case 41:
                if (player != null)
                    ContainerUtil.spawnChestWithItems(world, pos, ContainerUtil.ChestType.MEH, player);
                break;
            case 42:
                if (player != null)
                    ContainerUtil.spawnChestWithItems(world, pos, ContainerUtil.ChestType.OMAHGAWD, player);
                break;
            case 43:
                if (player != null) {
                    Direction facing = player.getHorizontalFacing().getOpposite();
                    BlockState chestState = Blocks.CHEST.getDefaultState().with(BlockStateProperties.HORIZONTAL_FACING, facing);
                    world.setBlockState(pos, chestState, 3);
                }
                break;
        }
    }
}
