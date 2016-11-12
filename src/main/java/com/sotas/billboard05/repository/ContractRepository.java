package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.Contract;
import com.sotas.billboard05.entity.Timetable;

import java.util.List;

public interface ContractRepository extends CrudRepository<Contract, Integer> {
    List<Contract> getByTimetableList(List<Timetable> timetableList);
}
