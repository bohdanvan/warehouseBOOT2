package com.warehouse.controller;

import com.warehouse.model.IncDel;
import com.warehouse.model.User;
import com.warehouse.model.UserRepository;
import com.warehouse.service.LangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * Created by user on 30.10.2016.
 */
@Controller
public class RootController {
    @Autowired
    LangRepository langRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    HttpSession httpSession;
    @Autowired
    HttpServletRequest httpServletRequest;

    String localess[] = Locale.getISOCountries();
    String localeLang = Locale.getDefault().getISO3Language();
//    String getLocaleLang = userRepository.findByLogin("login").getLanguage();


    @RequestMapping("/")
    String index(Model model) {

        try {
            if (httpSession.isNew()) {
                httpSession.setAttribute("locale", "eng");
            }
        } catch (Exception n) {
            httpSession.setAttribute("locale", "rus");
        }
        return "root";
    }




//    @RequestMapping("/admin/html")
@RequestMapping("/html")
public ModelAndView fixed(ModelAndView model) {

//        if (id == "fixed") {
//            model.addObject("id", id);
//            model.setViewName("fixed_sidebar");
//        }
//        if (id == "admin2") {
//            model.setViewName("admin2");
//        }
    model.addObject("incDel", new IncDel());
    model.setViewName("adminHTML");
    return model;
}


//        try {
//            if (httpSession.getAttribute("locale").equals(null)) {
//                httpSession.setAttribute("locale", "eng");
//            }
//            if (httpSession.getAttribute("locale").equals("")) {
//                httpSession.setAttribute("locale", "aze");
//            }
//
//        } catch (Exception ex) {
//            httpSession.setAttribute("locale", "rus");
//        }

//    @ModelAttribute("locale")
//    public String locale() {
//
//        return Locale.getDefault().getISO3Country();
//    }


    @RequestMapping("/eng")
    ModelAndView langENG() {
        httpSession.setAttribute("locale", "eng");
        return new ModelAndView("redirect:/");
    }

    @RequestMapping("/rus")
    ModelAndView langRUS() {
        httpSession.setAttribute("locale", "rus");
        return new ModelAndView("redirect:/");
    }


    @RequestMapping("/aze")
    ModelAndView langAZE() {
        httpSession.setAttribute("locale", "aze");
        return new ModelAndView("redirect:/");
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////


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

//        return "../static/";
        return "../";
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

        if (userName.toUpperCase().equals("ANONYMOUSUSER")) {
            userName = "";
        }
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


//
//    @RequestMapping("/layout")
//    public ModelAndView layout(ModelAndView model) {
//        model.addObject("user", new User());
//
//        model.setViewName("layout");
//
//        return model;
//    }