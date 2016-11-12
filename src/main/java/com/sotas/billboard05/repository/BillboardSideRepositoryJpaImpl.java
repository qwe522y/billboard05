package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.BillboardSide;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BillboardSideRepositoryJpaImpl extends CrudRepositoryJpaImpl<BillboardSide, Integer> implements BillboardSideRepository {
    public BillboardSideRepositoryJpaImpl() {
        super(BillboardSide.class);
    }

    @Override
    public List<BillboardSide> getByBillboard(int billboardId) {
        return getEntityManager().createQuery("SELECT e FROM BillboardSide e WHERE e.billboardId=:id", BillboardSide.class).setParameter("id", billboardId).getResultList();
    }

    @Override
    public List<BillboardSide> getByBillboard(List<Integer> billboardIdList) {
        return getEntityManager().createQuery("SELECT e FROM BillboardSide e WHERE e.billboardId IN :idList", BillboardSide.class).setParameter("idList", billboardIdList).getResultList();
    }
}
