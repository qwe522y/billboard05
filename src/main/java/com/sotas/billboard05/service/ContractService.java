package com.sotas.billboard05.service;

import com.sotas.billboard05.dto.ContractDto;
import com.sotas.billboard05.entity.Contract;

import java.util.List;

public interface ContractService {
    void accept(Contract contract);
    void reject(Contract contract);
    List<ContractDto> getByAgentId(int agentId, int beginYear, int beginMonth);
    void add(Contract contract);
    Contract get(int id);
    void remove(int id);
}
