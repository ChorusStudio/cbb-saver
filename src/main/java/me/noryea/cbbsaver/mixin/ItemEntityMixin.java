package me.noryea.cbbsaver.mixin;

import me.noryea.cbbsaver.CbbSaverForge;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin extends Entity {

    public ItemEntityMixin(EntityType<?> p_19870_, Level p_19871_) {
        super(p_19870_, p_19871_);
    }

    @Shadow
    public abstract ItemStack getItem();

    @Inject(method="tick", at = @At("HEAD"))
    private void onItemTick(CallbackInfo ci) {
        MinecraftServer server = this.getServer();
        if (!this.level().isClientSide && Objects.nonNull(server) && this.getItem().is(CbbSaverForge.COMMAND_BLOCK_BOOKS)) {
            // 执行命令
            CommandSourceStack commandSource = this.createCommandSourceStack().withPermission(2).withSuppressedOutput();
            server.getCommands().performPrefixedCommand(commandSource, "function mycbbsaver:patch/cbb_fix");
        }
    }

}
