package team.echo.projectecho.tier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import team.echo.projectecho.core.ProjectEchoCrafting;

public class GoldTier implements IItemTier {

    @Override
    public int getMaxUses() {
        return 600;
    }

    @Override
    public float getEfficiency() {
        return 9f;
    }

    @Override
    public float getAttackDamage() {
        return 6.0f;
    }

    @Override
    public int getHarvestLevel() {
        return 5;
    }

    @Override
    public int getEnchantability() {
        return 16;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(ProjectEchoCrafting.GOLD_INFUSED_ECHO_INGOT.get());
    }
}
