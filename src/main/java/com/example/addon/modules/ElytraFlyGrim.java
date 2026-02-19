package com.example.addon.modules;

import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.systems.modules.Categories;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.util.math.Vec3d;

public class ElytraFlyGrim extends Module {
    private double horizontalSpeed = 0;

    public ElytraFlyGrim() {
        super(Categories.Movement, "elytra-fly-grim", "Mantém velocidade de queda sem rubberband.");
    }

    @Override
    public void onDeactivate() {
        horizontalSpeed = 0;
    }

    @EventHandler
    private void onTick(TickEvent.Post event) {
        if (mc.player == null || !mc.player.isFallFlying()) {
            horizontalSpeed = 0;
            return;
        }

        Vec3d vel = mc.player.getVelocity();
        double currentSpeed = Math.sqrt(vel.x * vel.x + vel.z * vel.z);

        // Se estivermos rápido, salvamos essa velocidade "buffer"
        if (currentSpeed > 0.5) {
            horizontalSpeed = currentSpeed;
        }

        // Se temos uma velocidade salva, reaplicamos para não perder momentum
        if (horizontalSpeed > 0) {
            double yaw = Math.toRadians(mc.player.getYaw());
            double moveX = -Math.sin(yaw) * horizontalSpeed;
            double moveZ = Math.cos(yaw) * horizontalSpeed;

            // Mantemos a gravidade vanilla (vel.y) para o Grim não detectar NoGravity
            mc.player.setVelocity(moveX, vel.y, moveZ);
        }
    }
}
