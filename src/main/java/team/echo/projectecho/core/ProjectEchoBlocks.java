package team.echo.projectecho.core;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import team.echo.projectecho.ProjectEcho;
import team.echo.projectecho.armor.ItemBasicArmor;
import team.echo.projectecho.blocks.LootBlock;

import java.util.function.Supplier;

public class ProjectEchoBlocks {
    // Registry to register mod blocks
    public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ProjectEcho.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ProjectEcho.MOD_ID);

    // Register Items Below
    public static final RegistryObject<Block> LOOT_BLOCK = registerBlock("loot_block",
            () -> new LootBlock(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0)));

    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> returnBlock = REGISTRY.register(name, block);
        registerBlockItem(name, returnBlock);
        return returnBlock;
    }

    public static <T extends Block> void registerBlockItem(String name, Supplier<T> block){
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
    }
}
