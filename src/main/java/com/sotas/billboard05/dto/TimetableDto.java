package com.sotas.billboard05.dto;

import com.sotas.billboard05.entity.Timetable;

import java.util.HashMap;
import java.util.TreeMap;

public class TimetableDto extends TreeMap<String, Timetable> {
    private Timetable defaultTimetable;

    public TimetableDto(Timetable defaultTimetable) {
        this.defaultTimetable = defaultTimetable;
    }

    @Override
    public Timetable get(Object key) {
        return getOrDefault(key, defaultTimetable);
    }
}
