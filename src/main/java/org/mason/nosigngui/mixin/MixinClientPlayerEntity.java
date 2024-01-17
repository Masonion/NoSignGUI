package org.mason.nosigngui.mixin;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.block.entity.SignBlockEntity;
import org.mason.nosigngui.NoSignGUI;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public abstract class MixinClientPlayerEntity {

    @Inject(method = "openEditSignScreen(Lnet/minecraft/block/entity/SignBlockEntity;Z)V", at = @At("HEAD"), cancellable = true)
    private void onOpenEditSignScreen(SignBlockEntity sign, boolean front, CallbackInfo info) {
        if (!NoSignGUI.isSignGuiEnabled) {
            info.cancel();
        }
    }
}