package com.embedded;

import java.net.URL;
import java.security.ProtectionDomain;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.MetaInfConfiguration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;
import org.eclipse.jetty.webapp.WebXmlConfiguration;


public class JettyStarter {
	public static void main(String[] args) throws Exception{

        ProtectionDomain domain = JettyStarter.class.getProtectionDomain();
        URL location = domain.getCodeSource().getLocation();
        
        // create a web app and configure it to the root context of the server
        WebAppContext webapp = new WebAppContext();
        webapp.setDescriptor("WEB-INF/web.xml");
        webapp.setConfigurations(new Configuration[]{ new AnnotationConfiguration() 
        		, new WebXmlConfiguration(), new WebInfConfiguration(), new MetaInfConfiguration()        		
        		//, new FragmentConfiguration(), new EnvConfiguration(), new PlusConfiguration()
        	});
        webapp.setContextPath("/");
        webapp.setWar(location.toExternalForm());
        
        // starts the embedded server and bind it on 8081 port
		Server server = new Server(8081);
        server.setHandler(webapp);        
        server.start();
        server.join();	
	}
}
