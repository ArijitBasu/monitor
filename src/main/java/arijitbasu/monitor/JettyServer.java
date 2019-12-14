package arijitbasu.monitor;

import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.EventListener;


public class JettyServer {
    private static final Logger logger = LoggerFactory.getLogger(JettyServer.class);
    private static final int IDLE_TIMEOUT_MS = 300000;

    private int port;
    private int threadPoolSize;
    private String contextPath;

    private Server jettyServer;
    private ServletContextHandler contextHandler;

    public JettyServer(int port, int threadPoolSize, String contextPath) {
        this.port = port;
        this.threadPoolSize = threadPoolSize;
        this.contextPath = contextPath;
    }

    public void initServer() {
        QueuedThreadPool queuedThreadPool = new QueuedThreadPool();
        queuedThreadPool.setMaxThreads(this.threadPoolSize);
        jettyServer = new Server(queuedThreadPool);

        ServerConnector serverConnector = new ServerConnector(jettyServer, new HttpConnectionFactory());
        serverConnector.setPort(this.port);
        serverConnector.setIdleTimeout(IDLE_TIMEOUT_MS);
        jettyServer.addConnector(serverConnector);


        contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.setContextPath(this.contextPath);
        jettyServer.setHandler(contextHandler);
    }

    public void addInitParam(String paramName, String paramValue) {
        if (jettyServer == null) {
            throw new RuntimeException("Please call init before adding a servlet");
        }

        contextHandler.setInitParameter(paramName, paramValue);
    }

    public void addListener(EventListener listener) {
        if (jettyServer == null) {
            throw new RuntimeException("Please call init before adding a servlet");
        }
        contextHandler.addEventListener(listener);
    }

    public void addServlet(ServletHolder servletHolder, String path) {
        if (jettyServer == null) {
            throw new RuntimeException("Please call init before adding a servlet");
        }

        contextHandler.addServlet(servletHolder, path);

    }

    public void startServer() {

        try {
            jettyServer.start();
            logger.info("Server started at host: {} with thread count: {}",
                    jettyServer.getURI(), jettyServer.getThreadPool());
            jettyServer.join();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            jettyServer.destroy();
        }
    }

}
