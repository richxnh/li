package li.jetty;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.Collections;

import javax.management.MBeanServer;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.mortbay.jetty.webapp.WebAppContext;
import org.mortbay.management.MBeanContainer;

public class Jetty {
    static String WEB_ROOT_DIR = "WebContent";// 项目文件系统路径
    static String CONTEXT = "/";// 项目web相对
    static Integer PORT = 8001;
    static Integer SCAN_INTERVAL_SECONDS = 5;

    public static void main(String[] args) {
        new Jetty("WebContent", 8001, "/", 5).start();
    }

    private String webAppDir;
    private int port;
    private String context;
    private int scanIntervalSeconds;
    private boolean isStarted = false;
    private Server server;
    private WebAppContext web;
    private boolean enablescanner = true;

    Jetty(String webAppDir, int port, String context, int scanIntervalSeconds) {
        this.webAppDir = webAppDir;
        this.port = port;
        this.context = context;
        this.scanIntervalSeconds = scanIntervalSeconds;
        checkConfig();
    }

    private void checkConfig() {
        if (port < 0 || port > 65536)
            throw new IllegalArgumentException("Invalid port of web server: " + port);

        if (scanIntervalSeconds < 1)
            enablescanner = false;

        if (context == null)
            throw new IllegalStateException("Invalid context of web server: " + context);

        if (webAppDir == null)
            throw new IllegalStateException("Invalid context of web server: " + webAppDir);
    }

    public void start() {
        if (!isStarted) {
            try {
                doStart();
            } catch (Exception e) {
                e.printStackTrace();
            }
            isStarted = true;
        } else {
            throw new RuntimeException("Server already started.");
        }
    }

    private void doStart() throws Exception {
        String context = this.context;
        String webAppDir = this.webAppDir;
        Integer port = this.port;
        Integer scanIntervalSeconds = this.scanIntervalSeconds;

        server = new Server();

        if (port != null) {
            if (!available(port)) {
                throw new IllegalStateException("port: " + port + " already in use!");
            }
            SelectChannelConnector connector = new SelectChannelConnector();
            connector.setPort(port);

            server.addConnector(connector);
        }

        web = new WebAppContext();

        // 警告: 设置成 true 无法支持热加载
        // web.setParentLoaderPriority(false);
        web.setContextPath(context);
        web.setWar(webAppDir);
        web.setInitParams(Collections.singletonMap("org.mortbay.jetty.servlet.Default.useFileMappedBuffer", "false"));
        server.addHandler(web);

        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        MBeanContainer mBeanContainer = new MBeanContainer(mBeanServer);
        server.getContainer().addEventListener(mBeanContainer);
        mBeanContainer.start();

        // configureScanner
        // if (enablescanner) {
        // final ArrayList<File> scanList = new ArrayList<File>();
        // scanList.add(Files.root());
        // Scanner scanner = new Scanner();
        // scanner.setReportExistingFilesOnStartup(false);
        // scanner.setScanInterval(scanIntervalSeconds);
        // scanner.setScanDirs(scanList);
        // scanner.addListener(new Scanner.BulkListener() {
        //
        // public void filesChanged(@SuppressWarnings("rawtypes") List changes) {
        // try {
        // System.err.println("Loading changes ......");
        // web.stop();
        // web.start();
        // System.err.println("Loading complete.\n");
        // } catch (Exception e) {
        // System.err.println("Error reconfiguring/restarting webapp after change in watched files");
        // e.printStackTrace();
        // }
        // }
        // });
        // System.err.println("Starting scanner at interval of " + scanIntervalSeconds + " seconds.");
        // scanner.start();
        // }

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(100);
        }
    }

    private static boolean available(int port) {
        if (port <= 0) {
            throw new IllegalArgumentException("Invalid start port: " + port);
        }

        ServerSocket ss = null;
        DatagramSocket ds = null;
        try {
            ss = new ServerSocket(port);
            ss.setReuseAddress(true);
            ds = new DatagramSocket(port);
            ds.setReuseAddress(true);
            return true;
        } catch (IOException e) {
            //
        } finally {
            if (ds != null) {
                ds.close();
            }

            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    // should not be thrown, just detect port available.
                }
            }
        }
        return false;
    }
}