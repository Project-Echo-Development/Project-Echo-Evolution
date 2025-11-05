package team.echo.projectecho.crafting;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;

public class ItemDiamondEchoIngot extends Item {
    public ItemDiamondEchoIngot() {
        super(new Properties().group(ItemGroup.MATERIALS).maxStackSize(64).rarity(Rarity.RARE));
    }
}
