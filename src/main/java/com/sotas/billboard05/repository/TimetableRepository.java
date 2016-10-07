package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.Timetable;

import java.util.List;

public interface TimetableRepository extends CrudRepository<Timetable, Integer> {
    List<Timetable> getActualsByBillboard(int billboardId, int year, int month);
}
