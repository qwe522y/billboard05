package com.sotas.billboard05.service;

import com.sotas.billboard05.dto.BillboardDto;
import com.sotas.billboard05.entity.*;
import com.sotas.billboard05.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class BillboardServiceImpl implements BillboardService {
    @Autowired
    private BillboardRepository repository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private BillboardTypeRepository billboardTypeRepository;
    @Autowired
    private BillboardFormatRepository billboardFormatRepository;
    @Autowired
    private AgentRepository agentRepository;

    @Override
    public List<BillboardDto> getListByAgent(int agentId) {
        Agent agent = agentRepository.get(agentId);
        List<Billboard> list = repository.getListByAgent(agentId);
        List<Owner> owners = ownerRepository.getAll();
        List<BillboardType> billboardTypes = billboardTypeRepository.getAll();
        List<City> cities = cityRepository.getAll();
        List<BillboardFormat> billboardFormats = billboardFormatRepository.getAll();
        Map<Integer, City> cityMap =  cities.stream().collect(Collectors.toMap(City::getId, Function.identity()));
        Map<Integer, BillboardType> billboardTypeMap =  billboardTypes.stream().collect(Collectors.toMap(BillboardType::getId, Function.identity()));
        Map<Integer, Owner> ownerMap =  owners.stream().collect(Collectors.toMap(Owner::getId, Function.identity()));
        Map<Integer, BillboardFormat> billboardFormatMap = billboardFormats.stream().collect(Collectors.toMap(BillboardFormat::getId, Function.identity()));
        List<BillboardDto> res = new ArrayList<>();
        for(Billboard e : list) {
            res.add(new BillboardDto(e, ownerMap.get(e.getOwnerId()), agent, cityMap.get(e.getCityId()), billboardTypeMap.get(e.getTypeId()), billboardFormatMap.get(e.getFormatId())));
        }
        return res;
    }

    @Override
    public List<BillboardDto> getListByCity(int cityId) {
        return genBillboardDtoList(repository.getListByCity(cityId));
    }

    @Override
    public List<BillboardDto> getAll() {
        return genBillboardDtoList(repository.getAll());

    }

    private List<BillboardDto> genBillboardDtoList(List<Billboard> list) {
        List<Agent> agents = agentRepository.getAll();
        List<BillboardType> billboardTypes = billboardTypeRepository.getAll();
        List<City> cities = cityRepository.getAll();
        List<BillboardFormat> billboardFormats = billboardFormatRepository.getAll();
        Map<Integer, City> cityMap =  cities.stream().collect(Collectors.toMap(City::getId, Function.identity()));
        Map<Integer, BillboardType> billboardTypeMap =  billboardTypes.stream().collect(Collectors.toMap(BillboardType::getId, Function.identity()));
        Map<Integer, BillboardFormat> billboardFormatMap = billboardFormats.stream().collect(Collectors.toMap(BillboardFormat::getId, Function.identity()));
        Map<Integer, Agent> agentMap = agents.stream().collect(Collectors.toMap(Agent::getId, Function.identity()));
        List<BillboardDto> res = new ArrayList<>();
        for(Billboard e : list) {
            res.add(new BillboardDto(e, null, agentMap.get(e.getAgentId()), cityMap.get(e.getCityId()), billboardTypeMap.get(e.getTypeId()), billboardFormatMap.get(e.getFormatId())));
        }
        return res;
    }

    @Override
    @Transactional
    public void add(Billboard billboard) {
        repository.add(billboard);
    }
}