package com.sotas.billboard05.service;

import com.sotas.billboard05.dto.TimetableDto;
import com.sotas.billboard05.entity.BillboardSide;
import com.sotas.billboard05.entity.Timetable;

import java.util.List;

public interface TimetableService {
    List<TimetableDto> getByBillboardSide(int beginYear, int beginMonth, int monthCount, int sideId, int surfaceId);
}
