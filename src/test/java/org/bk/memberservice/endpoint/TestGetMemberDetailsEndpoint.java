package org.bk.memberservice.endpoint;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.isA;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.bk.memberservice.message.MemberDetailsRequest;
import org.bk.memberservice.service.MemberManager;
import org.bk.memberservice.types.MemberDetail;
import org.junit.Test;

public class TestGetMemberDetailsEndpoint {

	@Test
	public void testInvokeInternalObject() throws Exception {
		MemberManager memberManagerMock = createMock(MemberManager.class);
		MemberDetail memberDetail = new MemberDetail("testname","testphone","testcity","teststate");
//		MemberDetailsResponse response = new MemberDetailsResponse(memberDetail);
		expect(memberManagerMock.findByMemberId((isA(Long.class)))).andReturn(memberDetail);
		GetMemberDetailsEndpoint memberDetailsEndpoint = new GetMemberDetailsEndpoint();
		memberDetailsEndpoint.setMemberManager(memberManagerMock);
		replay(memberManagerMock);
		memberDetailsEndpoint.getMemberDetails(new MemberDetailsRequest(1L));
		verify(memberManagerMock);

	}

}
