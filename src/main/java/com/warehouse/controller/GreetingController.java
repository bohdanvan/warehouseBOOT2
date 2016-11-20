//package com.warehouse.controller;
//
//import com.warehouse.model.IncDel;
//import com.warehouse.model.IncDelNewForm;
//import com.warehouse.service.IncDelRepository;
//import com.warehouse.service.LangRepository;
//import com.warehouse.service.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.servlet.http.HttpSession;
//import javax.validation.Valid;
//
///**
// * Created by user on 30.10.2016.
// */
//@Controller
//public class GreetingController {
//
//    @Autowired
//    IncDelRepository incDelRepository;
//    @Autowired
//    LangRepository langRepository;
//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    HttpSession httpSession;
//
//    @GetMapping("/hello")
//    public String hello(Model model) {
//        return "hello";
//    }
//
//
////
////    @GetMapping("/incDelNew")
////    public String formNewIncDel(Model model) {
////        model.addAttribute("incDelNewForm", new IncDel());
////        return "greeting";
////    }
////
////    @PostMapping("/incDelNew")
////    public String newIncDelRegistr(@ModelAttribute IncDel incDelNewForm, Model model ) {
//////        IncDel incDel = new IncDel();
//////        incDel.setEmployeeID(getPrincipal());
//////        incDel.setCurrierTrackNumber(incDelNewForm.getCurrierTrackNumber());
//////        incDelRepository.save(incDel);
////
////        incDelRepository.save(incDelNewForm);
////        model.addAttribute("incDelNewForm",incDelNewForm);
////
////        return "result";
////    }
////
////
////    @GetMapping("/incDel-")
////    public String greetingForm(Model model) {
////        model.addAttribute("incDelNewForm", new IncDelNewForm());
////        return "incDel";
////    }
////
////    @PostMapping("/incDel-")
////    public String greetingSubmit(@ModelAttribute IncDelNewForm incDelNewForm) {
////
////        IncDel incDel = new IncDel();
////        incDel.setEmployeeID(getPrincipal());
////        incDel.setCurrierTrackNumber(incDelNewForm.getCurrierTrackNumber());
////        incDelRepository.save(incDel);
////        return "incDel";
////    }
////
//
//
//
//
//
//    @ModelAttribute("locale")
//    public String locale() {
//
//        try {
//            if (httpSession.isNew()) {
//                httpSession.setAttribute("locale", "eng");
//            }
//        } catch (Exception n) {
//            httpSession.setAttribute("locale", "rus");
//        }
//
//        try {
//            String locale = (String) httpSession.getAttribute("locale");
//            if (locale.equals("")) {
//                httpSession.setAttribute("locale", "rus");
//            }
//
//        } catch (Exception ex) {
//            httpSession.setAttribute("locale", "rus");
//        }
//
//        return (String) httpSession.getAttribute("locale");
//    }
//
//
//    @ModelAttribute("principal")
//    public String initializeUser() {
//        String userName = null;
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        if (principal instanceof UserDetails) {
//            userName = ((UserDetails) principal).getUsername();
//
//        } else {
//            userName = principal.toString();
//        }
//
//        if (userName.toUpperCase().equals("ANONYMOUSUSER")) {
//            userName = "";
//        }
//        return userName;
//    }
//
//
//    @ModelAttribute("isAnonym")
//    public String isAuth(HttpSession httpSession) {
//        String result = null;
//        String userName = null;
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        if (principal instanceof UserDetails) {
//            userName = ((UserDetails) principal).getUsername();
//
//        } else {
//            userName = principal.toString();
//        }
//
//        if (userName.toUpperCase().equals("ANONYMOUSUSER")) {
//            result = "";
//        }
//
//        return result;
//    }
//
//
//    private String getPrincipal() {
//        String userName = null;
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        if (principal instanceof UserDetails) {
//            userName = ((UserDetails) principal).getUsername();
//        } else {
//            userName = principal.toString();
//        }
//        return userName;
//    }
//
//
//}
//
