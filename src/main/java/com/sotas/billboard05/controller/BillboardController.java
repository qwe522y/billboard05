package com.sotas.billboard05.controller;

import com.sotas.billboard05.AuthUser;
import com.sotas.billboard05.dto.BillboardDto;
import com.sotas.billboard05.entity.Billboard;
import com.sotas.billboard05.entity.BillboardSide;
import com.sotas.billboard05.repository.BillboardFormatRepository;
import com.sotas.billboard05.repository.BillboardTypeRepository;
import com.sotas.billboard05.repository.CityRepository;
import com.sotas.billboard05.service.AuthUserService;
import com.sotas.billboard05.service.BillboardService;
import com.sotas.billboard05.service.BillboardSideService;
import com.sotas.billboard05.service.OwnerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/agent/")
public class BillboardController {
    private static Logger log = Logger.getLogger(BillboardController.class);
    private static final char[] alphabet = "ABCDEFGH".toCharArray();
    private BillboardSideService billboardSideService;
    private BillboardService billboardService;
    private OwnerService ownerService;
    private AuthUserService authUserService;
    private BillboardTypeRepository billboardTypeRepository;
    private CityRepository cityRepository;
    private BillboardFormatRepository billboardFormatRepository;
    private String photoDir;

    @Autowired
    public BillboardController(String photoDir, BillboardSideService billboardSideService, BillboardService billboardService, OwnerService ownerService, AuthUserService authUserService, BillboardTypeRepository billboardTypeRepository, CityRepository cityRepository, BillboardFormatRepository billboardFormatRepository) {
        this.photoDir = photoDir;
        this.billboardSideService = billboardSideService;
        this.billboardService = billboardService;
        this.ownerService = ownerService;
        this.authUserService = authUserService;
        this.billboardTypeRepository = billboardTypeRepository;
        this.cityRepository = cityRepository;
        this.billboardFormatRepository = billboardFormatRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        AuthUser authUser = authUserService.getAuthUser();
        List<BillboardDto> list = billboardService.getListByAgent(authUser.getAgent().getId());
        model.addAttribute("billboards", list);
        return "billboard/list";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        AuthUser authUser = authUserService.getAuthUser();
        model.addAttribute("cities", cityRepository.getAll());
        model.addAttribute("owners", ownerService.getByAgent(authUser.getAgent().getId()));
        model.addAttribute("billboardTypes", billboardTypeRepository.getAll());
        model.addAttribute("billboardFormats", billboardFormatRepository.getAll());
        model.addAttribute("billboard", new Billboard());
        return "billboard/add_form";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addBillboard(int sideNum, BigDecimal rent, Billboard billboard, MultipartFile miniPhoto, MultipartFile photo) throws IOException {
        AuthUser authUser = authUserService.getAuthUser();
        billboard.setAgentId(authUser.getAgent().getId());

        Map<String, byte[]> photoFiles = new HashMap<>();
        photoFiles.put("0.png", miniPhoto.getBytes());
        photoFiles.put("0.jpg", photo.getBytes());

        List<BillboardSide> bbSideList = new ArrayList<>();
        if(sideNum <= alphabet.length) {
            for (int i = 0; i < sideNum; i++) {
                bbSideList.add(new BillboardSide(0, "" + alphabet[i], rent, 1));
            }
        } else {
            log.warn("sideNum <= alphabet.length is false");
        }
        billboard = billboardService.add(billboard, bbSideList, photoDir, photoFiles);
        return "redirect:side/" + billboard.getId() + "/";
    }
}
