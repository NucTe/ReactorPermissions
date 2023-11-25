package me.nuclearteam.reactorpermissions.Website;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;

public class Site {
    public static void web(Server server) throws Exception {
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setWelcomeFiles(new String[]{"index.html"});

        // Set the base resource (adjust the path as needed)
        String resourceBase = Site.class.getClassLoader().getResource("webapp").toExternalForm();
        resourceHandler.setResourceBase(resourceBase);

        // Create a handler list and add the ResourceHandler
        HandlerList handlers = new HandlerList();
        handlers.addHandler(resourceHandler);

        // Set the handlers for the server
        server.setHandler(handlers);

        // Start the server
        server.start();
        server.join();
    }
}
