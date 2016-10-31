package com.sotas.billboard05.service;

import com.sotas.billboard05.dto.TimetableDto;
import org.junit.Test;

import java.util.List;

public class TimetableServiceImplTest {
    TimetableService service;
    @Test
    public void getForSurface() {
        List<TimetableDto> r = service.getByBillboardSide(
                2016, //beginYear
                11, //beginMonth
                3, //monthCount
                1, //sideId
                0 //surfaceId
        );
    }
}
