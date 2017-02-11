package com.sotas.billboard05.service;

import com.sotas.billboard05.dto.TimetableSideDto;
import com.sotas.billboard05.entity.BillboardSide;
import com.sotas.billboard05.entity.Timetable;
import com.sotas.billboard05.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class TimetableServiceImpl implements TimetableService {
    @Autowired
    private TimetableRepository repository;
    @Autowired
    private BillboardSideService billboardSideService;

    @Override
    public TimetableSideDto getByBillboardSide(int beginYear, int beginMonth, int sideId) {
        List<Timetable> list = repository.getByBillboardSideAndBeginDate(sideId, beginYear, beginMonth);
        BillboardSide bbSide = billboardSideService.get(sideId);
        TimetableSideDto res = new TimetableSideDto(bbSide);
        for(Timetable t : list) {
            res.put(t.getSurface(), t.getYear(), t.getMonth(), t);
        }
        return res;
    }

    @Override
    @Transactional
    public void update(Timetable timetable) {
        repository.update(timetable);
    }

    @Override
    public Timetable getByUniq(int sideId, int surfaceId, int year, int month) {
        List<Timetable> list = repository.getByBillboardSideAndBeginDate(sideId, year, month);
        for(Timetable tt : list) {
            if(tt.getSurface() == surfaceId && tt.getYear() == year && tt.getMonth() == month) return tt;
        }
        return null;
    }

    @Override
    @Transactional
    public Timetable add(Timetable tt) {
        return repository.add(tt);
    }

    @Override
    public Timetable get(int id) {
        return repository.get(id);
    }
}
