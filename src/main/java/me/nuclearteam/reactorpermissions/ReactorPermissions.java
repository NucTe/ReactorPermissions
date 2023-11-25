package me.nuclearteam.reactorpermissions;

import me.nuclearteam.nuclearlib.Nuclearlib;
import me.nuclearteam.nuclearlib.bukkit.MongoDb.ConfigManager;
import me.nuclearteam.nuclearlib.bukkit.MongoDb.MongoDbManager;
import me.nuclearteam.reactorpermissions.Website.Site;
import org.bukkit.plugin.java.JavaPlugin;
import org.eclipse.jetty.server.Server;

import java.util.logging.Logger;
import java.util.logging.Level;



public final class ReactorPermissions extends JavaPlugin {
    private ConfigManager configManager;
    private MongoDbManager mongoDbManager;

    Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );


    @Override
    public void onEnable() {
        // Mongodb

        mongoLogger.setLevel(Level.SEVERE);
        configManager = new ConfigManager(this);
        mongoDbManager = new MongoDbManager(this, "ReactorPermissions");
        String connectionString = configManager.getMongoDBConnectionString();
        mongoDbManager.connect(connectionString);

        // Jetty

        int port = 8080; // Use the port you want
        Server server = new Server(port);
        try {
            Site.web(server);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onDisable() {
        mongoDbManager.close();
    }
}
