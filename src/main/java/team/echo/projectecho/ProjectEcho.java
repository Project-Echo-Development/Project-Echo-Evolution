package team.echo.projectecho;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import team.echo.projectecho.core.ProjectEchoArmor;
import team.echo.projectecho.core.ProjectEchoBlocks;
import team.echo.projectecho.core.ProjectEchoCrafting;
import team.echo.projectecho.core.ProjectEchoTools;
import team.echo.projectecho.event.TooltipEventHandler;
import team.echo.projectecho.zoom.QuickZoom;

@Mod(ProjectEcho.MOD_ID)
public class ProjectEcho
{
    public static final String MOD_ID = "projectecho";
    private QuickZoom zoomMod;

    public ProjectEcho() {
        MinecraftForge.EVENT_BUS.register(this);
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ProjectEchoCrafting.REGISTRY.register(eventBus);
        ProjectEchoTools.REGISTRY.register(eventBus);
        ProjectEchoArmor.REGISTRY.register(eventBus);
        ProjectEchoBlocks.REGISTRY.register(eventBus);
        ProjectEchoBlocks.ITEMS.register(eventBus);
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> () -> {
        zoomMod = new QuickZoom();
        zoomMod.register();
        });
        MinecraftForge.EVENT_BUS.register(new TooltipEventHandler());
    }
}
