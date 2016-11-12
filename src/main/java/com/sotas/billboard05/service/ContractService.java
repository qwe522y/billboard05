package com.sotas.billboard05.service;

import com.sotas.billboard05.dto.ContractDto;
import com.sotas.billboard05.entity.Contract;

import java.util.List;

public interface ContractService {
    void update(Contract contract);
    List<ContractDto> getByAgentId(int agentId, int beginYear, int beginMonth);
}
