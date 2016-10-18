package com.sotas.billboard05.service;

import com.sotas.billboard05.entity.BillboardSide;
import com.sotas.billboard05.entity.Timetable;
import com.sotas.billboard05.repository.BillboardSideRepository;
import com.sotas.billboard05.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TimetableServiceImpl implements TimetableService {
    @Autowired
    private TimetableRepository repository;
    @Autowired
    private BillboardSideRepository billboardSideRepository;

    @Override
    public List<Timetable> getByBillboardAndBeginDate(int billboardId, int year, int month) {
        List<Timetable> res = new ArrayList<>();
        for(BillboardSide side : billboardSideRepository.getByBillboard(billboardId)) {
            res.addAll(repository.getByBillboardSideAndBeginDate(side.getId(), year, month));
        }
        return res;
    }

    @Override
    public List<Timetable> fillByDefault(List<Timetable> list, BillboardSide billboardSide) {
        return null;
    }
}
