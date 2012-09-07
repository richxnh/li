package server;

import java.net.InetAddress;

import org.apache.catalina.Context;
import org.apache.catalina.Engine;
import org.apache.catalina.Host;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Embedded;

public class EmbeddedTomcat {
	public static void main(String[] args) throws Exception {
		System.setProperty("catalina.home", "D:/Users/li/Desktop/webapps");
		Embedded embedded = new Embedded();

		Engine engine = embedded.createEngine();
		engine.setDefaultHost("localhost");

		Host host = embedded.createHost("localhost", "path2");
		engine.addChild(host);

		Context context = embedded.createContext("", "path3");
		host.addChild(context);

		embedded.addEngine(engine);

		InetAddress address = null;
		Connector connector = embedded.createConnector(address, 8001, false);
		embedded.addConnector(connector);

		embedded.start();
	}
}