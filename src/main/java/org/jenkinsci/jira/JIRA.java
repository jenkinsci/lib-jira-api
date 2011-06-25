package org.jenkinsci.jira;

import hudson.plugins.jira.soap.JiraSoapService;
import hudson.plugins.jira.soap.JiraSoapServiceServiceLocator;

import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.net.URL;

/**
 * @author Kohsuke Kawaguchi
 */
public class JIRA {
    /**
     * Connects to the confluence server.
     */
    public static JiraSoapService connect(URL jiraUrl) throws IOException, ServiceException {
        JiraSoapServiceServiceLocator loc = new JiraSoapServiceServiceLocator();
        return loc.getJirasoapserviceV2(new URL(jiraUrl,"rpc/soap/jirasoapservice-v2"));
    }
}
