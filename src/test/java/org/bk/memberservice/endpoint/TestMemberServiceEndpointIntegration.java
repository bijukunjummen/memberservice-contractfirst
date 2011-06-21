package org.bk.memberservice.endpoint;

import static org.easymock.EasyMock.*;
import static org.springframework.ws.test.server.RequestCreators.*;
import static org.springframework.ws.test.server.ResponseMatchers.*;

import javax.xml.transform.Source;

import org.bk.memberservice.service.MemberManager;
import org.bk.memberservice.types.MemberDetail;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.xml.transform.StringSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("integ-test.xml")
public class TestMemberServiceEndpointIntegration {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private MemberManager memberManager;

    private MockWebServiceClient mockClient;

    @Before
    public void createClient() {
        MemberDetail memberDetail = new MemberDetail("john doe", "111-111-1111", "City", "State");
        memberDetail.setId(1L);
        expect(memberManager.findByMemberId(1L)).andReturn(memberDetail);
        replay(memberManager);
        mockClient = MockWebServiceClient.createClient(applicationContext);
    }

    @Test
    public void testMemberServiceEndpoint() throws Exception {
        Source requestPayload = new StringSource(
                "<mem:MemberDetailsRequest xmlns:mem=\"http://bk.org/memberservice/\">"
                        + "<mem:id>1</mem:id>" 
                        + "</mem:MemberDetailsRequest>");
        Source responsePayload = new StringSource(
                "<ns3:MemberDetailsResponse xmlns:ns3=\"http://bk.org/memberservice/\">"
          + "<memberDetail>" 
          + "<id>1</id>"
          + "<name>john doe</name>"
          + "<phone>111-111-1111</phone>"
          + "<city>City</city>"
          + "<state>State</state>"
          + "</memberDetail>"
      + "</ns3:MemberDetailsResponse>");

        mockClient.sendRequest(withPayload(requestPayload)).andExpect(payload(responsePayload));
        verify(this.memberManager);
    }
}