package com.sotas.billboard05.service;

import com.sotas.billboard05.dto.TimetableDto;
import com.sotas.billboard05.entity.BillboardSide;
import com.sotas.billboard05.entity.Timetable;
import com.sotas.billboard05.repository.BillboardSideRepository;
import com.sotas.billboard05.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Component
public class TimetableServiceImpl implements TimetableService {
    @Autowired
    private TimetableRepository repository;


    @Override
    public List<TimetableDto> getByBillboardSide(int beginYear, int beginMonth, int sideId, int surfaceId) {
        List<Timetable> list = repository.getByBillboardSideAndBeginDate(sideId, beginYear, beginMonth);
        TreeMap<Integer, TimetableDto> map = new TreeMap<>();

    }
}
