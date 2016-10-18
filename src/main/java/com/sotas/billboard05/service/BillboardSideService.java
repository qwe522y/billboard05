package com.sotas.billboard05.service;

import com.sotas.billboard05.entity.BillboardSide;

import java.util.List;

public interface BillboardSideService {
    BillboardSide get(int id);
    List<BillboardSide> getByBillboard(int billboardId);
    void add(BillboardSide e);
    void update(BillboardSide e);
}
