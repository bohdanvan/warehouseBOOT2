package com.warehouse.controller;

import com.warehouse.model.IncDel;
import com.warehouse.model.User;
import com.warehouse.model.UserRepository;
import com.warehouse.service.IncDelRepository;
import com.warehouse.service.IncDelService;
import com.warehouse.service.LangRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by user on 06.10.2016.
 */
@Controller
public class UserController {
    final static Logger log4j = LoggerFactory.getLogger(UserController.class);
    private final AtomicLong counter = new AtomicLong();
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


    @GetMapping("/user/new")
    public ModelAndView userNewGet(ModelAndView model) {


        model.setViewName("admin");
        return model;
    }

    @PostMapping("/user/new")
    public ModelAndView userNewPost(ModelAndView model,
                                    @Valid User user ,
                                    BindingResult errors,
                                    @RequestParam("passwordRepit") String passwordRepit) {


       if(!errors.hasErrors()) {

           try {
               User userF = userRepository.findByUserName(user.getUserName());
               log4j.error("user already registred");
               model.addObject("error", "Login "+userF.getUserName() +"already registred ");
               model.setViewName("loginReset");

           } catch (Exception ex) {

               if ((user.getPassword()).equals(passwordRepit)) {

                   user.addRole("ROLE_USER");
                   userRepository.save(user);
                   final AuthenticationManager am = new SampleAuthenticationManager();

                   Authentication request = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
                   Authentication resultat = am.authenticate(request);
                   SecurityContextHolder.getContext().setAuthentication(resultat);

                   model.addObject("pass", true);
                   model.addObject("congratulation", "Congratulation you was registred in system. Please open below link ");
                   model.setViewName("redirect:/admin");

               } else {
                   model.addObject("error", "password incorrect");
//                   model.setViewName("redirect:/log#signup");
                   model.setViewName("loginReset");

               }
           }
       }else {

           model.setViewName("loginReset");
       }


        return model;
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





