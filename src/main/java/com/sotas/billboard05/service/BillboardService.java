package com.sotas.billboard05.service;

import com.sotas.billboard05.entity.Billboard;

import java.util.List;

public interface BillboardService {
    List<Billboard> getListByCity(int cityId);

}
