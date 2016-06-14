import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.Issue;
import hudson.plugins.jira.soap.JiraSoapService;
import hudson.plugins.jira.soap.RemoteComment;
import hudson.plugins.jira.soap.RemoteFieldValue;
import org.jenkinsci.jira.JIRA;

import java.net.URL;

/**
 * @author Kohsuke Kawaguchi
 */
public class Foo {
    public static void main(String[] args) throws Exception {
        JiraRestClient service = JIRA.connect(new URL("http://issues.jenkins-ci.org/"),"kohsuke","kohsuke");
        // if an issue doesn't exist an exception will be thrown
        Issue issue = service.getIssueClient().getIssue("JENKINS-2916").claim();

        System.out.println(issue);
    }
}
