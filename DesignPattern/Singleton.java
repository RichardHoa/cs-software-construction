package DesignPattern;

public class Singleton {
    public static void main(String[] args) {
        ServerConfig config = ServerConfig.getInstance();
        
        System.out.println(config.getServerName());
        System.out.println(config.getPort());

        ServerConfig anotherReference = ServerConfig.getInstance();
        System.out.println("Is it the same instance? " + (config == anotherReference));
    }

}


class ServerConfig {
    private static ServerConfig instance;

    private String serverName;
    private int port;

    private ServerConfig() {
        this.serverName = "Main_Production_Server";
        this.port = 8080;
    }

    // STATIC METHOD to call on the class
    public static synchronized ServerConfig getInstance() {
        if (instance == null) {
            instance = new ServerConfig();
        }
        return instance;
    }

    public String getServerName() { return serverName; }
    public int getPort() { return port; }
}
