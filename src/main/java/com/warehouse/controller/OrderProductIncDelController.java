package com.warehouse.controller;

import com.warehouse.model.IncDel;
import com.warehouse.model.OrderIncDel;
import com.warehouse.model.UserRepository;
import com.warehouse.service.IncDelRepository;
import com.warehouse.service.IncDelService;
import com.warehouse.service.LangRepository;
import com.warehouse.service.OrderIncDelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * Created by user on 06.10.2016.
 */
@RestController
//@RequestMapping("incDel/orderProduct/{incDelNumber}/{productName}/{qty}/{price}")
@RequestMapping("incDel/orderProduct/{incDelNumber}")
public class OrderProductIncDelController {
    final static Logger log4j = LoggerFactory.getLogger(OrderProductIncDelController.class);

    @Autowired
    IncDelRepository incDelRepository;
    @Autowired
    IncDelService incDelService;
    @Autowired
    OrderIncDelRepository orderIncDelRepository;
    @Autowired
    LangRepository langRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    HttpSession httpSession;
    @Autowired
    HttpServletRequest httpServletRequest;




    @RequestMapping
    Collection<OrderIncDel>  ordersIncDel(@PathVariable String incDelNumber )
                                         /* @PathVariable String productName,
                                          @PathVariable String qty,
                                          @PathVariable String price) */{ /*@RequestParam (name = "incDelNumber")String incDelNumber2*/

        IncDel incDel = incDelRepository.findByNumber(incDelNumber).orElseThrow(() -> new IncDelNotFoundExeption(incDelNumber));

        OrderIncDel orderIncDel = new OrderIncDel();   // FIXME: 24.11.2016   это добавление должно быть в POST - +   orderIncDel.setUrl("url");
        orderIncDel.setProductName("productName");
        orderIncDel.setUrl("url");
        orderIncDel.setQty(10);
        orderIncDel.setPrice(100);

        orderIncDel.setIncDelJOIN(incDel);
        orderIncDelRepository.save(orderIncDel);

        return orderIncDelRepository.findByIncDelJOIN(incDel);
    }


    @RequestMapping(method = RequestMethod.POST)
    public void addOrder (@PathVariable String incDelNumber, @RequestBody OrderIncDel orderIncDel){


        IncDel incDel = incDelRepository.findByNumber(incDelNumber)
                .orElseThrow(() -> new IncDelNotFoundExeption(incDelNumber)); //
        orderIncDel.setIncDelJOIN(incDel);
        orderIncDelRepository.save(orderIncDel);
    }



    @ResponseStatus(HttpStatus.NOT_FOUND)
    class IncDelNotFoundExeption extends RuntimeException{
        public IncDelNotFoundExeption(String incDelNumber){
            super("could not found : " + incDelNumber +" number");
        }

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










