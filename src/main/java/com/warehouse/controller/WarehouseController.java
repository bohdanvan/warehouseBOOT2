package com.warehouse.controller;

import com.warehouse.model.*;
import com.warehouse.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by user on 06.10.2016.
 */
@Controller
public class WarehouseController {
    final static Logger log4j = LoggerFactory.getLogger(WarehouseController.class);
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    IncDelRepository incDelRepository;
    @Autowired
    IncDelCrudRepository incDelCrudRepository;
    @Autowired
    OrderIncDelRepository orderIncDelRepository;
    @Autowired
    IncDelService incDelService;
    @Autowired
    WhRepository whRepository;
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    LangRepository langRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    HttpSession httpSession;
    @Autowired
    HttpServletRequest httpServletRequest;
//    @Autowired
//    HttpServletResponse httpServletResponce;

    private final String INCDEL_PATH = "/incDel/new";



    @GetMapping("warehouse/new")
    ModelAndView warehouseNew(ModelAndView model) {
        model.addObject("warehouse", new Warehouse());
        model.addObject("countrysList", countryRepository.findAll());
        log4j.info("size countrys :"+countryRepository.findAll().size());
        model.setViewName("admin");
        return model;
    }


    @PostMapping("warehouse/new")
    ModelAndView warehouPostseNew(ModelAndView model,
                                  @Valid Warehouse warehouse,
                                  BindingResult bindingResult
                                  ) {

       if(!bindingResult.hasErrors()){
           whRepository.save(warehouse);
           log4j.info("wh was saved");
           model.setViewName("redirect:/warehouse/all");

       }else {
           log4j.error(bindingResult.toString());
           model.setViewName("admin");

       }

        return model;
    }

    @GetMapping("warehouse/all")
    ModelAndView warehouseAll(ModelAndView model) {
        model.addObject("whLists", whRepository.findAll());
        model.setViewName("admin");
        return model;
    }

    @GetMapping("warehouse/del")
    ModelAndView warehouseAll(ModelAndView model,@RequestParam String id) {
        model.addObject("whLists", whRepository.findAll());
        model.setViewName("admin");
        return model;
    }





    @ModelAttribute("urlReq")
    public String urlReq() {
        log4j.info("urlReq :" + httpServletRequest.getRequestURL());
        return String.valueOf(httpServletRequest.getRequestURL());
    }

    @ModelAttribute("uriReq")
    public String uriReq() {
        log4j.info("uriReq :" + httpServletRequest.getRequestURI());
        String uri = httpServletRequest.getRequestURI();

        return uri.substring(1, uri.length());

    }

    @ModelAttribute("uriReqSecondParametr")
    public String uriReqSecondParametr() {

        String uri = httpServletRequest.getRequestURI();
        int positionSearchingCh = 0;
        String result;
        char[] chArray = uri.toCharArray();
        for (int i = 1; i < chArray.length; i++) {
            if (chArray[i] == '/') {
                positionSearchingCh = i;
            }
        }
        result = uri.substring(positionSearchingCh + 1, uri.length());

        httpSession.setAttribute("uriReqSecondParametr", result);
        try {
            log4j.info("httpSession uriReqSecondParametr set :" + result);
        } catch (NullPointerException ex) {
            log4j.error("httpSession uriReqSecondParametr set :" + ex.toString());
        }
        return result;
    }


    @ModelAttribute("url")
    public String url() {
        return "../";
    }


    @ModelAttribute("type")
    public String type(HttpSession httpSession) {
        return "client";
    }


    @ModelAttribute("locale")
    public String locale() {

        try {
            if (httpSession.isNew()) {
                httpSession.setAttribute("locale", "eng");
            }
        } catch (Exception n) {
            httpSession.setAttribute("locale", "rus");
        }

        try {
            String locale = (String) httpSession.getAttribute("locale");
            if (locale.equals("")) {
                httpSession.setAttribute("locale", "rus");
            }

        } catch (Exception ex) {
            httpSession.setAttribute("locale", "rus");
        }
        log4j.info("locale :" + (String) httpSession.getAttribute("locale"));
        return (String) httpSession.getAttribute("locale");
    }


    @ModelAttribute("principal")
    public String initializeUser() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();

        } else {
            userName = principal.toString();
        }

//        if (userName.toUpperCase().equals("ANONYMOUSUSER")) {
//            userName = "";
//        }
        log4j.info("principal : " + userName);
        return userName;
    }


    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        log4j.info("getPrincipal :" + userName);
        return userName;
    }


}





