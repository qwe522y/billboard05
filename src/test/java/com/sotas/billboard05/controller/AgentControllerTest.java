package com.sotas.billboard05.controller;

import com.sotas.billboard05.entity.Billboard;
import com.sotas.billboard05.service.BillboardService;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;

import java.util.List;

public class AgentControllerTest extends AbstractControllerTest {
    private AgentController controller;

    @Test
    public void showBillboardsForCurrentAgent() {
        controller = new AgentController(new BillboardService() {
            @Override
            public List<Billboard> getListByCity(int cityId) {
                return null;
            }
        });
        ExtendedModelMap model = new ExtendedModelMap();
        controller.list(model);
        List<Billboard> billboards = (List<Billboard>) model.asMap().get("billboards");


    }
}
