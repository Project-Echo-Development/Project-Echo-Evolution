package team.echo.projectecho.event;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.text.Color;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import team.echo.projectecho.ProjectEcho;

import java.awt.*;

@Mod.EventBusSubscriber(modid = ProjectEcho.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class TooltipEventHandler {

    @SubscribeEvent
    public static void onItemTooptip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();

        // Shooting star
        if (stack.hasTag() && stack.getTag() != null) {
            if (stack.getTag().contains("ShootingStar")) {
                String tooltipText = stack.getTag().getString("ShootingStar");
                event.getToolTip().add(new StringTextComponent(tooltipText).setStyle(Style.EMPTY.setColor(Color.fromTextFormatting(TextFormatting.LIGHT_PURPLE))));
            }
            if (stack.getTag().contains("SPR34")) {
                String tooltipText = stack.getTag().getString("SPR34");
                event.getToolTip().add(new StringTextComponent(tooltipText).setStyle(Style.EMPTY.setColor(Color.fromTextFormatting(TextFormatting.YELLOW))));
            }
        }
    }
}
