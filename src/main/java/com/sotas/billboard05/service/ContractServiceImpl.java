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
    private ContractRepository repository;
    private TimetableRepository timetableRepository;
    private BillboardSideRepository billboardSideRepository;
    private BillboardRepository billboardRepository;
    private TimetableService timetableService;

    @Autowired
    public ContractServiceImpl(ContractRepository repository, TimetableRepository timetableRepository, BillboardSideRepository billboardSideRepository, BillboardRepository billboardRepository, TimetableService timetableService) {
        this.repository = repository;
        this.timetableRepository = timetableRepository;
        this.billboardSideRepository = billboardSideRepository;
        this.billboardRepository = billboardRepository;
        this.timetableService = timetableService;
    }

    @Override
    @Transactional
    public void accept(Contract contract) {
        contract.setStatus(Contract.Status.ACCEPTED);
        repository.update(contract);
        Timetable timetable = timetableService.get(contract.getTimetableId());
        timetable.setStatus(Timetable.Status.CLOSE);
        timetableService.update(timetable);
    }

    @Override
    @Transactional
    public void reject(Contract contract) {
        contract.setStatus(Contract.Status.REJECTED);
        repository.update(contract);
    }

    @Override
    public List<ContractDto> getByAgentId(int agentId, int beginYear, int beginMonth) {
        List<Billboard> bbList = billboardRepository.getListByAgent(agentId);
        if(bbList.isEmpty()) return new ArrayList<>();
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

    @Override
    public Contract get(int id) {
        return repository.get(id);
    }

    @Override
    @Transactional
    public void remove(int id) {
        repository.remove(id);
    }
}
