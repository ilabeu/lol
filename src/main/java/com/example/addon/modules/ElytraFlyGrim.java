package com.ilabeu.modules;

import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.systems.modules.Categories;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.util.math.Vec3d;

public class ElytraFlyGrim extends Module {
    private double horizontalSpeed = 0;

    public ElytraFlyGrim() {
        super(Categories.Movement, "elytra-fly-grim", "Bypass de momentum para GrimV3.");
    }

    @Override
    public void onDeactivate() {
        horizontalSpeed = 0;
    }

    @EventHandler
    private void onTick(TickEvent.Post event) {
        if (mc.player == null) return;
        
        // Verificação compatível com 1.20.1
        if (!mc.player.isFallFlying()) {
            horizontalSpeed = 0;
            return;
        }

        Vec3d vel = mc.player.getVelocity();
        double currentSpeed = Math.sqrt(vel.x * vel.x + vel.z * vel.z);

        if (currentSpeed > 0.5) {
            horizontalSpeed = currentSpeed;
        }

        if (horizontalSpeed > 0) {
            double yaw = Math.toRadians(mc.player.getYaw());
            double moveX = -Math.sin(yaw) * horizontalSpeed;
            double moveZ = Math.cos(yaw) * horizontalSpeed;
            mc.player.setVelocity(moveX, vel.y, moveZ);
        }
    }
}
