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
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by user on 30.10.2016.
 */
@Controller
public class RootController  {
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
//        return "redirect:/log";
        return "root";
    }

    @RequestMapping("/root")
    String root(Model model) {
        return "root";
    }

    @RequestMapping("/home/new")
    public ModelAndView home(ModelAndView model){

        model.addObject("getRequestURI",httpServletRequest.getRequestURI() );
        model.setViewName("home");
        return model;
    }

    @RequestMapping("/home")
    public ModelAndView home(ModelAndView model,
                             HttpServletRequest request,
                             HttpServletResponse response,
                             ServletContext servletContext,
                             TemplateEngine templateEngine)
            throws IOException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        Calendar cal = Calendar.getInstance();

//        WebContext ctx =
//                new WebContext(request, response, servletContext, request.getLocale());
//        ctx.setVariable("today", dateFormat.format(cal.getTime()));
//
//        templateEngine.process("home", ctx, response.getWriter());

        model.addObject("today",dateFormat.format(cal.getTime()));
        model.addObject("user",new User());

        model.addObject("usersList",userRepository.findAll());
        model.addObject("http",httpSession.getLastAccessedTime() );

        model.addObject("tryLogginCount",httpSession.getAttribute("tryLogginCount"));
        model.setViewName("home");
        return model;
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
    model.addObject("user", new User());
    model.setViewName("fixed_sidebar");
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
            httpSession.setAttribute("locale", "eng");
        }

//        try {
//            String locale = (String) httpSession.getAttribute("locale");
//            if (locale.equals("")) {
//                httpSession.setAttribute("locale", "rus");
//            }
//
//        } catch (Exception ex) {
//            httpSession.setAttribute("locale", "rus");
//        }

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