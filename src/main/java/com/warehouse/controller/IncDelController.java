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
import javax.servlet.http.HttpServletResponse;
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

    @ModelAttribute("data")
    public String data() {
        try {
//            log4j.info("httpSession.getId() :" + httpSession.getId());
//            log4j.info("httpSession.getMaxInactiveInterval() :" + String.valueOf(httpSession.getMaxInactiveInterval()));
//            log4j.info("httpSession.getServletContext().getContextPath() :" + httpSession.getServletContext().getContextPath());
//            log4j.info("httpSession.getServletContext().getServerInfo() :" + httpSession.getServletContext().getServerInfo());
//            log4j.info("httpSession.getServletContext().getVirtualServerName() :" + httpSession.getServletContext().getVirtualServerName());
//            log4j.info("httpSession.getServletContext().toString() :" + httpSession.getServletContext().toString());
//        log4j.info(" :"+httpSession);

//            log4j.info("httpServletRequest.getQueryString() :" + httpServletRequest.getQueryString());
//            log4j.info("httpServletRequest.getAuthType() :" + httpServletRequest.getAuthType());
//            log4j.info("httpServletRequest.getPathTranslated() :" + httpServletRequest.getPathTranslated());
//            log4j.info("httpServletRequest.getPathInfo() :" + httpServletRequest.getPathInfo());
            log4j.info("httpServletRequest.getContextPath() :" + httpServletRequest.getContextPath());
            log4j.info("httpServletRequest.getServletPath() :" + httpServletRequest.getServletPath());
            log4j.info("httpServletRequest.getLocale() :" + httpServletRequest.getLocale());
            log4j.info("httpServletRequest.getRequestedSessionId() :" + httpServletRequest.getRequestedSessionId());
//            log4j.info("httpServletRequest.getServerPort() :" + httpServletRequest.getServerPort());
//            log4j.info("httpServletRequest.getLocalPort() :" + httpServletRequest.getLocalPort());
            log4j.info("httpServletRequest.getRemotePort() :" + httpServletRequest.getRemotePort());
            log4j.info("httpServletRequest.getUserPrincipal() :" + httpServletRequest.getUserPrincipal());
            log4j.info("httpServletRequest.getRemoteUser() :" + httpServletRequest.getRemoteUser());
//            log4j.info("httpServletRequest.getRemoteAddr() :" + httpServletRequest.getRemoteAddr());
//            log4j.info("httpServletRequest.getRemoteHost() :" + httpServletRequest.getRemoteHost());
//            log4j.info("httpServletRequest.getRemotePort() :" + httpServletRequest.getRemotePort());
//            log4j.info("httpServletResponce.getCharacterEncoding() :" + httpServletResponce.getCharacterEncoding());
//            log4j.info("httpServletResponce.getContentType() :" + httpServletResponce.getContentType());
//            log4j.info(" httpServletResponce.getStatus() :" + httpServletResponce.getStatus());
//            log4j.info("httpServletResponce.getBufferSize() :" + httpServletResponce.getBufferSize());
//            log4j.info("httpServletResponce - get status :" + String.valueOf(httpServletResponce.getStatus()));
//            log4j.info("httpServletResponce.isCommitted() :" + String.valueOf(httpServletResponce.isCommitted()));

        } catch (NullPointerException ex) {
            log4j.error("================ check full data block :" + ex.fillInStackTrace().getLocalizedMessage());
            log4j.error("================ check full data block :" + ex.getStackTrace().toString());
        }
        return new String("data");
    }


    @GetMapping("admin/navigation")
    ModelAndView navigation(ModelAndView modal) {
        modal.setViewName("admin");
        return modal;
    }


    @GetMapping("/incDel/new")
    public String newDelivery(Model model) {
        model.addAttribute("incDel", new IncDel());
        model.addAttribute("countrysList", countryRepository.findAll());

        try {
            httpSession.removeAttribute("incDelNumber");
        } catch (Exception ex) {
            log4j.warn(" @GetMapping(/incDel/new) -  incDelNumber was not found :" + ex.toString());
        }

        return "admin";
    }

    @PostMapping("/incDel/new")
    public String newIncDelReg(Model model, @Valid IncDel incDel, BindingResult errors) {


        if (errors.getErrorCount() == 0) {
            log4j.info(" /incDel/new - BindingResult errors == 0");


            incDel.setNumber(String.valueOf(System.nanoTime()));
            incDel.setStatus("new");
            incDelRepository.save(incDel);
            log4j.info("incDel was saved succes - id is :" + incDel.getId());

            httpSession.setAttribute("incDelNumber", incDel.getNumber());

            try {
                log4j.info("http incDelNumber set :" + httpSession.getAttribute("incDelNumber").toString());
            } catch (NullPointerException ex) {
                log4j.error("httpSession incDel was not found");
            }
            return "redirect:/incDel/registred";

        } else {

            log4j.warn("incDel/new : " + errors.toString());

            return "admin";

        }
    }


    @GetMapping("incDel/registred")
    ModelAndView registred(ModelAndView modal) {

        try {
            IncDel incDel = incDelRepository.findByNumber(httpSession.getAttribute("incDelNumber").toString());
            modal.addObject("incDel", incDel);
            int qty = 0;
            for (OrderIncDel order : orderIncDelRepository.findByIncDelJOIN(incDel)
                    ) {
                qty += order.getQty();
            }
            modal.addObject("qtyProductQty", qty);
            log4j.info("qtyProductQty refresh :" + qty);
        } catch (NullPointerException nex) {
            log4j.error("incDel/registred :" + nex.toString());
        }

        modal.setViewName("admin");
        return modal;
    }


    @GetMapping("incDel/edit")
    ModelAndView registredParam(ModelAndView modal, @RequestParam String incDelNumber) {

        log4j.info("------------------------1--------------------------------------");
        log4j.info(incDelNumber);
        log4j.info("------------------------2--------------------------------------");

//           log4j.info(httpSession.getAttribute("incDelNumber").toString());
//           httpSession.removeAttribute("incDelNumber");
        IncDel incDel = incDelRepository.findByNumber(incDelNumber);
//        log4j.info("incDel/edit{incDelNumber} - find number :" + incDel.getNumber());
        httpSession.setAttribute("incDelNumber", incDel.getNumber());
        log4j.info("get httpSession.getAttribute(incDelNumber) :" + httpSession.getAttribute("incDelNumber").toString());

        modal.setViewName("redirect:/incDel/registred");
        return modal;
    }

    @GetMapping("incDel/del")
    ModelAndView delIncDel(ModelAndView modal, @RequestParam String incDelNumber) {
        incDelRepository.delete(incDelRepository.findByNumber(incDelNumber));
        log4j.info("incDel/del - was delete succes , number is :" + incDelNumber);
        modal.setViewName("redirect:/incDel/all");
        return modal;
    }


    @PostMapping("incDel/registred")
    ModelAndView registredPOST(ModelAndView modal) {


        modal.setViewName("admin");
        return modal;
    }

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


    @PostMapping("incDel/orderProduct/add")
    ModelAndView addOrderToIncDel(ModelAndView modal, @Valid OrderIncDel orderIncDel, IncDel incDel) {
        int qtyProductQty = 0;
        log4j.info("Start orderProduct/add");
        try {
            incDel = incDelRepository.findByNumber(httpSession.getAttribute("incDelNumber").toString());
            orderIncDel.setIncDelJOIN(incDel);
            double amountOrder = orderIncDel.getPrice() * orderIncDel.getQty();
            orderIncDel.setAmount(amountOrder);

            if (incDel.equals(null) || amountOrder == 0)
                log4j.error("incDel.equals(null) || amount == 0");

            orderIncDelRepository.save(orderIncDel);

            double amountIncDel = 0.0;
            for (OrderIncDel order : orderIncDelRepository.findByIncDelJOIN(incDel)
                    ) {
                qtyProductQty += order.getQty();
                amountIncDel += order.getAmount();
            }
            httpSession.setAttribute("qtyProductQty", qtyProductQty);
            httpSession.setAttribute("amountIncDel", amountIncDel);

            incDel.setAmount(amountIncDel);
            incDelRepository.save(incDel);
            log4j.info("incDel save : " + incDel.getId() + " - " + incDel.getNumber());

            log4j.info("=======================amountIncDel : " + amountIncDel);
            try {
                log4j.info("httpSession qtyProductQty set : " + httpSession.getAttribute("qtyProductQty"));
            } catch (NullPointerException ex) {
                log4j.error("httpSession qtyProductQty set :" + ex.toString());
                ex.printStackTrace();
            }
//            model.addObject("qtyProductQty", qtyProductQty);

            if (qtyProductQty == 0) {
                log4j.error("qtyProductQty = 0 ");
            } else {
                log4j.info("qtyProductQty  : " + qtyProductQty);
            }


        } catch (NullPointerException ne) {
            log4j.warn(" @PostMapping incDel/orderProduct/add : " + ne.toString());
        } catch (Exception ex) {
            log4j.warn(ex.toString());

        }
        modal.addObject("incDel", incDel);
//        model.setViewName("forward:/incDel/registred");
        modal.setViewName("redirect:/incDel/registred");
//        model.setViewName("admin");
        return modal;
    }

    //    <a th:href="@{/order/{id}/details(id=3,action='show_all')}">
