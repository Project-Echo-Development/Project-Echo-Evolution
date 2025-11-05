package team.echo.projectecho.crafting;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;

public class ItemCarbonEchoIngot extends Item {
    public ItemCarbonEchoIngot() {
        super(new Properties().group(ItemGroup.MATERIALS).maxStackSize(64).rarity(Rarity.UNCOMMON));
    }
}
