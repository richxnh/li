package li.jetty;

import java.io.File;

import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.bio.SocketConnector;
import org.mortbay.jetty.handler.ContextHandlerCollection;
import org.mortbay.jetty.webapp.WebAppContext;

public class Demo {
    private static final int DEFAULT_PORT = 8003;
    private static final int DEFAULT_SCANINTERVALSECONDS = 5;

    public static void main(String[] args) {

        new JettyServer(detectWebAppDir(), DEFAULT_PORT, "/", DEFAULT_SCANINTERVALSECONDS).start();
    }

    private static String detectWebAppDir() {
        // String rootClassPath = getRootClassPath();
        //
        // System.out.println(rootClassPath);
        //
        // String[] temp = null;
        // if (rootClassPath.indexOf("\\WEB-INF\\") != -1)
        // temp = rootClassPath.split("\\\\");
        // else
        // temp = rootClassPath.split("/"); // linux support, need test!!!
        // return temp[temp.length - 3];

        return "D:\\workspace\\li\\WebContent";
    }

    public static String getRootClassPath() {
        String path = Demo.class.getClassLoader().getResource("").getPath();
        return new File(path).getAbsolutePath();
    }

    public static void main2(String[] args) {
        try {
            Server server = new Server();
            Connector connector = new SocketConnector();
            connector.setPort(8002);
            server.addConnector(connector);

            ContextHandlerCollection handler = new ContextHandlerCollection();

            WebAppContext webapp = new WebAppContext();
            webapp.setResourceBase("D:/workspace/li/WebContent");
            handler.addHandler(webapp);

            server.setHandler(handler);
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
