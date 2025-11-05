package team.echo.projectecho.crafting;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;

public class ItemBasicCore extends Item {
    public ItemBasicCore() {
        super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
    }
}
