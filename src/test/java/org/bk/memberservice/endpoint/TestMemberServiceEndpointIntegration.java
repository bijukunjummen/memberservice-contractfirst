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
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
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
          + "<ns3:memberdetail>" 
          + "<ns3:id>1</ns3:id>"
          + "<ns3:name>john doe</ns3:name>"
          + "<ns3:phone>111-111-1111</ns3:phone>"
          + "<ns3:city>City</ns3:city>"
          + "<ns3:state>State</ns3:state>"
          + "</ns3:memberdetail>"
      + "</ns3:MemberDetailsResponse>");

        Resource schema = new ClassPathResource("/memberservice.xsd");
        mockClient.sendRequest(withPayload(requestPayload)).andExpect(payload(responsePayload)).andExpect(validPayload(schema ));
        verify(this.memberManager);
    }
}