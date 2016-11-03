package com.sotas.billboard05.service;

import com.sotas.billboard05.dto.TimetableSideDto;
import com.sotas.billboard05.entity.Timetable;

import java.util.List;

public interface TimetableService {
    public TimetableSideDto getByBillboardSide(int beginYear, int beginMonth, int sideId);
    public void update(Timetable timetable);
}
