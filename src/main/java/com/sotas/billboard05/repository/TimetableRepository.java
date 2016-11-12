package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.Timetable;

import java.util.List;

public interface TimetableRepository extends CrudRepository<Timetable, Integer> {
    List<Timetable> getByBillboardSideAndBeginDate(List<Integer> sideIdList, int year, int month);
    List<Timetable> getByBillboardSideAndBeginDate(int sideId, int year, int month);
}
