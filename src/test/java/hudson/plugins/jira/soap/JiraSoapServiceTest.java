/*
 * The MIT License
 * 
 * Copyright (c) 2011, Jesse Farinacci
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package hudson.plugins.jira.soap;

import java.net.URL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="mailto:jieryn@gmail.com">Jesse Farinacci</a>
 */
public final class JiraSoapServiceTest {
    private static final String URL = "http://issues.jenkins-ci.org/rpc/soap/jirasoapservice-v2";

    private static final String PROJECT = "JENKINS";

    private static final String USER = "jieryn";

    private JiraSoapService service;

    private String loginToken;

    @Before
    public void setUp() throws Exception {
	service = new JiraSoapServiceServiceLocator()
		.getJirasoapserviceV2(new URL(URL));

	ConnectionInfo connectionInfo = new ConnectionInfo();
	loginToken = service.login(connectionInfo.userName,
		connectionInfo.password);
    }

    @Test
    public void testGetIssue1() throws Exception {
	Assert.assertNotNull(service.getIssue(loginToken, "JENKINS-1"));
    }

    @Test
    public void testGetRemoteComponents1() throws Exception {
	Assert.assertNotNull(service.getComponents(loginToken, PROJECT));
    }

    @Test
    public void testGetResolutions1() throws Exception {
	Assert.assertNotNull(service.getResolutions(loginToken));
    }

    @Test
    public void testGetServerInfo1() throws Exception {
	Assert.assertNotNull(service.getServerInfo(loginToken));
    }

    @Test
    public void testGetStatuses1() throws Exception {
	Assert.assertNotNull(service.getStatuses(loginToken));
    }

    @Test
    public void testGetUser1() throws Exception {
	Assert.assertNotNull(service.getUser(loginToken, USER));
    }
}
