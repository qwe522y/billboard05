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
import com.sotas.billboard05.service.ImgService;
import com.sotas.billboard05.service.OwnerService;
import com.sotas.billboard05.utils.Utils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/agent/")
public class BillboardController {
    private static Logger log = Logger.getLogger(BillboardController.class);
    private static final char[] alphabet = "ABCDEFGH".toCharArray();
    private BillboardService billboardService;
    private OwnerService ownerService;
    private AuthUserService authUserService;
    private BillboardTypeRepository billboardTypeRepository;
    private CityRepository cityRepository;
    private BillboardFormatRepository billboardFormatRepository;
    private ImgService imgService;

    @Autowired
    public BillboardController(ImgService imgService, BillboardService billboardService, OwnerService ownerService, AuthUserService authUserService, BillboardTypeRepository billboardTypeRepository, CityRepository cityRepository, BillboardFormatRepository billboardFormatRepository) {
        this.imgService = imgService;
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
        if(sideNum > alphabet.length) {
            log.warn("sideNum("+sideNum+") > alphabet("+alphabet.length+")");
            sideNum = alphabet.length;
        }
        List<BillboardSide> bbSideList = new ArrayList<>();
        for (int i = 0; i < sideNum; i++) {
            bbSideList.add(new BillboardSide(0, "" + alphabet[i], rent, 1));
        }
        billboard = billboardService.add(billboard, bbSideList, miniPhoto.getBytes(), new byte[][]{photo.getBytes()});
        return "redirect:side/" + billboard.getId() + "/";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String showEditForm(@PathVariable int id, Model model) {
        Utils.checkAccess(billboardService.get(id), authUserService.getAuthUser());
        model.addAttribute("billboard", billboardService.get(id));
        model.addAttribute("cities", cityRepository.getAll());
        model.addAttribute("owners", ownerService.getByAgent(authUserService.getAuthUser().getAgent().getId()));
        model.addAttribute("billboardTypes", billboardTypeRepository.getAll());
        model.addAttribute("billboardFormats", billboardFormatRepository.getAll());
        model.addAttribute("imgCount", imgService.getImgCount(id));
        return "billboard/edit";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    public String edit(@PathVariable int id, Billboard bb) {
        Utils.checkAccess(billboardService.get(id), authUserService.getAuthUser());
        Billboard originBB = billboardService.get(id);
        originBB.setCityId(bb.getCityId());
        originBB.setTypeId(bb.getTypeId());
        originBB.setFormatId(bb.getFormatId());
        originBB.setAddress(bb.getAddress());
        originBB.setLight(bb.isLight());
        originBB.setOwnerId(bb.getOwnerId());
        originBB.setWidth(bb.getWidth());
        originBB.setHeight(bb.getHeight());
        originBB.setLocation(bb.getLocation());
        billboardService.update(originBB);
        return "redirect:/agent/";
    }

    @RequestMapping(value = "/{id}/updateMiniPhoto", method = RequestMethod.POST)
    public String updateMiniPhoto(@PathVariable int id, MultipartFile miniPhoto) throws IOException {
        Utils.checkAccess(billboardService.get(id), authUserService.getAuthUser());
        imgService.setMiniImg(id, miniPhoto.getBytes());
        return "redirect:/agent/" + id + "/edit";
    }

    @RequestMapping(value = "/{id}/updatePhoto", method = RequestMethod.POST)
    public String updatePhoto(@PathVariable int id, MultipartFile photo, int index, String action) throws IOException {
        Utils.checkAccess(billboardService.get(id), authUserService.getAuthUser());
        if(action.equals("update")) {
            imgService.updateImg(id, photo.getBytes(), index);
        } else if(action.equals("delete")) {
            if(imgService.getImgCount(id) > 1) {
                imgService.deleteImg(id, index);
            }
        }
        return "redirect:/agent/" + id + "/edit";
    }

    @RequestMapping(value = "/{id}/addPhoto", method = RequestMethod.POST)
    public String addPhoto(@PathVariable int id, MultipartFile photo, String action) throws IOException {
        Utils.checkAccess(billboardService.get(id), authUserService.getAuthUser());
        imgService.addImg(id, photo.getBytes());
        return "redirect:/agent/" + id + "/edit";
    }
}
