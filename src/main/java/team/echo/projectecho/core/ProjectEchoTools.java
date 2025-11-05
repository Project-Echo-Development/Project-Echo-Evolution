package team.echo.projectecho.core;

import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import team.echo.projectecho.ProjectEcho;
import team.echo.projectecho.crafting.ItemBasicCore;
import team.echo.projectecho.tier.BasicTier;
import team.echo.projectecho.tier.CarbonTier;
import team.echo.projectecho.tier.DiamondTier;
import team.echo.projectecho.tier.GoldTier;
import team.echo.projectecho.tools.ItemBasicPickaxe;
import team.echo.projectecho.tools.ItemBasicSword;

public class ProjectEchoTools {
    // Registry to register mod tools
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ProjectEcho.MOD_ID);

    // Register Items Below
    // Tier: Basic
    public static final RegistryObject<Item> BASIC_ECHO_SWORD = REGISTRY.register("basic_echo_sword", () -> new ItemBasicSword(new BasicTier(),
            2, -2.4f, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> BASIC_ECHO_PICKAXE = REGISTRY.register("basic_echo_pickaxe", () -> new ItemBasicPickaxe(new BasicTier(),
            0, -2.8f, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> BASIC_ECHO_AXE = REGISTRY.register("basic_echo_axe", () -> new AxeItem(new BasicTier(),
            5, -3f, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> BASIC_ECHO_SPADE = REGISTRY.register("basic_echo_spade", () -> new ShovelItem(new BasicTier(),
            -1, -3f, new Item.Properties().group(ItemGroup.TOOLS)));

    // Tier: Gold Infused
    public static final RegistryObject<Item> GOLD_INFUSED_ECHO_SWORD = REGISTRY.register("gold_infused_echo_sword", () -> new SwordItem(new GoldTier(),
            2, -2.4f, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> GOLD_INFUSED_ECHO_PICKAXE = REGISTRY.register("gold_infused_echo_pickaxe", () -> new PickaxeItem(new GoldTier(),
            0, -2.8f, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> GOLD_INFUSED_ECHO_AXE = REGISTRY.register("gold_infused_echo_axe", () -> new AxeItem(new GoldTier(),
            5, -3f, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> GOLD_INFUSED_ECHO_SPADE = REGISTRY.register("gold_infused_echo_spade", () -> new ShovelItem(new GoldTier(),
            -1, -3f, new Item.Properties().group(ItemGroup.TOOLS)));

    // Tier: Carbon Infused
    public static final RegistryObject<Item> CARBON_INFUSED_ECHO_SWORD = REGISTRY.register("carbon_infused_echo_sword", () -> new SwordItem(new CarbonTier(),
            2, -2.4f, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> CARBON_INFUSED_ECHO_PICKAXE = REGISTRY.register("carbon_infused_echo_pickaxe", () -> new PickaxeItem(new CarbonTier(),
            0, -2.8f, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> CARBON_INFUSED_ECHO_AXE = REGISTRY.register("carbon_infused_echo_axe", () -> new AxeItem(new CarbonTier(),
            5, -3f, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> CARBON_INFUSED_ECHO_SPADE = REGISTRY.register("carbon_infused_echo_spade", () -> new ShovelItem(new CarbonTier(),
            -1, -3f, new Item.Properties().group(ItemGroup.TOOLS)));

    // Tier: Diamond Infused
    public static final RegistryObject<Item> DIAMOND_INFUSED_ECHO_SWORD = REGISTRY.register("diamond_infused_echo_sword", () -> new SwordItem(new DiamondTier(),
            2, -2.4f, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> DIAMOND_INFUSED_ECHO_PICKAXE = REGISTRY.register("diamond_infused_echo_pickaxe", () -> new PickaxeItem(new DiamondTier(),
            0, -2.8f, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> DIAMOND_INFUSED_ECHO_AXE = REGISTRY.register("diamond_infused_echo_axe", () -> new AxeItem(new DiamondTier(),
            5, -3f, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> DIAMOND_INFUSED_ECHO_SPADE = REGISTRY.register("diamond_infused_echo_spade", () -> new ShovelItem(new DiamondTier(),
            -1, -3f, new Item.Properties().group(ItemGroup.TOOLS)));
}
