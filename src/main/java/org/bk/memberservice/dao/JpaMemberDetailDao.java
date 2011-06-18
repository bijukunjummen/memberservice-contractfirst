package org.bk.memberservice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.bk.memberservice.types.MemberDetail;
import org.springframework.stereotype.Repository;

@Repository
public class JpaMemberDetailDao extends JpaDao<Long, MemberDetail> implements MemberDetailDao{

    @Override
    public List<MemberDetail> findByMemberName(String name) {
        EntityManager em = this.getEntityManager();
        TypedQuery<MemberDetail> q = em.createQuery("SELECT o FROM MemberDetail where o.name=:name", MemberDetail.class);
        q.setParameter("name", name);
        return q.getResultList();
    }

}
