package com.ilabeu.addon;

import com.ilabeu.modules.ElytraFlyGrim;
import meteordevelopment.meteorclient.addons.MeteorAddon;
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
        Modules.get().add(new ElytraFlyGrim());
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
