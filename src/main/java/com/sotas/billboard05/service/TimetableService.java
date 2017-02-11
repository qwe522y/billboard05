package com.sotas.billboard05.service;

import com.sotas.billboard05.dto.TimetableSideDto;
import com.sotas.billboard05.entity.Timetable;

public interface TimetableService {
    TimetableSideDto getByBillboardSide(int beginYear, int beginMonth, int sideId);
    void update(Timetable timetable);
    Timetable getByUniq(int sideId, int surfaceId, int year, int month);
    Timetable add(Timetable tt);
    Timetable get(int id);
}
