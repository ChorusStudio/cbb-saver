package me.noryea.cbbhopperpatch;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CbbHopperPatchForge.MOD_ID)
public class CbbHopperPatchForge {

    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "cbbhopperpatch";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public CbbHopperPatchForge() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("命令书防漏斗补丁已启用.");
    }
}
