package org.bk.memberservice.service;

import java.util.List;

import org.bk.memberservice.types.MemberDetail;

public interface MemberManager {
	MemberDetail create(MemberDetail memberDetail);
	MemberDetail update(MemberDetail memberDetail);
	boolean delete(Long id);
	public List<MemberDetail> findByMemberName(String name);
	public MemberDetail findByMemberId(Long id);
}
