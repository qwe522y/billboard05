package com.sotas.billboard05.service;

import com.sotas.billboard05.dto.BillboardDto;
import com.sotas.billboard05.entity.Billboard;
import com.sotas.billboard05.entity.BillboardSide;

import java.util.List;
import java.util.Map;

public interface BillboardService {
    List<BillboardDto> getListByAgent(int agentId);
    List<BillboardDto> getListByCity(int cityId);

    List<BillboardDto> getAll();

    Billboard add(Billboard billboard, List<BillboardSide> bbSideList, String photoDir, Map<String, byte[]> photoFiles);
    Billboard get(int id);
}