//    <a th:href="@{'/incDel/orderProduct/del'(orderId=${order.id})}"
//    /incDel/orderProduct/del?orderId=7
    @GetMapping("/incDel/orderProduct/del")
    ModelAndView delOrderFromIncDel(ModelAndView modal, @RequestParam String orderId) {

        OrderIncDel orderIncDel = orderIncDelRepository.getOne(Long.valueOf(orderId));
        IncDel incDel = incDelRepository.findByNumber(httpSession.getAttribute("incDelNumber").toString());
        double amount = incDel.getAmount() - orderIncDel.getAmount();

        if (amount >= 0) {
            incDel.setAmount(amount);
            incDelRepository.save(incDel);
            log4j.info("incDel.amount set : " + incDel.getAmount());
        } else {
            incDel.setAmount(0);
            log4j.error("@GetMapping(/incDel/orderProduct/del)  - amount less then 0 :" + amount);
        }
        log4j.info("@RequestParam String orderId is :" + orderId);
        orderIncDelRepository.delete(Long.valueOf(orderId));

//        modal.setViewName("redirect:/incDel/registred");
        modal.setViewName("admin");
        return modal;
    }


    @GetMapping("/incDel/succes")
    ModelAndView incDelSucces(ModelAndView modal, @RequestParam String incDelNumber) {
        httpSession.removeAttribute("incDelNumber");
        log4j.info(" http - incDelNumber was removed :" + incDelNumber);
        modal.setViewName("redirect:/incDel/all");
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
//
//
//@GetMapping("/incDel/orderProduct/del")
//ModelAndView delOrderFromIncDel(ModelAndView modal, @RequestParam String orderId) {

    @GetMapping("incDel/all")
    ModelAndView incDelAll(ModelAndView model) {


        double weightNew = 0;
        double weightRepack = 0;
        double weightOnTheWay = 0;
        double weightDamage = 0;

        double amountOrders = 0;
        double weightOrders = 0;

        for (IncDel incDel : incDelRepository.findAll()
                ) {

           String incDelStatus = incDel.getStatus();

          if(null != incDel.getStatus()) {

              if (incDelStatus.equals("new")) {
                  weightNew += incDel.getWeight();
              }
              if (incDelStatus.equals("repacking")) {
                  weightRepack += incDel.getWeight();
              }
              if (incDelStatus.equals("on the way")) {
                  weightOnTheWay += incDel.getWeight();
              }
              if (incDelStatus.equals("damage")) {
                  weightDamage += incDel.getWeight();
              }
          }


                    for (OrderIncDel order : orderIncDelRepository.findAll()
                            ) {
                        amountOrders += order.getAmount();
                    }
//                    log4j.info("incDel each for parametr :" + incDel.getStatus());
//                    log4j.info("reqParam :" + statusIncDel);
                }

        model.addObject("weightNew", weightNew);
        model.addObject("weightRepack", weightRepack);
        model.addObject("weightOnTheWay", weightOnTheWay);
        model.addObject("weightDamage", weightDamage);

        model.addObject("weightOrders", weightOrders);
        model.addObject("incDelsLists", incDelRepository.findAll());
//        model.setViewName("forward:/incDel/dashboard");
        model.setViewName("admin");
        return model;
    }



    @GetMapping("incDel/dashboard")
    ModelAndView incDelDashboard(ModelAndView model,
                                 @RequestParam(name = "statusIncDel") String statusIncDel) {

        double weightNew = 0;
        double weightRepack = 0;
        double weightOnTheWay = 0;
        double weightDamage = 0;

        double amountOrders = 0;
        double weightOrders = 0;

        for (IncDel incDel : incDelRepository.findAll()
                ) {

            String incDelStatus = incDel.getStatus();

            if(incDelStatus.equals("new")){
                weightNew += incDel.getWeight();
            }
            if(incDelStatus.equals("repacking")){
                weightRepack += incDel.getWeight();
            }
            if(incDelStatus.equals("on the way")){
                weightOnTheWay += incDel.getWeight();
            }
            if(incDelStatus.equals("damage")){
                weightDamage += incDel.getWeight();
            }


            for (OrderIncDel order : orderIncDelRepository.findAll()
                    ) {
                amountOrders += order.getAmount();
            }
//                    log4j.info("incDel each for parametr :" + incDel.getStatus());
//                    log4j.info("reqParam :" + statusIncDel);
        }

        model.addObject("weightNew", weightNew);
        model.addObject("weightRepack", weightRepack);
        model.addObject("weightOnTheWay", weightOnTheWay);
        model.addObject("weightDamage", weightDamage);

        model.addObject("weightOrders", weightOrders);



        List<IncDel> incDelsList = new ArrayList<>();
        for (IncDel incDel : incDelRepository.findAll()
                ) {
            try {
                if (statusIncDel.equals(incDel.getStatus())) {
                    incDelsList.add(incDel);
                }
            } catch (NullPointerException e) {
                log4j.error(e.toString());
            }
        }
        model.addObject("incDelsList", incDelsList);
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



    @ModelAttribute("whLists")
    public List<Warehouse> whLists(){
        return  whRepository.findAll();
    }

    @ModelAttribute("amountIncDel")
    public double amountIncDel() {
        try {
            return incDelRepository
                    .findByNumber(httpSession.getAttribute("incDelNumber").toString())
                    .getAmount();

        } catch (NullPointerException ex) {
            log4j.error(" @ModelAttribute('amountIncDel') :" + ex.toString());
            return 0;
        }
    }

    @ModelAttribute("qtyProductQty")
    public int qtyProductQty() {
        try {
            return (int) httpSession.getAttribute("qtyProductQty");
        } catch (NullPointerException ex) {
            return 0;
        }

    }

    @ModelAttribute("httpIncDel")
    public IncDel httpIncDel(IncDel incDel) {
        try {
            return incDelRepository.findByNumber(httpSession.getAttribute("incDelNumber").toString());
        } catch (NullPointerException nex) {
            return new IncDel("incDel not found ");
        }
    }

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





