package com.sotas.billboard05.dto;

import com.sotas.billboard05.entity.BillboardSide;
import com.sotas.billboard05.entity.Timetable;

import java.util.TreeMap;

public class TimetableSideDto {
    private TreeMap<Integer, TreeMap<Integer, TreeMap<Integer, Timetable>>> map = new TreeMap<>();
    private BillboardSide bbSide;

    public TimetableSideDto(BillboardSide bbSide) {
        this.bbSide = bbSide;
    }

    public void put(int surfaceId, int year, int month, Timetable timetable) {
        if(!map.containsKey(surfaceId)) map.put(surfaceId, new TreeMap<Integer, TreeMap<Integer, Timetable>>());
        if(!map.get(surfaceId).containsKey(year)) map.get(surfaceId).put(year, new TreeMap<>());
        map.get(surfaceId).get(year).put(month, timetable);
    }

    public Timetable get(int surfaceId, int year, int month) {
        Timetable defaultTimetable = new Timetable(bbSide.getId(), surfaceId, month, year, bbSide.getRent(), Timetable.Status.OPEN);
        if(!map.containsKey(surfaceId) || !map.get(surfaceId).containsKey(year)) return defaultTimetable;
        return map.get(surfaceId).get(year).getOrDefault(month, defaultTimetable);
    }

    public BillboardSide getBbSide() {
        return bbSide;
    }
}
