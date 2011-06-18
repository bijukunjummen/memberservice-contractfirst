package org.bk.memberservice.service;

import java.util.List;

import javax.annotation.Resource;

import org.bk.memberservice.dao.MemberDetailDao;
import org.bk.memberservice.types.MemberDetail;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberManagerImpl implements MemberManager {

    @Resource private MemberDetailDao memberDetailDao;
    
    @Override
    @Transactional
    public MemberDetail create(MemberDetail memberDetail) {
        return this.memberDetailDao.persist(memberDetail);
    }

    @Override
    @Transactional
    public MemberDetail update(MemberDetail memberDetail) {
        return this.memberDetailDao.update(memberDetail);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        MemberDetail memberDetail = this.memberDetailDao.findById(id);
        
        if (memberDetail!=null){
            this.memberDetailDao.remove(memberDetail);
            return true;
        }
        return false;
        
    }

    @Override
    public List<MemberDetail> findByMemberName(String name) {
        return this.memberDetailDao.findByMemberName(name);
    }

    @Override
    public MemberDetail findByMemberId(Long id) {
        return this.memberDetailDao.findById(id);
    }

}
