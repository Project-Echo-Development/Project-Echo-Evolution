package team.echo.projectecho.zoom;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.lwjgl.glfw.GLFW;

public class QuickZoom {
    private static Minecraft mc;
    private static double currentFov;
    private static double baseFov;
    private static final double SCROLL_STEP = 0.04;
    private static final double MIN_ZOOM = 0.02;
    private static final double MAX_ZOOM = 1.0;
    private static double zoomSpeed = 0.02;
    private static double zoomMult = 0.12;
    private static double zoomFactor = 1;
    private boolean initialized;
    private boolean zooming;
    private KeyBinding bind;



    public void setup(final FMLClientSetupEvent event) {
        mc = Minecraft.getInstance();
        currentFov = mc.gameSettings.fov;
        baseFov = mc.gameSettings.fov;

        bind = new KeyBinding("key.zoom", GLFW.GLFW_KEY_C, "key.categories.misc");
        ClientRegistry.registerKeyBinding(bind);
    }

    public void register() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (bind.isKeyDown()) {
            zooming = !zooming;
            if (!zooming)
                currentFov = baseFov;
        }
    }

    @SubscribeEvent
    public void onScroll(InputEvent.MouseScrollEvent event) {
        if (zooming) {
            double delta = event.getScrollDelta();
            zoomMult -= delta * SCROLL_STEP;
            if (zoomMult < MIN_ZOOM) zoomMult = MIN_ZOOM;
            if (zoomMult > MAX_ZOOM) zoomMult = MAX_ZOOM;
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onFovUpdate(EntityViewRenderEvent.FOVModifier event) {
        double fov = event.getFOV();

        if (!initialized) {
            baseFov = fov;
            initialized = true;
        }

        if (!zooming)
            baseFov = fov;

        mc.gameSettings.smoothCamera = zooming;
        double targetZoom = zooming ? zoomMult : 1;
        zoomFactor += (targetZoom - zoomFactor) * zoomSpeed;
        event.setFOV(baseFov * zoomFactor);
    }
}