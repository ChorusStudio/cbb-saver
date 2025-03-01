package me.noryea.cbbsaver.mixin;

import net.minecraft.world.Container;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.block.entity.HopperBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(HopperBlockEntity.class)

public abstract class HopperBlockEntityMixin {

    @Inject(method = "addItem(Lnet/minecraft/world/Container;Lnet/minecraft/world/entity/item/ItemEntity;)Z", at = @At("HEAD"), cancellable = true)
    private static void onAddItemEntity(Container container, ItemEntity itemEntity, CallbackInfoReturnable<Boolean> cir) {
        String itemDescriptionId = itemEntity.getItem().getDescriptionId();
        // 如果物品实体的翻译键是item.witherstormmod.command_block_book， 取消事件
        if (Objects.equals(itemDescriptionId,"item.witherstormmod.command_block_book")) {
            cir.setReturnValue(false);
            cir.cancel();
        }
    }

}