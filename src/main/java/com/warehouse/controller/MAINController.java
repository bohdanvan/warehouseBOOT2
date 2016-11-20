package com.warehouse.controller;

import com.warehouse.model.IncDel;
import com.warehouse.model.UserRepository;
import com.warehouse.service.LangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * Created by user on 30.10.2016.
 */
@Controller
public class MAINController {
    @Autowired
    LangRepository langRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    HttpSession httpSession;

    private final String localess[] = Locale.getISOCountries();
    private String localeLang = Locale.getDefault().getISO3Language();
//    String getLocaleLang = userRepository.findByLogin("login").getLanguage();


    @RequestMapping("/forward")
    public ModelAndView model() {

        ModelAndView model = new ModelAndView("forward:/loginJSP.jsp");
        model.addObject("msg", "Forward Handled");
        return model;
    }




}