package com.warehouse.controller;

import com.warehouse.model.IncDel;
import com.warehouse.model.OrderIncDel;
import com.warehouse.model.User;
import com.warehouse.model.UserRepository;
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
public class IncDelController {
    final static Logger log4j = LoggerFactory.getLogger(IncDelController.class);
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

//        IncDel incDel = new IncDel();
//        incDel.setNumber(String.valueOf(System.nanoTime()));
        model.addAttribute("incDel", new IncDel());
        log4j.info("Create new IncDel ");
//        log4j.info("IncDel set number / GET " + incDel.getNumber());
//        incDelRepository.save(incDel);


        if (null == httpSession.getAttribute("incDelNumber")) {
            log4j.warn("http incDelNumber set : null");
        } else {

        }

        return "admin";
    }


    @PostMapping("/incDel/new")
    public String newIncDelReg(Model model, @Valid IncDel incDel, BindingResult errors) {


        if (errors.getErrorCount() == 0) {
            log4j.info("errors == 0 ");
            log4j.info(errors.toString());

            incDel.setNumber(getPrincipal() + "-" + System.nanoTime());
            incDelRepository.save(incDel);
            log4j.info("incDel was saved / number is : " + incDel.getNumber());
            httpSession.setAttribute("incDelNumber", incDel.getNumber());
            log4j.info("http incDelNumber set :" + httpSession.getAttribute("incDelNumber").toString());


        } else {
            log4j.warn(errors.toString());

        }

        incDel.setBoxQty(1);


//
////        IncDel incDelF = incDelRepository.findByNumber(incDel.getNumber()).orElse(new IncDel("test"));
//        IncDel incDelF = incDelRepository.findByNumber(incDel.getNumber());
//        incDelF.setCurrierCompany("initialization on POST");
//        incDelF.setCustomsType("initialization on GET / POST");
//        incDelF.setBoxQty(2);
//        incDelRepository.save(incDelF);


//


//      if(incDel.getNumber().equals(incDelF.getNumber())) {
//          log4j.info(" serching number : " + incDel.getNumber() + " | find :" + incDelF.getNumber());
////        log4j.info(" serching number : equals");
//          log4j.info(" incDelF :" + incDelF.toString());
//                  model.addAttribute("info", " serching number : " + incDel.getNumber()+" | find :"+ incDelF.getNumber());
//
//
//      }
//        IncDel incDel2 = new IncDel("incDel2");
//        incDel2.setSupplier("supplier");
//        incDel2.setCurrierTrackNumber(String.valueOf(incDel.getSupplier()));
//        incDel2.setCustomsType(incDel.getNumber());
//        incDel2.setDestinationFROM(String.valueOf(incDel.getId()));
//        System.out.println(incDel.toString());
//        try {
//            incDel2 = incDelRepository.findOne(incDel.getId());
//        }catch (NullPointerException ex){
//            model.addAttribute("error", " Nullpointer ex : "+ex.toString());
//        }

        return "admin";
    }


    @PostMapping("incDel/orderProduct/add")
    ModelAndView addOrderToIncDel(ModelAndView modal, @Valid OrderIncDel orderIncDel, IncDel incDel) {

        log4j.info("Start orderProduct/add");
        try {
            incDel = incDelRepository.findByNumber(httpSession.getAttribute("incDelNumber").toString());
            orderIncDel.setIncDelJOIN(incDel);
            orderIncDelRepository.save(orderIncDel);
        } catch (NullPointerException ne) {
            log4j.warn(" @PostMapping incDel/orderProduct/add : " + ne.toString());
        } catch (Exception ex) {
            log4j.warn(ex.toString());

        }
        modal.setViewName("redirect:/incDel/new");
        return modal;
    }

    @GetMapping("incDel/registred/")
    ModelAndView registred(ModelAndView modal) {

        try {
            modal.addObject("incDel", incDelRepository.findByNumber(httpSession.getAttribute("incDelNumber").toString()));
        } catch (NullPointerException nex) {
            log4j.error(nex.toString());
        }

        modal.setViewName("admin");
        return modal;
    }


    @RequestMapping("/admin")
    public ModelAndView adminPage(ModelAndView model) {

        try {  // FIXME: 14.11.2016  language
            if (httpSession.isNew()) {
                httpSession.setAttribute("locale", "eng");
            }
        } catch (Exception n) {
            httpSession.setAttribute("locale", "rus");
        }

        try {
            model.addObject("usersList", userRepository.findAll());
        } catch (Exception ex) {
        }

        model.addObject("user", new User());
        model.addObject("incDel", new IncDel());
        model.setViewName("admin");
        return model;
    }


//    @ModelAttribute("incDel")
//    public IncDel incDel() {
//        try{
//            return incDelRepository.findByNumber(httpSession.getAttribute("incDelNumber").toString());
//        }catch (NullPointerException nex){
//            log4j.warn("@model IncDel was didint find  - return new ");
//            return new IncDel("Generate automaticly");
//        }
//    }


    @ModelAttribute("productsList")
    public List<String> productsList() {
        List<String> productsList = new ArrayList<>();
        productsList.add("Shoes");
        productsList.add("Strings");
        productsList.add("Shorts");
        return productsList;
    }

    @ModelAttribute("ordersIncDelList")
    public List<OrderIncDel> ordersIncDelList() {

        try {
            IncDel incDel = incDelRepository.findByNumber(httpSession.getAttribute("incDelNumber").toString());
            return (List<OrderIncDel>) orderIncDelRepository.findByIncDelJOIN(incDel);
        } catch (NullPointerException ex) {
            OrderIncDel orderIncDel = new OrderIncDel();
            orderIncDel.setProductName("here must be your product");
            List<OrderIncDel> ordersIncDelList = new ArrayList<>();
            ordersIncDelList.add(orderIncDel);
            return ordersIncDelList;
        }

    }

    @ModelAttribute("orderIncDel")
    public OrderIncDel orderIncDel() {
        return new OrderIncDel();
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





