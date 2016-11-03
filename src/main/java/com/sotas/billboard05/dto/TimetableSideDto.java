package com.sotas.billboard05.dto;

import com.sotas.billboard05.entity.BillboardSide;
import com.sotas.billboard05.entity.Timetable;

import java.util.HashMap;
import java.util.TreeMap;

public class TimetableSideDto extends TreeMap<Integer, TreeMap<Integer, TreeMap<Integer, Timetable>>> {
    private BillboardSide bbSide;

    public TimetableSideDto(BillboardSide bbSide) {
        this.bbSide = bbSide;
    }

    public void put(int surfaceId, int year, int month, Timetable timetable) {
        if(!containsKey(surfaceId)) put(surfaceId, new TreeMap<Integer, TreeMap<Integer, Timetable>>());
        if(!get(surfaceId).containsKey(year)) get(surfaceId).put(year, new TreeMap<>());
        get(surfaceId).get(year).put(month, timetable);
    }

    public Timetable get(int surfaceId, int year, int month) {
        Timetable defaultTimetable = new Timetable(bbSide.getId(), surfaceId, month, year, bbSide.getRent(), Timetable.Status.DEFAULT);
        if(!containsKey(surfaceId) || !get(surfaceId).containsKey(year)) return defaultTimetable;
        return get(surfaceId).get(year).getOrDefault(month, defaultTimetable);
    }

    public BillboardSide getBbSide() {
        return bbSide;
    }
}
