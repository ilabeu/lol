package com.ilabeu.addon;

import com.ilabeu.modules.ElytraFlyGrim;
import com.ilabeu.commands.CommandExample;
import com.ilabeu.hud.HudExample;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.commands.Commands;
import meteordevelopment.meteorclient.systems.hud.Hud;
import meteordevelopment.meteorclient.systems.modules.Modules;
import meteordevelopment.meteorclient.systems.modules.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddonTemplate extends MeteorAddon {
    public static final Logger LOG = LoggerFactory.getLogger("IlabeuHax");
    public static final Category CATEGORY = new Category("Ilabeu Hax");

    @Override
    public void onInitialize() {
        LOG.info("Inicializando Ilabeu Hax...");

        // Modules
        Modules.get().add(new ElytraFlyGrim());

        // Commands
        Commands.get().add(new CommandExample());

        // HUD
        Hud.get().register(HudExample.INFO);
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
    }

    @Override
    public String getPackage() {
        return "com.ilabeu.addon";
    }
}
