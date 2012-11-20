package li.jetty;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.management.MBeanServer;

import li.util.Files;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.mortbay.jetty.webapp.WebAppContext;
import org.mortbay.management.MBeanContainer;
import org.mortbay.util.Scanner;
import org.mortbay.util.Scanner.BulkListener;

public class Jetty {
    static String WEB_ROOT_DIR = "WebContent";// 项目文件系统路径
    static String CONTEXT = "/";// 项目web相对
    static Integer PORT = 8001;
    static Integer SCAN_INTERVAL_SECONDS = 5;

    public static void main(String[] args) throws Exception {
        start();
    }

    public static void start() throws Exception {
        Server server = new Server();

        SelectChannelConnector connector = new SelectChannelConnector();
        connector.setPort(PORT);
        server.addConnector(connector);

        final WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath(CONTEXT);
        webAppContext.setWar(WEB_ROOT_DIR);
        webAppContext.setInitParams(Collections.singletonMap("org.mortbay.jetty.servlet.Default.useFileMappedBuffer", "false"));
        server.addHandler(webAppContext);

        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        MBeanContainer mBeanContainer = new MBeanContainer(mBeanServer);
        server.getContainer().addEventListener(mBeanContainer);
        mBeanContainer.start();

        final ArrayList<File> scanList = new ArrayList<File>();
        scanList.add(Files.root());
        Scanner scanner = new Scanner();
        scanner.setReportExistingFilesOnStartup(false);
        scanner.setScanInterval(SCAN_INTERVAL_SECONDS);
        scanner.setScanDirs(scanList);
        scanner.addListener(new BulkListener() {
            public void filesChanged(List changes) {
                try {
                    System.err.println("Loading changes ......");
                    webAppContext.stop();
                    webAppContext.start();
                    System.err.println("Loading complete.\n");
                } catch (Exception e) {
                    System.err.println("Error reconfiguring/restarting webapp after change in watched files");
                    e.printStackTrace();
                }
            }
        });
        scanner.start();
        server.start();
        server.join();
    }
}