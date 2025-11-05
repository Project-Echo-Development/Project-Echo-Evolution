package team.echo.projectecho.tools;

import net.minecraft.item.IItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.SwordItem;

public class ItemBasicPickaxe extends PickaxeItem {
    public ItemBasicPickaxe(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties properties) {
        super(tier, attackDamageIn, attackSpeedIn, properties);
    }
}
