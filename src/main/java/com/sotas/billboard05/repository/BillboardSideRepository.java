package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.BillboardSide;

import java.util.List;

public interface BillboardSideRepository extends CrudRepository<BillboardSide, Integer> {
    List<BillboardSide> getByBillboard(int billboardId);
}
