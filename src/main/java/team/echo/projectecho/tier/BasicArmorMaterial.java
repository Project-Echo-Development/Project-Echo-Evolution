package team.echo.projectecho.tier;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.registries.ForgeRegistries;
import team.echo.projectecho.core.ProjectEchoCrafting;

public class BasicArmorMaterial implements IArmorMaterial {

    public static final IArmorMaterial BASIC = new BasicArmorMaterial();

    @Override
    public int getDurability(EquipmentSlotType equipmentSlotType) {
        switch (equipmentSlotType) {
            case HEAD:
                return 400;
            case CHEST:
                return 600;
            case LEGS:
                return 500;
            case FEET:
                return 450;
            default:
                return 0;
        }
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType equipmentSlotType) {
        switch (equipmentSlotType) {
            case HEAD:
                return 3;
            case CHEST:
                return 7;
            case LEGS:
                return 5;
            case FEET:
                return 3;
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
        return Ingredient.fromItems(ProjectEchoCrafting.ECHO_INGOT.get());
    }

    @Override
    public String getName() {
        return "basic";
    }

    @Override
    public float getToughness() {
        return 2;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.1f;
    }
}
