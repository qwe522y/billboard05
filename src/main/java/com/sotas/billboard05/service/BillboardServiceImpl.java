package com.sotas.billboard05.service;

import com.sotas.billboard05.dto.BillboardDto;
import com.sotas.billboard05.entity.*;
import com.sotas.billboard05.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
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
    private BillboardSideRepository billboardSideRepository;
    private ImgService imgService;

    public BillboardServiceImpl(ImgService imgService, BillboardRepository repository, CityRepository cityRepository, OwnerRepository ownerRepository, BillboardTypeRepository billboardTypeRepository, BillboardFormatRepository billboardFormatRepository, AgentRepository agentRepository, BillboardSideRepository billboardSideRepository) {
        this.imgService = imgService;
        this.repository = repository;
        this.cityRepository = cityRepository;
        this.ownerRepository = ownerRepository;
        this.billboardTypeRepository = billboardTypeRepository;
        this.billboardFormatRepository = billboardFormatRepository;
        this.agentRepository = agentRepository;
        this.billboardSideRepository = billboardSideRepository;
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
    public Billboard add(Billboard billboard, List<BillboardSide> bbSideList, byte[] miniPhoto, byte[][] photoFiles) {
        try {
            Billboard bb = repository.add(billboard);
            for (BillboardSide bbSide : bbSideList) {
                bbSide.setBillboardId(bb.getId());
                billboardSideRepository.add(bbSide);
            }
            imgService.setMiniImg(billboard.getId(), miniPhoto);
            for(byte[] f : photoFiles) {
                imgService.addImg(billboard.getId(), f);
            }
            return bb;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Billboard get(int id) {
        return repository.get(id);
    }

    @Override
    @Transactional
    public void update(Billboard billboard) {
        repository.update(billboard);
    }
}