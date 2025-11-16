package team.echo.projectecho.tier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import team.echo.projectecho.core.ProjectEchoCrafting;

public class CarbonTier implements IItemTier {

    @Override
    public int getMaxUses() {
        return 800;
    }

    @Override
    public float getEfficiency() {
        return 10f;
    }

    @Override
    public float getAttackDamage() {
        return 40.0f;
    }

    @Override
    public int getHarvestLevel() {
        return 6;
    }

    @Override
    public int getEnchantability() {
        return 16;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(ProjectEchoCrafting.CARBON_INFUSED_ECHO_INGOT.get());
    }
}
