package com.sotas.billboard05.dto;

import com.sotas.billboard05.entity.Timetable;

import java.util.TreeMap;

/**
 * Created by art on 30.10.16.
 */
public class TimetableListDto extends TreeMap<Integer, TimetableDto> {
    private Timetable defaultTimetable;

    public TimetableListDto(Timetable defaultTimetable) {
        this.defaultTimetable = defaultTimetable;
    }

    @Override
    public TimetableDto get(Object key) {
        if(containsKey(key)) return get(key);
        
        return getOrDefault(key, new TimetableDto(defaultTimetable));
    }
}
