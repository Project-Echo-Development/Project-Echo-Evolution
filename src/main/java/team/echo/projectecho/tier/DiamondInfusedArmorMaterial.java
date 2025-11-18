package team.echo.projectecho.tier;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.registries.ForgeRegistries;
import team.echo.projectecho.core.ProjectEchoCrafting;

import java.util.Objects;

public class DiamondInfusedArmorMaterial implements IArmorMaterial {

    public static final IArmorMaterial BASIC = new DiamondInfusedArmorMaterial();

    @Override
    public int getDurability(EquipmentSlotType equipmentSlotType) {
        switch (equipmentSlotType) {
            case HEAD:
                return 2100;
            case CHEST:
                return 2800;
            case LEGS:
                return 2400;
            case FEET:
                return 2000;
            default:
                return 0;
        }
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType equipmentSlotType) {
        switch (equipmentSlotType) {
            case FEET:
            case HEAD:
                return 21;
            case CHEST:
                return 27;
            case LEGS:
                return 24;
            default:
                return 0;
        }
    }

    @Override
    public int getEnchantability() {
        return 16;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron")));
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(ProjectEchoCrafting.DIAMOND_INFUSED_ECHO_INGOT.get());
    }

    @Override
    public String getName() {
        return "diamondinfused";
    }

    @Override
    public float getToughness() {
        return 12;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.25f;
    }
}
