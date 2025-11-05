package team.echo.projectecho.armor;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import team.echo.projectecho.tier.CarbonInfusedArmorMaterial;
import team.echo.projectecho.tier.DiamondInfusedArmorMaterial;

public class ItemDiamondInfusedArmor extends ArmorItem {
    public ItemDiamondInfusedArmor(EquipmentSlotType slotType, Properties properties) {
        super(new DiamondInfusedArmorMaterial(), slotType, properties);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return "projectecho:textures/models/armor/diamond_infused_echo_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
    }
}
