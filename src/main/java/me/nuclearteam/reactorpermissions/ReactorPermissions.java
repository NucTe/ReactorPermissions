package me.nuclearteam.reactorpermissions;

import me.nuclearteam.nuclearlib.bukkit.MongoDb.ConfigManager;
import me.nuclearteam.nuclearlib.bukkit.MongoDb.MongoDbManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ReactorPermissions extends JavaPlugin {
    private ConfigManager configManager;
    private MongoDbManager mongoDbManager;

    @Override
    public void onEnable() {
        configManager = new ConfigManager(this);
        mongoDbManager = new MongoDbManager(this, "ReactorPermissions");
        String connectionString = configManager.getMongoDBConnectionString();
        mongoDbManager.connect(connectionString);
        




    }

    @Override
    public void onDisable() {
        mongoDbManager.close();
    }
}
