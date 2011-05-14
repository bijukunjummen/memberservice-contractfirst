package org.bk.memberservice.endpoint;

import org.bk.memberservice.endpoint.GetMemberDetailsEndpoint;
import org.bk.memberservice.message.MemberDetailsRequest;
import org.bk.memberservice.message.MemberDetailsResponse;
import org.bk.memberservice.service.MemberManager;
import org.bk.memberservice.types.MemberDetail;

import static org.easymock.EasyMock.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGetMemberDetailsEndpoint {

	@Test
	public void testInvokeInternalObject() throws Exception {
		MemberManager memberManagerMock = createMock(MemberManager.class);
		MemberDetail memberDetail = new MemberDetail("testname","testphone","testcity","teststate");
		MemberDetailsResponse response = new MemberDetailsResponse(memberDetail);
		expect(memberManagerMock.getMemberDetails(isA(String.class))).andReturn(memberDetail);
		GetMemberDetailsEndpoint memberDetailsEndpoint = new GetMemberDetailsEndpoint();
		memberDetailsEndpoint.setMemberManager(memberManagerMock);
		replay(memberManagerMock);
		memberDetailsEndpoint.invokeInternal(new MemberDetailsRequest("testid"));
		verify(memberManagerMock);

	}

}
