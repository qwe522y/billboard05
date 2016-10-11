package com.sotas.billboard05.service;

import com.sotas.billboard05.dto.BillboardDto;
import com.sotas.billboard05.entity.Billboard;

import java.util.List;

public interface BillboardService {
    List<BillboardDto> getListByAgent(int agentId);
    List<BillboardDto> getListByCity(int cityId);

    List<BillboardDto> getAll();

    void add(Billboard billboard);
}
