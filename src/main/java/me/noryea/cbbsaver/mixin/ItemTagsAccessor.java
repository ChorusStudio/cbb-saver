package me.noryea.cbbsaver.mixin;

import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ItemTags.class)
public interface ItemTagsAccessor {
    @Invoker("bind")
    static TagKey<Item> invokeBind(String p_203855_) {
        throw new AssertionError();
    }
}
