package team.echo.projectecho.tier;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.registries.ForgeRegistries;
import team.echo.projectecho.core.ProjectEchoCrafting;

public class GoldInfusedArmorMaterial implements IArmorMaterial {

    public static final IArmorMaterial GOLD = new GoldInfusedArmorMaterial();

    @Override
    public int getDurability(EquipmentSlotType equipmentSlotType) {
        switch (equipmentSlotType) {
            case HEAD:
                return 1200;
            case CHEST:
                return 2000;
            case LEGS:
                return 1600;
            case FEET:
                return 1100;
            default:
                return 0;
        }
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType equipmentSlotType) {
        switch (equipmentSlotType) {
            case FEET:
            case HEAD:
                return 9;
            case CHEST:
                return 18;
            case LEGS:
                return 15;
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
        return Ingredient.fromItems(ProjectEchoCrafting.GOLD_INFUSED_ECHO_INGOT.get());
    }

    @Override
    public String getName() {
        return "goldinfused";
    }

    @Override
    public float getToughness() {
        return 6;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.15f;
    }
}
