package org.bk.memberservice.message;

import org.bk.memberservice.types.MemberDetail;

public class MemberDetailsResponse {

	public MemberDetailsResponse() {
	}

	private MemberDetail memberDetail;

	public MemberDetailsResponse(MemberDetail memberDetail) {
		this.memberDetail = memberDetail;
	}

	public MemberDetail getMemberDetail() {
		return memberDetail;
	}

	public void setMemberDetail(MemberDetail memberDetail) {
		this.memberDetail = memberDetail;
	}

}
