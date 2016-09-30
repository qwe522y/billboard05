package com.sotas.billboard05.service;

import com.sotas.billboard05.dto.BillboardDto;

import java.util.List;

public interface BillboardService {
    List<BillboardDto> getListByAgent(int agentId);
}
