package server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import server.config.Configuration;
import server.config.ConfigurationManager;
import server.core.ServerListenerThread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.cert.CRL;

/**
 * Driver Class for Http Server
 */
public class HTTPServer {

    private final static Logger LOGGER = LoggerFactory.getLogger(HTTPServer.class);

    public static void main(String[] args) {

        LOGGER.info("Server starting...");
        String filePath = "C:\\Users\\andritz\\IdeaProjects\\Weather\\src\\main\\resources\\http.json";
        String page = "<html><head><title>Simple Java HTTP Server</title></head><body><h1>This page was served using my Simple Java HTTP Server</h1></body></html>";

        ConfigurationManager.getInstace().loadConfigFile(filePath);
        final Configuration currentConfiguration = ConfigurationManager.getInstace().getCurrentConfiguration();

        LOGGER.info("Port: " + currentConfiguration.getPort());
        LOGGER.info("Webroot: " + currentConfiguration.getWebroot());

        final ServerListenerThread serverListenerThread;
        try {
            serverListenerThread = new ServerListenerThread(currentConfiguration.getPort(), currentConfiguration.getWebroot());
            serverListenerThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
