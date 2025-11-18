package team.echo.projectecho.tier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import team.echo.projectecho.core.ProjectEchoCrafting;

import java.util.function.Supplier;

public class BasicTier implements IItemTier {

    //BASIC(4, 400, 4.0f, 6.0f, 16, () -> Ingredient.fromItems(ProjectEchoCrafting.BASIC_ECHO_CORE.get()));
    @Override
    public int getMaxUses() {
        return 800;
    }

    @Override
    public float getEfficiency() {
        return 6.0f;
    }

    @Override
    public float getAttackDamage() {
        return 8.0f;
    }

    @Override
    public int getHarvestLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 16;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(ProjectEchoCrafting.ECHO_INGOT.get());
    }
}
