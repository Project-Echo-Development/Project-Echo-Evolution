package team.echo.projectecho.armor;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import team.echo.projectecho.tier.CarbonInfusedArmorMaterial;
import team.echo.projectecho.tier.GoldInfusedArmorMaterial;

public class ItemCarbonInfusedArmor extends ArmorItem {
    public ItemCarbonInfusedArmor(EquipmentSlotType slotType, Properties properties) {
        super(new CarbonInfusedArmorMaterial(), slotType, properties);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return "projectecho:textures/models/armor/carbon_infused_echo_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
    }
}
