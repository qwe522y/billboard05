package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.BillboardFormat;

import java.util.List;

public interface BillboardFormatRepository {
    BillboardFormat get(Integer id);
    List<BillboardFormat> getAll();
}
