package com.sotas.billboard05.service;

import com.sotas.billboard05.dto.ContractDto;
import com.sotas.billboard05.entity.*;
import com.sotas.billboard05.repository.BillboardRepository;
import com.sotas.billboard05.repository.BillboardSideRepository;
import com.sotas.billboard05.repository.ContractRepository;
import com.sotas.billboard05.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository repository;
    @Autowired
    private TimetableRepository timetableRepository;
    @Autowired
    private BillboardSideRepository billboardSideRepository;
    @Autowired
    private BillboardRepository billboardRepository;

    @Override
    @Transactional
    public void update(Contract contract) {
        repository.update(contract);
    }

    @Override
    public List<ContractDto> getByAgentId(int agentId, int beginYear, int beginMonth) {
        List<Billboard> bbList = billboardRepository.getListByAgent(agentId);
        Map<Integer, Billboard> bbMap=  bbList.stream().collect(Collectors.toMap(Billboard::getId, Function.identity()));
        List<Integer> bbIdList = new ArrayList<>();
        for(Billboard bb : bbList) bbIdList.add(bb.getId());

        List<BillboardSide> bbSideList = billboardSideRepository.getByBillboard(bbIdList);
        Map<Integer, BillboardSide> bbSideMap=  bbSideList.stream().collect(Collectors.toMap(BillboardSide::getId, Function.identity()));
        List<Integer> bbSideIdList = new ArrayList<>();
        for(BillboardSide bbSide : bbSideList) bbSideIdList.add(bbSide.getId());

        List<Timetable> ttList = timetableRepository.getByBillboardSideAndBeginDate(bbSideIdList, beginYear, beginMonth);
        Map<Integer, Timetable> ttMap =  ttList.stream().collect(Collectors.toMap(Timetable::getId, Function.identity()));
        List<Contract> contractList = repository.getByTimetableList(ttList);

        List<ContractDto> res = new ArrayList<>();
        for(Contract contract : contractList) {
            Timetable tt = ttMap.get(contract.getTimetableId());
            BillboardSide bbSide = bbSideMap.get(tt.getSideId());
            Billboard bb = bbMap.get(bbSide.getBillboardId());
            res.add(new ContractDto(contract, tt, bb, bbSide));
        }
        return res;
    }

    @Override
    @Transactional
    public void add(Contract contract) {
        repository.add(contract);
    }
}
