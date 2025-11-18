package team.echo.projectecho.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import team.echo.projectecho.core.ProjectEchoArmor;
import team.echo.projectecho.core.ProjectEchoCrafting;
import team.echo.projectecho.core.ProjectEchoTools;

import java.util.Random;

public class EntityUtil {

    public static void summonMultipleZombies(World world, BlockPos pos, int count) {
        if (!world.isRemote) {
            for (int i = 0; i < count; i++) {
                double offsetX = (world.getRandom().nextDouble() - 0.5) * 5.0;
                double offsetZ = (world.getRandom().nextDouble() - 0.5) * 5.0;
                ZombieEntity zombie = new ZombieEntity(world);
                zombie.setPosition(pos.getX() + 0.5 + offsetX, pos.getY(), pos.getZ() + 0.5 + offsetZ);
                world.addEntity(zombie);
            }
        }
    }

    public static void summonMultipleCats(World world, BlockPos pos, PlayerEntity tamedTo, boolean armored, boolean tamed, int count) {
        if (!world.isRemote) {
            for (int i = 0; i < count; i++) {
                double offsetX = (world.getRandom().nextDouble() - 0.5) * 5.0;
                double offsetZ = (world.getRandom().nextDouble() - 0.5) * 5.0;

                CatEntity cat = new CatEntity(EntityType.CAT, world);
                cat.setPosition(pos.getX() + 0.5 + offsetX, pos.getY(), pos.getZ() + 0.5 + offsetZ);

                if (armored) {
                    ItemStack enchantedHelmet = new ItemStack(ProjectEchoArmor.BASIC_ECHO_HELMET.get());
                    enchantedHelmet.addEnchantment(Enchantments.PROTECTION, 3);
                    enchantedHelmet.addEnchantment(Enchantments.THORNS, 1);

                    ItemStack enchantedChestplate = new ItemStack(ProjectEchoArmor.BASIC_ECHO_CHESTPLATE.get());
                    enchantedChestplate.addEnchantment(Enchantments.PROTECTION, 3);
                    enchantedChestplate.addEnchantment(Enchantments.THORNS, 1);

                    ItemStack enchantedLeggings = new ItemStack(ProjectEchoArmor.BASIC_ECHO_LEGGINGS.get());
                    enchantedLeggings.addEnchantment(Enchantments.PROTECTION, 3);
                    enchantedLeggings.addEnchantment(Enchantments.THORNS, 1);

                    ItemStack enchantedBoots = new ItemStack(ProjectEchoArmor.BASIC_ECHO_BOOTS.get());
                    enchantedBoots.addEnchantment(Enchantments.PROTECTION, 3);
                    enchantedBoots.addEnchantment(Enchantments.THORNS, 1);

                    cat.setItemStackToSlot(EquipmentSlotType.HEAD, enchantedHelmet);
                    cat.setItemStackToSlot(EquipmentSlotType.CHEST, enchantedChestplate);
                    cat.setItemStackToSlot(EquipmentSlotType.LEGS, enchantedLeggings);
                    cat.setItemStackToSlot(EquipmentSlotType.FEET, enchantedBoots);
                }

                if (tamed) {
                    cat.setTamed(true);
                    cat.setSitting(true);
                    if (tamedTo != null)
                        cat.setTamedBy(tamedTo);
                }

                cat.setCustomName(new StringTextComponent("\247d\247lEl Gato Army"));
                world.addParticle(ParticleTypes.HEART, pos.getX() + offsetX, pos.getY() + 1, pos.getZ() + offsetZ, 0, 0, 0);
                world.addEntity(cat);
            }
        }
    }

    @Deprecated
    public static void spawnZombieWithEnchantedGear(World world, BlockPos pos) {
        if (!world.isRemote) {
            ZombieEntity zombie = new ZombieEntity(world);
            zombie.setPosition(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);

            ItemStack enchantedSword = new ItemStack(ProjectEchoTools.BASIC_ECHO_SWORD.get());
            enchantedSword.addEnchantment(Enchantments.SHARPNESS, 5); // Sharpness V
            enchantedSword.addEnchantment(Enchantments.KNOCKBACK, 5); // Sharpness V
            enchantedSword.addEnchantment(Enchantments.UNBREAKING, 3); // Unbreaking III

            ItemStack enchantedHelmet = new ItemStack(ProjectEchoArmor.BASIC_ECHO_HELMET.get());
            enchantedHelmet.addEnchantment(Enchantments.PROTECTION, 3);
            enchantedHelmet.addEnchantment(Enchantments.THORNS, 1);

            ItemStack enchantedChestplate = new ItemStack(ProjectEchoArmor.BASIC_ECHO_CHESTPLATE.get());
            enchantedChestplate.addEnchantment(Enchantments.PROTECTION, 3);
            enchantedChestplate.addEnchantment(Enchantments.THORNS, 1);

            ItemStack enchantedLeggings = new ItemStack(ProjectEchoArmor.BASIC_ECHO_LEGGINGS.get());
            enchantedLeggings.addEnchantment(Enchantments.PROTECTION, 3);
            enchantedLeggings.addEnchantment(Enchantments.THORNS, 1);

            ItemStack enchantedBoots = new ItemStack(ProjectEchoArmor.BASIC_ECHO_BOOTS.get());
            enchantedBoots.addEnchantment(Enchantments.PROTECTION, 3);
            enchantedBoots.addEnchantment(Enchantments.THORNS, 1);

            zombie.setItemStackToSlot(EquipmentSlotType.MAINHAND, enchantedSword);
            zombie.setItemStackToSlot(EquipmentSlotType.HEAD, enchantedHelmet);
            zombie.setItemStackToSlot(EquipmentSlotType.CHEST, enchantedChestplate);
            zombie.setItemStackToSlot(EquipmentSlotType.LEGS, enchantedLeggings);
            zombie.setItemStackToSlot(EquipmentSlotType.FEET, enchantedBoots);

            zombie.setCustomName(new StringTextComponent("\247b\247lHarris"));
            world.addEntity(zombie);
        }
    }

