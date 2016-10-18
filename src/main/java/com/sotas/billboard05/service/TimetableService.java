package com.sotas.billboard05.service;

import com.sotas.billboard05.entity.BillboardSide;
import com.sotas.billboard05.entity.Timetable;

import java.util.List;

public interface TimetableService {
    List<Timetable> getByBillboardAndBeginDate(int billboardId, int year, int month);
    List<Timetable> fillByDefault(List<Timetable> list, BillboardSide billboardSide);
}
