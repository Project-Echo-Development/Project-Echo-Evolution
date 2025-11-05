package team.echo.projectecho.utils;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Mod.EventBusSubscriber
public class TickScheduler {
    private static final List<ScheduledTask> tasks = new ArrayList<>();

    // Schedule a task
    public static void schedule(ServerWorld world, Runnable task, int delayTicks) {
        tasks.add(new ScheduledTask(world, world.getServer().getTickCounter() + delayTicks, task));
    }

    // Tick handler
    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Iterator<ScheduledTask> iterator = tasks.iterator();
            while (iterator.hasNext()) {
                ScheduledTask scheduledTask = iterator.next();
                if (scheduledTask.shouldExecute()) {
                    scheduledTask.run();
                    iterator.remove();
                }
            }
        }
    }

    private static class ScheduledTask {
        private final ServerWorld world;
        private final int executeAt;
        private final Runnable task;

        public ScheduledTask(ServerWorld world, int executeAt, Runnable task) {
            this.world = world;
            this.executeAt = executeAt;
            this.task = task;
        }

        public boolean shouldExecute() {
            return world.getServer().getTickCounter() >= executeAt;
        }

        public void run() {
            task.run();
        }
    }
}
