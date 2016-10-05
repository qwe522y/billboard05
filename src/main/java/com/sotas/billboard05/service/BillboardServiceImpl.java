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
    private BillboardRepository repository;
    private CityRepository cityRepository;
    private OwnerRepository ownerRepository;
    private BillboardTypeRepository billboardTypeRepository;
    private BillboardFormatRepository billboardFormatRepository;
    private AgentRepository agentRepository;

    @Autowired
    public BillboardServiceImpl(BillboardRepository repository, CityRepository cityRepository, OwnerRepository ownerRepository, BillboardTypeRepository billboardTypeRepository, BillboardFormatRepository billboardFormatRepository, AgentRepository agentRepository) {
        this.repository = repository;
        this.cityRepository = cityRepository;
        this.ownerRepository = ownerRepository;
        this.billboardTypeRepository = billboardTypeRepository;
        this.billboardFormatRepository = billboardFormatRepository;
        this.agentRepository = agentRepository;
    }

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
    @Transactional
    public void add(Billboard billboard) {
        repository.add(billboard);
    }
}