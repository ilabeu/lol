package com.example.addon;

import com.example.addon.commands.CommandExample;
import com.example.addon.hud.HudExample;
import com.example.addon.modules.ElytraFlyGrim;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.commands.Commands;
import meteordevelopment.meteorclient.systems.hud.Hud;
import meteordevelopment.meteorclient.systems.modules.Modules;
import meteordevelopment.meteorclient.systems.modules.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddonTemplate extends MeteorAddon {
    public static final Logger LOG = LoggerFactory.getLogger("AddonTemplate");
    public static final Category CATEGORY = new Category("Ilabeu Hax");

    @Override
    public void onInitialize() {
        LOG.info("Inicializando Ilabeu Hax Addon...");

        // Registra o seu novo módulo de Elytra para o GrimV3
        Modules.get().add(new ElytraFlyGrim());

        // Registra comandos e HUD (opcional, se você manteve os exemplos)
        Commands.get().add(new CommandExample());
        Hud.get().register(HudExample.INFO);
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
    }

    @Override
    public String getPackage() {
        return "com.example.addon";
    }
}
