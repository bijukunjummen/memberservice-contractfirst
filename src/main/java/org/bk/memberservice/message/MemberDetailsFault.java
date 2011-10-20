package org.bk.memberservice.message;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.SERVER, faultStringOrReason = "No Member Found - From @SoapFault annotation")
public class MemberDetailsFault extends RuntimeException{

	public MemberDetailsFault(String faultDetail){
		this.faultDetail = faultDetail;
	}
	
	
	private static final long serialVersionUID = 1L;
	private String faultDetail;

	public String getFaultDetail() {
		return faultDetail;
	}

	public void setFaultDetail(String faultDetail) {
		this.faultDetail = faultDetail;
	}
	
	@Override
	public String toString() {
		return faultDetail;
	}

}
