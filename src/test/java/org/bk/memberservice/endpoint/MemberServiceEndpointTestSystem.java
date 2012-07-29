package org.bk.memberservice.endpoint;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.bk.memberservice.message.MemberDetailsRequest;
import org.bk.memberservice.message.MemberDetailsResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.client.core.WebServiceTemplate;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("system-test.xml")
public class MemberServiceEndpointTestSystem {

    @Autowired
    private WebServiceTemplate webserviceTemplate;




    @Test
    public void getMemberSystemTest() throws Exception {
        MemberDetailsRequest memberDetailsRequest = new MemberDetailsRequest();
        memberDetailsRequest.setId(1L);
        
        MemberDetailsResponse memberDetailsResponse= (MemberDetailsResponse)webserviceTemplate.marshalSendAndReceive(memberDetailsRequest );
        assertThat(memberDetailsResponse, is(not(nullValue())));
        System.out.println(memberDetailsResponse.getMemberDetail());
    }
}