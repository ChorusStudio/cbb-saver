package me.noryea.cbbsaver.mixin;

import net.minecraft.world.Container;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.HopperBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static me.noryea.cbbsaver.CbbSaverForge.COMMAND_BLOCK_BOOKS;

@Mixin(HopperBlockEntity.class)

public abstract class HopperBlockEntityMixin {

    @Inject(method = "addItem(Lnet/minecraft/world/Container;Lnet/minecraft/world/entity/item/ItemEntity;)Z", at = @At("HEAD"), cancellable = true)
    private static void onAddItemEntity(Container container, ItemEntity itemEntity, CallbackInfoReturnable<Boolean> cir) {
        ItemStack itemStack = itemEntity.getItem();
        // 如果物品是 #mycbbsaver:command_block_books，取消事件
        if (itemStack.is(COMMAND_BLOCK_BOOKS)) {
            cir.setReturnValue(false);
            cir.cancel();
        }
    }
}