package com.sotas.billboard05.service;

import com.sotas.billboard05.entity.Billboard;
import com.sotas.billboard05.entity.Timetable;

import java.util.Date;
import java.util.List;

public interface TimetableService {
    List<Timetable> getActualsByBillboard(int billboardId, int year, int month);

    /**
     * @param list
     * @param curDate начальная дата
     * @param monthNum кол-во месяцев от начальной даты
     * @return возвращает отфильтрованный по дате расписание по поверхности
     */
    List<Timetable> filterForSurface(List<Timetable> list, Date curDate, int monthNum, int billboardId, int side, int surface);

    /**
     * @return заполняет недостающие фрагменты расписание автоматически сгенерированными фрагментами
     */
    List<Timetable> fillByDefault(List<Timetable> list, Billboard bb);
}
