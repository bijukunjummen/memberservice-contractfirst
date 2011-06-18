package org.bk.memberservice.dao;

import java.util.List;

import org.bk.memberservice.types.MemberDetail;

public interface MemberDetailDao extends BaseDao<Long, MemberDetail> {
    List<MemberDetail> findByMemberName(String name);
}
