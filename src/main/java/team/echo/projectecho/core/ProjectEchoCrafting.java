package team.echo.projectecho.core;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import team.echo.projectecho.ProjectEcho;
import team.echo.projectecho.crafting.*;

public class ProjectEchoCrafting {
    // Registry to register mod crafting items
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ProjectEcho.MOD_ID);

    // Register Items Below
    public static final RegistryObject<Item> BASIC_ECHO_CORE = REGISTRY.register("basic_echo_core", ItemBasicCore::new);
    public static final RegistryObject<Item> GOLD_INFUSED_ECHO_CORE = REGISTRY.register("gold_infused_echo_core", ItemGoldCore::new);
    public static final RegistryObject<Item> ECHO_INGOT = REGISTRY.register("echo_ingot", ItemEchoIngot::new);
    public static final RegistryObject<Item> GOLD_INFUSED_ECHO_INGOT = REGISTRY.register("gold_infused_echo_ingot", ItemGoldEchoIngot::new);
    public static final RegistryObject<Item> CARBON_INFUSED_ECHO_INGOT = REGISTRY.register("carbon_infused_echo_ingot", ItemCarbonEchoIngot::new);
    public static final RegistryObject<Item> CARBON_INFUSED_ECHO_CORE = REGISTRY.register("carbon_infused_echo_core", ItemCarbonCore::new);
    public static final RegistryObject<Item> DIAMOND_INFUSED_ECHO_INGOT = REGISTRY.register("diamond_infused_echo_ingot", ItemDiamondEchoIngot::new);
    public static final RegistryObject<Item> DIAMOND_INFUSED_ECHO_CORE = REGISTRY.register("diamond_infused_echo_core", ItemDiamondCore::new);

}
