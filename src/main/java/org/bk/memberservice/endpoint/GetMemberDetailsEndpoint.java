package org.bk.memberservice.endpoint;

import org.bk.memberservice.message.MemberDetailsFault;
import org.bk.memberservice.message.MemberDetailsRequest;
import org.bk.memberservice.message.MemberDetailsResponse;
import org.bk.memberservice.service.MemberManager;
import org.bk.memberservice.types.MemberDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class GetMemberDetailsEndpoint {

	@Autowired private MemberManager memberManager;

	@PayloadRoot(namespace = "http://bk.org/memberservice/", localPart = "MemberDetailsRequest")
	@ResponsePayload
	public MemberDetailsResponse getMemberDetails(@RequestPayload MemberDetailsRequest request) throws Exception {
		MemberDetail memberDetail = memberManager.findByMemberId(request.getId());
		if (memberDetail==null){
			throw new MemberDetailsFault("Member Not Found");
		}
		MemberDetailsResponse response = new MemberDetailsResponse(memberDetail);
		return response;

	}

	public void setMemberManager(MemberManager memberManager) {
		this.memberManager = memberManager;
	}
	
	
}
