package org.jenkinsci.jira;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Properties;

/**
 * @author Kohsuke Kawaguchi
 */
public class JIRA {
    /**
     * Connects to the JIRA server.
     */
    public static JiraRestClient connect(URL jiraUrl, String username, String password) throws IOException {
        return new AsynchronousJiraRestClientFactory()
                .createWithBasicHttpAuthentication(URI.create(jiraUrl.toExternalForm()), username, password);
    }

    public static JiraRestClient connect(URL jiraUrl) throws IOException {
        Properties props = new Properties();
        try (FileReader r = new FileReader(System.getProperty("user.home")+".jenkins-ci.org")) {
            props.load(r);
        }

        return connect(new URL("https://issues.jenkins-ci.org/"), props.getProperty("userName"), props.getProperty("password"));
    }
}
