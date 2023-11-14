package me.kermx.attributeadmin;

import org.bukkit.plugin.java.JavaPlugin;

public final class AttributeAdmin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("attributeadmin").setExecutor(new AACommand());
        getCommand("attributefix").setExecutor(new AFCommand());
        getCommand("attributemodifiers").setExecutor(new AMCommand());
        getCommand("attributereset").setExecutor(new ARCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
