package org.bk.memberservice.message;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.bk.memberservice.types.MemberDetail;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "MemberSearchResponse", namespace="http://bk.org/memberservice/" )
public class MemberSearchResponse {

	@XmlElementWrapper(name="memberDetails")
	private List<MemberDetail> memberDetails;

	public MemberSearchResponse(){
		//
	}
	
	public MemberSearchResponse(List<MemberDetail> memberDetails){
		this.memberDetails = memberDetails;
	}
	
	public List<MemberDetail> getMemberDetails() {
		return memberDetails;
	}

	public void setMemberDetails(List<MemberDetail> memberDetails) {
		this.memberDetails = memberDetails;
	}
	
	
	
	
}
