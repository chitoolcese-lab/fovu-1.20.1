package dev.tori.fovu.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.tori.fovu.client.FovUClient;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(GameRenderer.class)
public class MixinGameRenderer {

    @ModifyReturnValue(
            method = "getFov(Lnet/minecraft/client/render/Camera;FZ)D",
            at = @At("RETURN")
    )
    private double getFov(double fov) {
        return MathHelper.clamp(fov, FovUClient.MIN_FOV, FovUClient.MAX_FOV);
    }
}
