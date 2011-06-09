package org.bk.memberservice.message;

import javax.xml.bind.annotation.XmlRootElement;

import org.bk.memberservice.types.MemberDetail;

@XmlRootElement(name="MemberDetailsResponse", namespace="http://bk.org/memberservice/")
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
