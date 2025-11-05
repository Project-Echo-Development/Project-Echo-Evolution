package team.echo.projectecho.armor;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.*;
import team.echo.projectecho.tier.BasicArmorMaterial;

import javax.annotation.Nullable;

public class ItemBasicArmor extends ArmorItem {
    public ItemBasicArmor(EquipmentSlotType slotType, Properties properties) {
        super(new BasicArmorMaterial(), slotType, properties);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return "projectecho:textures/models/armor/basic_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
    }
}
