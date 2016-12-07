package com.warehouse.controller;//package com.warehouse.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//import ua.kiev.prog.model.IncDel;
//import ua.kiev.prog.model.User;
//import ua.kiev.prog.service.*;
//
//import javax.validation.Valid;
//
///**
// * Created by user on 06.10.2016.
// */
//@Controller
//public class IncDelControllerOLD {
//    final static Logger log4j = LoggerFactory.getLogger(IncDelController.class);
//
//    @Autowired
//    LoggerRepository loggerRepository;
//    @Autowired
//    IncDelRepository incDelRepository;
//    @Autowired
//    IncDelService incDelService;
//    @Autowired
//    ParcelRepository parcelRepository;
//    @Autowired
//    BoxRepository boxRepository;
//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    SupplierRepository supplierRepository;
//    @Autowired
//    BoxService boxService;
//
//    //____________________________________________________________________________________________________________________
//    @RequestMapping(value = {"/incDel"}, method = RequestMethod.GET)
//    public ModelAndView showAllIncDel() {
////        User user = (User) authentication.getPrincipal();
//
//        ModelAndView model = new ModelAndView();
//        model.addObject("title", "ALL DELIVERY");
//        model.addObject("incDelList", incDelService.findByPrincipal(getPrincipal()));
//
//        model.addObject("maxValue", boxRepository.count() + (boxRepository.count() * 0.58));
//        model.addObject("value", boxRepository.count());
//        model.addObject("maxValue2", boxRepository.count() + (boxRepository.count() * 1.2));
//        model.addObject("value2", boxRepository.count());
//        model.addObject("maxValue3", boxRepository.count() + (boxRepository.count() * 0.12));
//        model.addObject("value3", boxRepository.count());
//
//        return model;
//    }
//
//
//
//    @RequestMapping(value = {"/incDel/{id}"}, method = RequestMethod.GET)
//    public ModelAndView oneIncDel(@PathVariable("id") long id) {
//
//        IncDel incDel = incDelRepository.findOne(id);
//        ModelAndView model = new ModelAndView();
//        model.addObject("title", "Edit DELIVERY " + incDel.getNumber());
//        model.addObject("listUsers", userRepository.findAll());
//        model.addObject("incDel", incDel);
//
//        model.setViewName("incDelNew");
//        return model;
//    }
//
//    @RequestMapping(value = {"/incDel/{id}"}, method = RequestMethod.POST) // TODO: 10.10.2016 {}
//    public ModelAndView saveIncDel(@Valid IncDel incDel) {
//
//        IncDel incDelToSave = incDel;
//        incDelService.save(incDelToSave);
//
//        ModelAndView model = new ModelAndView();
//        model.addObject("title", "SAVE DELIVERY :" + incDelToSave.getNumber());
//        model.addObject("listUsers", userRepository.findAll());
//        model.addObject("incDel", incDelToSave);
//
//        model.setViewName("incDelNew");
//
//        return model;
//    }
//
//
//    @RequestMapping(value = {"/incDel/new"}, method = RequestMethod.GET)
//    public ModelAndView incDelNew() {
//        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        IncDel incDel = new IncDel();
//   //     incDelService.add(incDel);
//
//        ModelAndView model = new ModelAndView();
//        model.addObject("title", "Registration form new delivery | "+incDel.getId()+" | "+incDel.getNumber());
//        model.addObject("incDel", incDel);
//        model.addObject("listUsers", userRepository.findAll());
//
//
//        User userF = userRepository.findOne(principal.getUserId());
//        if(userF.getTypeUser().equals("client")){
//
//            model.setViewName("incDelNew");
//
//        }else if(userF.getTypeUser().equals("employee")){
//
//            model.setViewName("incDelNew");              // TODO: 18.10.2016 BAG reafactor to employee
//        }
//
//        model.addObject("principalType", userF.getTypeUser());
//
//        ModelAndView modelAndViewForEmploee = new ModelAndView();
//
//        return model;
//    }
//
//
//    @RequestMapping(value = {"/incDel/new"}, method = RequestMethod.POST) // TODO: 10.10.2016 Поменял Model на Model and View -
//    public ModelAndView addBox(/*@Valid */ @ModelAttribute IncDel incDel, BindingResult result, /* ,@RequestParam String incDelID */ ModelAndView model) {
//
//
//
////        incDelService.add(incDel);
////        incDelService.save(incDel);
//
//
//
////        double weight = 0;
////        double volWeight = 0;
////        double cost = 0;
////
////
////        List<Box> boxList = incDelF.getBoxes();
////        if(boxList == null){
////            boxList.add(new Box());
////        }else {
////        }
////        for (Box box:boxList
////                ) {
////            weight+=box.getWeight();
////            volWeight+=box.getVolWeight();
////        }
////
////        incDelF.setWeight(weight);
////        incDelF.setVolWeight(volWeight);
//
//        IncDel incDelF = incDelService.addIncDel(incDel);  // TODO: 17.10.2016 BAG -
//
//
//
//        model.addObject("incDel",incDelF);
//        model.addObject("boxes",incDelF.getBoxes());
//        model.addObject("loggers",loggerRepository.findByIncDelJOIN(incDel));
//
//
//        if(result.hasErrors()) {
//            model.addObject("error", result.getErrorCount());
//        }
//        model.setViewName("incDelNewRegister" );  // TODO: 17.10.2016 REFACTOR
//
//        return model;
//    }
//
//
//
//
//    //-------------------------------------------------------------------------------------------------------------------
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
//}
