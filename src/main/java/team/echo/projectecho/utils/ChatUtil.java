package team.echo.projectecho.utils;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.server.ServerWorld;

public class ChatUtil {

    public static void broadcastMessage(ServerWorld world, String message) {
        MinecraftServer server = world.getServer();
        if (server != null) {
            if (server.isSinglePlayer()) {
                ServerPlayerEntity player = server.getPlayerList().getPlayers().get(0);
                if (player != null)
                    player.sendMessage(new StringTextComponent(message), player.getUniqueID());
            } else
                server.getPlayerList().func_232641_a_(new StringTextComponent(message), ChatType.SYSTEM, null);
        }
    }
}
