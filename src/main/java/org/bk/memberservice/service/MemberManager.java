package org.bk.memberservice.service;

import org.bk.memberservice.types.MemberDetail;

public interface MemberManager {
	MemberDetail getMemberDetails(String id);

}
