package com.warehouse.controller;

import com.warehouse.model.IncDel;
import com.warehouse.model.UserRepository;
import com.warehouse.service.IncDelRepository;
import com.warehouse.service.IncDelService;
import com.warehouse.service.LangRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by user on 06.10.2016.
 */
@Controller
public class IncDelController {
    final static Logger log4j = LoggerFactory.getLogger(IncDelController.class);

    @Autowired
    IncDelRepository incDelRepository;
    @Autowired
    IncDelService incDelService;
    @Autowired
    LangRepository langRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    HttpSession httpSession;
    @Autowired
    HttpServletRequest httpServletRequest;


    @GetMapping("/incDel/new")
    public String newDelivery(Model model) {

        model.addAttribute("topTitle", "New Delivery");
        model.addAttribute("sideBarTitle", "Admin Panel");
        model.addAttribute("sideBarSubTitle", "General");
        model.addAttribute("switch", "incDel");


        model.addAttribute("incDel",new IncDel());

        return "admin";
    }

    @PostMapping("/incDel/new")
    public String newIncDelReg(Model model ,@Valid IncDel incDel,BindingResult errors) {

        if(!errors.hasErrors()) {

            model.addAttribute("error", " add succefull ");
        }
        incDelRepository.save(incDel);
        return "admin";
    }

    @ModelAttribute("urlReq")
    public String urlReq() {
        return String.valueOf(httpServletRequest.getRequestURL());
    }
    @ModelAttribute("uriReq")
    public String uriReq() {
        return String.valueOf(httpServletRequest.getRequestURI());
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
        return userName;
    }


}





