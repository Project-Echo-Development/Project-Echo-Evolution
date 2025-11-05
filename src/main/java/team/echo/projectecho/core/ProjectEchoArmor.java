package team.echo.projectecho.core;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import team.echo.projectecho.ProjectEcho;
import team.echo.projectecho.armor.ItemBasicArmor;
import team.echo.projectecho.armor.ItemCarbonInfusedArmor;
import team.echo.projectecho.armor.ItemDiamondInfusedArmor;
import team.echo.projectecho.armor.ItemGoldInfusedArmor;
import team.echo.projectecho.tier.BasicArmorMaterial;
import team.echo.projectecho.tier.BasicTier;

public class ProjectEchoArmor {
    // Registry to register mod armor
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ProjectEcho.MOD_ID);

    // Register Items Below
    // Tier: Basic
    public static final RegistryObject<Item> BASIC_ECHO_HELMET = REGISTRY.register("basic_echo_helmet",
            () -> new ItemBasicArmor(EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> BASIC_ECHO_CHESTPLATE = REGISTRY.register("basic_echo_chestplate",
            () -> new ItemBasicArmor(EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> BASIC_ECHO_LEGGINGS = REGISTRY.register("basic_echo_trousers",
            () -> new ItemBasicArmor(EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> BASIC_ECHO_BOOTS = REGISTRY.register("basic_echo_boots",
            () -> new ItemBasicArmor(EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));

    // Tier: Gold
    public static final RegistryObject<Item> GOLD_INFUSED_ECHO_HELMET = REGISTRY.register("gold_infused_echo_helmet",
            () -> new ItemGoldInfusedArmor(EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> GOLD_INFUSED_ECHO_CHESTPLATE = REGISTRY.register("gold_infused_echo_chestplate",
            () -> new ItemGoldInfusedArmor(EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> GOLD_INFUSED_ECHO_TROUSERS = REGISTRY.register("gold_infused_echo_trousers",
            () -> new ItemGoldInfusedArmor(EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> GOLD_INFUSED_ECHO_BOOTS = REGISTRY.register("gold_infused_echo_boots",
            () -> new ItemGoldInfusedArmor(EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));

    // Tier: Carbon
    public static final RegistryObject<Item> CARBON_INFUSED_ECHO_HELMET = REGISTRY.register("carbon_infused_echo_helmet",
            () -> new ItemCarbonInfusedArmor(EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> CARBON_INFUSED_ECHO_CHESTPLATE = REGISTRY.register("carbon_infused_echo_chestplate",
            () -> new ItemCarbonInfusedArmor(EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> CARBON_INFUSED_ECHO_TROUSERS = REGISTRY.register("carbon_infused_echo_trousers",
            () -> new ItemCarbonInfusedArmor(EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> CARBON_INFUSED_ECHO_BOOTS = REGISTRY.register("carbon_infused_echo_boots",
            () -> new ItemCarbonInfusedArmor(EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));

    // Tier: Diamond
    public static final RegistryObject<Item> DIAMOND_INFUSED_ECHO_HELMET = REGISTRY.register("diamond_infused_echo_helmet",
            () -> new ItemDiamondInfusedArmor(EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> DIAMOND_INFUSED_ECHO_CHESTPLATE = REGISTRY.register("diamond_infused_echo_chestplate",
            () -> new ItemDiamondInfusedArmor(EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> DIAMOND_INFUSED_ECHO_TROUSERS = REGISTRY.register("diamond_infused_echo_trousers",
            () -> new ItemDiamondInfusedArmor(EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> DIAMOND_INFUSED_ECHO_BOOTS = REGISTRY.register("diamond_infused_echo_boots",
            () -> new ItemDiamondInfusedArmor(EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));
}
