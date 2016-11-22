package com.warehouse.controller;

import com.warehouse.model.IncDel;
import com.warehouse.model.User;
import com.warehouse.model.UserRepository;
import com.warehouse.model.UserRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by user on 14.11.2016.
 */
@Controller
public class SecurityController {
    @Autowired
    HttpSession httpSession;
    @Autowired
    HttpServletRequest httpServletRequest;
    @Autowired
    UserRepository userRepository;

//    AuthenticationManager

    @GetMapping("/log")
    public String log(Model model) {

        model.addAttribute("user",new User());

        return "login";
    }




    private final AuthenticationManager am = new SampleAuthenticationManager();
    static private int countTryLoggin = 0;


    @PostMapping("/log")
    public ModelAndView logPOST(
            @Valid User user,
            BindingResult errors,

                          HttpServletRequest httpServletRequest,
                          HttpServletResponse httpServletResponse,
                          HttpSession httpSession)
            throws IOException, ServletException {
        ModelAndView model = new ModelAndView();


        try {

            Authentication request = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
            Authentication result = am.authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(result);

            model.setViewName("redirect:/admin");
//            model.setViewName("admin");


        } catch (AuthenticationException e) {

            this.countTryLoggin++;
            httpSession.setAttribute("tryLogginCount", countTryLoggin);

            model.addObject("error",e.toString() );
            model.addObject("tryLogginCount",httpSession.getAttribute("tryLogginCount"));

//            try{
//                countTryLoggin = (int) httpSession.getAttribute("tryLogginCount");
//                countTryLoggin++;
//            }catch (NullPointerException nex) {
//                countTryLoggin = 1;
//                httpSession.setAttribute("tryLogginCount", countTryLoggin);
//            }
//

//            model.setViewName("redirect:/log");
            model.setViewName("login");

        }catch (Exception ex){

            model.addObject("error",ex.toString() );
//            model.setViewName("redirect:/log");
            model.setViewName("login");
        }

        return model;
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
        }catch (Exception ex){}

        model.setViewName("admin");
        return model;
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest req) throws ServletException {
       ModelAndView model = new ModelAndView();
        req.logout();
        model.setViewName("redirect:/log");  // FIXME: 17.11.2016  проверить redirect
//        return new ModelAndView("redirect:/abc.htm")  // как вариант проверить работоспособность
        return model;
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


//    public Authentication authenticate(Authentication auth) throws AuthenticationException {
//        if (auth.getName().equals(auth.getCredentials())) {
//            final List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();
//
////            AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
////            AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
////            AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_GRAND_ADMIN"));
//
//            return new UsernamePasswordAuthenticationToken(auth.getName(),
//                    auth.getCredentials(), AUTHORITIES);
//        }
//        throw new BadCredentialsException("Bad Credentials");
//    }
}







//
//model.addAttribute("req_getName",request.getName() );
//        model.addAttribute("req_getPrincipal",request.getPrincipal().toString() );
//        model.addAttribute("req_getCredentials",request.getCredentials().toString() );
//        model.addAttribute("am",am.toString() );
//        model.addAttribute("r3",result.toString() );
//        model.addAttribute("r2",request.toString() );
//        model.addAttribute("r4",httpServletRequest.authenticate(httpServletResponse) );
//        model.addAttribute("changeSessionId",httpServletRequest.changeSessionId() );
//        model.addAttribute("getAuthType",httpServletRequest.getAuthType() );
//        model.addAttribute("getContextPath",httpServletRequest.getContextPath() );
//        model.addAttribute("getCookies",httpServletRequest.getCookies() );
//        model.addAttribute("getMethod",httpServletRequest.getMethod() );
//        model.addAttribute("getPathInfo",httpServletRequest.getPathInfo() );
//        model.addAttribute("getPathTranslated",httpServletRequest.getPathTranslated() );
//        model.addAttribute("getQueryString",httpServletRequest.getQueryString() );
//        model.addAttribute("getRequestedSessionId",httpServletRequest.getRequestedSessionId() );
//        model.addAttribute("isRequestedSessionIdFromCookie",httpServletRequest.isRequestedSessionIdFromCookie() );
//        model.addAttribute("isRequestedSessionIdFromURL",httpServletRequest.isRequestedSessionIdFromURL() );
//        model.addAttribute("isUserInRole",httpServletRequest.isUserInRole("ADMIN") );
//        model.addAttribute("isUserInRoleUser",httpServletRequest.isUserInRole("USER") );
//        model.addAttribute("isUserInRoleROLE_ADMIN",httpServletRequest.isUserInRole("ROLE_ADMIN") );
//        model.addAttribute("isUserInRoleROLE_USER",httpServletRequest.isUserInRole("ROLE_USER") );
//
//        model.addAttribute("isAsyncStarted",httpServletRequest.isAsyncStarted() );
//        model.addAttribute("isAsyncSupported",httpServletRequest.isAsyncSupported() );
//        model.addAttribute("isSecure",httpServletRequest.isSecure() );
//        model.addAttribute("getRemoteUser",httpServletRequest.getRemoteUser() );
//        model.addAttribute("getRequestURI",httpServletRequest.getRequestURI() );
//        model.addAttribute("getRequestURL",httpServletRequest.getRequestURL() );
////            model.addAttribute("r ",httpServletRequest );
////            model.addAttribute("r ",httpServletRequest );
//
//        model.addAttribute("r5",httpServletResponse.toString() );
//        model.addAttribute("http",httpSession.getLastAccessedTime() );
//
//        model.addAttribute("tryLogginCount",httpSession.getAttribute("tryLogginCount"));


