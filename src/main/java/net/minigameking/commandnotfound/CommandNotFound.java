package net.minigameking.commandnotfound;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class CommandNotFound extends JavaPlugin {

    private static CommandNotFound plugin;
    public static String msg;
    public FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        int pluginId = 16581;
        Metrics metrics = new Metrics(this, pluginId);
        plugin = this;
        config.addDefault("Message", "§3[§2§lCommandNotFound§3] §cThis command does not exist.");
        config.options().copyDefaults(true);
        saveConfig();
        msg = config.getString("Message");
        this.getCommand("commandnotfound").setExecutor(new CommandManager());
        this.getCommand("commandnotfound").setTabCompleter(new TabComplete());
        getServer().getPluginManager().registerEvents(new CMDListener(), this);
        getServer().getConsoleSender().sendMessage("§3[§2§lCommandNotFound§3] §aCommandNotFound has been enabled!" );
    }

    public static CommandNotFound getPlugin() {
        return plugin;
    }
}
