package com.sotas.billboard05.service;

import com.sotas.billboard05.DateUtils;
import com.sotas.billboard05.entity.Billboard;
import com.sotas.billboard05.entity.Timetable;
import com.sotas.billboard05.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TimetableServiceImpl implements TimetableService {
    private TimetableRepository repository;

    @Autowired
    public TimetableServiceImpl(TimetableRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Timetable> getActualsByBillboard(int billboardId, int year, int month) {
        return repository.getActualsByBillboard(billboardId, year, month);
    }

    @Override
    public List<Timetable> filterForSurface(List<Timetable> list, int year, int month, int monthNum, int billboardId, int side, int surface) {
        List<Timetable> res = new ArrayList<>();
        int begin = year*12 + month;
        int end = year*12 + month + monthNum-1;
        for(Timetable tt : list) {
            int d = tt.getYear() *12 + tt.getMonth();
            if(begin <= d && end >= d) {
                res.add(tt);
            }
        }
        Collections.sort(list, new Comparator<Timetable>() {
            @Override
            public int compare(Timetable o1, Timetable o2) {
                return new Integer(o1.getYear()*12 + o1.getMonth()).compareTo(o2.getYear()*12 + o2.getMonth());
            }
        });
    }

    @Override
    public List<Timetable> fillByDefault(List<Timetable> list, Billboard bb) {
        return null;
    }
}
