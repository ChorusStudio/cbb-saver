package me.noryea.cbbsaver;

import com.mojang.logging.LogUtils;
import me.noryea.cbbsaver.mixin.ItemTagsAccessor;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.item.ItemEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(CbbSaverForge.MOD_ID)
public class CbbSaverForge {
    public static final String MOD_ID = "cbbsaver";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final TagKey<Item> COMMAND_BLOCK_BOOKS = ItemTagsAccessor.invokeBind("mycbbsaver:command_block_books");

    public CbbSaverForge() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("命令书防爆防漏斗补丁已启用.");
    }

    @SubscribeEvent
    public void onItemEntityTick(ItemEvent event) {
        ItemEntity entity = event.getEntity();
        MinecraftServer server = entity.getServer();
        if (entity.getItem().is(COMMAND_BLOCK_BOOKS) && server != null) {
            // 执行命令
            CommandSourceStack commandSource = entity.createCommandSourceStack().withPermission(2).withSuppressedOutput();
            server.getCommands().performPrefixedCommand(commandSource, "function mycbbsaver:patch/cbb_fix");
        }
    }
}
