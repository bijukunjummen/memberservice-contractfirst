package org.bk.memberservice.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="MemberSearchRequest", namespace="http://bk.org/memberservice/")
@XmlAccessorType(XmlAccessType.FIELD)
public class MemberSearchRequest {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
