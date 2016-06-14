package org.jenkinsci.jira;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import hudson.plugins.jira.soap.JiraSoapService;
import hudson.plugins.jira.soap.JiraSoapServiceServiceLocator;

import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author Kohsuke Kawaguchi
 */
public class JIRA {
    /**
     * Connects to the confluence server.
     */
    public static JiraRestClient connect(URL jiraUrl, String username, String password) throws IOException {
        return new AsynchronousJiraRestClientFactory()
                .createWithBasicHttpAuthentication(URI.create(jiraUrl.toExternalForm()), username, password);

    }
}
