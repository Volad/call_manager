/*
 * ShowEvidence, Inc. Copyright (C) 2014
 */
package com.cm.rest.app;

import java.net.URL;
import java.security.ProtectionDomain;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.SecureRequestCustomizer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * {@link CoreApplicationRunner} start all available {@link Application}s.
 * 
 * @author VladislavKondratenko
 *
 */
@Component
public class JettyRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(JettyRunner.class);

    private static final String JETTY_APP_CONTEXT = "restAppContext.xml";

    @Value("${jetty.port}")
    private int port;

    private WebAppContext context;

    public static void main(final String[] args) {
        try  {
            LOGGER.info("Starting Jetty Server");
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(JETTY_APP_CONTEXT);
            JettyRunner runner = context.getBean(JettyRunner.class);
            Server server = runner.configureJettyServer();

            server.start();
            LOGGER.info("Jetty started at port " + runner.port);
        } catch (Throwable e) {
            LOGGER.error("Error during starting jetty server ", e);

            System.exit(1);
        }
    }

    public Server configureJettyServer() {
        Server server = new Server();

        ServerConnector connector = new ServerConnector(server);
        connector.setPort(this.port);

        HttpConfiguration https = new HttpConfiguration();
        https.addCustomizer(new SecureRequestCustomizer());

        server.setConnectors(new Connector[] { connector });

        context = new WebAppContext();
        context.setServer(server);
        context.setContextPath("/");
        context.setThrowUnavailableOnStartupException(true);

        ProtectionDomain protectionDomain = JettyRunner.class.getProtectionDomain();
        URL location = protectionDomain.getCodeSource().getLocation();

        context.setWar(location.toExternalForm());

        server.setHandler(context);
        return server;
    }

    public WebAppContext getContext() {
        return context;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}
