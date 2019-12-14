package arijitbasu.monitor;

import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.web.context.ContextLoaderListener;

import java.net.UnknownHostException;

public class Driver {
    public static void main(String[] args) throws UnknownHostException {
        JettyServer server = new JettyServer(7000, 8, "/");
        server.initServer();

        server.addListener(new ContextLoaderListener());
        server.addInitParam("contextConfigLocation", "classpath*:**/application-context.xml");
        server.addInitParam("contextClass", "org.springframework.web.context.support.XmlWebApplicationContext");

        ServletHolder holder = new ServletHolder(ServletContainer.class);
        holder.setInitParameter("jersey.config.server.provider.packages", "arijitbasu.monitor;" );
        holder.setInitParameter("jersey.config.server.provider.scanning.recursive", "true");
        holder.setInitOrder(0);
        server.addServlet(holder, "/v1/*");

        server.startServer();
    }

}