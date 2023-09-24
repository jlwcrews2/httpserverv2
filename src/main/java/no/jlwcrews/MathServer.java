package no.jlwcrews;

import jakarta.servlet.DispatcherType;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;

import java.util.EnumSet;

public class MathServer {

    Server server = new Server(8181);

    public void start() throws Exception {
        var resource = Resource.newClassPathResource("/webapp");
        var webApp = new WebAppContext(resource, "/");

        webApp.addServlet(new ServletHolder(new AdditionServlet()), "/api/addition");
        webApp.addFilter(new FilterHolder(new NewFilter()), "/*", EnumSet.of(DispatcherType.REQUEST));
        server.setHandler(webApp);
        server.start();
    }
}
