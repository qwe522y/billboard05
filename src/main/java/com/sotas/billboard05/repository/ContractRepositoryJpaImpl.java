package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.Contract;
import com.sotas.billboard05.entity.Timetable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContractRepositoryJpaImpl extends CrudRepositoryJpaImpl<Contract, Integer> implements ContractRepository {
    public ContractRepositoryJpaImpl() {
        super(Contract.class);
    }


    @Override
    public List<Contract> getByTimetableList(List<Timetable> timetableList) {
        List<Integer> ttIdList = new ArrayList<>();
        for(Timetable tt : timetableList) ttIdList.add(tt.getId());
        return getEntityManager().createQuery("SELECT e FROM Contract e WHERE e.timetableId IN :ttlist", Contract.class).setParameter("ttlist", ttIdList).getResultList();
    }
}
