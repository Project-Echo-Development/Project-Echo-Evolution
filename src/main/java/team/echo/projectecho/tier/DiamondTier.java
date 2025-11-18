package team.echo.projectecho.tier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import team.echo.projectecho.core.ProjectEchoCrafting;

public class DiamondTier implements IItemTier {

    @Override
    public int getMaxUses() {
        return 2400;
    }

    @Override
    public float getEfficiency() {
        return 12f;
    }

    @Override
    public float getAttackDamage() {
        return 36.0f;
    }

    @Override
    public int getHarvestLevel() {
        return 8;
    }

    @Override
    public int getEnchantability() {
        return 16;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(ProjectEchoCrafting.DIAMOND_INFUSED_ECHO_INGOT.get());
    }
}
