package org.bk.memberservice.endpoint;

import org.bk.memberservice.message.MemberDetailsRequest;
import org.bk.memberservice.message.MemberDetailsResponse;
import org.bk.memberservice.service.MemberManager;
import org.bk.memberservice.types.MemberDetail;
import org.springframework.ws.server.endpoint.AbstractMarshallingPayloadEndpoint;

public class GetMemberDetailsEndpoint extends
		AbstractMarshallingPayloadEndpoint {

	private MemberManager memberManager;

	protected Object invokeInternal(Object requestObject) throws Exception {
		MemberDetailsRequest request = (MemberDetailsRequest) requestObject;
		MemberDetail memberDetail = memberManager.getMemberDetails(request
				.getId());
		MemberDetailsResponse response = new MemberDetailsResponse(memberDetail);
		return response;

	}

	public void setMemberManager(MemberManager memberManager) {
		this.memberManager = memberManager;
	}
	
	
}
