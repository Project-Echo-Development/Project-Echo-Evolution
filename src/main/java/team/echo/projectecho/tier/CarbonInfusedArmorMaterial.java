package team.echo.projectecho.tier;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.registries.ForgeRegistries;
import team.echo.projectecho.core.ProjectEchoCrafting;

public class CarbonInfusedArmorMaterial implements IArmorMaterial {

    public static final IArmorMaterial CARBON = new CarbonInfusedArmorMaterial();

    @Override
    public int getDurability(EquipmentSlotType equipmentSlotType) {
        switch (equipmentSlotType) {
            case HEAD:
                return 4250;
            case CHEST:
                return 5000;
            case LEGS:
                return 4500;
            case FEET:
                return 4200;
            default:
                return 0;
        }
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType equipmentSlotType) {
        switch (equipmentSlotType) {
            case HEAD:
                return 30;
            case CHEST:
                return 42;
            case LEGS:
                return 36;
            case FEET:
                return 28;
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
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron"));
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(ProjectEchoCrafting.BASIC_ECHO_CORE.get());
    }

    @Override
    public String getName() {
        return "carbon";
    }

    @Override
    public float getToughness() {
        return 24;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.2f;
    }
}