    // New method to replace the old one
    public static void spawnCustomZombieWithEnchantedGear(World world, BlockPos pos, String name, Item helmet, Item chestplate, Item pants, Item boots, Item weapon) {
        if (!world.isRemote) {
            ZombieEntity zombie = new ZombieEntity(world);
            zombie.setPosition(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);

            ItemStack enchantedSword = new ItemStack(weapon);
            enchantedSword.addEnchantment(Enchantments.SHARPNESS, 5); // Sharpness V
            enchantedSword.addEnchantment(Enchantments.KNOCKBACK, 5); // Sharpness V
            enchantedSword.addEnchantment(Enchantments.UNBREAKING, 3); // Unbreaking III

            ItemStack enchantedHelmet = new ItemStack(helmet);
            enchantedHelmet.addEnchantment(Enchantments.PROTECTION, 5);
            enchantedHelmet.addEnchantment(Enchantments.THORNS, 1);

            ItemStack enchantedChestplate = new ItemStack(chestplate);
            enchantedChestplate.addEnchantment(Enchantments.PROTECTION, 5);
            enchantedChestplate.addEnchantment(Enchantments.THORNS, 1);

            ItemStack enchantedLeggings = new ItemStack(pants);
            enchantedLeggings.addEnchantment(Enchantments.PROTECTION, 5);
            enchantedLeggings.addEnchantment(Enchantments.THORNS, 1);

            ItemStack enchantedBoots = new ItemStack(boots);
            enchantedBoots.addEnchantment(Enchantments.PROTECTION, 5);
            enchantedBoots.addEnchantment(Enchantments.THORNS, 1);

            zombie.setItemStackToSlot(EquipmentSlotType.MAINHAND, enchantedSword);
            zombie.setItemStackToSlot(EquipmentSlotType.HEAD, enchantedHelmet);
            zombie.setItemStackToSlot(EquipmentSlotType.CHEST, enchantedChestplate);
            zombie.setItemStackToSlot(EquipmentSlotType.LEGS, enchantedLeggings);
            zombie.setItemStackToSlot(EquipmentSlotType.FEET, enchantedBoots);

            zombie.setCustomName(new StringTextComponent(name));
            world.addEntity(zombie);
        }
    }

    public static void teleportPlayerUp(ServerPlayerEntity player, int blocksUp, boolean notify) {
        ServerWorld world = player.getServerWorld();
        double newX = player.getPosX();
        double newY = player.getPosY() + blocksUp;
        double newZ = player.getPosZ();

        // Make sure the target Y-coordinate is within bounds
        if (newY > world.getHeight()) {
            newY = world.getHeight();
        }

        // Teleport the player
        player.teleport(world, newX, newY, newZ, player.rotationYaw, player.rotationPitch);

        // Optionally send a message to the player
        if (notify)
            player.sendMessage(new StringTextComponent("You have been teleported up!"), player.getUniqueID());
    }

    public static void spawnFallingItems(World world, Item item, BlockPos pos, int up, int itemCount, int intervalTicks, String name) {
        Random random = new Random();
        for (int i = 0; i < itemCount; i++) {
            int delay = i * intervalTicks;
            TickScheduler.schedule(((ServerWorld) world).getWorld(), () -> {
                double xOffset = -1.5 + (3.0 * random.nextDouble());
                double zOffset = -1.5 + (3.0 * random.nextDouble());
                ItemStack itemStack = new ItemStack(item);
                if (!name.isEmpty())
                    itemStack.setDisplayName(new StringTextComponent(name));
                ItemEntity itemEntity = new ItemEntity(world, pos.getX() + 0.5 + xOffset, pos.getY() + up, pos.getZ() + 0.5 + zOffset, itemStack);
                itemEntity.setMotion(0, -0.1, 0);
                world.addEntity(itemEntity);
            }, delay);
        }
    }
}
