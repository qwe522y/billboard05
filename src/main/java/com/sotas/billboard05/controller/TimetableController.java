package com.sotas.billboard05.controller;

import com.sotas.billboard05.dto.TimetableSideDto;
import com.sotas.billboard05.entity.BillboardSide;
import com.sotas.billboard05.entity.Timetable;
import com.sotas.billboard05.service.BillboardSideService;
import com.sotas.billboard05.service.TimetableService;
import com.sotas.billboard05.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/agent/timetable/")
public class TimetableController {
    @Autowired
    private BillboardSideService billboardSideService;
    @Autowired
    private TimetableService timetableService;

    @RequestMapping(value = "{bbId}/", method = RequestMethod.GET)
    public String list(Model model, @PathVariable int bbId) {
        Calendar cal = Calendar.getInstance();
        List<BillboardSide> sides = billboardSideService.getByBillboard(bbId);
        ArrayList<TimetableSideDto> sidesDto = new ArrayList<>();
        for(BillboardSide side : sides) {
            sidesDto.add(timetableService.getByBillboardSide(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), side.getId()));
        }
        model.addAttribute("sides", sidesDto);
        model.addAttribute("months", Utils.genMonth(new Date(), 3));
        return "timetable/list";
    }

    @RequestMapping(value = "{bbId}/", method = RequestMethod.POST)
    public String updateTimetable(@PathVariable int bbId, int sideId, int surfaceId, int year, int month, BigDecimal rent, int status) {
        Timetable t = new Timetable(sideId, surfaceId, month, year, rent, status);
        timetableService.update(t);
        return "redirect:.";
    }
}
