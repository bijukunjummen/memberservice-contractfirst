package org.bk.memberservice.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="MemberDetailsRequest", namespace="http://bk.org/memberservice/")
@XmlAccessorType(XmlAccessType.FIELD)
public class MemberDetailsRequest {

	public MemberDetailsRequest() {
	}

	public MemberDetailsRequest(Long id) {
		this.id = id;
	}

	@XmlElement(namespace="http://bk.org/memberservice/")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
