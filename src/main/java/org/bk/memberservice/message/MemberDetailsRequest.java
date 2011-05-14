package org.bk.memberservice.message;

public class MemberDetailsRequest {

	public MemberDetailsRequest() {
	}

	public MemberDetailsRequest(String id) {
		this.id = id;
	}

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
